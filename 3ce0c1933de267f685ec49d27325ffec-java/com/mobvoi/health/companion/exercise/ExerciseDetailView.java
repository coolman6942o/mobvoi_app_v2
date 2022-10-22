package com.mobvoi.health.companion.exercise;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.health.companion.provider.Recorder;
import fg.m;
import fg.o;
import fg.p;
import fg.u;
import fg.w;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class ExerciseDetailView extends View {
    private float A;
    private int B;
    private int C;
    private List<Recorder.Item> D;
    private List<a> E;
    private int F;

    /* renamed from: a  reason: collision with root package name */
    private float f18155a;

    /* renamed from: b  reason: collision with root package name */
    private float f18156b;

    /* renamed from: c  reason: collision with root package name */
    private float f18157c;

    /* renamed from: d  reason: collision with root package name */
    private float f18158d;

    /* renamed from: e  reason: collision with root package name */
    private float f18159e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f18160f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f18161g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f18162h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f18163i;

    /* renamed from: j  reason: collision with root package name */
    private float f18164j;

    /* renamed from: k  reason: collision with root package name */
    private float f18165k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f18166l;

    /* renamed from: m  reason: collision with root package name */
    private DashPathEffect f18167m;

    /* renamed from: n  reason: collision with root package name */
    private int f18168n;

    /* renamed from: o  reason: collision with root package name */
    private float f18169o;

    /* renamed from: p  reason: collision with root package name */
    private float f18170p;

    /* renamed from: q  reason: collision with root package name */
    private float f18171q;

    /* renamed from: r  reason: collision with root package name */
    private Paint f18172r;

    /* renamed from: s  reason: collision with root package name */
    private Paint f18173s;

    /* renamed from: t  reason: collision with root package name */
    private Paint f18174t;

    /* renamed from: u  reason: collision with root package name */
    private Paint f18175u;

    /* renamed from: v  reason: collision with root package name */
    private Paint f18176v;

    /* renamed from: w  reason: collision with root package name */
    private int f18177w;

    /* renamed from: x  reason: collision with root package name */
    private int f18178x;

    /* renamed from: y  reason: collision with root package name */
    private long f18179y;

    /* renamed from: z  reason: collision with root package name */
    private int f18180z;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Path f18181a;

        /* renamed from: b  reason: collision with root package name */
        public LinearGradient f18182b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f18183c;

        public a(Path path, LinearGradient linearGradient, boolean z10) {
            this.f18181a = path;
            this.f18182b = linearGradient;
            this.f18183c = z10;
        }
    }

    public ExerciseDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        float f10;
        float abs;
        float f11;
        float f12;
        float f13;
        int i10;
        float dimension = getResources().getDimension(p.f26509h);
        int i11 = 1;
        float dimension2 = this.f18178x == 1 ? dimension : getResources().getDimension(p.f26513j);
        float dimension3 = getResources().getDimension(p.f26515k);
        this.f18159e = getResources().getDimension(p.f26513j);
        this.f18155a = dimension3;
        this.f18156b = getHeight() - this.f18159e;
        this.f18157c = dimension;
        this.f18158d = getWidth() - dimension2;
        float f14 = 0.0f;
        this.f18171q = 0.0f;
        int i12 = this.f18178x;
        int i13 = 3;
        if (i12 == 1) {
            this.f18168n = 48;
            this.f18162h = getResources().getStringArray(m.f26439a);
            this.f18170p = getResources().getDimensionPixelSize(p.U);
            float dimensionPixelSize = getResources().getDimensionPixelSize(p.f26507g);
            this.f18169o = dimensionPixelSize;
            float f15 = this.f18158d;
            float f16 = this.f18157c;
            float f17 = this.f18170p;
            float f18 = ((f15 - f16) - (f17 * 2.0f)) - dimensionPixelSize;
            float f19 = f16 + f17 + (dimensionPixelSize / 2.0f);
            this.f18171q = f18 / (this.f18168n - 1);
            this.f18163i = new float[this.f18162h.length];
            int i14 = 0;
            while (true) {
                float[] fArr = this.f18163i;
                if (i14 >= fArr.length) {
                    break;
                }
                fArr[i14] = (this.f18171q * i14 * 12.0f) + f19;
                i14++;
            }
        } else if (i12 == 2) {
            this.f18170p = 0.0f;
            this.f18169o = getResources().getDimensionPixelSize(p.f26517l);
            this.f18168n = 7;
            String[] stringArray = getResources().getStringArray(m.f26441c);
            this.f18162h = stringArray;
            float f20 = this.f18158d;
            float f21 = this.f18157c;
            float length = (f20 - f21) / stringArray.length;
            this.f18171q = (f20 - f21) / this.f18168n;
            this.f18163i = new float[stringArray.length];
            int i15 = 0;
            while (true) {
                float[] fArr2 = this.f18163i;
                if (i15 >= fArr2.length) {
                    break;
                }
                fArr2[i15] = this.f18157c + (i15 * length);
                i15++;
            }
        } else if (i12 == 3) {
            this.f18170p = getResources().getDimensionPixelSize(p.U);
            this.f18169o = getResources().getDimensionPixelSize(p.f26511i);
            this.f18162h = getResources().getStringArray(m.f26440b);
            if (this.f18179y < 0) {
                this.f18179y = System.currentTimeMillis();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.f18179y);
            int i16 = calendar.get(1);
            int i17 = calendar.get(2);
            if ((i16 % 4 == 0 && i16 % 100 != 0) || i16 % AGCServerException.AUTHENTICATION_INVALID == 0) {
                this.f18161g[1] = 29;
            }
            int i18 = this.f18161g[i17];
            this.f18168n = i18;
            if (i18 == 28) {
                String[] strArr = this.f18162h;
                strArr[strArr.length - 1] = String.format(getResources().getString(u.Q3), 28);
            }
            float f22 = (((this.f18158d - this.f18157c) - (this.f18170p * 2.0f)) - this.f18169o) / this.f18168n;
            this.f18171q = f22;
            this.f18163i = new float[this.f18162h.length];
            int i19 = 0;
            while (true) {
                float[] fArr3 = this.f18163i;
                if (i19 >= fArr3.length) {
                    break;
                }
                if (i19 == fArr3.length - 1 && this.f18168n == 28) {
                    fArr3[i19] = (this.f18158d - this.f18170p) - (this.f18169o / 2.0f);
                } else {
                    fArr3[i19] = this.f18157c + this.f18170p + (this.f18169o / 2.0f) + (7.0f * f22 * i19);
                }
                i19++;
            }
        }
        this.f18175u.setStrokeWidth(this.f18169o);
        int i20 = this.f18177w;
        int i21 = i20 == 0 ? AGCServerException.UNKNOW_EXCEPTION : 1 == i20 ? 5 : 3;
        int max = this.f18178x == 1 ? this.F : Math.max(this.f18180z, this.F);
        if (max > this.f18160f[0]) {
            int i22 = max / i21;
            if (max % i21 != 0) {
                i22++;
            }
            while (i22 % 4 != 0) {
                i22++;
            }
            int i23 = i22 * i21;
            int[] iArr = this.f18160f;
            iArr[0] = i23;
            iArr[1] = (i23 * 3) / 4;
            iArr[2] = i23 / 2;
            iArr[3] = i23 / 4;
        }
        this.E.clear();
        if (this.D != null) {
            int i24 = 0;
            while (i24 < this.D.size()) {
                Recorder.Item item = this.D.get(i24);
                if (item.value > 0) {
                    Path path = new Path();
                    int i25 = this.f18178x;
                    if (i25 == i11) {
                        f12 = this.f18157c + this.f18170p + (this.f18169o / 2.0f);
                        f13 = this.f18171q;
                        i10 = item.time;
                    } else if (i25 == 2) {
                        float f23 = this.f18157c;
                        f13 = this.f18171q;
                        f12 = f23 + (f13 / 2.0f);
                        i10 = item.time;
                    } else if (i25 == i13) {
                        f12 = this.f18157c + this.f18170p + (this.f18169o / 2.0f);
                        f13 = this.f18171q;
                        i10 = item.time;
                    } else {
                        f10 = f14;
                        float f24 = this.f18156b;
                        float f25 = f24 - (((f24 - this.f18155a) * item.value) / this.f18160f[0]);
                        path.moveTo(f10, f24 - (this.f18169o / 2.0f));
                        abs = Math.abs(f25 - this.f18156b);
                        f11 = this.f18169o;
                        if (abs > f11) {
                            path.lineTo(f10, this.f18156b - (f11 / 2.0f));
                            List<a> list = this.E;
                            float f26 = this.f18156b;
                            int i26 = this.C;
                            LinearGradient linearGradient = new LinearGradient(f10, f25, f10, f26, i26, i26, Shader.TileMode.MIRROR);
                            int i27 = this.f18180z;
                            list.add(new a(path, linearGradient, i27 > 0 && item.value >= i27));
                        } else {
                            path.lineTo(f10, f25);
                            List<a> list2 = this.E;
                            LinearGradient linearGradient2 = new LinearGradient(f10, f25, f10, this.f18156b, this.B, this.C, Shader.TileMode.MIRROR);
                            int i28 = this.f18180z;
                            list2.add(new a(path, linearGradient2, i28 > 0 && item.value >= i28));
                        }
                    }
                    f10 = f12 + (f13 * i10);
                    float f242 = this.f18156b;
                    float f252 = f242 - (((f242 - this.f18155a) * item.value) / this.f18160f[0]);
                    path.moveTo(f10, f242 - (this.f18169o / 2.0f));
                    abs = Math.abs(f252 - this.f18156b);
                    f11 = this.f18169o;
                    if (abs > f11) {
                    }
                }
                i24++;
                f14 = 0.0f;
                i11 = 1;
                i13 = 3;
            }
        }
        if (this.F > 0) {
            float f27 = this.f18156b;
            this.A = f27 - (((f27 - this.f18155a) * this.f18180z) / this.f18160f[0]);
        }
    }

    private void b() {
        this.f18165k = getResources().getDimensionPixelSize(p.R);
        this.f18164j = getResources().getDimensionPixelSize(p.S);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        Paint paint = this.f18172r;
        Resources resources = getResources();
        int i10 = o.f26464j;
        paint.setColor(resources.getColor(i10));
        float f10 = dimensionPixelSize;
        this.f18172r.setStrokeWidth(f10);
        this.f18172r.setStyle(Paint.Style.FILL);
        this.f18173s.setStyle(Paint.Style.STROKE);
        this.f18173s.setStrokeWidth(f10);
        this.f18173s.setColor(getResources().getColor(i10));
        this.f18173s.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
        this.f18174t.setColor(getResources().getColor(i10));
        this.f18174t.setTextAlign(Paint.Align.LEFT);
        this.f18174t.setTextSize(getResources().getDimension(p.X));
        this.f18174t.setStyle(Paint.Style.FILL);
        this.f18175u.setStrokeCap(Paint.Cap.ROUND);
        this.f18175u.setStyle(Paint.Style.STROKE);
        this.f18176v.setStrokeCap(Paint.Cap.ROUND);
        this.f18176v.setStyle(Paint.Style.FILL);
        this.f18176v.setStrokeWidth(getResources().getDimensionPixelSize(p.f26507g));
        String valueOf = String.valueOf(24);
        this.f18174t.getTextBounds(valueOf, 0, valueOf.length(), this.f18166l);
        int i11 = this.f18177w;
        if (i11 == 0) {
            this.B = getResources().getColor(o.f26457f0);
            this.C = getResources().getColor(o.f26455e0);
            this.f18160f = new int[]{2000, 1500, 1000, AGCServerException.UNKNOW_EXCEPTION};
        } else if (1 == i11) {
            this.B = getResources().getColor(o.f26467k0);
            this.C = getResources().getColor(o.f26465j0);
            this.f18160f = new int[]{20, 15, 10, 5};
        } else {
            this.B = getResources().getColor(o.f26452d);
            this.C = getResources().getColor(o.f26450c);
            this.f18160f = new int[]{12, 9, 6, 3};
        }
        this.f18176v.setColor(this.C);
        this.f18176v.setAlpha(128);
    }

    private void c(Canvas canvas) {
        this.f18173s.setColor(getResources().getColor(o.f26464j));
        this.f18173s.setPathEffect(this.f18167m);
        if (this.f18178x != 3) {
            float f10 = this.f18157c;
            canvas.drawLine(f10, this.f18155a, f10, this.f18156b + (this.f18159e / 2.0f), this.f18173s);
        }
        float f11 = this.f18158d;
        canvas.drawLine(f11, this.f18155a, f11, this.f18178x == 3 ? this.f18156b : this.f18156b + (this.f18159e / 2.0f), this.f18173s);
        float f12 = (this.f18156b - this.f18155a) / 4.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            float f13 = this.f18155a + (i11 * f12);
            canvas.drawLine(this.f18157c, f13, this.f18158d, f13, this.f18172r);
        }
        float f14 = this.f18157c;
        float f15 = this.f18156b;
        canvas.drawLine(f14, f15, this.f18158d, f15, this.f18172r);
        if (this.f18163i != null) {
            this.f18174t.setColor(getResources().getColor(o.f26464j));
            while (true) {
                float[] fArr = this.f18163i;
                if (i10 >= fArr.length) {
                    break;
                }
                int i12 = this.f18178x;
                if (i12 == 1) {
                    if (i10 != 0) {
                        canvas.drawLine(fArr[i10], this.f18155a, fArr[i10], (this.f18159e / 2.0f) + this.f18156b, this.f18173s);
                    }
                    this.f18174t.setTextAlign(Paint.Align.LEFT);
                    canvas.drawText(this.f18162h[i10], this.f18163i[i10] + this.f18165k, this.f18156b + this.f18164j + this.f18166l.height(), this.f18174t);
                } else if (i12 == 2) {
                    if (i10 != 0) {
                        canvas.drawLine(fArr[i10], this.f18155a, fArr[i10], (this.f18159e / 2.0f) + this.f18156b, this.f18173s);
                    }
                    this.f18174t.setTextAlign(Paint.Align.CENTER);
                    canvas.drawText(this.f18162h[i10], this.f18163i[i10] + (((this.f18158d - this.f18157c) / 7.0f) / 2.0f), this.f18156b + this.f18164j + this.f18166l.height(), this.f18174t);
                } else if (i12 == 3) {
                    canvas.drawLine(fArr[i10], this.f18155a, fArr[i10], (this.f18159e / 2.0f) + this.f18156b, this.f18173s);
                    this.f18174t.setTextAlign(Paint.Align.LEFT);
                    canvas.drawText(this.f18162h[i10], this.f18163i[i10] + this.f18165k, this.f18156b + this.f18164j + this.f18166l.height(), this.f18174t);
                }
                i10++;
            }
            if (this.f18178x != 1) {
                this.f18174t.setTextAlign(Paint.Align.LEFT);
                StringBuffer stringBuffer = new StringBuffer("0");
                int i13 = this.f18177w;
                if (i13 == 0) {
                    stringBuffer.append(getResources().getString(u.f26893g2));
                } else if (i13 == 1) {
                    stringBuffer.append(getResources().getString(u.f26899h2));
                } else {
                    stringBuffer.append(getResources().getString(u.f26887f2));
                }
                canvas.drawText(stringBuffer.toString(), this.f18158d + this.f18165k, this.f18156b - (this.f18166l.height() / 2), this.f18174t);
                List<a> list = this.E;
                if (list != null && list.size() > 0) {
                    this.f18174t.setColor(this.C);
                    canvas.drawText(getResources().getString(u.R3), this.f18158d + this.f18165k, this.A - this.f18164j, this.f18174t);
                    canvas.drawText(String.valueOf(this.f18180z), this.f18158d + this.f18165k, this.A + this.f18166l.height(), this.f18174t);
                }
            }
        }
    }

    public void d(List<Recorder.Item> list, int i10, int i11, long j10) {
        this.f18179y = j10;
        this.f18180z = i10;
        this.D = list;
        this.F = i11;
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f10;
        float f11;
        List<a> list;
        super.onDraw(canvas);
        c(canvas);
        if (!(this.f18178x == 1 || (list = this.E) == null || list.size() <= 0)) {
            this.f18173s.setColor(this.C);
            float f12 = this.f18157c;
            float f13 = this.A;
            canvas.drawLine(f12, f13, this.f18158d, f13, this.f18173s);
        }
        if (this.E != null) {
            if (this.f18178x == 1) {
                float f14 = 0.0f;
                for (int i10 = 0; i10 < this.f18168n; i10++) {
                    int i11 = this.f18178x;
                    if (i11 == 1) {
                        f10 = this.f18157c + this.f18170p + (this.f18169o / 2.0f);
                        f11 = this.f18171q;
                    } else if (i11 == 2) {
                        float f15 = this.f18157c;
                        f11 = this.f18171q;
                        f10 = f15 + (f11 / 2.0f);
                    } else if (i11 == 3) {
                        f10 = this.f18157c + this.f18170p + (this.f18169o / 2.0f);
                        f11 = this.f18171q;
                    } else {
                        canvas.drawPoint(f14, this.f18156b - (this.f18169o / 2.0f), this.f18176v);
                    }
                    f14 = f10 + (f11 * i10);
                    canvas.drawPoint(f14, this.f18156b - (this.f18169o / 2.0f), this.f18176v);
                }
            }
            for (a aVar : this.E) {
                Paint paint = this.f18175u;
                int i12 = 225;
                if (this.f18178x != 1 && !aVar.f18183c) {
                    i12 = 127;
                }
                paint.setAlpha(i12);
                this.f18175u.setShader(aVar.f18182b);
                canvas.drawPath(aVar.f18181a, this.f18175u);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public void setDateType(int i10) {
        this.f18178x = i10;
    }

    public ExerciseDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18160f = new int[]{2000, 1500, 1000, AGCServerException.UNKNOW_EXCEPTION};
        this.f18161g = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        this.f18166l = new Rect();
        this.f18167m = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f18172r = new Paint(1);
        this.f18173s = new Paint(1);
        this.f18174t = new Paint(1);
        this.f18175u = new Paint(1);
        this.f18176v = new Paint(1);
        this.f18177w = 0;
        this.f18178x = -1;
        this.f18179y = -1L;
        this.A = 0.0f;
        this.E = new ArrayList();
        this.F = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f27011a);
            try {
                this.f18177w = obtainStyledAttributes.getInt(w.f27013c, 0);
                this.f18178x = obtainStyledAttributes.getInt(w.f27012b, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        b();
    }
}
