package cat.nigga.event.bus.subscription;

import cat.nigga.event.bus.IFrostEventListener;
import cat.nigga.event.core.IFrostEvent;

/**
 * This class represents an immutable subscription of an event listener to an event.
 *
 * The event listener is associated with an object.
 */
public final class FrostImmutableSubscription {
    private final Object object;
    private final IFrostEventListener<IFrostEvent> listener;

    /**
     * Constructs a new instance of the subscription with the given object and event listener.
     *
     * @param object the object associated with the event listener
     * @param listener the event listener that listens to events of type IFrostEvent
     */
    public FrostImmutableSubscription(final Object object, final IFrostEventListener<IFrostEvent> listener) {
        this.object = object;
        this.listener = listener;
    }

    /**
     * Returns the object associated with the event listener.
     *
     * @return the object associated with the event listener
     */
    public final Object getObject() {
        return object;
    }

    /**
     * Returns the event listener that listens to events of type IFrostEvent.
     *
     * @return the event listener that listens to events of type IFrostEvent
     */
    public final IFrostEventListener<IFrostEvent> getListener() {
        return listener;
    }
}
