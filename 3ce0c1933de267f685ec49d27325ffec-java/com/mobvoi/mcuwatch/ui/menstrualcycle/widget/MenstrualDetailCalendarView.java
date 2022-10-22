package com.mobvoi.mcuwatch.ui.menstrualcycle.widget;

import a0.h;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import sh.c;
import sh.d;
import sh.e;
import sh.g;
/* loaded from: classes2.dex */
public class MenstrualDetailCalendarView extends View implements View.OnTouchListener {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private Paint I;
    private Paint J;
    private Paint K;
    private Paint L;
    private Paint M;
    private Paint N;
    private Paint O;
    private int P;
    private Paint Q;
    private Paint R;
    private Paint S;
    private String[] T;
    private Paint U;

    /* renamed from: a  reason: collision with root package name */
    private Date f19816a;

    /* renamed from: b  reason: collision with root package name */
    private Date f19817b;

    /* renamed from: c  reason: collision with root package name */
    private Date f19818c;

    /* renamed from: f  reason: collision with root package name */
    private Calendar f19821f;

    /* renamed from: k  reason: collision with root package name */
    private int f19826k;

    /* renamed from: l  reason: collision with root package name */
    private int f19827l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19828m;

    /* renamed from: n  reason: collision with root package name */
    private int f19829n;

    /* renamed from: o  reason: collision with root package name */
    private List<Integer> f19830o;

    /* renamed from: s  reason: collision with root package name */
    private a f19834s;

    /* renamed from: t  reason: collision with root package name */
    private int f19835t;

    /* renamed from: u  reason: collision with root package name */
    private int f19836u;

    /* renamed from: v  reason: collision with root package name */
    private float f19837v;

    /* renamed from: w  reason: collision with root package name */
    private float f19838w;

    /* renamed from: x  reason: collision with root package name */
    private float f19839x;

    /* renamed from: y  reason: collision with root package name */
    private float f19840y;

    /* renamed from: z  reason: collision with root package name */
    private float f19841z;

    /* renamed from: d  reason: collision with root package name */
    private int f19819d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f19820e = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f19822g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f19823h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private int[] f19824i = new int[42];

    /* renamed from: j  reason: collision with root package name */
    private int f19825j = 6;

