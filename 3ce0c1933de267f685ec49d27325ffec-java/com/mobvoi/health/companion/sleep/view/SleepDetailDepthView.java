package com.mobvoi.health.companion.sleep.view;

import a0.h;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.mobvoi.health.common.data.pojo.MotionType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import fg.o;
import fg.p;
import fg.r;
import java.util.ArrayList;
import java.util.List;
import yj.e;
import zj.a;
import zj.d;
/* loaded from: classes2.dex */
public class SleepDetailDepthView extends View {

    /* renamed from: a  reason: collision with root package name */
    MotionType[] f18700a;

    /* renamed from: b  reason: collision with root package name */
    SleepRecord f18701b;

    /* renamed from: c  reason: collision with root package name */
    Paint f18702c;

    /* renamed from: d  reason: collision with root package name */
    Paint f18703d;

    /* renamed from: e  reason: collision with root package name */
    Paint f18704e;

    /* renamed from: f  reason: collision with root package name */
    RectF f18705f;

    /* renamed from: g  reason: collision with root package name */
    Rect f18706g;

    /* renamed from: h  reason: collision with root package name */
    float f18707h;

    /* renamed from: i  reason: collision with root package name */
    float f18708i;

    /* renamed from: j  reason: collision with root package name */
    boolean f18709j;

    /* renamed from: k  reason: collision with root package name */
    boolean f18710k;

    /* renamed from: l  reason: collision with root package name */
    float f18711l;

    /* renamed from: m  reason: collision with root package name */
    float f18712m;

