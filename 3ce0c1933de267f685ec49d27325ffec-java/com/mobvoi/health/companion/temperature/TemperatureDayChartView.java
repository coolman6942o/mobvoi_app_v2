package com.mobvoi.health.companion.temperature;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import fg.m;
import fg.o;
import fg.p;
import fg.u;
import ih.a;
import ih.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class TemperatureDayChartView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f19020a;

    /* renamed from: b  reason: collision with root package name */
    private float f19021b;

    /* renamed from: c  reason: collision with root package name */
    private float f19022c;

    /* renamed from: d  reason: collision with root package name */
    private float f19023d;

    /* renamed from: e  reason: collision with root package name */
    private float f19024e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f19025f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f19026g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f19027h;

    /* renamed from: i  reason: collision with root package name */
    private float f19028i;

    /* renamed from: j  reason: collision with root package name */
    private float f19029j;

    /* renamed from: k  reason: collision with root package name */
    private Rect f19030k;

    /* renamed from: l  reason: collision with root package name */
    private Path f19031l;

    /* renamed from: m  reason: collision with root package name */
    private SimpleDateFormat f19032m;

    /* renamed from: n  reason: collision with root package name */
    private List<PointF> f19033n;

    /* renamed from: o  reason: collision with root package name */
    private float f19034o;

    /* renamed from: p  reason: collision with root package name */
    private float f19035p;

    /* renamed from: q  reason: collision with root package name */
    private DashPathEffect f19036q;

    /* renamed from: r  reason: collision with root package name */
    private float f19037r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f19038s;

    /* renamed from: t  reason: collision with root package name */
    private b f19039t;

    /* renamed from: u  reason: collision with root package name */
    private int f19040u;

    /* renamed from: v  reason: collision with root package name */
    private Paint f19041v;

    /* renamed from: w  reason: collision with root package name */
    private Paint f19042w;

    /* renamed from: x  reason: collision with root package name */
    private Paint f19043x;

    /* renamed from: y  reason: collision with root package name */
    private Paint f19044y;

    /* renamed from: z  reason: collision with root package name */
    private Paint f19045z;

    public TemperatureDayChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int a(long j10) {
        String[] split = this.f19032m.format(Long.valueOf(j10)).split(":");
        return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
    }

    private void b() {
        String[] strArr;
        float f10;
        float f11;
        int i10;
        int[] iArr;
        float dimension = getResources().getDimension(p.V);
        float dimension2 = getResources().getDimension(p.W);
        this.f19024e = dimension2;
        this.f19020a = dimension;
        this.f19021b = getHeight() - this.f19024e;
        this.f19022c = dimension;
        this.f19023d = getWidth() - dimension2;
        this.f19026g = getResources().getStringArray(m.f26439a);
        float dimensionPixelSize = getResources().getDimensionPixelSize(p.U);
        this.f19037r = dimensionPixelSize;
        float f12 = this.f19023d;
        float f13 = this.f19022c;
        float length = ((f12 - f13) - (dimensionPixelSize * 2.0f)) / strArr.length;
        float f14 = ((f12 - f13) - (dimensionPixelSize * 2.0f)) / 144.0f;
        this.f19027h = new float[this.f19026g.length];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            float[] fArr = this.f19027h;
            if (i12 >= fArr.length) {
                break;
            }
            fArr[i12] = this.f19022c + this.f19037r + (i12 * length);
            i12++;
        }
        b bVar = this.f19039t;
        if (bVar != null) {
            int ceil = bVar.f28275d > 0.0f ? (int) Math.ceil(Math.max(f10, this.f19025f[0])) : this.f19025f[0];
            if (this.f19039t.f28274c > 0.0f) {
                int[] iArr2 = this.f19025f;
                i10 = (int) Math.floor(Math.min(f11, iArr2[iArr2.length - 1]));
            } else {
                i10 = this.f19025f[iArr.length - 1];
            }
            int[] iArr3 = this.f19025f;
            if (ceil > iArr3[0] || i10 < iArr3[iArr3.length - 1]) {
                if (this.f19038s) {
                    int i13 = (ceil - i10) + 1;
                    this.f19025f = new int[i13];
                    for (int i14 = 0; i14 < i13; i14++) {
                        this.f19025f[i14] = ceil - i14;
                    }
                } else {
                    if ((ceil - i10) % 2 != 0) {
                        ceil++;
                    }
                    int i15 = ((ceil - i10) / 2) + 1;
                    this.f19025f = new int[i15];
                    for (int i16 = 0; i16 < i15; i16++) {
                        this.f19025f[i16] = ceil - (i16 * 2);
                    }
                }
            }
            List<a> list = this.f19039t.f28279h;
            this.f19033n.clear();
            int[] iArr4 = this.f19025f;
            int i17 = iArr4[0];
            int i18 = iArr4[iArr4.length - 1];
            for (int i19 = 0; i19 < list.size(); i19++) {
                a aVar = list.get(i19);
                float a10 = this.f19022c + this.f19037r + ((a(aVar.f28271a) / 10) * f14);
                float f15 = this.f19021b;
                this.f19033n.add(new PointF(a10, f15 - (((f15 - this.f19020a) * (aVar.f28272b - i18)) / (i17 - i18))));
            }
            this.f19031l.reset();
            PointF pointF = null;
            while (i11 < this.f19033n.size()) {
                PointF pointF2 = this.f19033n.get(i11);
                if (i11 == 0) {
                    this.f19031l.moveTo(pointF2.x, pointF2.y);
                } else {
                    Path path = this.f19031l;
                    float f16 = pointF.x;
                    float f17 = pointF.y;
                    path.quadTo(f16, f17, (pointF2.x + f16) / 2.0f, (pointF2.y + f17) / 2.0f);
                }
                i11++;
                pointF = pointF2;
            }
            if (pointF != null) {
                this.f19031l.lineTo(pointF.x, pointF.y);
            }
            float f18 = this.f19039t.f28273b;
            this.f19035p = f18;
            float f19 = this.f19021b;
            this.f19034o = f19 - (((f19 - this.f19020a) * (f18 - i18)) / (i17 - i18));
        }
    }

    private void c(Context context) {
        boolean isTempCelsius = com.mobvoi.companion.base.settings.a.isTempCelsius(context);
        this.f19038s = isTempCelsius;
        if (isTempCelsius) {
            this.f19025f = new int[]{38, 37, 36, 35};
        } else {
            this.f19025f = new int[]{101, 99, 97, 95};
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        this.f19040u = getResources().getColor(o.f26470m);
        getResources().getColor(o.f26466k);
        this.f19029j = getResources().getDimensionPixelSize(p.R);
        this.f19028i = getResources().getDimensionPixelSize(p.S);
        getResources().getDimensionPixelSize(p.Q);
        getResources().getDimensionPixelSize(p.P);
        Paint paint = this.f19041v;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        float f10 = dimensionPixelSize;
        this.f19041v.setStrokeWidth(f10);
        this.f19041v.setStyle(Paint.Style.FILL);
        this.f19042w.setStyle(Paint.Style.STROKE);
        this.f19042w.setStrokeWidth(f10);
        this.f19043x.setColor(getResources().getColor(i10));
        this.f19043x.setTextAlign(Paint.Align.LEFT);
        this.f19043x.setTextSize(getResources().getDimension(p.X));
        this.f19043x.setStyle(Paint.Style.FILL);
        this.f19044y.setStrokeWidth(f10);
        this.f19044y.setStrokeCap(Paint.Cap.ROUND);
        this.f19044y.setStyle(Paint.Style.STROKE);
        this.f19044y.setColor(this.f19040u);
        this.f19045z.setStrokeCap(Paint.Cap.ROUND);
        this.f19045z.setStyle(Paint.Style.FILL);
        String valueOf = String.valueOf(24);
        this.f19043x.getTextBounds(valueOf, 0, valueOf.length(), this.f19030k);
    }

    private void d(Canvas canvas) {
        Paint paint = this.f19042w;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        this.f19042w.setPathEffect(this.f19036q);
        float f10 = this.f19022c;
        canvas.drawLine(f10, this.f19020a, f10, this.f19021b + (this.f19024e / 2.0f), this.f19042w);
        float f11 = this.f19023d;
        canvas.drawLine(f11, this.f19020a, f11, this.f19021b + (this.f19024e / 2.0f), this.f19042w);
        float length = (this.f19021b - this.f19020a) / (this.f19025f.length - 1);
        this.f19043x.setColor(getResources().getColor(i10));
        this.f19043x.setTextAlign(Paint.Align.LEFT);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f19025f.length; i12++) {
            float f12 = this.f19022c;
            float f13 = this.f19020a;
            float f14 = length * i12;
            canvas.drawLine(f12, f13 + f14, this.f19023d, f13 + f14, this.f19041v);
            canvas.drawText(String.valueOf(this.f19025f[i12]), this.f19023d + this.f19029j, this.f19020a + f14 + (this.f19030k.height() / 2), this.f19043x);
        }
        if (this.f19027h != null) {
            while (true) {
                float[] fArr = this.f19027h;
                if (i11 < fArr.length) {
                    if (i11 != 0) {
                        canvas.drawLine(fArr[i11], this.f19020a, fArr[i11], (this.f19024e / 2.0f) + this.f19021b, this.f19042w);
                    }
                    canvas.drawText(this.f19026g[i11], this.f19027h[i11] + this.f19029j, this.f19021b + this.f19028i + this.f19030k.height(), this.f19043x);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
        List<PointF> list = this.f19033n;
        if (list == null || list.size() <= 0) {
            this.f19043x.setTextAlign(Paint.Align.CENTER);
            this.f19043x.setColor(getResources().getColor(o.f26458g));
            canvas.drawText(getResources().getString(u.N2), getWidth() / 2, (this.f19021b - this.f19020a) / 2.0f, this.f19043x);
        } else {
            canvas.drawPath(this.f19031l, this.f19044y);
        }
        if (this.f19034o > 0.0f) {
            this.f19042w.setColor(this.f19040u);
            this.f19042w.setPathEffect(this.f19036q);
            float f10 = this.f19022c;
            float f11 = this.f19034o;
            canvas.drawLine(f10, f11, this.f19023d, f11, this.f19042w);
            this.f19043x.setColor(this.f19040u);
            this.f19043x.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(getResources().getString(u.S4, Float.valueOf(this.f19035p)), this.f19023d + this.f19029j, this.f19034o + (this.f19030k.height() / 2), this.f19043x);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        b();
    }

    public void setDate(b bVar) {
        this.f19039t = bVar;
        b();
        invalidate();
    }

    public TemperatureDayChartView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19025f = new int[]{38, 37, 36, 35};
        this.f19030k = new Rect();
        this.f19031l = new Path();
        this.f19032m = new SimpleDateFormat("HH:mm");
        this.f19033n = new ArrayList();
        this.f19034o = -1.0f;
        this.f19035p = -1.0f;
        this.f19036q = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f19041v = new Paint(1);
        this.f19042w = new Paint(1);
        this.f19043x = new Paint(1);
        this.f19044y = new Paint(1);
        this.f19045z = new Paint(1);
        c(context);
    }
}
