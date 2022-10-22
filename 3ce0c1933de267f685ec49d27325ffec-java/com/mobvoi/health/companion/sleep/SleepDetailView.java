package com.mobvoi.health.companion.sleep;

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
import com.mobvoi.health.companion.sleep.c;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import com.mobvoi.wear.util.LogCleaner;
import fg.m;
import fg.o;
import fg.p;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import og.u;
/* loaded from: classes2.dex */
public class SleepDetailView extends View {
    private static final long F = u.D * 2;
    private int A;
    private Paint B;
    private Paint C;
    private Paint D;
    private Paint E;

    /* renamed from: a  reason: collision with root package name */
    private float f18563a;

    /* renamed from: b  reason: collision with root package name */
    private float f18564b;

    /* renamed from: c  reason: collision with root package name */
    private float f18565c;

    /* renamed from: d  reason: collision with root package name */
    private float f18566d;

    /* renamed from: e  reason: collision with root package name */
    private float f18567e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f18568f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f18569g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f18570h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f18571i;

    /* renamed from: j  reason: collision with root package name */
    private float f18572j;

    /* renamed from: k  reason: collision with root package name */
    private float f18573k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f18574l;

    /* renamed from: m  reason: collision with root package name */
    private DashPathEffect f18575m;

    /* renamed from: n  reason: collision with root package name */
    private float f18576n;

    /* renamed from: o  reason: collision with root package name */
    private float f18577o;

    /* renamed from: p  reason: collision with root package name */
    private long f18578p;

    /* renamed from: q  reason: collision with root package name */
    private int f18579q;

    /* renamed from: r  reason: collision with root package name */
    private int f18580r;

    /* renamed from: s  reason: collision with root package name */
    private float f18581s;

    /* renamed from: t  reason: collision with root package name */
    private float f18582t;

    /* renamed from: u  reason: collision with root package name */
    private c f18583u;

    /* renamed from: v  reason: collision with root package name */
    private long f18584v;

    /* renamed from: w  reason: collision with root package name */
    private int f18585w;

    /* renamed from: x  reason: collision with root package name */
    private int f18586x;

    /* renamed from: y  reason: collision with root package name */
    private int f18587y;

    /* renamed from: z  reason: collision with root package name */
    private int f18588z;

