package com.mobvoi.android.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: ReflectionUtils.java */
/* loaded from: classes2.dex */
public class p {
    public static Field a(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException unused) {
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (NoSuchFieldException unused2) {
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchFieldException(str + " not found");
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            while (cls != null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (NoSuchMethodException unused2) {
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchMethodException(str + " not found");
        }
    }
}
