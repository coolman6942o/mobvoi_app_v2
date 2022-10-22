package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    private IntegerCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t10;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i10 == 2) {
            if (type == Long.TYPE || type == Long.class) {
                t10 = (T) Long.valueOf(jSONLexer.longValue());
            } else {
                try {
                    t10 = (T) Integer.valueOf(jSONLexer.intValue());
                } catch (NumberFormatException e10) {
                    throw new JSONException("int value overflow, field : " + obj, e10);
                }
            }
            jSONLexer.nextToken(16);
            return t10;
        } else if (i10 == 3) {
            BigDecimal decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type == Long.TYPE || type == Long.class) {
                return (T) Long.valueOf(decimalValue.longValue());
            }
            return (T) Integer.valueOf(decimalValue.intValue());
        } else {
            T t11 = (T) defaultJSONParser.parse();
            try {
                if (!(type == Long.TYPE || type == Long.class)) {
                    t11 = (T) TypeUtils.castToInt(t11);
                    return t11;
                }
                t11 = (T) TypeUtils.castToLong(t11);
                return t11;
            } catch (Exception e11) {
                throw new JSONException("cast error, field : " + obj + ", value " + t11, e11);
            }
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number != null) {
            if (obj instanceof Long) {
                serializeWriter.writeLong(number.longValue());
            } else {
                serializeWriter.writeInt(number.intValue());
            }
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                Class<?> cls = number.getClass();
                if (cls == Byte.class) {
                    serializeWriter.write(66);
                } else if (cls == Short.class) {
                    serializeWriter.write(83);
                } else if (cls == Long.class) {
                    long longValue = number.longValue();
                    if (longValue <= 2147483647L && longValue >= -2147483648L && type != Long.class) {
                        serializeWriter.write(76);
                    }
                }
            }
        } else if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
            serializeWriter.write(48);
        } else {
            serializeWriter.writeNull();
        }
    }
}
