package com.mobvoi.health.companion.heartrate.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.mobvoi.health.companion.heartrate.ui.b;
import fg.m;
import fg.n;
import fg.o;
import fg.p;
import fg.u;
import j7.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BodyMindChartDayView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f18184a;

    /* renamed from: b  reason: collision with root package name */
    private float f18185b;

    /* renamed from: c  reason: collision with root package name */
    private float f18186c;

    /* renamed from: d  reason: collision with root package name */
    private float f18187d;

    /* renamed from: e  reason: collision with root package name */
    private float f18188e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f18189f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f18190g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f18191h;

    /* renamed from: i  reason: collision with root package name */
    private float f18192i;

    /* renamed from: j  reason: collision with root package name */
    private float f18193j;

    /* renamed from: k  reason: collision with root package name */
    private Rect f18194k;

    /* renamed from: l  reason: collision with root package name */
    private DashPathEffect f18195l;

    /* renamed from: m  reason: collision with root package name */
    private int f18196m;

    /* renamed from: n  reason: collision with root package name */
    private float f18197n;

    /* renamed from: o  reason: collision with root package name */
    private float f18198o;

    /* renamed from: p  reason: collision with root package name */
    private List<b.a> f18199p;

    /* renamed from: q  reason: collision with root package name */
    private List<PointF> f18200q;

    /* renamed from: r  reason: collision with root package name */
    private Paint f18201r;

    /* renamed from: s  reason: collision with root package name */
    private Paint f18202s;

    /* renamed from: t  reason: collision with root package name */
    private Paint f18203t;

    /* renamed from: u  reason: collision with root package name */
    private Paint f18204u;

    /* renamed from: v  reason: collision with root package name */
    private int f18205v;

    /* renamed from: w  reason: collision with root package name */
    private int f18206w;

    public BodyMindChartDayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        String[] strArr;
        float dimension = getResources().getDimension(p.f26495a);
        float dimension2 = getResources().getDimension(p.f26497b);
        this.f18188e = dimension2;
        this.f18184a = dimension;
        this.f18185b = getHeight() - this.f18188e;
        this.f18186c = dimension;
        this.f18187d = getWidth() - dimension2;
        this.f18190g = getResources().getStringArray(m.f26439a);
        this.f18198o = getResources().getDimensionPixelSize(p.U);
        float dimensionPixelSize = getResources().getDimensionPixelSize(p.T);
        this.f18197n = dimensionPixelSize;
        this.f18204u.setStrokeWidth(dimensionPixelSize);
        this.f18204u.setColor(getResources().getColor(this.f18196m == 2 ? o.f26469l0 : o.f26471m0));
        float f10 = this.f18187d;
        float f11 = this.f18186c;
        float f12 = this.f18198o;
        float f13 = this.f18197n;
        float length = (((f10 - f11) - (f12 * 2.0f)) - f13) / strArr.length;
        float f14 = (((f10 - f11) - (f12 * 2.0f)) - f13) / 48.0f;
        this.f18191h = new float[this.f18190g.length];
        int i10 = 0;
        while (true) {
            float[] fArr = this.f18191h;
            if (i10 >= fArr.length) {
                break;
            }
            fArr[i10] = this.f18186c + this.f18198o + (this.f18197n / 2.0f) + (i10 * length);
            i10++;
        }
        List<b.a> list = this.f18199p;
        if (list != null && list.size() > 0) {
            float f15 = (this.f18185b - this.f18184a) / 5.0f;
            this.f18200q.clear();
            for (b.a aVar : this.f18199p) {
                List<Integer> list2 = aVar.f18269a;
                if (list2 != null && list2.size() > 0) {
                    for (Integer num : list2) {
                        this.f18200q.add(new PointF(this.f18186c + this.f18198o + (this.f18197n / 2.0f) + (aVar.f18271c * f14), this.f18185b - ((f15 / 2.0f) + ((num.intValue() - 1) * f15))));
                    }
                }
            }
        }
    }

    private void b(Context context) {
        this.f18205v = a.b(context, n.f26445c, -7829368);
        this.f18206w = context.getColor(o.f26464j);
        this.f18193j = getResources().getDimensionPixelSize(p.R);
        this.f18192i = getResources().getDimensionPixelSize(p.S);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        this.f18201r.setColor(this.f18206w);
        float f10 = dimensionPixelSize;
        this.f18201r.setStrokeWidth(f10);
        this.f18201r.setStyle(Paint.Style.FILL);
        this.f18202s.setStyle(Paint.Style.STROKE);
        this.f18202s.setStrokeWidth(f10);
        this.f18203t.setColor(this.f18206w);
        this.f18203t.setTextAlign(Paint.Align.LEFT);
        this.f18203t.setTextSize(getResources().getDimension(p.X));
        this.f18203t.setStyle(Paint.Style.FILL);
        this.f18204u.setStrokeCap(Paint.Cap.ROUND);
        this.f18204u.setStyle(Paint.Style.FILL);
        this.f18204u.setStyle(Paint.Style.FILL);
        String valueOf = String.valueOf(24);
        this.f18203t.getTextBounds(valueOf, 0, valueOf.length(), this.f18194k);
    }

    private void c(Canvas canvas) {
        this.f18202s.setColor(this.f18206w);
        this.f18202s.setPathEffect(this.f18195l);
        float f10 = (this.f18185b - this.f18184a) / 5.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            float f11 = this.f18184a + (i11 * f10);
            canvas.drawLine(this.f18186c, f11, this.f18187d, f11, this.f18201r);
        }
        float f12 = this.f18186c;
        float f13 = this.f18185b;
        canvas.drawLine(f12, f13, this.f18187d, f13, this.f18201r);
        float f14 = this.f18186c;
        canvas.drawLine(f14, this.f18184a, f14, this.f18185b + (this.f18188e / 2.0f), this.f18202s);
        float f15 = this.f18187d;
        canvas.drawLine(f15, this.f18184a, f15, this.f18185b, this.f18202s);
        this.f18203t.setColor(this.f18206w);
        this.f18203t.setTextAlign(Paint.Align.LEFT);
        for (int i12 = 0; i12 < this.f18189f.length; i12++) {
            canvas.drawText(String.valueOf(this.f18189f[i12]), this.f18187d + this.f18193j, ((this.f18185b - (i12 * f10)) - (f10 / 2.0f)) + (this.f18194k.height() / 2), this.f18203t);
        }
        if (this.f18191h != null) {
            while (true) {
                float[] fArr = this.f18191h;
                if (i10 < fArr.length) {
                    if (i10 != 0) {
                        canvas.drawLine(fArr[i10], this.f18184a, fArr[i10], (this.f18188e / 2.0f) + this.f18185b, this.f18202s);
                    }
                    canvas.drawText(this.f18190g[i10], this.f18191h[i10] + this.f18193j, this.f18185b + this.f18192i + this.f18194k.height(), this.f18203t);
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void d(List<b.a> list, int i10) {
        this.f18199p = list;
        this.f18196m = i10;
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        List<PointF> list = this.f18200q;
        if (list == null || list.size() <= 0) {
            this.f18203t.setTextAlign(Paint.Align.CENTER);
            this.f18203t.setColor(this.f18205v);
            canvas.drawText(getResources().getString(u.N2), getWidth() / 2, (this.f18185b - this.f18184a) / 2.0f, this.f18203t);
            return;
        }
        for (PointF pointF : this.f18200q) {
            canvas.drawPoint(pointF.x, pointF.y, this.f18204u);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public BodyMindChartDayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18189f = new int[]{1, 2, 3, 4, 5};
        this.f18194k = new Rect();
        this.f18195l = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f18200q = new ArrayList();
        this.f18201r = new Paint(1);
        this.f18202s = new Paint(1);
        this.f18203t = new Paint(1);
        this.f18204u = new Paint(1);
        b(context);
    }
}
