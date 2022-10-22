package com.mobvoi.mcuwatch.ui.arty.widget;

import a0.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.cardiex.arty.lite.models.coach.ArtyLatest;
import com.mobvoi.companion.health.widget.arty.a;
import com.mobvoi.wear.util.DimensionUtils;
import gg.c;
import java.util.List;
import nj.u;
import sh.b;
import sh.d;
import sh.e;
import sh.g;
/* loaded from: classes2.dex */
public class ArtyLatestValueCommonView extends View {
    private int A;
    private Shader B;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f19385a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f19386b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f19387c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f19388d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f19389e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f19390f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f19391g;

    /* renamed from: h  reason: collision with root package name */
    private String f19392h;

    /* renamed from: i  reason: collision with root package name */
    private final String[] f19393i;

    /* renamed from: j  reason: collision with root package name */
    private final String[] f19394j;

    /* renamed from: k  reason: collision with root package name */
    private float f19395k;

    /* renamed from: l  reason: collision with root package name */
    private final float f19396l;

    /* renamed from: m  reason: collision with root package name */
    private final float f19397m;

    /* renamed from: n  reason: collision with root package name */
    private final float f19398n;

    /* renamed from: o  reason: collision with root package name */
    private final float f19399o;

    /* renamed from: p  reason: collision with root package name */
    private float f19400p;

    /* renamed from: q  reason: collision with root package name */
    private final int[] f19401q;

    /* renamed from: r  reason: collision with root package name */
    private final int[] f19402r;

    /* renamed from: s  reason: collision with root package name */
    private final int[] f19403s;

    /* renamed from: t  reason: collision with root package name */
    private int f19404t;

    /* renamed from: u  reason: collision with root package name */
    private int f19405u;

    /* renamed from: v  reason: collision with root package name */
    private int f19406v;

    /* renamed from: w  reason: collision with root package name */
    private int f19407w;

    /* renamed from: x  reason: collision with root package name */
    private int f19408x;

    /* renamed from: y  reason: collision with root package name */
    private int f19409y;

    /* renamed from: z  reason: collision with root package name */
    private int f19410z;

