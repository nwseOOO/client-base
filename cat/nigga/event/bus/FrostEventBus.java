package cat.nigga.event.bus;

import cat.nigga.event.bus.subscription.FrostImmutableSubscription;
import cat.nigga.event.core.IFrostEvent;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * The main class of the Frost Event Bus. Implements the {@link IFrostEventBus} interface
 * and is responsible for registering, unregistering, and emitting events.
 */
public final class FrostEventBus implements IFrostEventBus {
    /**
     * A map containing all the subscriptions, where the key is the type of the event
     * and the value is a set of subscribers (implementations of {@link IFrostEventListener})
     * that subscribed to that type of event.
     */
    private final Map<Type, Set<FrostImmutableSubscription>> subscriptionCache;

    /**
     * Constructs a new instance of the FrostEventBus and initializes the
     * subscription cache as a new {@link HashMap}.
     */
    FrostEventBus() {
        this.subscriptionCache = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void register(final Object object) {
        /**
         * Loop over all declared fields in the passed object and check if they
         * implement the {@link IFrostEventListener} interface. If they do, add
         * the subscriber to the subscription cache.
         */
        for (final Field field : object.getClass().getDeclaredFields()) {
            try {
                if (field.getType() == IFrostEventListener.class) {
                    // Set the field as accessible
                    field.setAccessible(true);

                    // Get the type of event the subscriber is interested in
                    final Type type = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];

                    // Add the subscriber to the cache, creating a new set if necessary
                    this.subscriptionCache.computeIfAbsent(type, subscribers -> new HashSet<>())
                            .add(new FrostImmutableSubscription(object, (IFrostEventListener<IFrostEvent>) field.get(object)));
                }
            } catch (final Exception exception) {
                // Print the stack trace of any exceptions that occur
                exception.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void unregister(final Object object) {
        /**
         * Loop over all sets of subscribers in the cache and remove any that belong
         * to the passed object.
         */
        this.subscriptionCache.values().forEach(subscribe -> subscribe.removeIf(subscriber -> subscriber.getObject().equals(object)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void emit(final IFrostEvent event) {
        // Check if the event has any subscribers
        if (this.subscriptionCache.get(event.getClass()) != null) {
            // Invoke the event listener for each subscriber of this event type
            this.subscriptionCache.get(event.getClass()).forEach(subscriber -> subscriber.getListener().invoke(event));
        }
    }
}