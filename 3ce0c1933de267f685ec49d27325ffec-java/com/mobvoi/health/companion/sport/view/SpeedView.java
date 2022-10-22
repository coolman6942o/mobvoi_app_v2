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
import android.view.ViewGroup;
import bh.d;
import bh.f;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.wear.util.LogCleaner;
import ef.b0;
import fg.o;
import fg.p;
import fg.u;
import java.util.ArrayList;
import java.util.List;
import lf.c;
/* loaded from: classes2.dex */
public class SpeedView extends View {
    private LinearGradient B;
    private String C;
    private String D;
    private int E;
    private int F;
    private int G;

    /* renamed from: c  reason: collision with root package name */
    private int f18914c;

    /* renamed from: d  reason: collision with root package name */
    private List<b0> f18915d;

    /* renamed from: f  reason: collision with root package name */
    private int f18917f;

    /* renamed from: g  reason: collision with root package name */
    private float f18918g;

    /* renamed from: h  reason: collision with root package name */
    private float f18919h;

    /* renamed from: i  reason: collision with root package name */
    private float f18920i;

    /* renamed from: s  reason: collision with root package name */
    private int f18930s;

    /* renamed from: t  reason: collision with root package name */
    private int f18931t;

    /* renamed from: u  reason: collision with root package name */
    private int f18932u;

    /* renamed from: v  reason: collision with root package name */
    private int f18933v;

    /* renamed from: w  reason: collision with root package name */
    private int f18934w;

    /* renamed from: x  reason: collision with root package name */
    private int f18935x;

    /* renamed from: y  reason: collision with root package name */
    private int f18936y;

    /* renamed from: a  reason: collision with root package name */
    private int f18912a = 80;

    /* renamed from: b  reason: collision with root package name */
    private int f18913b = 3;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18916e = true;

    /* renamed from: j  reason: collision with root package name */
    private int f18921j = 25;

    /* renamed from: k  reason: collision with root package name */
    private Path f18922k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private Path f18923l = new Path();

    /* renamed from: m  reason: collision with root package name */
    private Paint f18924m = new Paint(1);

    /* renamed from: n  reason: collision with root package name */
    private Paint f18925n = new Paint(1);

    /* renamed from: o  reason: collision with root package name */
    private Paint f18926o = new Paint(1);

    /* renamed from: p  reason: collision with root package name */
    private Paint f18927p = new Paint(1);

    /* renamed from: q  reason: collision with root package name */
    private Path f18928q = new Path();

    /* renamed from: r  reason: collision with root package name */
    private List<PointF> f18929r = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private Rect f18937z = new Rect();
    private RectF A = new RectF();