    public ArtyLatestValueCommonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        this.f19387c.setColor(this.f19410z);
        this.f19387c.setTextSize(getResources().getDimension(e.f34474c0));
        float dimension = ((this.f19399o + this.f19397m) + getResources().getDimension(e.S)) - this.f19387c.getFontMetrics().top;
        int i10 = this.f19404t;
        if (i10 == 0) {
            canvas.drawText("-", this.f19395k, dimension, this.f19387c);
        } else {
            canvas.drawText(String.valueOf(i10), this.f19395k, dimension, this.f19387c);
        }
        this.f19387c.setTextSize(getResources().getDimension(e.f34529z0));
        this.f19387c.setColor(this.A);
        this.f19387c.setTextAlign(Paint.Align.LEFT);
        float dimension2 = ((this.f19399o + this.f19397m) + getResources().getDimension(e.X)) - this.f19387c.getFontMetrics().ascent;
        float measureText = this.f19387c.measureText(this.f19394j[this.f19406v]);
        if (this.f19407w != 0 && this.f19404t > 0) {
            float dimension3 = getResources().getDimension(e.C);
            float width = this.f19391g.getWidth() + measureText + dimension3;
            canvas.drawBitmap(this.f19407w > 0 ? this.f19391g : this.f19390f, (this.f19395k - (width / 2.0f)) + measureText + dimension3, dimension2 - this.f19391g.getHeight(), this.f19387c);
            measureText = width;
        }
        canvas.drawText(this.f19394j[this.f19406v], this.f19395k - (measureText / 2.0f), dimension2, this.f19387c);
        this.f19386b.setShader(null);
        this.f19386b.setColor(getResources().getColor(d.f34444b0, null));
        float f10 = this.f19398n / 2.0f;
        canvas.drawCircle(this.f19395k, this.f19396l, f10, this.f19386b);
        RectF rectF = this.f19388d;
        float f11 = this.f19395k;
        float f12 = this.f19396l;
        rectF.set(f11 - f10, f12 - f10, f11 + f10, f12 + f10);
        if (this.f19404t > 0) {
            this.f19386b.setShader(this.B);
            float f13 = this.f19400p;
            float f14 = ((this.f19404t * 360.0f) / 100.0f) - (2.0f * f13);
            RectF rectF2 = this.f19388d;
            float f15 = f13 + 90.0f;
            if (f14 <= 0.0f) {
                f14 = 1.0f;
            }
            canvas.drawArc(rectF2, f15, f14, false, this.f19386b);
        }
    }

    private void b(Canvas canvas) {
        this.f19387c.setColor(this.f19410z);
        this.f19387c.setTextSize(getResources().getDimension(e.I));
        float dimension = (this.f19399o + getResources().getDimension(e.H)) - this.f19387c.getFontMetrics().top;
        int i10 = this.f19404t;
        if (i10 == 0) {
            canvas.drawText("-", this.f19395k, dimension, this.f19387c);
        } else {
            canvas.drawText(String.valueOf(i10), this.f19395k, dimension, this.f19387c);
        }
        this.f19385a.setTextSize(getResources().getDimension(e.f34529z0));
        this.f19385a.setColor(this.A);
        this.f19385a.setTextAlign(Paint.Align.LEFT);
        float dimension2 = (this.f19399o + getResources().getDimension(e.G)) - this.f19385a.getFontMetrics().top;
        float measureText = this.f19385a.measureText(this.f19394j[this.f19406v]);
        if (this.f19407w != 0 && this.f19404t > 0) {
            float dimension3 = getResources().getDimension(e.C);
            float width = this.f19391g.getWidth() + measureText + dimension3;
            canvas.drawBitmap(this.f19407w > 0 ? this.f19391g : this.f19390f, (this.f19395k - (width / 2.0f)) + measureText + dimension3, dimension2 - this.f19391g.getHeight(), this.f19385a);
            measureText = width;
        }
        canvas.drawText(this.f19394j[this.f19406v], this.f19395k - (measureText / 2.0f), dimension2, this.f19385a);
        if (this.f19404t > 0) {
            this.f19386b.setColor(getResources().getColor(d.f34444b0, null));
            float dimension4 = getResources().getDimension(e.E);
            this.f19386b.setStrokeWidth(getResources().getDimension(e.D) / 2.0f);
            this.f19386b.setShader(null);
            RectF rectF = this.f19389e;
            canvas.drawLine(rectF.left, rectF.top, this.f19395k + (dimension4 / 2.0f), rectF.bottom, this.f19386b);
            this.f19386b.setShader(this.B);
            RectF rectF2 = this.f19389e;
            canvas.drawLine(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.f19386b);
        }
    }

    private void c(Canvas canvas) {
        this.f19387c.setColor(this.f19410z);
        this.f19387c.setTextSize(getResources().getDimension(e.W));
        float dimension = (this.f19399o + getResources().getDimension(e.V)) - this.f19387c.getFontMetrics().top;
        int i10 = this.f19404t;
        if (i10 == 0) {
            canvas.drawText("-", this.f19395k, dimension, this.f19387c);
        } else {
            String valueOf = String.valueOf(i10);
            if (this.f19406v == 4) {
                this.f19387c.setTextSize(getResources().getDimension(e.f34477d0));
                valueOf = this.f19404t + "-" + this.f19405u;
                dimension = (this.f19399o + getResources().getDimension(e.B)) - this.f19387c.getFontMetrics().top;
            }
            canvas.drawText(valueOf, this.f19395k, dimension, this.f19387c);
        }
        this.f19385a.setColor(this.f19410z);
        this.f19385a.setTextSize(getResources().getDimension(e.U));
        canvas.drawText(this.f19394j[this.f19406v], this.f19395k, (this.f19399o + getResources().getDimension(e.T)) - this.f19385a.getFontMetrics().top, this.f19385a);
    }

    private void e() {
        int i10 = this.f19406v;
        if (i10 == 0 || i10 == 2) {
            this.B = new SweepGradient(this.f19395k, this.f19396l, new int[]{this.f19408x, this.f19409y}, new float[]{0.0f, this.f19404t / 100.0f});
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, this.f19395k, this.f19396l);
            this.B.setLocalMatrix(matrix);
            this.f19386b.setStrokeWidth(getResources().getDimension(e.f34468a0));
            this.f19400p = ((this.f19386b.getStrokeWidth() / 2.0f) * 360.0f) / (this.f19398n * 3.14f);
        } else if (i10 == 3) {
            float dimension = getResources().getDimension(e.E);
            float dimension2 = getResources().getDimension(e.F);
            float f10 = this.f19395k - (dimension / 2.0f);
            RectF rectF = this.f19389e;
            float f11 = this.f19399o;
            rectF.set(f10, f11 + dimension2, (dimension * (this.f19404t / 100.0f)) + f10, f11 + dimension2);
            RectF rectF2 = this.f19389e;
            this.B = new LinearGradient(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.f19408x, this.f19409y, Shader.TileMode.CLAMP);
        }
    }

    public int d(float f10, Paint paint) {
        paint.setTextSize(f10);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.bottom - fontMetrics.top);
    }

    public void f(int i10, int i11) {
        this.f19406v = i10;
        this.f19407w = i11;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f19385a.setColor(this.A);
        this.f19385a.setTextSize(getResources().getDimension(e.Y));
        this.f19385a.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(this.f19392h, this.f19395k, -this.f19385a.getFontMetrics().top, this.f19385a);
        float dimension = this.f19399o + getResources().getDimension(e.L);
        float dimension2 = getResources().getDimension(e.K);
        float dimension3 = getResources().getDimension(e.M);
        this.f19385a.setColor(getResources().getColor(d.f34449i, null));
        Paint paint = this.f19385a;
        Resources resources = getResources();
        int i10 = d.c_res_0x7f060042;
        paint.setShadowLayer(dimension3, 0.0f, 0.0f, resources.getColor(i10, null));
        this.f19388d.set(dimension2, dimension, getWidth() - dimension2, getResources().getDimension(e.J) + dimension);
        canvas.drawRoundRect(this.f19388d, dimension3, dimension3, this.f19385a);
        this.f19385a.setShadowLayer(0.0f, 0.0f, 0.0f, getResources().getColor(i10, null));
        this.f19387c.setTextSize(getResources().getDimension(e.R));
        this.f19387c.setTextAlign(Paint.Align.CENTER);
        this.f19387c.setFakeBoldText(true);
        float dimension4 = getResources().getDimension(e.D0) + getResources().getDimension(e.P);
        float dimension5 = (getResources().getDimension(e.Q) + dimension) - this.f19387c.getFontMetrics().ascent;
        float width = (getWidth() - (dimension4 * 2.0f)) / 2.0f;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f19401q;
            if (i11 >= iArr.length) {
                break;
            }
            if (iArr[i11] == 0) {
                this.f19387c.setColor(this.f19410z);
                canvas.drawText("-", (i11 * width) + dimension4, dimension5, this.f19387c);
            } else {
                this.f19387c.setColor(a.f17142a.g(this.f19406v, iArr[i11]));
                if (this.f19406v == 4) {
                    canvas.drawText(this.f19401q[i11] + "-" + this.f19402r[i11], (i11 * width) + dimension4, dimension5, this.f19387c);
                } else {
                    canvas.drawText(String.valueOf(this.f19401q[i11]), (i11 * width) + dimension4, dimension5, this.f19387c);
                }
            }
            i11++;
        }
        this.f19385a.setTextSize(getResources().getDimension(e.O));
        this.f19385a.setColor(this.A);
        float dimension6 = (dimension + getResources().getDimension(e.N)) - this.f19385a.getFontMetrics().top;
        int i12 = 0;
        while (true) {
            String[] strArr = this.f19393i;
            if (i12 >= strArr.length) {
                break;
            }
            canvas.drawText(strArr[2 - i12], (i12 * width) + dimension4, dimension6, this.f19385a);
            i12++;
        }
        this.f19387c.setFakeBoldText(false);
        int i13 = this.f19406v;
        if (i13 != 0) {
            if (i13 != 1) {
                if (i13 != 2) {
                    if (i13 == 3) {
                        b(canvas);
                        return;
                    } else if (i13 != 4) {
                        return;
                    }
                }
            }
            c(canvas);
            return;
        }
        a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (this.f19399o + getResources().getDimension(e.L) + DimensionUtils.dp2px(getContext(), 79.0f)), Integer.MIN_VALUE));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f19395k = getWidth() / 2.0f;
        e();
    }

    public void setArtyLatestValue(ArtyLatest artyLatest) {
        setVisibility(0);
        if (artyLatest.getCurrentComponent() != null) {
            this.f19392h = u.b(artyLatest.getCurrentComponent().getTimestamp());
            this.f19404t = (int) artyLatest.getCurrentComponent().getValue();
            artyLatest.getCurrentComponent().getSpread();
        }
        if (artyLatest.getMinComponent() != null) {
            this.f19401q[0] = (int) artyLatest.getMinComponent().getValue();
            this.f19403s[0] = (int) artyLatest.getMinComponent().getSpread();
        }
        if (artyLatest.getAvgComponent() != null) {
            this.f19401q[1] = (int) artyLatest.getAvgComponent().getValue();
            this.f19403s[1] = (int) artyLatest.getAvgComponent().getSpread();
        }
        if (artyLatest.getMaxComponent() != null) {
            this.f19401q[2] = (int) artyLatest.getMaxComponent().getValue();
            this.f19403s[2] = (int) artyLatest.getMaxComponent().getSpread();
        }
        a aVar = a.f17142a;
        this.f19408x = aVar.h(this.f19406v, this.f19404t, false);
        this.f19409y = aVar.h(this.f19406v, this.f19404t, true);
        this.f19391g = aVar.c(this.f19406v, this.f19404t, true);
        this.f19390f = aVar.c(this.f19406v, this.f19404t, false);
        postInvalidate();
    }

    public void setTodayArtyAllDataInfo(List<c> list) {
        c cVar = list.get(this.f19406v);
        this.f19392h = u.b(cVar.f27462f);
        int i10 = cVar.f27461e;
        this.f19404t = i10;
        int[] iArr = this.f19401q;
        iArr[0] = cVar.f27458b;
        iArr[1] = cVar.f27457a;
        iArr[2] = cVar.f27459c;
        if (cVar instanceof gg.a) {
            gg.a aVar = (gg.a) cVar;
            this.f19405u = aVar.f27455k;
            int[] iArr2 = this.f19402r;
            iArr2[0] = aVar.f27453i;
            iArr2[1] = aVar.f27452h;
            iArr2[2] = aVar.f27454j;
        }
        a aVar2 = a.f17142a;
        this.f19408x = aVar2.h(this.f19406v, i10, false);
        this.f19409y = aVar2.h(this.f19406v, this.f19404t, true);
        this.f19391g = aVar2.c(this.f19406v, this.f19404t, true);
        this.f19390f = aVar2.c(this.f19406v, this.f19404t, false);
        e();
        postInvalidate();
    }

    public ArtyLatestValueCommonView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19392h = "";
        this.f19401q = new int[3];
        this.f19402r = new int[3];
        this.f19403s = new int[3];
        this.f19407w = 0;
        Paint paint = new Paint(1);
        this.f19385a = paint;
        paint.setTextSize(getResources().getDimension(e.Y));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f19387c = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint.setTypeface(h.h(context, g.f34608b));
        paint2.setTypeface(h.h(context, g.f34607a));
        Paint paint3 = new Paint(1);
        this.f19386b = paint3;
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        setLayerType(1, null);
        this.f19388d = new RectF();
        this.f19389e = new RectF();
        this.f19393i = getResources().getStringArray(b.l_res_0x7f030014);
        this.f19394j = getResources().getStringArray(b.o_res_0x7f030017);
        float d10 = d(paint.getTextSize(), paint);
        this.f19399o = d10;
        float dimension = getResources().getDimension(e.Z);
        this.f19397m = dimension;
        float dimension2 = getResources().getDimension(e.f34471b0);
        this.f19398n = dimension2;
        this.f19396l = d10 + dimension + (dimension2 / 2.0f);
        this.f19410z = j7.a.e(this, sh.c.f34441c, -16777216);
        this.A = j7.a.e(this, sh.c.f34440b, -7829368);
    }
}
