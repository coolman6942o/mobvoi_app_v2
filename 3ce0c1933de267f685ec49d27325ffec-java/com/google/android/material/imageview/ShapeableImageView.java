package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.q;
import d7.k;
import t7.c;
import w7.g;
import w7.l;
import w7.n;
/* loaded from: classes.dex */
public class ShapeableImageView extends q implements n {

    /* renamed from: v  reason: collision with root package name */
    private static final int f10978v = k.B;

    /* renamed from: d  reason: collision with root package name */
    private final l f10979d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f10980e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f10981f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f10982g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f10983h;

    /* renamed from: i  reason: collision with root package name */
    private final Path f10984i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f10985j;

    /* renamed from: k  reason: collision with root package name */
    private g f10986k;

    /* renamed from: l  reason: collision with root package name */
    private w7.k f10987l;

    /* renamed from: m  reason: collision with root package name */
    private float f10988m;

    /* renamed from: n  reason: collision with root package name */
    private Path f10989n;

    /* renamed from: o  reason: collision with root package name */
    private int f10990o;

    /* renamed from: p  reason: collision with root package name */
    private int f10991p;

    /* renamed from: q  reason: collision with root package name */
    private int f10992q;

    /* renamed from: r  reason: collision with root package name */
    private int f10993r;

    /* renamed from: s  reason: collision with root package name */
    private int f10994s;

    /* renamed from: t  reason: collision with root package name */
    private int f10995t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f10996u;

    @TargetApi(21)
    /* loaded from: classes.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f10997a = new Rect();

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f10987l != null) {
                if (ShapeableImageView.this.f10986k == null) {
                    ShapeableImageView.this.f10986k = new g(ShapeableImageView.this.f10987l);
                }
                ShapeableImageView.this.f10980e.round(this.f10997a);
                ShapeableImageView.this.f10986k.setBounds(this.f10997a);
                ShapeableImageView.this.f10986k.getOutline(outline);
            }
        }
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void g(Canvas canvas) {
        if (this.f10985j != null) {
            this.f10982g.setStrokeWidth(this.f10988m);
            int colorForState = this.f10985j.getColorForState(getDrawableState(), this.f10985j.getDefaultColor());
            if (this.f10988m > 0.0f && colorForState != 0) {
                this.f10982g.setColor(colorForState);
                canvas.drawPath(this.f10984i, this.f10982g);
            }
        }
    }

    private boolean h() {
        return (this.f10994s == Integer.MIN_VALUE && this.f10995t == Integer.MIN_VALUE) ? false : true;
    }

    private boolean i() {
        return Build.VERSION.SDK_INT >= 17 && getLayoutDirection() == 1;
    }

    private void j(int i10, int i11) {
        this.f10980e.set(getPaddingLeft(), getPaddingTop(), i10 - getPaddingRight(), i11 - getPaddingBottom());
        this.f10979d.d(this.f10987l, 1.0f, this.f10980e, this.f10984i);
        this.f10989n.rewind();
        this.f10989n.addPath(this.f10984i);
        this.f10981f.set(0.0f, 0.0f, i10, i11);
        this.f10989n.addRect(this.f10981f, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.f10993r;
    }

    public final int getContentPaddingEnd() {
        int i10 = this.f10995t;
        return i10 != Integer.MIN_VALUE ? i10 : i() ? this.f10990o : this.f10992q;
    }

    public int getContentPaddingLeft() {
        int i10;
        int i11;
        if (h()) {
            if (i() && (i11 = this.f10995t) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!i() && (i10 = this.f10994s) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f10990o;
    }

    public int getContentPaddingRight() {
        int i10;
        int i11;
        if (h()) {
            if (i() && (i11 = this.f10994s) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!i() && (i10 = this.f10995t) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f10992q;
    }

    public final int getContentPaddingStart() {
        int i10 = this.f10994s;
        return i10 != Integer.MIN_VALUE ? i10 : i() ? this.f10992q : this.f10990o;
    }

    public int getContentPaddingTop() {
        return this.f10991p;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public w7.k getShapeAppearanceModel() {
        return this.f10987l;
    }

    public ColorStateList getStrokeColor() {
        return this.f10985j;
    }

    public float getStrokeWidth() {
        return this.f10988m;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f10989n, this.f10983h);
        g(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.f10996u) {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 <= 19 || isLayoutDirectionResolved()) {
                this.f10996u = true;
                if (i12 < 21 || (!isPaddingRelative() && !h())) {
                    setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
                } else {
                    setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        j(i10, i11);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10 + getContentPaddingLeft(), i11 + getContentPaddingTop(), i12 + getContentPaddingRight(), i13 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10 + getContentPaddingStart(), i11 + getContentPaddingTop(), i12 + getContentPaddingEnd(), i13 + getContentPaddingBottom());
    }

    @Override // w7.n
    public void setShapeAppearanceModel(w7.k kVar) {
        this.f10987l = kVar;
        g gVar = this.f10986k;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        j(getWidth(), getHeight());
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f10985j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i10) {
        setStrokeColor(e.a.a(getContext(), i10));
    }

    public void setStrokeWidth(float f10) {
        if (this.f10988m != f10) {
            this.f10988m = f10;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i10) {
        setStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShapeableImageView(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r0), attributeSet, i10);
        int i11 = f10978v;
        this.f10979d = l.k();
        this.f10984i = new Path();
        this.f10996u = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f10983h = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f10980e = new RectF();
        this.f10981f = new RectF();
        this.f10989n = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, d7.l.f25479o4, i10, i11);
        this.f10985j = c.a(context2, obtainStyledAttributes, d7.l.f25542w4);
        this.f10988m = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25550x4, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25487p4, 0);
        this.f10990o = dimensionPixelSize;
        this.f10991p = dimensionPixelSize;
        this.f10992q = dimensionPixelSize;
        this.f10993r = dimensionPixelSize;
        this.f10990o = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25510s4, dimensionPixelSize);
        this.f10991p = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25534v4, dimensionPixelSize);
        this.f10992q = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25518t4, dimensionPixelSize);
        this.f10993r = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25495q4, dimensionPixelSize);
        this.f10994s = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25526u4, Integer.MIN_VALUE);
        this.f10995t = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25502r4, Integer.MIN_VALUE);
        obtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f10982g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f10987l = w7.k.e(context2, attributeSet, i10, i11).m();
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new a());
        }
    }
}
