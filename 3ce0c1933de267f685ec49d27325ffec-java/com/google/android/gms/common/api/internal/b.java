package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import h6.n;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    private static final b f8511e = new b();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f8512a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f8513b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<a> f8514c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f8515d = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z10);
    }

    private b() {
    }

    public static b b() {
        return f8511e;
    }

    public static void c(Application application) {
        b bVar = f8511e;
        synchronized (bVar) {
            if (!bVar.f8515d) {
                application.registerActivityLifecycleCallbacks(bVar);
                application.registerComponentCallbacks(bVar);
                bVar.f8515d = true;
            }
        }
    }

    private final void e(boolean z10) {
        synchronized (f8511e) {
            ArrayList<a> arrayList = this.f8514c;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                a aVar = arrayList.get(i10);
                i10++;
                aVar.a(z10);
            }
        }
    }

    public final void a(a aVar) {
        synchronized (f8511e) {
            this.f8514c.add(aVar);
        }
    }

    public final boolean d() {
        return this.f8512a.get();
    }

    @TargetApi(16)
    public final boolean f(boolean z10) {
        if (!this.f8513b.get()) {
            if (!n.c()) {
                return z10;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f8513b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f8512a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f8512a.compareAndSet(true, false);
        this.f8513b.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f8512a.compareAndSet(true, false);
        this.f8513b.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        if (i10 == 20 && this.f8512a.compareAndSet(false, true)) {
            this.f8513b.set(true);
            e(true);
        }
    }
}
