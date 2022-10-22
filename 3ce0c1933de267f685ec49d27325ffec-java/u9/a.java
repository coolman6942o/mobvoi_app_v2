package u9;

import android.os.IBinder;
import com.mobvoi.android.common.utils.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ServiceManagerIA.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f35354a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f35355b;

    static {
        try {
            f35354a = Class.forName("android.os.ServiceManager", false, Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException e10) {
            k.r("ServiceManagerIA", "class not found", e10, new Object[0]);
        }
    }

    public static IBinder a(String str) {
        b();
        Method method = f35355b;
        if (method != null) {
            try {
                return (IBinder) method.invoke(null, str);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
                k.r("ServiceManagerIA", "Failed to invoke #getService()", e10, new Object[0]);
            }
        } else {
            k.q("ServiceManagerIA", "#getService() not available");
        }
        return null;
    }

    static Method b() {
        Class<?> cls;
        Method method = f35355b;
        if (method != null || (cls = f35354a) == null) {
            return method;
        }
        try {
            f35355b = cls.getMethod("getService", String.class);
        } catch (NoSuchMethodException e10) {
            k.r("ServiceManagerIA", "method not found", e10, new Object[0]);
        }
        return f35355b;
    }
}
