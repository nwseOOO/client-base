package cat.nigga.property.factory;

import cat.nigga.property.AbstractFrostProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class FrostPropertyFactory {
    private final List<AbstractFrostProperty<?>> properties;

    public FrostPropertyFactory() {
        this.properties = new ArrayList<>();
    }

    /**
     * Creates properties and adds them to the properties list.
     *
     * @param properties The properties to be created.
     * @throws IllegalArgumentException If the properties parameter is null or empty.
     */
    public final void createProperties(final AbstractFrostProperty<?>... properties) {
        if (properties == null || properties.length == 0) {
            throw new IllegalArgumentException("Properties cannot be null or empty.");
        }
        this.properties.addAll(Arrays.asList(properties));
    }

    /**
     * Returns an unmodifiable list of the properties.
     *
     * @return An unmodifiable list of the properties.
     */
    public final List<AbstractFrostProperty<?>> getProperties() {
        return Collections.unmodifiableList(this.properties);
    }
}