package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    private int ordinal;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i10, int i11) {
        this.ordinal = 0;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i10;
        this.isEnum = cls2.isEnum();
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            int i12 = modifiers & 1;
            this.fieldAccess = true;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        long j10 = -2128831035;
        for (int i13 = 0; i13 < str.length(); i13++) {
            j10 = (j10 ^ str.charAt(i13)) * 16777619;
        }
        this.nameHashCode = j10;
        this.format = null;
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable<Class<? super Object>>[] typeVariableArr;
        if (!(cls == null || type == null)) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType = getFieldType(cls, type, genericComponentType);
                return genericComponentType != fieldType ? Array.newInstance(TypeUtils.getClass(fieldType), 0).getClass() : type2;
            } else if (!TypeUtils.isGenericParamType(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                    Class<?> cls2 = TypeUtils.getClass(parameterizedType2);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    for (int i10 = 0; i10 < cls2.getTypeParameters().length; i10++) {
                        if (cls2.getTypeParameters()[i10].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i10];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    Type[] typeArr = null;
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeVariableArr = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeVariableArr = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeVariableArr = null;
                        parameterizedType = null;
                    }
                    boolean z10 = false;
                    for (int i11 = 0; i11 < actualTypeArguments.length && parameterizedType != null; i11++) {
                        Type type3 = actualTypeArguments[i11];
                        if (type3 instanceof TypeVariable) {
                            TypeVariable typeVariable2 = (TypeVariable) type3;
                            for (int i12 = 0; i12 < typeVariableArr.length; i12++) {
                                if (typeVariableArr[i12].getName().equals(typeVariable2.getName())) {
                                    if (typeArr == null) {
                                        typeArr = parameterizedType.getActualTypeArguments();
                                    }
                                    actualTypeArguments[i11] = typeArr[i12];
                                    z10 = true;
                                }
                            }
                        }
                    }
                    if (z10) {
                        return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.GenericDeclaration, java.lang.Object] */
    public static Type getInheritGenericType(Class<?> cls, TypeVariable<?> typeVariable) {
        ?? genericDeclaration = typeVariable.getGenericDeclaration();
        while (true) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                Type rawType = parameterizedType.getRawType();
                if (genericDeclaration.equals(rawType) || ((genericDeclaration instanceof Class) && (rawType instanceof Class) && ((Class) genericDeclaration).isAssignableFrom((Class) rawType))) {
                    TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i10 = 0; i10 < typeParameters.length; i10++) {
                        if (typeParameters[i10] == typeVariable) {
                            return actualTypeArguments[i10];
                        }
                    }
                    return null;
                }
            }
            cls = TypeUtils.getClass(genericSuperclass);
        }
    }

    public boolean equals(FieldInfo fieldInfo) {
        return fieldInfo == this || compareTo(fieldInfo) == 0;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (this.fieldAccess) {
            return this.field.get(obj);
        }
        return this.method.invoke(obj, new Object[0]);
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public String toString() {
        return this.name;
    }

    public int compareTo(FieldInfo fieldInfo) {
        int i10 = this.ordinal;
        int i11 = fieldInfo.ordinal;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        return this.name.compareTo(fieldInfo.name);
    }

    public FieldInfo(String str, Method method, Field field, Class<?> cls, Type type, int i10, int i11, JSONField jSONField, JSONField jSONField2, boolean z10) {
        Type type2;
        Class<?> cls2;
        Type inheritGenericType;
        boolean z11 = false;
        this.ordinal = 0;
        this.name = str;
        this.method = method;
        this.field = field;
        this.ordinal = i10;
        this.methodAnnotation = jSONField;
        this.fieldAnnotation = jSONField2;
        JSONField annotation = getAnnotation();
        String str2 = null;
        if (annotation != null) {
            String format = annotation.format();
            if (format.trim().length() != 0) {
                str2 = format;
            }
        }
        this.format = str2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.fieldTransient = (modifiers & 128) != 0;
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        long j10 = -2128831035;
        for (int i12 = 0; i12 < str.length(); i12++) {
            j10 = (j10 ^ str.charAt(i12)) * 16777619;
        }
        this.nameHashCode = j10;
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls2 = parameterTypes[0];
                type2 = (cls2 == Class.class || cls2 == String.class || cls2.isPrimitive() || !z10) ? cls2 : method.getGenericParameterTypes()[0];
                this.getOnly = false;
            } else {
                cls2 = method.getReturnType();
                type2 = (cls2 != Class.class && z10) ? method.getGenericReturnType() : cls2;
                this.getOnly = true;
            }
            this.declaringClass = method.getDeclaringClass();
        } else {
            cls2 = field.getType();
            Type genericType = (cls2.isPrimitive() || cls2 == String.class || cls2.isEnum() || !z10) ? cls2 : field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
            this.getOnly = Modifier.isFinal(field.getModifiers());
            type2 = genericType;
        }
        if (cls == null || cls2 != Object.class || !(type2 instanceof TypeVariable) || (inheritGenericType = getInheritGenericType(cls, (TypeVariable) type2)) == null) {
            if (!(type2 instanceof Class)) {
                Type fieldType = getFieldType(cls, type == null ? cls : type, type2);
                if (fieldType != type2) {
                    if (fieldType instanceof ParameterizedType) {
                        cls2 = TypeUtils.getClass(fieldType);
                    } else if (fieldType instanceof Class) {
                        cls2 = TypeUtils.getClass(fieldType);
                    }
                }
                type2 = fieldType;
            }
            this.fieldType = type2;
            this.fieldClass = cls2;
            if (!cls2.isArray() && cls2.isEnum()) {
                z11 = true;
            }
            this.isEnum = z11;
            return;
        }
        this.fieldClass = TypeUtils.getClass(inheritGenericType);
        this.fieldType = inheritGenericType;
        this.isEnum = cls2.isEnum();
    }
}
