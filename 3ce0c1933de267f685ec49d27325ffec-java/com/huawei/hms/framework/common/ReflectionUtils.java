package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    ReflectionUtils() {
    }

    public static Class<?> getClass(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!EmuiUtil.BUILDEX_VERSION.equals(str) && !EmuiUtil.IMMERSION_STYLE.equals(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            Logger.w(TAG, "ClassNotFoundException occur in method ReflectionUtils.getClass()");
            return null;
        }
    }

    private static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        String str2;
        Throwable e10;
        if (cls == null || str == null) {
            Logger.w(TAG, "targetClass is  null pr name is null:");
            return null;
        } else if (!EmuiUtil.GET_PRIMARY_COLOR.equals(str) && !EmuiUtil.GET_SUGGESTION_FOR_GROUND_COLOR_STYLE.equals(str)) {
            return null;
        } else {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e11) {
                e10 = e11;
                str2 = "NoSuchMethodException:";
                Logger.e(TAG, str2, e10);
                return null;
            } catch (SecurityException e12) {
                e10 = e12;
                str2 = "SecurityException:";
                Logger.e(TAG, str2, e10);
                return null;
            }
        }
    }

    public static Object getStaticFieldObj(String str, String str2) {
        String str3;
        Throwable e10;
        Class<?> cls = getClass(str);
        if (cls == null || TextUtils.isEmpty(str2) || !EmuiUtil.BUILDEX_VERSION.equals(str) || !EmuiUtil.EMUI_SDK_INT.equals(str2)) {
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str2);
            AccessibleObject.setAccessible(new Field[]{declaredField}, true);
            return declaredField.get(cls);
        } catch (IllegalAccessException e11) {
            e10 = e11;
            str3 = "Exception in getFieldObj :: IllegalAccessException:";
            Logger.e(TAG, str3, e10);
            return null;
        } catch (IllegalArgumentException e12) {
            e10 = e12;
            str3 = "Exception in getFieldObj :: IllegalArgumentException:";
            Logger.e(TAG, str3, e10);
            return null;
        } catch (NoSuchFieldException e13) {
            e10 = e13;
            str3 = "Exception in getFieldObj :: NoSuchFieldException:";
            Logger.e(TAG, str3, e10);
            return null;
        } catch (SecurityException e14) {
            e10 = e14;
            str3 = "not security int method getStaticFieldObj,SecurityException:";
            Logger.e(TAG, str3, e10);
            return null;
        }
    }

    private static Object invoke(Object obj, Method method, Object... objArr) {
        String str;
        Throwable e10;
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (RuntimeException e11) {
            e10 = e11;
            str = "RuntimeException in invoke:";
            Logger.e(TAG, str, e10);
            return null;
        } catch (Exception e12) {
            e10 = e12;
            str = "Exception in invoke:";
            Logger.e(TAG, str, e10);
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class[] clsArr;
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i10 = 0; i10 < length; i10++) {
                setClassType(clsArr, objArr[i10], i10);
            }
        } else {
            clsArr = null;
        }
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }

    private static void setClassType(Class<?>[] clsArr, Object obj, int i10) {
        if (obj instanceof Integer) {
            clsArr[i10] = Integer.TYPE;
        } else if (obj instanceof Long) {
            clsArr[i10] = Long.TYPE;
        } else if (obj instanceof Double) {
            clsArr[i10] = Double.TYPE;
        } else if (obj instanceof Float) {
            clsArr[i10] = Float.TYPE;
        } else if (obj instanceof Boolean) {
            clsArr[i10] = Boolean.TYPE;
        } else if (obj instanceof Character) {
            clsArr[i10] = Character.TYPE;
        } else if (obj instanceof Byte) {
            clsArr[i10] = Byte.TYPE;
        } else if (obj instanceof Void) {
            clsArr[i10] = Void.TYPE;
        } else if (obj instanceof Short) {
            clsArr[i10] = Short.TYPE;
        } else {
            clsArr[i10] = obj.getClass();
        }
    }
}
