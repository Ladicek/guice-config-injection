package cz.ladicek.guiceConfigInjection;

import com.google.common.base.Optional;

import javax.inject.Inject;
import javax.inject.Named;

public class Config {
    @Inject @Named("a") public String aString;
    @Inject @Named("a") public Optional<String> aOptionalString;
    @Inject @Named("a") public String aStringWithDefault = "a";
    @Inject @Named("a") public Optional<String> aOptionalStringWithDefault = Optional.of("a");
    @Inject @Named("b") public char bChar;
    @Inject @Named("b") public Character bCharObj;
    @Inject @Named("b") public Optional<Character> bOptionalChar;
    @Inject @Named("b") public String bString;
    @Inject @Named("b") public Optional<String> bOptionalString;
    @Inject @Named("c") public byte cByte;
    @Inject @Named("c") public Byte cByteObj;
    @Inject @Named("c") public Optional<Byte> cOptionalByte;
    @Inject @Named("c") public short cShort;
    @Inject @Named("c") public Short cShortObj;
    @Inject @Named("c") public Optional<Short> cOptionalShort;
    @Inject @Named("c") public int cInt;
    @Inject @Named("c") public Integer cIntObj;
    @Inject @Named("c") public Optional<Integer> cOptionalInt;
    @Inject @Named("c") public long cLong;
    @Inject @Named("c") public Long cLongObj;
    @Inject @Named("c") public Optional<Long> cOptionalLong;
    @Inject @Named("c") public float cFloat;
    @Inject @Named("c") public Float cFloatObj;
    @Inject @Named("c") public Optional<Float> cOptionalFloat;
    @Inject @Named("c") public double cDouble;
    @Inject @Named("c") public Double cDoubleObj;
    @Inject @Named("c") public Optional<Double> cOptionalDouble;
    @Inject @Named("c") public String cString;
    @Inject @Named("c") public Optional<String> cOptionalString;
    @Inject @Named("d") public float dFloat;
    @Inject @Named("d") public Float dFloatObj;
    @Inject @Named("d") public Optional<Float> dOptionalFloat;
    @Inject @Named("d") public double dDouble;
    @Inject @Named("d") public Double dDoubleObj;
    @Inject @Named("d") public Optional<Double> dOptionalDouble;
    @Inject @Named("d") public String dString;
    @Inject @Named("d") public Optional<String> dOptionalString;
    @Inject @Named("e") public boolean eBoolean;
    @Inject @Named("e") public Boolean eBooleanObj;
    @Inject @Named("e") public Optional<Boolean> eOptionalBoolean;
    @Inject @Named("e") public String eString;
    @Inject @Named("e") public Optional<String> eOptionalString;

    @Inject @Named("y") public Optional<Boolean> yOptionalBoolean;
    @Inject @Named("y") public Optional<Byte> yOptionalByte;
    @Inject @Named("y") public Optional<Short> yOptionalShort;
    @Inject @Named("y") public Optional<Integer> yOptionalInteger;
    @Inject @Named("y") public Optional<Long> yOptionalLong;
    @Inject @Named("y") public Optional<Float> yOptionalFloat;
    @Inject @Named("y") public Optional<Double> yOptionalDouble;
    @Inject @Named("y") public Optional<Character> yOptionalCharacter;
    @Inject @Named("y") public Optional<String> yOptionalString;

    @Inject @Named("z") public String zStringWithDefault = "z";
    @Inject @Named("z") public Optional<String> zOptionalStringWithDefault = Optional.of("z");
}
