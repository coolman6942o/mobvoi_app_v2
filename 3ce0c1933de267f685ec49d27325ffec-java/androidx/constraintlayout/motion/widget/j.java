package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.l;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: MotionLayout.java */
/* loaded from: classes.dex */
public class j extends ConstraintLayout implements s {
    public static boolean A0;
    private int A;
    private boolean B;
    HashMap<View, g> C;
    private long D;
    private float E;
    float F;
    float G;
    private long H;
    float I;
    private boolean J;
    boolean K;
    private d L;
    int M;
    private boolean N;
    private x.a O;
    private androidx.constraintlayout.motion.widget.b P;
    boolean Q;
    float R;
    float S;
    long T;
    float U;
    private boolean V;
    private ArrayList<h> W;

    /* renamed from: j0  reason: collision with root package name */
    private ArrayList<h> f1704j0;

    /* renamed from: k0  reason: collision with root package name */
    private ArrayList<h> f1705k0;

    /* renamed from: l0  reason: collision with root package name */
    private CopyOnWriteArrayList<d> f1706l0;

    /* renamed from: m0  reason: collision with root package name */
    private int f1707m0;

    /* renamed from: n0  reason: collision with root package name */
    private float f1708n0;

    /* renamed from: o0  reason: collision with root package name */
    protected boolean f1709o0;

    /* renamed from: p0  reason: collision with root package name */
    float f1710p0;

    /* renamed from: q0  reason: collision with root package name */
    private s.c f1711q0;

    /* renamed from: r0  reason: collision with root package name */
    private boolean f1712r0;

    /* renamed from: s0  reason: collision with root package name */
    private c f1713s0;

    /* renamed from: t0  reason: collision with root package name */
    private Runnable f1714t0;

    /* renamed from: u  reason: collision with root package name */
    l f1715u;

    /* renamed from: u0  reason: collision with root package name */
    private int[] f1716u0;

    /* renamed from: v  reason: collision with root package name */
    Interpolator f1717v;

    /* renamed from: v0  reason: collision with root package name */
    int f1718v0;

    /* renamed from: w  reason: collision with root package name */
    Interpolator f1719w;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f1720w0;

    /* renamed from: x  reason: collision with root package name */
    float f1721x;

    /* renamed from: x0  reason: collision with root package name */
    e f1722x0;

    /* renamed from: y  reason: collision with root package name */
    private int f1723y;

    /* renamed from: y0  reason: collision with root package name */
    private boolean f1724y0;

    /* renamed from: z  reason: collision with root package name */
    int f1725z;

    /* renamed from: z0  reason: collision with root package name */
    ArrayList<Integer> f1726z0;

    /* compiled from: MotionLayout.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f1713s0.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MotionLayout.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1728a;

        static {
            int[] iArr = new int[e.values().length];
            f1728a = iArr;
            try {
                iArr[e.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1728a[e.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1728a[e.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1728a[e.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MotionLayout.java */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        float f1729a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f1730b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f1731c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1732d = -1;

        c() {
        }

        void a() {
            int i10 = this.f1731c;
            if (!(i10 == -1 && this.f1732d == -1)) {
                if (i10 == -1) {
                    j.this.R(this.f1732d);
                } else {
                    int i11 = this.f1732d;
                    if (i11 == -1) {
                        j.this.O(i10, -1, -1);
                    } else {
                        j.this.P(i10, i11);
                    }
                }
                j.this.setState(e.SETUP);
            }
            if (!Float.isNaN(this.f1730b)) {
                j.this.N(this.f1729a, this.f1730b);
                this.f1729a = Float.NaN;
                this.f1730b = Float.NaN;
                this.f1731c = -1;
                this.f1732d = -1;
            } else if (!Float.isNaN(this.f1729a)) {
                j.this.setProgress(this.f1729a);
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f1729a);
            bundle.putFloat("motion.velocity", this.f1730b);
            bundle.putInt("motion.StartState", this.f1731c);
            bundle.putInt("motion.EndState", this.f1732d);
            return bundle;
        }

        public void c() {
            this.f1732d = j.this.A;
            this.f1731c = j.this.f1723y;
            this.f1730b = j.this.getVelocity();
            this.f1729a = j.this.getProgress();
        }

        public void d(int i10) {
            this.f1732d = i10;
        }

