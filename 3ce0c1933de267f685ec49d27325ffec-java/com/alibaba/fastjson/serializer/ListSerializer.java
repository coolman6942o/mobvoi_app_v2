package com.alibaba.fastjson.serializer;

import com.mobvoi.wear.lpa.LpaConstants;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class ListSerializer implements ObjectSerializer {
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i10 = 1;
        boolean z10 = (serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0;
        Type type2 = null;
        if (z10 && (type instanceof ParameterizedType)) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        if (obj != null) {
            List list = (List) obj;
            int size = list.size();
            if (size == 0) {
                serializeWriter.append((CharSequence) "[]");
                return;
            }
            SerialContext serialContext = jSONSerializer.context;
            if ((serializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
                jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0);
                if (jSONSerializer.references == null) {
                    jSONSerializer.references = new IdentityHashMap<>();
                }
                jSONSerializer.references.put(obj, serialContext);
            }
            try {
                if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                    serializeWriter.write(91);
                    jSONSerializer.incrementIndent();
                    for (int i11 = 0; i11 < size; i11++) {
                        Object obj3 = list.get(i11);
                        if (i11 != 0) {
                            serializeWriter.write(44);
                        }
                        jSONSerializer.println();
                        if (obj3 != null) {
                            IdentityHashMap<Object, SerialContext> identityHashMap = jSONSerializer.references;
                            if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                                ObjectSerializer objectSerializer = jSONSerializer.config.get(obj3.getClass());
                                jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0);
                                objectSerializer.write(jSONSerializer, obj3, Integer.valueOf(i11), type2);
                            } else {
                                jSONSerializer.writeReference(obj3);
                            }
                        } else {
                            jSONSerializer.out.writeNull();
                        }
                    }
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                    serializeWriter.write(93);
                    return;
                }
                int i12 = serializeWriter.count + 1;
                if (i12 > serializeWriter.buf.length) {
                    if (serializeWriter.writer == null) {
                        serializeWriter.expandCapacity(i12);
                    } else {
                        serializeWriter.flush();
                        i12 = 1;
                    }
                }
                serializeWriter.buf[serializeWriter.count] = '[';
                serializeWriter.count = i12;
                for (int i13 = 0; i13 < list.size(); i13++) {
                    Object obj4 = list.get(i13);
                    if (i13 != 0) {
                        int i14 = serializeWriter.count + 1;
                        if (i14 > serializeWriter.buf.length) {
                            if (serializeWriter.writer == null) {
                                serializeWriter.expandCapacity(i14);
                            } else {
                                serializeWriter.flush();
                                i14 = 1;
                            }
                        }
                        serializeWriter.buf[serializeWriter.count] = ',';
                        serializeWriter.count = i14;
                    }
                    if (obj4 == null) {
                        serializeWriter.append((CharSequence) LpaConstants.VALUE_NULL);
                    } else {
                        Class<?> cls = obj4.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) obj4).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) obj4).longValue();
                            if (z10) {
                                serializeWriter.writeLong(longValue);
                                serializeWriter.write(76);
                            } else {
                                serializeWriter.writeLong(longValue);
                            }
                        } else if (cls == String.class) {
                            String str = (String) obj4;
                            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                serializeWriter.writeStringWithSingleQuote(str);
                            } else {
                                serializeWriter.writeStringWithDoubleQuote(str, (char) 0, true);
                            }
                        } else {
                            if ((serializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
                                jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0);
                            }
                            IdentityHashMap<Object, SerialContext> identityHashMap2 = jSONSerializer.references;
                            if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                                jSONSerializer.config.get(obj4.getClass()).write(jSONSerializer, obj4, Integer.valueOf(i13), type2);
                            } else {
                                jSONSerializer.writeReference(obj4);
                            }
                        }
                    }
                }
                int i15 = serializeWriter.count + 1;
                if (i15 > serializeWriter.buf.length) {
                    if (serializeWriter.writer == null) {
                        serializeWriter.expandCapacity(i15);
                    } else {
                        serializeWriter.flush();
                        serializeWriter.buf[serializeWriter.count] = ']';
                        serializeWriter.count = i10;
                    }
                }
                i10 = i15;
                serializeWriter.buf[serializeWriter.count] = ']';
                serializeWriter.count = i10;
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
