package com.mobvoi.health.companion.pressure;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.health.companion.pressure.a;
import fg.m;
import fg.o;
import fg.p;
import fg.u;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class PressureDetailView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f18440a;

    /* renamed from: b  reason: collision with root package name */
    private float f18441b;

    /* renamed from: c  reason: collision with root package name */
    private float f18442c;

    /* renamed from: d  reason: collision with root package name */
    private float f18443d;

    /* renamed from: e  reason: collision with root package name */
    private float f18444e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f18445f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f18446g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f18447h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f18448i;

    /* renamed from: j  reason: collision with root package name */
    private float f18449j;

    /* renamed from: k  reason: collision with root package name */
    private float f18450k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f18451l;

    /* renamed from: m  reason: collision with root package name */
    private int f18452m;

    /* renamed from: n  reason: collision with root package name */
    private int f18453n;

    /* renamed from: o  reason: collision with root package name */
    private float f18454o;

    /* renamed from: p  reason: collision with root package name */
    private float f18455p;

    /* renamed from: q  reason: collision with root package name */
    private a f18456q;

    /* renamed from: r  reason: collision with root package name */
    private long f18457r;

    /* renamed from: s  reason: collision with root package name */
    private DashPathEffect f18458s;

    /* renamed from: t  reason: collision with root package name */
    private Paint f18459t;

    /* renamed from: u  reason: collision with root package name */
    private Paint f18460u;

    /* renamed from: v  reason: collision with root package name */
    private Paint f18461v;

    /* renamed from: w  reason: collision with root package name */
    private Paint f18462w;

    /* renamed from: x  reason: collision with root package name */
    private Paint f18463x;

    /* renamed from: y  reason: collision with root package name */
    private Paint f18464y;

    public PressureDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        int i10;
        String[] strArr;
        float dimension = getResources().getDimension(p.V);
        float dimension2 = getResources().getDimension(p.W);
        this.f18444e = dimension2;
        this.f18440a = dimension;
        this.f18441b = getHeight() - this.f18444e;
        this.f18442c = dimension;
        this.f18443d = getWidth() - dimension2;
        int i11 = this.f18452m;
        if (i11 > 0) {
            int i12 = 0;
            if (i11 == 1) {
                this.f18453n = 48;
                this.f18447h = getResources().getStringArray(m.f26439a);
                this.f18455p = getResources().getDimensionPixelSize(p.U);
                float dimensionPixelSize = getResources().getDimensionPixelSize(p.f26498b0);
                this.f18454o = dimensionPixelSize;
                float f15 = this.f18443d;
                float f16 = this.f18442c;
                float f17 = this.f18455p;
                float length = (((f15 - f16) - (f17 * 2.0f)) - dimensionPixelSize) / strArr.length;
                f10 = (((f15 - f16) - (f17 * 2.0f)) - dimensionPixelSize) / 48.0f;
                this.f18448i = new float[this.f18447h.length];
                while (true) {
                    float[] fArr = this.f18448i;
                    if (i12 >= fArr.length) {
                        break;
                    }
                    fArr[i12] = this.f18442c + this.f18455p + (this.f18454o / 2.0f) + (i12 * length);
                    i12++;
                }
            } else if (i11 == 2) {
                this.f18455p = 0.0f;
                this.f18454o = getResources().getDimensionPixelSize(p.f26502d0);
                this.f18453n = 7;
                String[] stringArray = getResources().getStringArray(m.f26441c);
                this.f18447h = stringArray;
                float f18 = this.f18443d;
                float f19 = this.f18442c;
                float length2 = (f18 - f19) / stringArray.length;
                f10 = (f18 - f19) / 7.0f;
                this.f18448i = new float[stringArray.length];
                while (true) {
                    float[] fArr2 = this.f18448i;
                    if (i12 >= fArr2.length) {
                        break;
                    }
                    fArr2[i12] = this.f18442c + (i12 * length2);
                    i12++;
                }
            } else if (i11 == 3) {
                this.f18455p = getResources().getDimensionPixelSize(p.U);
                this.f18454o = getResources().getDimensionPixelSize(p.f26500c0);
                this.f18447h = getResources().getStringArray(m.f26440b);
                if (this.f18457r < 0) {
                    this.f18457r = System.currentTimeMillis();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.f18457r);
                int i13 = calendar.get(1);
                int i14 = calendar.get(2);
                if ((i13 % 4 == 0 && i13 % 100 != 0) || i13 % AGCServerException.AUTHENTICATION_INVALID == 0) {
                    this.f18446g[1] = 29;
                }
                int i15 = this.f18446g[i14];
                this.f18453n = i15;
                if (i15 == 28) {
                    String[] strArr2 = this.f18447h;
                    strArr2[strArr2.length - 1] = String.format(getResources().getString(u.Q3), 28);
                }
                float f20 = (((this.f18443d - this.f18442c) - (this.f18455p * 2.0f)) - this.f18454o) / this.f18453n;
                this.f18448i = new float[this.f18447h.length];
                while (true) {
                    float[] fArr3 = this.f18448i;
                    if (i12 >= fArr3.length) {
                        break;
                    }
                    if (i12 == fArr3.length - 1 && this.f18453n == 28) {
                        fArr3[i12] = (this.f18443d - this.f18455p) - (this.f18454o / 2.0f);
                    } else {
                        fArr3[i12] = this.f18442c + this.f18455p + (this.f18454o / 2.0f) + (f20 * 7.0f * i12);
                    }
                    i12++;
                }
                f10 = f20;
            } else {
                f10 = 0.0f;
            }
            a aVar = this.f18456q;
            if (aVar != null) {
                List<a.b> list = aVar.f18473b;
                this.f18461v.setStrokeWidth(this.f18454o);
                for (a.b bVar : list) {
                    Path path = new Path();
                    int i16 = this.f18452m;
                    if (i16 == 1) {
                        f14 = this.f18442c + this.f18455p + (this.f18454o / 2.0f);
                        i10 = bVar.f18484b;
                    } else if (i16 == 2) {
                        f14 = this.f18442c + (f10 / 2.0f);
                        i10 = bVar.f18484b;
                    } else if (i16 == 3) {
                        f14 = this.f18442c + this.f18455p + (this.f18454o / 2.0f);
                        i10 = bVar.f18484b;
                    } else {
                        f11 = 0.0f;
                        f12 = bVar.f18483a;
                        if (f12 < 100.0f) {
                            f13 = this.f18440a;
                        } else {
                            float f21 = this.f18441b;
                            f13 = f21 - (((f21 - this.f18440a) * f12) / 100.0f);
                        }
                        path.moveTo(f11, f13 - (this.f18454o / 2.0f));
                        path.lineTo(f11, this.f18441b - (this.f18454o / 2.0f));
                        bVar.f18485c = path;
                    }
                    f11 = f14 + (i10 * f10);
                    f12 = bVar.f18483a;
                    if (f12 < 100.0f) {
                    }
                    path.moveTo(f11, f13 - (this.f18454o / 2.0f));
                    path.lineTo(f11, this.f18441b - (this.f18454o / 2.0f));
                    bVar.f18485c = path;
                }
            }
        }
    }

    private void b() {
        this.f18450k = getResources().getDimensionPixelSize(p.R);
        this.f18449j = getResources().getDimensionPixelSize(p.S);
        getResources().getDimensionPixelSize(p.Z);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        Paint paint = this.f18459t;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        float f10 = dimensionPixelSize;
        this.f18459t.setStrokeWidth(f10);
        this.f18459t.setStyle(Paint.Style.FILL);
        this.f18462w.setStyle(Paint.Style.STROKE);
        this.f18462w.setStrokeWidth(f10);
        this.f18460u.setColor(getResources().getColor(i10));
        this.f18460u.setTextAlign(Paint.Align.LEFT);
        this.f18460u.setTextSize(getResources().getDimension(p.X));
        this.f18460u.setStyle(Paint.Style.FILL);
        this.f18461v.setStrokeCap(Paint.Cap.ROUND);
        this.f18461v.setStyle(Paint.Style.STROKE);
        this.f18461v.setColor(getResources().getColor(o.f26470m));
        this.f18464y.setStyle(Paint.Style.STROKE);
        this.f18464y.setColor(getResources().getColor(o.f26478q));
        this.f18464y.setStrokeWidth(getResources().getDimensionPixelSize(p.f26529r));
        this.f18463x.setStrokeCap(Paint.Cap.ROUND);
        this.f18463x.setStyle(Paint.Style.FILL);
        String valueOf = String.valueOf(24);
        this.f18460u.getTextBounds(valueOf, 0, valueOf.length(), this.f18451l);
    }

    private void c(Canvas canvas) {
        float f10;
        float f11;
        Paint paint = this.f18462w;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        this.f18462w.setPathEffect(this.f18458s);
        float f12 = this.f18442c;
        float f13 = this.f18440a;
        canvas.drawLine(f12, f13, this.f18443d, f13, this.f18459t);
        float f14 = this.f18442c;
        float f15 = this.f18441b;
        canvas.drawLine(f14, f15, this.f18443d, f15, this.f18459t);
        if (this.f18452m != 3) {
            float f16 = this.f18442c;
            canvas.drawLine(f16, this.f18440a, f16, this.f18441b + (this.f18444e / 2.0f), this.f18462w);
        }
        float f17 = this.f18443d;
        canvas.drawLine(f17, this.f18440a, f17, this.f18452m == 3 ? this.f18441b : this.f18441b + (this.f18444e / 2.0f), this.f18462w);
        this.f18460u.setColor(getResources().getColor(i10));
        this.f18460u.setTextAlign(Paint.Align.LEFT);
        float f18 = (this.f18441b - this.f18440a) / 4.0f;
        for (int i11 = 1; i11 < 4; i11++) {
            float f19 = this.f18442c;
            float f20 = this.f18440a;
            float f21 = i11 * f18;
            canvas.drawLine(f19, f20 + f21, this.f18443d, f20 + f21, this.f18459t);
        }
        int i12 = 0;
        while (true) {
            int[] iArr = this.f18445f;
            if (i12 >= iArr.length) {
                break;
            }
            if (i12 == 0) {
                canvas.drawText(String.valueOf(iArr[i12]), this.f18443d + this.f18450k, this.f18440a + (this.f18451l.height() / 2), this.f18460u);
            }
            if (this.f18452m == 3 && i12 == this.f18445f.length - 1) {
                f11 = this.f18440a;
                f10 = i12 * f18;
            } else {
                f11 = this.f18440a + (i12 * f18);
                f10 = this.f18451l.height() / 2;
            }
            canvas.drawText(String.valueOf(this.f18445f[i12]), this.f18443d + this.f18450k, f11 + f10, this.f18460u);
            i12++;
        }
        if (this.f18448i != null) {
            int i13 = 0;
            while (true) {
                float[] fArr = this.f18448i;
                if (i13 < fArr.length) {
                    int i14 = this.f18452m;
                    if (i14 == 1) {
                        if (i13 != 0) {
                            canvas.drawLine(fArr[i13], this.f18440a, fArr[i13], (this.f18444e / 2.0f) + this.f18441b, this.f18462w);
                        }
                        canvas.drawText(this.f18447h[i13], this.f18448i[i13] + this.f18450k, this.f18441b + this.f18449j + this.f18451l.height(), this.f18460u);
                    } else if (i14 == 2) {
                        if (i13 != 0) {
                            canvas.drawLine(fArr[i13], this.f18440a, fArr[i13], (this.f18444e / 2.0f) + this.f18441b, this.f18462w);
                        }
                        this.f18460u.setTextAlign(Paint.Align.CENTER);
                        canvas.drawText(this.f18447h[i13], this.f18448i[i13] + (((this.f18443d - this.f18442c) / 7.0f) / 2.0f), this.f18441b + this.f18449j + this.f18451l.height(), this.f18460u);
                    } else if (i14 == 3) {
                        canvas.drawLine(fArr[i13], this.f18440a, fArr[i13], (this.f18444e / 2.0f) + this.f18441b, this.f18462w);
                        canvas.drawText(this.f18447h[i13], this.f18448i[i13] + this.f18450k, this.f18441b + this.f18449j + this.f18451l.height(), this.f18460u);
                    }
                    i13++;
                } else {
                    return;
                }
            }
        }
    }

    public void d(a aVar, int i10) {
        this.f18456q = aVar;
        this.f18452m = i10;
        this.f18457r = aVar != null ? aVar.f27853a : System.currentTimeMillis();
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        a aVar = this.f18456q;
        if (aVar != null) {
            for (a.b bVar : aVar.f18473b) {
                this.f18461v.setColor(getResources().getColor(a.a(bVar.f18483a)));
                canvas.drawPath(bVar.f18485c, this.f18461v);
            }
            return;
        }
        this.f18460u.setTextAlign(Paint.Align.CENTER);
        this.f18460u.setColor(getResources().getColor(o.f26458g));
        canvas.drawText(getResources().getString(u.N2), getWidth() / 2, (this.f18441b - this.f18440a) / 2.0f, this.f18460u);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public PressureDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18445f = new int[]{100, 75, 50, 25, 0};
        this.f18446g = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        this.f18451l = new Rect();
        this.f18452m = -1;
        this.f18457r = -1L;
        this.f18458s = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f18459t = new Paint(1);
        this.f18460u = new Paint(1);
        this.f18461v = new Paint(1);
        this.f18462w = new Paint(1);
        this.f18463x = new Paint(1);
        this.f18464y = new Paint(1);
        b();
    }
}
