package com.mobvoi.fitness.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.fitness.core.ui.SportMapView;
import ef.z;
import eg.f;
import java.util.ArrayList;
import java.util.List;
import ue.a;
import ue.c;
/* loaded from: classes2.dex */
public class SportMapView extends View {
    private boolean C;
    private boolean D;

    /* renamed from: l  reason: collision with root package name */
    private int f17930l;

    /* renamed from: m  reason: collision with root package name */
    private int f17931m;

    /* renamed from: s  reason: collision with root package name */
    private float f17937s;

    /* renamed from: t  reason: collision with root package name */
    private float f17938t;

    /* renamed from: u  reason: collision with root package name */
    private float f17939u;

    /* renamed from: v  reason: collision with root package name */
    private float f17940v;

    /* renamed from: w  reason: collision with root package name */
    private PointF f17941w;

    /* renamed from: x  reason: collision with root package name */
    private PointF f17942x;

    /* renamed from: a  reason: collision with root package name */
    private Paint f17919a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private Paint f17920b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private Paint f17921c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f17922d = new Matrix();

    /* renamed from: e  reason: collision with root package name */
    private Path f17923e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private Path f17924f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private Path f17925g = new Path();

    /* renamed from: h  reason: collision with root package name */
    private Path f17926h = new Path();

    /* renamed from: i  reason: collision with root package name */
    private List<z> f17927i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private int f17928j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f17929k = -1;

    /* renamed from: n  reason: collision with root package name */
    private double[] f17932n = {0.0d, 0.0d};

    /* renamed from: o  reason: collision with root package name */
    private double[] f17933o = {0.0d, 0.0d};

    /* renamed from: p  reason: collision with root package name */
    private float[] f17934p = {0.0f, 0.0f};

    /* renamed from: q  reason: collision with root package name */
    private int f17935q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f17936r = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f17943y = 0;

    /* renamed from: z  reason: collision with root package name */
    private int f17944z = 15;
    private int A = 30;
    private float B = 7.0f;
    private boolean E = false;
    private int F = 0;
    private int G = 0;
    float H = 0.0f;
    float I = 0.0f;

