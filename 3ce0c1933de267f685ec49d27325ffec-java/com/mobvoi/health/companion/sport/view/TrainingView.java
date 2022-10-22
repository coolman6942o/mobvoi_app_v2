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
import com.mobvoi.health.companion.sport.viewmodel.pojo.UiTrain;
import com.mobvoi.wear.util.LogCleaner;
import fg.o;
import fg.p;
import fg.u;
import java.util.List;
/* loaded from: classes2.dex */
public class TrainingView extends View {
    private boolean A;
    private String B;
    private String C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;

    /* renamed from: a  reason: collision with root package name */
    private List<UiTrain> f18964a;

    /* renamed from: l  reason: collision with root package name */
    private int f18975l;

    /* renamed from: m  reason: collision with root package name */
    private int f18976m;

    /* renamed from: n  reason: collision with root package name */
    private int f18977n;

    /* renamed from: s  reason: collision with root package name */
    private int f18982s;

    /* renamed from: t  reason: collision with root package name */
    private int f18983t;

    /* renamed from: u  reason: collision with root package name */
    private int f18984u;

    /* renamed from: v  reason: collision with root package name */
    private int f18985v;

    /* renamed from: w  reason: collision with root package name */
    private int f18986w;

    /* renamed from: x  reason: collision with root package name */
    private int f18987x;

    /* renamed from: y  reason: collision with root package name */
    private LinearGradient f18988y;

    /* renamed from: z  reason: collision with root package name */
    private LinearGradient f18989z;

    /* renamed from: b  reason: collision with root package name */
    private int f18965b = 30;

    /* renamed from: c  reason: collision with root package name */
    private int f18966c = 20;

    /* renamed from: d  reason: collision with root package name */
    private int f18967d = 10;

    /* renamed from: e  reason: collision with root package name */
    private int f18968e = 15;

    /* renamed from: f  reason: collision with root package name */
    private Paint f18969f = new Paint(1);

    /* renamed from: g  reason: collision with root package name */
    private Paint f18970g = new Paint(1);

    /* renamed from: h  reason: collision with root package name */
    private Paint f18971h = new Paint(1);

    /* renamed from: i  reason: collision with root package name */
    private Paint f18972i = new Paint(1);

    /* renamed from: j  reason: collision with root package name */
    private Paint f18973j = new Paint(1);

    /* renamed from: k  reason: collision with root package name */
    private Path f18974k = new Path();

    /* renamed from: o  reason: collision with root package name */
    private int f18978o = 10;

    /* renamed from: p  reason: collision with root package name */
    private int f18979p = 3;

    /* renamed from: q  reason: collision with root package name */
    private Rect f18980q = new Rect();

    /* renamed from: r  reason: collision with root package name */
    private RectF f18981r = new RectF();

