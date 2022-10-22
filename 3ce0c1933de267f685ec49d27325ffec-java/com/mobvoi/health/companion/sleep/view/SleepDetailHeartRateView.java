package com.mobvoi.health.companion.sleep.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
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
import com.mobvoi.android.common.utils.k;
import java.util.ArrayList;
import java.util.List;
import wj.b;
import wj.d;
import wj.e;
import xf.h;
/* loaded from: classes2.dex */
public class SleepDetailHeartRateView extends View {
    private a A;

    /* renamed from: a  reason: collision with root package name */
    private boolean f18713a;

    /* renamed from: b  reason: collision with root package name */
    List<? extends h> f18714b;

    /* renamed from: c  reason: collision with root package name */
    long f18715c;

    /* renamed from: d  reason: collision with root package name */
    long f18716d;

    /* renamed from: e  reason: collision with root package name */
    Paint f18717e;

    /* renamed from: f  reason: collision with root package name */
    Paint f18718f;

    /* renamed from: g  reason: collision with root package name */
    Paint f18719g;

    /* renamed from: h  reason: collision with root package name */
    Paint f18720h;

    /* renamed from: i  reason: collision with root package name */
    Paint f18721i;

    /* renamed from: j  reason: collision with root package name */
    Paint f18722j;

    /* renamed from: k  reason: collision with root package name */
    Paint f18723k;

    /* renamed from: l  reason: collision with root package name */
    Paint f18724l;

    /* renamed from: m  reason: collision with root package name */
    Rect f18725m;

    /* renamed from: n  reason: collision with root package name */
    Path f18726n;

    /* renamed from: o  reason: collision with root package name */
    Path f18727o;

    /* renamed from: p  reason: collision with root package name */
    List<PointF> f18728p;

    /* renamed from: q  reason: collision with root package name */
    Rect f18729q;

    /* renamed from: r  reason: collision with root package name */
    int f18730r;

    /* renamed from: s  reason: collision with root package name */
    int f18731s;

    /* renamed from: t  reason: collision with root package name */
    float f18732t;

    /* renamed from: u  reason: collision with root package name */
    int f18733u;

    /* renamed from: v  reason: collision with root package name */
    int f18734v;

    /* renamed from: w  reason: collision with root package name */
    PointF f18735w;

    /* renamed from: x  reason: collision with root package name */
    PointF f18736x;

    /* renamed from: y  reason: collision with root package name */
    PointF f18737y;

