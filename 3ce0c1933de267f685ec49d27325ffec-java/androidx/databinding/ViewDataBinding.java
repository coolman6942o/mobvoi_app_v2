package androidx.databinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.View;
import androidx.databinding.c;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.y;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.a implements p1.a {

    /* renamed from: l  reason: collision with root package name */
    static int f2710l;

    /* renamed from: m  reason: collision with root package name */
    private static final boolean f2711m;

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f2712a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2713b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2714c;

    /* renamed from: d  reason: collision with root package name */
    private final View f2715d;

    /* renamed from: e  reason: collision with root package name */
    private androidx.databinding.c<h, ViewDataBinding, Void> f2716e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2717f;

    /* renamed from: g  reason: collision with root package name */
    private Choreographer f2718g;

    /* renamed from: h  reason: collision with root package name */
    private final Choreographer.FrameCallback f2719h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f2720i;

    /* renamed from: j  reason: collision with root package name */
    private ViewDataBinding f2721j;

    /* renamed from: k  reason: collision with root package name */
    private p f2722k;

    /* loaded from: classes.dex */
    static class OnStartListener implements o {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<ViewDataBinding> f2723a;

        @y(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.f2723a.get();
            if (viewDataBinding != null) {
                viewDataBinding.h();
            }
        }
    }

    /* loaded from: classes.dex */
    class a {
        a() {
        }
    }

    /* loaded from: classes.dex */
    class b {
        b() {
        }
    }

    /* loaded from: classes.dex */
    class c {
        c() {
        }
    }

    /* loaded from: classes.dex */
    class d {
        d() {
        }
    }

    /* loaded from: classes.dex */
    class e extends c.a<h, ViewDataBinding, Void> {
        e() {
        }

        /* renamed from: b */
        public void a(h hVar, ViewDataBinding viewDataBinding, int i10, Void r42) {
            if (i10 != 1) {
                if (i10 == 2) {
                    hVar.b(viewDataBinding);
                } else if (i10 == 3) {
                    hVar.a(viewDataBinding);
                }
            } else if (!hVar.c(viewDataBinding)) {
                viewDataBinding.f2714c = true;
            }
        }
    }

    /* loaded from: classes.dex */
    class f implements View.OnAttachStateChangeListener {
        f() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.i(view).f2712a.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f2710l = i10;
        f2711m = i10 >= 16;
        new a();
        new b();
        new c();
        new d();
        new e();
        new ReferenceQueue();
        if (i10 >= 19) {
            new f();
        }
    }

    private void g() {
        if (this.f2717f) {
            k();
        } else if (j()) {
            this.f2717f = true;
            this.f2714c = false;
            androidx.databinding.c<h, ViewDataBinding, Void> cVar = this.f2716e;
            if (cVar != null) {
                cVar.d(this, 1, null);
                if (this.f2714c) {
                    this.f2716e.d(this, 2, null);
                }
            }
            if (!this.f2714c) {
                d();
                androidx.databinding.c<h, ViewDataBinding, Void> cVar2 = this.f2716e;
                if (cVar2 != null) {
                    cVar2.d(this, 3, null);
                }
            }
            this.f2717f = false;
        }
    }

    static ViewDataBinding i(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(p0.a.a_res_0x7f0b01df);
        }
        return null;
    }

    @Override // p1.a
    public View a() {
        return this.f2715d;
    }

    protected abstract void d();

    public void h() {
        ViewDataBinding viewDataBinding = this.f2721j;
        if (viewDataBinding == null) {
            g();
        } else {
            viewDataBinding.h();
        }
    }

    public abstract boolean j();

    protected void k() {
        ViewDataBinding viewDataBinding = this.f2721j;
        if (viewDataBinding != null) {
            viewDataBinding.k();
            return;
        }
        p pVar = this.f2722k;
        if (pVar == null || pVar.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                if (!this.f2713b) {
                    this.f2713b = true;
                    if (f2711m) {
                        this.f2718g.postFrameCallback(this.f2719h);
                    } else {
                        this.f2720i.post(this.f2712a);
                    }
                }
            }
        }
    }
}
