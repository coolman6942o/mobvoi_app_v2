package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f2234a;

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f2237d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f2238e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f2239f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f2240g = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f2235b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f2236c = f();

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2241a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f2242b;

        a(d dVar, Object obj) {
            this.f2241a = dVar;
            this.f2242b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2241a.f2247a = this.f2242b;
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Application f2243a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f2244b;

        b(Application application, d dVar) {
            this.f2243a = application;
            this.f2244b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2243a.unregisterActivityLifecycleCallbacks(this.f2244b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityRecreator.java */
    /* renamed from: androidx.core.app.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0015c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f2245a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f2246b;

        RunnableC0015c(Object obj, Object obj2) {
            this.f2245a = obj;
            this.f2246b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = c.f2237d;
                if (method != null) {
                    method.invoke(this.f2245a, this.f2246b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    c.f2238e.invoke(this.f2245a, this.f2246b, Boolean.FALSE);
                }
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable th2) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
            }
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f2247a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f2248b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2249c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2250d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2251e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2252f = false;

        d(Activity activity) {
            this.f2248b = activity;
            this.f2249c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f2248b == activity) {
                this.f2248b = null;
                this.f2251e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (this.f2251e && !this.f2252f && !this.f2250d && c.h(this.f2247a, this.f2249c, activity)) {
                this.f2252f = true;
                this.f2247a = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f2248b == activity) {
                this.f2250d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a10 = a();
        f2234a = a10;
        f2237d = d(a10);
        f2238e = c(a10);
        f2239f = e(a10);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 26 || i10 == 27;
    }

    protected static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f2236c.get(activity);
            if (obj2 == obj && activity.hashCode() == i10) {
                f2240g.postAtFrontOfQueue(new RunnableC0015c(f2235b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f2239f == null) {
            return false;
        } else {
            if (f2238e == null && f2237d == null) {
                return false;
            }
            try {
                Object obj2 = f2236c.get(activity);
                if (obj2 == null || (obj = f2235b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                d dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f2240g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f2239f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
