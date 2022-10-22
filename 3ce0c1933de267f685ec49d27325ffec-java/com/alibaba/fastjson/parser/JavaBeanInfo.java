package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class JavaBeanInfo {
    final Constructor<?> creatorConstructor;
    final Constructor<?> defaultConstructor;
    final int defaultConstructorParameterSize;
    final Method factoryMethod;
    final FieldInfo[] fields;
    final JSONType jsonType;
    boolean ordered = false;
    public final int parserFeatures;
    final FieldInfo[] sortedFields;
    final boolean supportBeanToArray;
    public final String typeName;

    JavaBeanInfo(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2, JSONType jSONType) {
        int i10;
        boolean z10;
        int i11 = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = fieldInfoArr;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String typeName = jSONType.typeName();
            if (typeName.length() != 0) {
                this.typeName = typeName;
            } else {
                this.typeName = cls.getName();
            }
            i10 = 0;
            for (Feature feature : jSONType.parseFeatures()) {
                i10 |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            i10 = 0;
        }
        this.parserFeatures = i10;
        if (jSONType != null) {
            Feature[] parseFeatures = jSONType.parseFeatures();
            z10 = false;
            for (Feature feature2 : parseFeatures) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z10 = true;
                }
            }
        } else {
            z10 = false;
        }
        this.supportBeanToArray = z10;
        FieldInfo[] computeSortedFields = computeSortedFields(fieldInfoArr, fieldInfoArr2);
        this.sortedFields = !Arrays.equals(fieldInfoArr, computeSortedFields) ? computeSortedFields : fieldInfoArr;
        this.defaultConstructorParameterSize = constructor != null ? constructor.getParameterTypes().length : i11;
    }

    static boolean addField(List<FieldInfo> list, FieldInfo fieldInfo, boolean z10) {
        if (!z10) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                FieldInfo fieldInfo2 = list.get(i10);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:272:0x05dd, code lost:
        if (r1.length() > 0) goto L274;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0404  */
    /* JADX WARN: Type inference failed for: r0v76, types: [java.lang.reflect.Type[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JavaBeanInfo build(Class<?> cls, int i10, Type type, boolean z10, boolean z11, boolean z12, boolean z13, PropertyNamingStrategy propertyNamingStrategy) {
        Constructor<?> constructor;
        Constructor<?> constructor2;
        Constructor<?>[] declaredConstructors;
        int i11;
        int i12;
        String str;
        PropertyNamingStrategy propertyNamingStrategy2;
        int i13;
        int i14;
        Field[] declaredFields;
        Class<? super Object> cls2;
        int i15;
        int i16;
        Field[] fieldArr;
        int i17;
        Constructor<?> constructor3;
        Method[] methodArr;
        ArrayList arrayList;
        Class<?> returnType;
        ArrayList arrayList2;
        int i18;
        Method method;
        int i19;
        char c10;
        String str2;
        int i20;
        JSONField jSONField;
        int i21;
        int i22;
        Constructor<?> constructor4;
        Method method2;
        JSONField jSONField2;
        JSONField jSONField3;
        ArrayList arrayList3 = new ArrayList();
        int i23 = i10 & 1024;
        int i24 = 1;
        int i25 = 0;
        if (i23 == 0) {
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
            } catch (Exception unused) {
                constructor = null;
            }
            if (constructor == null && cls.isMemberClass() && (i10 & 8) == 0) {
                for (Constructor<?> constructor5 : cls.getDeclaredConstructors()) {
                    Class<?>[] parameterTypes = constructor5.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                        constructor2 = constructor5;
                        break;
                    }
                }
            }
            constructor2 = constructor;
        } else {
            constructor2 = null;
        }
        Method[] methods = z10 ? null : cls.getMethods();
        Field[] declaredFields2 = cls.getDeclaredFields();
        if (constructor2 == null && !cls.isInterface() && i23 == 0) {
            Constructor<?>[] declaredConstructors2 = cls.getDeclaredConstructors();
            int length = declaredConstructors2.length;
            int i26 = 0;
            while (true) {
                if (i26 >= length) {
                    constructor4 = null;
                    break;
                }
                Constructor<?> constructor6 = declaredConstructors2[i26];
                if (((JSONCreator) constructor6.getAnnotation(JSONCreator.class)) != null) {
                    constructor4 = constructor6;
                    break;
                }
                i26++;
            }
            if (constructor4 != null) {
                TypeUtils.setAccessible(cls, constructor4, i10);
                Class<?>[] parameterTypes2 = constructor4.getParameterTypes();
                Class<?>[] genericParameterTypes = z13 ? constructor4.getGenericParameterTypes() : parameterTypes2;
                int i27 = 0;
                while (i27 < parameterTypes2.length) {
                    Annotation[] annotationArr = constructor4.getParameterAnnotations()[i27];
                    int length2 = annotationArr.length;
                    int i28 = i25;
                    while (true) {
                        if (i28 >= length2) {
                            jSONField3 = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i28];
                        if (annotation instanceof JSONField) {
                            jSONField3 = (JSONField) annotation;
                            break;
                        }
                        i28++;
                    }
                    if (jSONField3 != null) {
                        Class<?> cls3 = parameterTypes2[i27];
                        Class<?> cls4 = genericParameterTypes[i27];
                        Field field = TypeUtils.getField(cls, jSONField3.name(), declaredFields2);
                        if (field != null) {
                            TypeUtils.setAccessible(cls, field, i10);
                        }
                        declaredFields2 = declaredFields2;
                        parameterTypes2 = parameterTypes2;
                        addField(arrayList3, new FieldInfo(jSONField3.name(), cls, cls3, cls4, field, jSONField3.ordinal(), SerializerFeature.of(jSONField3.serialzeFeatures())), z10);
                        i27++;
                        i25 = 0;
                    } else {
                        throw new JSONException("illegal json creator");
                    }
                }
                int size = arrayList3.size();
                FieldInfo[] fieldInfoArr = new FieldInfo[size];
                arrayList3.toArray(fieldInfoArr);
                FieldInfo[] fieldInfoArr2 = new FieldInfo[size];
                System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, size);
                Arrays.sort(fieldInfoArr2);
                return new JavaBeanInfo(cls, null, constructor4, null, fieldInfoArr, fieldInfoArr2, z11 ? (JSONType) cls.getAnnotation(JSONType.class) : null);
            }
            int length3 = methods.length;
            int i29 = 0;
            while (true) {
                if (i29 >= length3) {
                    method2 = null;
                    break;
                }
                Method method3 = methods[i29];
                if (Modifier.isStatic(method3.getModifiers()) && cls.isAssignableFrom(method3.getReturnType()) && ((JSONCreator) method3.getAnnotation(JSONCreator.class)) != null) {
                    method2 = method3;
                    break;
                }
                i29++;
            }
            if (method2 != null) {
                TypeUtils.setAccessible(cls, method2, i10);
                Class<?>[] parameterTypes3 = method2.getParameterTypes();
                Class<?>[] genericParameterTypes2 = z13 ? method2.getGenericParameterTypes() : parameterTypes3;
                for (int i30 = 0; i30 < parameterTypes3.length; i30++) {
                    Annotation[] annotationArr2 = method2.getParameterAnnotations()[i30];
                    int length4 = annotationArr2.length;
                    int i31 = 0;
                    while (true) {
                        if (i31 >= length4) {
                            jSONField2 = null;
                            break;
                        }
                        Annotation annotation2 = annotationArr2[i31];
                        if (annotation2 instanceof JSONField) {
                            jSONField2 = (JSONField) annotation2;
                            break;
                        }
                        i31++;
                    }
                    if (jSONField2 != null) {
                        parameterTypes3 = parameterTypes3;
                        addField(arrayList3, new FieldInfo(jSONField2.name(), cls, parameterTypes3[i30], genericParameterTypes2[i30], TypeUtils.getField(cls, jSONField2.name(), declaredFields2), jSONField2.ordinal(), SerializerFeature.of(jSONField2.serialzeFeatures())), z10);
                    } else {
                        throw new JSONException("illegal json creator");
                    }
                }
                int size2 = arrayList3.size();
                FieldInfo[] fieldInfoArr3 = new FieldInfo[size2];
                arrayList3.toArray(fieldInfoArr3);
                FieldInfo[] fieldInfoArr4 = new FieldInfo[size2];
                System.arraycopy(fieldInfoArr3, 0, fieldInfoArr4, 0, size2);
                Arrays.sort(fieldInfoArr4);
                return new JavaBeanInfo(cls, null, null, method2, fieldInfoArr3, Arrays.equals(fieldInfoArr3, fieldInfoArr4) ? fieldInfoArr3 : fieldInfoArr4, z11 ? (JSONType) cls.getAnnotation(JSONType.class) : null);
            }
            throw new JSONException("default constructor not found. " + cls);
        }
        Class<? super Object> cls5 = Object.class;
        Field[] fieldArr2 = declaredFields2;
        if (constructor2 != null) {
            TypeUtils.setAccessible(cls, constructor2, i10);
        }
        int i32 = 4;
        if (!z10) {
            int length5 = methods.length;
            int i33 = 0;
            while (i33 < length5) {
                Method method4 = methods[i33];
                String name = method4.getName();
                if (name.length() >= i32 && !Modifier.isStatic(method4.getModifiers()) && (((returnType = method4.getReturnType()) == Void.TYPE || returnType == method4.getDeclaringClass()) && method4.getParameterTypes().length == i24 && method4.getDeclaringClass() != cls5)) {
                    JSONField jSONField4 = z12 ? (JSONField) method4.getAnnotation(JSONField.class) : null;
                    if (jSONField4 == null && z12) {
                        jSONField4 = TypeUtils.getSupperMethodAnnotation(cls, method4);
                    }
                    JSONField jSONField5 = jSONField4;
                    if (jSONField5 == null) {
                        i16 = i33;
                        i15 = length5;
                        methodArr = methods;
                        constructor3 = constructor2;
                        cls2 = cls5;
                        arrayList2 = arrayList3;
                        method = method4;
                        i19 = 0;
                        i18 = 0;
                    } else if (jSONField5.deserialize()) {
                        int ordinal = jSONField5.ordinal();
                        i18 = SerializerFeature.of(jSONField5.serialzeFeatures());
                        if (jSONField5.name().length() != 0) {
                            i16 = i33;
                            i15 = length5;
                            methodArr = methods;
                            constructor3 = constructor2;
                            cls2 = cls5;
                            arrayList2 = arrayList3;
                            addField(arrayList2, new FieldInfo(jSONField5.name(), method4, null, cls, type, ordinal, i18, jSONField5, null, z13), z10);
                            TypeUtils.setAccessible(cls, method4, i10);
                            fieldArr = fieldArr2;
                            i17 = 1;
                            arrayList = arrayList2;
                            i33 = i16 + 1;
                            arrayList3 = arrayList;
                            methods = methodArr;
                            constructor2 = constructor3;
                            i24 = i17;
                            fieldArr2 = fieldArr;
                            length5 = i15;
                            cls5 = cls2;
                            i32 = 4;
                        } else {
                            i16 = i33;
                            i15 = length5;
                            methodArr = methods;
                            constructor3 = constructor2;
                            cls2 = cls5;
                            arrayList2 = arrayList3;
                            method = method4;
                            i19 = ordinal;
                        }
                    }
                    if (name.startsWith("set")) {
                        char charAt = name.charAt(3);
                        if (!Character.isUpperCase(charAt)) {
                            c10 = 4;
                            if (charAt == '_') {
                                str2 = name.substring(4);
                            } else if (charAt == 'f') {
                                str2 = name.substring(3);
                            } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                str2 = TypeUtils.decapitalize(name.substring(3));
                            }
                        } else if (TypeUtils.compatibleWithJavaBean) {
                            str2 = TypeUtils.decapitalize(name.substring(3));
                            c10 = 4;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(Character.toLowerCase(name.charAt(3)));
                            c10 = 4;
                            sb2.append(name.substring(4));
                            str2 = sb2.toString();
                        }
                        Field field2 = TypeUtils.getField(cls, str2, fieldArr2);
                        if (field2 != null) {
                            i20 = 1;
                        } else if (method.getParameterTypes()[0] == Boolean.TYPE) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("is");
                            sb3.append(Character.toUpperCase(str2.charAt(0)));
                            i20 = 1;
                            sb3.append(str2.substring(1));
                            field2 = TypeUtils.getField(cls, sb3.toString(), fieldArr2);
                        } else {
                            i20 = 1;
                        }
                        Field field3 = field2;
                        if (field3 != null) {
                            JSONField jSONField6 = z12 ? (JSONField) field3.getAnnotation(JSONField.class) : null;
                            if (jSONField6 != null) {
                                int ordinal2 = jSONField6.ordinal();
                                int of2 = SerializerFeature.of(jSONField6.serialzeFeatures());
                                if (jSONField6.name().length() != 0) {
                                    i17 = i20;
                                    fieldArr = fieldArr2;
                                    addField(arrayList2, new FieldInfo(jSONField6.name(), method, field3, cls, type, ordinal2, of2, jSONField5, jSONField6, z13), z10);
                                    arrayList = arrayList2;
                                    i33 = i16 + 1;
                                    arrayList3 = arrayList;
                                    methods = methodArr;
                                    constructor2 = constructor3;
                                    i24 = i17;
                                    fieldArr2 = fieldArr;
                                    length5 = i15;
                                    cls5 = cls2;
                                    i32 = 4;
                                } else {
                                    i17 = i20;
                                    fieldArr = fieldArr2;
                                    i22 = ordinal2;
                                    arrayList = arrayList2;
                                    jSONField = jSONField5 == null ? jSONField6 : jSONField5;
                                    i21 = of2;
                                    if (propertyNamingStrategy != null) {
                                        str2 = propertyNamingStrategy.translate(str2);
                                    }
                                    addField(arrayList, new FieldInfo(str2, method, null, cls, type, i22, i21, jSONField, null, z13), z10);
                                    TypeUtils.setAccessible(cls, method, i10);
                                    i33 = i16 + 1;
                                    arrayList3 = arrayList;
                                    methods = methodArr;
                                    constructor2 = constructor3;
                                    i24 = i17;
                                    fieldArr2 = fieldArr;
                                    length5 = i15;
                                    cls5 = cls2;
                                    i32 = 4;
                                }
                            }
                        }
                        i17 = i20;
                        fieldArr = fieldArr2;
                        i22 = i19;
                        arrayList = arrayList2;
                        jSONField = jSONField5;
                        i21 = i18;
                        if (propertyNamingStrategy != null) {
                        }
                        addField(arrayList, new FieldInfo(str2, method, null, cls, type, i22, i21, jSONField, null, z13), z10);
                        TypeUtils.setAccessible(cls, method, i10);
                        i33 = i16 + 1;
                        arrayList3 = arrayList;
                        methods = methodArr;
                        constructor2 = constructor3;
                        i24 = i17;
                        fieldArr2 = fieldArr;
                        length5 = i15;
                        cls5 = cls2;
                        i32 = 4;
                    }
                    fieldArr = fieldArr2;
                    i17 = 1;
                    arrayList = arrayList2;
                    i33 = i16 + 1;
                    arrayList3 = arrayList;
                    methods = methodArr;
                    constructor2 = constructor3;
                    i24 = i17;
                    fieldArr2 = fieldArr;
                    length5 = i15;
                    cls5 = cls2;
                    i32 = 4;
                }
                i16 = i33;
                i15 = length5;
                methodArr = methods;
                constructor3 = constructor2;
                cls2 = cls5;
                i17 = i24;
                fieldArr = fieldArr2;
                arrayList = arrayList3;
                i33 = i16 + 1;
                arrayList3 = arrayList;
                methods = methodArr;
                constructor2 = constructor3;
                i24 = i17;
                fieldArr2 = fieldArr;
                length5 = i15;
                cls5 = cls2;
                i32 = 4;
            }
        }
        Constructor<?> constructor7 = constructor2;
        Class<? super Object> cls6 = cls5;
        int i34 = i24;
        Field[] fieldArr3 = fieldArr2;
        ArrayList arrayList4 = arrayList3;
        ArrayList<Field> arrayList5 = new ArrayList(fieldArr3.length);
        for (Field field4 : fieldArr3) {
            int modifiers = field4.getModifiers();
            if ((modifiers & 8) == 0) {
                if ((modifiers & 16) != 0) {
                    Class<?> type2 = field4.getType();
                    if (((Map.class.isAssignableFrom(type2) || Collection.class.isAssignableFrom(type2)) ? i34 : 0) == 0) {
                    }
                }
                if ((field4.getModifiers() & 1) != 0) {
                    arrayList5.add(field4);
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            Class<? super Object> cls7 = cls6;
            if (superclass == cls7) {
                break;
            }
            for (Field field5 : superclass.getDeclaredFields()) {
                int modifiers2 = field5.getModifiers();
                if ((modifiers2 & 8) == 0) {
                    if ((modifiers2 & 16) != 0) {
                        Class<?> type3 = field5.getType();
                        if (((Map.class.isAssignableFrom(type3) || Collection.class.isAssignableFrom(type3)) ? i34 : 0) == 0) {
                        }
                    }
                    if ((modifiers2 & 1) != 0) {
                        arrayList5.add(field5);
                    }
                }
            }
            superclass = superclass.getSuperclass();
            cls6 = cls7;
        }
        for (Field field6 : arrayList5) {
            String name2 = field6.getName();
            int size3 = arrayList4.size();
            int i35 = 0;
            for (int i36 = 0; i36 < size3; i36++) {
                if (((FieldInfo) arrayList4.get(i36)).name.equals(name2)) {
                    i35 = i34;
                }
            }
            if (i35 == 0) {
                JSONField jSONField7 = z12 ? (JSONField) field6.getAnnotation(JSONField.class) : null;
                if (jSONField7 != null) {
                    int ordinal3 = jSONField7.ordinal();
                    i13 = SerializerFeature.of(jSONField7.serialzeFeatures());
                    if (jSONField7.name().length() != 0) {
                        name2 = jSONField7.name();
                    }
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    i14 = ordinal3;
                } else {
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    i14 = 0;
                    i13 = 0;
                }
                if (propertyNamingStrategy2 != null) {
                    name2 = propertyNamingStrategy2.translate(name2);
                }
                TypeUtils.setAccessible(cls, field6, i10);
                addField(arrayList4, new FieldInfo(name2, null, field6, cls, type, i14, i13, null, jSONField7, z13), z10);
            }
        }
        if (!z10) {
            Method[] methods2 = cls.getMethods();
            int length6 = methods2.length;
            int i37 = 0;
            while (i37 < length6) {
                Method method5 = methods2[i37];
                String name3 = method5.getName();
                if (name3.length() < 4 || Modifier.isStatic(method5.getModifiers()) || !name3.startsWith("get")) {
                    i12 = i37;
                    i11 = length6;
                } else {
                    if (Character.isUpperCase(name3.charAt(3)) && method5.getParameterTypes().length == 0) {
                        Class<?> returnType2 = method5.getReturnType();
                        if (Collection.class.isAssignableFrom(returnType2) || Map.class.isAssignableFrom(returnType2)) {
                            JSONField jSONField8 = z12 ? (JSONField) method5.getAnnotation(JSONField.class) : null;
                            if (jSONField8 != null) {
                                str = jSONField8.name();
                            }
                            str = Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                            JSONField jSONField9 = jSONField8;
                            i12 = i37;
                            i11 = length6;
                            addField(arrayList4, new FieldInfo(str, method5, null, cls, type, 0, 0, jSONField9, null, z13), z10);
                            TypeUtils.setAccessible(cls, method5, i10);
                        }
                    }
                    i12 = i37;
                    i11 = length6;
                }
                i37 = i12 + 1;
                length6 = i11;
            }
        }
        int size4 = arrayList4.size();
        FieldInfo[] fieldInfoArr5 = new FieldInfo[size4];
        arrayList4.toArray(fieldInfoArr5);
        FieldInfo[] fieldInfoArr6 = new FieldInfo[size4];
        System.arraycopy(fieldInfoArr5, 0, fieldInfoArr6, 0, size4);
        Arrays.sort(fieldInfoArr6);
        return new JavaBeanInfo(cls, constructor7, null, null, fieldInfoArr5, fieldInfoArr6, z11 ? (JSONType) cls.getAnnotation(JSONType.class) : null);
    }

    private FieldInfo[] computeSortedFields(FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        String[] orders;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        JSONType jSONType = this.jsonType;
        if (!(jSONType == null || (orders = jSONType.orders()) == null || orders.length == 0)) {
            int i10 = 0;
            while (true) {
                if (i10 >= orders.length) {
                    z10 = true;
                    break;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= fieldInfoArr2.length) {
                        z13 = false;
                        break;
                    } else if (fieldInfoArr2[i11].name.equals(orders[i10])) {
                        z13 = true;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (!z13) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (!z10) {
                return fieldInfoArr2;
            }
            if (orders.length == fieldInfoArr.length) {
                int i12 = 0;
                while (true) {
                    if (i12 >= orders.length) {
                        z12 = true;
                        break;
                    } else if (!fieldInfoArr2[i12].name.equals(orders[i12])) {
                        z12 = false;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (z12) {
                    return fieldInfoArr2;
                }
                FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
                for (int i13 = 0; i13 < orders.length; i13++) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= fieldInfoArr2.length) {
                            break;
                        } else if (fieldInfoArr2[i14].name.equals(orders[i13])) {
                            fieldInfoArr3[i13] = fieldInfoArr2[i14];
                            break;
                        } else {
                            i14++;
                        }
                    }
                }
                this.ordered = true;
                return fieldInfoArr3;
            }
            int length = fieldInfoArr2.length;
            FieldInfo[] fieldInfoArr4 = new FieldInfo[length];
            for (int i15 = 0; i15 < orders.length; i15++) {
                int i16 = 0;
                while (true) {
                    if (i16 >= fieldInfoArr2.length) {
                        break;
                    } else if (fieldInfoArr2[i16].name.equals(orders[i15])) {
                        fieldInfoArr4[i15] = fieldInfoArr2[i16];
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            int length2 = orders.length;
            for (int i17 = 0; i17 < fieldInfoArr2.length; i17++) {
                for (int i18 = 0; i18 < length && i18 < length2; i18++) {
                    if (fieldInfoArr4[i17].equals(fieldInfoArr2[i18])) {
                        z11 = true;
                        break;
                    }
                }
                z11 = false;
                if (!z11) {
                    fieldInfoArr4[length2] = fieldInfoArr2[i17];
                    length2++;
                }
            }
            this.ordered = true;
        }
        return fieldInfoArr2;
    }
}
