package com.mobvoi.health.companion.sleep.view;

import a0.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.mobvoi.health.common.data.pojo.MotionType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import fg.n;
import fg.o;
import fg.p;
import fg.r;
import fg.u;
import fg.w;
import j7.a;
import java.util.ArrayList;
import java.util.List;
import yj.e;
import zj.d;
/* loaded from: classes2.dex */
public class SleepTypeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f18770a;

    /* renamed from: b  reason: collision with root package name */
    private float f18771b;

    /* renamed from: c  reason: collision with root package name */
    private float f18772c;

    /* renamed from: d  reason: collision with root package name */
    private float f18773d;

    /* renamed from: e  reason: collision with root package name */
    private float f18774e;

    /* renamed from: f  reason: collision with root package name */
    private float f18775f;

    /* renamed from: g  reason: collision with root package name */
    MotionType[] f18776g;

    /* renamed from: h  reason: collision with root package name */
    private float f18777h;

    /* renamed from: i  reason: collision with root package name */
    SleepRecord f18778i;

    /* renamed from: j  reason: collision with root package name */
    Paint f18779j;

    /* renamed from: k  reason: collision with root package name */
    Paint f18780k;

    /* renamed from: l  reason: collision with root package name */
    Paint f18781l;

    /* renamed from: m  reason: collision with root package name */
    RectF f18782m;

    /* renamed from: n  reason: collision with root package name */
    Rect f18783n;

    /* renamed from: o  reason: collision with root package name */
    float f18784o;

    /* renamed from: p  reason: collision with root package name */
    float f18785p;

    /* renamed from: q  reason: collision with root package name */
    float f18786q;

    /* renamed from: r  reason: collision with root package name */
    boolean f18787r;

    /* renamed from: s  reason: collision with root package name */
    boolean f18788s;

    /* renamed from: t  reason: collision with root package name */
    private int f18789t;

    /* renamed from: u  reason: collision with root package name */
    private int f18790u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f18791v;

    public SleepTypeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        SleepRecord sleepRecord = this.f18778i;
        if (sleepRecord == null) {
            this.f18776g = new MotionType[0];
        } else if (sleepRecord.e(SleepRecord.TimeType.Rem) == null) {
            this.f18776g = new MotionType[]{MotionType.Awake, MotionType.LightSleep, MotionType.DeepSleep};
        } else {
            this.f18776g = new MotionType[]{MotionType.Awake, MotionType.Rem, MotionType.LightSleep, MotionType.DeepSleep};
        }
    }

    private void b() {
        this.f18770a = this.f18775f;
        this.f18771b = getHeight() - this.f18774e;
        this.f18772c = this.f18775f;
        this.f18773d = getWidth() - this.f18775f;
        this.f18777h = (this.f18771b - this.f18770a) / 5.0f;
    }

    private void c(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.f27021k, i10, 0);
        this.f18791v = obtainStyledAttributes.getBoolean(w.f27024n, true);
        this.f18775f = obtainStyledAttributes.getDimensionPixelSize(w.f27023m, 0);
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(w.f27022l, 0);
        this.f18774e = dimensionPixelSize;
        if (dimensionPixelSize == 0.0f) {
            this.f18791v = false;
        }
        obtainStyledAttributes.recycle();
        this.f18786q = getResources().getDimension(p.f26536u0);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(p.f26538v0);
        this.f18790u = getResources().getColor(o.f26464j);
        this.f18789t = a.b(context, 16842806, -16777216);
        Paint paint = new Paint(1);
        this.f18779j = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f18780k = paint2;
        paint2.setTypeface(h.h(getContext(), r.f26644a));
        this.f18780k.setStrokeWidth(2.0f);
        this.f18780k.setTextSize(dimensionPixelSize2);
        this.f18780k.setTextAlign(Paint.Align.CENTER);
        int b10 = a.b(context, n.f26444b, -1);
        Paint paint3 = new Paint(1);
        this.f18781l = paint3;
        paint3.setColor(b10);
        this.f18781l.setStrokeWidth(2.0f);
        this.f18781l.setTextSize((dimensionPixelSize2 * 3) / 4);
        this.f18781l.setTextAlign(Paint.Align.CENTER);
        this.f18779j.setStyle(Paint.Style.FILL);
        this.f18782m = new RectF();
        this.f18783n = new Rect();
        this.f18784o = 0.0f;
    }

    private List<e> d(List<e> list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        e eVar = null;
        for (e eVar2 : list) {
            if (!eVar2.depth.isSleep()) {
                eVar2.depth = MotionType.Awake;
            }
            if (eVar != null) {
                if (eVar.depth == eVar2.depth && eVar.toTime == eVar2.fromTime) {
                    eVar.toTime = eVar2.toTime;
                    eVar.nextDepth = eVar2.nextDepth;
                } else {
                    arrayList.add(eVar);
                }
            }
            eVar = eVar2;
        }
        if (eVar != null) {
            arrayList.add(eVar);
        }
        return arrayList;
    }

    private void e(Canvas canvas) {
        int length = this.f18776g.length;
        int color = getResources().getColor(17170443);
        float f10 = 2.0f;
        float height = (getHeight() - ((this.f18785p * 2.0f) + (this.f18784o * 2.0f))) - getContext().getResources().getDimensionPixelSize(p.f26520m0);
        int width = getWidth();
        StringBuilder sb2 = new StringBuilder();
        for (MotionType motionType : this.f18776g) {
            sb2.append(d.e(getContext(), motionType));
        }
        String sb3 = sb2.toString();
        this.f18781l.getTextBounds(sb3, 0, sb3.length(), this.f18783n);
        int i10 = 10;
        int width2 = this.f18783n.width();
        int i11 = (int) this.f18784o;
        int i12 = width2 + ((20 + i11) * length);
        int i13 = i12 > width ? 0 : (width - i12) / (length + 1);
        int i14 = 0;
        int i15 = 0;
        while (i14 < length) {
            this.f18781l.setColor(zj.a.b(getContext(), this.f18776g[i14]));
            int i16 = i14 + 1;
            float f11 = (i16 * i13) + i15 + (((i14 * 2) + 1) * i10) + (i14 * i11);
            float f12 = height / f10;
            float f13 = i10;
            canvas.drawCircle(f11, f12, f13, this.f18781l);
            this.f18781l.setColor(color);
            String e10 = d.e(getContext(), this.f18776g[i14]);
            length = length;
            this.f18781l.getTextBounds(e10, 0, e10.length(), this.f18783n);
            int width3 = this.f18783n.width();
            canvas.drawText(e10, f11 + f13 + i11 + (width3 / 2), f12 + (this.f18783n.height() / 2), this.f18781l);
            i15 += width3;
            i14 = i16;
            f10 = 2.0f;
            i10 = 10;
        }
    }

    private void f(Canvas canvas) {
        if (this.f18791v) {
            this.f18780k.setAlpha(68);
            this.f18780k.setColor(this.f18789t);
            String charSequence = d.a(getContext(), this.f18778i.f20740d).toString();
            String charSequence2 = d.a(getContext(), this.f18778i.f20741e).toString();
            this.f18780k.getTextBounds(charSequence2, 0, charSequence2.length(), this.f18783n);
            this.f18785p = this.f18783n.height();
            this.f18780k.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(charSequence, this.f18772c, this.f18771b + (this.f18786q * 2.0f) + this.f18785p, this.f18780k);
            this.f18780k.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(charSequence2, this.f18773d, this.f18771b + (this.f18786q * 2.0f) + this.f18785p, this.f18780k);
        }
    }

    public void g(SleepRecord sleepRecord, boolean z10, boolean z11) {
        this.f18778i = sleepRecord;
        a();
        b();
        this.f18787r = z10;
        this.f18788s = z11;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f10;
        float f11;
        long j10;
        List<e> list;
        int i10;
        float f12;
        float f13;
        super.onDraw(canvas);
        if (this.f18791v) {
            this.f18780k.setAlpha(225);
            this.f18780k.setColor(this.f18790u);
            float f14 = this.f18772c;
            float f15 = this.f18771b;
            float f16 = this.f18786q;
            canvas.drawLine(f14, f15 + f16, this.f18773d, f15 + f16, this.f18780k);
        }
        SleepRecord sleepRecord = this.f18778i;
        int i11 = 0;
        if (sleepRecord != null) {
            List<e> d10 = d(sleepRecord.a());
            SleepRecord sleepRecord2 = this.f18778i;
            long j11 = sleepRecord2.f20740d;
            long j12 = sleepRecord2.f20741e - j11;
            f(canvas);
            if (d10 != null && d10.size() != 0) {
                int size = d10.size();
                float f17 = this.f18784o * (size - 1);
                float f18 = this.f18773d - this.f18772c;
                while (i11 < size) {
                    e eVar = d10.get(i11);
                    this.f18779j.setColor(zj.a.b(getContext(), eVar.depth));
                    if (this.f18788s) {
                        this.f18779j.setAlpha(80);
                    }
                    MotionType motionType = eVar.depth;
                    MotionType motionType2 = MotionType.Rem;
                    if (motionType == motionType2 || motionType == MotionType.LightSleep || motionType == MotionType.DeepSleep || motionType == MotionType.Awake) {
                        float f19 = this.f18772c;
                        i10 = size;
                        float f20 = f18 - f17;
                        list = d10;
                        float f21 = (float) j12;
                        j10 = j12;
                        float f22 = i11;
                        float f23 = this.f18784o;
                        float f24 = ((((float) (eVar.fromTime - j11)) * f20) / f21) + f19 + (f22 * f23);
                        f11 = f17;
                        f10 = f18;
                        float f25 = f19 + ((((float) (eVar.toTime - j11)) * f20) / f21) + (f22 * f23);
                        if (f24 == f25) {
                            f25 += 1.0f;
                        }
                        if (motionType == motionType2) {
                            float f26 = this.f18770a;
                            float f27 = this.f18777h;
                            f12 = f26 + f27;
                            f13 = f26 + (f27 * 2.0f);
                        } else if (motionType == MotionType.LightSleep) {
                            float f28 = this.f18770a;
                            float f29 = this.f18777h;
                            f12 = f28 + (f29 * 2.0f);
                            f13 = f28 + (f29 * 3.0f);
                        } else if (motionType == MotionType.DeepSleep) {
                            f12 = (this.f18777h * 3.0f) + this.f18770a;
                            f13 = this.f18771b;
                        } else {
                            f12 = this.f18770a;
                            f13 = this.f18777h + f12;
                        }
                        this.f18782m.set(f24, f12, f25, f13);
                        canvas.drawRoundRect(this.f18782m, 0.0f, 0.0f, this.f18779j);
                    } else {
                        list = d10;
                        i10 = size;
                        j10 = j12;
                        f11 = f17;
                        f10 = f18;
                    }
                    i11++;
                    size = i10;
                    d10 = list;
                    j12 = j10;
                    f17 = f11;
                    f18 = f10;
                }
            } else {
                return;
            }
        } else if (this.f18791v) {
            this.f18780k.setAlpha(135);
            this.f18780k.setColor(this.f18789t);
            this.f18780k.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getResources().getString(u.N2), (this.f18773d + this.f18772c) / 2.0f, (this.f18771b - this.f18770a) / 2.0f, this.f18780k);
            this.f18780k.getTextBounds("00:00", 0, 5, this.f18783n);
            this.f18785p = this.f18783n.height();
            this.f18780k.setAlpha(68);
            this.f18780k.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("00:00", this.f18772c, this.f18771b + (this.f18786q * 2.0f) + this.f18785p, this.f18780k);
            this.f18780k.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("00:00", this.f18773d, this.f18771b + (this.f18786q * 2.0f) + this.f18785p, this.f18780k);
        }
        if (this.f18787r) {
            e(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        b();
    }

    public void setSleepRecord(SleepRecord sleepRecord) {
        g(sleepRecord, false, false);
    }

    public SleepTypeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18776g = new MotionType[0];
        this.f18788s = false;
        this.f18791v = true;
        c(context, attributeSet, i10);
    }
}