    public SpeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(attributeSet, 0);
    }

    private void a(Canvas canvas) {
        this.f18924m.setColor(this.G);
        String str = Math.round(this.f18920i) + this.D;
        int i10 = 0;
        this.f18924m.getTextBounds(str, 0, str.length(), this.f18937z);
        int height = this.f18937z.height();
        int width = this.f18937z.width();
        int i11 = (height / 2) + 5;
        int i12 = (int) this.f18918g;
        int i13 = (int) this.f18919h;
        int i14 = i11 * 2;
        int width2 = (getWidth() - i14) - width;
        int i15 = (i12 - (width / 2)) - i11;
        if (i15 >= 0) {
            i10 = i15 > width2 ? width2 : i15;
        }
        this.f18922k.reset();
        float f10 = i12;
        float f11 = i13;
        this.f18922k.moveTo(f10, f11);
        int i16 = i13 - 10;
        float f12 = i16;
        this.f18922k.lineTo(i12 - 10, f12);
        this.f18922k.lineTo(i12 + 10, f12);
        this.f18922k.lineTo(f10, f11);
        this.f18937z.set(i10, i16 - i14, width + i10 + i14, i16);
        this.A.set(this.f18937z);
        float f13 = i11;
        this.f18922k.addRoundRect(this.A, f13, f13, Path.Direction.CCW);
        this.f18922k.close();
        canvas.drawPath(this.f18922k, this.f18924m);
        this.f18924m.setColor(this.F);
        canvas.drawText(str, i10 + i11, ((this.f18919h - 10.0f) - f13) - ((this.f18924m.descent() + this.f18924m.ascent()) / 2.0f), this.f18924m);
    }

    private void b(Canvas canvas) {
        this.f18925n.setShader(this.B);
        canvas.drawPath(this.f18923l, this.f18925n);
    }

    private void c(Canvas canvas) {
        String format = String.format(this.C, 10);
        this.f18926o.getTextBounds(format, 0, format.length(), this.f18937z);
        this.f18932u = this.f18937z.height();
        int width = this.f18937z.width();
        canvas.drawLine(getPaddingLeft(), ((getPaddingTop() + this.f18931t) - this.f18932u) - 10, getPaddingLeft() + this.f18930s, ((getPaddingTop() + this.f18931t) - this.f18932u) - 10, this.f18926o);
        for (int i10 = 0; i10 <= this.f18913b; i10++) {
            String format2 = String.format(this.C, Integer.valueOf(this.f18914c * i10));
            canvas.drawCircle(getPaddingLeft() + ((this.f18930s * i10) / this.f18913b), ((getPaddingTop() + this.f18931t) - this.f18932u) - 10, 5.0f, this.f18926o);
            if (i10 == 0) {
                canvas.drawText(format2, getPaddingLeft(), (((getPaddingTop() + this.f18931t) - (this.f18932u / 2)) - 5) - ((this.f18926o.descent() + this.f18926o.ascent()) / 2.0f), this.f18926o);
            } else if (i10 == this.f18913b) {
                canvas.drawText(format2, (getPaddingLeft() + this.f18930s) - width, (((getPaddingTop() + this.f18931t) - (this.f18932u / 2)) - 5) - ((this.f18926o.descent() + this.f18926o.ascent()) / 2.0f), this.f18926o);
            } else {
                canvas.drawText(format2, (getPaddingLeft() + ((this.f18930s * i10) / this.f18913b)) - (width / 2), (((getPaddingTop() + this.f18931t) - (this.f18932u / 2)) - 5) - ((this.f18926o.descent() + this.f18926o.ascent()) / 2.0f), this.f18926o);
            }
        }
        String valueOf = String.valueOf(this.f18921j);
        float paddingTop = ((getPaddingTop() + this.f18931t) - this.f18932u) - 10;
        this.f18926o.getTextBounds(valueOf, 0, valueOf.length(), this.f18937z);
        int width2 = this.f18937z.width();
        int height = this.f18937z.height();
        for (int i11 = 1; i11 <= 5; i11++) {
            canvas.drawText(String.valueOf((this.f18921j / 5) * i11), getPaddingLeft(), (paddingTop - (this.f18912a * i11)) + (height / 2), this.f18926o);
            this.f18928q.reset();
            this.f18928q.moveTo(getPaddingLeft() + 10 + width2, paddingTop - (this.f18912a * i11));
            this.f18928q.lineTo(getPaddingLeft() + this.f18930s, paddingTop - (this.f18912a * i11));
            canvas.drawPath(this.f18928q, this.f18927p);
        }
        d.a(canvas, this.f18916e, getPaddingLeft() + (getWidth() / 2), paddingTop - ((this.f18912a * 7) / 2), true);
    }

    private void d() {
        if (this.f18929r.size() <= 0) {
            this.f18929r.clear();
            int paddingLeft = getPaddingLeft();
            int size = this.f18915d.size();
            long j10 = this.f18914c * this.f18913b * LogCleaner.ONE_MINUTE;
            float f10 = (this.f18931t - this.f18932u) - 10;
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                b0 b0Var = this.f18915d.get(i11);
                PointF pointF = new PointF((float) (paddingLeft + ((b0Var.f25912a * this.f18930s) / j10)), f10 - (((b0Var.f25913b * this.f18912a) * 5.0f) / this.f18921j));
                if (i11 == this.f18917f) {
                    this.f18918g = pointF.x;
                    this.f18919h = pointF.y;
                }
                this.f18929r.add(pointF);
            }
            this.f18923l.reset();
            if (size > 1) {
                PointF pointF2 = null;
                while (i10 < size) {
                    PointF pointF3 = this.f18929r.get(i10);
                    if (i10 == 0) {
                        this.f18923l.moveTo(pointF3.x, pointF3.y);
                    } else {
                        float f11 = pointF2.x;
                        float f12 = pointF3.x;
                        float f13 = (f11 + f12) / 2.0f;
                        float f14 = pointF2.y;
                        float f15 = pointF3.y;
                        float f16 = (f14 + f15) / 2.0f;
                        if (i10 == 1) {
                            this.f18923l.lineTo(f13, f16);
                        } else if (i10 == this.f18917f) {
                            this.f18923l.lineTo(f12, f15);
                        } else {
                            this.f18923l.quadTo(f11, f14, f13, f16);
                        }
                    }
                    i10++;
                    pointF2 = pointF3;
                }
                this.f18923l.lineTo(pointF2.x, pointF2.y);
            }
        }
    }

    private void e(AttributeSet attributeSet, int i10) {
        f();
        this.f18924m.setStrokeWidth(this.f18935x);
        this.f18924m.setTextSize(this.f18934w);
        this.f18924m.setStyle(Paint.Style.FILL);
        this.f18926o.setStrokeWidth(this.f18935x);
        this.f18926o.setTextSize(this.f18933v);
        this.f18926o.setColor(this.E);
        this.f18926o.setStyle(Paint.Style.FILL);
        this.f18925n.setStrokeWidth(this.f18936y);
        this.f18925n.setColor(this.F);
        this.f18925n.setStyle(Paint.Style.STROKE);
        this.f18927p.setAlpha(0);
        this.f18927p.setStrokeWidth(this.f18935x);
        this.f18927p.setColor(this.E);
        this.f18927p.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18927p.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
    }

    private void f() {
        Resources resources = getResources();
        this.C = resources.getString(u.f26912j3);
        this.E = resources.getColor(o.f26451c0);
        this.F = resources.getColor(17170443);
        this.G = resources.getColor(o.Z);
        this.D = c.a(resources, !a.isUnitMetric(getContext()), SportDataType.Speed);
        this.f18933v = resources.getDimensionPixelSize(p.J);
        this.f18934w = resources.getDimensionPixelSize(p.I);
        this.f18935x = resources.getDimensionPixelSize(p.D);
        this.f18936y = resources.getDimensionPixelSize(p.A);
        this.f18912a = resources.getDimensionPixelSize(p.H);
    }

    public void g(List<b0> list, int i10, float f10, int i11) {
        this.f18914c = i11;
        boolean e10 = f.e(list);
        this.f18916e = e10;
        this.f18915d = list;
        if (!e10) {
            this.f18917f = i10;
            this.f18920i = f10;
            this.f18921j = (int) Math.ceil(f10);
            String format = String.format(this.C, 10);
            this.f18926o.getTextBounds(format, 0, format.length(), this.f18937z);
            int i12 = this.f18921j;
            this.f18921j = i12 + (i12 % 5 == 0 ? 0 : 5 - (i12 % 5));
        }
        this.f18931t = (this.f18912a * 6) + this.f18937z.height() + 20 + getPaddingBottom() + getPaddingTop();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f18931t;
        setLayoutParams(layoutParams);
        float height = (((this.f18912a - this.f18937z.height()) - 10) / 6.0f) / this.f18912a;
        float[] fArr = {height, 0.33333334f + height, 0.5f + height, 0.6666667f + height};
        int[] iArr = {getResources().getColor(o.Z), getResources().getColor(o.f26449b0), getResources().getColor(o.f26453d0), getResources().getColor(o.f26447a0)};
        this.G = bh.a.c(iArr, fArr, (1.0f - (f10 / this.f18921j)) + height);
        this.B = new LinearGradient(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop() + this.f18931t, iArr, fArr, Shader.TileMode.CLAMP);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        if (!this.f18916e) {
            b(canvas);
            a(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        this.f18930s = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        this.f18931t = (View.MeasureSpec.getSize(i11) - getPaddingTop()) - getPaddingBottom();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (!this.f18916e) {
            d();
        }
    }
}
