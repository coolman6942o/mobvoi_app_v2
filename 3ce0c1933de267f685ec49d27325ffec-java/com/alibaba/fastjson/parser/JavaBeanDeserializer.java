package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.mobvoi.wear.lpa.LpaConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    public final JavaBeanInfo beanInfo;
    private final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    private <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum r82;
        String str;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t10 = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i10 = 0;
        while (i10 < length) {
            boolean z10 = i10 == length + (-1) ? true : true;
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i10];
            FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            Class<?> cls = fieldInfo.fieldClass;
            try {
                if (cls == Integer.TYPE) {
                    int scanLongValue = (int) jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setInt(t10, scanLongValue);
                    } else {
                        fieldDeserializer.setValue(t10, new Integer(scanLongValue));
                    }
                    char c10 = jSONLexer.f6710ch;
                    if (c10 == ',') {
                        int i11 = jSONLexer.f6709bp + 1;
                        jSONLexer.f6709bp = i11;
                        jSONLexer.f6710ch = i11 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i11);
                        jSONLexer.token = 16;
                    } else if (c10 == ']') {
                        int i12 = jSONLexer.f6709bp + 1;
                        jSONLexer.f6709bp = i12;
                        jSONLexer.f6710ch = i12 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i12);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == String.class) {
                    char c11 = jSONLexer.f6710ch;
                    if (c11 == '\"') {
                        str = jSONLexer.scanStringValue('\"');
                    } else if (c11 != 'n' || !jSONLexer.text.startsWith(LpaConstants.VALUE_NULL, jSONLexer.f6709bp)) {
                        throw new JSONException("not match string. feild : " + obj);
                    } else {
                        int i13 = jSONLexer.f6709bp + 4;
                        jSONLexer.f6709bp = i13;
                        jSONLexer.f6710ch = i13 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i13);
                        str = null;
                    }
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.set(t10, str);
                    } else {
                        fieldDeserializer.setValue(t10, str);
                    }
                    char c12 = jSONLexer.f6710ch;
                    if (c12 == ',') {
                        int i14 = jSONLexer.f6709bp + 1;
                        jSONLexer.f6709bp = i14;
                        jSONLexer.f6710ch = i14 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i14);
                        jSONLexer.token = 16;
                    } else if (c12 == ']') {
                        int i15 = jSONLexer.f6709bp + 1;
                        jSONLexer.f6709bp = i15;
                        jSONLexer.f6710ch = i15 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i15);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else {
                    if (cls == Long.TYPE) {
                        long scanLongValue2 = jSONLexer.scanLongValue();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setLong(t10, scanLongValue2);
                        } else {
                            fieldDeserializer.setValue(t10, new Long(scanLongValue2));
                        }
                        char c13 = jSONLexer.f6710ch;
                        if (c13 == ',') {
                            int i16 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i16;
                            jSONLexer.f6710ch = i16 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i16);
                            jSONLexer.token = 16;
                        } else if (c13 == ']') {
                            int i17 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i17;
                            jSONLexer.f6710ch = i17 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i17);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean scanBoolean = jSONLexer.scanBoolean();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setBoolean(t10, scanBoolean);
                        } else {
                            fieldDeserializer.setValue(t10, Boolean.valueOf(scanBoolean));
                        }
                        char c14 = jSONLexer.f6710ch;
                        if (c14 == ',') {
                            int i18 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i18;
                            jSONLexer.f6710ch = i18 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i18);
                            jSONLexer.token = 16;
                        } else if (c14 == ']') {
                            int i19 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i19;
                            jSONLexer.f6710ch = i19 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i19);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls.isEnum()) {
                        char c15 = jSONLexer.f6710ch;
                        if (c15 == '\"') {
                            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                            r82 = scanSymbol == null ? null : Enum.valueOf(cls, scanSymbol);
                        } else if (c15 < '0' || c15 > '9') {
                            throw new JSONException("illegal enum." + jSONLexer.info());
                        } else {
                            r82 = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.config)).values[(int) jSONLexer.scanLongValue()];
                        }
                        fieldDeserializer.setValue(t10, r82);
                        char c16 = jSONLexer.f6710ch;
                        if (c16 == ',') {
                            int i20 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i20;
                            jSONLexer.f6710ch = i20 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i20);
                            jSONLexer.token = 16;
                        } else if (c16 == ']') {
                            int i21 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i21;
                            jSONLexer.f6710ch = i21 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i21);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Date.class && jSONLexer.f6710ch == '1') {
                        fieldDeserializer.setValue(t10, new Date(jSONLexer.scanLongValue()));
                        char c17 = jSONLexer.f6710ch;
                        if (c17 == ',') {
                            int i22 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i22;
                            jSONLexer.f6710ch = i22 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i22);
                            jSONLexer.token = 16;
                        } else if (c17 == ']') {
                            int i23 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i23;
                            jSONLexer.f6710ch = i23 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i23);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else {
                        char c18 = jSONLexer.f6710ch;
                        if (c18 == '[') {
                            int i24 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i24;
                            jSONLexer.f6710ch = i24 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i24);
                            jSONLexer.token = 14;
                        } else if (c18 == '{') {
                            int i25 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i25;
                            jSONLexer.f6710ch = i25 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i25);
                            jSONLexer.token = 12;
                        } else {
                            jSONLexer.nextToken();
                        }
                        fieldDeserializer.parseField(defaultJSONParser, t10, fieldInfo.fieldType, null);
                        if (z10) {
                            if (jSONLexer.token != 15) {
                                throw new JSONException("syntax error");
                            }
                        } else if (z10 && jSONLexer.token != 16) {
                            throw new JSONException("syntax error");
                        }
                    }
                    i10++;
                }
                i10++;
            } catch (IllegalAccessException e10) {
                throw new JSONException("set " + fieldInfo.name + "error", e10);
            }
        }
        if (jSONLexer.f6710ch == ',') {
            int i26 = jSONLexer.f6709bp + 1;
            jSONLexer.f6709bp = i26;
            jSONLexer.f6710ch = i26 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i26);
            jSONLexer.token = 16;
        } else {
            jSONLexer.nextToken();
        }
        return t10;
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        Field[] declaredFields;
        FieldDeserializer[] fieldDeserializerArr;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            boolean startsWith = str.startsWith("is");
            for (FieldDeserializer fieldDeserializer2 : this.sortedFieldDeserializers) {
                FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
                Class<?> cls = fieldInfo.fieldClass;
                String str2 = fieldInfo.name;
                if (str2.equalsIgnoreCase(str) || (startsWith && ((cls == Boolean.TYPE || cls == Boolean.class) && str2.equalsIgnoreCase(str.substring(2))))) {
                    fieldDeserializer = fieldDeserializer2;
                    break;
                }
            }
        }
        int i10 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && !((defaultJSONParser.lexer.features & i10) == 0 && (i10 & this.beanInfo.parserFeatures) == 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Field field : this.clazz.getDeclaredFields()) {
                    String name = field.getName();
                    if (getFieldDeserializer(name) == null) {
                        int modifiers = field.getModifiers();
                        if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                            concurrentHashMap.put(name, field);
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.config, this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        jSONLexer.nextTokenWithChar(':');
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        FieldInfo[] fieldInfoArr;
        if (!(type instanceof Class) || !this.clazz.isInterface()) {
            JavaBeanInfo javaBeanInfo = this.beanInfo;
            Constructor<?> constructor = javaBeanInfo.defaultConstructor;
            if (constructor == null) {
                return null;
            }
            try {
                Object newInstance = javaBeanInfo.defaultConstructorParameterSize == 0 ? constructor.newInstance(new Object[0]) : constructor.newInstance(defaultJSONParser.contex.object);
                if (!(defaultJSONParser == null || (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) == 0)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            fieldInfo.set(newInstance, "");
                        }
                    }
                }
                return newInstance;
            } catch (Exception e10) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e10);
            }
        } else {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        if (this.beanInfo.ordered) {
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i10 >= fieldDeserializerArr.length) {
                    return null;
                }
                if (fieldDeserializerArr[i10].fieldInfo.name.equalsIgnoreCase(str)) {
                    return this.sortedFieldDeserializers[i10];
                }
                i10++;
            }
        } else {
            int length = this.sortedFieldDeserializers.length - 1;
            while (i10 <= length) {
                int i11 = (i10 + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i11].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i10 = i11 + 1;
                } else if (compareTo <= 0) {
                    return this.sortedFieldDeserializers[i11];
                } else {
                    length = i11 - 1;
                }
            }
            return null;
        }
    }

    protected JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & Feature.IgnoreNotMatch.mask) != 0) {
            jSONLexer.nextTokenWithChar(':');
            Type type = null;
            List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
            if (list != null) {
                for (ExtraTypeProvider extraTypeProvider : list) {
                    type = extraTypeProvider.getExtraType(obj, str);
                }
            }
            if (type == null) {
                obj2 = defaultJSONParser.parse();
            } else {
                obj2 = defaultJSONParser.parseObject(type);
            }
            if (obj instanceof ExtraProcessable) {
                ((ExtraProcessable) obj).processExtra(str, obj2);
                return;
            }
            List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
            if (list2 != null) {
                for (ExtraProcessor extraProcessor : list2) {
                    extraProcessor.processExtra(obj, str, obj2);
                }
                return;
            }
            return;
        }
        throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, JavaBeanInfo javaBeanInfo) {
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.sortedFieldDeserializers[i10] = parserConfig.createFieldDeserializer(parserConfig, cls, javaBeanInfo.sortedFields[i10]);
        }
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            this.fieldDeserializers[i11] = getFieldDeserializer(javaBeanInfo.fields[i11].name);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:199:0x025a, code lost:
        if (r1 == 16) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x026a, code lost:
        r14.nextTokenWithChar(':');
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0270, code lost:
        if (r14.token != 4) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0272, code lost:
        r0 = r14.stringVal();
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x027c, code lost:
        if ("@".equals(r0) == false) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0280, code lost:
        r2 = (T) r4.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0288, code lost:
        if ("..".equals(r0) == false) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x028a, code lost:
        r1 = r4.parent;
        r2 = (T) r1.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x028e, code lost:
        if (r2 == null) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0290, code lost:
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0291, code lost:
        r37.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r37.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02a3, code lost:
        if ("$".equals(r0) == false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x02a5, code lost:
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02a6, code lost:
        r2 = r1.parent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x02a8, code lost:
        if (r2 == null) goto L518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x02aa, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x02ac, code lost:
        r2 = (T) r1.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02ae, code lost:
        if (r2 == null) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02b0, code lost:
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02b1, code lost:
        r37.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r37.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x02bd, code lost:
        r37.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r4, r0));
        r37.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02c8, code lost:
        r2 = (T) r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x02cc, code lost:
        r14.nextToken(13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x02d1, code lost:
        if (r14.token != 13) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x02d3, code lost:
        r14.nextToken(16);
        r37.setContext(r4, r2, r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x02db, code lost:
        if (r28 == null) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02dd, code lost:
        r28.object = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x02e1, code lost:
        r37.setContext(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x02e4, code lost:
        return (T) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x02e5, code lost:
        r1 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x02ee, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x02ef, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x02f2, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x02f3, code lost:
        r1 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0313, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0352, code lost:
        r7 = r36;
        r6 = r1;
        r15 = r4;
        r0 = r20;
        r14 = (T) r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0374, code lost:
        r5 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0376, code lost:
        r3 = r5.getSeeAlso(r37.config, r5.beanInfo, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x037c, code lost:
        if (r3 != null) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x037e, code lost:
        r6 = com.alibaba.fastjson.util.TypeUtils.loadClass(r2, r37.config.defaultClassLoader);
        r0 = com.alibaba.fastjson.util.TypeUtils.getClass(r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x038a, code lost:
        if (r0 == null) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x038c, code lost:
        if (r6 == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0392, code lost:
        if (r0.isAssignableFrom(r6) == false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x039c, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match");
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x039d, code lost:
        r3 = r37.config.getDeserializer(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x03a4, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x03a5, code lost:
        r6 = r1;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x03aa, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x03ab, code lost:
        r0 = (T) r3.deserialze(r37, r6, r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x03af, code lost:
        if (r1 == null) goto L283;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x03b1, code lost:
        r1.object = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x03b5, code lost:
        r37.setContext(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x03b8, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x03b9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x03ba, code lost:
        r2 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x03bd, code lost:
        r5 = r36;
        r2 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x03c8, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x03c9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x065b, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r0.token));
     */
    /* JADX WARN: Removed duplicated region for block: B:190:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #5 {all -> 0x0048, blocks: (B:16:0x0038, B:18:0x003d, B:27:0x0052, B:29:0x0058, B:35:0x0067, B:41:0x0076, B:46:0x0082, B:48:0x008c, B:51:0x0093, B:53:0x00a8, B:54:0x00b0, B:55:0x00b9, B:60:0x00c0), top: B:473:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x066f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        ParseContext parseContext;
        Object obj3;
        Throwable th2;
        int i10;
        int length;
        int i11;
        HashMap hashMap;
        Object obj4;
        FieldDeserializer fieldDeserializer;
        int i12;
        FieldInfo fieldInfo;
        int i13;
        Class<?> cls;
        Class<Double> cls2;
        boolean z10;
        int i14;
        char c10;
        JSONLexer jSONLexer;
        Object obj5;
        boolean z11;
        char c11;
        ParseContext parseContext2;
        ParseContext parseContext3;
        float f10;
        FieldInfo fieldInfo2;
        Object obj6;
        boolean z12;
        boolean z13;
        int i15;
        double d10;
        double d11;
        int i16;
        int i17;
        String str;
        JavaBeanDeserializer javaBeanDeserializer;
        Object obj7;
        ParseContext parseContext4;
        JSONLexer jSONLexer2;
        int i18;
        int i19;
        Object obj8;
        String scanSymbol;
        Object obj9;
        long j10;
        Object valueOf;
        boolean z14;
        boolean z15;
        boolean z16;
        JavaBeanDeserializer javaBeanDeserializer2 = this;
        Type type2 = type;
        Class<Double> cls3 = Double.class;
        if (type2 == JSON.class || type2 == JSONObject.class) {
            return (T) defaultJSONParser.parse();
        }
        JSONLexer jSONLexer3 = defaultJSONParser.lexer;
        int i20 = jSONLexer3.token;
        ParseContext parseContext5 = null;
        if (i20 == 8) {
            jSONLexer3.nextToken(16);
            return null;
        }
        boolean z17 = jSONLexer3.disableCircularReferenceDetect;
        ParseContext parseContext6 = defaultJSONParser.contex;
        if (!(obj2 == null || parseContext6 == null)) {
            parseContext6 = parseContext6.parent;
        }
        ParseContext parseContext7 = parseContext6;
        try {
        } catch (Throwable th3) {
            th2 = th3;
            obj3 = obj2;
        }
        if (i20 == 13) {
            jSONLexer3.nextToken(16);
            T t10 = obj2 == null ? (T) createInstance(defaultJSONParser, type) : (T) obj2;
            defaultJSONParser.setContext(parseContext7);
            return t10;
        }
        if (i20 == 14) {
            if (!javaBeanDeserializer2.beanInfo.supportBeanToArray && (jSONLexer3.features & Feature.SupportArrayToBean.mask) == 0) {
                z16 = false;
                if (z16) {
                    T t11 = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                    defaultJSONParser.setContext(parseContext7);
                    return t11;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        if (i20 == 12 || i20 == 16) {
            try {
                if (defaultJSONParser.resolveStatus == 2) {
                    i10 = 0;
                    defaultJSONParser.resolveStatus = 0;
                } else {
                    i10 = 0;
                }
                length = javaBeanDeserializer2.sortedFieldDeserializers.length;
                i11 = i10;
                hashMap = null;
                obj4 = obj2;
            } catch (Throwable th4) {
                th2 = th4;
                parseContext = parseContext7;
                obj3 = obj2;
            }
            while (true) {
                if (i11 < length) {
                    try {
                        fieldDeserializer = javaBeanDeserializer2.sortedFieldDeserializers[i11];
                        i12 = length;
                        fieldInfo = fieldDeserializer.fieldInfo;
                        i13 = i11;
                        cls = fieldInfo.fieldClass;
                    } catch (Throwable th5) {
                        th2 = th5;
                        obj3 = obj4;
                        parseContext = parseContext7;
                        if (parseContext5 != null) {
                        }
                        defaultJSONParser.setContext(parseContext);
                        throw th2;
                    }
                } else {
                    i12 = length;
                    i13 = i11;
                    fieldInfo = null;
                    cls = null;
                    fieldDeserializer = null;
                }
                long j11 = 0;
                float f11 = 0.0f;
                double d12 = 0.0d;
                if (fieldDeserializer != null) {
                    z11 = z17;
                    parseContext3 = parseContext5;
                    try {
                        j10 = fieldInfo.nameHashCode;
                        obj5 = obj4;
                        try {
                        } catch (Throwable th6) {
                            th2 = th6;
                            parseContext = parseContext7;
                            parseContext5 = parseContext3;
                            obj3 = (T) obj5;
                            if (parseContext5 != null) {
                            }
                            defaultJSONParser.setContext(parseContext);
                            throw th2;
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        obj5 = obj4;
                    }
                    if (!(cls == Integer.TYPE || cls == Integer.class)) {
                        if (!(cls == Long.TYPE || cls == Long.class)) {
                            if (cls == String.class) {
                                valueOf = jSONLexer3.scanFieldString(j10);
                                int i21 = jSONLexer3.matchStat;
                                if (i21 <= 0) {
                                    if (i21 == -2) {
                                        parseContext2 = parseContext3;
                                        c11 = '\r';
                                        javaBeanDeserializer2 = this;
                                        i14 = i13;
                                        parseContext5 = parseContext2;
                                        parseContext = parseContext7;
                                        cls2 = cls3;
                                        jSONLexer = jSONLexer3;
                                        z10 = z11;
                                        obj3 = obj5;
                                        c10 = 16;
                                    }
                                    i15 = 0;
                                    z13 = false;
                                    z12 = false;
                                    fieldInfo2 = fieldInfo;
                                    f10 = 0.0f;
                                    obj6 = valueOf;
                                    d10 = 0.0d;
                                    if (z13) {
                                        i16 = i15;
                                        try {
                                            scanSymbol = jSONLexer3.scanSymbol(defaultJSONParser.symbolTable);
                                            if (scanSymbol == null) {
                                                d11 = d10;
                                                int i22 = jSONLexer3.token;
                                                if (i22 == 13) {
                                                    jSONLexer3.nextToken(16);
                                                    parseContext2 = parseContext3;
                                                    break;
                                                }
                                            } else {
                                                d11 = d10;
                                            }
                                        } catch (Throwable th8) {
                                            th2 = th8;
                                            parseContext2 = parseContext3;
                                        }
                                        if ("$ref" == scanSymbol) {
                                            try {
                                                break;
                                            } catch (Throwable th9) {
                                                th2 = th9;
                                                parseContext2 = parseContext3;
                                            }
                                        } else {
                                            parseContext2 = parseContext3;
                                            if (JSON.DEFAULT_TYPE_KEY == scanSymbol) {
                                                try {
                                                    jSONLexer3.nextTokenWithChar(':');
                                                    if (jSONLexer3.token != 4) {
                                                        break;
                                                    }
                                                    String stringVal = jSONLexer3.stringVal();
                                                    jSONLexer3.nextToken(16);
                                                    if (!(type2 instanceof Class)) {
                                                        break;
                                                    }
                                                    try {
                                                        if (!stringVal.equals(((Class) type2).getName())) {
                                                            break;
                                                        }
                                                        c11 = '\r';
                                                        if (jSONLexer3.token == 13) {
                                                            jSONLexer3.nextToken();
                                                            break;
                                                        }
                                                        javaBeanDeserializer2 = this;
                                                        i14 = i13;
                                                        parseContext5 = parseContext2;
                                                        parseContext = parseContext7;
                                                        cls2 = cls3;
                                                        jSONLexer = jSONLexer3;
                                                        z10 = z11;
                                                        obj3 = obj5;
                                                        c10 = 16;
                                                    } catch (Throwable th10) {
                                                        th2 = th10;
                                                    }
                                                    parseContext5 = parseContext2;
                                                    obj3 = (T) obj9;
                                                    parseContext = parseContext7;
                                                } catch (Throwable th11) {
                                                    th2 = th11;
                                                    obj4 = (T) obj5;
                                                    parseContext5 = parseContext2;
                                                    obj3 = obj4;
                                                    parseContext = parseContext7;
                                                    if (parseContext5 != null) {
                                                    }
                                                    defaultJSONParser.setContext(parseContext);
                                                    throw th2;
                                                }
                                                if (parseContext5 != null) {
                                                    parseContext5.object = obj3;
                                                }
                                                defaultJSONParser.setContext(parseContext);
                                                throw th2;
                                            }
                                            i17 = 13;
                                            str = scanSymbol;
                                            obj7 = obj5;
                                            javaBeanDeserializer = this;
                                        }
                                        parseContext5 = parseContext2;
                                        parseContext = parseContext7;
                                        obj3 = (T) obj5;
                                        if (parseContext5 != null) {
                                        }
                                        defaultJSONParser.setContext(parseContext);
                                        throw th2;
                                    }
                                    d11 = d10;
                                    i16 = i15;
                                    parseContext2 = parseContext3;
                                    obj7 = obj5;
                                    i17 = 13;
                                    javaBeanDeserializer = this;
                                    str = null;
                                    if (obj7 == null || hashMap != null) {
                                        parseContext4 = parseContext2;
                                        jSONLexer2 = jSONLexer3;
                                    } else {
                                        try {
                                            obj7 = createInstance(defaultJSONParser, type);
                                            if (obj7 == null) {
                                                parseContext4 = parseContext2;
                                                try {
                                                    jSONLexer2 = jSONLexer3;
                                                    hashMap = new HashMap(javaBeanDeserializer.fieldDeserializers.length);
                                                } catch (Throwable th12) {
                                                    th2 = th12;
                                                    obj3 = (T) obj7;
                                                    parseContext = parseContext7;
                                                    parseContext5 = parseContext4;
                                                    if (parseContext5 != null) {
                                                    }
                                                    defaultJSONParser.setContext(parseContext);
                                                    throw th2;
                                                }
                                            } else {
                                                parseContext4 = parseContext2;
                                                jSONLexer2 = jSONLexer3;
                                            }
                                            if (!z11) {
                                                parseContext4 = defaultJSONParser.setContext(parseContext7, obj7, obj);
                                            }
                                        } catch (Throwable th13) {
                                            th2 = th13;
                                            parseContext4 = parseContext2;
                                        }
                                    }
                                    obj3 = (T) obj7;
                                    HashMap hashMap2 = hashMap;
                                    if (!z13) {
                                        if (!z12) {
                                            try {
                                                fieldDeserializer.parseField(defaultJSONParser, obj3, type2, hashMap2);
                                                i14 = i13;
                                                hashMap = hashMap2;
                                                parseContext = parseContext7;
                                                javaBeanDeserializer2 = javaBeanDeserializer;
                                                cls2 = cls3;
                                                z10 = z11;
                                                i18 = i17;
                                                jSONLexer = jSONLexer2;
                                            } catch (Throwable th14) {
                                                th2 = th14;
                                                obj3 = obj3;
                                                parseContext = parseContext7;
                                                parseContext5 = parseContext4;
                                                if (parseContext5 != null) {
                                                }
                                                defaultJSONParser.setContext(parseContext);
                                                throw th2;
                                            }
                                        } else {
                                            if (obj3 == null) {
                                                if (!(cls == Integer.TYPE || cls == Integer.class)) {
                                                    if (!(cls == Long.TYPE || cls == Long.class)) {
                                                        if (!(cls == Float.TYPE || cls == Float.class)) {
                                                            if (!(cls == Double.TYPE || cls == cls3)) {
                                                                obj8 = obj6;
                                                                hashMap2.put(fieldInfo2.name, obj8);
                                                                hashMap = hashMap2;
                                                            }
                                                            obj8 = new Double(d11);
                                                            hashMap2.put(fieldInfo2.name, obj8);
                                                            hashMap = hashMap2;
                                                        }
                                                        obj8 = new Float(f10);
                                                        hashMap2.put(fieldInfo2.name, obj8);
                                                        hashMap = hashMap2;
                                                    }
                                                    obj8 = Long.valueOf(j11);
                                                    hashMap2.put(fieldInfo2.name, obj8);
                                                    hashMap = hashMap2;
                                                }
                                                obj8 = Integer.valueOf(i16);
                                                hashMap2.put(fieldInfo2.name, obj8);
                                                hashMap = hashMap2;
                                            } else {
                                                FieldInfo fieldInfo3 = fieldInfo2;
                                                float f12 = f10;
                                                double d13 = d11;
                                                if (obj6 == null) {
                                                    hashMap = hashMap2;
                                                    try {
                                                        Class<?> cls4 = Integer.TYPE;
                                                        if (!(cls == cls4 || cls == Integer.class)) {
                                                            Class<?> cls5 = Long.TYPE;
                                                            if (!(cls == cls5 || cls == Long.class)) {
                                                                Class<?> cls6 = Float.TYPE;
                                                                if (!(cls == cls6 || cls == Float.class)) {
                                                                    Class<?> cls7 = Double.TYPE;
                                                                    if (!(cls == cls7 || cls == cls3)) {
                                                                        fieldDeserializer.setValue(obj3, obj6);
                                                                    }
                                                                    if (!fieldInfo3.fieldAccess || cls != cls7) {
                                                                        fieldDeserializer.setValue(obj3, new Double(d13));
                                                                    } else {
                                                                        fieldDeserializer.setValue(obj3, d13);
                                                                    }
                                                                }
                                                                if (!fieldInfo3.fieldAccess || cls != cls6) {
                                                                    fieldDeserializer.setValue(obj3, new Float(f12));
                                                                } else {
                                                                    fieldDeserializer.setValue(obj3, f12);
                                                                }
                                                            }
                                                            if (!fieldInfo3.fieldAccess || cls != cls5) {
                                                                fieldDeserializer.setValue(obj3, Long.valueOf(j11));
                                                            } else {
                                                                fieldDeserializer.setValue(obj3, j11);
                                                            }
                                                        }
                                                        if (!fieldInfo3.fieldAccess || cls != cls4) {
                                                            fieldDeserializer.setValue(obj3, Integer.valueOf(i16));
                                                        } else {
                                                            fieldDeserializer.setValue(obj3, i16);
                                                        }
                                                    } catch (IllegalAccessException e10) {
                                                        throw new JSONException("set property error, " + fieldInfo3.name, e10);
                                                    }
                                                } else {
                                                    hashMap = hashMap2;
                                                    fieldDeserializer.setValue(obj3, obj6);
                                                }
                                            }
                                            jSONLexer = jSONLexer2;
                                            if (jSONLexer.matchStat == 4) {
                                                parseContext = parseContext7;
                                                javaBeanDeserializer2 = javaBeanDeserializer;
                                                break;
                                            }
                                            i14 = i13;
                                            parseContext = parseContext7;
                                            javaBeanDeserializer2 = javaBeanDeserializer;
                                            cls2 = cls3;
                                            z10 = z11;
                                            i18 = i17;
                                        }
                                        i19 = jSONLexer.token;
                                        c10 = 16;
                                        if (i19 != 16) {
                                            parseContext5 = parseContext4;
                                        } else if (i19 == i18) {
                                            jSONLexer.nextToken(16);
                                            break;
                                        } else {
                                            if (i19 == 18 || i19 == 1) {
                                                break;
                                            }
                                            parseContext5 = parseContext4;
                                        }
                                    } else {
                                        hashMap = hashMap2;
                                        jSONLexer = jSONLexer2;
                                        i14 = i13;
                                        i18 = i17;
                                        parseContext = parseContext7;
                                        z10 = z11;
                                        javaBeanDeserializer2 = javaBeanDeserializer;
                                        cls2 = cls3;
                                        try {
                                            if (parseField(defaultJSONParser, str, obj3, type, hashMap)) {
                                                if (jSONLexer.token == 17) {
                                                    throw new JSONException("syntax error, unexpect token ':'");
                                                }
                                                i19 = jSONLexer.token;
                                                c10 = 16;
                                                if (i19 != 16) {
                                                }
                                            } else if (jSONLexer.token == i18) {
                                                jSONLexer.nextToken();
                                                break;
                                            } else {
                                                c10 = 16;
                                                parseContext5 = parseContext4;
                                            }
                                        } catch (Throwable th15) {
                                            th2 = th15;
                                            parseContext5 = parseContext4;
                                            if (parseContext5 != null) {
                                            }
                                            defaultJSONParser.setContext(parseContext);
                                            throw th2;
                                        }
                                    }
                                }
                                i15 = 0;
                                z13 = true;
                                z12 = true;
                                fieldInfo2 = fieldInfo;
                                f10 = 0.0f;
                                obj6 = valueOf;
                                d10 = 0.0d;
                                if (z13) {
                                }
                                if (obj7 == null) {
                                }
                                parseContext4 = parseContext2;
                                jSONLexer2 = jSONLexer3;
                                obj3 = (T) obj7;
                                HashMap hashMap22 = hashMap;
                                if (!z13) {
                                }
                            } else {
                                if (!(cls == Boolean.TYPE || cls == Boolean.class)) {
                                    if (!(cls == Float.TYPE || cls == Float.class)) {
                                        if (!(cls == Double.TYPE || cls == cls3)) {
                                            if (fieldInfo.isEnum && (defaultJSONParser.config.getDeserializer(cls) instanceof EnumDeserializer)) {
                                                long scanFieldSymbol = jSONLexer3.scanFieldSymbol(j10);
                                                int i23 = jSONLexer3.matchStat;
                                                if (i23 > 0) {
                                                    valueOf = fieldDeserializer.getEnumByHashCode(scanFieldSymbol);
                                                    z15 = true;
                                                    z14 = true;
                                                } else if (i23 != -2) {
                                                    valueOf = null;
                                                    z15 = false;
                                                    z14 = false;
                                                }
                                                z12 = z14;
                                                z13 = z15;
                                                i15 = 0;
                                                fieldInfo2 = fieldInfo;
                                                f10 = 0.0f;
                                                obj6 = valueOf;
                                                d10 = 0.0d;
                                                if (z13) {
                                                }
                                                if (obj7 == null) {
                                                }
                                                parseContext4 = parseContext2;
                                                jSONLexer2 = jSONLexer3;
                                                obj3 = (T) obj7;
                                                HashMap hashMap222 = hashMap;
                                                if (!z13) {
                                                }
                                            } else if (cls == int[].class) {
                                                valueOf = jSONLexer3.scanFieldIntArray(j10);
                                                int i24 = jSONLexer3.matchStat;
                                                if (i24 > 0) {
                                                    i15 = 0;
                                                    z13 = true;
                                                    z12 = true;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap2222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                } else {
                                                    if (i24 == -2) {
                                                    }
                                                    i15 = 0;
                                                    z13 = false;
                                                    z12 = false;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap22222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                }
                                            } else if (cls == float[].class) {
                                                valueOf = jSONLexer3.scanFieldFloatArray(j10);
                                                int i25 = jSONLexer3.matchStat;
                                                if (i25 > 0) {
                                                    i15 = 0;
                                                    z13 = true;
                                                    z12 = true;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap222222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                } else {
                                                    if (i25 == -2) {
                                                    }
                                                    i15 = 0;
                                                    z13 = false;
                                                    z12 = false;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap2222222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                }
                                            } else if (cls == double[].class) {
                                                valueOf = jSONLexer3.scanFieldDoubleArray(j10);
                                                int i26 = jSONLexer3.matchStat;
                                                if (i26 > 0) {
                                                    i15 = 0;
                                                    z13 = true;
                                                    z12 = true;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap22222222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                } else {
                                                    if (i26 == -2) {
                                                    }
                                                    i15 = 0;
                                                    z13 = false;
                                                    z12 = false;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap222222222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                }
                                            } else if (cls == float[][].class) {
                                                valueOf = jSONLexer3.scanFieldFloatArray2(j10);
                                                int i27 = jSONLexer3.matchStat;
                                                if (i27 > 0) {
                                                    i15 = 0;
                                                    z13 = true;
                                                    z12 = true;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap2222222222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                } else {
                                                    if (i27 == -2) {
                                                    }
                                                    i15 = 0;
                                                    z13 = false;
                                                    z12 = false;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap22222222222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                }
                                            } else if (cls == double[][].class) {
                                                valueOf = jSONLexer3.scanFieldDoubleArray2(j10);
                                                int i28 = jSONLexer3.matchStat;
                                                if (i28 > 0) {
                                                    i15 = 0;
                                                    z13 = true;
                                                    z12 = true;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap222222222222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                } else {
                                                    if (i28 == -2) {
                                                    }
                                                    i15 = 0;
                                                    z13 = false;
                                                    z12 = false;
                                                    fieldInfo2 = fieldInfo;
                                                    f10 = 0.0f;
                                                    obj6 = valueOf;
                                                    d10 = 0.0d;
                                                    if (z13) {
                                                    }
                                                    if (obj7 == null) {
                                                    }
                                                    parseContext4 = parseContext2;
                                                    jSONLexer2 = jSONLexer3;
                                                    obj3 = (T) obj7;
                                                    HashMap hashMap2222222222222 = hashMap;
                                                    if (!z13) {
                                                    }
                                                }
                                            } else if (jSONLexer3.matchField(fieldInfo.nameHashCode)) {
                                                i15 = 0;
                                                z13 = true;
                                                z12 = false;
                                                d10 = d12;
                                                fieldInfo2 = fieldInfo;
                                                f10 = f11;
                                                obj6 = null;
                                                if (z13) {
                                                }
                                                if (obj7 == null) {
                                                }
                                                parseContext4 = parseContext2;
                                                jSONLexer2 = jSONLexer3;
                                                obj3 = (T) obj7;
                                                HashMap hashMap22222222222222 = hashMap;
                                                if (!z13) {
                                                }
                                            }
                                            parseContext2 = parseContext3;
                                            c11 = '\r';
                                            javaBeanDeserializer2 = this;
                                            i14 = i13;
                                            parseContext5 = parseContext2;
                                            parseContext = parseContext7;
                                            cls2 = cls3;
                                            jSONLexer = jSONLexer3;
                                            z10 = z11;
                                            obj3 = obj5;
                                            c10 = 16;
                                        }
                                        d12 = jSONLexer3.scanFieldDouble(j10);
                                        int i29 = jSONLexer3.matchStat;
                                        if (i29 > 0) {
                                            i15 = 0;
                                            z13 = true;
                                            z12 = true;
                                            d10 = d12;
                                            fieldInfo2 = fieldInfo;
                                            f10 = f11;
                                            obj6 = null;
                                            if (z13) {
                                            }
                                            if (obj7 == null) {
                                            }
                                            parseContext4 = parseContext2;
                                            jSONLexer2 = jSONLexer3;
                                            obj3 = (T) obj7;
                                            HashMap hashMap222222222222222 = hashMap;
                                            if (!z13) {
                                            }
                                        } else if (i29 == -2) {
                                            parseContext2 = parseContext3;
                                            c11 = '\r';
                                            javaBeanDeserializer2 = this;
                                            i14 = i13;
                                            parseContext5 = parseContext2;
                                            parseContext = parseContext7;
                                            cls2 = cls3;
                                            jSONLexer = jSONLexer3;
                                            z10 = z11;
                                            obj3 = obj5;
                                            c10 = 16;
                                        }
                                    }
                                    f11 = jSONLexer3.scanFieldFloat(j10);
                                    int i30 = jSONLexer3.matchStat;
                                    if (i30 > 0) {
                                        i15 = 0;
                                        z13 = true;
                                        z12 = true;
                                        d10 = d12;
                                        fieldInfo2 = fieldInfo;
                                        f10 = f11;
                                        obj6 = null;
                                        if (z13) {
                                        }
                                        if (obj7 == null) {
                                        }
                                        parseContext4 = parseContext2;
                                        jSONLexer2 = jSONLexer3;
                                        obj3 = (T) obj7;
                                        HashMap hashMap2222222222222222 = hashMap;
                                        if (!z13) {
                                        }
                                    } else if (i30 == -2) {
                                        parseContext2 = parseContext3;
                                        c11 = '\r';
                                        javaBeanDeserializer2 = this;
                                        i14 = i13;
                                        parseContext5 = parseContext2;
                                        parseContext = parseContext7;
                                        cls2 = cls3;
                                        jSONLexer = jSONLexer3;
                                        z10 = z11;
                                        obj3 = obj5;
                                        c10 = 16;
                                    }
                                }
                                valueOf = Boolean.valueOf(jSONLexer3.scanFieldBoolean(j10));
                                int i31 = jSONLexer3.matchStat;
                                if (i31 > 0) {
                                    i15 = 0;
                                    z13 = true;
                                    z12 = true;
                                    fieldInfo2 = fieldInfo;
                                    f10 = 0.0f;
                                    obj6 = valueOf;
                                    d10 = 0.0d;
                                    if (z13) {
                                    }
                                    if (obj7 == null) {
                                    }
                                    parseContext4 = parseContext2;
                                    jSONLexer2 = jSONLexer3;
                                    obj3 = (T) obj7;
                                    HashMap hashMap22222222222222222 = hashMap;
                                    if (!z13) {
                                    }
                                } else {
                                    if (i31 == -2) {
                                        parseContext2 = parseContext3;
                                        c11 = '\r';
                                        javaBeanDeserializer2 = this;
                                        i14 = i13;
                                        parseContext5 = parseContext2;
                                        parseContext = parseContext7;
                                        cls2 = cls3;
                                        jSONLexer = jSONLexer3;
                                        z10 = z11;
                                        obj3 = obj5;
                                        c10 = 16;
                                    }
                                    i15 = 0;
                                    z13 = false;
                                    z12 = false;
                                    fieldInfo2 = fieldInfo;
                                    f10 = 0.0f;
                                    obj6 = valueOf;
                                    d10 = 0.0d;
                                    if (z13) {
                                    }
                                    if (obj7 == null) {
                                    }
                                    parseContext4 = parseContext2;
                                    jSONLexer2 = jSONLexer3;
                                    obj3 = (T) obj7;
                                    HashMap hashMap222222222222222222 = hashMap;
                                    if (!z13) {
                                    }
                                }
                            }
                            i11 = i14 + 1;
                            parseContext7 = parseContext;
                            z17 = z10;
                            length = i12;
                            cls3 = cls2;
                            obj4 = obj3;
                            jSONLexer3 = jSONLexer;
                            type2 = type;
                        }
                        j11 = jSONLexer3.scanFieldLong(j10);
                        int i32 = jSONLexer3.matchStat;
                        if (i32 <= 0) {
                            if (i32 == -2) {
                                parseContext2 = parseContext3;
                                c11 = '\r';
                                javaBeanDeserializer2 = this;
                                i14 = i13;
                                parseContext5 = parseContext2;
                                parseContext = parseContext7;
                                cls2 = cls3;
                                jSONLexer = jSONLexer3;
                                z10 = z11;
                                obj3 = obj5;
                                c10 = 16;
                                i11 = i14 + 1;
                                parseContext7 = parseContext;
                                z17 = z10;
                                length = i12;
                                cls3 = cls2;
                                obj4 = obj3;
                                jSONLexer3 = jSONLexer;
                                type2 = type;
                            }
                        }
                        i15 = 0;
                        z13 = true;
                        z12 = true;
                        d10 = d12;
                        fieldInfo2 = fieldInfo;
                        f10 = f11;
                        obj6 = null;
                        if (z13) {
                        }
                        if (obj7 == null) {
                        }
                        parseContext4 = parseContext2;
                        jSONLexer2 = jSONLexer3;
                        obj3 = (T) obj7;
                        HashMap hashMap2222222222222222222 = hashMap;
                        if (!z13) {
                        }
                        i11 = i14 + 1;
                        parseContext7 = parseContext;
                        z17 = z10;
                        length = i12;
                        cls3 = cls2;
                        obj4 = obj3;
                        jSONLexer3 = jSONLexer;
                        type2 = type;
                    }
                    int scanFieldInt = jSONLexer3.scanFieldInt(j10);
                    int i33 = jSONLexer3.matchStat;
                    if (i33 > 0) {
                        i15 = scanFieldInt;
                        z13 = true;
                        z12 = true;
                        d10 = d12;
                        fieldInfo2 = fieldInfo;
                        f10 = f11;
                        obj6 = null;
                        if (z13) {
                        }
                        if (obj7 == null) {
                        }
                        parseContext4 = parseContext2;
                        jSONLexer2 = jSONLexer3;
                        obj3 = (T) obj7;
                        HashMap hashMap22222222222222222222 = hashMap;
                        if (!z13) {
                        }
                        i11 = i14 + 1;
                        parseContext7 = parseContext;
                        z17 = z10;
                        length = i12;
                        cls3 = cls2;
                        obj4 = obj3;
                        jSONLexer3 = jSONLexer;
                        type2 = type;
                    } else {
                        if (i33 != -2) {
                            i15 = scanFieldInt;
                            z13 = false;
                            z12 = false;
                            d10 = d12;
                            fieldInfo2 = fieldInfo;
                            f10 = f11;
                            obj6 = null;
                            if (z13) {
                            }
                            if (obj7 == null) {
                            }
                            parseContext4 = parseContext2;
                            jSONLexer2 = jSONLexer3;
                            obj3 = (T) obj7;
                            HashMap hashMap222222222222222222222 = hashMap;
                            if (!z13) {
                            }
                            i11 = i14 + 1;
                            parseContext7 = parseContext;
                            z17 = z10;
                            length = i12;
                            cls3 = cls2;
                            obj4 = obj3;
                            jSONLexer3 = jSONLexer;
                            type2 = type;
                        }
                        parseContext2 = parseContext3;
                        c11 = '\r';
                        javaBeanDeserializer2 = this;
                        i14 = i13;
                        parseContext5 = parseContext2;
                        parseContext = parseContext7;
                        cls2 = cls3;
                        jSONLexer = jSONLexer3;
                        z10 = z11;
                        obj3 = obj5;
                        c10 = 16;
                        i11 = i14 + 1;
                        parseContext7 = parseContext;
                        z17 = z10;
                        length = i12;
                        cls3 = cls2;
                        obj4 = obj3;
                        jSONLexer3 = jSONLexer;
                        type2 = type;
                    }
                } else {
                    obj5 = obj4;
                    z11 = z17;
                    parseContext3 = parseContext5;
                }
                i15 = 0;
                z13 = false;
                z12 = false;
                d10 = d12;
                fieldInfo2 = fieldInfo;
                f10 = f11;
                obj6 = null;
                if (z13) {
                }
                if (obj7 == null) {
                }
                parseContext4 = parseContext2;
                jSONLexer2 = jSONLexer3;
                obj3 = (T) obj7;
                HashMap hashMap2222222222222222222222 = hashMap;
                if (!z13) {
                }
                i11 = i14 + 1;
                parseContext7 = parseContext;
                z17 = z10;
                length = i12;
                cls3 = cls2;
                obj4 = obj3;
                jSONLexer3 = jSONLexer;
                type2 = type;
            }
            HashMap hashMap3 = hashMap;
            parseContext5 = parseContext4;
            obj3 = obj3;
            if (obj3 == null) {
                try {
                    if (hashMap3 == null) {
                        T t12 = (T) createInstance(defaultJSONParser, type);
                        if (parseContext5 == null) {
                            try {
                                parseContext5 = defaultJSONParser.setContext(parseContext, t12, obj);
                            } catch (Throwable th16) {
                                th2 = th16;
                                obj3 = t12;
                            }
                        }
                        if (parseContext5 != null) {
                            parseContext5.object = t12;
                        }
                        defaultJSONParser.setContext(parseContext);
                        return t12;
                    }
                    int length2 = javaBeanDeserializer2.fieldDeserializers.length;
                    Object[] objArr = new Object[length2];
                    for (int i34 = 0; i34 < length2; i34++) {
                        objArr[i34] = hashMap3.get(javaBeanDeserializer2.fieldDeserializers[i34].fieldInfo.name);
                    }
                    JavaBeanInfo javaBeanInfo = javaBeanDeserializer2.beanInfo;
                    Constructor<?> constructor = javaBeanInfo.creatorConstructor;
                    if (constructor != null) {
                        try {
                            obj3 = (T) constructor.newInstance(objArr);
                        } catch (Exception e11) {
                            throw new JSONException("create instance error, " + javaBeanDeserializer2.beanInfo.creatorConstructor.toGenericString(), e11);
                        }
                    } else {
                        Method method = javaBeanInfo.factoryMethod;
                        if (method != null) {
                            try {
                                obj3 = (T) method.invoke(null, objArr);
                            } catch (Exception e12) {
                                throw new JSONException("create factory method error, " + javaBeanDeserializer2.beanInfo.factoryMethod.toString(), e12);
                            }
                        }
                    }
                } catch (Throwable th17) {
                    th2 = th17;
                }
            }
            if (parseContext5 != null) {
                parseContext5.object = obj3;
            }
            defaultJSONParser.setContext(parseContext);
            return (T) obj3;
        } else if (jSONLexer3.isBlankInput()) {
            defaultJSONParser.setContext(parseContext7);
            return null;
        } else if (i20 == 4 && jSONLexer3.stringVal().length() == 0) {
            jSONLexer3.nextToken();
            defaultJSONParser.setContext(parseContext7);
            return null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("syntax error, expect {, actual ");
            stringBuffer.append(jSONLexer3.info());
            if (obj instanceof String) {
                stringBuffer.append(", fieldName ");
                stringBuffer.append(obj);
            }
            throw new JSONException(stringBuffer.toString());
        }
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                FieldDeserializer fieldDeserializer = getFieldDeserializer(entry.getKey());
                if (fieldDeserializer != null) {
                    Object value = entry.getValue();
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Method method = fieldInfo.method;
                    if (method != null) {
                        method.invoke(createInstance, TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig));
                    } else {
                        fieldInfo.field.set(createInstance, TypeUtils.cast(value, fieldInfo.fieldType, parserConfig));
                    }
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            objArr[i10] = map.get(fieldInfoArr[i10].name);
        }
        Constructor<?> constructor = this.beanInfo.creatorConstructor;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e10) {
            throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e10);
        }
    }
}
