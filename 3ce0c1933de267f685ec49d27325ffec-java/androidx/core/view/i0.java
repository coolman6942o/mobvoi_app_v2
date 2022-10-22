package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f2560a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f2561b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f2562c = null;

    /* renamed from: d  reason: collision with root package name */
    int f2563d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j0 f2564a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2565b;

        a(i0 i0Var, j0 j0Var, View view) {
            this.f2564a = j0Var;
            this.f2565b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2564a.a(this.f2565b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2564a.b(this.f2565b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f2564a.c(this.f2565b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l0 f2566a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2567b;

        b(i0 i0Var, l0 l0Var, View view) {
            this.f2566a = l0Var;
            this.f2567b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2566a.a(this.f2567b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class c implements j0 {

        /* renamed from: a  reason: collision with root package name */
        i0 f2568a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2569b;

        c(i0 i0Var) {
            this.f2568a = i0Var;
        }

        @Override // androidx.core.view.j0
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            j0 j0Var = tag instanceof j0 ? (j0) tag : null;
            if (j0Var != null) {
                j0Var.a(view);
            }
        }

        @Override // androidx.core.view.j0
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            int i10 = this.f2568a.f2563d;
            j0 j0Var = null;
            if (i10 > -1) {
                view.setLayerType(i10, null);
                this.f2568a.f2563d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f2569b) {
                i0 i0Var = this.f2568a;
                Runnable runnable = i0Var.f2562c;
                if (runnable != null) {
                    i0Var.f2562c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof j0) {
                    j0Var = (j0) tag;
                }
                if (j0Var != null) {
                    j0Var.b(view);
                }
                this.f2569b = true;
            }
        }

        @Override // androidx.core.view.j0
        public void c(View view) {
            this.f2569b = false;
            j0 j0Var = null;
            if (this.f2568a.f2563d > -1) {
                view.setLayerType(2, null);
            }
            i0 i0Var = this.f2568a;
            Runnable runnable = i0Var.f2561b;
            if (runnable != null) {
                i0Var.f2561b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof j0) {
                j0Var = (j0) tag;
            }
            if (j0Var != null) {
                j0Var.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(View view) {
        this.f2560a = new WeakReference<>(view);
    }

    private void g(View view, j0 j0Var) {
        if (j0Var != null) {
            view.animate().setListener(new a(this, j0Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public i0 a(float f10) {
        View view = this.f2560a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void b() {
        View view = this.f2560a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.f2560a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public i0 d(long j10) {
        View view = this.f2560a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public i0 e(Interpolator interpolator) {
        View view = this.f2560a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public i0 f(j0 j0Var) {
        View view = this.f2560a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                g(view, j0Var);
            } else {
                view.setTag(2113929216, j0Var);
                g(view, new c(this));
            }
        }
        return this;
    }

    public i0 h(long j10) {
        View view = this.f2560a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public i0 i(l0 l0Var) {
        View view = this.f2560a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            b bVar = null;
            if (l0Var != null) {
                bVar = new b(this, l0Var, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public void j() {
        View view = this.f2560a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public i0 k(float f10) {
        View view = this.f2560a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
