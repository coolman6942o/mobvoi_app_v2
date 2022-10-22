package com.mobvoi.health.companion.sleep.view;

import a0.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import fg.o;
import fg.p;
import fg.r;
import fg.u;
import java.util.ArrayList;
import java.util.List;
import wj.a;
import yj.d;
/* loaded from: classes2.dex */
public class SleepDetailBloodOxygenView extends View {
    private LinearGradient A;

    /* renamed from: a  reason: collision with root package name */
    private float f18674a;

    /* renamed from: b  reason: collision with root package name */
    private float f18675b;

    /* renamed from: c  reason: collision with root package name */
    private float f18676c;

    /* renamed from: d  reason: collision with root package name */
    private float f18677d;

    /* renamed from: e  reason: collision with root package name */
    private float f18678e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f18679f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f18680g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f18681h;

    /* renamed from: i  reason: collision with root package name */
    Paint f18682i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f18683j;

    /* renamed from: k  reason: collision with root package name */
    private d f18684k;

    /* renamed from: l  reason: collision with root package name */
    private long f18685l;

    /* renamed from: m  reason: collision with root package name */
    private long f18686m;

    /* renamed from: n  reason: collision with root package name */
    private String f18687n;

    /* renamed from: o  reason: collision with root package name */
    private Rect f18688o;

    /* renamed from: p  reason: collision with root package name */
    private float f18689p;

    /* renamed from: q  reason: collision with root package name */
    private float f18690q;

    /* renamed from: r  reason: collision with root package name */
    private float f18691r;

    /* renamed from: s  reason: collision with root package name */
    private float f18692s;

    /* renamed from: t  reason: collision with root package name */
    private Path f18693t;

    /* renamed from: u  reason: collision with root package name */
    private Path f18694u;

    /* renamed from: v  reason: collision with root package name */
    private List<PointF> f18695v;

    /* renamed from: w  reason: collision with root package name */
    private PointF f18696w;

    /* renamed from: x  reason: collision with root package name */
    private PointF f18697x;

    /* renamed from: y  reason: collision with root package name */
    private int f18698y;

    /* renamed from: z  reason: collision with root package name */
    private int f18699z;

    public SleepDetailBloodOxygenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        float dimension = getResources().getDimension(p.f26534t0);
        float dimension2 = getResources().getDimension(p.f26528q0);
        this.f18678e = getResources().getDimension(p.f26532s0);
        this.f18674a = dimension;
        this.f18675b = getHeight() - this.f18678e;
        this.f18676c = dimension;
        this.f18677d = getWidth() - dimension2;
        this.f18693t.reset();
        this.f18694u.reset();
        this.f18695v.clear();
        d dVar = this.f18684k;
        if (dVar != null) {
            int i10 = dVar.min;
            if (i10 < this.f18683j[2]) {
                while (i10 % 5 != 0) {
                    i10--;
                }
            }
            int[] iArr = this.f18683j;
            iArr[0] = 100;
            iArr[1] = (100 + i10) / 2;
            iArr[2] = i10;
            this.A = new LinearGradient(0.0f, 0.0f, 0.0f, this.f18675b, getResources().getColor(a.f36260g), getResources().getColor(a.f36261h), Shader.TileMode.CLAMP);
            List<yj.a> list = this.f18684k.oxygen;
            if (list != null && list.size() > 0) {
                int size = this.f18684k.oxygen.size();
                float f10 = this.f18677d - this.f18676c;
                float f11 = this.f18675b - this.f18674a;
                long j10 = this.f18686m - this.f18685l;
                int[] iArr2 = this.f18683j;
                int i11 = iArr2[0] - iArr2[2];
                int i12 = iArr2[2];
                float f12 = 0.0f;
                float f13 = 200.0f;
                int i13 = 0;
                while (i13 < size) {
                    yj.a aVar = this.f18684k.oxygen.get(i13);
                    int i14 = aVar.percent;
                    float f14 = this.f18676c;
                    long j11 = j10;
                    long j12 = aVar.time;
                    float f15 = f13;
                    int i15 = i13;
                    f10 = f10;
                    PointF pointF = new PointF(f14 + ((((float) (j12 - this.f18685l)) * f10) / ((float) j11)), this.f18675b - (((i14 - i12) * f11) / i11));
                    float f16 = i14;
                    if (f16 > f12) {
                        this.f18698y = i15;
                        this.f18696w = pointF;
                        f12 = f16;
                    }
                    if (f16 < f15) {
                        this.f18699z = i15;
                        this.f18697x = pointF;
                    } else {
                        f16 = f15;
                    }
                    this.f18695v.add(pointF);
                    i13 = i15 + 1;
                    j10 = j11;
                    f13 = f16;
                }
                if (this.f18695v.size() > 1) {
                    PointF pointF2 = null;
                    int i16 = 0;
                    while (i16 < this.f18695v.size()) {
                        PointF pointF3 = this.f18695v.get(i16);
                        if (i16 == 0) {
                            this.f18693t.moveTo(pointF3.x, pointF3.y);
                        } else {
                            float f17 = pointF2.x;
                            float f18 = pointF3.x;
                            float f19 = (f17 + f18) / 2.0f;
                            float f20 = pointF2.y;
                            float f21 = pointF3.y;
                            float f22 = (f20 + f21) / 2.0f;
                            if (i16 == 1) {
                                this.f18693t.lineTo(f19, f22);
                            } else if (i16 == this.f18698y || i16 == this.f18699z) {
                                this.f18693t.lineTo(f18, f21);
                            } else {
                                this.f18693t.quadTo(f17, f20, f19, f22);
                            }
                        }
                        i16++;
                        pointF2 = pointF3;
                    }
                    this.f18693t.lineTo(pointF2.x, pointF2.y);
                    this.f18694u.addPath(this.f18693t);
                    this.f18694u.lineTo(this.f18695v.get(size - 1).x, this.f18675b);
                    this.f18694u.lineTo(this.f18695v.get(0).x, this.f18675b);
                    this.f18694u.close();
                }
            }
        }
    }

    private void b() {
        this.f18691r = getResources().getDimensionPixelSize(p.f26526p0);
        this.f18692s = getResources().getDimensionPixelSize(p.f26522n0);
        this.f18689p = getResources().getDimensionPixelSize(p.f26530r0);
        this.f18687n = getResources().getString(u.f26877d4);
        Paint paint = new Paint(1);
        this.f18679f = paint;
        paint.setColor(getResources().getColor(o.f26464j));
        this.f18679f.setTypeface(h.h(getContext(), r.f26644a));
        this.f18679f.setStrokeWidth(2.0f);
        this.f18679f.setTextSize(getResources().getDimensionPixelSize(p.f26538v0));
        Paint paint2 = new Paint(1);
        this.f18680g = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = this.f18680g;
        Resources resources = getResources();
        int i10 = o.f26480r;
        paint3.setColor(resources.getColor(i10));
        Paint paint4 = new Paint(1);
        this.f18681h = paint4;
        paint4.setColor(getResources().getColor(i10));
        this.f18681h.setStrokeWidth(getResources().getDimensionPixelSize(p.f26524o0));
        this.f18681h.setStyle(Paint.Style.STROKE);
        Paint paint5 = new Paint(1);
        this.f18682i = paint5;
        paint5.setTextAlign(Paint.Align.CENTER);
        this.f18682i.setStyle(Paint.Style.FILL);
        this.f18682i.setAntiAlias(true);
        String valueOf = String.valueOf(this.f18687n);
        this.f18679f.getTextBounds(valueOf, 0, valueOf.length(), this.f18688o);
        this.f18690q = this.f18688o.height();
    }

    public void c(d dVar, long j10, long j11) {
        this.f18684k = dVar;
        this.f18685l = j10;
        this.f18686m = j11;
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = this.f18683j.length;
        float f10 = (this.f18675b - this.f18674a) / (length - 1);
        this.f18679f.setTextAlign(Paint.Align.LEFT);
        for (int i10 = 0; i10 < length; i10++) {
            float f11 = this.f18674a + (i10 * f10);
            canvas.drawLine(this.f18676c, f11, this.f18677d, f11, this.f18679f);
            canvas.drawText(this.f18683j[i10] + this.f18687n, this.f18677d + this.f18689p, f11 + (this.f18690q / 2.0f), this.f18679f);
        }
        if (this.f18684k != null) {
            String charSequence = zj.d.a(getContext(), this.f18685l).toString();
            String charSequence2 = zj.d.a(getContext(), this.f18686m).toString();
            canvas.drawText(charSequence, this.f18676c, this.f18675b + (this.f18689p * 2.0f) + this.f18690q, this.f18679f);
            this.f18679f.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(charSequence2, this.f18677d, this.f18675b + (this.f18689p * 2.0f) + this.f18690q, this.f18679f);
        }
        List<PointF> list = this.f18695v;
        if (list != null && list.size() > 0) {
            this.f18680g.setShader(this.A);
            canvas.drawPath(this.f18694u, this.f18680g);
            canvas.drawPath(this.f18693t, this.f18681h);
        }
        if (this.f18696w != null) {
            this.f18682i.setColor(-1);
            this.f18682i.setStrokeWidth(this.f18691r);
            PointF pointF = this.f18696w;
            canvas.drawCircle(pointF.x, pointF.y, this.f18691r, this.f18682i);
            this.f18682i.setColor(Color.parseColor("#FF8902"));
            this.f18682i.setStrokeWidth(this.f18692s);
            PointF pointF2 = this.f18696w;
            canvas.drawCircle(pointF2.x, pointF2.y, this.f18692s, this.f18682i);
        }
        this.f18682i.reset();
        if (this.f18697x != null) {
            this.f18682i.setColor(-1);
            this.f18682i.setStrokeWidth(this.f18691r);
            PointF pointF3 = this.f18697x;
            canvas.drawCircle(pointF3.x, pointF3.y, this.f18691r, this.f18682i);
            this.f18682i.setColor(Color.parseColor("#008BE8"));
            this.f18682i.setStrokeWidth(this.f18692s);
            PointF pointF4 = this.f18697x;
            canvas.drawCircle(pointF4.x, pointF4.y, this.f18692s, this.f18682i);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public SleepDetailBloodOxygenView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18683j = new int[]{100, 95, 90};
        this.f18688o = new Rect();
        this.f18693t = new Path();
        this.f18694u = new Path();
        this.f18695v = new ArrayList();
        b();
    }
}
