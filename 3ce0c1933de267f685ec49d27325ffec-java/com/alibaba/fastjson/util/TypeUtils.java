package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.lpa.LpaConstants;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    private static ConcurrentMap<String, Class<?>> mappings = null;
    private static boolean setAccessibleEnable = true;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        mappings = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        mappings.put(HashMap.class.getName(), HashMap.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        T t10;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        int i10 = 0;
                        T t11 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object obj2 : collection) {
                            Array.set(t11, i10, cast(obj2, (Class<Object>) cls.getComponentType(), parserConfig));
                            i10++;
                        }
                        return t11;
                    } else if (cls == byte[].class) {
                        return (T) castToBytes(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return (T) castToBoolean(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return (T) castToByte(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return (T) castToShort(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return (T) castToInt(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return (T) castToLong(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return (T) castToFloat(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return (T) castToDouble(obj);
                }
                if (cls == String.class) {
                    return (T) castToString(obj);
                }
                if (cls == BigDecimal.class) {
                    return (T) castToBigDecimal(obj);
                }
                if (cls == BigInteger.class) {
                    return (T) castToBigInteger(obj);
                }
                if (cls == Date.class) {
                    return (T) castToDate(obj);
                }
                if (cls.isEnum()) {
                    return (T) castToEnum(obj, cls, parserConfig);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date castToDate = castToDate(obj);
                    if (cls == Calendar.class) {
                        t10 = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    } else {
                        try {
                            t10 = (T) ((Calendar) cls.newInstance());
                        } catch (Exception e10) {
                            throw new JSONException("can not cast to : " + cls.getName(), e10);
                        }
                    }
                    ((Calendar) t10).setTime(castToDate);
                    return t10;
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || LpaConstants.VALUE_NULL.equals(str)) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return (T) Currency.getInstance(str);
                    }
                }
                throw new JSONException("can not cast to : " + cls.getName());
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig) : obj;
            }
        }
    }

    public static final BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || LpaConstants.VALUE_NULL.equals(obj2)) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || LpaConstants.VALUE_NULL.equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static final Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z10 = true;
            if (((Number) obj).intValue() != 1) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || LpaConstants.VALUE_NULL.equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || LpaConstants.VALUE_NULL.equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return JSONLexer.decodeFast(str, 0, str.length());
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final Date castToDate(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long j10 = -1;
        if (obj instanceof Number) {
            j10 = ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                    str = JSON.DEFFAULT_DATE_FORMAT;
                } else if (str2.length() == 10) {
                    str = SettingConstants.DATE_FORMAT_DEFAULT;
                } else {
                    str = str2.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss.SSS";
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                try {
                    return simpleDateFormat.parse(str2);
                } catch (ParseException unused) {
                    throw new JSONException("can not cast to Date, value : " + str2);
                }
            } else if (str2.length() == 0 || LpaConstants.VALUE_NULL.equals(str2)) {
                return null;
            } else {
                j10 = Long.parseLong(str2);
            }
        }
        if (j10 >= 0) {
            return new Date(j10);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static final Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || LpaConstants.VALUE_NULL.equals(obj2)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static final <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e10) {
            throw new JSONException("can not cast to : " + cls.getName(), e10);
        }
    }

    public static final Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || LpaConstants.VALUE_NULL.equals(obj2)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static final Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || LpaConstants.VALUE_NULL.equals(str)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class<Object>) cls, ParserConfig.global);
    }

    public static final Long castToLong(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || LpaConstants.VALUE_NULL.equals(str)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                JSONLexer jSONLexer = new JSONLexer(str);
                if (jSONLexer.scanISO8601DateIfMatch(false)) {
                    calendar = jSONLexer.calendar;
                }
                jSONLexer.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static final Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || LpaConstants.VALUE_NULL.equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static final String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01d1, code lost:
        if (r0 == null) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0484  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<FieldInfo> computeGetters(Class<?> cls, int i10, boolean z10, JSONType jSONType, Map<String, String> map, boolean z11, boolean z12, boolean z13, PropertyNamingStrategy propertyNamingStrategy) {
        boolean z14;
        String[] strArr;
        int i11;
        int i12;
        Iterator it;
        Field[] declaredFields;
        Class<? super Object> cls2;
        Method[] methodArr;
        int i13;
        int i14;
        LinkedHashMap linkedHashMap;
        Map<String, String> map2;
        Field[] fieldArr;
        LinkedHashMap linkedHashMap2;
        Field[] fieldArr2;
        int i15;
        int i16;
        Field[] fieldArr3;
        Method method;
        String str;
        String str2;
        PropertyNamingStrategy propertyNamingStrategy2;
        JSONField jSONField;
        int i17;
        int i18;
        String str3;
        int i19;
        int i20;
        JSONField jSONField2;
        Class<?> cls3 = cls;
        int i21 = i10;
        JSONType jSONType2 = jSONType;
        Map<String, String> map3 = map;
        PropertyNamingStrategy propertyNamingStrategy3 = propertyNamingStrategy;
        Class<? super Object> cls4 = Object.class;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Field[] declaredFields2 = cls.getDeclaredFields();
        if (!z10) {
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i22 = 0;
            while (i22 < length) {
                Method method2 = methods[i22];
                String name = method2.getName();
                if ((method2.getModifiers() & 8) == 0 && !method2.getReturnType().equals(Void.TYPE) && method2.getParameterTypes().length == 0 && method2.getReturnType() != ClassLoader.class && method2.getDeclaringClass() != cls4 && (!name.equals("getMetaClass") || !method2.getReturnType().getName().equals("groovy.lang.MetaClass"))) {
                    JSONField jSONField3 = z12 ? (JSONField) method2.getAnnotation(JSONField.class) : null;
                    if (jSONField3 == null && z12) {
                        jSONField3 = getSupperMethodAnnotation(cls3, method2);
                    }
                    JSONField jSONField4 = jSONField3;
                    if (jSONField4 == null) {
                        i14 = i22;
                        i13 = length;
                        methodArr = methods;
                        fieldArr2 = declaredFields2;
                        cls2 = cls4;
                        linkedHashMap2 = linkedHashMap3;
                        i16 = 0;
                        i15 = 0;
                    } else if (jSONField4.serialize()) {
                        i16 = jSONField4.ordinal();
                        i15 = SerializerFeature.of(jSONField4.serialzeFeatures());
                        if (jSONField4.name().length() != 0) {
                            String name2 = jSONField4.name();
                            if (map3 == null || (name2 = map3.get(name2)) != null) {
                                String str4 = name2;
                                setAccessible(cls3, method2, i21);
                                i14 = i22;
                                i13 = length;
                                methodArr = methods;
                                fieldArr2 = declaredFields2;
                                linkedHashMap2 = linkedHashMap3;
                                cls2 = cls4;
                                linkedHashMap2.put(str4, new FieldInfo(str4, method2, null, cls, null, i16, i15, jSONField4, null, true));
                                map2 = map3;
                                fieldArr = fieldArr2;
                                linkedHashMap = linkedHashMap2;
                                i22 = i14 + 1;
                                cls3 = cls;
                                propertyNamingStrategy3 = propertyNamingStrategy;
                                declaredFields2 = fieldArr;
                                linkedHashMap3 = linkedHashMap;
                                length = i13;
                                methods = methodArr;
                                cls4 = cls2;
                                i21 = i10;
                                map3 = map2;
                                jSONType2 = jSONType;
                            }
                        } else {
                            i14 = i22;
                            i13 = length;
                            methodArr = methods;
                            fieldArr2 = declaredFields2;
                            cls2 = cls4;
                            linkedHashMap2 = linkedHashMap3;
                        }
                    }
                    if (name.startsWith("get")) {
                        if (name.length() >= 4) {
                            if (!name.equals("getClass")) {
                                char charAt = name.charAt(3);
                                if (Character.isUpperCase(charAt)) {
                                    str3 = compatibleWithJavaBean ? decapitalize(name.substring(3)) : Character.toLowerCase(name.charAt(3)) + name.substring(4);
                                } else if (charAt == '_') {
                                    str3 = name.substring(4);
                                } else if (charAt == 'f') {
                                    str3 = name.substring(3);
                                } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                    str3 = decapitalize(name.substring(3));
                                }
                                if (!isJSONTypeIgnore(cls3, jSONType2, str3)) {
                                    Field[] fieldArr4 = fieldArr2;
                                    Field field = getField(cls3, str3, fieldArr4);
                                    if (field != null) {
                                        JSONField jSONField5 = z12 ? (JSONField) field.getAnnotation(JSONField.class) : null;
                                        if (jSONField5 != null) {
                                            if (jSONField5.serialize()) {
                                                int ordinal = jSONField5.ordinal();
                                                i19 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                if (jSONField5.name().length() != 0) {
                                                    str3 = jSONField5.name();
                                                    if (map3 != null) {
                                                        str3 = map3.get(str3);
                                                    }
                                                }
                                                i20 = ordinal;
                                            }
                                            fieldArr = fieldArr4;
                                            map2 = map3;
                                            linkedHashMap = linkedHashMap2;
                                            i22 = i14 + 1;
                                            cls3 = cls;
                                            propertyNamingStrategy3 = propertyNamingStrategy;
                                            declaredFields2 = fieldArr;
                                            linkedHashMap3 = linkedHashMap;
                                            length = i13;
                                            methods = methodArr;
                                            cls4 = cls2;
                                            i21 = i10;
                                            map3 = map2;
                                            jSONType2 = jSONType;
                                        } else {
                                            i19 = i15;
                                            i20 = i16;
                                        }
                                        jSONField2 = jSONField5;
                                    } else {
                                        i19 = i15;
                                        i20 = i16;
                                        jSONField2 = null;
                                    }
                                    if (propertyNamingStrategy3 != null) {
                                        str3 = propertyNamingStrategy3.translate(str3);
                                    }
                                    if (map3 == null || (str3 = map3.get(str3)) != null) {
                                        String str5 = str3;
                                        setAccessible(cls3, method2, i21);
                                        str = name;
                                        method = method2;
                                        fieldArr3 = fieldArr4;
                                        linkedHashMap = linkedHashMap2;
                                        linkedHashMap.put(str5, new FieldInfo(str5, method2, field, cls, null, i20, i19, jSONField4, jSONField2, z13));
                                        i16 = i20;
                                        i15 = i19;
                                    }
                                    fieldArr = fieldArr4;
                                    map2 = map3;
                                    linkedHashMap = linkedHashMap2;
                                    i22 = i14 + 1;
                                    cls3 = cls;
                                    propertyNamingStrategy3 = propertyNamingStrategy;
                                    declaredFields2 = fieldArr;
                                    linkedHashMap3 = linkedHashMap;
                                    length = i13;
                                    methods = methodArr;
                                    cls4 = cls2;
                                    i21 = i10;
                                    map3 = map2;
                                    jSONType2 = jSONType;
                                }
                            }
                            map2 = map3;
                            fieldArr = fieldArr2;
                            linkedHashMap = linkedHashMap2;
                            i22 = i14 + 1;
                            cls3 = cls;
                            propertyNamingStrategy3 = propertyNamingStrategy;
                            declaredFields2 = fieldArr;
                            linkedHashMap3 = linkedHashMap;
                            length = i13;
                            methods = methodArr;
                            cls4 = cls2;
                            i21 = i10;
                            map3 = map2;
                            jSONType2 = jSONType;
                        }
                        map2 = map;
                        linkedHashMap = linkedHashMap2;
                        fieldArr = fieldArr2;
                        i22 = i14 + 1;
                        cls3 = cls;
                        propertyNamingStrategy3 = propertyNamingStrategy;
                        declaredFields2 = fieldArr;
                        linkedHashMap3 = linkedHashMap;
                        length = i13;
                        methods = methodArr;
                        cls4 = cls2;
                        i21 = i10;
                        map3 = map2;
                        jSONType2 = jSONType;
                    } else {
                        str = name;
                        method = method2;
                        linkedHashMap = linkedHashMap2;
                        fieldArr3 = fieldArr2;
                    }
                    if (str.startsWith("is") && str.length() >= 3) {
                        char charAt2 = str.charAt(2);
                        if (Character.isUpperCase(charAt2)) {
                            str2 = compatibleWithJavaBean ? decapitalize(str.substring(2)) : Character.toLowerCase(str.charAt(2)) + str.substring(3);
                        } else if (charAt2 == '_') {
                            str2 = str.substring(3);
                        } else if (charAt2 == 'f') {
                            str2 = str.substring(2);
                        }
                        fieldArr = fieldArr3;
                        Field field2 = getField(cls3, str2, fieldArr);
                        if (field2 == null) {
                            field2 = getField(cls3, str, fieldArr);
                        }
                        Field field3 = field2;
                        if (field3 != null) {
                            JSONField jSONField6 = z12 ? (JSONField) field3.getAnnotation(JSONField.class) : null;
                            if (jSONField6 != null) {
                                if (!jSONField6.serialize()) {
                                    map2 = map;
                                } else {
                                    int ordinal2 = jSONField6.ordinal();
                                    i17 = SerializerFeature.of(jSONField6.serialzeFeatures());
                                    if (jSONField6.name().length() != 0) {
                                        str2 = jSONField6.name();
                                        map2 = map;
                                        if (map2 != null && (str2 = map2.get(str2)) == null) {
                                        }
                                    } else {
                                        map2 = map;
                                    }
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    jSONField = jSONField6;
                                    i18 = ordinal2;
                                    if (propertyNamingStrategy2 != null) {
                                        str2 = propertyNamingStrategy2.translate(str2);
                                    }
                                    if (map2 != null || (str2 = map2.get(str2)) != null) {
                                        String str6 = str2;
                                        setAccessible(cls3, field3, i10);
                                        Method method3 = method;
                                        setAccessible(cls3, method3, i10);
                                        linkedHashMap.put(str6, new FieldInfo(str6, method3, field3, cls, null, i18, i17, jSONField4, jSONField, z13));
                                    }
                                }
                                i22 = i14 + 1;
                                cls3 = cls;
                                propertyNamingStrategy3 = propertyNamingStrategy;
                                declaredFields2 = fieldArr;
                                linkedHashMap3 = linkedHashMap;
                                length = i13;
                                methods = methodArr;
                                cls4 = cls2;
                                i21 = i10;
                                map3 = map2;
                                jSONType2 = jSONType;
                            } else {
                                map2 = map;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                jSONField = jSONField6;
                            }
                        } else {
                            map2 = map;
                            propertyNamingStrategy2 = propertyNamingStrategy;
                            jSONField = null;
                        }
                        i18 = i16;
                        i17 = i15;
                        if (propertyNamingStrategy2 != null) {
                        }
                        if (map2 != null) {
                        }
                        String str62 = str2;
                        setAccessible(cls3, field3, i10);
                        Method method32 = method;
                        setAccessible(cls3, method32, i10);
                        linkedHashMap.put(str62, new FieldInfo(str62, method32, field3, cls, null, i18, i17, jSONField4, jSONField, z13));
                        i22 = i14 + 1;
                        cls3 = cls;
                        propertyNamingStrategy3 = propertyNamingStrategy;
                        declaredFields2 = fieldArr;
                        linkedHashMap3 = linkedHashMap;
                        length = i13;
                        methods = methodArr;
                        cls4 = cls2;
                        i21 = i10;
                        map3 = map2;
                        jSONType2 = jSONType;
                    }
                    map2 = map;
                    fieldArr = fieldArr3;
                    i22 = i14 + 1;
                    cls3 = cls;
                    propertyNamingStrategy3 = propertyNamingStrategy;
                    declaredFields2 = fieldArr;
                    linkedHashMap3 = linkedHashMap;
                    length = i13;
                    methods = methodArr;
                    cls4 = cls2;
                    i21 = i10;
                    map3 = map2;
                    jSONType2 = jSONType;
                }
                i14 = i22;
                i13 = length;
                methodArr = methods;
                fieldArr = declaredFields2;
                cls2 = cls4;
                map2 = map3;
                linkedHashMap = linkedHashMap3;
                i22 = i14 + 1;
                cls3 = cls;
                propertyNamingStrategy3 = propertyNamingStrategy;
                declaredFields2 = fieldArr;
                linkedHashMap3 = linkedHashMap;
                length = i13;
                methods = methodArr;
                cls4 = cls2;
                i21 = i10;
                map3 = map2;
                jSONType2 = jSONType;
            }
        }
        Field[] fieldArr5 = declaredFields2;
        Class<? super Object> cls5 = cls4;
        Map<String, String> map4 = map3;
        LinkedHashMap linkedHashMap4 = linkedHashMap3;
        ArrayList arrayList = new ArrayList(fieldArr5.length);
        for (Field field4 : fieldArr5) {
            if ((field4.getModifiers() & 8) == 0 && !field4.getName().equals("this$0") && (field4.getModifiers() & 1) != 0) {
                arrayList.add(field4);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            Class<? super Object> cls6 = cls5;
            if (superclass == cls6) {
                break;
            }
            for (Field field5 : superclass.getDeclaredFields()) {
                if ((field5.getModifiers() & 8) == 0 && (field5.getModifiers() & 1) != 0) {
                    arrayList.add(field5);
                }
            }
            superclass = superclass.getSuperclass();
            cls5 = cls6;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Field field6 = (Field) it2.next();
            JSONField jSONField7 = z12 ? (JSONField) field6.getAnnotation(JSONField.class) : null;
            String name3 = field6.getName();
            if (jSONField7 == null) {
                i11 = 0;
                i12 = 0;
            } else if (jSONField7.serialize()) {
                int ordinal3 = jSONField7.ordinal();
                i12 = SerializerFeature.of(jSONField7.serialzeFeatures());
                if (jSONField7.name().length() != 0) {
                    name3 = jSONField7.name();
                }
                i11 = ordinal3;
            }
            if (map4 == null || (name3 = map4.get(name3)) != null) {
                if (propertyNamingStrategy != null) {
                    name3 = propertyNamingStrategy.translate(name3);
                }
                String str7 = name3;
                if (!linkedHashMap4.containsKey(str7)) {
                    setAccessible(cls, field6, i10);
                    it = it2;
                    linkedHashMap4.put(str7, new FieldInfo(str7, null, field6, cls, null, i11, i12, null, jSONField7, z13));
                } else {
                    it = it2;
                }
                it2 = it;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (jSONType != null) {
            strArr = jSONType.orders();
            if (strArr != null && strArr.length == linkedHashMap4.size()) {
                for (String str8 : strArr) {
                    if (linkedHashMap4.containsKey(str8)) {
                    }
                }
                z14 = true;
                if (!z14) {
                    for (String str9 : strArr) {
                        arrayList2.add((FieldInfo) linkedHashMap4.get(str9));
                    }
                } else {
                    for (FieldInfo fieldInfo : linkedHashMap4.values()) {
                        arrayList2.add(fieldInfo);
                    }
                    if (z11) {
                        Collections.sort(arrayList2);
                    }
                }
                return arrayList2;
            }
        } else {
            strArr = null;
        }
        z14 = false;
        if (!z14) {
        }
        return arrayList2;
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        return Object.class;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        Field field0 = getField0(cls, str, fieldArr);
        if (field0 == null) {
            field0 = getField0(cls, "_" + str, fieldArr);
        }
        if (field0 == null) {
            field0 = getField0(cls, "m_" + str, fieldArr);
        }
        if (field0 != null) {
            return field0;
        }
        return getField0(cls, "m" + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr);
    }

    private static Field getField0(Class<?> cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    public static Type getGenericParamType(Type type) {
        return type instanceof Class ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static JSONField getSupperMethodAnnotation(Class<?> cls, Method method) {
        Method[] methods;
        boolean z10;
        JSONField jSONField;
        Method[] methods2;
        boolean z11;
        JSONField jSONField2;
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length != parameterTypes2.length) {
                        continue;
                    } else {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= parameterTypes.length) {
                                z11 = true;
                                break;
                            } else if (!parameterTypes[i10].equals(parameterTypes2[i10])) {
                                z11 = false;
                                break;
                            } else {
                                i10++;
                            }
                        }
                        if (z11 && (jSONField2 = (JSONField) method2.getAnnotation(JSONField.class)) != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= parameterTypes3.length) {
                            z10 = true;
                            break;
                        } else if (!parameterTypes4[i11].equals(parameterTypes3[i11])) {
                            z10 = false;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (z10 && (jSONField = (JSONField) method3.getAnnotation(JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isGenericParamType(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        return genericSuperclass != Object.class && isGenericParamType(genericSuperclass);
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, JSONType jSONType, String str) {
        if (!(jSONType == null || jSONType.ignores() == null)) {
            for (String str2 : jSONType.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !isJSONTypeIgnore(superclass, (JSONType) superclass.getAnnotation(JSONType.class), str)) ? false : true;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        Class<?> cls;
        Exception e10;
        if (str == null || str.length() == 0) {
            return null;
        }
        Class<?> cls2 = mappings.get(str);
        if (cls2 != null) {
            return cls2;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return loadClass(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                cls2 = classLoader.loadClass(str);
                mappings.put(str, cls2);
                return cls2;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                cls = contextClassLoader.loadClass(str);
                try {
                    mappings.put(str, cls);
                    return cls;
                } catch (Exception e12) {
                    e10 = e12;
                    e10.printStackTrace();
                    cls2 = cls;
                    cls2 = Class.forName(str);
                    mappings.put(str, cls2);
                    return cls2;
                }
            }
        } catch (Exception e13) {
            e10 = e13;
            cls = cls2;
        }
        try {
            cls2 = Class.forName(str);
            mappings.put(str, cls2);
            return cls2;
        } catch (Exception e14) {
            e14.printStackTrace();
            return cls2;
        }
    }

    public static boolean setAccessible(Class<?> cls, Member member, int i10) {
        if (member != null && setAccessibleEnable) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i10 & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
        return false;
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        JSONObject jSONObject;
        int i10 = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i10 = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, i10);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            JavaBeanDeserializer javaBeanDeserializer = null;
            if (obj instanceof String) {
                String str4 = (String) obj;
                Class<?> loadClass = loadClass(str4, null);
                if (loadClass == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                } else if (!loadClass.equals(cls)) {
                    return (T) castToJavaBean(map, loadClass, parserConfig);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    jSONObject = (JSONObject) map;
                } else {
                    jSONObject = new JSONObject(map);
                }
                return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (parserConfig == null) {
                parserConfig = ParserConfig.global;
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
            }
            if (javaBeanDeserializer != null) {
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
            throw new JSONException("can not get javaBeanDeserializer");
        } catch (Exception e10) {
            throw new JSONException(e10.getMessage(), e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class<Object>) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || LpaConstants.VALUE_NULL.equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.util.Map, java.util.HashMap] */
    public static final <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t10;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == Set.class || rawType == HashSet.class) {
                    t10 = (T) new HashSet();
                } else if (rawType == TreeSet.class) {
                    t10 = (T) new TreeSet();
                } else {
                    t10 = (T) new ArrayList();
                }
                for (T t11 : (Iterable) obj) {
                    ((Collection) t10).add(cast(t11, type, parserConfig));
                }
                return t10;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r72 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r72.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return r72;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || LpaConstants.VALUE_NULL.equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }
}
