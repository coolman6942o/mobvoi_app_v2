package com.mobvoi.mcuwatch.recommendation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.internal.i;
import sh.d;
import sh.e;
/* compiled from: SportTimeOfWeekChartView.kt */
/* loaded from: classes2.dex */
public final class SportTimeOfWeekChartView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final int f19260a = 340;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f19261b = {300, 150, 50};

    /* renamed from: c  reason: collision with root package name */
    private final String[] f19262c = {"OPTIMAL", "BASELINE", "MINIMUM"};

    /* renamed from: d  reason: collision with root package name */
    private final String[] f19263d = {"S", "M", "T", "W", "T", "F", "S"};

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Integer> f19264e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f19265f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Integer> f19266g;

    /* renamed from: h  reason: collision with root package name */
    private final float f19267h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Float> f19268i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f19269j;

    /* renamed from: k  reason: collision with root package name */
    private final float f19270k;

    /* renamed from: l  reason: collision with root package name */
    private final float f19271l;

    /* renamed from: m  reason: collision with root package name */
    private final Paint f19272m;

    /* renamed from: n  reason: collision with root package name */
    private final DashPathEffect f19273n;

    /* renamed from: o  reason: collision with root package name */
    private final Paint f19274o;

    /* renamed from: p  reason: collision with root package name */
    private float f19275p;

    /* renamed from: q  reason: collision with root package name */
    private final float f19276q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportTimeOfWeekChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ArrayList<Integer> c10;
        List<Integer> j10;
        int p10;
        i.f(context, "context");
        c10 = m.c(0, 0, 0, 0, 0, 0, 0);
        this.f19264e = c10;
        this.f19265f = new int[]{b.c(context, d.f34457q), b.c(context, d.f34456p), b.c(context, d.f34463w), b.c(context, d.f34458r)};
        j10 = m.j(Integer.valueOf(aa.d.b(43.0f, context)), Integer.valueOf(aa.d.b(80.0f, context)), Integer.valueOf(aa.d.b(54.0f, context)), Integer.valueOf(aa.d.b(54.0f, context)));
        this.f19266g = j10;
        this.f19267h = aa.d.b(7.0f, context);
        p10 = n.p(j10, 10);
        ArrayList arrayList = new ArrayList(p10);
        for (Number number : j10) {
            arrayList.add(Float.valueOf(number.intValue() + this.f19267h));
        }
        this.f19268i = arrayList;
        Paint paint = new Paint(1);
        paint.setFakeBoldText(true);
        io.m mVar = io.m.f28349a;
        this.f19269j = paint;
        float d10 = aa.d.d(14.0f, context);
        this.f19270k = d10;
        this.f19271l = aa.d.d(10.0f, context);
        Paint paint2 = new Paint(1);
        this.f19272m = paint2;
        this.f19273n = new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f);
        this.f19274o = new Paint(1);
        paint.setTextSize(d10);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.f19275p = fontMetrics.descent - fontMetrics.ascent;
        this.f19276q = getResources().getDimension(e.T0);
        paint2.setStrokeWidth(getResources().getDimension(e.f34507o0));
        setLayerType(1, null);
    }

    private final int a(int i10) {
        if (i10 > 300) {
            return this.f19265f[0];
        }
        if (i10 > 150) {
            return this.f19265f[1];
        }
        if (i10 > 50) {
            return this.f19265f[2];
        }
        return this.f19265f[3];
    }

    private final float b(int i10, float f10) {
        float floatValue;
        float floatValue2;
        if (i10 > this.f19260a) {
            return f10;
        }
        if (i10 > 300) {
            floatValue = (((i10 - 300) * (this.f19266g.get(0).floatValue() + this.f19267h)) / (this.f19260a - 300)) + this.f19268i.get(1).floatValue() + this.f19268i.get(2).floatValue();
            floatValue2 = this.f19268i.get(3).floatValue();
        } else if (i10 > 150) {
            floatValue = (((i10 - 150) * (this.f19266g.get(1).floatValue() + this.f19267h)) / 150) + this.f19268i.get(2).floatValue();
            floatValue2 = this.f19268i.get(3).floatValue();
        } else if (i10 <= 50) {
            return (i10 * (this.f19266g.get(3).floatValue() + this.f19267h)) / 50;
        } else {
            floatValue = ((i10 - 50) * (this.f19266g.get(2).floatValue() + this.f19267h)) / 100;
            floatValue2 = this.f19268i.get(3).floatValue();
        }
        return floatValue2 + floatValue;
    }

    private final void c(float f10, Canvas canvas) {
        this.f19269j.setColor(b.c(getContext(), d.f34462v));
        this.f19269j.setTextSize(this.f19270k);
        this.f19269j.setTextAlign(Paint.Align.CENTER);
        this.f19269j.setAlpha(255);
        this.f19274o.setStrokeWidth(this.f19276q);
        this.f19274o.setStrokeCap(Paint.Cap.BUTT);
        int i10 = 0;
        float paddingLeft = getPaddingLeft() + this.f19267h + this.f19269j.measureText(String.valueOf(this.f19261b[0])) + this.f19276q;
        float paddingRight = getPaddingRight() + this.f19269j.measureText(this.f19262c[0]) + this.f19276q;
        int length = this.f19263d.length;
        float width = (getWidth() - paddingLeft) - paddingRight;
        float f11 = this.f19276q;
        float f12 = (width - (length * f11)) / (length - 1);
        float f13 = 2;
        float f14 = paddingLeft + (f11 / f13);
        float f15 = f10 + this.f19275p;
        Iterator<T> it = this.f19266g.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = Integer.valueOf(((Number) next).intValue() + ((Number) it.next()).intValue());
            }
            float floatValue = ((Number) next).floatValue() + (this.f19267h * 4);
            for (String str : this.f19263d) {
                i10++;
                canvas.drawText(str, f14, f15, this.f19269j);
                Integer num = this.f19264e.get(i10);
                i.e(num, "weekSportTimes[index]");
                int intValue = num.intValue();
                if (intValue > 0) {
                    this.f19274o.setColor(a(intValue));
                    float b10 = f10 - b(intValue, floatValue);
                    canvas.drawLine(f14, f10, f14, b10 + (this.f19276q / f13), this.f19274o);
                    float f16 = this.f19276q;
                    canvas.drawCircle(f14, b10 + (f16 / f13), f16 / f13, this.f19274o);
                }
                f14 += this.f19276q + f12;
            }
            return;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        super.onDraw(canvas);
        float paddingLeft = getPaddingLeft();
        this.f19269j.setTextSize(this.f19270k);
        this.f19269j.setColor(b.c(getContext(), d.f34454n));
        float paddingTop = getPaddingTop() + this.f19275p;
        canvas.drawText("min", this.f19267h + paddingLeft, paddingTop, this.f19269j);
        this.f19274o.setStrokeWidth(getResources().getDimension(e.f34498k0));
        this.f19274o.setStrokeCap(Paint.Cap.ROUND);
        int i10 = 0;
        for (Object obj : this.f19266g) {
            i10++;
            if (i10 < 0) {
                m.o();
            }
            int intValue = ((Number) obj).intValue();
            this.f19274o.setColor(this.f19265f[i10]);
            float f10 = this.f19267h + paddingTop;
            float f11 = f10 + intValue;
            canvas.drawLine(paddingLeft, f10, paddingLeft, f11, this.f19274o);
            this.f19272m.setPathEffect(this.f19273n);
            this.f19272m.setColor(b.c(getContext(), d.f34460t));
            if (i10 < 3) {
                this.f19269j.setTextSize(this.f19270k);
                this.f19269j.setTextAlign(Paint.Align.LEFT);
                this.f19269j.setColor(this.f19265f[i10]);
                this.f19269j.setAlpha(255);
                canvas.drawText(String.valueOf(this.f19261b[i10]), this.f19267h + paddingLeft, f11, this.f19269j);
                this.f19269j.setTextSize(this.f19271l);
                this.f19269j.setTextAlign(Paint.Align.RIGHT);
                this.f19269j.setAlpha(130);
                canvas.drawText(this.f19262c[i10], getWidth() - getPaddingRight(), f11, this.f19269j);
                float f12 = this.f19267h;
                float f13 = f11 + (f12 / 2);
                canvas.drawLine(paddingLeft + f12, f13, getWidth() - getPaddingRight(), f13, this.f19272m);
            } else {
                float f14 = f11 + (this.f19267h / 2);
                this.f19272m.setPathEffect(null);
                this.f19272m.setColor(b.c(getContext(), d.f34459s));
                canvas.drawLine(paddingLeft + this.f19267h, f14, getWidth() - getPaddingRight(), f14, this.f19272m);
            }
            paddingTop = f11;
        }
        c(paddingTop + (this.f19267h / 2), canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        float f10 = (this.f19275p * 2) + 0.0f + (this.f19267h * 5);
        for (Number number : this.f19266g) {
            f10 += number.intValue();
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) f10, Integer.MIN_VALUE));
    }

    public final void setData(ArrayList<Integer> data) {
        i.f(data, "data");
        this.f19264e.clear();
        this.f19264e.addAll(data);
    }
}
