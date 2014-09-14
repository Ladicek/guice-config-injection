package cz.ladicek.guiceConfigInjection;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.google.inject.spi.TypeConverter;

import javax.inject.Named;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class PropertiesModule extends AbstractModule {
    private final Properties config;

    public PropertiesModule(Properties config) {
        this.config = config;
    }

    @Override
    protected void configure() {
        configureTypeConversions();
        configureFallbackToOptionalAbsent();

        Names.bindProperties(binder(), config);
    }

    private void configureTypeConversions() {
        convertToTypes(matcherForOptional(Boolean.class), new OptionalPrimitiveTypeConverter(Boolean.class));
        convertToTypes(matcherForOptional(Byte.class), new OptionalPrimitiveTypeConverter(Byte.class));
        convertToTypes(matcherForOptional(Short.class), new OptionalPrimitiveTypeConverter(Short.class));
        convertToTypes(matcherForOptional(Integer.class), new OptionalPrimitiveTypeConverter(Integer.class));
        convertToTypes(matcherForOptional(Long.class), new OptionalPrimitiveTypeConverter(Long.class));
        convertToTypes(matcherForOptional(Float.class), new OptionalPrimitiveTypeConverter(Float.class));
        convertToTypes(matcherForOptional(Double.class), new OptionalPrimitiveTypeConverter(Double.class));
        convertToTypes(matcherForOptional(Character.class), new OptionalCharacterConverter());
        convertToTypes(matcherForOptional(String.class), new OptionalStringConverter());
    }

    private void configureFallbackToOptionalAbsent() {
        fallbackToOptionalAbsent(Boolean.class);
        fallbackToOptionalAbsent(Byte.class);
        fallbackToOptionalAbsent(Short.class);
        fallbackToOptionalAbsent(Integer.class);
        fallbackToOptionalAbsent(Long.class);
        fallbackToOptionalAbsent(Float.class);
        fallbackToOptionalAbsent(Double.class);
        fallbackToOptionalAbsent(Character.class);
        fallbackToOptionalAbsent(String.class);
    }

    /** This doesn't create the required {@link TypeLiteral}, it must be present in {@link #OPTIONAL_TYPE_LITERALS}! */
    private void fallbackToOptionalAbsent(Class<?> clazz) {
        @SuppressWarnings("unchecked")
        TypeLiteral<Optional<?>> typeLiteral = (TypeLiteral<Optional<?>>) OPTIONAL_TYPE_LITERALS.get(clazz);

        bind(typeLiteral).annotatedWith(Named.class).toInstance(Optional.absent());
    }

    /** This doesn't create the required {@link TypeLiteral}, it must be present in {@link #OPTIONAL_TYPE_LITERALS}! */
    private static Matcher<? super TypeLiteral<?>> matcherForOptional(Class<?> clazz) {
        return Matchers.only(OPTIONAL_TYPE_LITERALS.get(clazz));
    }

    private static final ImmutableMap<Class<?>, TypeLiteral<?>> OPTIONAL_TYPE_LITERALS
            = ImmutableMap.<Class<?>, TypeLiteral<?>>builder()
            .put(Boolean.class, new TypeLiteral<Optional<Boolean>>() {})
            .put(Byte.class, new TypeLiteral<Optional<Byte>>() {})
            .put(Short.class, new TypeLiteral<Optional<Short>>() {})
            .put(Integer.class, new TypeLiteral<Optional<Integer>>() {})
            .put(Long.class, new TypeLiteral<Optional<Long>>() {})
            .put(Float.class, new TypeLiteral<Optional<Float>>() {})
            .put(Double.class, new TypeLiteral<Optional<Double>>() {})
            .put(Character.class, new TypeLiteral<Optional<Character>>() {})
            .put(String.class, new TypeLiteral<Optional<String>>() {})
            .build();

    /**
     * Suitable for all primitive type wrappers except of {@code Character}, which doesn't expose
     * a {@code public static valueOf(String)} factory method.
     */
    private static final class OptionalPrimitiveTypeConverter implements TypeConverter {
        private final Method parser;

        private OptionalPrimitiveTypeConverter(Class<?> clazz) {
            try {
                this.parser = clazz.getMethod("valueOf", String.class);
            } catch (NoSuchMethodException e) {
                throw new AssertionError(e);
            }
        }

        @Override
        public Object convert(String value, TypeLiteral<?> toType) {
            try {
                return Optional.of(parser.invoke(null, value));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final class OptionalCharacterConverter implements TypeConverter {
        @Override
        public Object convert(String value, TypeLiteral<?> toType) {
            if (value.length() != 1) {
                throw new RuntimeException("Length != 1.");
            }
            return Optional.of(value.charAt(0));
        }
    }

    private static final class OptionalStringConverter implements TypeConverter {
        @Override
        public Object convert(String value, TypeLiteral<?> toType) {
            return Optional.of(value);
        }
    }
}
