package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
/* loaded from: classes.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    protected ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo, 2);
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        return this.fieldValueDeserilizer;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        Object obj2;
        Class<?> cls;
        if (this.fieldValueDeserilizer == null) {
            ParserConfig parserConfig = defaultJSONParser.config;
            FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        if (type instanceof ParameterizedType) {
            defaultJSONParser.contex.type = type;
        }
        FieldInfo fieldInfo2 = this.fieldInfo;
        String str = fieldInfo2.format;
        if (str != null) {
            ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
            if (objectDeserializer instanceof DateCodec) {
                obj2 = ((DateCodec) objectDeserializer).deserialze(defaultJSONParser, fieldInfo2.fieldType, fieldInfo2.name, str);
                if (defaultJSONParser.resolveStatus != 1) {
                    DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
                    lastResolveTask.fieldDeserializer = this;
                    lastResolveTask.ownerContext = defaultJSONParser.contex;
                    defaultJSONParser.resolveStatus = 0;
                    return;
                } else if (obj == null) {
                    map.put(this.fieldInfo.name, obj2);
                    return;
                } else if (obj2 != null || ((cls = this.fieldInfo.fieldClass) != Byte.TYPE && cls != Short.TYPE && cls != Float.TYPE && cls != Double.TYPE)) {
                    setValue(obj, obj2);
                    return;
                } else {
                    return;
                }
            }
        }
        obj2 = this.fieldValueDeserilizer.deserialze(defaultJSONParser, fieldInfo2.fieldType, fieldInfo2.name);
        if (defaultJSONParser.resolveStatus != 1) {
        }
    }
}
