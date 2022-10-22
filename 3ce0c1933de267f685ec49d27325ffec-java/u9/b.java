package u9;

import com.mobvoi.android.common.utils.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: SystemPropertiesIA.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f35356a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f35357b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f35358c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f35359d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f35360e;

    static {
        try {
            f35356a = Class.forName("android.os.SystemProperties", false, Thread.currentThread().getContextClassLoader());
        } catch (Exception e10) {
            k.r("SystemPropertiesIA", "Failed to reflect SystemProperties", e10, new Object[0]);
        }
    }

    public static String a(String str, String str2) {
        d();
        Method method = f35357b;
        if (method != null) {
            try {
                return (String) method.invoke(null, str, str2);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
                e10.printStackTrace();
            }
        } else {
            k.q("SystemPropertiesIA", "#get(String, String) not found");
        }
        return str2;
    }

    public static boolean b(String str, boolean z10) {
        e();
        Method method = f35359d;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, str, Boolean.valueOf(z10))).booleanValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
                e10.printStackTrace();
            }
        } else {
            k.q("SystemPropertiesIA", "#getBoolean(String, boolean) not found");
        }
        return z10;
    }

    public static int c(String str, int i10) {
        f();
        Method method = f35358c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, str, Integer.valueOf(i10))).intValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
                e10.printStackTrace();
            }
        } else {
            k.q("SystemPropertiesIA", "#getInt(String, int) not found");
        }
        return i10;
    }

    static Method d() {
        Class<?> cls;
        Method method = f35357b;
        if (method != null || (cls = f35356a) == null) {
            return method;
        }
        try {
            f35357b = cls.getMethod("get", String.class, String.class);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        }
        return f35357b;
    }

    static Method e() {
        Class<?> cls;
        Method method = f35359d;
        if (method != null || (cls = f35356a) == null) {
            return method;
        }
        try {
            f35359d = cls.getMethod("getBoolean", String.class, Boolean.TYPE);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        }
        return f35359d;
    }

    static Method f() {
        Class<?> cls;
        Method method = f35358c;
        if (method != null || (cls = f35356a) == null) {
            return method;
        }
        try {
            f35358c = cls.getMethod("getInt", String.class, Integer.TYPE);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        }
        return f35358c;
    }

    static Method g() {
        Class<?> cls;
        Method method = f35360e;
        if (method != null || (cls = f35356a) == null) {
            return method;
        }
        try {
            f35360e = cls.getMethod("set", String.class, String.class);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        }
        return f35360e;
    }

    public static void h(String str, String str2) {
        g();
        Method method = f35360e;
        if (method != null) {
            try {
                method.invoke(null, str, str2);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
                e10.printStackTrace();
            }
        } else {
            k.q("SystemPropertiesIA", "#set(String, String) not found");
        }
    }
}
