package cz.ladicek.guiceConfigInjection;

import com.google.common.base.Optional;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ConfigInjectionTest {
    private Config config;

    @Before
    public void setUpConfig() throws IOException {
        Injector injector = Main.injector();
        config = injector.getInstance(Config.class);
    }

    @Test
    public void test() {
        assertEquals("aString", "foo", config.aString);
        assertEquals("aOptionalString", Optional.of("foo"), config.aOptionalString);
        assertEquals("aStringWithDefault", "foo", config.aStringWithDefault);
        assertEquals("aOptionalStringWithDefault", Optional.of("foo"), config.aOptionalStringWithDefault);
        assertEquals("bChar", 'x', config.bChar);
        assertEquals("bCharObj", new Character('x'), config.bCharObj);
        assertEquals("bOptionalChar", Optional.of('x'), config.bOptionalChar);
        assertEquals("bString", "x", config.bString);
        assertEquals("bOptionalString", Optional.of("x"), config.bOptionalString);
        assertEquals("cByte", (byte) 1, config.cByte);
        assertEquals("cByteObj", new Byte((byte) 1), config.cByteObj);
        assertEquals("cOptionalByte", Optional.of((byte) 1), config.cOptionalByte);
        assertEquals("cShort", (short) 1, config.cShort);
        assertEquals("cShortObj", new Short((short) 1), config.cShortObj);
        assertEquals("cOptionalShort", Optional.of((short) 1), config.cOptionalShort);
        assertEquals("cInt", 1, config.cInt);
        assertEquals("cIntObj", new Integer(1), config.cIntObj);
        assertEquals("cOptionalInt", Optional.of(1), config.cOptionalInt);
        assertEquals("cLong", 1L, config.cLong);
        assertEquals("cLongObj", new Long(1L), config.cLongObj);
        assertEquals("cOptionalLong", Optional.of(1L), config.cOptionalLong);
        assertEquals("cFloat", 1.0F, config.cFloat, 0.01);
        assertEquals("cFloatObj", new Float(1.0F), config.cFloatObj);
        assertEquals("cOptionalFloat", Optional.of(1.0F), config.cOptionalFloat);
        assertEquals("cDouble", 1.0, config.cDouble, 0.01);
        assertEquals("cDoubleObj", new Double(1.0), config.cDoubleObj);
        assertEquals("cOptionalDouble", Optional.of(1.0), config.cOptionalDouble);
        assertEquals("cString", "1", config.cString);
        assertEquals("cOptionalString", Optional.of("1"), config.cOptionalString);
        assertEquals("dFloat", 1.0F, config.dFloat, 0.01);
        assertEquals("dFloatObj", new Float(1.0F), config.dFloatObj);
        assertEquals("dOptionalFloat", Optional.of(1.0F), config.dOptionalFloat);
        assertEquals("dDouble", 1.0, config.dDouble, 0.01);
        assertEquals("dDoubleObj", new Double(1.0), config.dDoubleObj);
        assertEquals("dOptionalDouble", Optional.of(1.0), config.dOptionalDouble);
        assertEquals("dString", "1.0", config.dString);
        assertEquals("dOptionalString", Optional.of("1.0"), config.dOptionalString);
        assertEquals("eBoolean", true, config.eBoolean);
        assertEquals("eBooleanObj", Boolean.TRUE, config.eBooleanObj);
        assertEquals("eOptionalBoolean", Optional.of(Boolean.TRUE), config.eOptionalBoolean);
        assertEquals("eString", "true", config.eString);
        assertEquals("eOptionalString", Optional.of("true"), config.eOptionalString);

        assertEquals("yOptionalBoolean", Optional.<Boolean>absent(), config.yOptionalBoolean);
        assertEquals("yOptionalByte", Optional.<Byte>absent(), config.yOptionalByte);
        assertEquals("yOptionalShort", Optional.<Short>absent(), config.yOptionalShort);
        assertEquals("yOptionalInteger", Optional.<Integer>absent(), config.yOptionalInteger);
        assertEquals("yOptionalLong", Optional.<Long>absent(), config.yOptionalLong);
        assertEquals("yOptionalFloat", Optional.<Float>absent(), config.yOptionalFloat);
        assertEquals("yOptionalDouble", Optional.<Double>absent(), config.yOptionalDouble);
        assertEquals("yOptionalCharacter", Optional.<Character>absent(), config.yOptionalCharacter);
        assertEquals("yOptionalString", Optional.<String>absent(), config.yOptionalString);

        assertEquals("zStringWithDefault", "z", config.zStringWithDefault);
        assertEquals("zOptionalStringWithDefault", Optional.of("z"), config.zOptionalStringWithDefault);
    }
}
