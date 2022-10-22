package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
/* loaded from: classes.dex */
public final class ArrayCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ArrayCodec instance = new ArrayCodec();

    private ArrayCodec() {
    }

    private <T> T toObjectArray(DefaultJSONParser defaultJSONParser, Class<?> cls, JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t10 = (T) Array.newInstance(cls, size);
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = jSONArray.get(i10);
            if (obj == jSONArray) {
                Array.set(t10, i10, t10);
            } else {
                if (!cls.isArray()) {
                    obj = TypeUtils.cast(obj, (Class<Object>) cls, defaultJSONParser.config);
                } else if (!cls.isInstance(obj)) {
                    obj = toObjectArray(defaultJSONParser, cls, (JSONArray) obj);
                }
                Array.set(t10, i10, obj);
            }
        }
        jSONArray.setRelatedArray(t10);
        jSONArray.setComponentType(cls);
        return t10;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (type == char[].class) {
            if (i10 == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                return (T) stringVal.toCharArray();
            } else if (i10 != 2) {
                return (T) JSON.toJSONString(defaultJSONParser.parse()).toCharArray();
            } else {
                Number integerValue = jSONLexer.integerValue();
                jSONLexer.nextToken(16);
                return (T) integerValue.toString().toCharArray();
            }
        } else if (i10 == 4) {
            T t10 = (T) jSONLexer.bytesValue();
            jSONLexer.nextToken(16);
            return t10;
        } else {
            Class<?> componentType = ((Class) type).getComponentType();
            JSONArray jSONArray = new JSONArray();
            defaultJSONParser.parseArray(componentType, jSONArray, obj);
            return (T) toObjectArray(defaultJSONParser, componentType, jSONArray);
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Object[] objArr = (Object[]) obj;
        if (obj != null) {
            int length = objArr.length;
            int i10 = length - 1;
            if (i10 == -1) {
                serializeWriter.append((CharSequence) "[]");
                return;
            }
            SerialContext serialContext = jSONSerializer.context;
            int i11 = 0;
            jSONSerializer.setContext(serialContext, obj, obj2, 0);
            try {
                serializeWriter.write(91);
                if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                    jSONSerializer.incrementIndent();
                    jSONSerializer.println();
                    while (i11 < length) {
                        if (i11 != 0) {
                            serializeWriter.write(44);
                            jSONSerializer.println();
                        }
                        jSONSerializer.write(objArr[i11]);
                        i11++;
                    }
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                    serializeWriter.write(93);
                    return;
                }
                Class<?> cls = null;
                ObjectSerializer objectSerializer = null;
                while (i11 < i10) {
                    Object obj3 = objArr[i11];
                    if (obj3 == null) {
                        serializeWriter.append((CharSequence) "null,");
                    } else {
                        IdentityHashMap<Object, SerialContext> identityHashMap = jSONSerializer.references;
                        if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                            Class<?> cls2 = obj3.getClass();
                            if (cls2 == cls) {
                                objectSerializer.write(jSONSerializer, obj3, null, null);
                            } else {
                                objectSerializer = jSONSerializer.config.get(cls2);
                                objectSerializer.write(jSONSerializer, obj3, null, null);
                                cls = cls2;
                            }
                        } else {
                            jSONSerializer.writeReference(obj3);
                        }
                        serializeWriter.write(44);
                    }
                    i11++;
                }
                Object obj4 = objArr[i10];
                if (obj4 == null) {
                    serializeWriter.append((CharSequence) "null]");
                } else {
                    IdentityHashMap<Object, SerialContext> identityHashMap2 = jSONSerializer.references;
                    if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                        jSONSerializer.writeWithFieldName(obj4, Integer.valueOf(i10));
                    } else {
                        jSONSerializer.writeReference(obj4);
                    }
                    serializeWriter.write(93);
                }
            } finally {
                jSONSerializer.context = serialContext;
            }
        } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
            serializeWriter.write("[]");
        } else {
            serializeWriter.writeNull();
        }
    }
}
