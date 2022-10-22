package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;
/* loaded from: classes.dex */
public final class FieldSerializer implements Comparable<FieldSerializer> {
    protected final int features;
    public final FieldInfo fieldInfo;
    protected final String format;
    protected char[] name_chars;
    private RuntimeSerializerInfo runtimeInfo;
    protected final boolean writeNull;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RuntimeSerializerInfo {
        ObjectSerializer fieldSerializer;
        Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    public FieldSerializer(FieldInfo fieldInfo) {
        boolean z10;
        this.fieldInfo = fieldInfo;
        JSONField annotation = fieldInfo.getAnnotation();
        String str = null;
        if (annotation != null) {
            z10 = false;
            for (SerializerFeature serializerFeature : annotation.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteMapNullValue) {
                    z10 = true;
                }
            }
            String trim = annotation.format().trim();
            str = trim.length() != 0 ? trim : str;
            this.features = SerializerFeature.of(annotation.serialzeFeatures());
        } else {
            this.features = 0;
            z10 = false;
        }
        this.writeNull = z10;
        this.format = str;
        String str2 = fieldInfo.name;
        int length = str2.length();
        this.name_chars = new char[length + 3];
        str2.getChars(0, str2.length(), this.name_chars, 1);
        char[] cArr = this.name_chars;
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
    }

    public Object getPropertyValue(Object obj) throws Exception {
        try {
            return this.fieldInfo.get(obj);
        } catch (Exception e10) {
            FieldInfo fieldInfo = this.fieldInfo;
            Member member = fieldInfo.method;
            if (member == null) {
                member = fieldInfo.field;
            }
            throw new JSONException("get property error。 " + (member.getDeclaringClass().getName() + "." + member.getName()), e10);
        }
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i10 = serializeWriter.features;
        if ((SerializerFeature.QuoteFieldNames.mask & i10) == 0) {
            serializeWriter.writeFieldName(this.fieldInfo.name, true);
        } else if ((i10 & SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter.writeFieldName(this.fieldInfo.name, true);
        } else {
            char[] cArr = this.name_chars;
            serializeWriter.write(cArr, 0, cArr.length);
        }
    }

    public void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception {
        Class<?> cls;
        String str = this.format;
        if (str != null) {
            jSONSerializer.writeWithFormat(obj, str);
            return;
        }
        if (this.runtimeInfo == null) {
            if (obj == null) {
                cls = this.fieldInfo.fieldClass;
            } else {
                cls = obj.getClass();
            }
            this.runtimeInfo = new RuntimeSerializerInfo(jSONSerializer.config.get(cls), cls);
        }
        RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2 == runtimeSerializerInfo.runtimeFieldClass) {
                ObjectSerializer objectSerializer = runtimeSerializerInfo.fieldSerializer;
                FieldInfo fieldInfo = this.fieldInfo;
                objectSerializer.write(jSONSerializer, obj, fieldInfo.name, fieldInfo.fieldType);
                return;
            }
            ObjectSerializer objectSerializer2 = jSONSerializer.config.get(cls2);
            FieldInfo fieldInfo2 = this.fieldInfo;
            objectSerializer2.write(jSONSerializer, obj, fieldInfo2.name, fieldInfo2.fieldType);
        } else if ((this.features & SerializerFeature.WriteNullNumberAsZero.mask) == 0 || !Number.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
            int i10 = this.features;
            if ((SerializerFeature.WriteNullBooleanAsFalse.mask & i10) != 0 && Boolean.class == runtimeSerializerInfo.runtimeFieldClass) {
                jSONSerializer.out.write("false");
            } else if ((i10 & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Collection.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
                runtimeSerializerInfo.fieldSerializer.write(jSONSerializer, null, this.fieldInfo.name, runtimeSerializerInfo.runtimeFieldClass);
            } else {
                jSONSerializer.out.write("[]");
            }
        } else {
            jSONSerializer.out.write(48);
        }
    }

    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }
}
