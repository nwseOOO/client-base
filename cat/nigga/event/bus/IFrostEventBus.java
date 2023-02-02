package cat.nigga.event.bus;

import cat.nigga.event.core.IFrostEvent;

/**
 * This interface defines the basic functionality
 * of the event bus: registering subscribers, unregistering subscribers, and emitting events.
 */
public interface IFrostEventBus {

    /**
     * Registers a new subscriber.
     *
     * @param object The subscriber object to be registered.
     */
    void register(final Object object);

    /**
     * Unregisters an existing subscriber.
     *
     * @param object The subscriber object to be unregistered.
     */
    void unregister(final Object object);

    /**
     * Emits an event, causing all subscribers interested in that event to be notified.
     *
     * @param event The event to be emitted.
     */
    void emit(final IFrostEvent event);

    /**
     * @return A new instance of the standard FrostEventBus.
     */
    static IFrostEventBus standard() {
        return new FrostEventBus();
    }
}