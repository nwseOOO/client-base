package cat.nigga.module;

//This is the interface for a module that can be toggled on and off.
//It has methods for handling the enabling and disabling of the module and for checking its current state.
public interface IFrostToggleable {
    //This method is called when the module is enabled.
    void onEnable();

    //This method is called when the module is disabled.
    void onDisable();

    //This method sets the state of the module to either enabled or disabled.
    void setEnabled(final boolean state);

    //This method returns the current state of the module, whether it is enabled or disabled.
    boolean isEnabled();
}