    public TrainingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet, 0);
    }

    private void a(List<UiTrain> list) {
        int i10 = 0;
        for (UiTrain uiTrain : list) {
            int i11 = (int) (uiTrain.f19007b / LogCleaner.ONE_MINUTE);
            if (i11 > i10) {
                i10 = i11;
            }
        }
        if (i10 > 0) {
            this.f18979p = i10 + (3 - (i10 % 3));
        }
    }

    private void b(AttributeSet attributeSet, int i10) {
        c();
        this.f18969f.setStrokeWidth(this.f18987x);
        this.f18969f.setTextSize(this.f18985v);
        this.f18969f.setAlpha(128);
        this.f18969f.setStyle(Paint.Style.FILL);
        this.f18969f.setColor(getResources().getColor(o.f26462i));
        this.f18971h.setStrokeWidth(this.f18987x);
        this.f18971h.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18971h.setColor(this.E);
        this.f18971h.setAlpha(60);
        this.f18971h.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
        this.f18970g.setTextSize(this.f18986w);
        this.f18970g.setStyle(Paint.Style.FILL);
        this.f18970g.setColor(this.E);
    }

    private void c() {
        Resources resources = getResources();
        this.B = resources.getString(u.f26912j3);
        this.C = resources.getString(u.f26960r3);
        this.D = resources.getString(u.f26936n3);
        this.E = resources.getColor(o.f26460h);
        this.F = resources.getColor(o.Y);
        this.G = resources.getColor(o.V);
        this.H = resources.getColor(o.X);
        this.I = resources.getColor(o.W);
        this.f18985v = resources.getDimensionPixelSize(p.J);
        this.f18986w = resources.getDimensionPixelSize(p.I);
        this.f18987x = resources.getDimensionPixelSize(p.D);
        this.f18965b = resources.getDimensionPixelSize(p.L);
        this.f18966c = resources.getDimensionPixelSize(p.N);
        this.f18967d = resources.getDimensionPixelSize(p.M);
        this.f18968e = resources.getDimensionPixelSize(p.K);
    }

    public void d(List<UiTrain> list, int i10) {
        this.f18964a = list;
        a(list);
        this.f18975l = 0;
        this.f18976m = 0;
        this.f18977n = 0;
        for (UiTrain uiTrain : list) {
            UiTrain.Type type = uiTrain.f19006a;
            if (type == UiTrain.Type.Train) {
                this.f18975l++;
                this.f18977n++;
            } else if (type == UiTrain.Type.Relax) {
                this.f18976m++;
            }
        }
        String format = String.format(this.C, 10, 10);
        this.f18970g.getTextBounds(format, 0, format.length(), this.f18980q);
        this.f18984u = this.f18980q.width();
        String format2 = String.format(this.D, Integer.valueOf(this.f18977n));
        this.f18969f.getTextBounds(format2, 0, format2.length(), this.f18980q);
        int i11 = this.f18977n;
        this.f18983t = ((this.f18965b + this.f18966c + this.f18967d) * i11) + (this.f18968e * (i11 + 1)) + getPaddingTop() + getPaddingBottom() + this.f18978o + this.f18980q.height();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f18983t;
        setLayoutParams(layoutParams);
        this.A = true;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        int i11 = 2;
        int i12 = 3;
        int i13 = (this.f18982s * 2) / 3;
        int paddingLeft = getPaddingLeft() + 10 + this.f18980q.width();
        float f10 = paddingLeft;
        canvas.drawLine(f10, getPaddingTop(), f10, ((this.f18983t - getPaddingBottom()) - this.f18980q.height()) - this.f18978o, this.f18969f);
        int i14 = this.f18965b + this.f18966c + this.f18967d;
        int i15 = 1;
        while (i15 <= this.f18977n) {
            int i16 = i15 - 1;
            int i17 = i16 * 2;
            int i18 = (int) (this.f18964a.get(i17).f19007b / 1000);
            int paddingTop = (this.f18968e * i15) + (i16 * i14) + getPaddingTop();
            float f11 = paddingLeft + 3;
            int i19 = i13 - paddingLeft;
            this.f18981r.set(f11, paddingTop, paddingLeft + (((i18 * i19) / this.f18979p) / 60), this.f18965b + paddingTop);
            canvas.drawCircle(f10, (this.f18965b / i11) + paddingTop, 5.0f, this.f18969f);
            this.f18970g.setAlpha(255);
            String str = this.C;
            Object[] objArr = new Object[i11];
            objArr[0] = Integer.valueOf(i18 / 60);
            objArr[1] = Integer.valueOf(i18 % 60);
            canvas.drawText(String.format(str, objArr), (((this.f18982s - getPaddingLeft()) - getPaddingRight()) - (this.f18984u / i11)) - 10, ((this.f18965b / i11) + paddingTop) - ((this.f18970g.descent() + this.f18970g.ascent()) / 2.0f), this.f18970g);
            RectF rectF = this.f18981r;
            int i20 = this.f18965b;
            canvas.drawRoundRect(rectF, i20 / 2, i20 / i11, this.f18972i);
            canvas.drawText(String.format(this.D, Integer.valueOf(i15)), getPaddingLeft(), (((this.f18965b + this.f18966c) + this.f18967d) / i11) + paddingTop + (this.f18980q.height() / i11), this.f18969f);
            int i21 = paddingTop + this.f18965b + this.f18967d;
            canvas.drawCircle(f10, (this.f18966c / i11) + i21, 5.0f, this.f18969f);
            if (i15 != this.f18977n || this.f18976m >= this.f18975l) {
                int i22 = (int) (this.f18964a.get(i17 + 1).f19007b / 1000);
                this.f18970g.setAlpha(80);
                canvas.drawText(String.format(this.C, Integer.valueOf(i22 / 60), Integer.valueOf(i22 % 60)), (((this.f18982s - getPaddingLeft()) - getPaddingRight()) - (this.f18984u / 2)) - 10, ((this.f18966c / 2) + i21) - ((this.f18970g.descent() + this.f18970g.ascent()) / 2.0f), this.f18970g);
                this.f18981r.set(f11, i21, (((i22 * i19) / this.f18979p) / 60) + paddingLeft, i21 + this.f18966c);
                RectF rectF2 = this.f18981r;
                int i23 = this.f18966c;
                canvas.drawRoundRect(rectF2, i23 / 2, i23 / 2, this.f18973j);
            }
            i15++;
            i11 = 2;
            i12 = 3;
        }
        int i24 = 1;
        for (int i25 = i12; i24 <= i25; i25 = 3) {
            this.f18974k.reset();
            float f12 = (((i13 - paddingLeft) * i24) / i25) + paddingLeft;
            this.f18974k.moveTo(f12, getPaddingTop());
            this.f18974k.lineTo(f12, ((this.f18983t - getPaddingBottom()) - this.f18978o) - this.f18980q.height());
            canvas.drawPath(this.f18974k, this.f18971h);
            canvas.drawText(String.format(this.B, Integer.valueOf((this.f18979p / 3) * i24)), i10 - (this.f18980q.width() / 2), (((this.f18983t - getPaddingBottom()) - (this.f18978o / 2)) + (this.f18980q.height() / 2)) - ((this.f18969f.descent() + this.f18969f.ascent()) / 2.0f), this.f18969f);
            i24++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.A) {
            this.f18983t = View.MeasureSpec.getSize(i11);
        }
        int size = View.MeasureSpec.getSize(i10);
        this.f18982s = size;
        setMeasuredDimension(size, this.f18983t);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f18982s != 0) {
            if (this.f18988y == null) {
                LinearGradient linearGradient = new LinearGradient(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((this.f18982s * 2) / 3), getPaddingTop() + this.f18965b, this.F, this.G, Shader.TileMode.CLAMP);
                this.f18988y = linearGradient;
                this.f18972i.setShader(linearGradient);
            }
            if (this.f18989z == null) {
                LinearGradient linearGradient2 = new LinearGradient(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((this.f18982s * 2) / 3), getPaddingTop() + this.f18966c, this.H, this.I, Shader.TileMode.CLAMP);
                this.f18989z = linearGradient2;
                this.f18973j.setShader(linearGradient2);
            }
        }
    }
}