    public SleepDetailDepthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        SleepRecord sleepRecord = this.f18701b;
        if (sleepRecord == null) {
            this.f18700a = new MotionType[0];
        } else if (sleepRecord.e(SleepRecord.TimeType.Rem) == null) {
            this.f18700a = new MotionType[]{MotionType.Awake, MotionType.LightSleep, MotionType.DeepSleep};
        } else {
            this.f18700a = new MotionType[]{MotionType.Awake, MotionType.Rem, MotionType.LightSleep, MotionType.DeepSleep};
        }
    }

    private void b() {
        this.f18711l = getWidth();
        this.f18712m = getHeight();
    }

    private int c(MotionType motionType) {
        return getContext().getResources().getDimensionPixelSize(p.f26520m0);
    }

    private void d() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.f26540w0);
        Paint paint = new Paint(1);
        this.f18702c = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f18703d = paint2;
        paint2.setColor(getResources().getColor(o.f26460h));
        this.f18703d.setTypeface(h.h(getContext(), r.f26644a));
        this.f18703d.setStrokeWidth(2.0f);
        this.f18703d.setTextSize(dimensionPixelSize);
        this.f18703d.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.f18704e = paint3;
        paint3.setColor(getResources().getColor(17170443));
        this.f18704e.setStrokeWidth(2.0f);
        this.f18704e.setTextSize((dimensionPixelSize * 3) / 4);
        this.f18704e.setTextAlign(Paint.Align.CENTER);
        this.f18702c.setStyle(Paint.Style.FILL);
        this.f18705f = new RectF();
        this.f18706g = new Rect();
        this.f18707h = getResources().getDimension(p.f26518l0);
    }

    private List<e> e(List<e> list) {
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

    private void f(Canvas canvas) {
        int length = this.f18700a.length;
        int color = getResources().getColor(17170443);
        float f10 = 2.0f;
        float height = (getHeight() - ((this.f18708i * 2.0f) + (this.f18707h * 2.0f))) - getContext().getResources().getDimensionPixelSize(p.f26520m0);
        int width = getWidth();
        StringBuilder sb2 = new StringBuilder();
        for (MotionType motionType : this.f18700a) {
            sb2.append(d.e(getContext(), motionType));
        }
        String sb3 = sb2.toString();
        this.f18704e.getTextBounds(sb3, 0, sb3.length(), this.f18706g);
        int i10 = 10;
        int width2 = this.f18706g.width();
        int i11 = (int) this.f18707h;
        int i12 = width2 + ((20 + i11) * length);
        int i13 = i12 > width ? 0 : (width - i12) / (length + 1);
        int i14 = 0;
        int i15 = 0;
        while (i14 < length) {
            this.f18704e.setColor(a.b(getContext(), this.f18700a[i14]));
            int i16 = i14 + 1;
            float f11 = (i16 * i13) + i15 + (((i14 * 2) + 1) * i10) + (i14 * i11);
            float f12 = height / f10;
            float f13 = i10;
            canvas.drawCircle(f11, f12, f13, this.f18704e);
            this.f18704e.setColor(color);
            String e10 = d.e(getContext(), this.f18700a[i14]);
            length = length;
            this.f18704e.getTextBounds(e10, 0, e10.length(), this.f18706g);
            int width3 = this.f18706g.width();
            canvas.drawText(e10, f11 + f13 + i11 + (width3 / 2), f12 + (this.f18706g.height() / 2), this.f18704e);
            i15 += width3;
            i14 = i16;
            f10 = 2.0f;
            i10 = 10;
        }
    }

    private void g(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int i10 = (int) this.f18707h;
        String charSequence = d.a(getContext(), this.f18701b.f20740d).toString();
        String charSequence2 = d.a(getContext(), this.f18701b.f20741e).toString();
        this.f18703d.getTextBounds(charSequence2, 0, charSequence2.length(), this.f18706g);
        int width2 = this.f18706g.width() + i10;
        this.f18703d.getTextBounds(charSequence, 0, charSequence.length(), this.f18706g);
        int width3 = this.f18706g.width() + i10;
        int height2 = this.f18706g.height();
        this.f18708i = height2;
        Paint.FontMetrics fontMetrics = this.f18703d.getFontMetrics();
        float f10 = fontMetrics.top;
        float f11 = fontMetrics.bottom;
        float f12 = height - (height2 * 2);
        float f13 = height;
        this.f18705f.set(0.0f, f12, width3, f13);
        float f14 = f10 / 2.0f;
        float f15 = f11 / 2.0f;
        canvas.drawText(charSequence, this.f18705f.centerX(), (int) ((this.f18705f.centerY() - f14) - f15), this.f18703d);
        this.f18705f.set(width - width2, f12, width, f13);
        canvas.drawText(charSequence2, this.f18705f.centerX(), (int) ((this.f18705f.centerY() - f14) - f15), this.f18703d);
    }

    public void h(SleepRecord sleepRecord, boolean z10, boolean z11) {
        this.f18701b = sleepRecord;
        a();
        b();
        this.f18709j = z10;
        this.f18710k = z11;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        SleepRecord sleepRecord = this.f18701b;
        if (sleepRecord != null) {
            List<e> e10 = e(sleepRecord.a());
            SleepRecord sleepRecord2 = this.f18701b;
            long j10 = sleepRecord2.f20740d;
            long j11 = sleepRecord2.f20741e - j10;
            g(canvas);
            if (e10 != null && e10.size() != 0) {
                float f10 = (this.f18708i * 2.0f) + (this.f18707h * 2.0f);
                int size = e10.size();
                float f11 = this.f18707h * (size - 1);
                for (int i10 = 0; i10 < size; i10++) {
                    e eVar = e10.get(i10);
                    this.f18702c.setColor(a.b(getContext(), eVar.depth));
                    if (this.f18710k) {
                        this.f18702c.setAlpha(125);
                    }
                    float f12 = this.f18711l;
                    float f13 = ((float) (eVar.fromTime - j10)) * (f12 - f11);
                    float f14 = (float) j11;
                    float f15 = i10;
                    float f16 = this.f18707h;
                    int i11 = (int) ((f13 / f14) + (f15 * f16));
                    j11 = j11;
                    int i12 = (int) (((((float) (eVar.toTime - j10)) * (f12 - f11)) / f14) + (f15 * f16));
                    if (i11 == i12) {
                        i12++;
                    }
                    this.f18705f.set(i11, (this.f18712m - f10) - c(eVar.depth), i12, this.f18712m - f10);
                    canvas.drawRoundRect(this.f18705f, 0.0f, 0.0f, this.f18702c);
                }
            } else {
                return;
            }
        }
        if (this.f18709j) {
            f(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        b();
    }

    public void setSleepRecord(SleepRecord sleepRecord) {
        h(sleepRecord, false, false);
    }

    public SleepDetailDepthView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18700a = new MotionType[0];
        this.f18710k = false;
        d();
    }
}
