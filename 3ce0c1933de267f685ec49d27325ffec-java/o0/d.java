package o0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.d0;
import java.util.Arrays;
/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: x  reason: collision with root package name */
    private static final Interpolator f31378x = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f31379a;

    /* renamed from: b  reason: collision with root package name */
    private int f31380b;

    /* renamed from: d  reason: collision with root package name */
    private float[] f31382d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f31383e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f31384f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f31385g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f31386h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f31387i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f31388j;

    /* renamed from: k  reason: collision with root package name */
    private int f31389k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f31390l;

    /* renamed from: m  reason: collision with root package name */
    private float f31391m;

    /* renamed from: n  reason: collision with root package name */
    private float f31392n;

    /* renamed from: o  reason: collision with root package name */
    private int f31393o;

    /* renamed from: p  reason: collision with root package name */
    private final int f31394p;

    /* renamed from: q  reason: collision with root package name */
    private int f31395q;

    /* renamed from: r  reason: collision with root package name */
    private OverScroller f31396r;

    /* renamed from: s  reason: collision with root package name */
    private final c f31397s;

    /* renamed from: t  reason: collision with root package name */
    private View f31398t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f31399u;

    /* renamed from: v  reason: collision with root package name */
    private final ViewGroup f31400v;

    /* renamed from: c  reason: collision with root package name */
    private int f31381c = -1;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f31401w = new b();

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.K(0);
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract int a(View view, int i10, int i11);

        public abstract int b(View view, int i10, int i11);

        public int c(int i10) {
            return i10;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(View view, int i10) {
        }

        public abstract void j(int i10);

        public abstract void k(View view, int i10, int i11, int i12, int i13);

        public abstract void l(View view, float f10, float f11);

        public abstract boolean m(View view, int i10);
    }

    private d(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cVar != null) {
            this.f31400v = viewGroup;
            this.f31397s = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f31394p = i10;
            this.f31393o = i10;
            this.f31380b = viewConfiguration.getScaledTouchSlop();
            this.f31391m = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f31392n = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f31396r = new OverScroller(context, f31378x);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private boolean D(int i10) {
        if (C(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void G() {
        this.f31390l.computeCurrentVelocity(1000, this.f31391m);
        p(g(this.f31390l.getXVelocity(this.f31381c), this.f31392n, this.f31391m), g(this.f31390l.getYVelocity(this.f31381c), this.f31392n, this.f31391m));
    }

    private void H(float f10, float f11, int i10) {
        boolean c10 = c(f10, f11, i10, 1);
        if (c(f11, f10, i10, 4)) {
            c10 |= true;
        }
        if (c(f10, f11, i10, 2)) {
            boolean z10 = c10 ? 1 : 0;
            char c11 = c10 ? 1 : 0;
            c10 = z10 | true;
        }
        if (c(f11, f10, i10, 8)) {
            boolean z11 = c10 ? 1 : 0;
            char c12 = c10 ? 1 : 0;
            c10 = z11 | true;
        }
        if (c10) {
            int[] iArr = this.f31387i;
            iArr[i10] = iArr[i10] | (c10 ? 1 : 0);
            c cVar = this.f31397s;
            int i11 = c10 ? 1 : 0;
            int i12 = c10 ? 1 : 0;
            int i13 = c10 ? 1 : 0;
            cVar.f(i11, i10);
        }
    }

    private void I(float f10, float f11, int i10) {
        s(i10);
        float[] fArr = this.f31382d;
        this.f31384f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f31383e;
        this.f31385g[i10] = f11;
        fArr2[i10] = f11;
        this.f31386h[i10] = y((int) f10, (int) f11);
        this.f31389k |= 1 << i10;
    }

    private void J(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (D(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f31384f[pointerId] = x10;
                this.f31385g[pointerId] = y10;
            }
        }
    }

    private boolean c(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f31386h[i10] & i11) != i11 || (this.f31395q & i11) == 0 || (this.f31388j[i10] & i11) == i11 || (this.f31387i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f31380b;
        if (abs <= i12 && abs2 <= i12) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f31397s.g(i11)) {
            return (this.f31387i[i10] & i11) == 0 && abs > ((float) this.f31380b);
        }
        int[] iArr = this.f31388j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    private boolean f(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f31397s.d(view) > 0;
        boolean z11 = this.f31397s.e(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f31380b) : z11 && Math.abs(f11) > ((float) this.f31380b);
        }
        int i10 = this.f31380b;
        return (f10 * f10) + (f11 * f11) > ((float) (i10 * i10));
    }

    private float g(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        return abs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    private int h(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        return abs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    private void i() {
        float[] fArr = this.f31382d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f31383e, 0.0f);
            Arrays.fill(this.f31384f, 0.0f);
            Arrays.fill(this.f31385g, 0.0f);
            Arrays.fill(this.f31386h, 0);
            Arrays.fill(this.f31387i, 0);
            Arrays.fill(this.f31388j, 0);
            this.f31389k = 0;
        }
    }

    private void j(int i10) {
        if (this.f31382d != null && C(i10)) {
            this.f31382d[i10] = 0.0f;
            this.f31383e[i10] = 0.0f;
            this.f31384f[i10] = 0.0f;
            this.f31385g[i10] = 0.0f;
            this.f31386h[i10] = 0;
            this.f31387i[i10] = 0;
            this.f31388j[i10] = 0;
            this.f31389k = (~(1 << i10)) & this.f31389k;
        }
    }

    private int k(int i10, int i11, int i12) {
        int i13;
        if (i10 == 0) {
            return 0;
        }
        int width = this.f31400v.getWidth();
        float f10 = width / 2;
        float q5 = f10 + (q(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int abs = Math.abs(i11);
        if (abs > 0) {
            i13 = Math.round(Math.abs(q5 / abs) * 1000.0f) * 4;
        } else {
            i13 = (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f);
        }
        return Math.min(i13, 600);
    }

    private int l(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int h10 = h(i12, (int) this.f31392n, (int) this.f31391m);
        int h11 = h(i13, (int) this.f31392n, (int) this.f31391m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(h10);
        int abs4 = Math.abs(h11);
        int i14 = abs3 + abs4;
        int i15 = abs + abs2;
        if (h10 != 0) {
            f11 = abs3;
            f10 = i14;
        } else {
            f11 = abs;
            f10 = i15;
        }
        float f14 = f11 / f10;
        if (h11 != 0) {
            f13 = abs4;
            f12 = i14;
        } else {
            f13 = abs2;
            f12 = i15;
        }
        return (int) ((k(i10, h10, this.f31397s.d(view)) * f14) + (k(i11, h11, this.f31397s.e(view)) * (f13 / f12)));
    }

    public static d n(ViewGroup viewGroup, float f10, c cVar) {
        d o10 = o(viewGroup, cVar);
        o10.f31380b = (int) (o10.f31380b * (1.0f / f10));
        return o10;
    }

    public static d o(ViewGroup viewGroup, c cVar) {
        return new d(viewGroup.getContext(), viewGroup, cVar);
    }

    private void p(float f10, float f11) {
        this.f31399u = true;
        this.f31397s.l(this.f31398t, f10, f11);
        this.f31399u = false;
        if (this.f31379a == 1) {
            K(0);
        }
    }

    private float q(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    private void r(int i10, int i11, int i12, int i13) {
        int left = this.f31398t.getLeft();
        int top = this.f31398t.getTop();
        if (i12 != 0) {
            i10 = this.f31397s.a(this.f31398t, i10, i12);
            d0.d0(this.f31398t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f31397s.b(this.f31398t, i11, i13);
            d0.e0(this.f31398t, i11 - top);
        }
        int i15 = i11;
        if (i12 != 0 || i13 != 0) {
            this.f31397s.k(this.f31398t, i14, i15, i14 - left, i15 - top);
        }
    }

    private void s(int i10) {
        float[] fArr = this.f31382d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f31383e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f31384f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f31385g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f31386h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f31387i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f31388j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f31382d = fArr2;
            this.f31383e = fArr3;
            this.f31384f = fArr4;
            this.f31385g = fArr5;
            this.f31386h = iArr;
            this.f31387i = iArr2;
            this.f31388j = iArr3;
        }
    }

    private boolean u(int i10, int i11, int i12, int i13) {
        int left = this.f31398t.getLeft();
        int top = this.f31398t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f31396r.abortAnimation();
            K(0);
            return false;
        }
        this.f31396r.startScroll(left, top, i14, i15, l(this.f31398t, i14, i15, i12, i13));
        K(2);
        return true;
    }

    private int y(int i10, int i11) {
        int i12 = i10 < this.f31400v.getLeft() + this.f31393o ? 1 : 0;
        if (i11 < this.f31400v.getTop() + this.f31393o) {
            i12 |= 4;
        }
        if (i10 > this.f31400v.getRight() - this.f31393o) {
            i12 |= 2;
        }
        return i11 > this.f31400v.getBottom() - this.f31393o ? i12 | 8 : i12;
    }

    public int A() {
        return this.f31379a;
    }

    public boolean B(int i10, int i11) {
        return E(this.f31398t, i10, i11);
    }

    public boolean C(int i10) {
        return ((1 << i10) & this.f31389k) != 0;
    }

    public boolean E(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public void F(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f31390l == null) {
            this.f31390l = VelocityTracker.obtain();
        }
        this.f31390l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View t10 = t((int) x10, (int) y10);
            I(x10, y10, pointerId);
            R(t10, pointerId);
            int i12 = this.f31386h[pointerId];
            int i13 = this.f31395q;
            if ((i12 & i13) != 0) {
                this.f31397s.h(i12 & i13, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f31379a == 1) {
                G();
            }
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f31379a == 1) {
                    p(0.0f, 0.0f);
                }
                a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x11 = motionEvent.getX(actionIndex);
                float y11 = motionEvent.getY(actionIndex);
                I(x11, y11, pointerId2);
                if (this.f31379a == 0) {
                    R(t((int) x11, (int) y11), pointerId2);
                    int i14 = this.f31386h[pointerId2];
                    int i15 = this.f31395q;
                    if ((i14 & i15) != 0) {
                        this.f31397s.h(i14 & i15, pointerId2);
                    }
                } else if (B((int) x11, (int) y11)) {
                    R(this.f31398t, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f31379a == 1 && pointerId3 == this.f31381c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i11 >= pointerCount) {
                            i10 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i11);
                        if (pointerId4 != this.f31381c) {
                            View t11 = t((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                            View view = this.f31398t;
                            if (t11 == view && R(view, pointerId4)) {
                                i10 = this.f31381c;
                                break;
                            }
                        }
                        i11++;
                    }
                    if (i10 == -1) {
                        G();
                    }
                }
                j(pointerId3);
            }
        } else if (this.f31379a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i11 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i11);
                if (D(pointerId5)) {
                    float x12 = motionEvent.getX(i11);
                    float y12 = motionEvent.getY(i11);
                    float f10 = x12 - this.f31382d[pointerId5];
                    float f11 = y12 - this.f31383e[pointerId5];
                    H(f10, f11, pointerId5);
                    if (this.f31379a != 1) {
                        View t12 = t((int) x12, (int) y12);
                        if (f(t12, f10, f11) && R(t12, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            J(motionEvent);
        } else if (D(this.f31381c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f31381c);
            float x13 = motionEvent.getX(findPointerIndex);
            float y13 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f31384f;
            int i16 = this.f31381c;
            int i17 = (int) (x13 - fArr[i16]);
            int i18 = (int) (y13 - this.f31385g[i16]);
            r(this.f31398t.getLeft() + i17, this.f31398t.getTop() + i18, i17, i18);
            J(motionEvent);
        }
    }

    void K(int i10) {
        this.f31400v.removeCallbacks(this.f31401w);
        if (this.f31379a != i10) {
            this.f31379a = i10;
            this.f31397s.j(i10);
            if (this.f31379a == 0) {
                this.f31398t = null;
            }
        }
    }

    public void L(int i10) {
        this.f31393o = i10;
    }

    public void M(int i10) {
        this.f31395q = i10;
    }

    public void N(float f10) {
        this.f31392n = f10;
    }

    public boolean O(int i10, int i11) {
        if (this.f31399u) {
            return u(i10, i11, (int) this.f31390l.getXVelocity(this.f31381c), (int) this.f31390l.getYVelocity(this.f31381c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00dd, code lost:
        if (r12 != r11) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean P(MotionEvent motionEvent) {
        boolean z10;
        View t10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f31390l == null) {
            this.f31390l = VelocityTracker.obtain();
        }
        this.f31390l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x10 = motionEvent.getX(actionIndex);
                            float y10 = motionEvent.getY(actionIndex);
                            I(x10, y10, pointerId);
                            int i10 = this.f31379a;
                            if (i10 == 0) {
                                int i11 = this.f31386h[pointerId];
                                int i12 = this.f31395q;
                                if ((i11 & i12) != 0) {
                                    this.f31397s.h(i11 & i12, pointerId);
                                }
                            } else if (i10 == 2 && (t10 = t((int) x10, (int) y10)) == this.f31398t) {
                                R(t10, pointerId);
                            }
                        } else if (actionMasked == 6) {
                            j(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (!(this.f31382d == null || this.f31383e == null)) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i13 = 0; i13 < pointerCount; i13++) {
                        int pointerId2 = motionEvent.getPointerId(i13);
                        if (D(pointerId2)) {
                            float x11 = motionEvent.getX(i13);
                            float y11 = motionEvent.getY(i13);
                            float f10 = x11 - this.f31382d[pointerId2];
                            float f11 = y11 - this.f31383e[pointerId2];
                            View t11 = t((int) x11, (int) y11);
                            boolean z11 = t11 != null && f(t11, f10, f11);
                            if (z11) {
                                int left = t11.getLeft();
                                int i14 = (int) f10;
                                int a10 = this.f31397s.a(t11, left + i14, i14);
                                int top = t11.getTop();
                                int i15 = (int) f11;
                                int b10 = this.f31397s.b(t11, top + i15, i15);
                                int d10 = this.f31397s.d(t11);
                                int e10 = this.f31397s.e(t11);
                                if (d10 != 0) {
                                    if (d10 > 0) {
                                    }
                                }
                                if (e10 != 0) {
                                    if (e10 > 0 && b10 == top) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            H(f10, f11, pointerId2);
                            if (this.f31379a != 1) {
                                if (z11 && R(t11, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    J(motionEvent);
                }
                z10 = false;
            }
            a();
            z10 = false;
        } else {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            z10 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            I(x12, y12, pointerId3);
            View t12 = t((int) x12, (int) y12);
            if (t12 == this.f31398t && this.f31379a == 2) {
                R(t12, pointerId3);
            }
            int i16 = this.f31386h[pointerId3];
            int i17 = this.f31395q;
            if ((i16 & i17) != 0) {
                this.f31397s.h(i16 & i17, pointerId3);
            }
        }
        if (this.f31379a == 1) {
            return true;
        }
        return z10;
    }

    public boolean Q(View view, int i10, int i11) {
        this.f31398t = view;
        this.f31381c = -1;
        boolean u10 = u(i10, i11, 0, 0);
        if (!u10 && this.f31379a == 0 && this.f31398t != null) {
            this.f31398t = null;
        }
        return u10;
    }

    boolean R(View view, int i10) {
        if (view == this.f31398t && this.f31381c == i10) {
            return true;
        }
        if (view == null || !this.f31397s.m(view, i10)) {
            return false;
        }
        this.f31381c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f31381c = -1;
        i();
        VelocityTracker velocityTracker = this.f31390l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f31390l = null;
        }
    }

    public void b(View view, int i10) {
        if (view.getParent() == this.f31400v) {
            this.f31398t = view;
            this.f31381c = i10;
            this.f31397s.i(view, i10);
            K(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f31400v + ")");
    }

    public boolean d(int i10) {
        int length = this.f31382d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (e(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i10, int i11) {
        if (!C(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.f31384f[i11] - this.f31382d[i11];
        float f11 = this.f31385g[i11] - this.f31383e[i11];
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f31380b) : z11 && Math.abs(f11) > ((float) this.f31380b);
        }
        int i12 = this.f31380b;
        return (f10 * f10) + (f11 * f11) > ((float) (i12 * i12));
    }

    public boolean m(boolean z10) {
        if (this.f31379a == 2) {
            boolean computeScrollOffset = this.f31396r.computeScrollOffset();
            int currX = this.f31396r.getCurrX();
            int currY = this.f31396r.getCurrY();
            int left = currX - this.f31398t.getLeft();
            int top = currY - this.f31398t.getTop();
            if (left != 0) {
                d0.d0(this.f31398t, left);
            }
            if (top != 0) {
                d0.e0(this.f31398t, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f31397s.k(this.f31398t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f31396r.getFinalX() && currY == this.f31396r.getFinalY()) {
                this.f31396r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.f31400v.post(this.f31401w);
                } else {
                    K(0);
                }
            }
        }
        return this.f31379a == 2;
    }

    public View t(int i10, int i11) {
        for (int childCount = this.f31400v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f31400v.getChildAt(this.f31397s.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View v() {
        return this.f31398t;
    }

    public int w() {
        return this.f31394p;
    }

    public int x() {
        return this.f31393o;
    }

    public int z() {
        return this.f31380b;
    }
}
