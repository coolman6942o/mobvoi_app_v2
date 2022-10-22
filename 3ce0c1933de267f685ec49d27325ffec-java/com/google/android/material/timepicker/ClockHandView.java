package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.d0;
import d7.k;
import d7.l;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClockHandView extends View {

    /* renamed from: a  reason: collision with root package name */
    private ValueAnimator f11576a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11577b;

    /* renamed from: c  reason: collision with root package name */
    private float f11578c;

    /* renamed from: d  reason: collision with root package name */
    private float f11579d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11580e;

    /* renamed from: f  reason: collision with root package name */
    private int f11581f;

    /* renamed from: g  reason: collision with root package name */
    private final List<d> f11582g;

    /* renamed from: h  reason: collision with root package name */
    private final int f11583h;

    /* renamed from: i  reason: collision with root package name */
    private final float f11584i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f11585j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f11586k;

    /* renamed from: l  reason: collision with root package name */
    private final int f11587l;

    /* renamed from: m  reason: collision with root package name */
    private float f11588m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11589n;

    /* renamed from: o  reason: collision with root package name */
    private c f11590o;

    /* renamed from: p  reason: collision with root package name */
    private double f11591p;

    /* renamed from: q  reason: collision with root package name */
    private int f11592q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.n(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        b(ClockHandView clockHandView) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void d(float f10, boolean z10);
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(float f10, boolean z10);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.F);
    }

    private void c(Canvas canvas) {
        int width;
        int height = getHeight() / 2;
        float width2 = getWidth() / 2;
        float f10 = height;
        this.f11585j.setStrokeWidth(0.0f);
        canvas.drawCircle((this.f11592q * ((float) Math.cos(this.f11591p))) + width2, (this.f11592q * ((float) Math.sin(this.f11591p))) + f10, this.f11583h, this.f11585j);
        double sin = Math.sin(this.f11591p);
        double cos = Math.cos(this.f11591p);
        this.f11585j.setStrokeWidth(this.f11587l);
        canvas.drawLine(width2, f10, width + ((int) (cos * r6)), height + ((int) (r6 * sin)), this.f11585j);
        canvas.drawCircle(width2, f10, this.f11584i, this.f11585j);
    }

    private int e(float f10, float f11) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f11 - (getHeight() / 2), f10 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    private Pair<Float, Float> h(float f10) {
        float f11 = f();
        if (Math.abs(f11 - f10) > 180.0f) {
            if (f11 > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (f11 < 180.0f && f10 > 180.0f) {
                f11 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(f11), Float.valueOf(f10));
    }

    private boolean i(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        float e10 = e(f10, f11);
        boolean z13 = false;
        boolean z14 = f() != e10;
        if (z11 && z14) {
            return true;
        }
        if (!z14 && !z10) {
            return false;
        }
        if (z12 && this.f11577b) {
            z13 = true;
        }
        m(e10, z13);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f11588m = f11;
        this.f11591p = Math.toRadians(f11 - 90.0f);
        float width = (getWidth() / 2) + (this.f11592q * ((float) Math.cos(this.f11591p)));
        float height = (getHeight() / 2) + (this.f11592q * ((float) Math.sin(this.f11591p)));
        RectF rectF = this.f11586k;
        int i10 = this.f11583h;
        rectF.set(width - i10, height - i10, width + i10, height + i10);
        for (d dVar : this.f11582g) {
            dVar.b(f11, z10);
        }
        invalidate();
    }

    public void b(d dVar) {
        this.f11582g.add(dVar);
    }

    public RectF d() {
        return this.f11586k;
    }

    public float f() {
        return this.f11588m;
    }

    public int g() {
        return this.f11583h;
    }

    public void j(boolean z10) {
        this.f11577b = z10;
    }

    public void k(int i10) {
        this.f11592q = i10;
        invalidate();
    }

    public void l(float f10) {
        m(f10, false);
    }

    public void m(float f10, boolean z10) {
        ValueAnimator valueAnimator = this.f11576a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            n(f10, false);
            return;
        }
        Pair<Float, Float> h10 = h(f10);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) h10.first).floatValue(), ((Float) h10.second).floatValue());
        this.f11576a = ofFloat;
        ofFloat.setDuration(200L);
        this.f11576a.addUpdateListener(new a());
        this.f11576a.addListener(new b(this));
        this.f11576a.start();
    }

    public void o(c cVar) {
        this.f11590o = cVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        l(f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f11578c = x10;
            this.f11579d = y10;
            this.f11580e = true;
            this.f11589n = false;
            z12 = false;
            z11 = false;
            z10 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i10 = (int) (x10 - this.f11578c);
            int i11 = (int) (y10 - this.f11579d);
            this.f11580e = (i10 * i10) + (i11 * i11) > this.f11581f;
            boolean z13 = this.f11589n;
            z12 = actionMasked == 1;
            z10 = false;
            z11 = z13;
        } else {
            z12 = false;
            z11 = false;
            z10 = false;
        }
        boolean i12 = i(x10, y10, z11, z10, z12) | this.f11589n;
        this.f11589n = i12;
        if (i12 && z12 && (cVar = this.f11590o) != null) {
            cVar.d(e(x10, y10), this.f11580e);
        }
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11582g = new ArrayList();
        Paint paint = new Paint();
        this.f11585j = paint;
        this.f11586k = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f25460m1, i10, k.D);
        this.f11592q = obtainStyledAttributes.getDimensionPixelSize(l.f25476o1, 0);
        this.f11583h = obtainStyledAttributes.getDimensionPixelSize(l.f25484p1, 0);
        Resources resources = getResources();
        this.f11587l = resources.getDimensionPixelSize(d7.d.f25230y);
        this.f11584i = resources.getDimensionPixelSize(d7.d.f25226w);
        int color = obtainStyledAttributes.getColor(l.f25468n1, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        l(0.0f);
        this.f11581f = ViewConfiguration.get(context).getScaledTouchSlop();
        d0.E0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