    public SleepDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        float f10;
        c.d dVar;
        float f11;
        long j10;
        int i10;
        float f12;
        int i11;
        int i12;
        char c10;
        float f13;
        float f14;
        float f15;
        int i13;
        String[] strArr;
        float dimension = getResources().getDimension(p.V);
        float dimension2 = getResources().getDimension(p.W);
        this.f18567e = dimension2;
        this.f18563a = dimension;
        this.f18564b = getHeight() - this.f18567e;
        this.f18565c = dimension;
        this.f18566d = getWidth() - dimension2;
        int i14 = this.f18579q;
        if (i14 > 0) {
            long j11 = 0;
            int i15 = 3;
            int i16 = 2;
            float f16 = 0.0f;
            int i17 = 1;
            float f17 = 2.0f;
            if (i14 == 1) {
                this.f18580r = 24;
                this.f18570h = getResources().getStringArray(m.f26439a);
                this.f18582t = getResources().getDimensionPixelSize(p.U);
                float dimensionPixelSize = getResources().getDimensionPixelSize(p.T);
                this.f18581s = dimensionPixelSize;
                float f18 = this.f18566d;
                float f19 = this.f18565c;
                float f20 = this.f18582t;
                float length = (((f18 - f19) - (f20 * 2.0f)) - dimensionPixelSize) / strArr.length;
                f10 = (((f18 - f19) - (f20 * 2.0f)) - dimensionPixelSize) / 24.0f;
                this.f18571i = new float[this.f18570h.length];
                int i18 = 0;
                while (true) {
                    float[] fArr = this.f18571i;
                    if (i18 >= fArr.length) {
                        break;
                    }
                    fArr[i18] = this.f18565c + this.f18582t + (this.f18581s / 2.0f) + (i18 * length);
                    i18++;
                }
            } else {
                float f21 = 7.0f;
                if (i14 == 2) {
                    this.f18582t = 0.0f;
                    this.f18581s = getResources().getDimensionPixelSize(p.Y);
                    this.f18580r = 7;
                    String[] stringArray = getResources().getStringArray(m.f26441c);
                    this.f18570h = stringArray;
                    float f22 = this.f18566d;
                    float f23 = this.f18565c;
                    float length2 = (f22 - f23) / stringArray.length;
                    f10 = (f22 - f23) / 7.0f;
                    this.f18571i = new float[stringArray.length];
                    int i19 = 0;
                    while (true) {
                        float[] fArr2 = this.f18571i;
                        if (i19 >= fArr2.length) {
                            break;
                        }
                        fArr2[i19] = this.f18565c + (i19 * length2);
                        i19++;
                    }
                } else if (i14 == 3) {
                    this.f18582t = getResources().getDimensionPixelSize(p.U);
                    this.f18581s = getResources().getDimensionPixelSize(p.T);
                    this.f18570h = getResources().getStringArray(m.f26440b);
                    if (this.f18584v < 0) {
                        this.f18584v = System.currentTimeMillis();
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(this.f18584v);
                    int i20 = calendar.get(1);
                    int i21 = calendar.get(2);
                    if ((i20 % 4 == 0 && i20 % 100 != 0) || i20 % AGCServerException.AUTHENTICATION_INVALID == 0) {
                        this.f18569g[1] = 29;
                    }
                    int i22 = this.f18569g[i21];
                    this.f18580r = i22;
                    if (i22 == 28) {
                        String[] strArr2 = this.f18570h;
                        strArr2[strArr2.length - 1] = String.format(getResources().getString(fg.u.Q3), 28);
                    }
                    f10 = (((this.f18566d - this.f18565c) - (this.f18582t * 2.0f)) - this.f18581s) / this.f18580r;
                    this.f18571i = new float[this.f18570h.length];
                    int i23 = 0;
                    while (true) {
                        float[] fArr3 = this.f18571i;
                        if (i23 >= fArr3.length) {
                            break;
                        }
                        if (i23 == fArr3.length - 1 && this.f18580r == 28) {
                            fArr3[i23] = (this.f18566d - this.f18582t) - (this.f18581s / 2.0f);
                        } else {
                            fArr3[i23] = this.f18565c + this.f18582t + (this.f18581s / 2.0f) + (f10 * f21 * i23);
                        }
                        i23++;
                        f21 = 7.0f;
                    }
                } else {
                    f10 = 0.0f;
                }
            }
            c cVar = this.f18583u;
            if (!(cVar == null || (dVar = cVar.f18623c) == null)) {
                long j12 = dVar.f18651a;
                this.f18578p = j12;
                char c11 = 4;
                if (j12 > F) {
                    int[] iArr = this.f18568f;
                    iArr[0] = 24;
                    iArr[1] = 18;
                    iArr[2] = 12;
                    iArr[3] = 6;
                } else if (j12 > TimeUnit.HOURS.toMillis(this.f18568f[0])) {
                    long j13 = this.f18578p;
                    int i24 = ((int) j13) / 3600000;
                    if (((int) (j13 % LogCleaner.ONE_HOUR)) != 0) {
                        i24++;
                    }
                    while (i24 % 4 != 0) {
                        i24++;
                    }
                    int[] iArr2 = this.f18568f;
                    iArr2[0] = i24;
                    iArr2[1] = (i24 * 3) / 4;
                    iArr2[2] = i24 / 2;
                    iArr2[3] = i24 / 4;
                }
                List<c.a> list = this.f18583u.f18622b;
                Path path = new Path();
                for (c.a aVar : list) {
                    int i25 = this.f18579q;
                    if (i25 == i17) {
                        f15 = this.f18565c + this.f18582t + (this.f18581s / f17);
                        i13 = aVar.f18631g;
                    } else if (i25 == i16) {
                        f15 = this.f18565c + (f10 / f17);
                        i13 = aVar.f18631g;
                    } else if (i25 == i15) {
                        f15 = this.f18565c + this.f18582t + (this.f18581s / f17);
                        i13 = aVar.f18631g;
                    } else {
                        f11 = f16;
                        j10 = aVar.f18630f;
                        if (j10 <= j11) {
                            long j14 = F;
                            if (j10 >= j14) {
                                aVar.f18630f = j14;
                            }
                            if (aVar.f18628d >= j14) {
                                aVar.f18628d = j14;
                            }
                            float f24 = this.f18564b;
                            float millis = f24 - (((f24 - this.f18563a) * ((float) aVar.f18630f)) / ((float) TimeUnit.HOURS.toMillis(this.f18568f[0])));
                            float f25 = this.f18564b - millis;
                            long j15 = aVar.f18630f;
                            float f26 = (((float) aVar.f18625a) * f25) / ((float) j15);
                            float f27 = (((float) aVar.f18626b) * f25) / ((float) j15);
                            float f28 = (((float) aVar.f18627c) * f25) / ((float) j15);
                            f13 = f10;
                            float f29 = (((float) aVar.f18628d) * f25) / ((float) j15);
                            ArrayList<c.C0218c> arrayList = new ArrayList();
                            if (f26 > f16) {
                                float f30 = this.f18581s;
                                if (f26 < f30 / 2.0f) {
                                    f26 = f30 / 2.0f;
                                }
                                c.C0218c cVar2 = new c.C0218c();
                                cVar2.f18648a = f26;
                                cVar2.f18649b = SleepRecord.TimeType.Awake;
                                arrayList.add(cVar2);
                            }
                            if (f27 > f16) {
                                if (arrayList.size() == 0) {
                                    float f31 = this.f18581s;
                                    if (f27 < f31 / 2.0f) {
                                        f27 = f31 / 2.0f;
                                    }
                                }
                                c.C0218c cVar3 = new c.C0218c();
                                cVar3.f18648a = f27;
                                cVar3.f18649b = SleepRecord.TimeType.Rem;
                                arrayList.add(cVar3);
                            }
                            if (f28 > f16) {
                                if (arrayList.size() == 0) {
                                    float f32 = this.f18581s;
                                    f14 = 2.0f;
                                    if (f28 < f32 / 2.0f) {
                                        f28 = f32 / 2.0f;
                                    }
                                } else {
                                    f14 = 2.0f;
                                }
                                if (f26 + f27 + f28 > f25) {
                                    f28 = ((f25 - f26) - f27) / f14;
                                }
                                c.C0218c cVar4 = new c.C0218c();
                                cVar4.f18648a = f28;
                                cVar4.f18649b = SleepRecord.TimeType.LightSleep;
                                arrayList.add(cVar4);
                            }
                            if (f29 > f16) {
                                if (arrayList.size() == 0) {
                                    float f33 = this.f18581s;
                                    if (f29 < f33 / 2.0f) {
                                        f28 = f33 / 2.0f;
                                    }
                                }
                                if (f26 + f27 + f28 + f29 > f25) {
                                    f29 = ((f25 - f26) - f27) - f28;
                                }
                                c.C0218c cVar5 = new c.C0218c();
                                cVar5.f18648a = f29;
                                cVar5.f18649b = SleepRecord.TimeType.DeepSleep;
                                arrayList.add(cVar5);
                            }
                            int size = arrayList.size();
                            float f34 = millis;
                            int i26 = 0;
                            while (i26 < arrayList.size()) {
                                path.reset();
                                c.C0218c cVar6 = (c.C0218c) arrayList.get(i26);
                                cVar6.f18650c = new Path();
                                float f35 = f34 + cVar6.f18648a;
                                if (size < 2) {
                                    float f36 = this.f18581s;
                                    path.addRoundRect(f11 - (f36 / 2.0f), f34, f11 + (f36 / 2.0f), f35, new float[]{f36 / 2.0f, f36 / 2.0f, f36 / 2.0f, f36 / 2.0f, f36 / 2.0f, f36 / 2.0f, f36 / 2.0f, f36 / 2.0f}, Path.Direction.CCW);
                                } else if (i26 == 0) {
                                    float f37 = this.f18581s;
                                    path.addRoundRect(f11 - (f37 / 2.0f), f34, f11 + (f37 / 2.0f), f35, new float[]{f37 / 2.0f, f37 / 2.0f, f37 / 2.0f, f37 / 2.0f, f16, f16, f16, f16}, Path.Direction.CCW);
                                } else if (i26 == size - 1) {
                                    float f38 = this.f18581s;
                                    path.addRoundRect(f11 - (f38 / 2.0f), f34, f11 + (f38 / 2.0f), f35, new float[]{f16, f16, f16, f16, f38 / 2.0f, f38 / 2.0f, f38 / 2.0f, f38 / 2.0f}, Path.Direction.CW);
                                } else {
                                    float f39 = this.f18581s;
                                    path.addRect(f11 - (f39 / 2.0f), f34, f11 + (f39 / 2.0f), f35, Path.Direction.CW);
                                }
                                cVar6.f18650c.addPath(path);
                                i26++;
                                f34 = f35;
                                f16 = 0.0f;
                            }
                            c10 = 4;
                            i12 = 3;
                            i11 = 2;
                            f12 = 2.0f;
                            i10 = 1;
                            for (c.C0218c cVar7 : arrayList) {
                                SleepRecord.TimeType timeType = cVar7.f18649b;
                                if (timeType == SleepRecord.TimeType.Awake) {
                                    aVar.f18632h = cVar7.f18650c;
                                } else if (timeType == SleepRecord.TimeType.Rem) {
                                    aVar.f18633i = cVar7.f18650c;
                                } else if (timeType == SleepRecord.TimeType.LightSleep) {
                                    aVar.f18634j = cVar7.f18650c;
                                } else if (timeType == SleepRecord.TimeType.DeepSleep) {
                                    aVar.f18635k = cVar7.f18650c;
                                }
                            }
                        } else {
                            i10 = i17;
                            f12 = f17;
                            i12 = 3;
                            i11 = 2;
                            c10 = c11;
                            f13 = f10;
                        }
                        f10 = f13;
                        c11 = c10;
                        i15 = i12;
                        i16 = i11;
                        f17 = f12;
                        i17 = i10;
                        j11 = 0;
                        f16 = 0.0f;
                    }
                    f11 = f15 + (i13 * f10);
                    j10 = aVar.f18630f;
                    if (j10 <= j11) {
                    }
                    f10 = f13;
                    c11 = c10;
                    i15 = i12;
                    i16 = i11;
                    f17 = f12;
                    i17 = i10;
                    j11 = 0;
                    f16 = 0.0f;
                }
                float f40 = (float) this.f18583u.f18623c.f18655e;
                this.f18577o = f40;
                float f41 = this.f18564b;
                this.f18576n = f41 - (((f41 - this.f18563a) * f40) / ((float) TimeUnit.HOURS.toMillis(this.f18568f[0])));
            }
        }
    }

