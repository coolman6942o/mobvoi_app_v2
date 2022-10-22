package bd;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: AppLifeCycleMonitor.java */
/* loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    private static a f5125g;

    /* renamed from: a  reason: collision with root package name */
    private boolean f5126a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5127b = true;

    /* renamed from: c  reason: collision with root package name */
    private Handler f5128c = com.mobvoi.android.common.utils.b.i();

    /* renamed from: d  reason: collision with root package name */
    private List<b> f5129d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<Activity> f5130e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private Runnable f5131f = new RunnableC0072a();

    /* compiled from: AppLifeCycleMonitor.java */
    /* renamed from: bd.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0072a implements Runnable {
        RunnableC0072a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f5126a && a.this.f5127b) {
                a.this.f5126a = false;
                for (b bVar : a.this.f5129d) {
                    bVar.b();
                }
            }
        }
    }

    /* compiled from: AppLifeCycleMonitor.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(Activity activity);

        void b();
    }

    public static a g() {
        a aVar = f5125g;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static a i(Application application) {
        if (f5125g == null) {
            a aVar = new a();
            f5125g = aVar;
            application.registerActivityLifecycleCallbacks(aVar);
        }
        return f5125g;
    }

    public void e(b bVar) {
        this.f5129d.add(bVar);
    }

    public List<Activity> f() {
        return this.f5130e;
    }

    public Activity h() {
        int size = this.f5130e.size();
        if (size > 0) {
            return this.f5130e.get(size - 1);
        }
        return null;
    }

    public boolean j() {
        return this.f5126a;
    }

    public void k(b bVar) {
        this.f5129d.remove(bVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f5130e.contains(activity)) {
            this.f5130e.add(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.f5130e.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f5127b = true;
        this.f5128c.removeCallbacks(this.f5131f);
        this.f5128c.postDelayed(this.f5131f, 500L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f5127b = false;
        boolean z10 = !this.f5126a;
        this.f5126a = true;
        this.f5128c.removeCallbacks(this.f5131f);
        if (z10) {
            for (b bVar : this.f5129d) {
                bVar.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
