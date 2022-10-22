package com.mobvoi.mcuwatch.ui.arty.widget;

import a0.h;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.mobvoi.companion.health.widget.arty.a;
import com.mobvoi.mcuwatch.ui.arty.ArtyDetailActivity;
import com.mobvoi.wear.util.DimensionUtils;
import sh.c;
import sh.d;
import sh.e;
import sh.f;
import sh.g;
import sh.k;
import sh.m;
/* loaded from: classes2.dex */
public class ArtyScoreView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19411a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f19412b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f19413c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f19414d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f19415e;

    /* renamed from: f  reason: collision with root package name */
    private final TextPaint f19416f;

    /* renamed from: g  reason: collision with root package name */
    private final TextPaint f19417g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f19418h;

    /* renamed from: i  reason: collision with root package name */
    private SweepGradient f19419i;

    /* renamed from: j  reason: collision with root package name */
    private int f19420j;

    /* renamed from: k  reason: collision with root package name */
    private int f19421k;

    /* renamed from: l  reason: collision with root package name */
    private float f19422l;

    /* renamed from: m  reason: collision with root package name */
    private float f19423m;

    /* renamed from: n  reason: collision with root package name */
    private final String f19424n;

    /* renamed from: o  reason: collision with root package name */
    private final String f19425o;

    /* renamed from: p  reason: collision with root package name */
    private final String f19426p;

    /* renamed from: q  reason: collision with root package name */
    private final String f19427q;

    /* renamed from: r  reason: collision with root package name */
    private float f19428r;

    /* renamed from: s  reason: collision with root package name */
    private float f19429s;

    /* renamed from: t  reason: collision with root package name */
    private int[] f19430t;

    /* renamed from: u  reason: collision with root package name */
    private int f19431u;

    /* renamed from: v  reason: collision with root package name */
    private int f19432v;

    public ArtyScoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int a(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            return size;
        }
        int dimension = (int) (getResources().getDimension(e.f34519u0) + getResources().getDimension(e.f34513r0) + getResources().getDimension(e.f34511q0));
        return mode == Integer.MIN_VALUE ? Math.min(dimension, size) : dimension;
    }

    public void b() {
        Intent intent = new Intent();
        intent.setClass(this.f19411a, ArtyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("data_type", 0);
        bundle.putInt("extra_diff_value", this.f19420j);
        intent.putExtras(bundle);
        this.f19411a.startActivity(intent);
    }

    public void c() {
        this.f19412b = BitmapFactory.decodeResource(getResources(), f.K0);
        this.f19421k = 0;
        postInvalidate();
    }

    public void d() {
        a aVar = a.f17142a;
        this.f19419i = new SweepGradient(this.f19422l, this.f19423m, new int[]{aVar.h(0, this.f19421k, false), aVar.h(0, this.f19421k, true)}, new float[]{0.0f, this.f19421k / 100.0f});
        Matrix matrix = new Matrix();
        matrix.setRotate(90.0f, this.f19422l, this.f19423m);
        this.f19419i.setLocalMatrix(matrix);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f19415e.setShader(null);
        this.f19415e.setColor(getResources().getColor(d.f34443b));
        canvas.drawCircle(this.f19422l, this.f19423m, this.f19428r, this.f19415e);
        if (this.f19421k > 0) {
            RectF rectF = this.f19418h;
            float f10 = this.f19422l;
            float f11 = this.f19428r;
            float f12 = this.f19423m;
            rectF.set(f10 - f11, f12 - f11, f10 + f11, f12 + f11);
            this.f19415e.setShader(this.f19419i);
            float f13 = this.f19429s;
            float f14 = ((this.f19421k * 360) / 100.0f) - (f13 * 2.0f);
            RectF rectF2 = this.f19418h;
            float f15 = f13 + 90.0f;
            if (f14 <= 0.0f) {
                f14 = 1.0f;
            }
            canvas.drawArc(rectF2, f15, f14, false, this.f19415e);
        }
        Bitmap bitmap = this.f19412b;
        canvas.drawBitmap(bitmap, this.f19422l - (bitmap.getWidth() / 2.0f), getResources().getDimension(e.f34521v0), this.f19416f);
        this.f19416f.setTextSize(getResources().getDimension(e.f34517t0));
        this.f19416f.setColor(this.f19431u);
        this.f19416f.setTextAlign(Paint.Align.LEFT);
        Paint.FontMetrics fontMetrics = this.f19416f.getFontMetrics();
        float dimension = (getResources().getDimension(e.f34515s0) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
        float measureText = this.f19416f.measureText(this.f19425o);
        float measureText2 = this.f19416f.measureText(this.f19424n);
        float measureText3 = this.f19416f.measureText(this.f19426p);
        float f16 = (((measureText2 / 2.0f) + measureText) + measureText3) / 2.0f;
        canvas.drawText(this.f19425o, this.f19422l - f16, dimension, this.f19416f);
        canvas.drawText(this.f19426p, (this.f19422l + f16) - measureText3, dimension, this.f19416f);
        this.f19416f.setTextSize(getResources().getDimension(e.G0));
        Paint.FontMetrics fontMetrics2 = this.f19416f.getFontMetrics();
        canvas.drawText(this.f19424n, (this.f19422l - f16) + measureText, (getResources().getDimension(e.f34525x0) + ((fontMetrics2.bottom - fontMetrics2.top) / 2.0f)) - ((fontMetrics2.descent + fontMetrics2.ascent) / 2.0f), this.f19416f);
        this.f19417g.setTextSize(getResources().getDimension(e.C0));
        this.f19417g.setColor(this.f19431u);
        this.f19417g.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics3 = this.f19417g.getFontMetrics();
        float dimension2 = (getResources().getDimension(e.A0) + ((fontMetrics3.bottom - fontMetrics3.top) / 2.0f)) - ((fontMetrics3.descent + fontMetrics3.ascent) / 2.0f);
        int i10 = this.f19421k;
        if (i10 > 0) {
            canvas.drawText(String.valueOf(i10), this.f19422l, dimension2, this.f19417g);
        } else {
            canvas.drawText("-", this.f19422l, dimension2, this.f19417g);
        }
        this.f19417g.setTextSize(getResources().getDimension(e.f34529z0));
        this.f19417g.setColor(this.f19432v);
        this.f19417g.setTextAlign(Paint.Align.LEFT);
        float measureText4 = this.f19417g.measureText(this.f19427q);
        float dimension3 = getResources().getDimension(e.B0);
        Paint.FontMetrics fontMetrics4 = this.f19417g.getFontMetrics();
        float dimension4 = (getResources().getDimension(e.f34527y0) + ((fontMetrics4.bottom - fontMetrics4.top) / 2.0f)) - ((fontMetrics4.descent + fontMetrics4.ascent) / 2.0f);
        if (this.f19420j != 0 && this.f19421k > 0) {
            float width = measureText4 + dimension3 + this.f19414d.getWidth();
            canvas.drawBitmap(this.f19420j > 0 ? this.f19414d : this.f19413c, (this.f19422l - (width / 2.0f)) + measureText4 + dimension3, dimension4 - this.f19413c.getHeight(), this.f19417g);
            measureText4 = width;
        }
        canvas.drawText(this.f19427q, this.f19422l - (measureText4 / 2.0f), dimension4, this.f19417g);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(View.MeasureSpec.getSize(i10), a(i11));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f19422l = getWidth() / 2.0f;
        Resources resources = getResources();
        int i14 = e.f34519u0;
        this.f19423m = (resources.getDimension(i14) / 2.0f) + getResources().getDimension(e.f34513r0);
        this.f19428r = (getResources().getDimension(i14) / 2.0f) - (getResources().getDimension(e.f34523w0) / 2.0f);
        this.f19429s = ((this.f19415e.getStrokeWidth() / 2.0f) * 360.0f) / (this.f19428r * 6.28f);
        d();
    }

    public void setScore(int i10) {
        if (this.f19421k != i10) {
            this.f19420j = gg.d.a(0, i10);
            a aVar = a.f17142a;
            this.f19412b = BitmapFactory.decodeResource(getResources(), this.f19430t[aVar.l(0, i10)]);
            this.f19421k = i10;
            this.f19413c = aVar.b(0, i10, false);
            this.f19414d = aVar.b(0, this.f19421k, true);
            if (this.f19421k > 0) {
                d();
            }
            postInvalidate();
        }
    }

    public ArtyScoreView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19430t = new int[]{f.f34550h, f.f34547g, f.f34556j, f.f34553i};
        this.f19411a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f34912f);
        int resourceId = obtainStyledAttributes.getResourceId(m.f34914h, -1);
        this.f19421k = obtainStyledAttributes.getInt(m.f34913g, -1);
        this.f19427q = obtainStyledAttributes.getString(m.f34915i);
        this.f19424n = getResources().getString(k.K);
        this.f19425o = getResources().getString(k.H);
        this.f19426p = getResources().getString(k.J);
        obtainStyledAttributes.recycle();
        this.f19431u = j7.a.e(this, c.f34441c, -16777216);
        this.f19432v = j7.a.e(this, c.f34440b, -7829368);
        this.f19412b = BitmapFactory.decodeResource(getResources(), resourceId);
        setElevation(DimensionUtils.dp2px(context, 2.0f));
        Paint paint = new Paint(1);
        this.f19415e = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(getResources().getDimension(e.f34523w0));
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        TextPaint textPaint = new TextPaint(1);
        this.f19416f = textPaint;
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint(1);
        this.f19417g = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        textPaint2.setAntiAlias(true);
        textPaint.setTypeface(h.h(context, g.f34608b));
        textPaint2.setTypeface(h.h(context, g.f34607a));
        this.f19418h = new RectF();
    }
}
