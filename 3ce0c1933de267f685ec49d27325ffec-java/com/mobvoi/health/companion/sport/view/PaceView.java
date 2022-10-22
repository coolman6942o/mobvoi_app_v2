package com.mobvoi.health.companion.sport.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import bh.d;
import bh.f;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import ef.a0;
import fg.o;
import fg.p;
import fg.u;
import java.util.List;
import lf.c;
/* loaded from: classes2.dex */
public class PaceView extends View {
    private int A;
    private int B;
    private String C;
    private String D;
    private int E;
    private String F;
    private String G;
    private String H;
    private String I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;

    /* renamed from: h  reason: collision with root package name */
    private List<a0> f18876h;

    /* renamed from: k  reason: collision with root package name */
    private int f18879k;

    /* renamed from: m  reason: collision with root package name */
    private int f18881m;

    /* renamed from: n  reason: collision with root package name */
    private int f18882n;

    /* renamed from: o  reason: collision with root package name */
    private int f18883o;

    /* renamed from: r  reason: collision with root package name */
    private int f18886r;

    /* renamed from: s  reason: collision with root package name */
    private int f18887s;

    /* renamed from: t  reason: collision with root package name */
    private int f18888t;

    /* renamed from: u  reason: collision with root package name */
    private int f18889u;

    /* renamed from: w  reason: collision with root package name */
    private LinearGradient f18891w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f18892x;

    /* renamed from: y  reason: collision with root package name */
    private int f18893y;

    /* renamed from: z  reason: collision with root package name */
    private int f18894z;

    /* renamed from: a  reason: collision with root package name */
    private Paint f18869a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private Paint f18870b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    private Paint f18871c = new Paint(1);

    /* renamed from: d  reason: collision with root package name */
    private Paint f18872d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private Paint f18873e = new Paint(1);

    /* renamed from: f  reason: collision with root package name */
    private Paint f18874f = new Paint(1);

    /* renamed from: g  reason: collision with root package name */
    private Path f18875g = new Path();

    /* renamed from: i  reason: collision with root package name */
    private boolean f18877i = true;

    /* renamed from: j  reason: collision with root package name */
    private int f18878j = 10;

    /* renamed from: l  reason: collision with root package name */
    private Rect f18880l = new Rect();

    /* renamed from: p  reason: collision with root package name */
    private int f18884p = 32;

    /* renamed from: q  reason: collision with root package name */
    private int f18885q = 10;

    /* renamed from: v  reason: collision with root package name */
    private RectF f18890v = new RectF();

    public PaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    private void a(AttributeSet attributeSet, int i10) {
        b();
        this.f18871c.setStrokeWidth(this.B);
        this.f18871c.setStyle(Paint.Style.FILL);
        this.f18869a.setStrokeWidth(this.A);
        this.f18869a.setTextSize(this.f18893y);
        this.f18869a.setAlpha(128);
        this.f18869a.setStyle(Paint.Style.FILL);
        this.f18869a.setColor(this.J);
        this.f18870b.setTextSize(this.f18893y);
        this.f18870b.setAlpha(128);
        this.f18870b.setStyle(Paint.Style.FILL);
        this.f18870b.setColor(this.J);
        this.f18874f.setStrokeWidth(this.A);
        this.f18874f.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18874f.setColor(this.K);
        this.f18874f.setAlpha(60);
        this.f18874f.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
        this.f18872d.setTextSize(this.f18894z);
        this.f18872d.setStyle(Paint.Style.FILL);
        this.f18872d.setColor(this.K);
        this.f18873e.setTextSize(this.f18893y);
        this.f18873e.setStyle(Paint.Style.FILL);
    }

