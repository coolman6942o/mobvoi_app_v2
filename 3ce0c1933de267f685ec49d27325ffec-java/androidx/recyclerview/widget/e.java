package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.d0;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.services.core.AMapException;
import com.huawei.agconnect.exception.AGCServerException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastScroller.java */
/* loaded from: classes.dex */
public class e extends RecyclerView.n implements RecyclerView.r {
    private static final int[] D = {16842919};
    private static final int[] E = new int[0];

    /* renamed from: a  reason: collision with root package name */
    private final int f3986a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3987b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f3988c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f3989d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3990e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3991f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f3992g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f3993h;

    /* renamed from: i  reason: collision with root package name */
    private final int f3994i;

    /* renamed from: j  reason: collision with root package name */
    private final int f3995j;

    /* renamed from: k  reason: collision with root package name */
    int f3996k;

    /* renamed from: l  reason: collision with root package name */
    int f3997l;

    /* renamed from: m  reason: collision with root package name */
    float f3998m;

    /* renamed from: n  reason: collision with root package name */
    int f3999n;

    /* renamed from: o  reason: collision with root package name */
    int f4000o;

    /* renamed from: p  reason: collision with root package name */
    float f4001p;

    /* renamed from: s  reason: collision with root package name */
    private RecyclerView f4004s;

    /* renamed from: z  reason: collision with root package name */
    final ValueAnimator f4011z;

    /* renamed from: q  reason: collision with root package name */
    private int f4002q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f4003r = 0;

    /* renamed from: t  reason: collision with root package name */
    private boolean f4005t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f4006u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f4007v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f4008w = 0;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f4009x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    private final int[] f4010y = new int[2];
    int A = 0;
    private final Runnable B = new a();
    private final RecyclerView.s C = new b();

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.p(AGCServerException.UNKNOW_EXCEPTION);
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    class b extends RecyclerView.s {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i10, int i11) {
            e.this.A(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    private class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4014a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4014a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f4014a) {
                this.f4014a = false;
            } else if (((Float) e.this.f4011z.getAnimatedValue()).floatValue() == 0.0f) {
                e eVar = e.this;
                eVar.A = 0;
                eVar.x(0);
            } else {
                e eVar2 = e.this;
                eVar2.A = 2;
                eVar2.u();
            }
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            e.this.f3988c.setAlpha(floatValue);
            e.this.f3989d.setAlpha(floatValue);
            e.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4011z = ofFloat;
        this.f3988c = stateListDrawable;
        this.f3989d = drawable;
        this.f3992g = stateListDrawable2;
        this.f3993h = drawable2;
        this.f3990e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f3991f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f3994i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f3995j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f3986a = i11;
        this.f3987b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        i(recyclerView);
    }

    private void B(float f10) {
        int[] o10 = o();
        float max = Math.max(o10[0], Math.min(o10[1], f10));
        if (Math.abs(this.f3997l - max) >= 2.0f) {
            int w10 = w(this.f3998m, max, o10, this.f4004s.computeVerticalScrollRange(), this.f4004s.computeVerticalScrollOffset(), this.f4003r);
            if (w10 != 0) {
                this.f4004s.scrollBy(0, w10);
            }
            this.f3998m = max;
        }
    }

    private void j() {
        this.f4004s.removeCallbacks(this.B);
    }

    private void k() {
        this.f4004s.c1(this);
        this.f4004s.e1(this);
        this.f4004s.f1(this.C);
        j();
    }

    private void l(Canvas canvas) {
        int i10 = this.f4003r;
        int i11 = this.f3994i;
        int i12 = i10 - i11;
        int i13 = this.f4000o;
        int i14 = this.f3999n;
        int i15 = i13 - (i14 / 2);
        this.f3992g.setBounds(0, 0, i14, i11);
        this.f3993h.setBounds(0, 0, this.f4002q, this.f3995j);
        canvas.translate(0.0f, i12);
        this.f3993h.draw(canvas);
        canvas.translate(i15, 0.0f);
        this.f3992g.draw(canvas);
        canvas.translate(-i15, -i12);
    }

    private void m(Canvas canvas) {
        int i10 = this.f4002q;
        int i11 = this.f3990e;
        int i12 = i10 - i11;
        int i13 = this.f3997l;
        int i14 = this.f3996k;
        int i15 = i13 - (i14 / 2);
        this.f3988c.setBounds(0, 0, i11, i14);
        this.f3989d.setBounds(0, 0, this.f3991f, this.f4003r);
        if (r()) {
            this.f3989d.draw(canvas);
            canvas.translate(this.f3990e, i15);
            canvas.scale(-1.0f, 1.0f);
            this.f3988c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate(-this.f3990e, -i15);
            return;
        }
        canvas.translate(i12, 0.0f);
        this.f3989d.draw(canvas);
        canvas.translate(0.0f, i15);
        this.f3988c.draw(canvas);
        canvas.translate(-i12, -i15);
    }

    private int[] n() {
        int[] iArr = this.f4010y;
        int i10 = this.f3987b;
        iArr[0] = i10;
        iArr[1] = this.f4002q - i10;
        return iArr;
    }

