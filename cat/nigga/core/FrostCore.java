package cat.nigga.core;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * The FrostCore class is the main component of the Frost framework. It stores
 * services that can be accessed by different parts of the client.
 */
public final class FrostCore {
    private static FrostCore instance;

    private final ClassToInstanceMap<Object> services;

    /**
     * Private constructor for the FrostCore class. It is called by the builder
     * when creating an instance of the class.
     *
     * @param builder The builder used to create the FrostCore instance.
     */
    private FrostCore(final Builder builder) {
        if (instance != null) {
            throw new IllegalStateException("There is already an existing instance of Frost.");
        }
        instance = this;
        this.services = builder.services;
    }

    /**
     * Returns the single instance of the FrostCore class. If no instance exists,
     * an exception is thrown.
     *
     * @return The single instance of the FrostCore class.
     */
    public static FrostCore getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Frost is not initialized.");
        }
        return instance;
    }

    /**
     * Returns a service stored in the services map that corresponds to the specified class.
     *
     * @param clazz The class of the service to be retrieved.
     * @return The service object that corresponds to the specified class.
     */
    public final <T> T getService(final Class<T> clazz) {
        return this.services.getInstance(clazz);
    }

    /**
     * The builder class for the FrostCore class. It provides a convenient way
     * to create an instance of the FrostCore class.
     */
    public static final class Builder {
        private final ClassToInstanceMap<Object> services;

        /**
         * Constructor for the builder class. Initializes the services map.
         */
        public Builder() {
            this.services = MutableClassToInstanceMap.create();
        }

        /**
         * Adds a service to the services map.
         *
         * @param service The service to be added to the services map.
         * @return The builder instance, for chaining method calls.
         */
        public final Builder addService(final Object service) {
            this.services.putInstance((Class<Object>) service.getClass(), service);
            return this;
        }

        /**
         * Builds the FrostCore instance.
         *
         * @return The FrostCore instance.
         */
        public final FrostCore build() {
            return new FrostCore(this);
        }
    }
}
