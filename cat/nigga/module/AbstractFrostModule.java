package cat.nigga.module;

import cat.nigga.property.AbstractFrostProperty;
import cat.nigga.property.factory.FrostPropertyFactory;

import java.util.List;

public abstract class AbstractFrostModule implements IFrostToggleable {
    protected final String name;
    protected final FrostModuleCategory category;
    protected boolean enabled;
    private final FrostPropertyFactory propertyFactory;

    /**
     * Creates a new instance of the AbstractFrostModule class.
     *
     * @param name     the name of the module
     * @param category the category of the module
     */
    public AbstractFrostModule(final String name, final FrostModuleCategory category) {
        this.name = name;
        this.category = category;
        this.propertyFactory = new FrostPropertyFactory();
    }

    /**
     * Gets the name of the module.
     *
     * @return the name of the module
     */
    public final String getName() {
        return name;
    }

    /**
     * Gets the category of the module.
     *
     * @return the category of the module
     */
    public final FrostModuleCategory getCategory() {
        return category;
    }

    /**
     * Gets the properties of the module.
     *
     * @return the properties of the module
     */
    public final List<AbstractFrostProperty<?>> getProperties() {
        return this.propertyFactory.getProperties();
    }

    /**
     * Adds properties to the module.
     *
     * @param properties the properties to add to the module
     */
    public final void addProperties(final AbstractFrostProperty<?>... properties) {
        this.propertyFactory.createProperties(properties);
    }

    /**
     * Enables the module.
     */
    @Override
    public final void onEnable() {
        this.enabled = true;
    }

    /**
     * Disables the module.
     */
    @Override
    public final void onDisable() {
        this.enabled = false;
    }

    /**
     * Sets the state of the module.
     *
     * @param state the state to set the module to
     */
    @Override
    public void setEnabled(final boolean state) {
        this.enabled = state;
        if (this.enabled) onEnable();
        else onDisable();
    }

    /**
     * Changes the state of the module.
     */
    public final void toggle() {
        setEnabled(!isEnabled());
    }

    /**
     * Returns whether the module is currently enabled.
     *
     * @return whether the module is currently enabled
     */
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
