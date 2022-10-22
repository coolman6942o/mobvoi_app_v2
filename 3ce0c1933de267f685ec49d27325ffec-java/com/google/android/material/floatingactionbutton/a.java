package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import w7.k;
import w7.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BorderDrawable.java */
/* loaded from: classes.dex */
public class a extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    private final Paint f10910b;

    /* renamed from: h  reason: collision with root package name */
    float f10916h;

    /* renamed from: i  reason: collision with root package name */
    private int f10917i;

    /* renamed from: j  reason: collision with root package name */
    private int f10918j;

    /* renamed from: k  reason: collision with root package name */
    private int f10919k;

    /* renamed from: l  reason: collision with root package name */
    private int f10920l;

    /* renamed from: m  reason: collision with root package name */
    private int f10921m;

    /* renamed from: o  reason: collision with root package name */
    private k f10923o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f10924p;

    /* renamed from: a  reason: collision with root package name */
    private final l f10909a = l.k();

    /* renamed from: c  reason: collision with root package name */
    private final Path f10911c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f10912d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f10913e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f10914f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final b f10915g = new b();

    /* renamed from: n  reason: collision with root package name */
    private boolean f10922n = true;

    /* compiled from: BorderDrawable.java */
    /* loaded from: classes.dex */
    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return a.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(k kVar) {
        this.f10923o = kVar;
        Paint paint = new Paint(1);
        this.f10910b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        Rect rect = this.f10912d;
        copyBounds(rect);
        float height = this.f10916h / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{b0.a.f(this.f10917i, this.f10921m), b0.a.f(this.f10918j, this.f10921m), b0.a.f(b0.a.j(this.f10918j, 0), this.f10921m), b0.a.f(b0.a.j(this.f10920l, 0), this.f10921m), b0.a.f(this.f10920l, this.f10921m), b0.a.f(this.f10919k, this.f10921m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    protected RectF b() {
        this.f10914f.set(getBounds());
        return this.f10914f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f10921m = colorStateList.getColorForState(getState(), this.f10921m);
        }
        this.f10924p = colorStateList;
        this.f10922n = true;
        invalidateSelf();
    }

    public void d(float f10) {
        if (this.f10916h != f10) {
            this.f10916h = f10;
            this.f10910b.setStrokeWidth(f10 * 1.3333f);
            this.f10922n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f10922n) {
            this.f10910b.setShader(a());
            this.f10922n = false;
        }
        float strokeWidth = this.f10910b.getStrokeWidth() / 2.0f;
        copyBounds(this.f10912d);
        this.f10913e.set(this.f10912d);
        float min = Math.min(this.f10923o.r().a(b()), this.f10913e.width() / 2.0f);
        if (this.f10923o.u(b())) {
            this.f10913e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f10913e, min, min, this.f10910b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i10, int i11, int i12, int i13) {
        this.f10917i = i10;
        this.f10918j = i11;
        this.f10919k = i12;
        this.f10920l = i13;
    }

    public void f(k kVar) {
        this.f10923o = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f10915g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f10916h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f10923o.u(b())) {
            outline.setRoundRect(getBounds(), this.f10923o.r().a(b()));
            return;
        }
        copyBounds(this.f10912d);
        this.f10913e.set(this.f10912d);
        this.f10909a.d(this.f10923o, 1.0f, this.f10913e, this.f10911c);
        if (this.f10911c.isConvex()) {
            outline.setConvexPath(this.f10911c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.f10923o.u(b())) {
            return true;
        }
        int round = Math.round(this.f10916h);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f10924p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f10922n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f10924p;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.f10921m)) == this.f10921m)) {
            this.f10922n = true;
            this.f10921m = colorForState;
        }
        if (this.f10922n) {
            invalidateSelf();
        }
        return this.f10922n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f10910b.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f10910b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
