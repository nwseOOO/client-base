package cat.nigga.property.impl;

import cat.nigga.property.AbstractFrostProperty;

/**
 * A FrostEnumPropertyImpl represents a property with values from an enumerated type.
 * This class extends the AbstractFrostProperty class and implements methods specific to enumerated properties.
 *
 * @param <T> The type of enumerated values for this property.
 */
public final class FrostEnumPropertyImpl<T extends Enum<T>> extends AbstractFrostProperty<T> {
    // an array of the enumerated values for this property
    private final T[] values;

    /**
     * Constructs a new FrostEnumPropertyImpl with the specified name and value.
     *
     * @param name  The name of the property.
     * @param value The value of the property.
     */
    public FrostEnumPropertyImpl(final String name, T value) {
        super(name, value);
        // the enumerated values for this property are retrieved using the value's class.
        this.values = (T[]) this.value.getClass().getEnumConstants();
    }

    /**
     * Overrides the getValue method of AbstractFrostProperty to return the value of this property.
     *
     * @return The value of this property.
     */
    @Override
    public T getValue() {
        return (T) this.value;
    }

    /**
     * Returns the enumerated values of this property.
     *
     * @return The enumerated values of this property.
     */
    public T[] getValues() {
        return values;
    }

    /**
     * Sets the value of this property based on the given index in the values array.
     *
     * @param index The index of the value to set.
     */
    public void setValue(int index) {
        // the value is set by calling the setValue method of the superclass with the value at the specified index.
        super.setValue(this.values[index]);
    }
}
