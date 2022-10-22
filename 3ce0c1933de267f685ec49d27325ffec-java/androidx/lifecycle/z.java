package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a0;
/* compiled from: ProcessLifecycleOwner.java */
/* loaded from: classes.dex */
public class z implements p {

    /* renamed from: i  reason: collision with root package name */
    private static final z f3341i = new z();

    /* renamed from: e  reason: collision with root package name */
    private Handler f3346e;

    /* renamed from: a  reason: collision with root package name */
    private int f3342a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3343b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3344c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3345d = true;

    /* renamed from: f  reason: collision with root package name */
    private final q f3347f = new q(this);

    /* renamed from: g  reason: collision with root package name */
    private Runnable f3348g = new a();

    /* renamed from: h  reason: collision with root package name */
    a0.a f3349h = new b();

    /* compiled from: ProcessLifecycleOwner.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.f();
            z.this.g();
        }
    }

    /* compiled from: ProcessLifecycleOwner.java */
    /* loaded from: classes.dex */
    class b implements a0.a {
        b() {
        }

        @Override // androidx.lifecycle.a0.a
        public void a() {
        }

        @Override // androidx.lifecycle.a0.a
        public void onResume() {
            z.this.b();
        }

        @Override // androidx.lifecycle.a0.a
        public void onStart() {
            z.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProcessLifecycleOwner.java */
    /* loaded from: classes.dex */
    public class c extends g {

        /* compiled from: ProcessLifecycleOwner.java */
        /* loaded from: classes.dex */
        class a extends g {
            a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                z.this.b();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                z.this.c();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                a0.f(activity).h(z.this.f3349h);
            }
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            z.this.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            z.this.d();
        }
    }

    private z() {
    }

    public static p h() {
        return f3341i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Context context) {
        f3341i.e(context);
    }

    void a() {
        int i10 = this.f3343b - 1;
        this.f3343b = i10;
        if (i10 == 0) {
            this.f3346e.postDelayed(this.f3348g, 700L);
        }
    }

    void b() {
        int i10 = this.f3343b + 1;
        this.f3343b = i10;
        if (i10 != 1) {
            return;
        }
        if (this.f3344c) {
            this.f3347f.h(Lifecycle.Event.ON_RESUME);
            this.f3344c = false;
            return;
        }
        this.f3346e.removeCallbacks(this.f3348g);
    }

    void c() {
        int i10 = this.f3342a + 1;
        this.f3342a = i10;
        if (i10 == 1 && this.f3345d) {
            this.f3347f.h(Lifecycle.Event.ON_START);
            this.f3345d = false;
        }
    }

    void d() {
        this.f3342a--;
        g();
    }

    void e(Context context) {
        this.f3346e = new Handler();
        this.f3347f.h(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    void f() {
        if (this.f3343b == 0) {
            this.f3344c = true;
            this.f3347f.h(Lifecycle.Event.ON_PAUSE);
        }
    }

    void g() {
        if (this.f3342a == 0 && this.f3344c) {
            this.f3347f.h(Lifecycle.Event.ON_STOP);
            this.f3345d = true;
        }
    }

    @Override // androidx.lifecycle.p
    public Lifecycle getLifecycle() {
        return this.f3347f;
    }
}
