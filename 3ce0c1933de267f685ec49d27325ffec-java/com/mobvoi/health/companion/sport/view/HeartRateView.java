package com.mobvoi.health.companion.sport.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import bh.a;
import bh.d;
import bh.f;
import com.mobvoi.health.common.data.pojo.HeartRateLevel;
import com.mobvoi.wear.util.LogCleaner;
import fg.o;
import fg.p;
import fg.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import xf.h;
/* loaded from: classes2.dex */
public class HeartRateView extends View {
    private int B;
    private int C;
    private int D;
    private LinearGradient G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private int O;
    private int P;
    private int Q;
    private String R;
    private int S;
    private int T;
    private int U;
    private int V;

    /* renamed from: a  reason: collision with root package name */
    private int f18843a;

    /* renamed from: b  reason: collision with root package name */
    private int f18844b;

    /* renamed from: c  reason: collision with root package name */
    private int f18845c;

    /* renamed from: f  reason: collision with root package name */
    private List<h> f18848f;

    /* renamed from: g  reason: collision with root package name */
    private List<Integer> f18849g;

    /* renamed from: h  reason: collision with root package name */
    private List<Path> f18850h;

    /* renamed from: i  reason: collision with root package name */
    private List<RectF> f18851i;

    /* renamed from: j  reason: collision with root package name */
    private List<Integer> f18852j;

    /* renamed from: k  reason: collision with root package name */
    private List<Path> f18853k;

    /* renamed from: l  reason: collision with root package name */
    private List<RectF> f18854l;

    /* renamed from: p  reason: collision with root package name */
    private int f18858p;

    /* renamed from: q  reason: collision with root package name */
    private float f18859q;

    /* renamed from: r  reason: collision with root package name */
    private float f18860r;

    /* renamed from: s  reason: collision with root package name */
    private int f18861s;

    /* renamed from: d  reason: collision with root package name */
    private int f18846d = 30;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18847e = true;

    /* renamed from: m  reason: collision with root package name */
    private final Paint f18855m = new Paint(1);

    /* renamed from: n  reason: collision with root package name */
    private final Paint f18856n = new Paint(1);

    /* renamed from: o  reason: collision with root package name */
    private final Paint f18857o = new Paint(1);

    /* renamed from: t  reason: collision with root package name */
    private final Path f18862t = new Path();

    /* renamed from: u  reason: collision with root package name */
    private final Path f18863u = new Path();

    /* renamed from: v  reason: collision with root package name */
    private final Paint f18864v = new Paint(1);

    /* renamed from: w  reason: collision with root package name */
    private final Paint f18865w = new Paint(1);

    /* renamed from: x  reason: collision with root package name */
    private final Paint f18866x = new Paint(1);

    /* renamed from: y  reason: collision with root package name */
    private final Paint f18867y = new Paint(1);

    /* renamed from: z  reason: collision with root package name */
    private final Path f18868z = new Path();
    private final List<PointF> A = new ArrayList();
    private final Rect E = new Rect();
    private RectF F = new RectF();

