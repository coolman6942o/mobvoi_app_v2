package com.mobvoi.health.companion.sport.view;

import a0.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import fg.m;
import fg.n;
import fg.o;
import fg.p;
import fg.q;
import fg.r;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class DetailCalendarView extends View implements View.OnTouchListener {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private Paint G;
    private Paint H;
    private Paint I;
    private Paint J;
    private String[] K;
    private float L;
    private Bitmap M;
    private Rect N;

    /* renamed from: a  reason: collision with root package name */
    private Date f18810a;

    /* renamed from: b  reason: collision with root package name */
    private Date f18811b;

    /* renamed from: c  reason: collision with root package name */
    private Date f18812c;

    /* renamed from: d  reason: collision with root package name */
    private Date f18813d;

    /* renamed from: e  reason: collision with root package name */
    private Date f18814e;

    /* renamed from: h  reason: collision with root package name */
    private Calendar f18817h;

    /* renamed from: k  reason: collision with root package name */
    private int f18820k;

    /* renamed from: l  reason: collision with root package name */
    private int f18821l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18822m;

    /* renamed from: n  reason: collision with root package name */
    private int f18823n;

    /* renamed from: o  reason: collision with root package name */
    private List<Integer> f18824o;

    /* renamed from: p  reason: collision with root package name */
    private a f18825p;

    /* renamed from: q  reason: collision with root package name */
    private int f18826q;

    /* renamed from: r  reason: collision with root package name */
    private int f18827r;

    /* renamed from: s  reason: collision with root package name */
    private float f18828s;

    /* renamed from: t  reason: collision with root package name */
    private float f18829t;

    /* renamed from: u  reason: collision with root package name */
    private float f18830u;

    /* renamed from: v  reason: collision with root package name */
    private float f18831v;

    /* renamed from: w  reason: collision with root package name */
    private float f18832w;

    /* renamed from: x  reason: collision with root package name */
    private int f18833x;

    /* renamed from: y  reason: collision with root package name */
    private int f18834y;

    /* renamed from: z  reason: collision with root package name */
    private int f18835z;

    /* renamed from: f  reason: collision with root package name */
    private int f18815f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f18816g = -1;

    /* renamed from: i  reason: collision with root package name */
    private int[] f18818i = new int[42];

    /* renamed from: j  reason: collision with root package name */
    private int f18819j = 6;
    private int O = -1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Date date, Date date2, Date date3);
    }

    public DetailCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k();
    }

    private void a() {
        this.f18817h.setTime(this.f18812c);
        this.f18817h.set(5, 1);
        int i10 = 7;
        int i11 = this.f18817h.get(7) - 1;
        if (i11 != 0) {
            i10 = i11;
        }
        int i12 = i10 - 1;
        this.f18820k = i12;
        this.f18818i[i12] = 1;
        if (i12 > 0) {
            this.f18817h.set(5, 0);
            int i13 = this.f18817h.get(5);
            for (int i14 = i12 - 1; i14 >= 0; i14--) {
                this.f18818i[i14] = i13;
                i13--;
            }
            this.f18817h.set(5, this.f18818i[0]);
        }
        this.f18817h.setTime(this.f18812c);
        this.f18817h.add(2, 1);
        this.f18817h.set(5, 0);
        int i15 = this.f18817h.get(5);
        int i16 = 1;
        while (i16 < i15) {
            int i17 = i16 + 1;
            this.f18818i[i12 + i16] = i17;
            if (this.f18822m && this.f18823n == i16) {
                this.f18816g = (i16 - 1) + i12;
            }
            i16 = i17;
        }
        int i18 = i12 + i15;
        this.f18821l = i18;
        for (int i19 = i18; i19 < 42; i19++) {
            this.f18818i[i19] = (i19 - i18) + 1;
        }
        if (this.f18821l < 42) {
            this.f18817h.add(5, 1);
        }
        this.f18817h.set(5, this.f18818i[41]);
    }

    private void b(Canvas canvas, int i10) {
        int i11 = i(i10);
        int j10 = j(i10);
        float f10 = this.f18829t;
        float f11 = j10 - 1;
        float f12 = this.f18830u;
        canvas.drawCircle(((i11 - 1) * f10) + (f10 / 2.0f), (this.f18828s * 2.0f) + (f11 * f12) + (f11 * this.f18832w) + (f12 / 2.0f), this.f18831v, this.J);
    }

    private void c(Canvas canvas) {
        int i10;
        this.f18817h.setTime(this.f18812c);
        String str = this.f18817h.get(1) + "" + this.f18817h.get(2);
        this.f18817h.setTime(this.f18813d);
        if (str.equals(this.f18817h.get(1) + "" + this.f18817h.get(2))) {
            this.f18817h.get(5);
        }
        int i11 = 0;
        if (this.f18818i[6] > 28) {
            i10 = 7;
            i11 = 7;
        } else {
            i10 = 0;
        }
        int i12 = (this.f18819j * 7) + i11;
        while (i11 < i12) {
            int i13 = this.f18833x;
            if (m(i11)) {
                i13 = this.f18835z;
            } else if (n(i11)) {
                i13 = this.f18835z;
            }
            if (this.f18822m) {
                int i14 = this.f18816g;
                if (i14 == i11 && this.f18815f != i14) {
                    i13 = this.A;
                } else if (this.f18815f == i11) {
                    i13 = this.D;
                }
            } else if (this.f18815f == i11) {
                i13 = this.D;
            }
            d(canvas, i11 - i10, String.valueOf(this.f18818i[i11]), i13);
            i11++;
        }
    }

    private void d(Canvas canvas, int i10, String str, int i11) {
        int i12 = i(i10);
        int j10 = j(i10);
        this.H.setColor(i11);
        float f10 = j10 - 1;
        float f11 = this.f18830u;
        float descent = ((((this.f18828s * 2.0f) + (f10 * f11)) + (f10 * this.f18832w)) + (f11 / 2.0f)) - ((this.H.descent() + this.H.ascent()) / 2.0f);
        float f12 = this.f18829t;
        canvas.drawText(str, ((i12 - 1) * f12) + ((f12 - this.H.measureText(str)) / 2.0f), descent, this.H);
    }

    private void e(Canvas canvas, int i10) {
        Bitmap decodeResource;
        int i11 = i((this.f18820k + i10) - 1);
        int j10 = j((this.f18820k + i10) - 1);
        float f10 = this.f18829t;
        float f11 = (i11 - 1) * f10;
        float f12 = j10 - 1;
        float f13 = this.f18830u;
        float f14 = (this.f18828s * 2.0f) + (f12 * f13) + (f12 * this.f18832w);
        if (this.O == 4) {
            this.M = BitmapFactory.decodeResource(getResources(), q.f26607p2);
            float width = ((this.f18829t / 2.0f) + f11) - (decodeResource.getWidth() / 2);
            float f15 = this.f18830u;
            float f16 = this.f18831v;
            canvas.drawBitmap(this.M, this.N, new RectF(width, (f15 / 2.0f) + f14 + f16 + 6.0f, f11 + (this.f18829t / 2.0f) + (this.M.getWidth() / 2), f14 + (f15 / 2.0f) + f16 + 6.0f + this.M.getHeight()), (Paint) null);
            return;
        }
        canvas.drawPoint(f11 + (f10 / 2.0f), f14 + (f13 / 2.0f) + this.f18831v + 6.0f + (this.L / 2.0f), this.I);
    }

    private void f(Canvas canvas) {
        List<Integer> list = this.f18824o;
        if (!(list == null || list.size() == 0)) {
            for (Integer num : this.f18824o) {
                e(canvas, num.intValue());
            }
        }
    }

    private void g(Canvas canvas) {
        if (this.f18822m) {
            b(canvas, this.f18816g);
        }
    }

    private void getShowWeeks() {
        int actualMaximum = this.f18817h.getActualMaximum(5);
        this.f18817h.set(5, 1);
        int i10 = this.f18817h.get(7);
        switch (actualMaximum) {
            case 28:
                if (i10 == 2) {
                    this.f18819j = 4;
                    return;
                } else {
                    this.f18819j = 5;
                    return;
                }
            case 29:
                this.f18819j = 5;
                return;
            case 30:
                if (i10 == 1) {
                    this.f18819j = 6;
                    return;
                } else {
                    this.f18819j = 5;
                    return;
                }
            case 31:
                if (i10 == 7 || i10 == 1) {
                    this.f18819j = 6;
                    return;
                } else {
                    this.f18819j = 5;
                    return;
                }
            default:
                return;
        }
    }

    private void h(Canvas canvas) {
        float descent = this.f18828s - (this.G.descent() + this.G.ascent());
        int i10 = 0;
        while (true) {
            String[] strArr = this.K;
            if (i10 < strArr.length) {
                float f10 = this.f18829t;
                canvas.drawText(this.K[i10 % 7], (i10 * f10) + ((f10 - this.G.measureText(strArr[i10])) / 2.0f), descent, this.G);
                i10++;
            } else {
                return;
            }
        }
    }

    private int i(int i10) {
        return (i10 % 7) + 1;
    }

    private int j(int i10) {
        return (i10 / 7) + 1;
    }

    private void k() {
        Date date = new Date();
        this.f18813d = date;
        this.f18811b = date;
        this.f18810a = date;
        this.f18812c = date;
        Calendar calendar = Calendar.getInstance();
        this.f18817h = calendar;
        calendar.setTime(this.f18812c);
        l();
        setOnTouchListener(this);
    }

    private void l() {
        Resources resources = getResources();
        this.f18833x = j7.a.e(this, n.f26443a, -12303292);
        this.f18835z = resources.getColor(o.f26459g0);
        this.A = resources.getColor(o.f26491w0);
        this.E = this.f18833x;
        this.B = resources.getColor(o.f26461h0);
        this.C = resources.getColor(o.f26463i0);
        this.D = resources.getColor(o.f26474o);
        new LinearGradient(0.0f, 0.0f, this.f18826q, 0.0f, this.B, this.C, Shader.TileMode.CLAMP);
        this.K = resources.getStringArray(m.f26441c);
        this.F = resources.getDimensionPixelSize(p.f26521n);
        this.f18834y = resources.getDimensionPixelSize(p.I);
        this.f18828s = resources.getDimensionPixelSize(p.f26543z);
        this.f18830u = resources.getDimensionPixelSize(p.f26541x);
        this.f18832w = resources.getDimensionPixelSize(p.f26542y);
        this.f18829t = this.f18826q / 7.0f;
        Paint paint = new Paint();
        this.G = paint;
        paint.setColor(this.E);
        this.G.setAntiAlias(true);
        this.G.setTextSize(this.F);
        this.G.setStrokeWidth(2.0f);
        this.G.setTypeface(Typeface.DEFAULT_BOLD);
        Paint paint2 = new Paint();
        this.H = paint2;
        paint2.setColor(this.f18833x);
        this.H.setAntiAlias(true);
        this.H.setTextSize(this.f18834y);
        this.H.setTypeface(h.h(getContext(), r.f26645b));
        Paint paint3 = new Paint();
        this.I = paint3;
        paint3.setAntiAlias(true);
        this.I.setStrokeCap(Paint.Cap.ROUND);
        this.I.setStyle(Paint.Style.FILL);
        this.I.setColor(this.D);
        this.I.setStrokeWidth(resources.getDimensionPixelSize(p.f26519m));
        Paint paint4 = new Paint(1);
        this.J = paint4;
        paint4.setAntiAlias(true);
        this.J.setStyle(Paint.Style.FILL);
        this.J.setStrokeWidth(2.0f);
        this.J.setColor(this.D);
        Rect rect = new Rect();
        String valueOf = String.valueOf(24);
        this.H.getTextBounds(valueOf, 0, valueOf.length(), rect);
        this.L = rect.height();
        this.f18831v = Math.max(rect.height() / 2, rect.width() / 2) + 15;
    }

    private boolean m(int i10) {
        return i10 < this.f18820k;
    }

    private boolean n(int i10) {
        return i10 >= this.f18821l;
    }

    private boolean o() {
        int i10 = this.f18818i[6] > 28 ? 7 : 0;
        int i11 = this.f18815f;
        return i11 + i10 >= this.f18820k && i11 + i10 < this.f18821l;
    }

    private void q(float f10, float f11) {
        if (f11 > this.f18828s) {
            int floor = (int) (Math.floor(f10 / this.f18829t) + 1.0d);
            int floor2 = (int) (Math.floor((f11 - (this.f18828s * 2.0f)) / (this.f18830u + this.f18832w)) + 1.0d);
            int i10 = floor2 - 1;
            float f12 = this.f18830u;
            float f13 = (this.f18828s * 2.0f) + (i10 * f12) + (floor2 * this.f18832w);
            if (f11 > f13 && f11 < f13 + f12) {
                int i11 = this.f18815f;
                int i12 = 7;
                this.f18815f = ((i10 * 7) + floor) - 1;
                if (!o()) {
                    this.f18815f = i11;
                    return;
                }
                this.f18817h.setTime(this.f18812c);
                if (m(this.f18815f)) {
                    this.f18817h.add(2, -1);
                } else if (n(this.f18815f)) {
                    this.f18817h.add(2, 1);
                }
                i12 = 0;
                int[] iArr = this.f18818i;
                if (iArr[6] <= 28) {
                }
                this.f18817h.set(5, iArr[this.f18815f + i12]);
                this.f18814e = this.f18817h.getTime();
            } else {
                return;
            }
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        h(canvas);
        g(canvas);
        f(canvas);
        c(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = getResources().getDisplayMetrics().widthPixels;
        this.f18826q = i12;
        float f10 = this.f18830u;
        int i13 = this.f18819j;
        this.f18827r = (int) ((this.f18828s * 2.0f) + (f10 * i13) + (this.f18832w * (i13 + 1)));
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f18827r, 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        l();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            q(motionEvent.getX(), motionEvent.getY());
        } else if (action != 1) {
            if (action == 3) {
                this.f18815f = -1;
                invalidate();
            }
        } else if (this.f18814e != null && o()) {
            Date date = this.f18814e;
            this.f18811b = date;
            this.f18810a = date;
            a aVar = this.f18825p;
            if (aVar != null) {
                aVar.a(date, date, date);
            }
            this.f18815f = -1;
            invalidate();
        }
        return true;
    }

    public void p(Date date, int i10, boolean z10) {
        this.O = i10;
        this.f18822m = z10;
        if (z10) {
            this.f18823n = Calendar.getInstance().get(5);
        }
        this.f18817h.setTime(date);
        this.f18812c = this.f18817h.getTime();
        getShowWeeks();
        a();
        if (i10 == 4) {
            this.M = BitmapFactory.decodeResource(getResources(), q.f26607p2);
            this.N = new Rect(0, 0, this.M.getWidth(), this.M.getHeight());
        }
        invalidate();
    }

    public void setDownIndex(int i10) {
        this.f18815f = i10;
        this.f18817h.set(5, i10);
        this.f18814e = this.f18817h.getTime();
        invalidate();
    }

    public void setOnItemClickListener(a aVar) {
        this.f18825p = aVar;
    }

    public void setSportDates(List<Integer> list) {
        this.f18824o = list;
        invalidate();
    }
}
