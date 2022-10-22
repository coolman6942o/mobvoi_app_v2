package com.mobvoi.health.companion.noise;

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
import com.mobvoi.health.companion.noise.a;
import fg.m;
import fg.o;
import fg.p;
import fg.u;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class NoiseDetailView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f18339a;

    /* renamed from: b  reason: collision with root package name */
    private float f18340b;

    /* renamed from: c  reason: collision with root package name */
    private float f18341c;

    /* renamed from: d  reason: collision with root package name */
    private float f18342d;

    /* renamed from: e  reason: collision with root package name */
    private float f18343e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f18344f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f18345g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f18346h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f18347i;

    /* renamed from: j  reason: collision with root package name */
    private float f18348j;

    /* renamed from: k  reason: collision with root package name */
    private float f18349k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f18350l;

    /* renamed from: m  reason: collision with root package name */
    private DashPathEffect f18351m;

    /* renamed from: n  reason: collision with root package name */
    private float f18352n;

    /* renamed from: o  reason: collision with root package name */
    private float f18353o;

    /* renamed from: p  reason: collision with root package name */
    private int f18354p;

    /* renamed from: q  reason: collision with root package name */
    private int f18355q;

    /* renamed from: r  reason: collision with root package name */
    private float f18356r;

    /* renamed from: s  reason: collision with root package name */
    private float f18357s;

    /* renamed from: t  reason: collision with root package name */
    private a f18358t;

    /* renamed from: u  reason: collision with root package name */
    private long f18359u;

    /* renamed from: v  reason: collision with root package name */
    private Paint f18360v;

    /* renamed from: w  reason: collision with root package name */
    private Paint f18361w;

    /* renamed from: x  reason: collision with root package name */
    private Paint f18362x;

    /* renamed from: y  reason: collision with root package name */
    private Paint f18363y;

    public NoiseDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0209  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        int i10;
        String[] strArr;
        float dimension = getResources().getDimension(p.V);
        float dimension2 = getResources().getDimension(p.W);
        this.f18343e = dimension2;
        this.f18339a = dimension;
        this.f18340b = getHeight() - this.f18343e;
        this.f18341c = dimension;
        this.f18342d = getWidth() - dimension2;
        int i11 = this.f18354p;
        if (i11 > 0) {
            int i12 = 0;
            if (i11 == 1) {
                this.f18355q = 48;
                this.f18346h = getResources().getStringArray(m.f26439a);
                this.f18357s = getResources().getDimensionPixelSize(p.U);
                float dimensionPixelSize = getResources().getDimensionPixelSize(p.f26498b0);
                this.f18356r = dimensionPixelSize;
                float f17 = this.f18342d;
                float f18 = this.f18341c;
                float f19 = this.f18357s;
                float length = (((f17 - f18) - (f19 * 2.0f)) - dimensionPixelSize) / strArr.length;
                f10 = (((f17 - f18) - (f19 * 2.0f)) - dimensionPixelSize) / 48.0f;
                this.f18347i = new float[this.f18346h.length];
                while (true) {
                    float[] fArr = this.f18347i;
                    if (i12 >= fArr.length) {
                        break;
                    }
                    fArr[i12] = this.f18341c + this.f18357s + (this.f18356r / 2.0f) + (i12 * length);
                    i12++;
                }
            } else if (i11 == 2) {
                this.f18357s = 0.0f;
                this.f18356r = getResources().getDimensionPixelSize(p.Y);
                this.f18355q = 7;
                String[] stringArray = getResources().getStringArray(m.f26441c);
                this.f18346h = stringArray;
                float f20 = this.f18342d;
                float f21 = this.f18341c;
                float length2 = (f20 - f21) / stringArray.length;
                f10 = (f20 - f21) / 7.0f;
                this.f18347i = new float[stringArray.length];
                while (true) {
                    float[] fArr2 = this.f18347i;
                    if (i12 >= fArr2.length) {
                        break;
                    }
                    fArr2[i12] = this.f18341c + (i12 * length2);
                    i12++;
                }
            } else if (i11 == 3) {
                this.f18357s = getResources().getDimensionPixelSize(p.U);
                this.f18356r = getResources().getDimensionPixelSize(p.T);
                this.f18346h = getResources().getStringArray(m.f26440b);
                if (this.f18359u < 0) {
                    this.f18359u = System.currentTimeMillis();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.f18359u);
                int i13 = calendar.get(1);
                int i14 = calendar.get(2);
                if ((i13 % 4 == 0 && i13 % 100 != 0) || i13 % AGCServerException.AUTHENTICATION_INVALID == 0) {
                    this.f18345g[1] = 29;
                }
                int i15 = this.f18345g[i14];
                this.f18355q = i15;
                if (i15 == 28) {
                    String[] strArr2 = this.f18346h;
                    strArr2[strArr2.length - 1] = String.format(getResources().getString(u.Q3), 28);
                }
                float f22 = (((this.f18342d - this.f18341c) - (this.f18357s * 2.0f)) - this.f18356r) / this.f18355q;
                this.f18347i = new float[this.f18346h.length];
                while (true) {
                    float[] fArr3 = this.f18347i;
                    if (i12 >= fArr3.length) {
                        break;
                    }
                    if (i12 == fArr3.length - 1 && this.f18355q == 28) {
                        fArr3[i12] = (this.f18342d - this.f18357s) - (this.f18356r / 2.0f);
                    } else {
                        fArr3[i12] = this.f18341c + this.f18357s + (this.f18356r / 2.0f) + (f22 * 7.0f * i12);
                    }
                    i12++;
                }
                f10 = f22;
            } else {
                f10 = 0.0f;
            }
            a aVar = this.f18358t;
            if (aVar != null) {
                List<a.b> list = aVar.f18364b;
                this.f18363y.setStrokeWidth(this.f18356r);
                for (a.b bVar : list) {
                    Path path = new Path();
                    int i16 = this.f18354p;
                    if (i16 == 1) {
                        f16 = this.f18341c + this.f18357s + (this.f18356r / 2.0f);
                        i10 = bVar.f18374e;
                    } else if (i16 == 2) {
                        f16 = this.f18341c + (f10 / 2.0f);
                        i10 = bVar.f18374e;
                    } else if (i16 == 3) {
                        f16 = this.f18341c + this.f18357s + (this.f18356r / 2.0f);
                        i10 = bVar.f18374e;
                    } else {
                        f11 = 0.0f;
                        f12 = bVar.f18372c;
                        if (f12 < 120.0f) {
                            f13 = this.f18339a;
                        } else {
                            float f23 = this.f18340b;
                            f13 = f23 - (((f23 - this.f18339a) * f12) / 120.0f);
                        }
                        f14 = bVar.f18373d;
                        if (f14 >= 0.0f) {
                            f15 = this.f18340b;
                        } else {
                            float f24 = this.f18340b;
                            f15 = f24 - (((f24 - this.f18339a) * f14) / 120.0f);
                        }
                        path.moveTo(f11, f13);
                        path.lineTo(f11, f15);
                        bVar.f18375f = path;
                    }
                    f11 = f16 + (i10 * f10);
                    f12 = bVar.f18372c;
                    if (f12 < 120.0f) {
                    }
                    f14 = bVar.f18373d;
                    if (f14 >= 0.0f) {
                    }
                    path.moveTo(f11, f13);
                    path.lineTo(f11, f15);
                    bVar.f18375f = path;
                }
                float f25 = this.f18358t.f18365c.f18369d;
                this.f18353o = f25;
                float f26 = this.f18340b;
                this.f18352n = f26 - (((f26 - this.f18339a) * f25) / 120.0f);
            }
        }
    }

    private void b() {
        this.f18349k = getResources().getDimensionPixelSize(p.R);
        this.f18348j = getResources().getDimensionPixelSize(p.S);
        getResources().getDimensionPixelSize(p.f26505f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        Paint paint = this.f18360v;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        float f10 = dimensionPixelSize;
        this.f18360v.setStrokeWidth(f10);
        this.f18360v.setStyle(Paint.Style.FILL);
        this.f18361w.setStyle(Paint.Style.STROKE);
        this.f18361w.setStrokeWidth(f10);
        this.f18362x.setColor(getResources().getColor(i10));
        this.f18362x.setTextAlign(Paint.Align.LEFT);
        this.f18362x.setTextSize(getResources().getDimension(p.X));
        this.f18362x.setStyle(Paint.Style.FILL);
        this.f18363y.setStrokeCap(Paint.Cap.ROUND);
        this.f18363y.setStyle(Paint.Style.STROKE);
        this.f18363y.setColor(getResources().getColor(o.f26474o));
        String valueOf = String.valueOf(24);
        this.f18362x.getTextBounds(valueOf, 0, valueOf.length(), this.f18350l);
    }

    private void c(Canvas canvas) {
        Paint paint = this.f18361w;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        this.f18361w.setPathEffect(this.f18351m);
        if (this.f18354p != 3) {
            float f10 = this.f18341c;
            canvas.drawLine(f10, this.f18339a, f10, this.f18340b + (this.f18343e / 2.0f), this.f18361w);
        }
        float f11 = this.f18342d;
        canvas.drawLine(f11, this.f18339a, f11, this.f18354p == 3 ? this.f18340b : this.f18340b + (this.f18343e / 2.0f), this.f18361w);
        this.f18362x.setColor(getResources().getColor(i10));
        this.f18362x.setTextAlign(Paint.Align.LEFT);
        float f12 = (this.f18340b - this.f18339a) / 4.0f;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int[] iArr = this.f18344f;
            if (i12 >= iArr.length) {
                break;
            }
            float f13 = this.f18339a + (i12 * f12);
            float height = (this.f18354p == 3 && i12 == iArr.length - 1) ? f13 : (this.f18350l.height() / 2) + f13;
            canvas.drawLine(this.f18341c, f13, this.f18342d, f13, this.f18360v);
            canvas.drawText(String.valueOf(this.f18344f[i12]), this.f18342d + this.f18349k, height, this.f18362x);
            i12++;
        }
        if (this.f18347i != null) {
            while (true) {
                float[] fArr = this.f18347i;
                if (i11 < fArr.length) {
                    int i13 = this.f18354p;
                    if (i13 == 1) {
                        if (i11 != 0) {
                            canvas.drawLine(fArr[i11], this.f18339a, fArr[i11], (this.f18343e / 2.0f) + this.f18340b, this.f18361w);
                        }
                        canvas.drawText(this.f18346h[i11], this.f18347i[i11] + this.f18349k, this.f18340b + this.f18348j + this.f18350l.height(), this.f18362x);
                    } else if (i13 == 2) {
                        if (i11 != 0) {
                            canvas.drawLine(fArr[i11], this.f18339a, fArr[i11], (this.f18343e / 2.0f) + this.f18340b, this.f18361w);
                        }
                        this.f18362x.setTextAlign(Paint.Align.CENTER);
                        canvas.drawText(this.f18346h[i11], this.f18347i[i11] + (((this.f18342d - this.f18341c) / 7.0f) / 2.0f), this.f18340b + this.f18348j + this.f18350l.height(), this.f18362x);
                    } else if (i13 == 3) {
                        canvas.drawLine(fArr[i11], this.f18339a, fArr[i11], (this.f18343e / 2.0f) + this.f18340b, this.f18361w);
                        canvas.drawText(this.f18346h[i11], this.f18347i[i11] + this.f18349k, this.f18340b + this.f18348j + this.f18350l.height(), this.f18362x);
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public void d(a aVar, int i10) {
        this.f18358t = aVar;
        this.f18354p = i10;
        this.f18359u = aVar != null ? aVar.f27853a : System.currentTimeMillis();
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        if (this.f18352n > 0.0f) {
            Paint paint = this.f18361w;
            Resources resources = getResources();
            int i10 = o.f26472n;
            paint.setColor(resources.getColor(i10));
            this.f18361w.setPathEffect(this.f18351m);
            float f10 = this.f18341c;
            float f11 = this.f18352n;
            canvas.drawLine(f10, f11, this.f18342d, f11, this.f18361w);
            this.f18362x.setColor(getResources().getColor(i10));
            this.f18362x.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(String.valueOf(Math.round(this.f18353o)), this.f18342d + this.f18349k, this.f18352n + (this.f18350l.height() / 2), this.f18362x);
        }
        a aVar = this.f18358t;
        if (aVar != null) {
            for (a.b bVar : aVar.f18364b) {
                canvas.drawPath(bVar.f18375f, this.f18363y);
            }
            return;
        }
        this.f18362x.setTextAlign(Paint.Align.CENTER);
        this.f18362x.setColor(getResources().getColor(o.f26458g));
        canvas.drawText(getResources().getString(u.N2), getWidth() / 2, (this.f18340b - this.f18339a) / 2.0f, this.f18362x);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public NoiseDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18344f = new int[]{120, 90, 60, 30, 0};
        this.f18345g = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        this.f18350l = new Rect();
        this.f18351m = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f18352n = -1.0f;
        this.f18353o = -1.0f;
        this.f18354p = -1;
        this.f18359u = -1L;
        this.f18360v = new Paint(1);
        this.f18361w = new Paint(1);
        this.f18362x = new Paint(1);
        this.f18363y = new Paint(1);
        b();
    }
}