    private void b() {
        Resources resources = getResources();
        this.f18585w = resources.getColor(o.f26484t);
        this.f18586x = resources.getColor(o.f26490w);
        this.f18587y = resources.getColor(o.f26488v);
        this.f18588z = resources.getColor(o.f26486u);
        this.A = resources.getColor(o.f26464j);
        this.f18573k = resources.getDimensionPixelSize(p.R);
        this.f18572j = resources.getDimensionPixelSize(p.S);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        this.B.setColor(this.A);
        float f10 = dimensionPixelSize;
        this.B.setStrokeWidth(f10);
        this.B.setStyle(Paint.Style.FILL);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(f10);
        this.D.setColor(this.A);
        this.D.setTextAlign(Paint.Align.LEFT);
        this.D.setTextSize(getResources().getDimension(p.X));
        this.D.setStyle(Paint.Style.FILL);
        this.E.setStrokeCap(Paint.Cap.ROUND);
        this.E.setStyle(Paint.Style.FILL);
        String valueOf = String.valueOf(24);
        this.D.getTextBounds(valueOf, 0, valueOf.length(), this.f18574l);
    }

    private void c(Canvas canvas) {
        float f10;
        float f11;
        this.C.setColor(this.A);
        this.C.setPathEffect(this.f18575m);
        float f12 = this.f18566d;
        canvas.drawLine(f12, this.f18563a, f12, this.f18579q == 3 ? this.f18564b : this.f18564b + (this.f18567e / 2.0f), this.C);
        if (this.f18579q == 2) {
            float f13 = this.f18565c;
            canvas.drawLine(f13, this.f18563a, f13, this.f18564b + (this.f18567e / 2.0f), this.C);
        }
        this.D.setColor(this.A);
        this.D.setTextAlign(Paint.Align.LEFT);
        float f14 = (this.f18564b - this.f18563a) / 4.0f;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f18568f;
            if (i11 >= iArr.length) {
                break;
            }
            if (this.f18579q == 3 && i11 == iArr.length - 1) {
                f11 = this.f18563a;
                f10 = i11 * f14;
            } else {
                f11 = this.f18563a + (i11 * f14);
                f10 = this.f18574l.height() / 2;
            }
            canvas.drawText(String.valueOf(this.f18568f[i11]), this.f18566d + this.f18573k, f11 + f10, this.D);
            float f15 = this.f18565c;
            float f16 = this.f18563a;
            float f17 = i11 * f14;
            canvas.drawLine(f15, f16 + f17, this.f18566d, f16 + f17, this.B);
            i11++;
        }
        if (this.f18571i != null) {
            this.C.setColor(this.A);
            this.C.setPathEffect(this.f18575m);
            while (true) {
                float[] fArr = this.f18571i;
                if (i10 < fArr.length) {
                    int i12 = this.f18579q;
                    if (i12 == 1) {
                        if (i10 != 0) {
                            canvas.drawLine(fArr[i10], this.f18563a, fArr[i10], (this.f18567e / 2.0f) + this.f18564b, this.C);
                        }
                        this.D.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(this.f18570h[i10], this.f18571i[i10] + this.f18573k, this.f18564b + this.f18572j + this.f18574l.height(), this.D);
                    } else if (i12 == 2) {
                        if (i10 != 0) {
                            canvas.drawLine(fArr[i10], this.f18563a, fArr[i10], (this.f18567e / 2.0f) + this.f18564b, this.C);
                        }
                        this.D.setTextAlign(Paint.Align.CENTER);
                        canvas.drawText(this.f18570h[i10], this.f18571i[i10] + (((this.f18566d - this.f18565c) / 7.0f) / 2.0f), this.f18564b + this.f18572j + this.f18574l.height(), this.D);
                    } else if (i12 == 3) {
                        this.D.setTextAlign(Paint.Align.LEFT);
                        float[] fArr2 = this.f18571i;
                        canvas.drawLine(fArr2[i10], this.f18563a, fArr2[i10], (this.f18567e / 2.0f) + this.f18564b, this.C);
                        canvas.drawText(this.f18570h[i10], this.f18571i[i10] + this.f18573k, this.f18564b + this.f18572j + this.f18574l.height(), this.D);
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void d(c cVar, int i10) {
        this.f18583u = cVar;
        this.f18579q = i10;
        this.f18584v = cVar != null ? cVar.f27853a : System.currentTimeMillis();
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        if (this.f18576n > 0.0f) {
            Paint paint = this.C;
            Resources resources = getResources();
            int i10 = o.f26468l;
            paint.setColor(resources.getColor(i10));
            this.C.setPathEffect(this.f18575m);
            float f10 = this.f18565c;
            float f11 = this.f18576n;
            canvas.drawLine(f10, f11, this.f18566d, f11, this.C);
            int i11 = (int) (this.f18577o / 60000.0f);
            String format = String.format(getResources().getString(fg.u.f26895g4), Integer.valueOf(i11 / 60));
            String format2 = String.format(getResources().getString(fg.u.f26925l4), Integer.valueOf(i11 % 60));
            this.D.setColor(getResources().getColor(i10));
            this.D.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(format, this.f18566d + this.f18573k, this.f18576n - (this.f18574l.height() / 2), this.D);
            canvas.drawText(format2, this.f18566d + this.f18573k, this.f18576n + this.f18574l.height(), this.D);
        }
        c cVar = this.f18583u;
        if (cVar != null) {
            List<c.a> list = cVar.f18622b;
            if (list != null) {
                for (c.a aVar : list) {
                    if (aVar.f18632h != null) {
                        this.E.setColor(this.f18585w);
                        canvas.drawPath(aVar.f18632h, this.E);
                    }
                    if (aVar.f18633i != null) {
                        this.E.setColor(this.f18586x);
                        canvas.drawPath(aVar.f18633i, this.E);
                    }
                    if (aVar.f18634j != null) {
                        this.E.setColor(this.f18587y);
                        canvas.drawPath(aVar.f18634j, this.E);
                    }
                    if (aVar.f18635k != null) {
                        this.E.setColor(this.f18588z);
                        canvas.drawPath(aVar.f18635k, this.E);
                    }
                }
                return;
            }
            return;
        }
        this.D.setTextAlign(Paint.Align.CENTER);
        this.D.setColor(getResources().getColor(o.f26458g));
        canvas.drawText(getResources().getString(fg.u.N2), getWidth() / 2, (this.f18564b - this.f18563a) / 2.0f, this.D);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public SleepDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18568f = new int[]{12, 9, 6, 3, 0};
        this.f18569g = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        this.f18574l = new Rect();
        this.f18575m = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f18576n = -1.0f;
        this.f18577o = -1.0f;
        this.f18579q = -1;
        this.f18584v = -1L;
        this.B = new Paint(1);
        this.C = new Paint(1);
        this.D = new Paint(1);
        this.E = new Paint(1);
        b();
    }
}
