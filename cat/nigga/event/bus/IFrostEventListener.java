package cat.nigga.event.bus;

import cat.nigga.event.core.IFrostEvent;

/**
 * A functional interface that is used to listen to events.
 * Implement this interface to create a listener for events.
 *
 * @param <T>
 */
@FunctionalInterface
public interface IFrostEventListener<T extends IFrostEvent> {
    /**
     * This method is called when an event is emitted.
     *
     * @param event The event that was emitted.
     */
    void invoke(final T event);
}
