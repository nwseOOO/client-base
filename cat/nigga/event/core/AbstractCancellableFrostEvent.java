package cat.nigga.event.core;

public abstract class AbstractCancellableFrostEvent {

    // A flag that indicates whether the event is cancelled or not.
    protected boolean cancelled;

    // Constructor that initializes the cancelled flag to false.
    protected AbstractCancellableFrostEvent() {
        this.cancelled = false;
    }

    // A method that sets the cancelled flag to true.
    public final void setCancelled() {
        this.cancelled = true;
    }
}