        public void e(float f10) {
            this.f1729a = f10;
        }

        public void f(int i10) {
            this.f1731c = i10;
        }

        public void g(Bundle bundle) {
            this.f1729a = bundle.getFloat("motion.progress");
            this.f1730b = bundle.getFloat("motion.velocity");
            this.f1731c = bundle.getInt("motion.StartState");
            this.f1732d = bundle.getInt("motion.EndState");
        }

        public void h(float f10) {
            this.f1730b = f10;
        }
    }

    /* compiled from: MotionLayout.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(j jVar, int i10, int i11, float f10);

        void b(j jVar, int i10, int i11);

        void c(j jVar, int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MotionLayout.java */
    /* loaded from: classes.dex */
    public enum e {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    private void J() {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if ((this.L != null || ((copyOnWriteArrayList = this.f1706l0) != null && !copyOnWriteArrayList.isEmpty())) && this.f1708n0 != this.F) {
            if (this.f1707m0 != -1) {
                d dVar = this.L;
                if (dVar != null) {
                    dVar.b(this, this.f1723y, this.A);
                }
                CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.f1706l0;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<d> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.f1723y, this.A);
                    }
                }
            }
            this.f1707m0 = -1;
            float f10 = this.F;
            this.f1708n0 = f10;
            d dVar2 = this.L;
            if (dVar2 != null) {
                dVar2.a(this, this.f1723y, this.A, f10);
            }
            CopyOnWriteArrayList<d> copyOnWriteArrayList3 = this.f1706l0;
            if (copyOnWriteArrayList3 != null) {
                Iterator<d> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, this.f1723y, this.A, this.F);
                }
            }
        }
    }

    private void M() {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if (this.L != null || ((copyOnWriteArrayList = this.f1706l0) != null && !copyOnWriteArrayList.isEmpty())) {
            Iterator<Integer> it = this.f1726z0.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                d dVar = this.L;
                if (dVar != null) {
                    dVar.c(this, next.intValue());
                }
                CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.f1706l0;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<d> it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().c(this, next.intValue());
                    }
                }
            }
            this.f1726z0.clear();
        }
    }

    void H(float f10) {
    }

    void I(boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        float f10;
        boolean z15;
        if (this.H == -1) {
            this.H = getNanoTime();
        }
        float f11 = this.G;
        if (f11 > 0.0f && f11 < 1.0f) {
            this.f1725z = -1;
        }
        if (this.V || (this.K && (z10 || this.I != f11))) {
            float signum = Math.signum(this.I - f11);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.f1717v;
            float f12 = !(interpolator instanceof i) ? ((((float) (nanoTime - this.H)) * signum) * 1.0E-9f) / this.E : 0.0f;
            float f13 = this.G + f12;
            if (this.J) {
                f13 = this.I;
            }
            int i11 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i11 <= 0 || f13 < this.I) && (signum > 0.0f || f13 > this.I)) {
                z13 = false;
            } else {
                f13 = this.I;
                this.K = false;
                z13 = true;
            }
            this.G = f13;
            this.F = f13;
            this.H = nanoTime;
            if (interpolator == null || z13) {
                this.f1721x = f12;
            } else {
                if (this.N) {
                    f10 = interpolator.getInterpolation(((float) (nanoTime - this.D)) * 1.0E-9f);
                    Interpolator interpolator2 = this.f1717v;
                    if (interpolator2 != this.O) {
                        this.G = f10;
                        this.H = nanoTime;
                        if (interpolator2 instanceof i) {
                            float a10 = ((i) interpolator2).a();
                            this.f1721x = a10;
                            int i12 = ((Math.abs(a10) * this.E) > 1.0E-5f ? 1 : ((Math.abs(a10) * this.E) == 1.0E-5f ? 0 : -1));
                            if (a10 <= 0.0f || f10 < 1.0f) {
                                z15 = false;
                            } else {
                                this.G = 1.0f;
                                z15 = false;
                                this.K = false;
                                f10 = 1.0f;
                            }
                            if (a10 < 0.0f && f10 <= 0.0f) {
                                this.G = 0.0f;
                                this.K = z15;
                                f13 = 0.0f;
                            }
                        }
                    } else {
                        throw null;
                    }
                } else {
                    f10 = interpolator.getInterpolation(f13);
                    Interpolator interpolator3 = this.f1717v;
                    if (interpolator3 instanceof i) {
                        this.f1721x = ((i) interpolator3).a();
                    } else {
                        this.f1721x = ((interpolator3.getInterpolation(f13 + f12) - f10) * signum) / f12;
                    }
                }
                f13 = f10;
            }
            if (Math.abs(this.f1721x) > 1.0E-5f) {
                setState(e.MOVING);
            }
            if ((i11 > 0 && f13 >= this.I) || (signum <= 0.0f && f13 <= this.I)) {
                f13 = this.I;
                this.K = false;
            }
            if (f13 >= 1.0f || f13 <= 0.0f) {
                z14 = false;
                this.K = false;
                setState(e.FINISHED);
            } else {
                z14 = false;
            }
            int childCount = getChildCount();
            this.V = z14;
            long nanoTime2 = getNanoTime();
            this.f1710p0 = f13;
            Interpolator interpolator4 = this.f1719w;
            float interpolation = interpolator4 == null ? f13 : interpolator4.getInterpolation(f13);
            Interpolator interpolator5 = this.f1719w;
            if (interpolator5 != null) {
                float interpolation2 = interpolator5.getInterpolation((signum / this.E) + f13);
                this.f1721x = interpolation2;
                this.f1721x = interpolation2 - this.f1719w.getInterpolation(f13);
            }
            int i13 = z14 ? 1 : 0;
            Object[] objArr = z14 ? 1 : 0;
            for (int i14 = i13; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                g gVar = this.C.get(childAt);
                if (gVar != null) {
                    this.V = gVar.c(childAt, interpolation, nanoTime2, this.f1711q0) | this.V;
                }
            }
            boolean z16 = (i11 > 0 && f13 >= this.I) || (signum <= 0.0f && f13 <= this.I);
            if (!this.V && !this.K && z16) {
                setState(e.FINISHED);
            }
            if (this.f1709o0) {
                requestLayout();
            }
            z11 = true;
            boolean z17 = this.V | (!z16);
            this.V = z17;
            if (f13 > 0.0f || (i10 = this.f1723y) == -1 || this.f1725z == i10) {
                if (f13 >= 1.0d) {
                    int i15 = this.f1725z;
                    int i16 = this.A;
                    if (i15 != i16) {
                        this.f1725z = i16;
                        throw null;
                    }
                }
                if (z17 || this.K) {
                    invalidate();
                } else if ((i11 > 0 && f13 == 1.0f) || (signum < 0.0f && f13 == 0.0f)) {
                    setState(e.FINISHED);
                }
                if (!this.V && !this.K && ((i11 > 0 && f13 == 1.0f) || (signum < 0.0f && f13 == 0.0f))) {
                    L();
                }
            } else {
                this.f1725z = i10;
                throw null;
            }
        } else {
            z11 = true;
        }
        float f14 = this.G;
        if (f14 >= 1.0f) {
            int i17 = this.f1725z;
            int i18 = this.A;
            if (i17 == i18) {
                z11 = false;
            }
            this.f1725z = i18;
        } else if (f14 <= 0.0f) {
            int i19 = this.f1725z;
            int i20 = this.f1723y;
            if (i19 == i20) {
                z11 = false;
            }
            this.f1725z = i20;
        } else {
            z12 = false;
            this.f1724y0 |= z12;
            if (z12 && !this.f1712r0) {
                requestLayout();
            }
            this.F = this.G;
        }
        z12 = z11;
        this.f1724y0 |= z12;
        if (z12) {
            requestLayout();
        }
        this.F = this.G;
    }

    protected void K() {
        int i10;
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if ((this.L != null || ((copyOnWriteArrayList = this.f1706l0) != null && !copyOnWriteArrayList.isEmpty())) && this.f1707m0 == -1) {
            this.f1707m0 = this.f1725z;
            if (!this.f1726z0.isEmpty()) {
                ArrayList<Integer> arrayList = this.f1726z0;
                i10 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i10 = -1;
            }
            int i11 = this.f1725z;
            if (!(i10 == i11 || i11 == -1)) {
                this.f1726z0.add(Integer.valueOf(i11));
            }
        }
        M();
        Runnable runnable = this.f1714t0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f1716u0;
        if (iArr != null && this.f1718v0 > 0) {
            R(iArr[0]);
            int[] iArr2 = this.f1716u0;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.f1718v0--;
        }
    }

    void L() {
    }

    public void N(float f10, float f11) {
        if (!isAttachedToWindow()) {
            if (this.f1713s0 == null) {
                this.f1713s0 = new c();
            }
            this.f1713s0.e(f10);
            this.f1713s0.h(f11);
            return;
        }
        setProgress(f10);
        setState(e.MOVING);
        this.f1721x = f11;
        float f12 = 0.0f;
        int i10 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i10 != 0) {
            if (i10 > 0) {
                f12 = 1.0f;
            }
            H(f12);
        } else if (f10 != 0.0f && f10 != 1.0f) {
            if (f10 > 0.5f) {
                f12 = 1.0f;
            }
            H(f12);
        }
    }

    public void O(int i10, int i11, int i12) {
        setState(e.SETUP);
        this.f1725z = i10;
        this.f1723y = -1;
        this.A = -1;
        androidx.constraintlayout.widget.b bVar = this.f1774k;
        if (bVar != null) {
            bVar.d(i10, i11, i12);
        }
    }

    public void P(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.f1713s0 == null) {
                this.f1713s0 = new c();
            }
            this.f1713s0.f(i10);
            this.f1713s0.d(i11);
        }
    }

    public void Q() {
        H(1.0f);
        this.f1714t0 = null;
    }

    public void R(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f1713s0 == null) {
                this.f1713s0 = new c();
            }
            this.f1713s0.d(i10);
            return;
        }
        S(i10, -1, -1);
    }

    public void S(int i10, int i11, int i12) {
        T(i10, i11, i12, -1);
    }

    public void T(int i10, int i11, int i12, int i13) {
        int i14 = this.f1725z;
        if (i14 != i10) {
            if (this.f1723y == i10) {
                H(0.0f);
                if (i13 > 0) {
                    this.E = i13 / 1000.0f;
                }
            } else if (this.A == i10) {
                H(1.0f);
                if (i13 > 0) {
                    this.E = i13 / 1000.0f;
                }
            } else {
                this.A = i10;
                if (i14 != -1) {
                    P(i14, i10);
                    H(1.0f);
                    this.G = 0.0f;
                    Q();
                    if (i13 > 0) {
                        this.E = i13 / 1000.0f;
                        return;
                    }
                    return;
                }
                this.N = false;
                this.I = 1.0f;
                this.F = 0.0f;
                this.G = 0.0f;
                this.H = getNanoTime();
                this.D = getNanoTime();
                this.J = false;
                this.f1717v = null;
                if (i13 == -1) {
                    throw null;
                }
                this.f1723y = -1;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        ArrayList<h> arrayList = this.f1705k0;
        if (arrayList != null) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().w(canvas);
            }
        }
        I(false);
        super.dispatchDraw(canvas);
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.f1725z;
    }

    public ArrayList<l.a> getDefinedTransitions() {
        return null;
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.P == null) {
            this.P = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.P;
    }

    public int getEndState() {
        return this.A;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.G;
    }

    public l getScene() {
        return this.f1715u;
    }

    public int getStartState() {
        return this.f1723y;
    }

    public float getTargetPosition() {
        return this.I;
    }

    public Bundle getTransitionState() {
        if (this.f1713s0 == null) {
            this.f1713s0 = new c();
        }
        this.f1713s0.c();
        return this.f1713s0.b();
    }

    public long getTransitionTimeMs() {
        return this.E * 1000.0f;
    }

    public float getVelocity() {
        return this.f1721x;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    @Override // androidx.core.view.s
    public void j(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (!(!this.Q && i10 == 0 && i11 == 0)) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.Q = false;
    }

    @Override // androidx.core.view.r
    public void k(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    @Override // androidx.core.view.r
    public boolean l(View view, View view2, int i10, int i11) {
        return false;
    }

    @Override // androidx.core.view.r
    public void m(View view, View view2, int i10, int i11) {
        this.T = getNanoTime();
        this.U = 0.0f;
        this.R = 0.0f;
        this.S = 0.0f;
    }

    @Override // androidx.core.view.r
    public void n(View view, int i10) {
    }

    @Override // androidx.core.view.r
    public void o(View view, int i10, int i11, int[] iArr, int i12) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Display display;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && (display = getDisplay()) != null) {
            display.getRotation();
        }
        L();
        c cVar = this.f1713s0;
        if (cVar == null) {
            return;
        }
        if (this.f1720w0) {
            post(new a());
        } else {
            cVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f1712r0 = true;
        try {
            super.onLayout(z10, i10, i11, i12, i13);
        } finally {
            this.f1712r0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof h) {
            h hVar = (h) view;
            if (this.f1706l0 == null) {
                this.f1706l0 = new CopyOnWriteArrayList<>();
            }
            this.f1706l0.add(hVar);
            if (hVar.v()) {
                if (this.W == null) {
                    this.W = new ArrayList<>();
                }
                this.W.add(hVar);
            }
            if (hVar.u()) {
                if (this.f1704j0 == null) {
                    this.f1704j0 = new ArrayList<>();
                }
                this.f1704j0.add(hVar);
            }
            if (hVar.t()) {
                if (this.f1705k0 == null) {
                    this.f1705k0 = new ArrayList<>();
                }
                this.f1705k0.add(hVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<h> arrayList = this.W;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<h> arrayList2 = this.f1704j0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f1709o0) {
            int i10 = this.f1725z;
        }
        super.requestLayout();
    }

    public void setDebugMode(int i10) {
        this.M = i10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.f1720w0 = z10;
    }

    public void setInteractionEnabled(boolean z10) {
        this.B = z10;
    }

    public void setInterpolatedProgress(float f10) {
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<h> arrayList = this.f1704j0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f1704j0.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<h> arrayList = this.W;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.W.get(i10).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10) {
        int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i10 < 0 || f10 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f1713s0 == null) {
                this.f1713s0 = new c();
            }
            this.f1713s0.e(f10);
        } else if (i10 <= 0) {
            if (this.G == 1.0f && this.f1725z == this.A) {
                setState(e.MOVING);
            }
            this.f1725z = this.f1723y;
            if (this.G == 0.0f) {
                setState(e.FINISHED);
            }
        } else if (f10 >= 1.0f) {
            if (this.G == 0.0f && this.f1725z == this.f1723y) {
                setState(e.MOVING);
            }
            this.f1725z = this.A;
            if (this.G == 1.0f) {
                setState(e.FINISHED);
            }
        } else {
            this.f1725z = -1;
            setState(e.MOVING);
        }
    }

    public void setScene(l lVar) {
        u();
        throw null;
    }

    void setStartState(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f1713s0 == null) {
                this.f1713s0 = new c();
            }
            this.f1713s0.f(i10);
            this.f1713s0.d(i10);
            return;
        }
        this.f1725z = i10;
    }

    void setState(e eVar) {
        e eVar2 = e.FINISHED;
        if (eVar != eVar2 || this.f1725z != -1) {
            e eVar3 = this.f1722x0;
            this.f1722x0 = eVar;
            e eVar4 = e.MOVING;
            if (eVar3 == eVar4 && eVar == eVar4) {
                J();
            }
            int i10 = b.f1728a[eVar3.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (eVar == eVar4) {
                    J();
                }
                if (eVar == eVar2) {
                    K();
                }
            } else if (i10 == 3 && eVar == eVar2) {
                K();
            }
        }
    }

    public void setTransition(int i10) {
    }

    protected void setTransition(l.a aVar) {
        throw null;
    }

    public void setTransitionDuration(int i10) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setTransitionListener(d dVar) {
        this.L = dVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f1713s0 == null) {
            this.f1713s0 = new c();
        }
        this.f1713s0.g(bundle);
        if (isAttachedToWindow()) {
            this.f1713s0.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        String a10 = androidx.constraintlayout.motion.widget.a.a(context, this.f1723y);
        String a11 = androidx.constraintlayout.motion.widget.a.a(context, this.A);
        float f10 = this.G;
        float f11 = this.f1721x;
        StringBuilder sb2 = new StringBuilder(String.valueOf(a10).length() + 47 + String.valueOf(a11).length());
        sb2.append(a10);
        sb2.append("->");
        sb2.append(a11);
        sb2.append(" (pos:");
        sb2.append(f10);
        sb2.append(" Dpos/Dt:");
        sb2.append(f11);
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void w(int i10) {
        this.f1774k = null;
    }
}
