package com.mobvoi.health.companion.sleep;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import fg.o;
import fg.p;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import yj.d;
/* loaded from: classes2.dex */
public class SleepBloodOxygenView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f18486a;

    /* renamed from: b  reason: collision with root package name */
    private float f18487b;

    /* renamed from: c  reason: collision with root package name */
    private float f18488c;

    /* renamed from: d  reason: collision with root package name */
    private float f18489d;

    /* renamed from: e  reason: collision with root package name */
    private float f18490e;

    /* renamed from: f  reason: collision with root package name */
    private float f18491f;

    /* renamed from: g  reason: collision with root package name */
    private float f18492g;

    /* renamed from: h  reason: collision with root package name */
    private float f18493h;

    /* renamed from: i  reason: collision with root package name */
    private float f18494i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f18495j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f18496k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f18497l;

    /* renamed from: m  reason: collision with root package name */
    private d f18498m;

    /* renamed from: n  reason: collision with root package name */
    private List<a> f18499n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public float f18500a;

        /* renamed from: b  reason: collision with root package name */
        public float f18501b;

        public a(float f10, float f11) {
            this.f18500a = f10;
            this.f18501b = f11;
        }
    }

    public SleepBloodOxygenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        List<yj.a> list;
        float dimension = getResources().getDimension(p.f26535u);
        getResources().getDimension(p.f26496a0);
        this.f18486a = dimension;
        this.f18487b = getHeight() - this.f18492g;
        this.f18488c = dimension;
        this.f18489d = getWidth() - this.f18491f;
        this.f18499n.clear();
        d dVar = this.f18498m;
        if (!(dVar == null || (list = dVar.oxygen) == null || list.size() <= 0)) {
            d dVar2 = this.f18498m;
            long j10 = dVar2.startTime;
            long j11 = dVar2.endTime;
            for (yj.a aVar : dVar2.oxygen) {
                int i10 = aVar.percent;
                if (i10 >= 90) {
                    float f10 = this.f18488c;
                    float f11 = this.f18487b;
                    this.f18499n.add(new a(f10 + (((this.f18489d - f10) * ((float) (aVar.time - j10))) / ((float) (j11 - j10))), f11 - (((f11 - this.f18486a) * (i10 - 90)) / 10.0f)));
                }
            }
        }
    }

    private void c() {
        this.f18497l.setStyle(Paint.Style.FILL);
        this.f18497l.setColor(getResources().getColor(o.f26485t0));
        this.f18496k.setTextAlign(Paint.Align.CENTER);
        this.f18496k.setColor(getResources().getColor(o.f26464j));
        this.f18496k.setStyle(Paint.Style.STROKE);
        this.f18496k.setStrokeWidth(getResources().getDimension(p.f26506f0));
        this.f18496k.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        this.f18495j.setTextSize(getResources().getDimension(p.f26508g0));
        this.f18495j.setStyle(Paint.Style.FILL);
        this.f18495j.setColor(getResources().getColor(o.f26460h));
        this.f18495j.setAlpha(128);
        this.f18490e = getResources().getDimension(p.f26512i0);
        this.f18491f = getResources().getDimension(p.f26514j0);
        this.f18492g = getResources().getDimension(p.f26510h0);
        this.f18493h = getResources().getDimension(p.f26516k0);
        Rect rect = new Rect();
        this.f18495j.getTextBounds("100%", 0, 4, rect);
        this.f18494i = rect.height();
    }

    public CharSequence a(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return DateFormat.format("HH:mm", calendar);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d dVar = this.f18498m;
        if (dVar != null) {
            String charSequence = a(dVar.startTime).toString();
            String charSequence2 = a(this.f18498m.endTime).toString();
            this.f18495j.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(charSequence2, this.f18489d, this.f18487b + this.f18493h + this.f18494i, this.f18495j);
            this.f18495j.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(charSequence, this.f18488c, this.f18487b + this.f18493h + this.f18494i, this.f18495j);
        }
        this.f18495j.setTextAlign(Paint.Align.LEFT);
        float f10 = (this.f18487b - this.f18486a) / 2.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            float f11 = this.f18488c;
            float f12 = this.f18486a;
            float f13 = i10 * f10;
            canvas.drawLine(f11, f12 + f13, this.f18489d, f12 + f13, this.f18496k);
            canvas.drawText((100 - (5 * i10)) + "%", this.f18489d + (this.f18490e * 2.0f), this.f18486a + f13 + (this.f18494i / 2.0f), this.f18495j);
        }
        List<a> list = this.f18499n;
        if (list != null && list.size() > 0) {
            for (a aVar : this.f18499n) {
                canvas.drawCircle(aVar.f18500a, aVar.f18501b, this.f18490e, this.f18497l);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        b();
    }

    public void setSleepBloodOxygen(d dVar) {
        this.f18498m = dVar;
        b();
        invalidate();
    }

    public SleepBloodOxygenView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18495j = new Paint(1);
        this.f18496k = new Paint(1);
        this.f18497l = new Paint(1);
        this.f18499n = new ArrayList();
        c();
    }
}
