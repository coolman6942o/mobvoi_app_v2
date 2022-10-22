package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: BundleCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: BundleCompat.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Method f2253a;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f2254b;

        public static void a(Bundle bundle, String str, IBinder iBinder) {
            if (!f2254b) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f2253a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e10) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e10);
                }
                f2254b = true;
            }
            Method method2 = f2253a;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e11);
                    f2253a = null;
                }
            }
        }
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.a(bundle, str, iBinder);
        }
    }
}
