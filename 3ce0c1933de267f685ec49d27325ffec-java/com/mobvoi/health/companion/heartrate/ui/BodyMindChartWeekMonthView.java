package com.mobvoi.health.companion.heartrate.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.health.companion.heartrate.ui.b;
import fg.m;
import fg.n;
import fg.o;
import fg.p;
import fg.u;
import j7.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class BodyMindChartWeekMonthView extends View {
    private final Paint A;
    private final Paint B;
    private int C;
    private int D;

    /* renamed from: a  reason: collision with root package name */
    private float f18207a;

    /* renamed from: b  reason: collision with root package name */
    private float f18208b;

    /* renamed from: c  reason: collision with root package name */
    private float f18209c;

    /* renamed from: d  reason: collision with root package name */
    private float f18210d;

    /* renamed from: e  reason: collision with root package name */
    private float f18211e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f18212f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f18213g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f18214h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f18215i;

    /* renamed from: j  reason: collision with root package name */
    private float f18216j;

    /* renamed from: k  reason: collision with root package name */
    private float f18217k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f18218l;

    /* renamed from: m  reason: collision with root package name */
    private List<Path> f18219m;

    /* renamed from: n  reason: collision with root package name */
    private Path f18220n;

    /* renamed from: o  reason: collision with root package name */
    private List<PointF> f18221o;

    /* renamed from: p  reason: collision with root package name */
    private DashPathEffect f18222p;

    /* renamed from: q  reason: collision with root package name */
    private int f18223q;

    /* renamed from: r  reason: collision with root package name */
    private int f18224r;

    /* renamed from: s  reason: collision with root package name */
    private float f18225s;

    /* renamed from: t  reason: collision with root package name */
    private float f18226t;

    /* renamed from: u  reason: collision with root package name */
    private List<b.a> f18227u;

    /* renamed from: v  reason: collision with root package name */
    private long f18228v;

    /* renamed from: w  reason: collision with root package name */
    private int f18229w;

    /* renamed from: x  reason: collision with root package name */
    private final Paint f18230x;

    /* renamed from: y  reason: collision with root package name */
    private final Paint f18231y;

    /* renamed from: z  reason: collision with root package name */
    private final Paint f18232z;

    public BodyMindChartWeekMonthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        float f10;
        float f11;
        List<Integer> list;
        float f12;
        float f13;
        int i10;
        float dimension = getResources().getDimension(p.f26495a);
        float dimension2 = getResources().getDimension(p.f26497b);
        this.f18211e = dimension2;
        this.f18207a = dimension;
        this.f18208b = getHeight() - this.f18211e;
        this.f18209c = dimension;
        this.f18210d = getWidth() - dimension2;
        int i11 = this.f18223q;
        if (i11 > 0) {
            int i12 = 3;
            float f14 = 0.0f;
            int i13 = 2;
            int i14 = 0;
            float f15 = 2.0f;
            if (i11 == 2) {
                this.f18226t = 0.0f;
                this.f18225s = getResources().getDimensionPixelSize(p.Y);
                this.f18224r = 7;
                String[] stringArray = getResources().getStringArray(m.f26441c);
                this.f18214h = stringArray;
                float f16 = this.f18210d;
                float f17 = this.f18209c;
                float length = (f16 - f17) / stringArray.length;
                f10 = (f16 - f17) / 7.0f;
                this.f18215i = new float[stringArray.length];
                int i15 = 0;
                while (true) {
                    float[] fArr = this.f18215i;
                    if (i15 >= fArr.length) {
                        break;
                    }
                    fArr[i15] = this.f18209c + (i15 * length);
                    i15++;
                }
            } else if (i11 == 3) {
                this.f18226t = getResources().getDimensionPixelSize(p.U);
                this.f18225s = getResources().getDimensionPixelSize(p.T);
                this.f18214h = getResources().getStringArray(m.f26440b);
                if (this.f18228v < 0) {
                    this.f18228v = System.currentTimeMillis();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.f18228v);
                int i16 = calendar.get(1);
                int i17 = calendar.get(2);
                if ((i16 % 4 == 0 && i16 % 100 != 0) || i16 % AGCServerException.AUTHENTICATION_INVALID == 0) {
                    this.f18213g[1] = 29;
                }
                int i18 = this.f18213g[i17];
                this.f18224r = i18;
                if (i18 == 28) {
                    String[] strArr = this.f18214h;
                    strArr[strArr.length - 1] = String.format(getResources().getString(u.Q3), 28);
                }
                float f18 = (((this.f18210d - this.f18209c) - (this.f18226t * 2.0f)) - this.f18225s) / this.f18224r;
                this.f18215i = new float[this.f18214h.length];
                int i19 = 0;
                while (true) {
                    float[] fArr2 = this.f18215i;
                    if (i19 >= fArr2.length) {
                        break;
                    }
                    if (i19 == fArr2.length - 1 && this.f18224r == 28) {
                        fArr2[i19] = (this.f18210d - this.f18226t) - (this.f18225s / 2.0f);
                    } else {
                        fArr2[i19] = this.f18209c + this.f18226t + (this.f18225s / 2.0f) + (f18 * 7.0f * i19);
                    }
                    i19++;
                }
                f10 = f18;
            } else {
                f10 = 0.0f;
            }
            List<b.a> list2 = this.f18227u;
            if (list2 != null && list2.size() > 0) {
                this.A.setStrokeWidth(this.f18225s);
                this.A.setColor(androidx.core.content.b.c(getContext(), this.f18229w == 2 ? o.f26469l0 : o.f26471m0));
                this.f18219m.clear();
                this.f18220n.reset();
                this.f18221o.clear();
                float f19 = this.f18208b;
                float f20 = this.f18207a;
                float f21 = (f19 - f20) / 5.0f;
                float f22 = f21 / 2.0f;
                float f23 = f20 + f22;
                float f24 = (f19 - f22) - f23;
                for (b.a aVar : this.f18227u) {
                    int i20 = this.f18223q;
                    if (i20 == i13) {
                        f13 = this.f18209c + (f10 / f15);
                        i10 = aVar.f18271c;
                    } else if (i20 == i12) {
                        f13 = this.f18209c + this.f18226t + (this.f18225s / f15);
                        i10 = aVar.f18271c;
                    } else {
                        f11 = f14;
                        list = aVar.f18269a;
                        if (list != null || list.size() <= 0) {
                            f12 = f15;
                        } else {
                            Collections.sort(list);
                            Point point = new Point();
                            int i21 = i14;
                            int i22 = i21;
                            while (i21 < list.size()) {
                                int intValue = list.get(i21).intValue();
                                if (i22 == 0) {
                                    point.x = intValue;
                                    point.y = intValue;
                                } else if (i22 == intValue) {
                                    point.y = intValue;
                                } else {
                                    Path path = new Path();
                                    path.moveTo(f11, (this.f18208b - ((point.x - 1) * f21)) - (this.f18225s / 2.0f));
                                    path.lineTo(f11, (this.f18208b - (point.y * f21)) + (this.f18225s / 2.0f));
                                    this.f18219m.add(path);
                                    point.x = intValue;
                                    point.y = intValue;
                                }
                                i22 = intValue + 1;
                                i21++;
                            }
                            if (i22 != 0) {
                                Path path2 = new Path();
                                f12 = 2.0f;
                                path2.moveTo(f11, (this.f18208b - ((point.x - 1) * f21)) - (this.f18225s / 2.0f));
                                path2.lineTo(f11, (this.f18208b - (point.y * f21)) + (this.f18225s / 2.0f));
                                this.f18219m.add(path2);
                            } else {
                                f12 = 2.0f;
                            }
                            float f25 = aVar.f18270b;
                            if (f25 >= 1.0f) {
                                PointF pointF = new PointF(f11, ((1.0f - ((f25 - 1.0f) / 4.0f)) * f24) + f23);
                                this.f18221o.add(pointF);
                                if (this.f18227u.indexOf(aVar) == 0) {
                                    this.f18220n.moveTo(pointF.x, pointF.y);
                                } else {
                                    this.f18220n.lineTo(pointF.x, pointF.y);
                                }
                            }
                        }
                        f15 = f12;
                        i12 = 3;
                        f14 = 0.0f;
                        i13 = 2;
                        i14 = 0;
                    }
                    f11 = f13 + (i10 * f10);
                    list = aVar.f18269a;
                    if (list != null) {
                    }
                    f12 = f15;
                    f15 = f12;
                    i12 = 3;
                    f14 = 0.0f;
                    i13 = 2;
                    i14 = 0;
                }
            }
        }
    }

    private void b(Context context) {
        this.D = a.b(context, n.f26445c, -7829368);
        this.C = context.getColor(o.f26464j);
        this.f18217k = getResources().getDimensionPixelSize(p.R);
        this.f18216j = getResources().getDimensionPixelSize(p.S);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        this.f18230x.setColor(this.C);
        float f10 = dimensionPixelSize;
        this.f18230x.setStrokeWidth(f10);
        this.f18230x.setStyle(Paint.Style.FILL);
        this.f18231y.setStyle(Paint.Style.STROKE);
        this.f18231y.setStrokeWidth(f10);
        this.f18232z.setColor(this.C);
        this.f18232z.setTextAlign(Paint.Align.LEFT);
        this.f18232z.setTextSize(getResources().getDimension(p.X));
        this.f18232z.setStyle(Paint.Style.FILL);
        this.A.setStrokeCap(Paint.Cap.ROUND);
        this.A.setStyle(Paint.Style.STROKE);
        this.B.setStyle(Paint.Style.STROKE);
        String valueOf = String.valueOf(24);
        this.f18232z.getTextBounds(valueOf, 0, valueOf.length(), this.f18218l);
    }

    private void c(Canvas canvas) {
        this.f18231y.setColor(this.C);
        this.f18231y.setPathEffect(this.f18222p);
        float f10 = (this.f18208b - this.f18207a) / 5.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            float f11 = this.f18207a + (i11 * f10);
            canvas.drawLine(this.f18209c, f11, this.f18210d, f11, this.f18230x);
        }
        float f12 = this.f18209c;
        float f13 = this.f18208b;
        canvas.drawLine(f12, f13, this.f18210d, f13, this.f18230x);
        float f14 = this.f18209c;
        canvas.drawLine(f14, this.f18207a, f14, this.f18208b + (this.f18211e / 2.0f), this.f18231y);
        float f15 = this.f18210d;
        canvas.drawLine(f15, this.f18207a, f15, this.f18208b, this.f18231y);
        this.f18232z.setColor(this.C);
        this.f18232z.setTextAlign(Paint.Align.LEFT);
        for (int i12 = 0; i12 < this.f18212f.length; i12++) {
            canvas.drawText(String.valueOf(this.f18212f[i12]), this.f18210d + this.f18217k, ((this.f18208b - (i12 * f10)) - (f10 / 2.0f)) + (this.f18218l.height() / 2), this.f18232z);
        }
        if (this.f18215i != null) {
            while (true) {
                float[] fArr = this.f18215i;
                if (i10 < fArr.length) {
                    if (i10 != 0) {
                        canvas.drawLine(fArr[i10], this.f18207a, fArr[i10], (this.f18211e / 2.0f) + this.f18208b, this.f18231y);
                    }
                    canvas.drawText(this.f18214h[i10], this.f18215i[i10] + this.f18217k, this.f18208b + this.f18216j + this.f18218l.height(), this.f18232z);
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void d(List<b.a> list, long j10, int i10, int i11) {
        this.f18227u = list;
        this.f18223q = i11;
        this.f18228v = j10;
        this.f18229w = i10;
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        List<Path> list = this.f18219m;
        if (list == null || list.size() <= 0) {
            this.f18232z.setTextAlign(Paint.Align.CENTER);
            this.f18232z.setColor(this.D);
            canvas.drawText(getResources().getString(u.N2), getWidth() / 2.0f, (this.f18208b - this.f18207a) / 2.0f, this.f18232z);
            return;
        }
        this.B.setStrokeWidth(4.0f);
        this.B.setColor(androidx.core.content.b.c(getContext(), this.f18229w == 2 ? o.f26469l0 : o.f26471m0));
        canvas.drawPath(this.f18220n, this.B);
        this.B.setStrokeWidth(this.f18223q == 2 ? 3.0f : 2.0f);
        this.B.setStyle(Paint.Style.FILL);
        for (PointF pointF : this.f18221o) {
            canvas.drawCircle(pointF.x, pointF.y, (this.f18225s - this.B.getStrokeWidth()) / 2.0f, this.B);
        }
        this.B.setStyle(Paint.Style.STROKE);
        this.B.setColor(-1);
        for (PointF pointF2 : this.f18221o) {
            canvas.drawCircle(pointF2.x, pointF2.y, (this.f18225s - this.B.getStrokeWidth()) / 2.0f, this.B);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public BodyMindChartWeekMonthView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18212f = new int[]{1, 2, 3, 4, 5};
        this.f18213g = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        this.f18218l = new Rect();
        this.f18219m = new ArrayList();
        this.f18220n = new Path();
        this.f18221o = new ArrayList();
        this.f18222p = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f18223q = -1;
        this.f18228v = -1L;
        this.f18230x = new Paint(1);
        this.f18231y = new Paint(1);
        this.f18232z = new Paint(1);
        this.A = new Paint(1);
        this.B = new Paint(1);
        b(context);
    }
}
