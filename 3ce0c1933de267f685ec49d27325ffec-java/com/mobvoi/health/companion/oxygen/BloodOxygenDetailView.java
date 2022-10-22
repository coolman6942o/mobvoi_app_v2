package com.mobvoi.health.companion.oxygen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.health.companion.oxygen.a;
import fg.m;
import fg.o;
import fg.p;
import fg.u;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class BloodOxygenDetailView extends View {
    private Paint A;

    /* renamed from: a  reason: collision with root package name */
    private float f18389a;

    /* renamed from: b  reason: collision with root package name */
    private float f18390b;

    /* renamed from: c  reason: collision with root package name */
    private float f18391c;

    /* renamed from: d  reason: collision with root package name */
    private float f18392d;

    /* renamed from: e  reason: collision with root package name */
    private float f18393e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f18394f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f18395g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f18396h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f18397i;

    /* renamed from: j  reason: collision with root package name */
    private float f18398j;

    /* renamed from: k  reason: collision with root package name */
    private float f18399k;

    /* renamed from: l  reason: collision with root package name */
    private float f18400l;

    /* renamed from: m  reason: collision with root package name */
    private Rect f18401m;

    /* renamed from: n  reason: collision with root package name */
    private PointF f18402n;

    /* renamed from: o  reason: collision with root package name */
    private PointF f18403o;

    /* renamed from: p  reason: collision with root package name */
    private int f18404p;

    /* renamed from: q  reason: collision with root package name */
    private int f18405q;

    /* renamed from: r  reason: collision with root package name */
    private float f18406r;

    /* renamed from: s  reason: collision with root package name */
    private float f18407s;

    /* renamed from: t  reason: collision with root package name */
    private a f18408t;

    /* renamed from: u  reason: collision with root package name */
    private long f18409u;

    /* renamed from: v  reason: collision with root package name */
    private DashPathEffect f18410v;

    /* renamed from: w  reason: collision with root package name */
    private Paint f18411w;

    /* renamed from: x  reason: collision with root package name */
    private Paint f18412x;

    /* renamed from: y  reason: collision with root package name */
    private Paint f18413y;

    /* renamed from: z  reason: collision with root package name */
    private Paint f18414z;

    public BloodOxygenDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        float f10;
        float f11;
        float f12;
        float f13;
        float abs;
        float f14;
        float f15;
        float f16;
        a.C0215a aVar;
        a.C0215a aVar2;
        float f17;
        int i10;
        String[] strArr;
        float dimension = getResources().getDimension(p.V);
        float dimension2 = getResources().getDimension(p.W);
        this.f18393e = dimension2;
        this.f18389a = dimension;
        this.f18390b = getHeight() - this.f18393e;
        this.f18391c = dimension;
        this.f18392d = getWidth() - dimension2;
        int i11 = this.f18404p;
        if (i11 > 0) {
            int i12 = 2;
            if (i11 == 1) {
                this.f18405q = 24;
                this.f18396h = getResources().getStringArray(m.f26439a);
                this.f18407s = getResources().getDimensionPixelSize(p.U);
                float dimensionPixelSize = getResources().getDimensionPixelSize(p.T);
                this.f18406r = dimensionPixelSize;
                float f18 = this.f18392d;
                float f19 = this.f18391c;
                float f20 = this.f18407s;
                float length = (((f18 - f19) - (f20 * 2.0f)) - dimensionPixelSize) / strArr.length;
                f10 = (((f18 - f19) - (f20 * 2.0f)) - dimensionPixelSize) / 24.0f;
                this.f18397i = new float[this.f18396h.length];
                int i13 = 0;
                while (true) {
                    float[] fArr = this.f18397i;
                    if (i13 >= fArr.length) {
                        break;
                    }
                    fArr[i13] = this.f18391c + this.f18407s + (this.f18406r / 2.0f) + (i13 * length);
                    i13++;
                }
            } else if (i11 == 2) {
                this.f18407s = 0.0f;
                this.f18406r = getResources().getDimensionPixelSize(p.Y);
                this.f18405q = 7;
                String[] stringArray = getResources().getStringArray(m.f26441c);
                this.f18396h = stringArray;
                float f21 = this.f18392d;
                float f22 = this.f18391c;
                float length2 = (f21 - f22) / stringArray.length;
                f10 = (f21 - f22) / 7.0f;
                this.f18397i = new float[stringArray.length];
                int i14 = 0;
                while (true) {
                    float[] fArr2 = this.f18397i;
                    if (i14 >= fArr2.length) {
                        break;
                    }
                    fArr2[i14] = this.f18391c + (i14 * length2);
                    i14++;
                }
            } else if (i11 == 3) {
                this.f18407s = getResources().getDimensionPixelSize(p.U);
                this.f18406r = getResources().getDimensionPixelSize(p.T);
                this.f18396h = getResources().getStringArray(m.f26440b);
                if (this.f18409u < 0) {
                    this.f18409u = System.currentTimeMillis();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.f18409u);
                int i15 = calendar.get(1);
                int i16 = calendar.get(2);
                if ((i15 % 4 == 0 && i15 % 100 != 0) || i15 % AGCServerException.AUTHENTICATION_INVALID == 0) {
                    this.f18395g[1] = 29;
                }
                int i17 = this.f18395g[i16];
                this.f18405q = i17;
                if (i17 == 28) {
                    String[] strArr2 = this.f18396h;
                    strArr2[strArr2.length - 1] = String.format(getResources().getString(u.Q3), 28);
                }
                float f23 = (((this.f18392d - this.f18391c) - (this.f18407s * 2.0f)) - this.f18406r) / this.f18405q;
                this.f18397i = new float[this.f18396h.length];
                int i18 = 0;
                while (true) {
                    float[] fArr3 = this.f18397i;
                    if (i18 >= fArr3.length) {
                        break;
                    }
                    if (i18 == fArr3.length - 1 && this.f18405q == 28) {
                        fArr3[i18] = (this.f18392d - this.f18407s) - (this.f18406r / 2.0f);
                    } else {
                        fArr3[i18] = this.f18391c + this.f18407s + (this.f18406r / 2.0f) + (f23 * 7.0f * i18);
                    }
                    i18++;
                }
                f10 = f23;
            } else {
                f10 = 0.0f;
            }
            a aVar3 = this.f18408t;
            if (aVar3 != null) {
                float f24 = aVar3.f18416c.f18421e;
                int i19 = 5;
                while (f24 < this.f18394f[3]) {
                    i19 += 5;
                    for (int i20 = 0; i20 < 4; i20++) {
                        this.f18394f[i20] = 100 - (i20 * i19);
                    }
                }
                List<a.b> list = this.f18408t.f18415b;
                this.f18414z.setStrokeWidth(this.f18406r);
                for (a.b bVar : list) {
                    Path path = new Path();
                    int i21 = this.f18404p;
                    if (i21 == 1) {
                        f17 = this.f18391c + this.f18407s + (this.f18406r / 2.0f);
                        i10 = bVar.f18426c;
                    } else if (i21 == i12) {
                        f17 = this.f18391c + (f10 / 2.0f);
                        i10 = bVar.f18426c;
                    } else if (i21 == 3) {
                        f17 = this.f18391c + this.f18407s + (this.f18406r / 2.0f);
                        i10 = bVar.f18426c;
                    } else {
                        f11 = 0.0f;
                        float f25 = this.f18394f[3];
                        f12 = bVar.f18424a;
                        if (f12 < 100.0f) {
                            f13 = this.f18389a;
                        } else {
                            float f26 = this.f18390b;
                            f13 = f26 - (((f26 - this.f18389a) * (f12 - f25)) / (100.0f - f25));
                        }
                        float f27 = this.f18390b;
                        float f28 = f27 - (((f27 - this.f18389a) * (bVar.f18425b - f25)) / (100.0f - f25));
                        abs = Math.abs(f13 - f28);
                        f14 = this.f18406r;
                        if (abs > f14 / 2.0f) {
                            f16 = Math.max(f13, f28);
                            float f29 = this.f18406r;
                            float f30 = this.f18389a;
                            if (f16 - (f29 / 2.0f) < f30) {
                                f16 = f30 + (f29 / 2.0f);
                            }
                            f15 = f16;
                        } else {
                            f16 = (f14 / 2.0f) + f13;
                            f15 = f28 - (f14 / 2.0f);
                        }
                        path.moveTo(f11, f16);
                        path.lineTo(f11, f15);
                        bVar.f18427d = path;
                        aVar = this.f18408t.f18416c;
                        if (aVar.f18418b == bVar.f18426c && aVar.f18420d == bVar.f18424a) {
                            this.f18402n = new PointF(f11, f16);
                        }
                        aVar2 = this.f18408t.f18416c;
                        if (aVar2.f18419c == bVar.f18426c && aVar2.f18421e == bVar.f18425b) {
                            this.f18403o = new PointF(f11, f15);
                        }
                        i12 = 2;
                    }
                    f11 = f17 + (i10 * f10);
                    float f252 = this.f18394f[3];
                    f12 = bVar.f18424a;
                    if (f12 < 100.0f) {
                    }
                    float f272 = this.f18390b;
                    float f282 = f272 - (((f272 - this.f18389a) * (bVar.f18425b - f252)) / (100.0f - f252));
                    abs = Math.abs(f13 - f282);
                    f14 = this.f18406r;
                    if (abs > f14 / 2.0f) {
                    }
                    path.moveTo(f11, f16);
                    path.lineTo(f11, f15);
                    bVar.f18427d = path;
                    aVar = this.f18408t.f18416c;
                    if (aVar.f18418b == bVar.f18426c) {
                        this.f18402n = new PointF(f11, f16);
                    }
                    aVar2 = this.f18408t.f18416c;
                    if (aVar2.f18419c == bVar.f18426c) {
                        this.f18403o = new PointF(f11, f15);
                    }
                    i12 = 2;
                }
            }
        }
    }

    private void b() {
        this.f18399k = getResources().getDimensionPixelSize(p.R);
        this.f18398j = getResources().getDimensionPixelSize(p.S);
        this.f18400l = getResources().getDimensionPixelSize(p.f26505f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        Paint paint = this.f18411w;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        float f10 = dimensionPixelSize;
        this.f18411w.setStrokeWidth(f10);
        this.f18411w.setStyle(Paint.Style.FILL);
        this.f18412x.setStyle(Paint.Style.STROKE);
        this.f18412x.setStrokeWidth(f10);
        this.f18413y.setColor(getResources().getColor(i10));
        this.f18413y.setTextAlign(Paint.Align.LEFT);
        this.f18413y.setTextSize(getResources().getDimension(p.X));
        this.f18413y.setStyle(Paint.Style.FILL);
        this.f18414z.setStrokeCap(Paint.Cap.ROUND);
        this.f18414z.setStyle(Paint.Style.STROKE);
        this.f18414z.setColor(getResources().getColor(o.f26470m));
        this.A.setStrokeCap(Paint.Cap.ROUND);
        this.A.setStyle(Paint.Style.FILL);
        String valueOf = String.valueOf(24);
        this.f18413y.getTextBounds(valueOf, 0, valueOf.length(), this.f18401m);
    }

    private void c(Canvas canvas) {
        float f10;
        float f11;
        float f12 = this.f18391c;
        float f13 = this.f18389a;
        canvas.drawLine(f12, f13, this.f18392d, f13, this.f18411w);
        float f14 = this.f18391c;
        float f15 = this.f18390b;
        canvas.drawLine(f14, f15, this.f18392d, f15, this.f18411w);
        Paint paint = this.f18412x;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        this.f18412x.setPathEffect(this.f18410v);
        if (this.f18404p != 3) {
            float f16 = this.f18391c;
            canvas.drawLine(f16, this.f18389a, f16, this.f18390b + (this.f18393e / 2.0f), this.f18412x);
        }
        float f17 = this.f18392d;
        canvas.drawLine(f17, this.f18389a, f17, this.f18404p == 3 ? this.f18390b : this.f18390b + (this.f18393e / 2.0f), this.f18412x);
        this.f18413y.setColor(getResources().getColor(i10));
        this.f18413y.setTextAlign(Paint.Align.LEFT);
        float f18 = (this.f18390b - this.f18389a) / 3.0f;
        for (int i11 = 1; i11 < 3; i11++) {
            float f19 = this.f18391c;
            float f20 = this.f18389a;
            float f21 = i11 * f18;
            canvas.drawLine(f19, f20 + f21, this.f18392d, f20 + f21, this.f18411w);
        }
        int i12 = 0;
        while (true) {
            int[] iArr = this.f18394f;
            if (i12 >= iArr.length) {
                break;
            }
            if (this.f18404p == 3 && i12 == iArr.length - 1) {
                f11 = this.f18389a;
                f10 = i12 * f18;
            } else {
                f11 = this.f18389a + (i12 * f18);
                f10 = this.f18401m.height() / 2;
            }
            canvas.drawText(this.f18394f[i12] + "%", this.f18392d + this.f18399k, f11 + f10, this.f18413y);
            i12++;
        }
        if (this.f18397i != null) {
            int i13 = 0;
            while (true) {
                float[] fArr = this.f18397i;
                if (i13 < fArr.length) {
                    int i14 = this.f18404p;
                    if (i14 == 1) {
                        if (i13 != 0) {
                            canvas.drawLine(fArr[i13], this.f18389a, fArr[i13], (this.f18393e / 2.0f) + this.f18390b, this.f18412x);
                        }
                        canvas.drawText(this.f18396h[i13], this.f18397i[i13] + this.f18399k, this.f18390b + this.f18398j + this.f18401m.height(), this.f18413y);
                    } else if (i14 == 2) {
                        if (i13 != 0) {
                            canvas.drawLine(fArr[i13], this.f18389a, fArr[i13], (this.f18393e / 2.0f) + this.f18390b, this.f18412x);
                        }
                        this.f18413y.setTextAlign(Paint.Align.CENTER);
                        canvas.drawText(this.f18396h[i13], this.f18397i[i13] + (((this.f18392d - this.f18391c) / 7.0f) / 2.0f), this.f18390b + this.f18398j + this.f18401m.height(), this.f18413y);
                    } else if (i14 == 3) {
                        canvas.drawLine(fArr[i13], this.f18389a, fArr[i13], (this.f18393e / 2.0f) + this.f18390b, this.f18412x);
                        canvas.drawText(this.f18396h[i13], this.f18397i[i13] + this.f18399k, this.f18390b + this.f18398j + this.f18401m.height(), this.f18413y);
                    }
                    i13++;
                } else {
                    return;
                }
            }
        }
    }

    public void d(a aVar, int i10) {
        this.f18408t = aVar;
        this.f18404p = i10;
        this.f18409u = aVar != null ? aVar.f27853a : System.currentTimeMillis();
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        a aVar = this.f18408t;
        if (aVar != null) {
            for (a.b bVar : aVar.f18415b) {
                canvas.drawPath(bVar.f18427d, this.f18414z);
            }
        } else {
            this.f18413y.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getResources().getString(u.N2), getWidth() / 2, (this.f18390b - this.f18389a) / 2.0f, this.f18413y);
        }
        if (this.f18403o != null) {
            this.A.setStrokeWidth(this.f18404p == 3 ? this.f18406r : this.f18406r + this.f18400l);
            this.A.setColor(-1);
            PointF pointF = this.f18403o;
            canvas.drawPoint(pointF.x, pointF.y, this.A);
            this.A.setColor(getResources().getColor(o.f26468l));
            this.A.setStrokeWidth(this.f18404p == 3 ? this.f18406r - 4.0f : this.f18406r);
            PointF pointF2 = this.f18403o;
            canvas.drawPoint(pointF2.x, pointF2.y, this.A);
        }
        if (this.f18402n != null) {
            this.A.setStrokeWidth(this.f18404p == 3 ? this.f18406r : this.f18406r + this.f18400l);
            this.A.setColor(-1);
            PointF pointF3 = this.f18402n;
            canvas.drawPoint(pointF3.x, pointF3.y, this.A);
            this.A.setColor(getResources().getColor(o.f26466k));
            this.A.setStrokeWidth(this.f18404p == 3 ? this.f18406r - 4.0f : this.f18406r);
            PointF pointF4 = this.f18402n;
            canvas.drawPoint(pointF4.x, pointF4.y, this.A);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public BloodOxygenDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18394f = new int[]{100, 95, 90, 85};
        this.f18395g = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        this.f18401m = new Rect();
        this.f18404p = -1;
        this.f18409u = -1L;
        this.f18410v = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f18411w = new Paint(1);
        this.f18412x = new Paint(1);
        this.f18413y = new Paint(1);
        this.f18414z = new Paint(1);
        this.A = new Paint(1);
        b();
    }
}
