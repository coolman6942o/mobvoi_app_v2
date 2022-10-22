package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.d0;
import androidx.core.view.q;
import androidx.core.view.t;
import androidx.core.view.u;
import com.amap.api.services.core.AMapException;
import com.scwang.smart.refresh.layout.constant.RefreshState;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
public class SmartRefreshLayout extends ViewGroup implements sm.f, t {
    protected static vm.b W0;
    protected static vm.c X0;
    protected static vm.d Y0;
    protected static ViewGroup.MarginLayoutParams Z0 = new ViewGroup.MarginLayoutParams(-1, -1);
    protected int[] A;
    protected float A0;
    protected boolean B;
    protected float B0;
    protected boolean C;
    protected float C0;
    protected boolean D;
    protected boolean E;
    protected sm.a E0;
    protected boolean F;
    protected sm.a F0;
    protected boolean G;
    protected sm.b G0;
    protected boolean H;
    protected Paint H0;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected RefreshState K0;
    protected boolean L;
    protected RefreshState L0;
    protected boolean M;
    protected boolean N;
    protected boolean O;
    protected boolean P;
    protected boolean P0;
    protected boolean Q;
    protected boolean Q0;
    protected boolean R;
    protected boolean S;
    protected Runnable U0;
    protected boolean V;
    protected ValueAnimator V0;
    protected boolean W;

    /* renamed from: a  reason: collision with root package name */
    protected int f22326a;

    /* renamed from: b  reason: collision with root package name */
    protected int f22327b;

    /* renamed from: c  reason: collision with root package name */
    protected int f22328c;

    /* renamed from: d  reason: collision with root package name */
    protected int f22329d;

    /* renamed from: f  reason: collision with root package name */
    protected int f22331f;

    /* renamed from: g  reason: collision with root package name */
    protected int f22332g;

    /* renamed from: h  reason: collision with root package name */
    protected float f22333h;

    /* renamed from: i  reason: collision with root package name */
    protected float f22334i;

    /* renamed from: j  reason: collision with root package name */
    protected float f22335j;

    /* renamed from: j0  reason: collision with root package name */
    protected boolean f22336j0;

    /* renamed from: k  reason: collision with root package name */
    protected float f22337k;

    /* renamed from: k0  reason: collision with root package name */
    protected vm.g f22338k0;

    /* renamed from: l  reason: collision with root package name */
    protected float f22339l;

    /* renamed from: l0  reason: collision with root package name */
    protected vm.e f22340l0;

    /* renamed from: m0  reason: collision with root package name */
    protected vm.f f22342m0;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f22343n;

    /* renamed from: n0  reason: collision with root package name */
    protected vm.i f22344n0;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f22345o;

    /* renamed from: o0  reason: collision with root package name */
    protected int f22346o0;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f22347p;

    /* renamed from: p0  reason: collision with root package name */
    protected boolean f22348p0;

    /* renamed from: q  reason: collision with root package name */
    protected int f22349q;

    /* renamed from: r  reason: collision with root package name */
    protected int f22351r;

    /* renamed from: s  reason: collision with root package name */
    protected int f22353s;

    /* renamed from: t  reason: collision with root package name */
    protected int f22355t;

    /* renamed from: t0  reason: collision with root package name */
    protected int f22356t0;

    /* renamed from: u  reason: collision with root package name */
    protected int f22357u;

    /* renamed from: u0  reason: collision with root package name */
    protected tm.a f22358u0;

    /* renamed from: v  reason: collision with root package name */
    protected int f22359v;

    /* renamed from: v0  reason: collision with root package name */
    protected int f22360v0;

    /* renamed from: w  reason: collision with root package name */
    protected int f22361w;

    /* renamed from: w0  reason: collision with root package name */
    protected tm.a f22362w0;

    /* renamed from: x  reason: collision with root package name */
    protected Scroller f22363x;

    /* renamed from: x0  reason: collision with root package name */
    protected int f22364x0;

    /* renamed from: y0  reason: collision with root package name */
    protected int f22366y0;

    /* renamed from: z0  reason: collision with root package name */
    protected float f22368z0;

    /* renamed from: e  reason: collision with root package name */
    protected int f22330e = 300;

    /* renamed from: m  reason: collision with root package name */
    protected char f22341m = 'n';
    protected boolean T = false;
    protected boolean U = false;

    /* renamed from: q0  reason: collision with root package name */
    protected int[] f22350q0 = new int[2];

    /* renamed from: r0  reason: collision with root package name */
    protected q f22352r0 = new q(this);

    /* renamed from: s0  reason: collision with root package name */
    protected u f22354s0 = new u(this);
    protected float D0 = 0.16666667f;
    protected sm.e J0 = new l();
    protected long M0 = 0;
    protected int N0 = 0;
    protected int O0 = 0;
    protected boolean R0 = false;
    protected boolean S0 = false;
    protected MotionEvent T0 = null;
    protected Handler I0 = new Handler(Looper.getMainLooper());

    /* renamed from: y  reason: collision with root package name */
    protected VelocityTracker f22365y = VelocityTracker.obtain();