    /* renamed from: z  reason: collision with root package name */
    PointF f18738z;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i10, int i11);
    }

    public SleepDetailHeartRateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        float f10;
        if (!this.f18713a) {
            long j10 = this.f18716d - this.f18715c;
            this.f18728p.clear();
            int size = this.f18714b.size();
            int height = getHeight();
            int width = getWidth();
            long j11 = this.f18715c;
            float f11 = 200.0f;
            float b10 = b(height);
            float f12 = height - (this.f18732t * 2.0f);
            float f13 = 0.0f;
            for (int i10 = 0; i10 < size; i10++) {
                h hVar = this.f18714b.get(i10);
                b10 = b10;
                long j12 = hVar.f36542a - j11;
                j11 = j11;
                PointF pointF = new PointF((float) ((j12 * width) / j10), f12 - ((hVar.f36543b * f12) / 180.0f));
                float f14 = hVar.f36543b;
                if (f14 > f13) {
                    this.f18733u = i10;
                    this.f18730r = (int) f14;
                    this.f18735w = pointF;
                    f13 = f14;
                }
                if (f14 < f11) {
                    this.f18734v = i10;
                    this.f18731s = (int) f14;
                    this.f18737y = pointF;
                    f11 = f14;
                }
                this.f18728p.add(pointF);
                k.c("HeartRateView", "pointFs size is %d, heart rate time is %d, heart rate value is %f", Integer.valueOf(this.f18728p.size()), Long.valueOf(hVar.f36542a), Float.valueOf(hVar.f36543b));
            }
            float f15 = b10;
            if (this.f18737y == null) {
                f10 = 0.0f;
                this.f18737y = new PointF(0.0f, 0.0f);
            } else {
                f10 = 0.0f;
            }
            if (this.f18735w == null) {
                this.f18735w = new PointF(f10, f10);
            }
            a aVar = this.A;
            if (aVar != null) {
                aVar.a(this.f18731s, this.f18730r);
            }
            d();
            this.f18726n.reset();
            if (size > 1) {
                PointF pointF2 = null;
                int i11 = 0;
                while (i11 < size) {
                    PointF pointF3 = this.f18728p.get(i11);
                    if (i11 == 0) {
                        this.f18726n.moveTo(pointF3.x, pointF3.y);
                    } else {
                        float f16 = pointF2.x;
                        float f17 = pointF3.x;
                        float f18 = (f16 + f17) / 2.0f;
                        float f19 = pointF2.y;
                        float f20 = pointF3.y;
                        float f21 = (f19 + f20) / 2.0f;
                        if (i11 == 1) {
                            this.f18726n.lineTo(f18, f21);
                        } else if (i11 == this.f18733u || i11 == this.f18734v) {
                            this.f18726n.lineTo(f17, f20);
                        } else {
                            this.f18726n.quadTo(f16, f19, f18, f21);
                        }
                    }
                    i11++;
                    pointF2 = pointF3;
                }
                this.f18726n.lineTo(pointF2.x, pointF2.y);
            }
            this.f18727o.reset();
            this.f18727o.addPath(this.f18726n);
            this.f18727o.lineTo(this.f18728p.get(size - 1).x, f15);
            this.f18727o.lineTo(this.f18728p.get(0).x, f15);
            this.f18727o.close();
        }
    }

    private float b(int i10) {
        return i10;
    }

    private void c() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(b.f36270d);
        this.f18717e = new Paint(1);
        this.f18721i = new Paint(1);
        this.f18723k = new Paint(1);
        this.f18721i.setColor(getResources().getColor(17170443));
        this.f18721i.setStrokeWidth(2.0f);
        float f10 = dimensionPixelSize;
        this.f18721i.setTextSize(f10);
        this.f18721i.setAlpha(128);
        this.f18721i.setTextAlign(Paint.Align.CENTER);
        this.f18724l.setColor(getResources().getColor(17170443));
        this.f18724l.setStrokeWidth(1.0f);
        this.f18724l.setAlpha(60);
        Paint paint = new Paint(1);
        this.f18722j = paint;
        paint.setColor(getResources().getColor(17170443));
        this.f18722j.setTextSize(f10);
        this.f18722j.setTextAlign(Paint.Align.CENTER);
        this.f18723k.setStrokeWidth(2.0f);
        this.f18723k.setColor(getResources().getColor(wj.a.f36262i));
        this.f18723k.setStyle(Paint.Style.STROKE);
        this.f18723k.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
        this.f18718f = new Paint(1);
        Paint paint2 = new Paint(1);
        this.f18719g = paint2;
        paint2.setColor(getResources().getColor(17170443));
        this.f18719g.setTextSize(f10);
        this.f18719g.setTextAlign(Paint.Align.RIGHT);
        Paint paint3 = new Paint(1);
        this.f18720h = paint3;
        paint3.setColor(getResources().getColor(17170443));
        this.f18720h.setTextSize(f10);
        this.f18720h.setAlpha(80);
        this.f18720h.setTextAlign(Paint.Align.RIGHT);
        this.f18718f.setStyle(Paint.Style.FILL);
        this.f18718f.setColor(-1);
        this.f18717e.setColor(Color.parseColor("#FF5252"));
        this.f18717e.setStrokeWidth(5.0f);
        this.f18717e.setStyle(Paint.Style.STROKE);
        new RectF();
        Rect rect = new Rect();
        this.f18725m = rect;
        this.f18721i.getTextBounds("0", 0, 1, rect);
        this.f18732t = this.f18725m.height();
        this.f18725m.height();
        getResources().getDimension(b.f36269c);
    }

    private void d() {
        PointF pointF = this.f18735w;
        this.f18736x = new PointF(pointF.x, pointF.y);
        PointF pointF2 = this.f18737y;
        PointF pointF3 = new PointF(pointF2.x, pointF2.y);
        this.f18738z = pointF3;
        if (this.f18736x.equals(pointF3)) {
            this.f18736x = this.f18738z;
        }
        int width = getWidth();
        String valueOf = String.valueOf(this.f18731s);
        this.f18722j.getTextBounds(valueOf, 0, valueOf.length(), this.f18729q);
        int width2 = this.f18729q.width();
        int height = this.f18729q.height();
        PointF pointF4 = this.f18738z;
        float f10 = pointF4.x;
        int i10 = width2 / 2;
        float f11 = i10;
        if (f10 < f11) {
            pointF4.x = f11;
        } else {
            float f12 = width - i10;
            if (f10 > f12) {
                pointF4.x = f12;
            }
        }
        String valueOf2 = String.valueOf(this.f18730r);
        this.f18722j.getTextBounds(valueOf2, 0, valueOf2.length(), this.f18729q);
        int width3 = this.f18729q.width();
        PointF pointF5 = this.f18736x;
        float f13 = pointF5.x;
        int i11 = width3 / 2;
        float f14 = i11;
        if (f13 < f14) {
            pointF5.x = f14;
        } else {
            float f15 = width - i11;
            if (f13 > f15) {
                pointF5.x = f15;
            }
        }
        int i12 = height / 2;
        if (Math.sqrt(Math.pow(i12 + i12, 2.0d) + Math.pow(i10 + i11, 2.0d)) > Math.sqrt(Math.pow(this.f18738z.x - pointF5.x, 2.0d) + Math.pow(this.f18738z.y - this.f18736x.y, 2.0d)) && !this.f18736x.equals(this.f18738z)) {
            PointF pointF6 = this.f18736x;
            float f16 = pointF6.y;
            PointF pointF7 = this.f18738z;
            float f17 = pointF7.y;
            if (f16 > f17) {
                pointF7.y = f17 - height;
            } else {
                pointF6.y = f16 - height;
            }
        }
    }

    private void e(Canvas canvas) {
        if (this.f18735w != null) {
            this.f18722j.setColor(-1);
            PointF pointF = this.f18735w;
            canvas.drawCircle(pointF.x, pointF.y, 8.0f, this.f18722j);
            this.f18722j.setColor(Color.parseColor("#FF8902"));
            PointF pointF2 = this.f18735w;
            canvas.drawCircle(pointF2.x, pointF2.y, 5.0f, this.f18722j);
        }
        this.f18722j.reset();
        if (this.f18737y != null) {
            this.f18722j.setColor(-1);
            PointF pointF3 = this.f18737y;
            canvas.drawCircle(pointF3.x, pointF3.y, 8.0f, this.f18722j);
            this.f18722j.setColor(Color.parseColor("#008BE8"));
            PointF pointF4 = this.f18737y;
            canvas.drawCircle(pointF4.x, pointF4.y, 5.0f, this.f18722j);
        }
    }

    public void f(List<? extends h> list, long j10, long j11) {
        this.f18714b = list;
        this.f18715c = j10;
        this.f18716d = j11;
        boolean z10 = list == null || list.size() == 0;
        this.f18713a = z10;
        if (!z10) {
            a();
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getWidth();
        getHeight();
        if (!this.f18713a) {
            canvas.drawPath(this.f18726n, this.f18717e);
            e(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        new LinearGradient(0.0f, 0.0f, 0.0f, b(i11), getResources().getColor(wj.a.f36260g), getResources().getColor(wj.a.f36261h), Shader.TileMode.CLAMP);
        if (!this.f18713a) {
            a();
        }
    }

    public void setSleepHeartRateCallback(a aVar) {
        this.A = aVar;
    }

    /* JADX WARN: Finally extract failed */
    public SleepDetailHeartRateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18713a = true;
        this.f18724l = new Paint(1);
        new Path();
        this.f18726n = new Path();
        this.f18727o = new Path();
        this.f18728p = new ArrayList();
        this.f18729q = new Rect();
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, e.f36291a, i10, d.f36290a);
        try {
            obtainStyledAttributes.getBoolean(e.f36292b, true);
            obtainStyledAttributes.recycle();
            c();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