    /* renamed from: p  reason: collision with root package name */
    private List<Integer> f19831p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private List<Integer> f19832q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private List<Integer> f19833r = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, boolean z10);
    }

    public MenstrualDetailCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q();
    }

    private void A(Float f10, Float f11) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long uptimeMillis2 = SystemClock.uptimeMillis() + 100;
        dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis2, 0, f10.floatValue(), f11.floatValue(), 0));
        dispatchTouchEvent(MotionEvent.obtain(uptimeMillis + 1000, uptimeMillis2 + 1000, 1, f10.floatValue(), f11.floatValue(), 0));
    }

    private void a() {
        this.f19821f.setTime(this.f19816a);
        this.f19821f.set(5, 1);
        int i10 = 7;
        int i11 = this.f19821f.get(7) - 1;
        if (i11 != 0) {
            i10 = i11;
        }
        int i12 = i10 - 1;
        this.f19826k = i12;
        this.f19824i[i12] = 1;
        if (i12 > 0) {
            this.f19821f.set(5, 0);
            int i13 = this.f19821f.get(5);
            for (int i14 = i12 - 1; i14 >= 0; i14--) {
                this.f19824i[i14] = i13;
                i13--;
            }
            this.f19821f.set(5, this.f19824i[0]);
        }
        this.f19821f.setTime(this.f19816a);
        this.f19821f.add(2, 1);
        this.f19821f.set(5, 0);
        int i15 = this.f19821f.get(5);
        int i16 = 1;
        while (i16 < i15) {
            int i17 = i16 + 1;
            this.f19824i[i12 + i16] = i17;
            if (this.f19828m && this.f19829n == i16) {
                this.f19820e = (i16 - 1) + i12;
            }
            i16 = i17;
        }
        int i18 = i12 + i15;
        this.f19827l = i18;
        for (int i19 = i18; i19 < 42; i19++) {
            this.f19824i[i19] = (i19 - i18) + 1;
        }
        if (this.f19827l < 42) {
            this.f19821f.add(5, 1);
        }
        this.f19821f.set(5, this.f19824i[41]);
    }

    private void c(Canvas canvas, int i10, Paint paint) {
        int o10 = o(i10);
        int p10 = p(i10);
        float f10 = this.f19838w;
        float f11 = (o10 - 1) * f10;
        float f12 = p10 - 1;
        float f13 = this.f19839x;
        float f14 = (this.f19837v * 2.0f) + (f12 * f13) + (f12 * this.f19841z);
        float f15 = this.f19840y;
        if (this.f19820e == i10) {
            f15 -= 6.0f;
        }
        canvas.drawCircle(f11 + (f10 / 2.0f), f14 + (f13 / 2.0f), f15, paint);
    }

    private void d(Canvas canvas) {
        int i10;
        this.f19821f.setTime(this.f19816a);
        String str = this.f19821f.get(1) + "" + this.f19821f.get(2);
        this.f19821f.setTime(this.f19817b);
        if (str.equals(this.f19821f.get(1) + "" + this.f19821f.get(2))) {
            this.f19821f.get(5);
        }
        int i11 = 0;
        if (this.f19824i[6] > 28) {
            i10 = 7;
            i11 = 7;
        } else {
            i10 = 0;
        }
        int i12 = (this.f19825j * 7) + i11;
        while (i11 < i12) {
            int i13 = this.A;
            if (!t(i11) && !v(i11)) {
                int i14 = this.f19819d;
                if (i14 == i11 && i14 != this.f19820e) {
                    i13 = this.C;
                }
                if (u(i11) || s(i11) || w(i11)) {
                    i13 = this.C;
                }
                e(canvas, i11 - i10, String.valueOf(this.f19824i[i11]), i13);
            }
            i11++;
        }
    }

    private void e(Canvas canvas, int i10, String str, int i11) {
        int o10 = o(i10);
        int p10 = p(i10);
        this.J.setColor(i11);
        float f10 = p10 - 1;
        float f11 = this.f19839x;
        float descent = ((((this.f19837v * 2.0f) + (f10 * f11)) + (f10 * this.f19841z)) + (f11 / 2.0f)) - ((this.J.descent() + this.J.ascent()) / 2.0f);
        float f12 = this.f19838w;
        float measureText = ((o10 - 1) * f12) + ((f12 - this.J.measureText(str)) / 2.0f);
        if (this.f19820e == i10) {
            this.f19823h = measureText;
            this.f19822g = descent;
        }
        canvas.drawText(str, measureText, descent, this.J);
    }

    private void f(Canvas canvas, int i10) {
        Paint paint = this.U;
        if (u(i10) || s(i10) || w(i10)) {
            paint.setStyle(Paint.Style.STROKE);
        } else {
            paint.setStyle(Paint.Style.FILL);
        }
        int o10 = o(i10);
        int p10 = p(i10);
        float f10 = this.f19838w;
        float f11 = p10 - 1;
        float f12 = this.f19839x;
        canvas.drawCircle(((o10 - 1) * f10) + (f10 / 2.0f), (this.f19837v * 2.0f) + (f11 * f12) + (f11 * this.f19841z) + (f12 / 2.0f), this.f19840y, this.U);
    }

    private void g(Canvas canvas) {
        int i10 = this.f19819d;
        if (i10 >= 0 && i10 != this.f19820e) {
            f(canvas, i10);
        }
    }

    private void getShowWeeks() {
        int actualMaximum = this.f19821f.getActualMaximum(5);
        this.f19821f.set(5, 1);
        int i10 = this.f19821f.get(7);
        switch (actualMaximum) {
            case 28:
                if (i10 == 2) {
                    this.f19825j = 4;
                    return;
                } else {
                    this.f19825j = 5;
                    return;
                }
            case 29:
                this.f19825j = 5;
                return;
            case 30:
                if (i10 == 1) {
                    this.f19825j = 6;
                    return;
                } else {
                    this.f19825j = 5;
                    return;
                }
            case 31:
                if (i10 == 7 || i10 == 1) {
                    this.f19825j = 6;
                    return;
                } else {
                    this.f19825j = 5;
                    return;
                }
            default:
                return;
        }
    }

    private void h(Canvas canvas) {
        List<Integer> list = this.f19832q;
        if (!(list == null || list.size() == 0)) {
            for (Integer num : this.f19832q) {
                c(canvas, num.intValue(), this.R);
            }
        }
    }

    private void i(Canvas canvas) {
        List<Integer> list = this.f19831p;
        if (!(list == null || list.size() == 0)) {
            for (Integer num : this.f19831p) {
                c(canvas, num.intValue(), this.Q);
            }
        }
    }

    private void j(Canvas canvas) {
        List<Integer> list = this.f19833r;
        if (!(list == null || list.size() == 0)) {
            for (Integer num : this.f19833r) {
                c(canvas, num.intValue(), this.S);
            }
        }
    }

    private void k(Canvas canvas, int i10) {
        k.c("wlp", "drawToday index = %s", Integer.valueOf(i10));
        int o10 = o(i10);
        int p10 = p(i10);
        float f10 = this.f19838w;
        float f11 = (o10 - 1) * f10;
        float f12 = p10 - 1;
        float f13 = this.f19839x;
        float f14 = (this.f19837v * 2.0f) + (f12 * f13) + (f12 * this.f19841z);
        canvas.drawCircle((f10 / 2.0f) + f11, (f13 / 2.0f) + f14, this.f19840y, this.L);
        float f15 = this.f19838w;
        RectF rectF = new RectF((f15 / 2.0f) + f11, f14, (f15 / 2.0f) + f11 + 72.0f, 36.0f + f14);
        float f16 = this.f19840y;
        canvas.drawRoundRect(rectF, f16, f16, this.N);
        canvas.drawText("今天", 0, 2, f11 + (this.f19838w / 2.0f) + 6.0f, f14 + (this.f19841z * 2.0f), this.O);
    }

    private void l(Canvas canvas) {
        if (this.f19828m) {
            k(canvas, this.f19820e);
        }
    }

    private void m(Canvas canvas) {
        float descent = this.f19837v - (this.I.descent() + this.I.ascent());
        int i10 = 0;
        while (true) {
            String[] strArr = this.T;
            if (i10 < strArr.length) {
                float f10 = this.f19838w;
                canvas.drawText(this.T[i10 % 7], (i10 * f10) + ((f10 - this.I.measureText(strArr[i10])) / 2.0f), descent, this.I);
                i10++;
            } else {
                return;
            }
        }
    }

    public static String n(Date date) {
        Application e10 = b.e();
        Calendar calendar = Calendar.getInstance();
        int i10 = 1;
        boolean z10 = calendar.getFirstDayOfWeek() == 1;
        calendar.setTime(date);
        int i11 = calendar.get(7);
        if (z10 || (i11 = i11 + 1) != 8) {
            i10 = i11;
        }
        switch (i10) {
            case 1:
                return e10.getString(sh.k.B2);
            case 2:
                return e10.getString(sh.k.f34874u1);
            case 3:
                return e10.getString(sh.k.S2);
            case 4:
                return e10.getString(sh.k.V4);
            case 5:
                return e10.getString(sh.k.N2);
            case 6:
                return e10.getString(sh.k.Q0);
            case 7:
                return e10.getString(sh.k.f34845o2);
            default:
                return "";
        }
    }

    private int o(int i10) {
        return (i10 % 7) + 1;
    }

    private int p(int i10) {
        return (i10 / 7) + 1;
    }

    private void q() {
        Date date = new Date();
        this.f19817b = date;
        this.f19816a = date;
        Calendar calendar = Calendar.getInstance();
        this.f19821f = calendar;
        calendar.setTime(this.f19816a);
        r();
        setOnTouchListener(this);
    }

    private void r() {
        Resources resources = getResources();
        this.A = j7.a.e(this, c.f34439a, -12303292);
        resources.getColor(d.Y);
        this.C = resources.getColor(d.f34444b0);
        this.G = resources.getColor(d.U);
        this.D = resources.getColor(d.W);
        this.E = resources.getColor(d.X);
        this.F = resources.getColor(d.V);
        new LinearGradient(0.0f, 0.0f, this.f19835t, 0.0f, this.D, this.E, Shader.TileMode.CLAMP);
        this.T = resources.getStringArray(sh.b.f34436t);
        this.P = resources.getDimensionPixelSize(e.f34469a1);
        this.H = resources.getDimensionPixelSize(e.V0);
        this.B = resources.getDimensionPixelSize(e.Z0);
        this.f19837v = resources.getDimensionPixelSize(e.Y0);
        this.f19839x = resources.getDimensionPixelSize(e.W0);
        this.f19841z = resources.getDimensionPixelSize(e.X0);
        this.f19838w = this.f19835t / 7.0f;
        Paint paint = new Paint();
        this.I = paint;
        paint.setColor(this.G);
        this.I.setAntiAlias(true);
        this.I.setTextSize(this.H);
        this.I.setStrokeWidth(2.0f);
        this.I.setTypeface(Typeface.DEFAULT_BOLD);
        Paint paint2 = new Paint();
        this.J = paint2;
        paint2.setColor(this.A);
        this.J.setAntiAlias(true);
        this.J.setTextSize(this.B);
        this.J.setTypeface(h.h(getContext(), g.f34609c));
        Paint paint3 = new Paint();
        this.K = paint3;
        paint3.setAntiAlias(true);
        this.K.setStrokeCap(Paint.Cap.ROUND);
        this.K.setStyle(Paint.Style.FILL);
        this.K.setColor(this.F);
        this.K.setStrokeWidth(resources.getDimensionPixelSize(e.U0));
        Paint paint4 = new Paint(1);
        this.U = paint4;
        paint4.setAntiAlias(true);
        this.U.setStrokeWidth(6.0f);
        this.U.setColor(this.E);
        Paint paint5 = new Paint(1);
        this.L = paint5;
        paint5.setAntiAlias(true);
        this.L.setStyle(Paint.Style.STROKE);
        this.L.setStrokeWidth(6.0f);
        this.L.setColor(this.F);
        Paint paint6 = new Paint(1);
        this.M = paint6;
        paint6.setAntiAlias(true);
        this.M.setStyle(Paint.Style.STROKE);
        this.M.setStrokeWidth(2.0f);
        this.M.setColor(-1);
        Paint paint7 = new Paint(1);
        this.N = paint7;
        paint7.setAntiAlias(true);
        this.N.setStyle(Paint.Style.FILL);
        this.N.setStrokeWidth(2.0f);
        this.N.setColor(this.F);
        Paint paint8 = new Paint(1);
        this.O = paint8;
        paint8.setAntiAlias(true);
        this.O.setStyle(Paint.Style.FILL);
        this.O.setColor(-1);
        this.O.setTextSize(this.P);
        Paint paint9 = new Paint(1);
        this.Q = paint9;
        paint9.setAntiAlias(true);
        this.Q.setStyle(Paint.Style.FILL);
        this.Q.setColor(resources.getColor(d.f34464x));
        Paint paint10 = new Paint(1);
        this.R = paint10;
        paint10.setAntiAlias(true);
        this.R.setStyle(Paint.Style.FILL);
        this.R.setColor(resources.getColor(d.f34465y));
        Paint paint11 = new Paint(1);
        this.S = paint11;
        paint11.setAntiAlias(true);
        this.S.setStyle(Paint.Style.FILL);
        this.S.setColor(resources.getColor(d.f34455o));
        Rect rect = new Rect();
        String valueOf = String.valueOf(24);
        this.J.getTextBounds(valueOf, 0, valueOf.length(), rect);
        rect.height();
        this.f19840y = Math.max(rect.height() / 2, rect.width() / 2) + 15;
    }

    private boolean s(int i10) {
        return this.f19832q.contains(Integer.valueOf(i10));
    }

    private boolean t(int i10) {
        return i10 < this.f19826k;
    }

    private boolean u(int i10) {
        return this.f19831p.contains(Integer.valueOf(i10));
    }

    private boolean v(int i10) {
        return i10 >= this.f19827l;
    }

    private boolean w(int i10) {
        return this.f19833r.contains(Integer.valueOf(i10));
    }

    private boolean x() {
        int i10 = this.f19824i[6] > 28 ? 7 : 0;
        int i11 = this.f19819d;
        return i11 + i10 >= this.f19826k && i11 + i10 < this.f19827l;
    }

    private void z(float f10, float f11) {
        if (f11 > this.f19837v) {
            int floor = (int) (Math.floor(f10 / this.f19838w) + 1.0d);
            int floor2 = (int) (Math.floor((f11 - (this.f19837v * 2.0f)) / (this.f19839x + this.f19841z)) + 1.0d);
            int i10 = floor2 - 1;
            float f12 = this.f19839x;
            float f13 = (this.f19837v * 2.0f) + (i10 * f12) + (floor2 * this.f19841z);
            if (f11 > f13 && f11 < f13 + f12) {
                int i11 = this.f19819d;
                int i12 = 7;
                this.f19819d = ((i10 * 7) + floor) - 1;
                if (!x()) {
                    this.f19819d = i11;
                    return;
                }
                this.f19821f.setTime(this.f19816a);
                if (t(this.f19819d)) {
                    this.f19821f.add(2, -1);
                } else if (v(this.f19819d)) {
                    this.f19821f.add(2, 1);
                }
                i12 = 0;
                int[] iArr = this.f19824i;
                if (iArr[6] <= 28) {
                }
                this.f19821f.set(5, iArr[this.f19819d + i12]);
                this.f19818c = this.f19821f.getTime();
            } else {
                return;
            }
        }
        invalidate();
    }

    public void b() {
        float f10 = this.f19823h;
        if (f10 > 0.0f && this.f19822g > 0.0f) {
            A(Float.valueOf(f10), Float.valueOf(this.f19822g));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        m(canvas);
        j(canvas);
        i(canvas);
        h(canvas);
        l(canvas);
        g(canvas);
        d(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = getResources().getDisplayMetrics().widthPixels;
        this.f19835t = i12;
        float f10 = this.f19839x;
        int i13 = this.f19825j;
        this.f19836u = (int) ((this.f19837v * 2.0f) + (f10 * i13) + (this.f19841z * (i13 + 1)));
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f19836u, 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        r();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            z(motionEvent.getX(), motionEvent.getY());
        } else if (action != 1) {
            if (action == 3) {
                this.f19819d = -1;
                invalidate();
            }
        } else if (!(this.f19818c == null || !x() || this.f19834s == null)) {
            String string = getContext().getString(sh.k.f34840n2);
            if (u(this.f19819d) || s(this.f19819d)) {
                string = getContext().getString(sh.k.f34854q1);
            } else if (w(this.f19819d)) {
                string = getContext().getString(sh.k.W1);
            }
            a aVar = this.f19834s;
            boolean z10 = false;
            String string2 = getContext().getString(sh.k.f34897y2, string, DateFormat.format(getContext().getString(sh.k.f34787d0), this.f19818c).toString() + n(this.f19818c));
            if (this.f19819d == this.f19820e) {
                z10 = true;
            }
            aVar.a(string2, z10);
        }
        return true;
    }

    public void setDownIndex(int i10) {
        this.f19819d = i10;
        this.f19821f.set(5, i10);
        this.f19818c = this.f19821f.getTime();
        invalidate();
    }

    public void setOnItemClickListener(a aVar) {
        this.f19834s = aVar;
    }

    public void setPeriodCycle(com.mobvoi.mcuwatch.ui.menstrualcycle.data.a aVar) {
        if (aVar != null) {
            this.f19831p.clear();
            long time = bh.b.c(this.f19816a).getTime() - 1;
            long time2 = bh.b.b(this.f19816a).getTime();
            Calendar calendar = Calendar.getInstance();
            for (Date date : com.mobvoi.mcuwatch.ui.menstrualcycle.data.b.f19786a.e(aVar.c(), aVar.b(), time, time2)) {
                calendar.setTime(date);
                this.f19831p.add(Integer.valueOf((calendar.get(5) - 1) + this.f19826k));
            }
            this.f19832q.clear();
            List<Date> d10 = aVar.d();
            if (d10 != null && d10.size() > 0) {
                for (int i10 = 0; i10 < d10.size(); i10++) {
                    calendar.setTime(d10.get(i10));
                    int i11 = (calendar.get(5) - 1) + this.f19826k;
                    k.c("wlp", "calendar.get(Calendar.DAY_OF_MONTH) = %s", Integer.valueOf(i11));
                    this.f19832q.add(Integer.valueOf(i11));
                }
                Collections.sort(this.f19832q);
            }
            this.f19833r.clear();
            List<Date> e10 = aVar.e();
            if (e10 != null && e10.size() > 0) {
                for (int i12 = 0; i12 < e10.size(); i12++) {
                    calendar.setTime(e10.get(i12));
                    int i13 = (calendar.get(5) - 1) + this.f19826k;
                    k.c("wlp", "calendar.get(Calendar.DAY_OF_MONTH) = %s", Integer.valueOf(i13));
                    this.f19833r.add(Integer.valueOf(i13));
                }
                Collections.sort(this.f19833r);
            }
            invalidate();
        }
    }

    public void setSportDates(List<Integer> list) {
        this.f19830o = list;
        invalidate();
    }

    public void y(Date date, int i10, boolean z10) {
        this.f19828m = z10;
        if (z10) {
            this.f19829n = Calendar.getInstance().get(5);
        } else {
            this.f19829n = -1;
        }
        this.f19821f.setTime(date);
        this.f19816a = this.f19821f.getTime();
        getShowWeeks();
        a();
        invalidate();
    }
}