    public SportMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(attributeSet, 0);
    }

    private void b() {
        for (int i10 = 1; i10 < this.f17927i.size(); i10++) {
            if (this.f17932n[0] > this.f17927i.get(i10).f26024b) {
                this.f17932n[0] = this.f17927i.get(i10).f26024b;
            }
            if (this.f17932n[1] > this.f17927i.get(i10).f26025c) {
                this.f17932n[1] = this.f17927i.get(i10).f26025c;
            }
            if (this.f17933o[0] < this.f17927i.get(i10).f26024b) {
                this.f17933o[0] = this.f17927i.get(i10).f26024b;
            }
            if (this.f17933o[1] < this.f17927i.get(i10).f26025c) {
                this.f17933o[1] = this.f17927i.get(i10).f26025c;
            }
        }
        double[] dArr = this.f17933o;
        double d10 = dArr[1];
        double[] dArr2 = this.f17932n;
        double d11 = d10 - dArr2[1];
        double d12 = dArr[0] - dArr2[0];
        double d13 = ((d11 / 0.800000011920929d) - d11) / 2.0d;
        double d14 = ((d12 / 0.800000011920929d) - d12) / 2.0d;
        dArr2[0] = dArr2[0] - d14;
        dArr[0] = dArr[0] + d14;
        dArr2[1] = dArr2[1] - d13;
        dArr[1] = dArr[1] + d13;
    }

    private void c() {
        this.H = (this.f17935q / 2) - (this.F / 2);
        this.I = (this.f17936r / 2) - (this.G / 2);
    }

    private void d() {
        float f10;
        this.f17925g = new Path();
        this.f17926h = new Path();
        getRang();
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i10 = 0;
        while (true) {
            f10 = 1.0f;
            if (i10 >= this.f17927i.size()) {
                break;
            }
            if (i10 > 0 && this.f17927i.get(i10).f26028f) {
                int i11 = i10 - 1;
                f11 = ((float) (this.f17927i.get(i11).f26025c - this.f17932n[1])) / this.f17934p[1];
                f12 = 1.0f - (((float) (this.f17927i.get(i11).f26024b - this.f17932n[0])) / this.f17934p[0]);
            }
            float f13 = ((float) (this.f17927i.get(i10).f26025c - this.f17932n[1])) / this.f17934p[1];
            float f14 = 1.0f - (((float) (this.f17927i.get(i10).f26024b - this.f17932n[0])) / this.f17934p[0]);
            if (i10 == 0) {
                this.f17937s = f13;
                this.f17938t = f14;
                this.f17925g.moveTo(f13, f14);
                this.f17941w = new PointF(this.f17937s, this.f17938t);
            } else if (this.f17927i.get(i10).f26028f) {
                if (f.a.d()) {
                    k.a("fit.ui.map", "SportMapView location resume=true count :" + i10);
                }
                this.f17925g.moveTo(f13, f14);
                this.f17926h.moveTo(f11, f12);
                this.f17926h.lineTo(f13, f14);
            } else {
                this.f17925g.lineTo(f13, f14);
            }
            if (i10 == this.f17927i.size() - 1) {
                this.f17939u = f13;
                this.f17940v = f14;
                this.f17942x = new PointF(this.f17939u, this.f17940v);
            }
            i10++;
        }
        float[] fArr = this.f17934p;
        if (fArr[1] != 0.0f) {
            f10 = fArr[0] / fArr[1];
        }
        setViewScale(f10);
    }

    private void e() {
        double[] dArr = this.f17933o;
        double[] dArr2 = this.f17932n;
        double d10 = this.f17927i.get(0).f26024b;
        dArr2[0] = d10;
        dArr[0] = d10;
        double[] dArr3 = this.f17933o;
        double[] dArr4 = this.f17932n;
        double d11 = this.f17927i.get(0).f26025c;
        dArr4[1] = d11;
        dArr3[1] = d11;
        b();
        d();
    }

    private void f(AttributeSet attributeSet, int i10) {
        this.f17920b.setAntiAlias(true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.f35408a, i10, 0);
            this.f17928j = obtainStyledAttributes.getColor(c.f35409b, 0);
            this.f17929k = obtainStyledAttributes.getColor(c.f35411d, -1);
            this.C = obtainStyledAttributes.getBoolean(c.f35410c, false);
            this.D = obtainStyledAttributes.getBoolean(c.f35412e, false);
            obtainStyledAttributes.recycle();
        }
        this.f17921c.setStrokeWidth(4.0f);
        this.f17921c.setStyle(Paint.Style.STROKE);
        this.f17921c.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        postInvalidate();
    }

    private void getRang() {
        float[] fArr = this.f17934p;
        double[] dArr = this.f17933o;
        double d10 = dArr[0];
        double[] dArr2 = this.f17932n;
        fArr[0] = (float) (d10 - dArr2[0]);
        fArr[1] = (float) (dArr[1] - dArr2[1]);
        if (f.a.d()) {
            k.a("fit.ui.map", "getRang latitude  min:" + this.f17932n[0] + ", max:" + this.f17933o[0] + ",rangs:" + this.f17934p[0]);
            k.a("fit.ui.map", "getRang longitude min:" + this.f17932n[1] + ", max:" + this.f17933o[1] + ",rangs:" + this.f17934p[1]);
        }
    }

    private void h(Canvas canvas, float f10, float f11) {
        this.f17920b.setStyle(Paint.Style.FILL);
        this.f17920b.setColor(this.f17930l);
        if (this.E) {
            int i10 = this.f17944z;
            int i11 = this.f17943y;
            if (i10 >= i11 && i10 < 20) {
                this.f17944z = i10 + 1;
                this.A--;
                this.B = (float) (this.B - 0.7d);
            } else if (i10 > i11 || i10 <= 15) {
                this.f17943y = i10;
            } else {
                this.f17944z = i10 - 1;
                this.A++;
                this.B = (float) (this.B + 0.7d);
            }
        }
        canvas.drawCircle(f10, f11, this.f17944z, this.f17920b);
        this.f17920b.setColor(this.f17931m);
        canvas.drawCircle(f10, f11, this.A, this.f17920b);
        this.f17920b.setStrokeWidth(this.B);
        this.f17920b.setStyle(Paint.Style.STROKE);
        this.f17920b.setColor(-1);
        canvas.drawCircle(f10, f11, 8.0f, this.f17920b);
        this.f17920b.setStyle(Paint.Style.FILL);
        this.f17920b.setColor(this.f17929k);
        canvas.drawCircle(f10, f11, 6.0f, this.f17920b);
        if (this.E) {
            postOnAnimationDelayed(new Runnable() { // from class: kf.a
                @Override // java.lang.Runnable
                public final void run() {
                    SportMapView.this.g();
                }
            }, 150L);
        }
    }

    private void i(Canvas canvas) {
        if (this.D && this.f17941w != null) {
            this.f17919a.setStyle(Paint.Style.FILL);
            this.f17919a.setColor(-1);
            PointF pointF = this.f17941w;
            canvas.drawCircle(pointF.x * this.F, pointF.y * this.G, 10.0f, this.f17919a);
            this.f17919a.setColor(getResources().getColor(a.f35382g));
            PointF pointF2 = this.f17941w;
            canvas.drawCircle(pointF2.x * this.F, pointF2.y * this.G, 5.0f, this.f17919a);
        }
        if (this.D && this.f17942x != null) {
            this.f17919a.setStyle(Paint.Style.FILL);
            this.f17919a.setColor(-1);
            PointF pointF3 = this.f17942x;
            canvas.drawCircle(pointF3.x * this.F, pointF3.y * this.G, 10.0f, this.f17919a);
            this.f17919a.setColor(getResources().getColor(a.f35381f));
            PointF pointF4 = this.f17942x;
            canvas.drawCircle(pointF4.x * this.F, pointF4.y * this.G, 5.0f, this.f17919a);
        }
    }

    private void j(Canvas canvas, float f10, float f11) {
        this.f17920b.setStyle(Paint.Style.FILL);
        this.f17920b.setColor(getResources().getColor(a.f35383h));
        canvas.drawCircle(f10, f11, 5.0f, this.f17920b);
    }

    private void setGpsColor(boolean z10) {
        Resources resources;
        int i10;
        this.f17930l = getResources().getColor(z10 ? a.f35376a : a.f35377b);
        this.f17931m = getResources().getColor(z10 ? a.f35378c : a.f35379d);
        if (z10) {
            resources = getResources();
            i10 = a.f35383h;
        } else {
            resources = getResources();
            i10 = a.f35380e;
        }
        this.f17929k = resources.getColor(i10);
    }

    private void setViewScale(float f10) {
        int i10 = this.f17935q;
        int i11 = this.f17936r;
        if (i10 > i11) {
            i10 = i11;
        }
        this.F = i10;
        this.G = i10;
        if (f10 < 1.0f) {
            this.G = (int) (i10 * f10);
        } else if (f10 > 1.0f) {
            this.F = (int) (i10 / f10);
        }
        this.f17922d.setScale(this.F, this.G);
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.f17928j);
        canvas.translate(getPaddingLeft(), getPaddingTop());
        if (this.f17927i.size() > 0) {
            this.f17920b.setStrokeWidth(4.0f);
            this.f17920b.setColor(this.f17929k);
            this.f17920b.setStyle(Paint.Style.STROKE);
            this.f17923e.set(this.f17925g);
            this.f17923e.transform(this.f17922d);
            this.f17921c.setColor(this.f17929k);
            this.f17924f.set(this.f17926h);
            this.f17924f.transform(this.f17922d);
            canvas.translate(this.H, this.I);
            canvas.drawPath(this.f17923e, this.f17920b);
            canvas.drawPath(this.f17924f, this.f17921c);
            if (this.C) {
                j(canvas, this.f17937s * this.F, this.f17938t * this.G);
            }
            i(canvas);
        } else {
            this.f17940v = 0.5f;
            this.f17939u = 0.5f;
        }
        if (this.C) {
            h(canvas, this.f17939u * this.F, this.f17940v * this.G);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f17935q = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.f17936r = measuredHeight;
        if (this.D) {
            this.f17935q -= 40;
            this.f17936r = measuredHeight - 40;
        }
        float[] fArr = this.f17934p;
        setViewScale(fArr[1] == 0.0f ? 1.0f : fArr[0] / fArr[1]);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setGpsStatus(int i10) {
        boolean z10 = false;
        setGpsColor(i10 == 3);
        if (i10 == 1) {
            z10 = true;
        }
        this.E = z10;
        invalidate();
    }

    public void setLocationData(List<z> list) {
        this.f17927i.clear();
        if (list != null) {
            this.f17927i.addAll(list);
        }
        if (this.f17927i.size() > 0) {
            e();
        }
        invalidate();
    }
}
