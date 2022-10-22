package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.d0;
import com.huawei.agconnect.exception.AGCServerException;
/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: r  reason: collision with root package name */
    private static final int f2657r = ViewConfiguration.getTapTimeout();

    /* renamed from: c  reason: collision with root package name */
    final View f2660c;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f2661d;

    /* renamed from: g  reason: collision with root package name */
    private int f2664g;

    /* renamed from: h  reason: collision with root package name */
    private int f2665h;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2669l;

    /* renamed from: m  reason: collision with root package name */
    boolean f2670m;

    /* renamed from: n  reason: collision with root package name */
    boolean f2671n;

    /* renamed from: o  reason: collision with root package name */
    boolean f2672o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f2673p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f2674q;

    /* renamed from: a  reason: collision with root package name */
    final C0024a f2658a = new C0024a();

    /* renamed from: b  reason: collision with root package name */
    private final Interpolator f2659b = new AccelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    private float[] f2662e = {0.0f, 0.0f};

    /* renamed from: f  reason: collision with root package name */
    private float[] f2663f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i  reason: collision with root package name */
    private float[] f2666i = {0.0f, 0.0f};

    /* renamed from: j  reason: collision with root package name */
    private float[] f2667j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    private float[] f2668k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0024a {

        /* renamed from: a  reason: collision with root package name */
        private int f2675a;

        /* renamed from: b  reason: collision with root package name */
        private int f2676b;

        /* renamed from: c  reason: collision with root package name */
        private float f2677c;

        /* renamed from: d  reason: collision with root package name */
        private float f2678d;

        /* renamed from: j  reason: collision with root package name */
        private float f2684j;

        /* renamed from: k  reason: collision with root package name */
        private int f2685k;

        /* renamed from: e  reason: collision with root package name */
        private long f2679e = Long.MIN_VALUE;

        /* renamed from: i  reason: collision with root package name */
        private long f2683i = -1;

        /* renamed from: f  reason: collision with root package name */
        private long f2680f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f2681g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f2682h = 0;

        C0024a() {
        }

        private float e(long j10) {
            long j11 = this.f2679e;
            if (j10 < j11) {
                return 0.0f;
            }
            long j12 = this.f2683i;
            if (j12 < 0 || j10 < j12) {
                return a.e(((float) (j10 - j11)) / this.f2675a, 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f2684j;
            return (1.0f - f10) + (f10 * a.e(((float) (j10 - j12)) / this.f2685k, 0.0f, 1.0f));
        }

        private float g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        public void a() {
            if (this.f2680f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g10 = g(e(currentAnimationTimeMillis));
                this.f2680f = currentAnimationTimeMillis;
                float f10 = ((float) (currentAnimationTimeMillis - this.f2680f)) * g10;
                this.f2681g = (int) (this.f2677c * f10);
                this.f2682h = (int) (f10 * this.f2678d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f2681g;
        }

        public int c() {
            return this.f2682h;
        }

        public int d() {
            float f10 = this.f2677c;
            return (int) (f10 / Math.abs(f10));
        }

        public int f() {
            float f10 = this.f2678d;
            return (int) (f10 / Math.abs(f10));
        }

        public boolean h() {
            return this.f2683i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2683i + ((long) this.f2685k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2685k = a.f((int) (currentAnimationTimeMillis - this.f2679e), 0, this.f2676b);
            this.f2684j = e(currentAnimationTimeMillis);
            this.f2683i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f2676b = i10;
        }

        public void k(int i10) {
            this.f2675a = i10;
        }

        public void l(float f10, float f11) {
            this.f2677c = f10;
            this.f2678d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2679e = currentAnimationTimeMillis;
            this.f2683i = -1L;
            this.f2680f = currentAnimationTimeMillis;
            this.f2684j = 0.5f;
            this.f2681g = 0;
            this.f2682h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f2672o) {
                if (aVar.f2670m) {
                    aVar.f2670m = false;
                    aVar.f2658a.m();
                }
                C0024a aVar2 = a.this.f2658a;
                if (aVar2.h() || !a.this.u()) {
                    a.this.f2672o = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.f2671n) {
                    aVar3.f2671n = false;
                    aVar3.c();
                }
                aVar2.a();
                a.this.j(aVar2.b(), aVar2.c());
                d0.l0(a.this.f2660c, this);
            }
        }
    }

    public a(View view) {
        this.f2660c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        o(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f2657r);
        r(AGCServerException.UNKNOW_EXCEPTION);
        q(AGCServerException.UNKNOW_EXCEPTION);
    }

    private float d(int i10, float f10, float f11, float f12) {
        float h10 = h(this.f2662e[i10], f11, this.f2663f[i10], f10);
        int i11 = (h10 > 0.0f ? 1 : (h10 == 0.0f ? 0 : -1));
        if (i11 == 0) {
            return 0.0f;
        }
        float f13 = this.f2666i[i10];
        float f14 = this.f2667j[i10];
        float f15 = this.f2668k[i10];
        float f16 = f13 * f12;
        if (i11 > 0) {
            return e(h10 * f16, f14, f15);
        }
        return -e((-h10) * f16, f14, f15);
    }

    static float e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    static int f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    private float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f2664g;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (this.f2672o && i10 == 1) {
                    return 1.0f;
                }
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    private float h(float f10, float f11, float f12, float f13) {
        float f14;
        float e10 = e(f10 * f11, 0.0f, f12);
        float g10 = g(f11 - f13, e10) - g(f13, e10);
        if (g10 < 0.0f) {
            f14 = -this.f2659b.getInterpolation(-g10);
        } else if (g10 <= 0.0f) {
            return 0.0f;
        } else {
            f14 = this.f2659b.getInterpolation(g10);
        }
        return e(f14, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f2670m) {
            this.f2672o = false;
        } else {
            this.f2658a.i();
        }
    }

    private void v() {
        int i10;
        if (this.f2661d == null) {
            this.f2661d = new b();
        }
        this.f2672o = true;
        this.f2670m = true;
        if (this.f2669l || (i10 = this.f2665h) <= 0) {
            this.f2661d.run();
        } else {
            d0.m0(this.f2660c, this.f2661d, i10);
        }
        this.f2669l = true;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2660c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f2665h = i10;
        return this;
    }

    public a l(int i10) {
        this.f2664g = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f2673p && !z10) {
            i();
        }
        this.f2673p = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f2663f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f2668k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L19;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f2673p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            i();
            return this.f2674q && this.f2672o;
        }
        this.f2671n = true;
        this.f2669l = false;
        this.f2658a.l(d(0, motionEvent.getX(), view.getWidth(), this.f2660c.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f2660c.getHeight()));
        if (!this.f2672o && u()) {
            v();
        }
        if (this.f2674q) {
            return false;
        }
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f2667j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f2658a.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f2658a.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f2662e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f2666i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    boolean u() {
        C0024a aVar = this.f2658a;
        int f10 = aVar.f();
        int d10 = aVar.d();
        return (f10 != 0 && b(f10)) || (d10 != 0 && a(d10));
    }
}
