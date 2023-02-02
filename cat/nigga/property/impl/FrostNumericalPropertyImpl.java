package cat.nigga.property.impl;

import cat.nigga.property.AbstractFrostProperty;

/**
 * A FrostNumericalPropertyImpl represents a property of double type.
 * This class extends the AbstractFrostProperty class and implements methods specific to numerical properties.
 */
public final class FrostNumericalPropertyImpl extends AbstractFrostProperty<Double> {
    // the minimum value that this property can have
    private final double minimum;
    // the maximum value that this property can have
    private final double maximum;
    // the increment by which the value of this property can be increased/decreased
    private final double increment;

    /**
     * Constructs a new FrostNumericalPropertyImpl with the specified name, value, minimum, maximum and increment.
     *
     * @param name      The name of the property.
     * @param value     The value of the property.
     * @param minimum   The minimum value that this property can have.
     * @param maximum   The maximum value that this property can have.
     * @param increment The increment by which the value of this property can be increased/decreased.
     */
    public FrostNumericalPropertyImpl(final String name, final double value, final double minimum, final double maximum, final double increment) {
        super(name, value);
        this.minimum = minimum;
        this.maximum = maximum;
        this.increment = increment;
    }

    /**
     * Overrides the setValue method of AbstractFrostProperty to ensure that the value of this property stays within the specified minimum and maximum values.
     * If the new value is less than the minimum, it is set to the minimum. If it is greater than the maximum, it is set to the maximum.
     *
     * @param value The new value of the property.
     */
    @Override
    public void setValue(Double value) {
        // If the new value is less than the minimum, it is set to the minimum.
        if (value < minimum) value = minimum;
            // If it is greater than the maximum, it is set to the maximum.
        else if (value > maximum) value = maximum;
        // The new value of the property is set.
        super.setValue(value);
    }

    /**
     * Returns the increment value of the property.
     *
     * @return The increment value of the property.
     */
    public double getIncrement() {
        return increment;
    }

    /**
     * Returns the maximum value of the property.
     *
     * @return The maximum value of the property.
     */
    public double getMaximum() {
        return maximum;
    }

    /**
     * Returns the minimum value of the property.
     *
     * @return The minimum value of the property.
     */
    public double getMinimum() {
        return minimum;
    }
}
