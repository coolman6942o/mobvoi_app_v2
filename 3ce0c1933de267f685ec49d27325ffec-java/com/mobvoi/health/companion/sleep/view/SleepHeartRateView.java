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
import com.mobvoi.sleep.data.pojo.SleepRecord;
import fg.o;
import fg.p;
import fg.r;
import java.util.ArrayList;
import java.util.List;
import wj.a;
import yj.b;
import zj.d;
/* loaded from: classes2.dex */
public class SleepHeartRateView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f18739a;

    /* renamed from: b  reason: collision with root package name */
    private float f18740b;

    /* renamed from: c  reason: collision with root package name */
    private float f18741c;

    /* renamed from: d  reason: collision with root package name */
    private float f18742d;

    /* renamed from: e  reason: collision with root package name */
    private float f18743e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f18744f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f18745g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f18746h;

    /* renamed from: i  reason: collision with root package name */
    Paint f18747i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f18748j;

    /* renamed from: k  reason: collision with root package name */
    private SleepRecord f18749k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f18750l;

    /* renamed from: m  reason: collision with root package name */
    private float f18751m;

    /* renamed from: n  reason: collision with root package name */
    private float f18752n;

    /* renamed from: o  reason: collision with root package name */
    private float f18753o;

    /* renamed from: p  reason: collision with root package name */
    private float f18754p;

    /* renamed from: q  reason: collision with root package name */
    private Path f18755q;

    /* renamed from: r  reason: collision with root package name */
    private Path f18756r;

    /* renamed from: s  reason: collision with root package name */
    private List<PointF> f18757s;

    /* renamed from: t  reason: collision with root package name */
    private PointF f18758t;

    /* renamed from: u  reason: collision with root package name */
    private PointF f18759u;

    /* renamed from: v  reason: collision with root package name */
    private int f18760v;

    /* renamed from: w  reason: collision with root package name */
    private int f18761w;

    /* renamed from: x  reason: collision with root package name */
    private LinearGradient f18762x;

    public SleepHeartRateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        float dimension = getResources().getDimension(p.f26534t0);
        float dimension2 = getResources().getDimension(p.f26528q0);
        this.f18743e = getResources().getDimension(p.f26532s0);
        this.f18739a = dimension;
        this.f18740b = getHeight() - this.f18743e;
        this.f18741c = dimension;
        this.f18742d = getWidth() - dimension2;
        this.f18755q.reset();
        this.f18756r.reset();
        this.f18757s.clear();
        SleepRecord sleepRecord = this.f18749k;
        if (sleepRecord != null) {
            int round = Math.round(sleepRecord.f20746j);
            int round2 = Math.round(this.f18749k.f20745i);
            int max = Math.max(round, this.f18748j[0]);
            int min = Math.min(round2, this.f18748j[2]);
            while (max % 10 != 0) {
                max++;
            }
            while (min % 10 != 0) {
                min--;
            }
            int[] iArr = this.f18748j;
            iArr[0] = max;
            iArr[1] = (max + min) / 2;
            iArr[2] = min;
            this.f18762x = new LinearGradient(0.0f, 0.0f, 0.0f, this.f18740b, getResources().getColor(a.f36260g), getResources().getColor(a.f36261h), Shader.TileMode.CLAMP);
            if (this.f18749k.b() != null && this.f18749k.b().size() > 0) {
                int size = this.f18749k.b().size();
                SleepRecord sleepRecord2 = this.f18749k;
                long j10 = sleepRecord2.f20740d;
                long j11 = sleepRecord2.f20741e;
                float f10 = this.f18742d - this.f18741c;
                float f11 = this.f18740b - this.f18739a;
                long j12 = j11 - j10;
                int[] iArr2 = this.f18748j;
                int i10 = iArr2[0] - iArr2[2];
                int i11 = iArr2[2];
                float f12 = 0.0f;
                float f13 = 200.0f;
                for (int i12 = 0; i12 < size; i12++) {
                    b bVar = this.f18749k.b().get(i12);
                    int round3 = Math.round(bVar.value);
                    size = size;
                    i11 = i11;
                    i10 = i10;
                    float f14 = f13;
                    PointF pointF = new PointF(this.f18741c + ((((float) (bVar.time - j10)) * f10) / ((float) j12)), this.f18740b - (((round3 - i11) * f11) / i10));
                    float f15 = round3;
                    if (f15 > f12) {
                        this.f18760v = i12;
                        this.f18758t = pointF;
                        f12 = f15;
                    }
                    if (f15 < f14) {
                        this.f18761w = i12;
                        this.f18759u = pointF;
                        f13 = f15;
                    } else {
                        f13 = f14;
                    }
                    this.f18757s.add(pointF);
                }
                int i13 = size;
                if (this.f18757s.size() > 1) {
                    PointF pointF2 = null;
                    int i14 = 0;
                    while (i14 < this.f18757s.size()) {
                        PointF pointF3 = this.f18757s.get(i14);
                        if (i14 == 0) {
                            this.f18755q.moveTo(pointF3.x, pointF3.y);
                        } else {
                            float f16 = pointF2.x;
                            float f17 = pointF3.x;
                            float f18 = (f16 + f17) / 2.0f;
                            float f19 = pointF2.y;
                            float f20 = pointF3.y;
                            float f21 = (f19 + f20) / 2.0f;
                            if (i14 == 1) {
                                this.f18755q.lineTo(f18, f21);
                            } else if (i14 == this.f18760v || i14 == this.f18761w) {
                                this.f18755q.lineTo(f17, f20);
                            } else {
                                this.f18755q.quadTo(f16, f19, f18, f21);
                            }
                        }
                        i14++;
                        pointF2 = pointF3;
                    }
                    this.f18755q.lineTo(pointF2.x, pointF2.y);
                    this.f18756r.addPath(this.f18755q);
                    this.f18756r.lineTo(this.f18757s.get(i13 - 1).x, this.f18740b);
                    this.f18756r.lineTo(this.f18757s.get(0).x, this.f18740b);
                    this.f18756r.close();
                }
            }
        }
    }

    private void b() {
        this.f18753o = getResources().getDimensionPixelSize(p.f26526p0);
        this.f18754p = getResources().getDimensionPixelSize(p.f26522n0);
        this.f18751m = getResources().getDimensionPixelSize(p.f26530r0);
        Paint paint = new Paint(1);
        this.f18744f = paint;
        paint.setColor(getResources().getColor(o.f26464j));
        this.f18744f.setTypeface(h.h(getContext(), r.f26644a));
        this.f18744f.setStrokeWidth(2.0f);
        this.f18744f.setTextSize(getResources().getDimensionPixelSize(p.f26538v0));
        Paint paint2 = new Paint(1);
        this.f18745g = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = this.f18745g;
        Resources resources = getResources();
        int i10 = o.f26480r;
        paint3.setColor(resources.getColor(i10));
        Paint paint4 = new Paint(1);
        this.f18746h = paint4;
        paint4.setColor(getResources().getColor(i10));
        this.f18746h.setStrokeWidth(getResources().getDimensionPixelSize(p.f26524o0));
        this.f18746h.setStyle(Paint.Style.STROKE);
        Paint paint5 = new Paint(1);
        this.f18747i = paint5;
        paint5.setTextAlign(Paint.Align.CENTER);
        this.f18747i.setStyle(Paint.Style.FILL);
        this.f18747i.setAntiAlias(true);
        this.f18744f.getTextBounds("100", 0, 3, this.f18750l);
        this.f18752n = this.f18750l.height();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = this.f18748j.length;
        float f10 = (this.f18740b - this.f18739a) / (length - 1);
        this.f18744f.setTextAlign(Paint.Align.LEFT);
        for (int i10 = 0; i10 < length; i10++) {
            float f11 = this.f18739a + (i10 * f10);
            canvas.drawLine(this.f18741c, f11, this.f18742d, f11, this.f18744f);
            canvas.drawText(String.valueOf(this.f18748j[i10]), this.f18742d + this.f18751m, f11 + (this.f18752n / 2.0f), this.f18744f);
        }
        if (this.f18749k != null) {
            String charSequence = d.a(getContext(), this.f18749k.f20740d).toString();
            String charSequence2 = d.a(getContext(), this.f18749k.f20741e).toString();
            canvas.drawText(charSequence, this.f18741c, this.f18740b + (this.f18751m * 2.0f) + this.f18752n, this.f18744f);
            this.f18744f.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(charSequence2, this.f18742d, this.f18740b + (this.f18751m * 2.0f) + this.f18752n, this.f18744f);
        }
        List<PointF> list = this.f18757s;
        if (list != null && list.size() > 0) {
            this.f18745g.setShader(this.f18762x);
            canvas.drawPath(this.f18756r, this.f18745g);
            canvas.drawPath(this.f18755q, this.f18746h);
        }
        if (this.f18758t != null) {
            this.f18747i.setColor(-1);
            this.f18747i.setStrokeWidth(this.f18753o);
            PointF pointF = this.f18758t;
            canvas.drawCircle(pointF.x, pointF.y, this.f18753o, this.f18747i);
            this.f18747i.setColor(Color.parseColor("#FF8902"));
            this.f18747i.setStrokeWidth(this.f18754p);
            PointF pointF2 = this.f18758t;
            canvas.drawCircle(pointF2.x, pointF2.y, this.f18754p, this.f18747i);
        }
        this.f18747i.reset();
        if (this.f18759u != null) {
            this.f18747i.setColor(-1);
            this.f18747i.setStrokeWidth(this.f18753o);
            PointF pointF3 = this.f18759u;
            canvas.drawCircle(pointF3.x, pointF3.y, this.f18753o, this.f18747i);
            this.f18747i.setColor(Color.parseColor("#008BE8"));
            this.f18747i.setStrokeWidth(this.f18754p);
            PointF pointF4 = this.f18759u;
            canvas.drawCircle(pointF4.x, pointF4.y, this.f18754p, this.f18747i);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public void setSleepRecord(SleepRecord sleepRecord) {
        this.f18749k = sleepRecord;
        a();
        invalidate();
    }

    public SleepHeartRateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18748j = new int[]{100, 80, 60};
        this.f18750l = new Rect();
        this.f18755q = new Path();
        this.f18756r = new Path();
        this.f18757s = new ArrayList();
        b();
    }
}
