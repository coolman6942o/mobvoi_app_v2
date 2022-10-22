package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    private CollectionCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.alibaba.fastjson.JSONArray, T, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t10;
        Type type2 = Object.class;
        Class cls = null;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        } else if (type == JSONArray.class) {
            ?? r82 = (T) new JSONArray();
            defaultJSONParser.parseArray((Collection) r82);
            return r82;
        } else {
            Type type3 = type;
            while (!(type3 instanceof Class)) {
                if (type3 instanceof ParameterizedType) {
                    type3 = ((ParameterizedType) type3).getRawType();
                } else {
                    throw new JSONException("TODO");
                }
            }
            Class cls2 = (Class) type3;
            if (cls2 == AbstractCollection.class || cls2 == Collection.class) {
                t10 = (T) new ArrayList();
            } else if (cls2.isAssignableFrom(HashSet.class)) {
                t10 = (T) new HashSet();
            } else if (cls2.isAssignableFrom(LinkedHashSet.class)) {
                t10 = (T) new LinkedHashSet();
            } else if (cls2.isAssignableFrom(TreeSet.class)) {
                t10 = (T) new TreeSet();
            } else if (cls2.isAssignableFrom(ArrayList.class)) {
                t10 = (T) new ArrayList();
            } else if (cls2.isAssignableFrom(EnumSet.class)) {
                t10 = (T) EnumSet.noneOf(type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : type2);
            } else {
                try {
                    t10 = (T) ((Collection) cls2.newInstance());
                } catch (Exception unused) {
                    throw new JSONException("create instane error, class " + cls2.getName());
                }
            }
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                if (type instanceof Class) {
                    Class cls3 = (Class) type;
                    if (!cls3.getName().startsWith("java.")) {
                        Type genericSuperclass = cls3.getGenericSuperclass();
                        if (genericSuperclass instanceof ParameterizedType) {
                            cls = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                        }
                    }
                }
                if (cls != null) {
                    type2 = cls;
                }
            }
            defaultJSONParser.parseArray(type2, (Collection) t10, obj);
            return t10;
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj != null) {
            Type type2 = null;
            int i10 = serializeWriter.features;
            SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
            int i11 = 0;
            if ((i10 & serializerFeature.mask) != 0 && (type instanceof ParameterizedType)) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Collection collection = (Collection) obj;
            SerialContext serialContext = jSONSerializer.context;
            jSONSerializer.setContext(serialContext, obj, obj2, 0);
            if ((serializeWriter.features & serializerFeature.mask) != 0) {
                if (HashSet.class == collection.getClass()) {
                    serializeWriter.append((CharSequence) "Set");
                } else if (TreeSet.class == collection.getClass()) {
                    serializeWriter.append((CharSequence) "TreeSet");
                }
            }
            try {
                serializeWriter.write(91);
                for (Object obj3 : collection) {
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        serializeWriter.write(44);
                    }
                    if (obj3 == null) {
                        serializeWriter.writeNull();
                    } else {
                        Class<?> cls = obj3.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) obj3).intValue());
                        } else if (cls == Long.class) {
                            serializeWriter.writeLong(((Long) obj3).longValue());
                            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                                serializeWriter.write(76);
                            }
                        } else {
                            jSONSerializer.config.get(cls).write(jSONSerializer, obj3, Integer.valueOf(i12 - 1), type2);
                        }
                    }
                    i11 = i12;
                }
                serializeWriter.write(93);
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