    private int[] o() {
        int[] iArr = this.f4009x;
        int i10 = this.f3987b;
        iArr[0] = i10;
        iArr[1] = this.f4003r - i10;
        return iArr;
    }

    private void q(float f10) {
        int[] n10 = n();
        float max = Math.max(n10[0], Math.min(n10[1], f10));
        if (Math.abs(this.f4000o - max) >= 2.0f) {
            int w10 = w(this.f4001p, max, n10, this.f4004s.computeHorizontalScrollRange(), this.f4004s.computeHorizontalScrollOffset(), this.f4002q);
            if (w10 != 0) {
                this.f4004s.scrollBy(w10, 0);
            }
            this.f4001p = max;
        }
    }

    private boolean r() {
        return d0.E(this.f4004s) == 1;
    }

    private void v(int i10) {
        j();
        this.f4004s.postDelayed(this.B, i10);
    }

    private int w(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / i13) * i14);
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    private void y() {
        this.f4004s.h(this);
        this.f4004s.k(this);
        this.f4004s.l(this.C);
    }

    void A(int i10, int i11) {
        int computeVerticalScrollRange = this.f4004s.computeVerticalScrollRange();
        int i12 = this.f4003r;
        this.f4005t = computeVerticalScrollRange - i12 > 0 && i12 >= this.f3986a;
        int computeHorizontalScrollRange = this.f4004s.computeHorizontalScrollRange();
        int i13 = this.f4002q;
        boolean z10 = computeHorizontalScrollRange - i13 > 0 && i13 >= this.f3986a;
        this.f4006u = z10;
        boolean z11 = this.f4005t;
        if (z11 || z10) {
            if (z11) {
                float f10 = i12;
                this.f3997l = (int) ((f10 * (i11 + (f10 / 2.0f))) / computeVerticalScrollRange);
                this.f3996k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
            }
            if (this.f4006u) {
                float f11 = i13;
                this.f4000o = (int) ((f11 * (i10 + (f11 / 2.0f))) / computeHorizontalScrollRange);
                this.f3999n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
            }
            int i14 = this.f4007v;
            if (i14 == 0 || i14 == 1) {
                x(1);
            }
        } else if (this.f4007v != 0) {
            x(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (this.f4002q != this.f4004s.getWidth() || this.f4003r != this.f4004s.getHeight()) {
            this.f4002q = this.f4004s.getWidth();
            this.f4003r = this.f4004s.getHeight();
            x(0);
        } else if (this.A != 0) {
            if (this.f4005t) {
                m(canvas);
            }
            if (this.f4006u) {
                l(canvas);
            }
        }
    }

    public void i(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4004s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                k();
            }
            this.f4004s = recyclerView;
            if (recyclerView != null) {
                y();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f4007v;
        if (i10 == 1) {
            boolean t10 = t(motionEvent.getX(), motionEvent.getY());
            boolean s10 = s(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!t10 && !s10) {
                return false;
            }
            if (s10) {
                this.f4008w = 1;
                this.f4001p = (int) motionEvent.getX();
            } else if (t10) {
                this.f4008w = 2;
                this.f3998m = (int) motionEvent.getY();
            }
            x(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f4007v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean t10 = t(motionEvent.getX(), motionEvent.getY());
                boolean s10 = s(motionEvent.getX(), motionEvent.getY());
                if (t10 || s10) {
                    if (s10) {
                        this.f4008w = 1;
                        this.f4001p = (int) motionEvent.getX();
                    } else if (t10) {
                        this.f4008w = 2;
                        this.f3998m = (int) motionEvent.getY();
                    }
                    x(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f4007v == 2) {
                this.f3998m = 0.0f;
                this.f4001p = 0.0f;
                x(1);
                this.f4008w = 0;
            } else if (motionEvent.getAction() == 2 && this.f4007v == 2) {
                z();
                if (this.f4008w == 1) {
                    q(motionEvent.getX());
                }
                if (this.f4008w == 2) {
                    B(motionEvent.getY());
                }
            }
        }
    }

    void p(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f4011z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f4011z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f4011z.setDuration(i10);
        this.f4011z.start();
    }

    boolean s(float f10, float f11) {
        if (f11 >= this.f4003r - this.f3994i) {
            int i10 = this.f4000o;
            int i11 = this.f3999n;
            if (f10 >= i10 - (i11 / 2) && f10 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean t(float f10, float f11) {
        if (!r() ? f10 >= this.f4002q - this.f3990e : f10 <= this.f3990e) {
            int i10 = this.f3997l;
            int i11 = this.f3996k;
            if (f11 >= i10 - (i11 / 2) && f11 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    void u() {
        this.f4004s.invalidate();
    }

    void x(int i10) {
        if (i10 == 2 && this.f4007v != 2) {
            this.f3988c.setState(D);
            j();
        }
        if (i10 == 0) {
            u();
        } else {
            z();
        }
        if (this.f4007v == 2 && i10 != 2) {
            this.f3988c.setState(E);
            v(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
        } else if (i10 == 1) {
            v(1500);
        }
        this.f4007v = i10;
    }

    public void z() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 == 3) {
                this.f4011z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f4011z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f4011z.setDuration(500L);
        this.f4011z.setStartDelay(0L);
        this.f4011z.start();
    }
}
