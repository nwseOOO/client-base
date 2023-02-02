package cat.nigga.property;

public abstract class AbstractFrostProperty<T> {
    /**
     * The name of the property.
     */
    protected final String name;

    /**
     * The value of the property.
     */
    protected T value;

    /**
     * Constructs a new AbstractFrostProperty with the specified name and value.
     *
     * @param name  The name of the property.
     * @param value The value of the property.
     */
    protected AbstractFrostProperty(final String name, final T value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the value of the property.
     *
     * @return The value of the property.
     */
    protected T getValue() {
        return this.value;
    }

    /**
     * Sets the value of the property.
     *
     * @param value The new value of the property.
     */
    protected void setValue(final T value) {
        this.value = value;
    }
}