    /* renamed from: z  reason: collision with root package name */
    protected Interpolator f22367z = new xm.b(xm.b.f36614b);

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22369a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f22369a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22369a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22369a[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22369a[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22369a[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22369a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22369a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f22369a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f22369a[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f22369a[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f22369a[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f22369a[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f22370a;

        b(boolean z10) {
            this.f22370a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.setStateDirectLoading(this.f22370a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f22372a;

        c(boolean z10) {
            this.f22372a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.M0 = System.currentTimeMillis();
                SmartRefreshLayout.this.D(RefreshState.Refreshing);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                vm.g gVar = smartRefreshLayout.f22338k0;
                if (gVar != null) {
                    if (this.f22372a) {
                        gVar.c(smartRefreshLayout);
                    }
                } else if (smartRefreshLayout.f22342m0 == null) {
                    smartRefreshLayout.v(AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                sm.a aVar = smartRefreshLayout2.E0;
                if (aVar != null) {
                    float f10 = smartRefreshLayout2.f22368z0;
                    if (f10 < 10.0f) {
                        f10 *= smartRefreshLayout2.f22356t0;
                    }
                    aVar.j(smartRefreshLayout2, smartRefreshLayout2.f22356t0, (int) f10);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                vm.f fVar = smartRefreshLayout3.f22342m0;
                if (fVar != null && (smartRefreshLayout3.E0 instanceof sm.d)) {
                    if (this.f22372a) {
                        fVar.c(smartRefreshLayout3);
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    float f11 = smartRefreshLayout4.f22368z0;
                    if (f11 < 10.0f) {
                        f11 *= smartRefreshLayout4.f22356t0;
                    }
                    smartRefreshLayout4.f22342m0.l((sm.d) smartRefreshLayout4.E0, smartRefreshLayout4.f22356t0, (int) f11);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RefreshState refreshState;
            RefreshState refreshState2;
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.V0 = null;
                if (smartRefreshLayout.f22327b != 0 || (refreshState = smartRefreshLayout.K0) == (refreshState2 = RefreshState.None) || refreshState.isOpening || refreshState.isDragging) {
                    RefreshState refreshState3 = smartRefreshLayout.K0;
                    if (refreshState3 != smartRefreshLayout.L0) {
                        smartRefreshLayout.setViceState(refreshState3);
                        return;
                    }
                    return;
                }
                smartRefreshLayout.D(refreshState2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.J0.e(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            vm.e eVar = smartRefreshLayout.f22340l0;
            if (eVar != null) {
                eVar.a(smartRefreshLayout);
            } else if (smartRefreshLayout.f22342m0 == null) {
                smartRefreshLayout.q(2000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            vm.f fVar = smartRefreshLayout2.f22342m0;
            if (fVar != null) {
                fVar.a(smartRefreshLayout2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f22377a = 0;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22378b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Boolean f22379c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f22380d;

        g(int i10, Boolean bool, boolean z10) {
            this.f22378b = i10;
            this.f22379c = bool;
            this.f22380d = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f22377a;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (i10 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout.K0;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 && smartRefreshLayout.L0 == RefreshState.Refreshing) {
                    smartRefreshLayout.L0 = refreshState2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.V0;
                    if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.V0.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.V0 = null;
                        if (smartRefreshLayout2.J0.c(0) == null) {
                            SmartRefreshLayout.this.D(refreshState2);
                        } else {
                            SmartRefreshLayout.this.D(RefreshState.PullDownCanceled);
                        }
                    } else if (!(refreshState != RefreshState.Refreshing || smartRefreshLayout.E0 == null || smartRefreshLayout.G0 == null)) {
                        this.f22377a = i10 + 1;
                        smartRefreshLayout.I0.postDelayed(this, this.f22378b);
                        SmartRefreshLayout.this.D(RefreshState.RefreshFinish);
                        if (this.f22379c == Boolean.FALSE) {
                            SmartRefreshLayout.this.H(false);
                        }
                    }
                }
                if (this.f22379c == Boolean.TRUE) {
                    SmartRefreshLayout.this.H(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int h10 = smartRefreshLayout3.E0.h(smartRefreshLayout3, this.f22380d);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            vm.f fVar = smartRefreshLayout4.f22342m0;
            if (fVar != null) {
                sm.a aVar = smartRefreshLayout4.E0;
                if (aVar instanceof sm.d) {
                    fVar.g((sm.d) aVar, this.f22380d);
                }
            }
            if (h10 < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                if (smartRefreshLayout5.f22343n || smartRefreshLayout5.f22348p0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.f22343n) {
                        float f10 = smartRefreshLayout6.f22337k;
                        smartRefreshLayout6.f22334i = f10;
                        smartRefreshLayout6.f22329d = 0;
                        smartRefreshLayout6.f22343n = false;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout6.f22335j, (f10 + smartRefreshLayout6.f22327b) - (smartRefreshLayout6.f22326a * 2), 0));
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout7.f22335j, smartRefreshLayout7.f22337k + smartRefreshLayout7.f22327b, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.f22348p0) {
                        smartRefreshLayout8.f22346o0 = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout8.f22335j, smartRefreshLayout8.f22337k, 0));
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        smartRefreshLayout9.f22348p0 = false;
                        smartRefreshLayout9.f22329d = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i11 = smartRefreshLayout10.f22327b;
                if (i11 > 0) {
                    ValueAnimator h11 = smartRefreshLayout10.h(0, h10, smartRefreshLayout10.f22367z, smartRefreshLayout10.f22331f);
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (smartRefreshLayout11.O) {
                        animatorUpdateListener = smartRefreshLayout11.G0.g(smartRefreshLayout11.f22327b);
                    }
                    if (h11 != null && animatorUpdateListener != null) {
                        h11.addUpdateListener(animatorUpdateListener);
                    }
                } else if (i11 < 0) {
                    smartRefreshLayout10.h(0, h10, smartRefreshLayout10.f22367z, smartRefreshLayout10.f22331f);
                } else {
                    smartRefreshLayout10.J0.e(0, false);
                    SmartRefreshLayout.this.J0.f(RefreshState.None);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f22382a = 0;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22383b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f22384c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f22385d;

        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f22387a;

            /* renamed from: com.scwang.smart.refresh.layout.SmartRefreshLayout$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class C0248a extends AnimatorListenerAdapter {
                C0248a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator == null || animator.getDuration() != 0) {
                        h hVar = h.this;
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.R0 = false;
                        if (hVar.f22384c) {
                            smartRefreshLayout.H(true);
                        }
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        if (smartRefreshLayout2.K0 == RefreshState.LoadFinish) {
                            smartRefreshLayout2.D(RefreshState.None);
                        }
                    }
                }
            }

            a(int i10) {
                this.f22387a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
                ValueAnimator valueAnimator;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.N || this.f22387a >= 0) {
                    animatorUpdateListener = null;
                } else {
                    animatorUpdateListener = smartRefreshLayout.G0.g(smartRefreshLayout.f22327b);
                    if (animatorUpdateListener != null) {
                        animatorUpdateListener.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                C0248a aVar = new C0248a();
                h hVar = h.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i10 = smartRefreshLayout2.f22327b;
                if (i10 > 0) {
                    valueAnimator = smartRefreshLayout2.J0.c(0);
                } else {
                    if (animatorUpdateListener != null || i10 == 0) {
                        ValueAnimator valueAnimator2 = smartRefreshLayout2.V0;
                        if (valueAnimator2 != null) {
                            valueAnimator2.setDuration(0L);
                            SmartRefreshLayout.this.V0.cancel();
                            SmartRefreshLayout.this.V0 = null;
                        }
                        SmartRefreshLayout.this.J0.e(0, false);
                        SmartRefreshLayout.this.J0.f(RefreshState.None);
                    } else if (!hVar.f22384c || !smartRefreshLayout2.H) {
                        valueAnimator = smartRefreshLayout2.J0.c(0);
                    } else {
                        int i11 = smartRefreshLayout2.f22360v0;
                        if (i10 >= (-i11)) {
                            smartRefreshLayout2.D(RefreshState.None);
                        } else {
                            valueAnimator = smartRefreshLayout2.J0.c(-i11);
                        }
                    }
                    valueAnimator = null;
                }
                if (valueAnimator != null) {
                    valueAnimator.addListener(aVar);
                } else {
                    aVar.onAnimationEnd(null);
                }
            }
        }

        h(int i10, boolean z10, boolean z11) {
            this.f22383b = i10;
            this.f22384c = z10;
            this.f22385d = z11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
            if (r6.G0.h() != false) goto L48;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i10 = this.f22382a;
            long j10 = 0;
            boolean z10 = true;
            if (i10 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout.K0;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 && smartRefreshLayout.L0 == RefreshState.Loading) {
                    smartRefreshLayout.L0 = refreshState2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.V0;
                    if (valueAnimator != null && ((refreshState.isDragging || refreshState == RefreshState.LoadReleased) && refreshState.isFooter)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.V0.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.V0 = null;
                        if (smartRefreshLayout2.J0.c(0) == null) {
                            SmartRefreshLayout.this.D(refreshState2);
                        } else {
                            SmartRefreshLayout.this.D(RefreshState.PullUpCanceled);
                        }
                    } else if (!(refreshState != RefreshState.Loading || smartRefreshLayout.F0 == null || smartRefreshLayout.G0 == null)) {
                        this.f22382a = i10 + 1;
                        smartRefreshLayout.I0.postDelayed(this, this.f22383b);
                        SmartRefreshLayout.this.D(RefreshState.LoadFinish);
                        return;
                    }
                }
                if (this.f22384c) {
                    SmartRefreshLayout.this.H(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int h10 = smartRefreshLayout3.F0.h(smartRefreshLayout3, this.f22385d);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            vm.f fVar = smartRefreshLayout4.f22342m0;
            if (fVar != null) {
                sm.a aVar = smartRefreshLayout4.F0;
                if (aVar instanceof sm.c) {
                    fVar.f((sm.c) aVar, this.f22385d);
                }
            }
            if (h10 < Integer.MAX_VALUE) {
                if (this.f22384c) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.H) {
                        if (smartRefreshLayout5.f22327b < 0) {
                        }
                    }
                }
                z10 = false;
                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                int i11 = smartRefreshLayout6.f22327b;
                int max = i11 - (z10 ? Math.max(i11, -smartRefreshLayout6.f22360v0) : 0);
                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                if (smartRefreshLayout7.f22343n || smartRefreshLayout7.f22348p0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.f22343n) {
                        float f10 = smartRefreshLayout8.f22337k;
                        smartRefreshLayout8.f22334i = f10;
                        smartRefreshLayout8.f22329d = smartRefreshLayout8.f22327b - max;
                        smartRefreshLayout8.f22343n = false;
                        float f11 = smartRefreshLayout8.G ? max : 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout8.f22335j, f10 + f11 + (smartRefreshLayout8.f22326a * 2), 0));
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout9.f22335j, smartRefreshLayout9.f22337k + f11, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    if (smartRefreshLayout10.f22348p0) {
                        smartRefreshLayout10.f22346o0 = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout10.f22335j, smartRefreshLayout10.f22337k, 0));
                        SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                        smartRefreshLayout11.f22348p0 = false;
                        smartRefreshLayout11.f22329d = 0;
                    }
                }
                Handler handler = SmartRefreshLayout.this.I0;
                a aVar2 = new a(max);
                if (SmartRefreshLayout.this.f22327b < 0) {
                    j10 = h10;
                }
                handler.postDelayed(aVar2, j10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class i implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        int f22392c;

        /* renamed from: f  reason: collision with root package name */
        float f22395f;

        /* renamed from: a  reason: collision with root package name */
        int f22390a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f22391b = 10;

        /* renamed from: e  reason: collision with root package name */
        float f22394e = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        long f22393d = AnimationUtils.currentAnimationTimeMillis();

        i(float f10, int i10) {
            this.f22395f = f10;
            this.f22392c = i10;
            SmartRefreshLayout.this.I0.postDelayed(this, this.f22391b);
            if (f10 > 0.0f) {
                SmartRefreshLayout.this.J0.f(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.J0.f(RefreshState.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.U0 == this && !smartRefreshLayout.K0.isFinishing) {
                if (Math.abs(smartRefreshLayout.f22327b) < Math.abs(this.f22392c)) {
                    int i10 = this.f22390a + 1;
                    this.f22390a = i10;
                    this.f22395f = (float) (this.f22395f * Math.pow(0.949999988079071d, i10 * 2));
                } else if (this.f22392c != 0) {
                    int i11 = this.f22390a + 1;
                    this.f22390a = i11;
                    this.f22395f = (float) (this.f22395f * Math.pow(0.44999998807907104d, i11 * 2));
                } else {
                    int i12 = this.f22390a + 1;
                    this.f22390a = i12;
                    this.f22395f = (float) (this.f22395f * Math.pow(0.8500000238418579d, i12 * 2));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f10 = this.f22395f * ((((float) (currentAnimationTimeMillis - this.f22393d)) * 1.0f) / 1000.0f);
                if (Math.abs(f10) >= 1.0f) {
                    this.f22393d = currentAnimationTimeMillis;
                    float f11 = this.f22394e + f10;
                    this.f22394e = f11;
                    SmartRefreshLayout.this.C(f11);
                    SmartRefreshLayout.this.I0.postDelayed(this, this.f22391b);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout2.L0;
                boolean z10 = refreshState.isDragging;
                if (z10 && refreshState.isHeader) {
                    smartRefreshLayout2.J0.f(RefreshState.PullDownCanceled);
                } else if (z10 && refreshState.isFooter) {
                    smartRefreshLayout2.J0.f(RefreshState.PullUpCanceled);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                smartRefreshLayout3.U0 = null;
                if (Math.abs(smartRefreshLayout3.f22327b) >= Math.abs(this.f22392c)) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    smartRefreshLayout4.h(this.f22392c, 0, smartRefreshLayout4.f22367z, Math.min(Math.max((int) xm.b.i(Math.abs(SmartRefreshLayout.this.f22327b - this.f22392c)), 30), 100) * 10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f22397a;

        /* renamed from: c  reason: collision with root package name */
        float f22399c;

        /* renamed from: b  reason: collision with root package name */
        int f22398b = 10;

        /* renamed from: d  reason: collision with root package name */
        float f22400d = 0.98f;

        /* renamed from: e  reason: collision with root package name */
        long f22401e = 0;

        /* renamed from: f  reason: collision with root package name */
        long f22402f = AnimationUtils.currentAnimationTimeMillis();

        j(float f10) {
            this.f22399c = f10;
            this.f22397a = SmartRefreshLayout.this.f22327b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
            if (r0.f22327b >= (-r0.f22360v0)) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
            if (r0.f22327b > r0.f22356t0) goto L33;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Runnable a() {
            RefreshState refreshState;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            RefreshState refreshState2 = smartRefreshLayout.K0;
            if (refreshState2.isFinishing) {
                return null;
            }
            if (smartRefreshLayout.f22327b != 0) {
                if (refreshState2.isOpening || (smartRefreshLayout.T && smartRefreshLayout.H && smartRefreshLayout.U && smartRefreshLayout.A(smartRefreshLayout.C))) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.K0 == RefreshState.Loading || (smartRefreshLayout2.T && smartRefreshLayout2.H && smartRefreshLayout2.U && smartRefreshLayout2.A(smartRefreshLayout2.C))) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.K0 == RefreshState.Refreshing) {
                    }
                }
                int i10 = 0;
                int i11 = SmartRefreshLayout.this.f22327b;
                float f10 = this.f22399c;
                int i12 = i11;
                while (true) {
                    if (i11 * i12 <= 0) {
                        break;
                    }
                    i10++;
                    f10 = (float) (f10 * Math.pow(this.f22400d, (this.f22398b * i10) / 10.0f));
                    float f11 = ((this.f22398b * 1.0f) / 1000.0f) * f10;
                    if (Math.abs(f11) < 1.0f) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        RefreshState refreshState3 = smartRefreshLayout5.K0;
                        if (!refreshState3.isOpening || ((refreshState3 == (refreshState = RefreshState.Refreshing) && i12 > smartRefreshLayout5.f22356t0) || (refreshState3 != refreshState && i12 < (-smartRefreshLayout5.f22360v0)))) {
                            return null;
                        }
                    } else {
                        i12 = (int) (i12 + f11);
                    }
                }
            }
            this.f22401e = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.I0.postDelayed(this, this.f22398b);
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.U0 == this && !smartRefreshLayout.K0.isFinishing) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float pow = (float) (this.f22399c * Math.pow(this.f22400d, ((float) (currentAnimationTimeMillis - this.f22401e)) / (1000.0f / this.f22398b)));
                this.f22399c = pow;
                float f10 = pow * ((((float) (currentAnimationTimeMillis - this.f22402f)) * 1.0f) / 1000.0f);
                if (Math.abs(f10) > 1.0f) {
                    this.f22402f = currentAnimationTimeMillis;
                    int i10 = (int) (this.f22397a + f10);
                    this.f22397a = i10;
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.f22327b * i10 > 0) {
                        smartRefreshLayout2.J0.e(i10, true);
                        SmartRefreshLayout.this.I0.postDelayed(this, this.f22398b);
                        return;
                    }
                    smartRefreshLayout2.U0 = null;
                    smartRefreshLayout2.J0.e(0, true);
                    xm.b.d(SmartRefreshLayout.this.G0.j(), (int) (-this.f22399c));
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.R0 && f10 > 0.0f) {
                        smartRefreshLayout3.R0 = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.U0 = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements sm.e {
        public l() {
        }

        @Override // sm.e
        public sm.e a(sm.a aVar, int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.H0 == null && i10 != 0) {
                smartRefreshLayout.H0 = new Paint();
            }
            if (aVar.equals(SmartRefreshLayout.this.E0)) {
                SmartRefreshLayout.this.N0 = i10;
            } else if (aVar.equals(SmartRefreshLayout.this.F0)) {
                SmartRefreshLayout.this.O0 = i10;
            }
            return this;
        }

        @Override // sm.e
        public sm.e b() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.K0 == RefreshState.TwoLevel) {
                smartRefreshLayout.J0.f(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.f22327b == 0) {
                    e(0, false);
                    SmartRefreshLayout.this.D(RefreshState.None);
                } else {
                    c(0).setDuration(SmartRefreshLayout.this.f22330e);
                }
            }
            return this;
        }

        @Override // sm.e
        public ValueAnimator c(int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.h(i10, 0, smartRefreshLayout.f22367z, smartRefreshLayout.f22331f);
        }

        @Override // sm.e
        public sm.f d() {
            return SmartRefreshLayout.this;
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
        @Override // sm.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public sm.e e(int i10, boolean z10) {
            vm.f fVar;
            int i11;
            int i12;
            vm.f fVar2;
            boolean z11;
            int i13;
            sm.a aVar;
            sm.a aVar2;
            sm.a aVar3;
            sm.a aVar4;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f22327b == i10 && (((aVar3 = smartRefreshLayout.E0) == null || !aVar3.e()) && ((aVar4 = SmartRefreshLayout.this.F0) == null || !aVar4.e()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i14 = smartRefreshLayout2.f22327b;
            smartRefreshLayout2.f22327b = i10;
            if (z10) {
                RefreshState refreshState = smartRefreshLayout2.L0;
                if (refreshState.isDragging || refreshState.isOpening) {
                    float f10 = i10;
                    float f11 = smartRefreshLayout2.B0;
                    if (f11 < 10.0f) {
                        f11 *= smartRefreshLayout2.f22356t0;
                    }
                    if (f10 <= f11) {
                        float f12 = -i10;
                        float f13 = smartRefreshLayout2.C0;
                        if (f13 < 10.0f) {
                            f13 *= smartRefreshLayout2.f22360v0;
                        }
                        if (f12 > f13 && !smartRefreshLayout2.T) {
                            smartRefreshLayout2.J0.f(RefreshState.ReleaseToLoad);
                        } else if (i10 < 0 && !smartRefreshLayout2.T) {
                            smartRefreshLayout2.J0.f(RefreshState.PullUpToLoad);
                        } else if (i10 > 0) {
                            smartRefreshLayout2.J0.f(RefreshState.PullDownToRefresh);
                        }
                    } else if (smartRefreshLayout2.K0 != RefreshState.ReleaseToTwoLevel) {
                        smartRefreshLayout2.J0.f(RefreshState.ReleaseToRefresh);
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (smartRefreshLayout3.G0 != null) {
                if (i10 >= 0) {
                    if (smartRefreshLayout3.B(smartRefreshLayout3.F, smartRefreshLayout3.E0)) {
                        i13 = i10;
                    } else if (i14 < 0) {
                        i13 = 0;
                    }
                    z11 = true;
                    if (i10 <= 0) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.B(smartRefreshLayout4.G, smartRefreshLayout4.F0)) {
                            i13 = i10;
                        } else if (i14 > 0) {
                            i13 = 0;
                        }
                        z11 = true;
                    }
                    if (z11) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        smartRefreshLayout5.G0.d(i13, smartRefreshLayout5.f22353s, smartRefreshLayout5.f22355t);
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.T && smartRefreshLayout6.U && smartRefreshLayout6.H) {
                            sm.a aVar5 = smartRefreshLayout6.F0;
                            if ((aVar5 instanceof sm.c) && aVar5.getSpinnerStyle() == tm.b.f35224d) {
                                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                if (smartRefreshLayout7.A(smartRefreshLayout7.C)) {
                                    SmartRefreshLayout.this.F0.getView().setTranslationY(Math.max(0, i13));
                                }
                            }
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        boolean z12 = (smartRefreshLayout8.D && (aVar2 = smartRefreshLayout8.E0) != null && aVar2.getSpinnerStyle() == tm.b.f35226f) || SmartRefreshLayout.this.N0 != 0;
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        boolean z13 = (smartRefreshLayout9.E && (aVar = smartRefreshLayout9.F0) != null && aVar.getSpinnerStyle() == tm.b.f35226f) || SmartRefreshLayout.this.O0 != 0;
                        if ((z12 && (i13 >= 0 || i14 > 0)) || (z13 && (i13 <= 0 || i14 < 0))) {
                            smartRefreshLayout2.invalidate();
                        }
                    }
                }
                i13 = 0;
                z11 = false;
                if (i10 <= 0) {
                }
                if (z11) {
                }
            }
            if ((i10 >= 0 || i14 > 0) && SmartRefreshLayout.this.E0 != null) {
                int max = Math.max(i10, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i15 = smartRefreshLayout10.f22356t0;
                float f14 = smartRefreshLayout10.f22368z0;
                if (f14 < 10.0f) {
                    f14 *= i15;
                }
                int i16 = (int) f14;
                float f15 = max * 1.0f;
                float f16 = smartRefreshLayout10.B0;
                if (f16 < 10.0f) {
                    f16 *= i15;
                }
                float f17 = f15 / f16;
                if (smartRefreshLayout10.A(smartRefreshLayout10.B) || (SmartRefreshLayout.this.K0 == RefreshState.RefreshFinish && !z10)) {
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (i14 != smartRefreshLayout11.f22327b) {
                        if (smartRefreshLayout11.E0.getSpinnerStyle() == tm.b.f35224d) {
                            SmartRefreshLayout.this.E0.getView().setTranslationY(SmartRefreshLayout.this.f22327b);
                            SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                            if (!(smartRefreshLayout12.N0 == 0 || smartRefreshLayout12.H0 == null || smartRefreshLayout12.B(smartRefreshLayout12.F, smartRefreshLayout12.E0))) {
                                smartRefreshLayout2.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.E0.getSpinnerStyle().f35232c) {
                            View view = SmartRefreshLayout.this.E0.getView();
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : SmartRefreshLayout.Z0;
                            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((SmartRefreshLayout.this.f22327b - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                            int i17 = marginLayoutParams.leftMargin;
                            int i18 = marginLayoutParams.topMargin + SmartRefreshLayout.this.f22364x0;
                            view.layout(i17, i18, view.getMeasuredWidth() + i17, view.getMeasuredHeight() + i18);
                        }
                        i12 = i16;
                        i11 = i15;
                        SmartRefreshLayout.this.E0.m(z10, f17, max, i15, i12);
                    } else {
                        i12 = i16;
                        i11 = i15;
                    }
                    if (z10 && SmartRefreshLayout.this.E0.e()) {
                        int i19 = (int) SmartRefreshLayout.this.f22335j;
                        int width = smartRefreshLayout2.getWidth();
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        smartRefreshLayout13.E0.d(smartRefreshLayout13.f22335j / (width == 0 ? 1 : width), i19, width);
                    }
                } else {
                    i12 = i16;
                    i11 = i15;
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (!(i14 == smartRefreshLayout14.f22327b || (fVar2 = smartRefreshLayout14.f22342m0) == null)) {
                    sm.a aVar6 = smartRefreshLayout14.E0;
                    if (aVar6 instanceof sm.d) {
                        fVar2.o((sm.d) aVar6, z10, f17, max, i11, i12);
                    }
                }
            }
            if ((i10 <= 0 || i14 < 0) && SmartRefreshLayout.this.F0 != null) {
                int i20 = -Math.min(i10, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i21 = smartRefreshLayout15.f22360v0;
                float f18 = smartRefreshLayout15.A0;
                if (f18 < 10.0f) {
                    f18 *= i21;
                }
                int i22 = (int) f18;
                float f19 = i20 * 1.0f;
                float f20 = smartRefreshLayout15.C0;
                if (f20 < 10.0f) {
                    f20 *= i21;
                }
                float f21 = f19 / f20;
                if (smartRefreshLayout15.A(smartRefreshLayout15.C) || (SmartRefreshLayout.this.K0 == RefreshState.LoadFinish && !z10)) {
                    SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                    if (i14 != smartRefreshLayout16.f22327b) {
                        if (smartRefreshLayout16.F0.getSpinnerStyle() == tm.b.f35224d) {
                            SmartRefreshLayout.this.F0.getView().setTranslationY(SmartRefreshLayout.this.f22327b);
                            SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                            if (!(smartRefreshLayout17.O0 == 0 || smartRefreshLayout17.H0 == null || smartRefreshLayout17.B(smartRefreshLayout17.G, smartRefreshLayout17.F0))) {
                                smartRefreshLayout2.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.F0.getSpinnerStyle().f35232c) {
                            View view2 = SmartRefreshLayout.this.F0.getView();
                            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : SmartRefreshLayout.Z0;
                            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-SmartRefreshLayout.this.f22327b) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), 1073741824));
                            int i23 = marginLayoutParams2.leftMargin;
                            int measuredHeight = (marginLayoutParams2.topMargin + smartRefreshLayout2.getMeasuredHeight()) - SmartRefreshLayout.this.f22366y0;
                            view2.layout(i23, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i23, measuredHeight);
                        }
                        SmartRefreshLayout.this.F0.m(z10, f21, i20, i21, i22);
                    }
                    if (z10 && SmartRefreshLayout.this.F0.e()) {
                        int i24 = (int) SmartRefreshLayout.this.f22335j;
                        int width2 = smartRefreshLayout2.getWidth();
                        SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                        smartRefreshLayout18.F0.d(smartRefreshLayout18.f22335j / (width2 == 0 ? 1 : width2), i24, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (!(i14 == smartRefreshLayout19.f22327b || (fVar = smartRefreshLayout19.f22342m0) == null)) {
                    sm.a aVar7 = smartRefreshLayout19.F0;
                    if (aVar7 instanceof sm.c) {
                        fVar.k((sm.c) aVar7, z10, f21, i20, i21, i22);
                    }
                }
            }
            return this;
        }

        @Override // sm.e
        public sm.e f(RefreshState refreshState) {
            switch (a.f22369a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.K0;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.f22327b == 0) {
                        smartRefreshLayout.D(refreshState3);
                        return null;
                    } else if (smartRefreshLayout.f22327b == 0) {
                        return null;
                    } else {
                        c(0);
                        return null;
                    }
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.K0.isOpening || !smartRefreshLayout2.A(smartRefreshLayout2.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.D(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.A(smartRefreshLayout3.C)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.K0;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.T || !smartRefreshLayout4.H || !smartRefreshLayout4.U)) {
                            smartRefreshLayout4.D(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.K0.isOpening || !smartRefreshLayout5.A(smartRefreshLayout5.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                        return null;
                    }
                    SmartRefreshLayout.this.D(RefreshState.PullDownCanceled);
                    f(RefreshState.None);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.A(smartRefreshLayout6.C)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.K0.isOpening && (!smartRefreshLayout7.T || !smartRefreshLayout7.H || !smartRefreshLayout7.U)) {
                            smartRefreshLayout7.D(RefreshState.PullUpCanceled);
                            f(RefreshState.None);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.K0.isOpening || !smartRefreshLayout8.A(smartRefreshLayout8.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.D(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.A(smartRefreshLayout9.C)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.K0;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.T || !smartRefreshLayout10.H || !smartRefreshLayout10.U)) {
                            smartRefreshLayout10.D(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (smartRefreshLayout11.K0.isOpening || !smartRefreshLayout11.A(smartRefreshLayout11.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    SmartRefreshLayout.this.D(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (smartRefreshLayout12.K0.isOpening || !smartRefreshLayout12.A(smartRefreshLayout12.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.D(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (smartRefreshLayout13.K0.isOpening || !smartRefreshLayout13.A(smartRefreshLayout13.C)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.D(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    return null;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    return null;
                default:
                    SmartRefreshLayout.this.D(refreshState);
                    return null;
            }
        }
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22331f = 300;
        this.f22339l = 0.5f;
        this.f22349q = -1;
        this.f22351r = -1;
        this.f22353s = -1;
        this.f22355t = -1;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = false;
        this.S = false;
        this.V = false;
        this.W = false;
        this.f22336j0 = false;
        tm.a aVar = tm.a.f35209c;
        this.f22358u0 = aVar;
        this.f22362w0 = aVar;
        this.f22368z0 = 2.5f;
        this.A0 = 2.5f;
        this.B0 = 1.0f;
        this.C0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.K0 = refreshState;
        this.L0 = refreshState;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f22363x = new Scroller(context);
        this.f22332g = context.getResources().getDisplayMetrics().heightPixels;
        this.f22326a = viewConfiguration.getScaledTouchSlop();
        this.f22357u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f22359v = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f22360v0 = xm.b.c(60.0f);
        this.f22356t0 = xm.b.c(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, um.c.f35519a);
        if (!obtainStyledAttributes.hasValue(um.c.f35521c)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(um.c.f35520b)) {
            super.setClipChildren(false);
        }
        vm.d dVar = Y0;
        if (dVar != null) {
            dVar.a(context, this);
        }
        this.f22339l = obtainStyledAttributes.getFloat(um.c.f35525g, this.f22339l);
        this.f22368z0 = obtainStyledAttributes.getFloat(um.c.H, this.f22368z0);
        this.A0 = obtainStyledAttributes.getFloat(um.c.C, this.A0);
        this.B0 = obtainStyledAttributes.getFloat(um.c.J, this.B0);
        this.C0 = obtainStyledAttributes.getFloat(um.c.E, this.C0);
        this.B = obtainStyledAttributes.getBoolean(um.c.f35540v, this.B);
        this.f22331f = obtainStyledAttributes.getInt(um.c.L, this.f22331f);
        int i10 = um.c.f35533o;
        this.C = obtainStyledAttributes.getBoolean(i10, this.C);
        int i11 = um.c.F;
        this.f22356t0 = obtainStyledAttributes.getDimensionPixelOffset(i11, this.f22356t0);
        int i12 = um.c.A;
        this.f22360v0 = obtainStyledAttributes.getDimensionPixelOffset(i12, this.f22360v0);
        this.f22364x0 = obtainStyledAttributes.getDimensionPixelOffset(um.c.G, this.f22364x0);
        this.f22366y0 = obtainStyledAttributes.getDimensionPixelOffset(um.c.B, this.f22366y0);
        this.R = obtainStyledAttributes.getBoolean(um.c.f35524f, this.R);
        this.S = obtainStyledAttributes.getBoolean(um.c.f35523e, this.S);
        int i13 = um.c.f35532n;
        this.F = obtainStyledAttributes.getBoolean(i13, this.F);
        int i14 = um.c.f35531m;
        this.G = obtainStyledAttributes.getBoolean(i14, this.G);
        this.I = obtainStyledAttributes.getBoolean(um.c.f35538t, this.I);
        this.L = obtainStyledAttributes.getBoolean(um.c.f35526h, this.L);
        this.J = obtainStyledAttributes.getBoolean(um.c.f35536r, this.J);
        this.M = obtainStyledAttributes.getBoolean(um.c.f35539u, this.M);
        this.N = obtainStyledAttributes.getBoolean(um.c.f35541w, this.N);
        this.O = obtainStyledAttributes.getBoolean(um.c.f35542x, this.O);
        this.P = obtainStyledAttributes.getBoolean(um.c.f35534p, this.P);
        boolean z10 = obtainStyledAttributes.getBoolean(um.c.f35529k, this.H);
        this.H = z10;
        this.H = obtainStyledAttributes.getBoolean(um.c.f35530l, z10);
        this.D = obtainStyledAttributes.getBoolean(um.c.f35528j, this.D);
        this.E = obtainStyledAttributes.getBoolean(um.c.f35527i, this.E);
        this.K = obtainStyledAttributes.getBoolean(um.c.f35537s, this.K);
        this.f22349q = obtainStyledAttributes.getResourceId(um.c.f35544z, this.f22349q);
        this.f22351r = obtainStyledAttributes.getResourceId(um.c.f35543y, this.f22351r);
        this.f22353s = obtainStyledAttributes.getResourceId(um.c.I, this.f22353s);
        this.f22355t = obtainStyledAttributes.getResourceId(um.c.D, this.f22355t);
        boolean z11 = obtainStyledAttributes.getBoolean(um.c.f35535q, this.Q);
        this.Q = z11;
        this.f22352r0.m(z11);
        this.V = this.V || obtainStyledAttributes.hasValue(i10);
        this.W = this.W || obtainStyledAttributes.hasValue(i13);
        this.f22336j0 = this.f22336j0 || obtainStyledAttributes.hasValue(i14);
        this.f22358u0 = obtainStyledAttributes.hasValue(i11) ? tm.a.f35215i : this.f22358u0;
        this.f22362w0 = obtainStyledAttributes.hasValue(i12) ? tm.a.f35215i : this.f22362w0;
        int color = obtainStyledAttributes.getColor(um.c.f35522d, 0);
        int color2 = obtainStyledAttributes.getColor(um.c.K, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.A = new int[]{color2, color};
            } else {
                this.A = new int[]{color2};
            }
        } else if (color != 0) {
            this.A = new int[]{0, color};
        }
        if (this.M && !this.V && !this.C) {
            this.C = true;
        }
        obtainStyledAttributes.recycle();
    }

    public static void setDefaultRefreshFooterCreator(vm.b bVar) {
        W0 = bVar;
    }

    public static void setDefaultRefreshHeaderCreator(vm.c cVar) {
        X0 = cVar;
    }

    public static void setDefaultRefreshInitializer(vm.d dVar) {
        Y0 = dVar;
    }

    protected boolean A(boolean z10) {
        return z10 && !this.M;
    }

    protected boolean B(boolean z10, sm.a aVar) {
        return z10 || this.M || aVar == null || aVar.getSpinnerStyle() == tm.b.f35226f;
    }

    protected void C(float f10) {
        RefreshState refreshState;
        float f11 = (!this.f22348p0 || this.P || f10 >= 0.0f || this.G0.h()) ? f10 : 0.0f;
        if (f11 > this.f22332g * 5 && getTag() == null) {
            int i10 = um.a.f35517a;
            if (getTag(i10) == null) {
                float f12 = this.f22337k;
                int i11 = this.f22332g;
                if (f12 < i11 / 6.0f && this.f22335j < i11 / 16.0f) {
                    Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                    setTag(i10, "你这么死拉，臣妾做不到啊！");
                }
            }
        }
        RefreshState refreshState2 = this.K0;
        if (refreshState2 == RefreshState.TwoLevel && f11 > 0.0f) {
            this.J0.e(Math.min((int) f11, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f11 >= 0.0f) {
            int i12 = this.f22356t0;
            if (f11 < i12) {
                this.J0.e((int) f11, true);
            } else {
                float f13 = this.f22368z0;
                if (f13 < 10.0f) {
                    f13 *= i12;
                }
                double d10 = f13 - i12;
                int max = Math.max((this.f22332g * 4) / 3, getHeight());
                int i13 = this.f22356t0;
                double d11 = max - i13;
                double max2 = Math.max(0.0f, (f11 - i13) * this.f22339l);
                double d12 = -max2;
                if (d11 == 0.0d) {
                    d11 = 1.0d;
                }
                this.J0.e(((int) Math.min(d10 * (1.0d - Math.pow(100.0d, d12 / d11)), max2)) + this.f22356t0, true);
            }
        } else if (f11 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.H && this.T && this.U && A(this.C)) || (this.L && !this.T && A(this.C))))) {
            int i14 = this.f22360v0;
            if (f11 > (-i14)) {
                this.J0.e((int) f11, true);
            } else {
                float f14 = this.A0;
                if (f14 < 10.0f) {
                    f14 *= i14;
                }
                double d13 = f14 - i14;
                int max3 = Math.max((this.f22332g * 4) / 3, getHeight());
                int i15 = this.f22360v0;
                double d14 = max3 - i15;
                double d15 = -Math.min(0.0f, (i15 + f11) * this.f22339l);
                double d16 = -d15;
                if (d14 == 0.0d) {
                    d14 = 1.0d;
                }
                this.J0.e(((int) (-Math.min(d13 * (1.0d - Math.pow(100.0d, d16 / d14)), d15))) - this.f22360v0, true);
            }
        } else if (f11 >= 0.0f) {
            float f15 = this.f22368z0;
            double d17 = f15 < 10.0f ? this.f22356t0 * f15 : f15;
            double max4 = Math.max(this.f22332g / 2, getHeight());
            double max5 = Math.max(0.0f, this.f22339l * f11);
            double d18 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.J0.e((int) Math.min(d17 * (1.0d - Math.pow(100.0d, d18 / max4)), max5), true);
        } else {
            float f16 = this.A0;
            double d19 = f16 < 10.0f ? this.f22360v0 * f16 : f16;
            double max6 = Math.max(this.f22332g / 2, getHeight());
            double d20 = -Math.min(0.0f, this.f22339l * f11);
            this.J0.e((int) (-Math.min(d19 * (1.0d - Math.pow(100.0d, (-d20) / (max6 == 0.0d ? 1.0d : max6))), d20)), true);
        }
        if (this.L && !this.T && A(this.C) && f11 < 0.0f && (refreshState = this.K0) != RefreshState.Refreshing && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
            if (this.S) {
                this.U0 = null;
                this.J0.c(-this.f22360v0);
            }
            setStateDirectLoading(false);
            this.I0.postDelayed(new f(), this.f22331f);
        }
    }

    protected void D(RefreshState refreshState) {
        RefreshState refreshState2 = this.K0;
        if (refreshState2 != refreshState) {
            this.K0 = refreshState;
            this.L0 = refreshState;
            sm.a aVar = this.E0;
            sm.a aVar2 = this.F0;
            vm.f fVar = this.f22342m0;
            if (aVar != null) {
                aVar.q(this, refreshState2, refreshState);
            }
            if (aVar2 != null) {
                aVar2.q(this, refreshState2, refreshState);
            }
            if (fVar != null) {
                fVar.q(this, refreshState2, refreshState);
            }
            if (refreshState == RefreshState.LoadFinish) {
                this.R0 = false;
            }
        } else if (this.L0 != refreshState2) {
            this.L0 = refreshState2;
        }
    }

    protected void E() {
        RefreshState refreshState = this.K0;
        if (refreshState != RefreshState.TwoLevel) {
            RefreshState refreshState2 = RefreshState.Loading;
            if (refreshState == refreshState2 || (this.H && this.T && this.U && this.f22327b < 0 && A(this.C))) {
                int i10 = this.f22327b;
                int i11 = this.f22360v0;
                if (i10 < (-i11)) {
                    this.J0.c(-i11);
                } else if (i10 > 0) {
                    this.J0.c(0);
                }
            } else {
                RefreshState refreshState3 = this.K0;
                RefreshState refreshState4 = RefreshState.Refreshing;
                if (refreshState3 == refreshState4) {
                    int i12 = this.f22327b;
                    int i13 = this.f22356t0;
                    if (i12 > i13) {
                        this.J0.c(i13);
                    } else if (i12 < 0) {
                        this.J0.c(0);
                    }
                } else if (refreshState3 == RefreshState.PullDownToRefresh) {
                    this.J0.f(RefreshState.PullDownCanceled);
                } else if (refreshState3 == RefreshState.PullUpToLoad) {
                    this.J0.f(RefreshState.PullUpCanceled);
                } else if (refreshState3 == RefreshState.ReleaseToRefresh) {
                    this.J0.f(refreshState4);
                } else if (refreshState3 == RefreshState.ReleaseToLoad) {
                    this.J0.f(refreshState2);
                } else if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
                    this.J0.f(RefreshState.TwoLevelReleased);
                } else if (refreshState3 == RefreshState.RefreshReleased) {
                    if (this.V0 == null) {
                        this.J0.c(this.f22356t0);
                    }
                } else if (refreshState3 == RefreshState.LoadReleased) {
                    if (this.V0 == null) {
                        this.J0.c(-this.f22360v0);
                    }
                } else if (refreshState3 != RefreshState.LoadFinish && this.f22327b != 0) {
                    this.J0.c(0);
                }
            }
        } else if (this.f22361w > -1000 && this.f22327b > getHeight() / 2) {
            ValueAnimator c10 = this.J0.c(getHeight());
            if (c10 != null) {
                c10.setDuration(this.f22330e);
            }
        } else if (this.f22343n) {
            this.J0.b();
        }
    }

    public sm.f F(boolean z10) {
        this.V = true;
        this.C = z10;
        return this;
    }

    public sm.f G(boolean z10) {
        this.P = z10;
        sm.b bVar = this.G0;
        if (bVar != null) {
            bVar.f(z10);
        }
        return this;
    }

    public sm.f H(boolean z10) {
        RefreshState refreshState = this.K0;
        if (refreshState == RefreshState.Refreshing && z10) {
            y();
        } else if (refreshState == RefreshState.Loading && z10) {
            t();
        } else if (this.T != z10) {
            this.T = z10;
            sm.a aVar = this.F0;
            if (aVar instanceof sm.c) {
                if (((sm.c) aVar).c(z10)) {
                    this.U = true;
                    if (this.T && this.H && this.f22327b > 0 && this.F0.getSpinnerStyle() == tm.b.f35224d && A(this.C) && B(this.B, this.E0)) {
                        this.F0.getView().setTranslationY(this.f22327b);
                    }
                } else {
                    this.U = false;
                    new RuntimeException("Footer:" + this.F0 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    public sm.f I(vm.e eVar) {
        this.f22340l0 = eVar;
        this.C = this.C || (!this.V && eVar != null);
        return this;
    }

    public sm.f J(vm.g gVar) {
        this.f22338k0 = gVar;
        return this;
    }

    public sm.f K(sm.c cVar) {
        return L(cVar, 0, 0);
    }

    public sm.f L(sm.c cVar, int i10, int i11) {
        sm.a aVar;
        sm.a aVar2 = this.F0;
        if (aVar2 != null) {
            super.removeView(aVar2.getView());
        }
        this.F0 = cVar;
        this.R0 = false;
        this.O0 = 0;
        this.U = false;
        this.Q0 = false;
        this.f22362w0 = tm.a.f35209c;
        this.C = !this.V || this.C;
        if (i10 == 0) {
            i10 = -1;
        }
        if (i11 == 0) {
            i11 = -2;
        }
        k kVar = new k(i10, i11);
        ViewGroup.LayoutParams layoutParams = cVar.getView().getLayoutParams();
        if (layoutParams instanceof k) {
            kVar = (k) layoutParams;
        }
        if (this.F0.getSpinnerStyle().f35231b) {
            super.addView(this.F0.getView(), getChildCount(), kVar);
        } else {
            super.addView(this.F0.getView(), 0, kVar);
        }
        int[] iArr = this.A;
        if (!(iArr == null || (aVar = this.F0) == null)) {
            aVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public sm.f M(sm.d dVar) {
        return N(dVar, 0, 0);
    }

    public sm.f N(sm.d dVar, int i10, int i11) {
        sm.a aVar;
        sm.a aVar2 = this.E0;
        if (aVar2 != null) {
            super.removeView(aVar2.getView());
        }
        this.E0 = dVar;
        this.N0 = 0;
        this.P0 = false;
        this.f22358u0 = tm.a.f35209c;
        if (i10 == 0) {
            i10 = -1;
        }
        if (i11 == 0) {
            i11 = -2;
        }
        k kVar = new k(i10, i11);
        ViewGroup.LayoutParams layoutParams = dVar.getView().getLayoutParams();
        if (layoutParams instanceof k) {
            kVar = (k) layoutParams;
        }
        if (this.E0.getSpinnerStyle().f35231b) {
            super.addView(this.E0.getView(), getChildCount(), kVar);
        } else {
            super.addView(this.E0.getView(), 0, kVar);
        }
        int[] iArr = this.A;
        if (!(iArr == null || (aVar = this.E0) == null)) {
            aVar.setPrimaryColors(iArr);
        }
        return this;
    }

    protected boolean O(float f10) {
        if (f10 == 0.0f) {
            f10 = this.f22361w;
        }
        if (Build.VERSION.SDK_INT > 27 && this.G0 != null) {
            getScaleY();
            View view = this.G0.getView();
            if (getScaleY() == -1.0f && view.getScaleY() == -1.0f) {
                f10 = -f10;
            }
        }
        if (Math.abs(f10) > this.f22357u) {
            int i10 = this.f22327b;
            if (i10 * f10 < 0.0f) {
                RefreshState refreshState = this.K0;
                if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading || (i10 < 0 && this.T)) {
                    this.U0 = new j(f10).a();
                    return true;
                } else if (refreshState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f10 < 0.0f && ((this.J && (this.C || this.K)) || ((this.K0 == RefreshState.Loading && i10 >= 0) || (this.L && A(this.C))))) || (f10 > 0.0f && ((this.J && this.B) || this.K || (this.K0 == RefreshState.Refreshing && this.f22327b <= 0)))) {
                this.S0 = false;
                this.f22363x.fling(0, 0, 0, (int) (-f10), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.f22363x.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    @Override // sm.f
    public sm.f a(boolean z10) {
        setNestedScrollingEnabled(z10);
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f22363x.getCurrY();
        if (this.f22363x.computeScrollOffset()) {
            int finalY = this.f22363x.getFinalY();
            if ((finalY >= 0 || ((!this.B && !this.K) || !this.G0.a())) && (finalY <= 0 || ((!this.C && !this.K) || !this.G0.h()))) {
                this.S0 = true;
                invalidate();
                return;
            }
            if (this.S0) {
                i(finalY > 0 ? -this.f22363x.getCurrVelocity() : this.f22363x.getCurrVelocity());
            }
            this.f22363x.forceFinished(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c6, code lost:
        if (r2.isFinishing == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ca, code lost:
        if (r2.isHeader == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00d8, code lost:
        if (r2.isFinishing == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00dc, code lost:
        if (r2.isFooter == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0108, code lost:
        if (r6 != 3) goto L226;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState;
        char c10;
        sm.a aVar;
        sm.a aVar2;
        int actionMasked = motionEvent.getActionMasked();
        int i10 = 0;
        int i11 = 1;
        boolean z10 = actionMasked == 6;
        int actionIndex = z10 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i12 = 0; i12 < pointerCount; i12++) {
            if (actionIndex != i12) {
                f10 += motionEvent.getX(i12);
                f11 += motionEvent.getY(i12);
            }
        }
        if (z10) {
            pointerCount--;
        }
        float f12 = pointerCount;
        float f13 = f10 / f12;
        float f14 = f11 / f12;
        if ((actionMasked == 6 || actionMasked == 5) && this.f22343n) {
            this.f22334i += f14 - this.f22337k;
        }
        this.f22335j = f13;
        this.f22337k = f14;
        if (this.f22348p0) {
            int i13 = this.f22346o0;
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i13 == this.f22346o0) {
                int i14 = (int) this.f22335j;
                int width = getWidth();
                float f15 = this.f22335j;
                if (width != 0) {
                    i11 = width;
                }
                float f16 = f15 / i11;
                if (A(this.B) && this.f22327b > 0 && (aVar2 = this.E0) != null && aVar2.e()) {
                    this.E0.d(f16, i14, width);
                } else if (A(this.C) && this.f22327b < 0 && (aVar = this.F0) != null && aVar.e()) {
                    this.F0.d(f16, i14, width);
                }
            }
            return dispatchTouchEvent;
        }
        if (isEnabled() && (this.B || this.C || this.K)) {
            if (this.P0) {
                RefreshState refreshState2 = this.K0;
                if (!refreshState2.isOpening) {
                }
            }
            if (this.Q0) {
                RefreshState refreshState3 = this.K0;
                if (!refreshState3.isOpening) {
                }
            }
            if (!z(actionMasked)) {
                RefreshState refreshState4 = this.K0;
                if (!refreshState4.isFinishing && ((refreshState4 != (refreshState = RefreshState.Loading) || !this.S) && (refreshState4 != RefreshState.Refreshing || !this.R))) {
                    if (actionMasked != 0) {
                        if (actionMasked != 1) {
                            if (actionMasked == 2) {
                                float f17 = f13 - this.f22333h;
                                float f18 = f14 - this.f22334i;
                                this.f22365y.addMovement(motionEvent);
                                if (!this.f22343n && !this.f22347p && (c10 = this.f22341m) != 'h' && this.G0 != null) {
                                    if (c10 == 'v' || (Math.abs(f18) >= this.f22326a && Math.abs(f17) < Math.abs(f18))) {
                                        this.f22341m = 'v';
                                        if (f18 > 0.0f && (this.f22327b < 0 || ((this.K || this.B) && this.G0.a()))) {
                                            this.f22343n = true;
                                            this.f22334i = f14 - this.f22326a;
                                        } else if (f18 < 0.0f && (this.f22327b > 0 || ((this.K || this.C) && ((this.K0 == refreshState && this.R0) || this.G0.h())))) {
                                            this.f22343n = true;
                                            this.f22334i = this.f22326a + f14;
                                        }
                                        if (this.f22343n) {
                                            f18 = f14 - this.f22334i;
                                            if (this.f22345o) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            sm.e eVar = this.J0;
                                            int i15 = this.f22327b;
                                            eVar.f((i15 > 0 || (i15 == 0 && f18 > 0.0f)) ? RefreshState.PullDownToRefresh : RefreshState.PullUpToLoad);
                                            ViewParent parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    } else if (Math.abs(f17) >= this.f22326a && Math.abs(f17) > Math.abs(f18) && this.f22341m != 'v') {
                                        this.f22341m = 'h';
                                    }
                                }
                                if (this.f22343n) {
                                    int i16 = ((int) f18) + this.f22329d;
                                    RefreshState refreshState5 = this.L0;
                                    if ((refreshState5.isHeader && (i16 < 0 || this.f22328c < 0)) || (refreshState5.isFooter && (i16 > 0 || this.f22328c > 0))) {
                                        this.f22328c = i16;
                                        long eventTime = motionEvent.getEventTime();
                                        if (this.T0 == null) {
                                            MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, this.f22333h + f17, this.f22334i, 0);
                                            this.T0 = obtain;
                                            super.dispatchTouchEvent(obtain);
                                        }
                                        MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 2, this.f22333h + f17, this.f22334i + i16, 0);
                                        super.dispatchTouchEvent(obtain2);
                                        if (this.R0 && f18 > this.f22326a && this.f22327b < 0) {
                                            this.R0 = false;
                                        }
                                        if (i16 > 0 && ((this.K || this.B) && this.G0.a())) {
                                            this.f22337k = f14;
                                            this.f22334i = f14;
                                            this.f22329d = 0;
                                            this.J0.f(RefreshState.PullDownToRefresh);
                                        } else if (i16 >= 0 || ((!this.K && !this.C) || !this.G0.h())) {
                                            i10 = i16;
                                        } else {
                                            this.f22337k = f14;
                                            this.f22334i = f14;
                                            this.f22329d = 0;
                                            this.J0.f(RefreshState.PullUpToLoad);
                                        }
                                        RefreshState refreshState6 = this.L0;
                                        if ((!refreshState6.isHeader || i10 >= 0) && (!refreshState6.isFooter || i10 <= 0)) {
                                            if (this.T0 != null) {
                                                this.T0 = null;
                                                obtain2.setAction(3);
                                                super.dispatchTouchEvent(obtain2);
                                            }
                                            obtain2.recycle();
                                            i16 = i10;
                                        } else {
                                            if (this.f22327b != 0) {
                                                C(0.0f);
                                            }
                                            return true;
                                        }
                                    }
                                    C(i16);
                                    return true;
                                } else if (this.R0 && f18 > this.f22326a && this.f22327b < 0) {
                                    this.R0 = false;
                                }
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.f22365y.addMovement(motionEvent);
                        this.f22365y.computeCurrentVelocity(1000, this.f22359v);
                        this.f22361w = (int) this.f22365y.getYVelocity();
                        O(0.0f);
                        this.f22365y.clear();
                        this.f22341m = 'n';
                        MotionEvent motionEvent2 = this.T0;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                            this.T0 = null;
                            long eventTime2 = motionEvent.getEventTime();
                            MotionEvent obtain3 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.f22333h, f14, 0);
                            super.dispatchTouchEvent(obtain3);
                            obtain3.recycle();
                        }
                        E();
                        if (this.f22343n) {
                            this.f22343n = false;
                            return true;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    this.f22361w = 0;
                    this.f22365y.addMovement(motionEvent);
                    this.f22363x.forceFinished(true);
                    this.f22333h = f13;
                    this.f22334i = f14;
                    this.f22328c = 0;
                    this.f22329d = this.f22327b;
                    this.f22343n = false;
                    this.f22347p = false;
                    this.f22345o = super.dispatchTouchEvent(motionEvent);
                    if (this.K0 != RefreshState.TwoLevel || this.f22334i >= getMeasuredHeight() * (1.0f - this.D0)) {
                        sm.b bVar = this.G0;
                        if (bVar != null) {
                            bVar.b(motionEvent);
                        }
                        return true;
                    }
                    this.f22341m = 'h';
                    return this.f22345o;
                }
            }
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        Paint paint;
        Paint paint2;
        sm.b bVar = this.G0;
        View view2 = bVar != null ? bVar.getView() : null;
        sm.a aVar = this.E0;
        if (aVar != null && aVar.getView() == view) {
            if (!A(this.B) || (!this.I && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.f22327b, view.getTop());
                int i10 = this.N0;
                if (!(i10 == 0 || (paint2 = this.H0) == null)) {
                    paint2.setColor(i10);
                    if (this.E0.getSpinnerStyle().f35232c) {
                        max = view.getBottom();
                    } else if (this.E0.getSpinnerStyle() == tm.b.f35224d) {
                        max = view.getBottom() + this.f22327b;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), max, this.H0);
                }
                if ((this.D && this.E0.getSpinnerStyle() == tm.b.f35226f) || this.E0.getSpinnerStyle().f35232c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j10);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        sm.a aVar2 = this.F0;
        if (aVar2 != null && aVar2.getView() == view) {
            if (!A(this.C) || (!this.I && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f22327b, view.getBottom());
                int i11 = this.O0;
                if (!(i11 == 0 || (paint = this.H0) == null)) {
                    paint.setColor(i11);
                    if (this.F0.getSpinnerStyle().f35232c) {
                        min = view.getTop();
                    } else if (this.F0.getSpinnerStyle() == tm.b.f35224d) {
                        min = view.getTop() + this.f22327b;
                    }
                    canvas.drawRect(0.0f, min, getWidth(), view.getBottom(), this.H0);
                }
                if ((this.E && this.F0.getSpinnerStyle() == tm.b.f35226f) || this.F0.getSpinnerStyle().f35232c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j10);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new k(getContext(), attributeSet);
    }

    @Override // sm.f
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f22354s0.a();
    }

    public sm.c getRefreshFooter() {
        sm.a aVar = this.F0;
        if (aVar instanceof sm.c) {
            return (sm.c) aVar;
        }
        return null;
    }

    public sm.d getRefreshHeader() {
        sm.a aVar = this.E0;
        if (aVar instanceof sm.d) {
            return (sm.d) aVar;
        }
        return null;
    }

    public RefreshState getState() {
        return this.K0;
    }

    protected ValueAnimator h(int i10, int i11, Interpolator interpolator, int i12) {
        if (this.f22327b == i10) {
            return null;
        }
        ValueAnimator valueAnimator = this.V0;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.V0.cancel();
            this.V0 = null;
        }
        this.U0 = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f22327b, i10);
        this.V0 = ofInt;
        ofInt.setDuration(i12);
        this.V0.setInterpolator(interpolator);
        this.V0.addListener(new d());
        this.V0.addUpdateListener(new e());
        this.V0.setStartDelay(i11);
        this.V0.start();
        return this.V0;
    }

    protected void i(float f10) {
        RefreshState refreshState;
        if (this.V0 != null) {
            return;
        }
        if (f10 > 0.0f && ((refreshState = this.K0) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
            this.U0 = new i(f10, this.f22356t0);
        } else if (f10 < 0.0f && (this.K0 == RefreshState.Loading || ((this.H && this.T && this.U && A(this.C)) || (this.L && !this.T && A(this.C) && this.K0 != RefreshState.Refreshing)))) {
            this.U0 = new i(f10, -this.f22360v0);
        } else if (this.f22327b == 0 && this.J) {
            this.U0 = new i(f10, 0);
        }
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.Q && (this.K || this.B || this.C);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        sm.a aVar;
        vm.c cVar;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.E0 == null && (cVar = X0) != null) {
                sm.d a10 = cVar.a(getContext(), this);
                if (a10 != null) {
                    M(a10);
                } else {
                    throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
                }
            }
            if (this.F0 == null) {
                vm.b bVar = W0;
                if (bVar != null) {
                    sm.c a11 = bVar.a(getContext(), this);
                    if (a11 != null) {
                        K(a11);
                    } else {
                        throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
                    }
                }
            } else {
                this.C = this.C || !this.V;
            }
            if (this.G0 == null) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    sm.a aVar2 = this.E0;
                    if ((aVar2 == null || childAt != aVar2.getView()) && ((aVar = this.F0) == null || childAt != aVar.getView())) {
                        this.G0 = new ym.a(childAt);
                    }
                }
            }
            if (this.G0 == null) {
                int c10 = xm.b.c(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(um.b.f35518a);
                super.addView(textView, 0, new k(-1, -1));
                ym.a aVar3 = new ym.a(textView);
                this.G0 = aVar3;
                aVar3.getView().setPadding(c10, c10, c10, c10);
            }
            View findViewById = findViewById(this.f22349q);
            View findViewById2 = findViewById(this.f22351r);
            this.G0.c(this.f22344n0);
            this.G0.f(this.P);
            this.G0.e(this.J0, findViewById, findViewById2);
            if (this.f22327b != 0) {
                D(RefreshState.None);
                sm.b bVar2 = this.G0;
                this.f22327b = 0;
                bVar2.d(0, this.f22353s, this.f22355t);
            }
        }
        int[] iArr = this.A;
        if (iArr != null) {
            sm.a aVar4 = this.E0;
            if (aVar4 != null) {
                aVar4.setPrimaryColors(iArr);
            }
            sm.a aVar5 = this.F0;
            if (aVar5 != null) {
                aVar5.setPrimaryColors(this.A);
            }
        }
        sm.b bVar3 = this.G0;
        if (bVar3 != null) {
            super.bringChildToFront(bVar3.getView());
        }
        sm.a aVar6 = this.E0;
        if (aVar6 != null && aVar6.getSpinnerStyle().f35231b) {
            super.bringChildToFront(this.E0.getView());
        }
        sm.a aVar7 = this.F0;
        if (aVar7 != null && aVar7.getSpinnerStyle().f35231b) {
            super.bringChildToFront(this.F0.getView());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.V = true;
        this.U0 = null;
        ValueAnimator valueAnimator = this.V0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.V0.removeAllUpdateListeners();
            this.V0.setDuration(0L);
            this.V0.cancel();
            this.V0 = null;
        }
        sm.a aVar = this.E0;
        if (aVar != null && this.K0 == RefreshState.Refreshing) {
            aVar.h(this, false);
        }
        sm.a aVar2 = this.F0;
        if (aVar2 != null && this.K0 == RefreshState.Loading) {
            aVar2.h(this, false);
        }
        if (this.f22327b != 0) {
            this.J0.e(0, true);
        }
        RefreshState refreshState = this.K0;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2) {
            D(refreshState2);
        }
        Handler handler = this.I0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.R0 = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onFinishInflate() {
        int i10;
        int i11;
        int i12;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount <= 3) {
            int i13 = -1;
            int i14 = 0;
            char c10 = 0;
            while (true) {
                i10 = 2;
                if (i14 >= childCount) {
                    break;
                }
                View childAt = super.getChildAt(i14);
                if (xm.b.e(childAt) && (c10 < 2 || i14 == 1)) {
                    i13 = i14;
                    c10 = 2;
                } else if (!(childAt instanceof sm.a) && c10 < 1) {
                    c10 = i14 > 0 ? (char) 1 : (char) 0;
                    i13 = i14;
                }
                i14++;
            }
            if (i13 >= 0) {
                this.G0 = new ym.a(super.getChildAt(i13));
                if (i13 == 1) {
                    if (childCount != 3) {
                        i10 = -1;
                    }
                    i11 = 0;
                } else if (childCount == 2) {
                    i11 = -1;
                    i10 = 1;
                }
                for (i12 = 0; i12 < childCount; i12++) {
                    View childAt2 = super.getChildAt(i12);
                    if (i12 == i11 || (i12 != i10 && i11 == -1 && this.E0 == null && (childAt2 instanceof sm.d))) {
                        this.E0 = childAt2 instanceof sm.d ? (sm.d) childAt2 : new ym.c(childAt2);
                    } else if (i12 == i10 || (i10 == -1 && (childAt2 instanceof sm.c))) {
                        this.C = this.C || !this.V;
                        this.F0 = childAt2 instanceof sm.c ? (sm.c) childAt2 : new ym.b(childAt2);
                    }
                }
                return;
            }
            i11 = -1;
            i10 = -1;
            while (i12 < childCount) {
            }
            return;
        }
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = super.getChildAt(i15);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(um.a.f35517a))) {
                sm.b bVar = this.G0;
                boolean z11 = true;
                if (bVar != null && bVar.getView() == childAt) {
                    boolean z12 = isInEditMode() && this.I && A(this.B) && this.E0 != null;
                    View view = this.G0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : Z0;
                    int i16 = marginLayoutParams.leftMargin + paddingLeft;
                    int i17 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i16;
                    int measuredHeight = view.getMeasuredHeight() + i17;
                    if (z12 && B(this.F, this.E0)) {
                        int i18 = this.f22356t0;
                        i17 += i18;
                        measuredHeight += i18;
                    }
                    view.layout(i16, i17, measuredWidth, measuredHeight);
                }
                sm.a aVar = this.E0;
                if (aVar != null && aVar.getView() == childAt) {
                    boolean z13 = isInEditMode() && this.I && A(this.B);
                    View view2 = this.E0.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : Z0;
                    int i19 = marginLayoutParams2.leftMargin;
                    int i20 = marginLayoutParams2.topMargin + this.f22364x0;
                    int measuredWidth2 = view2.getMeasuredWidth() + i19;
                    int measuredHeight2 = view2.getMeasuredHeight() + i20;
                    if (!z13 && this.E0.getSpinnerStyle() == tm.b.f35224d) {
                        int i21 = this.f22356t0;
                        i20 -= i21;
                        measuredHeight2 -= i21;
                    }
                    view2.layout(i19, i20, measuredWidth2, measuredHeight2);
                }
                sm.a aVar2 = this.F0;
                if (aVar2 != null && aVar2.getView() == childAt) {
                    if (!isInEditMode() || !this.I || !A(this.C)) {
                        z11 = false;
                    }
                    View view3 = this.F0.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : Z0;
                    tm.b spinnerStyle = this.F0.getSpinnerStyle();
                    int i22 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.f22366y0;
                    if (this.T && this.U && this.H && this.G0 != null && this.F0.getSpinnerStyle() == tm.b.f35224d && A(this.C)) {
                        View view4 = this.G0.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == tm.b.f35228h) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.f22366y0;
                    } else {
                        if (z11 || spinnerStyle == tm.b.f35227g || spinnerStyle == tm.b.f35226f) {
                            i14 = this.f22360v0;
                        } else if (spinnerStyle.f35232c && this.f22327b < 0) {
                            i14 = Math.max(A(this.C) ? -this.f22327b : 0, 0);
                        }
                        measuredHeight3 -= i14;
                    }
                    view3.layout(i22, measuredHeight3, view3.getMeasuredWidth() + i22, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        tm.a aVar;
        int i15;
        int i16;
        boolean z10 = isInEditMode() && this.I;
        int childCount = super.getChildCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < childCount) {
            View childAt = super.getChildAt(i17);
            if (childAt.getVisibility() == 8 || "GONE".equals(childAt.getTag(um.a.f35517a))) {
                i12 = childCount;
            } else {
                sm.a aVar2 = this.E0;
                if (aVar2 == null || aVar2.getView() != childAt) {
                    i12 = childCount;
                } else {
                    View view = this.E0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : Z0;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int i20 = this.f22356t0;
                    tm.a aVar3 = this.f22358u0;
                    i12 = childCount;
                    if (aVar3.f35222a < tm.a.f35215i.f35222a) {
                        int i21 = layoutParams.height;
                        if (i21 > 0) {
                            i20 = i21 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            tm.a aVar4 = tm.a.f35213g;
                            if (aVar3.a(aVar4)) {
                                this.f22356t0 = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.f22358u0 = aVar4;
                            }
                        } else if (i21 == -2 && (this.E0.getSpinnerStyle() != tm.b.f35228h || !this.f22358u0.f35223b)) {
                            int max = Math.max((View.MeasureSpec.getSize(i11) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE));
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredHeight > 0) {
                                if (measuredHeight != max) {
                                    tm.a aVar5 = this.f22358u0;
                                    tm.a aVar6 = tm.a.f35211e;
                                    if (aVar5.a(aVar6)) {
                                        this.f22356t0 = measuredHeight + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                        this.f22358u0 = aVar6;
                                    }
                                }
                                i20 = -1;
                            }
                        }
                    }
                    if (this.E0.getSpinnerStyle() == tm.b.f35228h) {
                        i20 = View.MeasureSpec.getSize(i11);
                        i16 = -1;
                        i15 = 0;
                    } else {
                        if (!this.E0.getSpinnerStyle().f35232c || z10) {
                            i15 = 0;
                        } else {
                            i15 = 0;
                            i20 = Math.max(0, A(this.B) ? this.f22327b : 0);
                        }
                        i16 = -1;
                    }
                    if (i20 != i16) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((i20 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i15), 1073741824));
                    }
                    tm.a aVar7 = this.f22358u0;
                    if (!aVar7.f35223b) {
                        float f10 = this.f22368z0;
                        if (f10 < 10.0f) {
                            f10 *= this.f22356t0;
                        }
                        this.f22358u0 = aVar7.b();
                        this.E0.a(this.J0, this.f22356t0, (int) f10);
                    }
                    if (z10 && A(this.B)) {
                        i18 += view.getMeasuredWidth();
                        i19 += view.getMeasuredHeight();
                    }
                }
                sm.a aVar8 = this.F0;
                if (aVar8 == null || aVar8.getView() != childAt) {
                    i13 = 0;
                } else {
                    View view2 = this.F0.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : Z0;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int i22 = this.f22360v0;
                    tm.a aVar9 = this.f22362w0;
                    if (aVar9.f35222a < tm.a.f35215i.f35222a) {
                        int i23 = layoutParams2.height;
                        if (i23 > 0) {
                            i22 = marginLayoutParams2.bottomMargin + i23 + marginLayoutParams2.topMargin;
                            tm.a aVar10 = tm.a.f35213g;
                            if (aVar9.a(aVar10)) {
                                this.f22360v0 = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.f22362w0 = aVar10;
                            }
                        } else if (i23 == -2 && (this.F0.getSpinnerStyle() != tm.b.f35228h || !this.f22362w0.f35223b)) {
                            int max2 = Math.max((View.MeasureSpec.getSize(i11) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(max2, Integer.MIN_VALUE));
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != max2) {
                                    tm.a aVar11 = this.f22362w0;
                                    tm.a aVar12 = tm.a.f35211e;
                                    if (aVar11.a(aVar12)) {
                                        this.f22360v0 = measuredHeight2 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.f22362w0 = aVar12;
                                    }
                                }
                                i14 = -1;
                                if (this.F0.getSpinnerStyle() != tm.b.f35228h) {
                                    i14 = View.MeasureSpec.getSize(i11);
                                } else if (this.F0.getSpinnerStyle().f35232c && !z10) {
                                    i13 = 0;
                                    i14 = Math.max(0, A(this.C) ? -this.f22327b : 0);
                                    if (i14 != -1) {
                                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((i14 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i13), 1073741824));
                                    }
                                    aVar = this.f22362w0;
                                    if (!aVar.f35223b) {
                                        float f11 = this.A0;
                                        if (f11 < 10.0f) {
                                            f11 *= this.f22360v0;
                                        }
                                        this.f22362w0 = aVar.b();
                                        this.F0.a(this.J0, this.f22360v0, (int) f11);
                                    }
                                    if (z10 && A(this.C)) {
                                        i18 += view2.getMeasuredWidth();
                                        i19 += view2.getMeasuredHeight();
                                    }
                                }
                                i13 = 0;
                                if (i14 != -1) {
                                }
                                aVar = this.f22362w0;
                                if (!aVar.f35223b) {
                                }
                                if (z10) {
                                    i18 += view2.getMeasuredWidth();
                                    i19 += view2.getMeasuredHeight();
                                }
                            }
                        }
                    }
                    i14 = i22;
                    if (this.F0.getSpinnerStyle() != tm.b.f35228h) {
                    }
                    i13 = 0;
                    if (i14 != -1) {
                    }
                    aVar = this.f22362w0;
                    if (!aVar.f35223b) {
                    }
                    if (z10) {
                    }
                }
                sm.b bVar = this.G0;
                if (bVar != null && bVar.getView() == childAt) {
                    View view3 = this.G0.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : Z0;
                    view3.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((!z10 || ((this.E0 == null || !A(this.B) || !B(this.F, this.E0)) ? i13 : 1) == 0) ? i13 : this.f22356t0) + ((!z10 || ((this.F0 == null || !A(this.C) || !B(this.G, this.F0)) ? i13 : 1) == 0) ? i13 : this.f22360v0), layoutParams3.height));
                    i18 += view3.getMeasuredWidth() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin;
                    i19 += view3.getMeasuredHeight() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
                }
            }
            i17++;
            childCount = i12;
        }
        super.setMeasuredDimension(View.resolveSize(Math.max(i18 + getPaddingLeft() + getPaddingRight(), super.getSuggestedMinimumWidth()), i10), View.resolveSize(Math.max(i19 + getPaddingTop() + getPaddingBottom(), super.getSuggestedMinimumHeight()), i11));
        this.f22335j = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return this.f22352r0.a(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return (this.R0 && f11 > 0.0f) || O(-f11) || this.f22352r0.b(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        int i12 = this.f22346o0;
        int i13 = 0;
        if (i11 * i12 > 0) {
            if (Math.abs(i11) > Math.abs(this.f22346o0)) {
                int i14 = this.f22346o0;
                this.f22346o0 = 0;
                i13 = i14;
            } else {
                this.f22346o0 -= i11;
                i13 = i11;
            }
            C(this.f22346o0);
        } else if (i11 > 0 && this.R0) {
            int i15 = i12 - i11;
            this.f22346o0 = i15;
            C(i15);
            i13 = i11;
        }
        this.f22352r0.c(i10, i11 - i13, iArr, null);
        iArr[1] = iArr[1] + i13;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        ViewParent parent;
        vm.i iVar;
        vm.i iVar2;
        boolean f10 = this.f22352r0.f(i10, i11, i12, i13, this.f22350q0);
        int i14 = i13 + this.f22350q0[1];
        if ((i14 < 0 && ((this.B || this.K) && (this.f22346o0 != 0 || (iVar2 = this.f22344n0) == null || iVar2.a(this.G0.getView())))) || (i14 > 0 && ((this.C || this.K) && (this.f22346o0 != 0 || (iVar = this.f22344n0) == null || iVar.b(this.G0.getView()))))) {
            RefreshState refreshState = this.L0;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.J0.f(i14 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!f10 && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i15 = this.f22346o0 - i14;
            this.f22346o0 = i15;
            C(i15);
        }
        if (this.R0 && i11 < 0) {
            this.R0 = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f22354s0.b(view, view2, i10);
        this.f22352r0.o(i10 & 2);
        this.f22346o0 = this.f22327b;
        this.f22348p0 = true;
        z(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return (isEnabled() && isNestedScrollingEnabled() && (i10 & 2) != 0) && (this.K || this.B || this.C);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onStopNestedScroll(View view) {
        this.f22354s0.d(view);
        this.f22348p0 = false;
        this.f22346o0 = 0;
        E();
        this.f22352r0.q();
    }

    public sm.f p() {
        return s(true);
    }

    public sm.f q(int i10) {
        return r(i10, true, false);
    }

    public sm.f r(int i10, boolean z10, boolean z11) {
        int i11 = i10 >> 16;
        int i12 = (i10 << 16) >> 16;
        h hVar = new h(i11, z11, z10);
        if (i12 > 0) {
            this.I0.postDelayed(hVar, i12);
        } else {
            hVar.run();
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        View j10 = this.G0.j();
        if ((Build.VERSION.SDK_INT >= 21 || !(j10 instanceof AbsListView)) && d0.Y(j10)) {
            this.f22347p = z10;
            super.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public sm.f s(boolean z10) {
        return r(z10 ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.M0))), 300) << 16 : 0, z10, false);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.Q = z10;
        this.f22352r0.m(z10);
    }

    protected void setStateDirectLoading(boolean z10) {
        RefreshState refreshState = this.K0;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.M0 = System.currentTimeMillis();
            this.R0 = true;
            D(refreshState2);
            vm.e eVar = this.f22340l0;
            if (eVar != null) {
                if (z10) {
                    eVar.a(this);
                }
            } else if (this.f22342m0 == null) {
                q(2000);
            }
            sm.a aVar = this.F0;
            if (aVar != null) {
                float f10 = this.A0;
                if (f10 < 10.0f) {
                    f10 *= this.f22360v0;
                }
                aVar.j(this, this.f22360v0, (int) f10);
            }
            vm.f fVar = this.f22342m0;
            if (fVar != null && (this.F0 instanceof sm.c)) {
                if (z10) {
                    fVar.a(this);
                }
                float f11 = this.A0;
                if (f11 < 10.0f) {
                    f11 *= this.f22360v0;
                }
                this.f22342m0.p((sm.c) this.F0, this.f22360v0, (int) f11);
            }
        }
    }

    protected void setStateLoading(boolean z10) {
        b bVar = new b(z10);
        D(RefreshState.LoadReleased);
        ValueAnimator c10 = this.J0.c(-this.f22360v0);
        if (c10 != null) {
            c10.addListener(bVar);
        }
        sm.a aVar = this.F0;
        if (aVar != null) {
            float f10 = this.A0;
            if (f10 < 10.0f) {
                f10 *= this.f22360v0;
            }
            aVar.n(this, this.f22360v0, (int) f10);
        }
        vm.f fVar = this.f22342m0;
        if (fVar != null) {
            sm.a aVar2 = this.F0;
            if (aVar2 instanceof sm.c) {
                float f11 = this.A0;
                if (f11 < 10.0f) {
                    f11 *= this.f22360v0;
                }
                fVar.b((sm.c) aVar2, this.f22360v0, (int) f11);
            }
        }
        if (c10 == null) {
            bVar.onAnimationEnd(null);
        }
    }

    protected void setStateRefreshing(boolean z10) {
        c cVar = new c(z10);
        D(RefreshState.RefreshReleased);
        ValueAnimator c10 = this.J0.c(this.f22356t0);
        if (c10 != null) {
            c10.addListener(cVar);
        }
        sm.a aVar = this.E0;
        if (aVar != null) {
            float f10 = this.f22368z0;
            if (f10 < 10.0f) {
                f10 *= this.f22356t0;
            }
            aVar.n(this, this.f22356t0, (int) f10);
        }
        vm.f fVar = this.f22342m0;
        if (fVar != null) {
            sm.a aVar2 = this.E0;
            if (aVar2 instanceof sm.d) {
                float f11 = this.f22368z0;
                if (f11 < 10.0f) {
                    f11 *= this.f22356t0;
                }
                fVar.i((sm.d) aVar2, this.f22356t0, (int) f11);
            }
        }
        if (c10 == null) {
            cVar.onAnimationEnd(null);
        }
    }

    protected void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.K0;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            D(RefreshState.None);
        }
        if (this.L0 != refreshState) {
            this.L0 = refreshState;
        }
    }

    public sm.f t() {
        return r(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.M0))), 300) << 16, true, true);
    }

    public sm.f u() {
        return x(true);
    }

    public sm.f v(int i10) {
        return w(i10, true, Boolean.FALSE);
    }

    public sm.f w(int i10, boolean z10, Boolean bool) {
        int i11 = i10 >> 16;
        int i12 = (i10 << 16) >> 16;
        g gVar = new g(i11, bool, z10);
        if (i12 > 0) {
            this.I0.postDelayed(gVar, i12);
        } else {
            gVar.run();
        }
        return this;
    }

    public sm.f x(boolean z10) {
        if (z10) {
            return w(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.M0))), 300) << 16, true, Boolean.FALSE);
        }
        return w(0, false, null);
    }

    public sm.f y() {
        return w(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.M0))), 300) << 16, true, Boolean.TRUE);
    }

    protected boolean z(int i10) {
        if (i10 == 0) {
            if (this.V0 != null) {
                RefreshState refreshState = this.K0;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased || refreshState == RefreshState.RefreshReleased || refreshState == RefreshState.LoadReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.J0.f(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.J0.f(RefreshState.PullUpToLoad);
                }
                this.V0.setDuration(0L);
                this.V0.cancel();
                this.V0 = null;
            }
            this.U0 = null;
        }
        return this.V0 != null;
    }

    /* loaded from: classes2.dex */
    public static class k extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f22404a;

        /* renamed from: b  reason: collision with root package name */
        public tm.b f22405b;

        public k(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f22404a = 0;
            this.f22405b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, um.c.M);
            this.f22404a = obtainStyledAttributes.getColor(um.c.N, this.f22404a);
            int i10 = um.c.O;
            if (obtainStyledAttributes.hasValue(i10)) {
                this.f22405b = tm.b.f35229i[obtainStyledAttributes.getInt(i10, tm.b.f35224d.f35230a)];
            }
            obtainStyledAttributes.recycle();
        }

        public k(int i10, int i11) {
            super(i10, i11);
            this.f22404a = 0;
            this.f22405b = null;
        }
    }
}
