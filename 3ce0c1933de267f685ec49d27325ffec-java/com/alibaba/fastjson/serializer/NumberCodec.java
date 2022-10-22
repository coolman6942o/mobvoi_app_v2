package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class NumberCodec implements ObjectSerializer, ObjectDeserializer {
    public static final NumberCodec instance = new NumberCodec();
    private DecimalFormat decimalFormat;

    private NumberCodec() {
        this.decimalFormat = null;
    }

    /* JADX WARN: Type inference failed for: r8v16, types: [java.math.BigDecimal, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString));
            } else if (type == Float.TYPE || type == Float.class) {
                String numberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Float.valueOf(Float.parseFloat(numberString2));
            } else {
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken(16);
                if (type == Short.TYPE || type == Short.class) {
                    return (T) Short.valueOf((short) longValue);
                }
                if (type == Byte.TYPE || type == Byte.class) {
                    return (T) Byte.valueOf((byte) longValue);
                }
                if (longValue < -2147483648L || longValue > 2147483647L) {
                    return (T) Long.valueOf(longValue);
                }
                return (T) Integer.valueOf((int) longValue);
            }
        } else if (i10 != 3) {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                return (T) TypeUtils.castToDouble(parse);
            }
            if (type == Float.TYPE || type == Float.class) {
                return (T) TypeUtils.castToFloat(parse);
            }
            if (type == Short.TYPE || type == Short.class) {
                return (T) TypeUtils.castToShort(parse);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return (T) TypeUtils.castToByte(parse);
            }
            return (T) TypeUtils.castToBigDecimal(parse);
        } else if (type == Double.TYPE || type == Double.class) {
            String numberString3 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString3));
        } else if (type == Float.TYPE || type == Float.class) {
            String numberString4 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Float.valueOf(Float.parseFloat(numberString4));
        } else {
            ?? r82 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                return (T) Short.valueOf(r82.shortValue());
            }
            return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r82.byteValue()) : r82;
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
            } else {
                serializeWriter.writeNull();
            }
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (Float.isNaN(floatValue)) {
                serializeWriter.writeNull();
            } else if (Float.isInfinite(floatValue)) {
                serializeWriter.writeNull();
            } else {
                String f10 = Float.toString(floatValue);
                if (f10.endsWith(".0")) {
                    f10 = f10.substring(0, f10.length() - 2);
                }
                serializeWriter.write(f10);
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                    serializeWriter.write(70);
                }
            }
        } else {
            double doubleValue = ((Double) obj).doubleValue();
            if (Double.isNaN(doubleValue)) {
                serializeWriter.writeNull();
            } else if (Double.isInfinite(doubleValue)) {
                serializeWriter.writeNull();
            } else {
                DecimalFormat decimalFormat = this.decimalFormat;
                if (decimalFormat == null) {
                    str = Double.toString(doubleValue);
                    if (str.endsWith(".0")) {
                        str = str.substring(0, str.length() - 2);
                    }
                } else {
                    str = decimalFormat.format(doubleValue);
                }
                serializeWriter.append((CharSequence) str);
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                    serializeWriter.write(68);
                }
            }
        }
    }

    public NumberCodec(DecimalFormat decimalFormat) {
        this.decimalFormat = null;
        this.decimalFormat = decimalFormat;
    }

    public NumberCodec(String str) {
        this(new DecimalFormat(str));
    }
}