    private void b() {
        Resources resources = getResources();
        this.C = resources.getString(u.f26864b3);
        this.D = c.a(resources, !a.isUnitMetric(getContext()), SportDataType.Distance);
        this.G = resources.getString(u.f26918k3);
        this.J = resources.getColor(o.T);
        this.K = resources.getColor(o.f26460h);
        this.L = resources.getColor(o.R);
        this.M = resources.getColor(o.O);
        this.F = resources.getString(u.f26960r3);
        this.H = resources.getString(u.f26870c3);
        this.I = resources.getString(u.f26857a3);
        this.N = resources.getColor(o.P);
        this.O = resources.getColor(o.N);
        this.f18893y = resources.getDimensionPixelSize(p.J);
        this.f18894z = resources.getDimensionPixelSize(p.I);
        this.f18884p = resources.getDimensionPixelSize(p.E);
        this.f18885q = resources.getDimensionPixelSize(p.F);
        this.A = resources.getDimensionPixelSize(p.D);
        this.B = resources.getDimensionPixelSize(p.A);
    }

    public void c(List<a0> list, float f10, int i10) {
        int size = list.size();
        this.f18879k = i10 * 3;
        boolean e10 = f.e(list);
        this.f18877i = e10;
        if (!e10) {
            if (list.size() < 50) {
                this.f18876h = list;
            } else {
                this.f18876h = list.subList(0, 50);
                size = 50;
            }
            int round = Math.round(f10);
            this.f18879k = round;
            this.f18879k = round + (3 - (round % 3));
        }
        String format = String.format(this.F, 10, 10);
        this.f18872d.getTextBounds(format, 0, format.length(), this.f18880l);
        this.f18888t = this.f18880l.width();
        String format2 = String.format(this.I, 10, 10);
        this.f18873e.getTextBounds(format2, 0, format2.length(), this.f18880l);
        this.f18889u = this.f18880l.width();
        String str = "<" + String.format(this.C, Integer.valueOf(size), this.D);
        this.E = str.length();
        this.f18870b.getTextBounds(str, 0, str.length(), this.f18880l);
        this.f18883o = this.f18880l.width();
        this.f18869a.getTextBounds(str, 0, str.length(), this.f18880l);
        this.f18881m = this.f18880l.height();
        this.f18882n = this.f18880l.width();
        if (size == 0) {
            size = 1;
        }
        this.f18887s = (this.f18884p * size) + (this.f18885q * (size + 1)) + getPaddingTop() + getPaddingBottom() + this.f18878j + this.f18881m;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f18887s;
        setLayoutParams(layoutParams);
        this.f18892x = true;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingTop;
        String format;
        int i10;
        super.onDraw(canvas);
        int i11 = 2;
        int i12 = (this.f18886r * 2) / 3;
        int paddingLeft = getPaddingLeft() + 10 + this.f18882n;
        float f10 = paddingLeft;
        canvas.drawLine(f10, getPaddingTop(), f10, ((this.f18887s - getPaddingBottom()) - (this.f18881m / 2)) - (this.f18878j / 2), this.f18869a);
        Integer num = 0;
        if (this.f18877i) {
            canvas.drawText(String.format(this.C, 1, this.D), getPaddingLeft(), (this.f18887s / 2) + (this.f18881m / 2), this.f18869a);
            canvas.drawCircle(f10, this.f18887s / 2, 5.0f, this.f18869a);
            d.a(canvas, this.f18877i, getPaddingLeft() + (getWidth() / 2), (this.f18887s / 2) + (this.f18881m / 2), false);
        } else {
            int size = this.f18876h.size();
            int descent = (int) ((this.f18872d.descent() + this.f18872d.ascent()) / 2.0f);
            int descent2 = (int) ((this.f18873e.descent() + this.f18873e.ascent()) / 2.0f);
            int i13 = 0;
            while (i13 < size) {
                int i14 = (int) (this.f18876h.get(i13).f25908b * 60.0f);
                int i15 = i13 + 1;
                int i16 = paddingLeft + 3;
                num = num;
                i12 = i12;
                this.f18890v.set(i16, (this.f18885q * i15) + (this.f18884p * i13) + getPaddingTop(), i16 + ((((i12 - paddingLeft) * i14) / this.f18879k) / 60), this.f18884p + paddingTop);
                RectF rectF = this.f18890v;
                int i17 = this.f18884p;
                canvas.drawRoundRect(rectF, i17 / 2, i17 / 2, this.f18871c);
                canvas.drawCircle(f10, (this.f18884p / 2) + paddingTop, 5.0f, this.f18869a);
                this.f18872d.setAlpha(255);
                canvas.drawText(String.format(this.F, Integer.valueOf(i14 / 60), Integer.valueOf(i14 % 60)), (((this.f18886r - getPaddingRight()) - (this.f18888t / 2)) - this.f18889u) - 20, ((this.f18884p / 2) + paddingTop) - descent, this.f18872d);
                if (!(i13 == 0 || i13 == size - 1)) {
                    int i18 = ((int) (this.f18876h.get(i13).f25908b * 60.0f)) - ((int) (this.f18876h.get(i13 - 1).f25908b * 60.0f));
                    if (i18 < 0) {
                        int i19 = -i18;
                        this.f18873e.setColor(this.N);
                        canvas.drawText(String.format(this.H, Integer.valueOf(i19 / 60), Integer.valueOf(i19 % 60)), ((this.f18886r - getPaddingRight()) - (this.f18889u / 2)) - 10, ((this.f18884p / 2) + paddingTop) - descent2, this.f18873e);
                    } else {
                        this.f18873e.setColor(this.O);
                        canvas.drawText(String.format(this.I, Integer.valueOf(i18 / 60), Integer.valueOf(i18 % 60)), ((this.f18886r - getPaddingRight()) - (this.f18889u / 2)) - 10, ((this.f18884p / 2) + paddingTop) - descent2, this.f18873e);
                    }
                }
                if (i13 == size - 1) {
                    i11 = 2;
                    canvas.drawText("<" + String.format(this.C, Integer.valueOf(i15), this.D), getPaddingLeft() - (this.f18883o - this.f18882n), paddingTop + (this.f18884p / 2) + (this.f18881m / 2), this.f18870b);
                } else {
                    i11 = 2;
                    canvas.drawText(String.format(this.C, Integer.valueOf(i15), this.D), getPaddingLeft() + ((this.f18882n * (this.E - format.length())) / this.E), paddingTop + (this.f18884p / 2) + (this.f18881m / 2), this.f18869a);
                }
                i13 = i15;
            }
        }
        Integer num2 = num;
        int i20 = i12;
        String str = this.G;
        Object[] objArr = new Object[i11];
        objArr[0] = 1;
        objArr[1] = num2;
        String format2 = String.format(str, objArr);
        this.f18869a.getTextBounds(format2, 0, format2.length(), this.f18880l);
        int i21 = 1;
        for (int i22 = 3; i21 <= i22; i22 = 3) {
            this.f18875g.reset();
            float f11 = (((i20 - paddingLeft) * i21) / i22) + paddingLeft;
            this.f18875g.moveTo(f11, getPaddingTop());
            this.f18875g.lineTo(f11, ((this.f18887s - getPaddingBottom()) - this.f18878j) - this.f18880l.height());
            canvas.drawPath(this.f18875g, this.f18874f);
            canvas.drawText(String.format(this.F, Integer.valueOf((this.f18879k / 3) * i21), num2), i10 - (this.f18880l.width() / 2), (((this.f18887s - getPaddingBottom()) - (this.f18878j / 2)) + (this.f18880l.height() / 2)) - ((this.f18869a.descent() + this.f18869a.ascent()) / 2.0f), this.f18869a);
            i21++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.f18892x) {
            this.f18887s = View.MeasureSpec.getSize(i11);
        }
        int size = View.MeasureSpec.getSize(i10);
        this.f18886r = size;
        setMeasuredDimension(size, this.f18887s);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f18886r != 0 && this.f18891w == null) {
            LinearGradient linearGradient = new LinearGradient(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((this.f18886r * 2) / 3), getPaddingTop(), this.L, this.M, Shader.TileMode.CLAMP);
            this.f18891w = linearGradient;
            this.f18871c.setShader(linearGradient);
        }
    }
}