    public HeartRateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(attributeSet, 0);
    }

    private void a(Canvas canvas) {
        this.f18864v.setColor(this.Q);
        String str = Math.round(this.f18861s) + " " + this.N;
        int i10 = 0;
        this.f18864v.getTextBounds(str, 0, str.length(), this.E);
        int height = this.E.height();
        int width = this.E.width();
        int i11 = (height / 2) + 5;
        int i12 = (int) this.f18859q;
        int i13 = (int) this.f18860r;
        int i14 = i11 * 2;
        int width2 = (getWidth() - i14) - width;
        int i15 = (i12 - (width / 2)) - i11;
        if (i15 >= 0) {
            i10 = i15 > width2 ? width2 : i15;
        }
        this.f18862t.reset();
        float f10 = i12;
        float f11 = i13;
        this.f18862t.moveTo(f10, f11);
        int i16 = i13 - 10;
        float f12 = i16;
        this.f18862t.lineTo(i12 - 10, f12);
        this.f18862t.lineTo(i12 + 10, f12);
        this.f18862t.lineTo(f10, f11);
        this.E.set(i10, i16 - i14, width + i10 + i14, i16);
        this.F.set(this.E);
        float f13 = i11;
        this.f18862t.addRoundRect(this.F, f13, f13, Path.Direction.CCW);
        this.f18862t.close();
        canvas.drawPath(this.f18862t, this.f18864v);
        this.f18864v.setColor(this.O);
        canvas.drawText(str, i10 + i11, ((this.f18860r - 10.0f) - f13) - ((this.f18864v.descent() + this.f18864v.ascent()) / 2.0f), this.f18864v);
    }

    private void b(Canvas canvas) {
        List<Path> list = this.f18850h;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                canvas.drawPath(this.f18850h.get(i10), this.f18857o);
                canvas.drawRect(this.f18851i.get(i10), this.f18855m);
            }
        }
        List<Path> list2 = this.f18853k;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                canvas.drawPath(this.f18853k.get(i11), this.f18857o);
                RectF rectF = this.f18854l.get(i11);
                this.F = rectF;
                canvas.drawRect(rectF, this.f18856n);
            }
        }
    }

    private void c(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        float descent = (this.f18866x.descent() + this.f18866x.ascent()) / 2.0f;
        float paddingTop = ((getPaddingTop() + this.C) - this.D) - 10;
        float f10 = paddingLeft;
        canvas.drawText(this.M, f10, (paddingTop - ((this.f18846d * 19) / 2.0f)) - descent, this.f18866x);
        this.f18866x.setColor(this.O);
        this.f18866x.setAlpha(128);
        canvas.drawText(this.L, f10, (paddingTop - ((this.f18846d * 17) / 2.0f)) - descent, this.f18866x);
        canvas.drawText(this.K, f10, (paddingTop - ((this.f18846d * 14) / 2.0f)) - descent, this.f18866x);
        canvas.drawText(this.J, f10, (paddingTop - ((this.f18846d * 11) / 2.0f)) - descent, this.f18866x);
        canvas.drawText(this.I, f10, (paddingTop - ((this.f18846d * 9) / 2.0f)) - descent, this.f18866x);
        canvas.drawText(this.H, f10, (paddingTop - ((this.f18846d * 3) / 2.0f)) - descent, this.f18866x);
        d.a(canvas, this.f18847e, f10 + (getWidth() / 2.0f), paddingTop - ((this.f18846d * 13) / 2.0f), true);
    }

    private void d(Canvas canvas) {
        int i10;
        int i11 = 1;
        String format = String.format(this.R, 10);
        this.f18867y.setColor(this.O);
        this.f18867y.setAlpha(60);
        this.f18866x.getTextBounds(format, 0, format.length(), this.E);
        int width = this.E.width();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop() + this.C;
        int i12 = this.D;
        float f10 = (paddingTop - i12) - 10;
        float descent = (((i12 / 2.0f) + f10) + 5.0f) - ((this.f18866x.descent() + this.f18866x.ascent()) / 2.0f);
        float f11 = paddingLeft;
        canvas.drawLine(f11, f10, this.B + paddingLeft, f10, this.f18866x);
        int i13 = 0;
        while (i13 <= 3) {
            String str = this.R;
            Object[] objArr = new Object[i11];
            objArr[0] = Integer.valueOf(this.f18845c * i13);
            String format2 = String.format(str, objArr);
            canvas.drawCircle((((this.B * i13) * 1.0f) / 3.0f) + f11, f10, 5.0f, this.f18866x);
            if (i13 == 0) {
                canvas.drawText(format2, f11, descent, this.f18866x);
            } else if (i13 == 3) {
                canvas.drawText(format2, (this.B + paddingLeft) - width, descent, this.f18866x);
            } else {
                canvas.drawText(format2, (f11 + (((this.B * i13) * 1.0f) / 3.0f)) - (width / 2.0f), descent, this.f18866x);
            }
            i13++;
            i11 = 1;
        }
        String valueOf = String.valueOf(this.f18844b);
        this.f18866x.getTextBounds(valueOf, 0, valueOf.length(), this.E);
        int width2 = this.E.width();
        int height = this.E.height();
        float f12 = f10 - (this.f18846d * 2);
        this.f18868z.reset();
        this.f18868z.moveTo(f11, f12);
        this.f18868z.lineTo(((this.B + paddingLeft) - 10) - width2, f12);
        this.f18867y.setColor(-16776961);
        canvas.drawPath(this.f18868z, this.f18867y);
        this.f18867y.setColor(-7829368);
        int i14 = 4;
        int i15 = 10;
        while (i14 < i15) {
            if (i14 == 7) {
                i10 = 10;
            } else {
                String valueOf2 = String.valueOf((this.f18844b * i14) / 9);
                if (i14 == 9) {
                    this.f18867y.setColor(this.P);
                    this.f18867y.setAlpha(153);
                    this.f18866x.setColor(this.P);
                }
                float f13 = f10 - (this.f18846d * i14);
                canvas.drawText(valueOf2, (this.B + paddingLeft) - width2, (height / 2.0f) + f13, this.f18866x);
                this.f18868z.reset();
                this.f18868z.moveTo(f11, f13);
                i10 = 10;
                this.f18868z.lineTo(((this.B + paddingLeft) - 10) - width2, f13);
                canvas.drawPath(this.f18868z, this.f18867y);
            }
            i14++;
            i15 = i10;
        }
        c(canvas);
    }

    private void e() {
        this.A.clear();
        int paddingLeft = getPaddingLeft();
        int size = this.f18848f.size();
        long j10 = this.f18845c * 3 * LogCleaner.ONE_MINUTE;
        float paddingTop = ((getPaddingTop() + this.C) - this.D) - 10.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = this.f18848f.get(i11);
            PointF pointF = new PointF(paddingLeft + ((((float) (hVar.f36542a * this.B)) * 1.0f) / ((float) j10)), paddingTop - (((hVar.f36543b * this.f18846d) * 9.0f) / this.f18844b));
            if (i11 == this.f18858p) {
                this.f18859q = pointF.x;
                this.f18860r = pointF.y;
            }
            this.A.add(pointF);
        }
        this.f18863u.reset();
        if (size > 1) {
            PointF pointF2 = null;
            while (i10 < size) {
                PointF pointF3 = this.A.get(i10);
                if (i10 == 0) {
                    this.f18863u.moveTo(pointF3.x, pointF3.y);
                } else {
                    float f10 = pointF2.x;
                    float f11 = pointF3.x;
                    float f12 = (f10 + f11) / 2.0f;
                    float f13 = pointF2.y;
                    float f14 = pointF3.y;
                    float f15 = (f13 + f14) / 2.0f;
                    if (i10 == 1) {
                        this.f18863u.lineTo(f12, f15);
                    } else if (i10 == this.f18858p) {
                        this.f18863u.lineTo(f11, f14);
                    } else {
                        this.f18863u.quadTo(f10, f13, f12, f15);
                    }
                }
                i10++;
                pointF2 = pointF3;
            }
            this.f18863u.lineTo(pointF2.x, pointF2.y);
        }
    }

    private void f() {
        int paddingTop;
        if (!this.f18847e) {
            float[] fArr = {0.09090909f, 0.2909091f, 0.4909091f, 0.5909091f, 1.0f};
            int[] iArr = {getResources().getColor(o.D), getResources().getColor(o.F), getResources().getColor(o.G), getResources().getColor(o.B), getResources().getColor(o.E)};
            int paddingLeft = getPaddingLeft();
            float f10 = paddingLeft;
            this.G = new LinearGradient(f10, getPaddingTop(), f10, paddingTop + this.C, iArr, fArr, Shader.TileMode.CLAMP);
            e();
            this.Q = a.c(iArr, fArr, this.f18860r / this.C);
            g();
        }
    }

    private void g() {
        int size = this.f18848f.size();
        float paddingTop = ((getPaddingTop() + this.C) - this.D) - 10;
        List<Integer> list = this.f18849g;
        if (list != null && list.size() > 0) {
            this.f18850h = new LinkedList();
            this.f18851i = new LinkedList();
            int size2 = this.f18849g.size();
            int i10 = size2 - (size2 % 2);
            for (int i11 = 0; i11 < i10; i11 += 2) {
                Path path = new Path();
                int intValue = this.f18849g.get(i11).intValue();
                int intValue2 = this.f18849g.get(i11 + 1).intValue();
                PointF pointF = this.A.get(intValue);
                float f10 = pointF.x;
                path.moveTo(f10, paddingTop);
                path.lineTo(pointF.x, pointF.y);
                int min = Math.min(intValue2, size);
                int i12 = intValue + 1;
                while (i12 < min) {
                    PointF pointF2 = this.A.get(i12);
                    float f11 = pointF.x;
                    float f12 = pointF.y;
                    path.quadTo(f11, f12, (pointF2.x + f11) / 2.0f, (pointF2.y + f12) / 2.0f);
                    i12++;
                    pointF = pointF2;
                }
                PointF pointF3 = this.A.get(min);
                path.lineTo(pointF3.x, pointF3.y);
                path.lineTo(pointF3.x, paddingTop);
                path.lineTo(f10, paddingTop);
                path.close();
                RectF rectF = new RectF();
                rectF.set(f10, paddingTop - 4.0f, pointF3.x, paddingTop);
                this.f18851i.add(rectF);
                this.f18850h.add(path);
            }
        }
        List<Integer> list2 = this.f18852j;
        if (list2 != null && list2.size() > 0) {
            this.f18853k = new LinkedList();
            this.f18854l = new LinkedList();
            int size3 = this.f18852j.size();
            int i13 = size3 - (size3 % 2);
            for (int i14 = 0; i14 < i13; i14 += 2) {
                Path path2 = new Path();
                int intValue3 = this.f18852j.get(i14).intValue();
                int intValue4 = this.f18852j.get(i14 + 1).intValue();
                PointF pointF4 = this.A.get(intValue3);
                float f13 = pointF4.x;
                path2.moveTo(f13, paddingTop);
                path2.lineTo(pointF4.x, pointF4.y);
                int min2 = Math.min(intValue4, size);
                int i15 = intValue3 + 1;
                while (i15 < min2) {
                    PointF pointF5 = this.A.get(i15);
                    float f14 = pointF4.x;
                    float f15 = pointF4.y;
                    path2.quadTo(f14, f15, (pointF5.x + f14) / 2.0f, (pointF5.y + f15) / 2.0f);
                    i15++;
                    pointF4 = pointF5;
                }
                PointF pointF6 = this.A.get(min2);
                path2.lineTo(pointF6.x, pointF6.y);
                path2.lineTo(pointF6.x, paddingTop);
                path2.lineTo(f13, paddingTop);
                path2.close();
                RectF rectF2 = new RectF();
                this.F = rectF2;
                rectF2.set(f13, paddingTop - 4.0f, pointF6.x, paddingTop);
                this.f18854l.add(this.F);
                this.f18853k.add(path2);
            }
        }
    }

    private void h(AttributeSet attributeSet, int i10) {
        j();
        d.b(getContext().getApplicationContext());
        this.f18857o.setColor(getResources().getColor(o.f26494z));
        this.f18857o.setStyle(Paint.Style.FILL);
        this.f18855m.setColor(getResources().getColor(o.f26493y));
        this.f18856n.setColor(getResources().getColor(o.f26492x));
        this.f18864v.setStrokeWidth(this.V);
        this.f18864v.setTextSize(this.T);
        this.f18864v.setStyle(Paint.Style.FILL);
        this.f18866x.setTextSize(this.S);
        this.f18866x.setColor(this.O);
        this.f18866x.setAlpha(128);
        this.f18866x.setStyle(Paint.Style.FILL);
        this.f18865w.setStrokeWidth(this.U);
        this.f18865w.setColor(this.O);
        this.f18865w.setStyle(Paint.Style.STROKE);
        this.f18867y.setStrokeWidth(this.V);
        this.f18867y.setColor(this.O);
        this.f18867y.setAlpha(60);
        this.f18867y.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18867y.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
    }

    private void i() {
        this.f18844b = HeartRateLevel.startHeartRateOf(HeartRateLevel.DANGEROUS, this.f18843a);
    }

    private void j() {
        Resources resources = getResources();
        this.H = resources.getString(u.B3);
        this.I = resources.getString(u.C3);
        this.J = resources.getString(u.A3);
        this.K = resources.getString(u.f26996x3);
        this.L = resources.getString(u.f27002y3);
        this.M = resources.getString(u.f27008z3);
        this.O = resources.getColor(o.f26462i);
        this.R = resources.getString(u.f26912j3);
        this.P = resources.getColor(o.A);
        this.N = resources.getString(u.f27007z2);
        this.S = resources.getDimensionPixelSize(p.J);
        this.T = resources.getDimensionPixelSize(p.I);
        this.f18846d = resources.getDimensionPixelSize(p.G);
        this.V = resources.getDimensionPixelSize(p.D);
        this.U = resources.getDimensionPixelSize(p.A);
    }

    public void k(List<h> list, int i10, List<Integer> list2, List<Integer> list3, int i11, int i12, int i13) {
        this.f18843a = i10;
        this.f18847e = f.e(list);
        this.f18845c = i13;
        i();
        if (!this.f18847e) {
            this.f18848f = list;
            this.f18858p = i11;
            this.f18849g = list2;
            this.f18852j = list3;
            this.f18861s = i12;
            String str = this.f18844b + this.N;
            this.f18864v.getTextBounds(str, 0, str.length(), this.E);
        }
        String format = String.format(this.R, 10);
        this.f18866x.getTextBounds(format, 0, format.length(), this.E);
        this.D = this.E.height();
        f();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f18847e) {
            this.f18865w.setShader(this.G);
            canvas.drawPath(this.f18863u, this.f18865w);
            b(canvas);
            a(canvas);
        }
        d(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        this.B = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        int i12 = (this.f18846d * 12) + 20;
        this.C = i12;
        setMeasuredDimension(View.MeasureSpec.getSize(i10), i12 + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        f();
    }
}
