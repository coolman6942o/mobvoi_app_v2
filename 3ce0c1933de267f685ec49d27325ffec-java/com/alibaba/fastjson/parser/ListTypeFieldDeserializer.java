package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ListTypeFieldDeserializer extends FieldDeserializer {
    private final boolean array;
    private ObjectDeserializer deserializer;
    private final Type itemType;

    public ListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo, 14);
        Type type = fieldInfo.fieldType;
        Class<?> cls2 = fieldInfo.fieldClass;
        if (type instanceof ParameterizedType) {
            this.itemType = ((ParameterizedType) type).getActualTypeArguments()[0];
            this.array = false;
        } else if (cls2.isArray()) {
            this.itemType = cls2.getComponentType();
            this.array = true;
        } else {
            this.itemType = Object.class;
            this.array = false;
        }
    }

    final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        int i10;
        int i11;
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer = this.deserializer;
        if (type instanceof ParameterizedType) {
            Class cls = null;
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() instanceof Class) {
                    cls = (Class) parameterizedType.getRawType();
                }
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i11 = 0;
                    while (i11 < length) {
                        if (cls.getTypeParameters()[i11].getName().equals(typeVariable.getName())) {
                            break;
                        }
                        i11++;
                    }
                }
                i11 = -1;
                if (i11 != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i11];
                    if (!type2.equals(this.itemType)) {
                        objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
                    }
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1 && (actualTypeArguments[0] instanceof TypeVariable)) {
                    TypeVariable typeVariable2 = (TypeVariable) actualTypeArguments[0];
                    ParameterizedType parameterizedType3 = (ParameterizedType) type;
                    if (parameterizedType3.getRawType() instanceof Class) {
                        cls = (Class) parameterizedType3.getRawType();
                    }
                    if (cls != null) {
                        int length2 = cls.getTypeParameters().length;
                        i10 = 0;
                        while (i10 < length2) {
                            if (cls.getTypeParameters()[i10].getName().equals(typeVariable2.getName())) {
                                break;
                            }
                            i10++;
                        }
                    }
                    i10 = -1;
                    if (i10 != -1) {
                        actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i10];
                        type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    }
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (objectDeserializer == null) {
            objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
            this.deserializer = objectDeserializer;
        }
        int i12 = jSONLexer.token;
        if (i12 == 14) {
            int i13 = 0;
            char c10 = jSONLexer.f6710ch;
            int i14 = 15;
            char c11 = JSONLexer.EOI;
            if (c10 == '[') {
                int i15 = jSONLexer.f6709bp + 1;
                jSONLexer.f6709bp = i15;
                jSONLexer.f6710ch = i15 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i15);
                jSONLexer.token = 14;
            } else if (c10 == '{') {
                int i16 = jSONLexer.f6709bp + 1;
                jSONLexer.f6709bp = i16;
                jSONLexer.f6710ch = i16 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i16);
                jSONLexer.token = 12;
            } else if (c10 == '\"') {
                jSONLexer.scanString();
            } else if (c10 == ']') {
                int i17 = jSONLexer.f6709bp + 1;
                jSONLexer.f6709bp = i17;
                jSONLexer.f6710ch = i17 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i17);
                jSONLexer.token = 15;
            } else {
                jSONLexer.nextToken();
            }
            while (true) {
                int i18 = jSONLexer.token;
                if (i18 == 16) {
                    jSONLexer.nextToken();
                } else if (i18 == i14) {
                    break;
                } else {
                    collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, Integer.valueOf(i13)));
                    if (defaultJSONParser.resolveStatus == 1) {
                        defaultJSONParser.checkListResolve(collection);
                    }
                    if (jSONLexer.token == 16) {
                        char c12 = jSONLexer.f6710ch;
                        if (c12 == '[') {
                            int i19 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i19;
                            jSONLexer.f6710ch = i19 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i19);
                            jSONLexer.token = 14;
                        } else if (c12 == '{') {
                            int i20 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i20;
                            jSONLexer.f6710ch = i20 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i20);
                            jSONLexer.token = 12;
                        } else if (c12 == '\"') {
                            jSONLexer.scanString();
                        } else {
                            jSONLexer.nextToken();
                        }
                    }
                    i13++;
                    i14 = 15;
                }
            }
            if (jSONLexer.f6710ch == ',') {
                int i21 = jSONLexer.f6709bp + 1;
                jSONLexer.f6709bp = i21;
                if (i21 < jSONLexer.len) {
                    c11 = jSONLexer.text.charAt(i21);
                }
                jSONLexer.f6710ch = c11;
                jSONLexer.token = 16;
                return;
            }
            jSONLexer.nextToken();
        } else if (i12 == 12) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, 0));
        } else {
            String str = "exepct '[', but " + JSONToken.name(jSONLexer.token);
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new JSONException(str);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        ArrayList arrayList;
        JSONArray jSONArray;
        if (defaultJSONParser.lexer.token == 8) {
            setValue(obj, (Object) null);
            defaultJSONParser.lexer.nextToken();
            return;
        }
        if (this.array) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.setComponentType(this.itemType);
            jSONArray = jSONArray2;
            arrayList = jSONArray2;
        } else {
            arrayList = new ArrayList();
            jSONArray = null;
        }
        ParseContext parseContext = defaultJSONParser.contex;
        defaultJSONParser.setContext(parseContext, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(parseContext);
        Object obj2 = arrayList;
        if (this.array) {
            Object array = arrayList.toArray((Object[]) Array.newInstance((Class) this.itemType, arrayList.size()));
            jSONArray.setRelatedArray(array);
            obj2 = array;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, obj2);
        } else {
            setValue(obj, obj2);
        }
    }
}
