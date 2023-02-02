package cat.nigga.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible for managing a list of {@link AbstractFrostModule}s.
 * It provides a builder pattern to add modules to the list.
 */
public final class FrostModuleRepository {

    private final List<AbstractFrostModule> modules;

    /**
     * The constructor initializes the list of modules with the one provided by the builder.
     *
     * @param builder The builder object that provides the list of modules to initialize the repository with.
     */
    private FrostModuleRepository(final Builder builder) {
        this.modules = builder.modules;
    }

    /**
     * Returns the list of modules.
     *
     * @return A list of {@link AbstractFrostModule}s.
     */
    public final List<AbstractFrostModule> getModules() {
        return modules;
    }

    /**
     * This nested class provides a builder pattern for the FrostModuleRepository class.
     */
    public static final class Builder {
        private final List<AbstractFrostModule> modules;

        /**
         * The constructor initializes an empty list of modules.
         */
        public Builder() {
            this.modules = new ArrayList<>();
        }

        /**
         * Adds a module to the list.
         *
         * @param modules The modules to add to the list.
         * @return The builder object, for chaining.
         */
        public final Builder addModules(final AbstractFrostModule... modules) {
            this.modules.addAll(Arrays.asList(modules));
            return this;
        }

        /**
         * Builds a new FrostModuleRepository object using the list of modules that have been added to the builder.
         *
         * @return A new FrostModuleRepository object.
         */
        public final FrostModuleRepository build() {
            return new FrostModuleRepository(this);
        }
    }
}
