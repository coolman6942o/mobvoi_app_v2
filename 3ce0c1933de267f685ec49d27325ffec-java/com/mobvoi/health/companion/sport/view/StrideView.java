package com.mobvoi.health.companion.sport.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import bh.d;
import bh.f;
import com.mobvoi.wear.util.LogCleaner;
import ef.c0;
import fg.o;
import fg.p;
import fg.u;
import fg.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class StrideView extends View {
    private int A;
    private String B;
    private int C;

    /* renamed from: b  reason: collision with root package name */
    private int f18939b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends c0> f18940c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18942e;

    /* renamed from: m  reason: collision with root package name */
    private int f18950m;

    /* renamed from: n  reason: collision with root package name */
    private int f18951n;

    /* renamed from: o  reason: collision with root package name */
    private int f18952o;

    /* renamed from: p  reason: collision with root package name */
    private int f18953p;

    /* renamed from: w  reason: collision with root package name */
    private LinearGradient f18960w;

    /* renamed from: y  reason: collision with root package name */
    private int f18962y;

    /* renamed from: z  reason: collision with root package name */
    private int f18963z;

    /* renamed from: a  reason: collision with root package name */
    private int f18938a = 3;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18941d = true;

    /* renamed from: f  reason: collision with root package name */
    private float f18943f = 0.8f;

    /* renamed from: g  reason: collision with root package name */
    private int f18944g = 200;

    /* renamed from: h  reason: collision with root package name */
    private Path f18945h = new Path();

    /* renamed from: i  reason: collision with root package name */
    private Path f18946i = new Path();

    /* renamed from: j  reason: collision with root package name */
    private Paint f18947j = new Paint(1);

    /* renamed from: k  reason: collision with root package name */
    private Paint f18948k = new Paint(1);

    /* renamed from: l  reason: collision with root package name */
    private Path f18949l = new Path();

    /* renamed from: q  reason: collision with root package name */
    private int f18954q = -7829368;

    /* renamed from: r  reason: collision with root package name */
    private int f18955r = -7829368;

    /* renamed from: s  reason: collision with root package name */
    private int f18956s = -7829368;

    /* renamed from: t  reason: collision with root package name */
    private Paint f18957t = new Paint(1);

    /* renamed from: u  reason: collision with root package name */
    private Paint f18958u = new Paint(1);

    /* renamed from: v  reason: collision with root package name */
    private Rect f18959v = new Rect();

    /* renamed from: x  reason: collision with root package name */
    private List<PointF> f18961x = new ArrayList();

    public StrideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet, 0);
    }

    private void a(Canvas canvas) {
        canvas.drawLine(getPaddingLeft(), getPaddingTop() + this.f18963z, getPaddingLeft() + this.f18962y, getPaddingTop() + this.f18963z, this.f18947j);
        for (int i10 = 0; i10 <= this.f18938a; i10++) {
            String format = String.format(this.B, Integer.valueOf(this.f18939b * i10));
            canvas.drawCircle(getPaddingLeft() + ((this.f18962y * i10) / this.f18938a), getPaddingTop() + this.f18963z, 5.0f, this.f18947j);
            this.f18949l.reset();
            this.f18949l.moveTo(getPaddingLeft() + ((this.f18962y * i10) / this.f18938a), getPaddingTop() + this.f18963z);
            this.f18949l.lineTo(getPaddingLeft() + ((this.f18962y * i10) / this.f18938a), getPaddingTop());
            if (!(i10 == 0 || i10 == this.f18938a)) {
                canvas.drawPath(this.f18949l, this.f18948k);
            }
            if (i10 == 0) {
                canvas.drawText(format, getPaddingLeft(), ((((getPaddingTop() + this.f18963z) + this.f18950m) + (this.f18952o / 2)) + 5) - ((this.f18947j.descent() + this.f18947j.ascent()) / 2.0f), this.f18947j);
            } else if (i10 == this.f18938a) {
                canvas.drawText(format, (getPaddingLeft() + this.f18962y) - this.f18953p, ((((getPaddingTop() + this.f18963z) + this.f18950m) + (this.f18952o / 2)) + 5) - ((this.f18947j.descent() + this.f18947j.ascent()) / 2.0f), this.f18947j);
            } else {
                canvas.drawText(format, (getPaddingLeft() + ((this.f18962y * i10) / this.f18938a)) - (this.f18953p / 2), ((((getPaddingTop() + this.f18963z) + this.f18950m) + (this.f18952o / 2)) + 5) - ((this.f18947j.descent() + this.f18947j.ascent()) / 2.0f), this.f18947j);
            }
        }
        for (int i11 = 1; i11 <= 4; i11++) {
            String format2 = this.f18942e ? String.format("%.1f", Float.valueOf((this.f18943f / 4.0f) * i11)) : String.valueOf(((!this.f18941d ? this.f18944g / 100 : this.f18944g) / 4) * i11);
            this.f18947j.getTextBounds(format2, 0, format2.length(), this.f18959v);
            int i12 = 4 - i11;
            canvas.drawText(format2, getPaddingLeft() + 5, getPaddingTop() + ((this.f18963z * i12) / 4) + (this.f18952o / 2), this.f18947j);
            this.f18949l.reset();
            this.f18949l.moveTo(getPaddingLeft() + 10 + this.f18959v.width(), getPaddingTop() + ((this.f18963z * i12) / 4));
            this.f18949l.lineTo(getPaddingLeft() + this.f18962y, getPaddingTop() + ((this.f18963z * i12) / 4));
            canvas.drawPath(this.f18949l, this.f18948k);
        }
        d.a(canvas, this.f18941d, getPaddingLeft() + (getWidth() / 2), getPaddingTop() + ((this.f18963z * 3) / 8), true);
    }

    private void b() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f18961x.clear();
        int size = this.f18940c.size();
        this.f18943f = 0.0f;
        for (c0 c0Var : this.f18940c) {
            float c10 = c0Var.c();
            if (c10 > this.f18943f) {
                this.f18943f = c10;
            }
        }
        int i10 = ((int) (this.f18943f * 100.0f)) / 10;
        int i11 = ((i10 + 4) - (i10 % 4)) * 10;
        this.f18944g = i11;
        this.f18943f = i11 / 100.0f;
        long j10 = this.f18938a * this.f18939b * LogCleaner.ONE_MINUTE;
        for (int i12 = 0; i12 < size; i12++) {
            c0 c0Var2 = this.f18940c.get(i12);
            this.f18961x.add(new PointF((float) (paddingLeft + ((c0Var2.b() * this.f18962y) / j10)), paddingTop + ((1.0f - (c0Var2.c() / this.f18943f)) * this.f18963z)));
        }
        this.f18945h.reset();
        int size2 = this.f18961x.size();
        if (size2 > 1) {
            PointF pointF = null;
            int i13 = 0;
            while (i13 < size2) {
                PointF pointF2 = this.f18961x.get(i13);
                if (i13 == 0) {
                    this.f18945h.moveTo(pointF2.x, pointF2.y);
                } else {
                    float f10 = pointF.x;
                    float f11 = (pointF2.x + f10) / 2.0f;
                    float f12 = pointF.y;
                    float f13 = (pointF2.y + f12) / 2.0f;
                    if (i13 == 1) {
                        this.f18945h.lineTo(f11, f13);
                    } else {
                        this.f18945h.quadTo(f10, f12, f11, f13);
                    }
                }
                i13++;
                pointF = pointF2;
            }
            this.f18945h.lineTo(pointF.x, pointF.y);
        }
        this.f18946i.reset();
        this.f18946i.addPath(this.f18945h);
        this.f18946i.lineTo(this.f18961x.get(size2 - 1).x, this.f18963z + paddingTop);
        this.f18946i.lineTo(this.f18961x.get(0).x, paddingTop + this.f18963z);
        this.f18946i.close();
    }

    private void c(AttributeSet attributeSet, int i10) {
        d();
        this.f18947j.setAntiAlias(true);
        this.f18947j.setStrokeWidth(this.f18950m);
        this.f18947j.setTextSize(this.A);
        this.f18947j.setStyle(Paint.Style.FILL);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.f27025o, i10, 0);
            this.f18954q = obtainStyledAttributes.getColor(w.f27028r, -7829368);
            this.f18955r = obtainStyledAttributes.getColor(w.f27027q, -7829368);
            this.f18956s = obtainStyledAttributes.getColor(w.f27026p, -7829368);
            obtainStyledAttributes.recycle();
        }
        this.f18947j.setColor(this.f18954q);
        this.f18948k.setStrokeWidth(this.f18950m);
        this.f18948k.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18948k.setColor(this.f18954q);
        this.f18948k.setAlpha(50);
        this.f18948k.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
        this.f18958u.setStyle(Paint.Style.FILL);
    }

    private void d() {
        Resources resources = getResources();
        this.B = resources.getString(u.f26912j3);
        this.C = resources.getColor(o.U);
        this.A = resources.getDimensionPixelSize(p.J);
        this.f18950m = resources.getDimensionPixelSize(p.D);
        this.f18951n = resources.getDimensionPixelSize(p.A);
    }

    public void e(List<? extends c0> list, boolean z10, int i10) {
        this.f18940c = list;
        this.f18941d = f.e(list);
        this.f18942e = z10;
        this.f18939b = i10;
        String format = String.format(this.B, 20);
        this.f18947j.getTextBounds(format, 0, format.length(), this.f18959v);
        this.f18952o = this.f18959v.height();
        this.f18953p = this.f18959v.width();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height++;
        setLayoutParams(layoutParams);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        if (!this.f18941d) {
            this.f18958u.setShader(this.f18960w);
            canvas.drawPath(this.f18946i, this.f18958u);
            this.f18957t.setColor(this.C);
            this.f18957t.setStyle(Paint.Style.STROKE);
            this.f18957t.setStrokeWidth(this.f18951n);
            canvas.drawPath(this.f18945h, this.f18957t);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        this.f18962y = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        this.f18963z = (((View.MeasureSpec.getSize(i11) - getPaddingTop()) - getPaddingBottom()) - this.f18952o) - this.f18950m;
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f18963z != 0 && this.f18960w == null) {
            this.f18960w = new LinearGradient(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop() + this.f18963z, this.f18955r, this.f18956s, Shader.TileMode.CLAMP);
        }
        if (!this.f18941d) {
            b();
        }
    }
}
