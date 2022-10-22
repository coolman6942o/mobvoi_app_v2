package f9;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import g9.b;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public final class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Application f26363a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0284a f26364b = new C0284a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Utils.java */
    /* renamed from: f9.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0284a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final LinkedList<Activity> f26365a = new LinkedList<>();

        /* renamed from: b  reason: collision with root package name */
        final HashMap<Object, b> f26366b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private int f26367c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f26368d = 0;

        C0284a() {
        }

        private void a(boolean z10) {
            b next;
            if (!this.f26366b.isEmpty()) {
                Iterator<b> it = this.f26366b.values().iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    if (z10) {
                        next.a();
                    } else {
                        next.b();
                    }
                }
            }
        }

        private void b(Activity activity) {
            if (activity.getClass() != b.a.class) {
                if (!this.f26365a.contains(activity)) {
                    this.f26365a.addLast(activity);
                } else if (!this.f26365a.getLast().equals(activity)) {
                    this.f26365a.remove(activity);
                    this.f26365a.addLast(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            this.f26365a.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            b(activity);
            if (this.f26367c <= 0) {
                a(true);
            }
            int i10 = this.f26368d;
            if (i10 < 0) {
                this.f26368d = i10 + 1;
            } else {
                this.f26367c++;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity.isChangingConfigurations()) {
                this.f26368d--;
                return;
            }
            int i10 = this.f26367c - 1;
            this.f26367c = i10;
            if (i10 <= 0) {
                a(false);
            }
        }
    }

    /* compiled from: Utils.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();
    }

    public static Application a() {
        Application application = f26363a;
        if (application != null) {
            return application;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (invoke != null) {
                b((Application) invoke);
                return f26363a;
            }
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    public static void b(Application application) {
        if (f26363a == null) {
            f26363a = application;
            application.registerActivityLifecycleCallbacks(f26364b);
        }
    }
}
