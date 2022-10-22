package com.mobvoi.health.companion.heartrate.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.health.companion.heartrate.ui.c;
import fg.m;
import fg.o;
import fg.p;
import fg.q;
import fg.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import ng.d;
import of.h;
import rh.a;
/* loaded from: classes2.dex */
public class HeartRateDetailView extends View {
    private c A;
    private long B;
    private final List<Float> C;
    private final List<Float> D;
    private final List<d> E;
    private final List<d> F;
    private Bitmap G;
    private Rect H;
    private Rect I;
    private Bitmap J;
    private Rect K;
    private Rect L;
    private Bitmap M;
    private Rect N;
    private Rect O;
    private Bitmap P;
    private Rect Q;
    private Rect R;
    private TextPaint S;
    private final Paint T;
    private final Paint U;
    private final Paint V;
    private final Paint W;

    /* renamed from: a  reason: collision with root package name */
    private float f18233a;

    /* renamed from: b  reason: collision with root package name */
    private float f18234b;

    /* renamed from: c  reason: collision with root package name */
    private float f18235c;

    /* renamed from: d  reason: collision with root package name */
    private float f18236d;

    /* renamed from: e  reason: collision with root package name */
    private float f18237e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f18238f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f18239g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f18240h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f18241i;

    /* renamed from: j  reason: collision with root package name */
    private float f18242j;

    /* renamed from: j0  reason: collision with root package name */
    private final Paint f18243j0;

    /* renamed from: k  reason: collision with root package name */
    private float f18244k;

    /* renamed from: k0  reason: collision with root package name */
    private final Paint f18245k0;

    /* renamed from: l  reason: collision with root package name */
    private float f18246l;

    /* renamed from: l0  reason: collision with root package name */
    private Paint f18247l0;

    /* renamed from: m  reason: collision with root package name */
    private final Rect f18248m;

    /* renamed from: m0  reason: collision with root package name */
    private Paint f18249m0;

    /* renamed from: n  reason: collision with root package name */
    private PointF f18250n;

    /* renamed from: n0  reason: collision with root package name */
    private Context f18251n0;

    /* renamed from: o  reason: collision with root package name */
    private PointF f18252o;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f18253o0;

    /* renamed from: p  reason: collision with root package name */
    private final List<PointF> f18254p;

    /* renamed from: q  reason: collision with root package name */
    private final Path f18255q;

    /* renamed from: r  reason: collision with root package name */
    private final Path f18256r;

    /* renamed from: s  reason: collision with root package name */
    private final Path f18257s;

    /* renamed from: t  reason: collision with root package name */
    private float f18258t;

    /* renamed from: u  reason: collision with root package name */
    private float f18259u;

    /* renamed from: v  reason: collision with root package name */
    private final DashPathEffect f18260v;

    /* renamed from: w  reason: collision with root package name */
    private int f18261w;

    /* renamed from: x  reason: collision with root package name */
    private int f18262x;

    /* renamed from: y  reason: collision with root package name */
    private float f18263y;

    /* renamed from: z  reason: collision with root package name */
    private float f18264z;

    public HeartRateDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        float f10;
        float f11;
        float f12;
        int i10;
        float f13;
        float f14;
        int i11;
        float f15;
        float f16;
        int i12;
        float f17;
        float f18;
        int i13;
        c.a aVar;
        float f19;
        float f20;
        float f21;
        c.a aVar2;
        c.a aVar3;
        int i14;
        float f22;
        int i15;
        String[] strArr;
        float dimension = getResources().getDimension(p.V);
        float dimension2 = getResources().getDimension(p.W);
        this.f18237e = dimension2;
        this.f18233a = dimension;
        this.f18234b = getHeight() - this.f18237e;
        this.f18235c = dimension;
        this.f18236d = getWidth() - dimension2;
        int i16 = this.f18261w;
        if (i16 > 0) {
            int i17 = 3;
            float f23 = 0.0f;
            if (i16 == 1) {
                this.f18262x = 24;
                this.f18240h = getResources().getStringArray(m.f26439a);
                this.f18264z = getResources().getDimensionPixelSize(p.U);
                float dimensionPixelSize = getResources().getDimensionPixelSize(p.T);
                this.f18263y = dimensionPixelSize;
                float f24 = this.f18236d;
                float f25 = this.f18235c;
                float f26 = this.f18264z;
                float length = (((f24 - f25) - (f26 * 2.0f)) - dimensionPixelSize) / strArr.length;
                f10 = (((f24 - f25) - (f26 * 2.0f)) - dimensionPixelSize) / 24.0f;
                this.f18241i = new float[this.f18240h.length];
                int i18 = 0;
                while (true) {
                    float[] fArr = this.f18241i;
                    if (i18 >= fArr.length) {
                        break;
                    }
                    fArr[i18] = this.f18235c + this.f18264z + (this.f18263y / 2.0f) + (i18 * length);
                    i18++;
                }
            } else if (i16 == 2) {
                this.f18264z = 0.0f;
                this.f18263y = getResources().getDimensionPixelSize(p.Y);
                this.f18262x = 7;
                String[] stringArray = getResources().getStringArray(m.f26441c);
                this.f18240h = stringArray;
                float f27 = this.f18236d;
                float f28 = this.f18235c;
                float length2 = (f27 - f28) / stringArray.length;
                f10 = (f27 - f28) / 7.0f;
                this.f18241i = new float[stringArray.length];
                int i19 = 0;
                while (true) {
                    float[] fArr2 = this.f18241i;
                    if (i19 >= fArr2.length) {
                        break;
                    }
                    fArr2[i19] = this.f18235c + (i19 * length2);
                    i19++;
                }
            } else if (i16 == 3) {
                this.f18264z = getResources().getDimensionPixelSize(p.U);
                this.f18263y = getResources().getDimensionPixelSize(p.T);
                this.f18240h = getResources().getStringArray(m.f26440b);
                if (this.B < 0) {
                    this.B = System.currentTimeMillis();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.B);
                int i20 = calendar.get(1);
                int i21 = calendar.get(2);
                if ((i20 % 4 == 0 && i20 % 100 != 0) || i20 % AGCServerException.AUTHENTICATION_INVALID == 0) {
                    this.f18239g[1] = 29;
                }
                int i22 = this.f18239g[i21];
                this.f18262x = i22;
                if (i22 == 28) {
                    String[] strArr2 = this.f18240h;
                    strArr2[strArr2.length - 1] = String.format(getResources().getString(u.Q3), 28);
                }
                float f29 = (((this.f18236d - this.f18235c) - (this.f18264z * 2.0f)) - this.f18263y) / this.f18262x;
                this.f18241i = new float[this.f18240h.length];
                int i23 = 0;
                while (true) {
                    float[] fArr3 = this.f18241i;
                    if (i23 >= fArr3.length) {
                        break;
                    }
                    if (i23 == fArr3.length - 1 && this.f18262x == 28) {
                        fArr3[i23] = (this.f18236d - this.f18264z) - (this.f18263y / 2.0f);
                    } else {
                        fArr3[i23] = this.f18235c + this.f18264z + (this.f18263y / 2.0f) + (f29 * 7.0f * i23);
                    }
                    i23++;
                }
                f10 = f29;
            } else {
                f10 = 0.0f;
            }
            c cVar = this.A;
            if (cVar != null) {
                float f30 = cVar.f18273c.f18280b;
                List<a> list = cVar.f18277g;
                if (list != null && list.size() > 0) {
                    float f31 = 0.0f;
                    for (a aVar4 : this.A.f18277g) {
                        int i24 = aVar4.f33516c;
                        if (f31 < i24) {
                            f31 = i24;
                        }
                    }
                    f30 = Math.max(f30, f31 + 10.0f);
                }
                int i25 = 50;
                while (f30 > this.f18238f[0]) {
                    i25 += 10;
                    int i26 = 0;
                    while (true) {
                        int[] iArr = this.f18238f;
                        if (i26 < iArr.length) {
                            iArr[i26] = (3 - i26) * i25;
                            i26++;
                        }
                    }
                }
                List<c.b> list2 = this.A.f18272b;
                this.W.setStrokeWidth(this.f18263y);
                this.f18255q.reset();
                this.f18254p.clear();
                if (!(list2 == null || this.A.f18273c == null)) {
                    int i27 = 0;
                    for (c.b bVar : list2) {
                        Path path = new Path();
                        int i28 = this.f18261w;
                        if (i28 == 1) {
                            f22 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i15 = bVar.f18295g;
                        } else if (i28 == 2) {
                            f22 = this.f18235c + (f10 / 2.0f);
                            i15 = bVar.f18295g;
                        } else if (i28 == i17) {
                            f22 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i15 = bVar.f18295g;
                        } else {
                            f19 = f23;
                            float f32 = this.f18234b;
                            float f33 = this.f18233a;
                            float f34 = (f32 - f33) * bVar.f18291c;
                            int[] iArr2 = this.f18238f;
                            f20 = f32 - (f34 / iArr2[0]);
                            f21 = f32 - (((f32 - f33) * bVar.f18292d) / iArr2[0]);
                            path.moveTo(f19, (this.f18263y / 2.0f) + f20);
                            path.lineTo(f19, f21 - (this.f18263y / 2.0f));
                            bVar.f18296h = path;
                            aVar2 = this.A.f18273c;
                            if (aVar2.f18287i == bVar.f18295g && aVar2.f18280b == bVar.f18291c) {
                                this.f18250n = new PointF(f19, f20);
                            }
                            aVar3 = this.A.f18273c;
                            if (aVar3.f18288j == bVar.f18295g && aVar3.f18281c == bVar.f18292d) {
                                this.f18252o = new PointF(f19, f21);
                            }
                            if (this.f18261w == 2 && (i14 = bVar.f18293e) > 0) {
                                float f35 = this.f18234b;
                                float f36 = f35 - (((f35 - this.f18233a) * i14) / this.f18238f[0]);
                                this.f18254p.add(new PointF(f19, f36));
                                if (i27 != 0) {
                                    this.f18255q.moveTo(f19, f36);
                                } else {
                                    this.f18255q.lineTo(f19, f36);
                                }
                                i27++;
                            }
                            i17 = 3;
                            f23 = 0.0f;
                        }
                        f19 = f22 + (i15 * f10);
                        float f322 = this.f18234b;
                        float f332 = this.f18233a;
                        float f342 = (f322 - f332) * bVar.f18291c;
                        int[] iArr22 = this.f18238f;
                        f20 = f322 - (f342 / iArr22[0]);
                        f21 = f322 - (((f322 - f332) * bVar.f18292d) / iArr22[0]);
                        path.moveTo(f19, (this.f18263y / 2.0f) + f20);
                        path.lineTo(f19, f21 - (this.f18263y / 2.0f));
                        bVar.f18296h = path;
                        aVar2 = this.A.f18273c;
                        if (aVar2.f18287i == bVar.f18295g) {
                            this.f18250n = new PointF(f19, f20);
                        }
                        aVar3 = this.A.f18273c;
                        if (aVar3.f18288j == bVar.f18295g) {
                            this.f18252o = new PointF(f19, f21);
                        }
                        if (this.f18261w == 2) {
                            float f352 = this.f18234b;
                            float f362 = f352 - (((f352 - this.f18233a) * i14) / this.f18238f[0]);
                            this.f18254p.add(new PointF(f19, f362));
                            if (i27 != 0) {
                            }
                            i27++;
                        }
                        i17 = 3;
                        f23 = 0.0f;
                    }
                    int i29 = this.A.f18273c.f18283e;
                    float f37 = i29 == 0 ? aVar.f18284f : i29;
                    this.f18259u = f37;
                    float f38 = this.f18234b;
                    this.f18258t = f38 - (((f38 - this.f18233a) * f37) / this.f18238f[0]);
                }
                this.C.clear();
                this.D.clear();
                this.E.clear();
                this.F.clear();
                List<a> list3 = this.A.f18275e;
                if (list3 != null && list3.size() > 0) {
                    for (a aVar5 : this.A.f18275e) {
                        int i30 = this.f18261w;
                        if (i30 == 1) {
                            f18 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i13 = aVar5.f33517d;
                        } else if (i30 == 2) {
                            f18 = this.f18235c + (f10 / 2.0f);
                            i13 = aVar5.f33517d;
                        } else if (i30 == 3) {
                            f18 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i13 = aVar5.f33517d;
                        } else {
                            f17 = 0.0f;
                            this.C.add(Float.valueOf(f17));
                        }
                        f17 = f18 + (i13 * f10);
                        this.C.add(Float.valueOf(f17));
                    }
                    Paint paint = new Paint(1);
                    this.f18247l0 = paint;
                    paint.setColor(b.c(getContext(), o.f26473n0));
                    this.f18247l0.setAlpha(34);
                    this.f18247l0.setStyle(Paint.Style.STROKE);
                    this.f18247l0.setStrokeWidth(this.f18263y);
                    Bitmap b10 = b(q.f26545a0);
                    this.G = b10;
                    if (b10 != null) {
                        this.H = new Rect(0, 0, this.G.getWidth(), this.G.getHeight());
                    }
                    this.I = new Rect();
                }
                List<a> list4 = this.A.f18276f;
                if (list4 != null && list4.size() > 0) {
                    for (a aVar6 : this.A.f18276f) {
                        int i31 = this.f18261w;
                        if (i31 == 1) {
                            f16 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i12 = aVar6.f33517d;
                        } else if (i31 == 2) {
                            f16 = this.f18235c + (f10 / 2.0f);
                            i12 = aVar6.f33517d;
                        } else if (i31 == 3) {
                            f16 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i12 = aVar6.f33517d;
                        } else {
                            f15 = 0.0f;
                            this.D.add(Float.valueOf(f15));
                        }
                        f15 = f16 + (i12 * f10);
                        this.D.add(Float.valueOf(f15));
                    }
                    Paint paint2 = new Paint(1);
                    this.f18249m0 = paint2;
                    paint2.setColor(b.c(getContext(), o.f26473n0));
                    this.f18249m0.setAlpha(34);
                    this.f18249m0.setStyle(Paint.Style.STROKE);
                    this.f18249m0.setStrokeWidth(this.f18263y);
                    Bitmap b11 = b(q.f26549b0);
                    this.J = b11;
                    if (b11 != null) {
                        this.K = new Rect(0, 0, this.J.getWidth(), this.J.getHeight());
                    }
                    this.L = new Rect();
                }
                List<a> list5 = this.A.f18277g;
                if (list5 != null && list5.size() > 0) {
                    for (a aVar7 : this.A.f18277g) {
                        int i32 = this.f18261w;
                        if (i32 == 1) {
                            f14 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i11 = aVar7.f33517d;
                        } else if (i32 == 2) {
                            f14 = this.f18235c + (f10 / 2.0f);
                            i11 = aVar7.f33517d;
                        } else if (i32 == 3) {
                            f14 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i11 = aVar7.f33517d;
                        } else {
                            f13 = 0.0f;
                            float f39 = this.f18234b;
                            int i33 = aVar7.f33516c;
                            this.E.add(new d(f13, f39 - (((f39 - this.f18233a) * i33) / this.f18238f[0]), i33));
                        }
                        f13 = f14 + (i11 * f10);
                        float f392 = this.f18234b;
                        int i332 = aVar7.f33516c;
                        this.E.add(new d(f13, f392 - (((f392 - this.f18233a) * i332) / this.f18238f[0]), i332));
                    }
                    if (this.S == null) {
                        TextPaint textPaint = new TextPaint(1);
                        this.S = textPaint;
                        textPaint.setTextAlign(Paint.Align.CENTER);
                        this.S.setTextSize(getResources().getDimension(p.X));
                    }
                    Bitmap b12 = b(q.f26553c0);
                    this.M = b12;
                    if (b12 != null) {
                        this.N = new Rect(0, 0, this.M.getWidth(), this.M.getHeight());
                    }
                    this.O = new Rect();
                }
                List<a> list6 = this.A.f18278h;
                if (list6 != null && list6.size() > 0) {
                    for (a aVar8 : this.A.f18278h) {
                        int i34 = this.f18261w;
                        if (i34 == 1) {
                            f12 = this.f18235c + this.f18264z + (this.f18263y / 2.0f);
                            i10 = aVar8.f33517d;
                        } else if (i34 == 2) {
                            f12 = this.f18235c + (f10 / 2.0f);
                            i10 = aVar8.f33517d;
                        } else {
                            f11 = i34 == 3 ? this.f18235c + this.f18264z + (this.f18263y / 2.0f) + (aVar8.f33517d * f10) : 0.0f;
                            float f40 = this.f18234b;
                            int i35 = aVar8.f33516c;
                            this.F.add(new d(f11, f40 - (((f40 - this.f18233a) * i35) / this.f18238f[0]), i35));
                        }
                        f11 = f12 + (i10 * f10);
                        float f402 = this.f18234b;
                        int i352 = aVar8.f33516c;
                        this.F.add(new d(f11, f402 - (((f402 - this.f18233a) * i352) / this.f18238f[0]), i352));
                    }
                    if (this.S == null) {
                        TextPaint textPaint2 = new TextPaint(1);
                        this.S = textPaint2;
                        textPaint2.setTextAlign(Paint.Align.CENTER);
                        this.S.setTextSize(getResources().getDimension(p.X));
                    }
                    Bitmap b13 = b(q.f26557d0);
                    this.P = b13;
                    if (b13 != null) {
                        this.Q = new Rect(0, 0, this.P.getWidth(), this.P.getHeight());
                    }
                    this.R = new Rect();
                }
            }
        }
    }

    private Bitmap b(int i10) {
        Drawable e10 = b.e(getContext(), i10);
        if (e10 == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(e10.getIntrinsicWidth(), e10.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        e10.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        e10.draw(canvas);
        return createBitmap;
    }

    private void c() {
        this.f18244k = getResources().getDimensionPixelSize(p.R);
        this.f18242j = getResources().getDimensionPixelSize(p.S);
        this.f18246l = getResources().getDimensionPixelSize(p.f26505f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.O);
        Paint paint = this.T;
        Context context = getContext();
        int i10 = o.f26464j;
        paint.setColor(b.c(context, i10));
        float f10 = dimensionPixelSize;
        this.T.setStrokeWidth(f10);
        this.T.setStyle(Paint.Style.FILL);
        this.U.setStyle(Paint.Style.STROKE);
        this.U.setStrokeWidth(f10);
        this.V.setColor(b.c(getContext(), i10));
        this.V.setTextAlign(Paint.Align.LEFT);
        this.V.setTextSize(getResources().getDimension(p.X));
        this.V.setStyle(Paint.Style.FILL);
        this.W.setStrokeCap(Paint.Cap.ROUND);
        this.W.setStyle(Paint.Style.STROKE);
        this.W.setColor(b.c(getContext(), o.f26470m));
        this.f18245k0.setStyle(Paint.Style.STROKE);
        this.f18245k0.setColor(b.c(getContext(), o.f26478q));
        this.f18245k0.setStrokeWidth(getResources().getDimensionPixelSize(p.f26529r));
        this.f18243j0.setStrokeCap(Paint.Cap.ROUND);
        this.f18243j0.setStyle(Paint.Style.FILL);
        String valueOf = String.valueOf(24);
        this.V.getTextBounds(valueOf, 0, valueOf.length(), this.f18248m);
    }

    private void d(Canvas canvas) {
        float f10;
        float f11;
        Paint paint = this.U;
        Context context = getContext();
        int i10 = o.f26464j;
        paint.setColor(b.c(context, i10));
        this.U.setPathEffect(this.f18260v);
        float f12 = this.f18235c;
        float f13 = this.f18233a;
        canvas.drawLine(f12, f13, this.f18236d, f13, this.T);
        float f14 = this.f18235c;
        float f15 = this.f18234b;
        canvas.drawLine(f14, f15, this.f18236d, f15, this.T);
        if (this.f18261w != 3) {
            float f16 = this.f18235c;
            canvas.drawLine(f16, this.f18233a, f16, this.f18234b + (this.f18237e / 2.0f), this.U);
        }
        float f17 = this.f18236d;
        canvas.drawLine(f17, this.f18233a, f17, this.f18261w == 3 ? this.f18234b : this.f18234b + (this.f18237e / 2.0f), this.U);
        float f18 = this.f18234b;
        float f19 = this.f18233a;
        float f20 = (f18 - f19) / 3.0f;
        canvas.drawLine(this.f18235c, f19 + f20, this.f18236d, f19 + f20, this.T);
        float f21 = this.f18235c;
        float f22 = this.f18233a;
        float f23 = f20 * 2.0f;
        canvas.drawLine(f21, f22 + f23, this.f18236d, f22 + f23, this.T);
        this.V.setColor(b.c(getContext(), i10));
        this.V.setTextAlign(Paint.Align.LEFT);
        int i11 = 0;
        while (true) {
            int[] iArr = this.f18238f;
            if (i11 >= iArr.length) {
                break;
            }
            if (this.f18261w == 3 && i11 == iArr.length - 1) {
                f11 = this.f18233a;
                f10 = i11 * f20;
            } else {
                f11 = this.f18233a + (i11 * f20);
                f10 = this.f18248m.height() / 2.0f;
            }
            canvas.drawText(String.valueOf(this.f18238f[i11]), this.f18236d + this.f18244k, f11 + f10, this.V);
            i11++;
        }
        if (this.f18241i != null) {
            int i12 = 0;
            while (true) {
                float[] fArr = this.f18241i;
                if (i12 < fArr.length) {
                    int i13 = this.f18261w;
                    if (i13 == 1) {
                        if (i12 != 0) {
                            canvas.drawLine(fArr[i12], this.f18233a, fArr[i12], (this.f18237e / 2.0f) + this.f18234b, this.U);
                        }
                        canvas.drawText(this.f18240h[i12], this.f18241i[i12] + this.f18244k, this.f18234b + this.f18242j + this.f18248m.height(), this.V);
                    } else if (i13 == 2) {
                        if (i12 != 0) {
                            canvas.drawLine(fArr[i12], this.f18233a, fArr[i12], (this.f18237e / 2.0f) + this.f18234b, this.U);
                        }
                        this.V.setTextAlign(Paint.Align.CENTER);
                        canvas.drawText(this.f18240h[i12], this.f18241i[i12] + (((this.f18236d - this.f18235c) / 7.0f) / 2.0f), this.f18234b + this.f18242j + this.f18248m.height(), this.V);
                    } else if (i13 == 3) {
                        canvas.drawLine(fArr[i12], this.f18233a, fArr[i12], (this.f18237e / 2.0f) + this.f18234b, this.U);
                        canvas.drawText(this.f18240h[i12], this.f18241i[i12] + this.f18244k, this.f18234b + this.f18242j + this.f18248m.height(), this.V);
                    }
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    public void e(c cVar, int i10) {
        this.A = cVar;
        this.f18261w = i10;
        this.B = cVar != null ? cVar.f27853a : System.currentTimeMillis();
        a();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        List<d> list;
        Bitmap bitmap;
        Iterator<d> it;
        Object obj;
        List<d> list2;
        Bitmap bitmap2;
        List<Float> list3;
        Bitmap bitmap3;
        Bitmap bitmap4;
        List<Float> list4;
        Bitmap bitmap5;
        List<c.b> list5;
        super.onDraw(canvas);
        d(canvas);
        if (this.f18261w == 1 && this.f18258t > 0.0f && this.f18259u > 0.0f) {
            Paint paint = this.U;
            Context context = getContext();
            int i10 = o.f26476p;
            paint.setColor(b.c(context, i10));
            this.U.setPathEffect(this.f18260v);
            float f10 = this.f18235c;
            float f11 = this.f18258t;
            canvas.drawLine(f10, f11, this.f18236d, f11, this.U);
            this.V.setTextAlign(Paint.Align.LEFT);
            this.V.setColor(b.c(getContext(), i10));
            canvas.drawText(String.valueOf(Math.round(this.f18259u)), this.f18236d + this.f18244k, this.f18258t + (this.f18248m.height() / 2.0f), this.V);
        }
        c cVar = this.A;
        if (cVar == null || (list5 = cVar.f18272b) == null || list5.size() <= 0) {
            z10 = true;
        } else {
            for (c.b bVar : this.A.f18272b) {
                canvas.drawPath(bVar.f18296h, this.W);
            }
            z10 = false;
        }
        if (this.f18252o != null) {
            this.f18243j0.setStrokeWidth(this.f18261w == 3 ? this.f18263y : this.f18263y + this.f18246l);
            this.f18243j0.setColor(-1);
            PointF pointF = this.f18252o;
            canvas.drawPoint(pointF.x, pointF.y, this.f18243j0);
            this.f18243j0.setColor(b.c(getContext(), o.f26468l));
            this.f18243j0.setStrokeWidth(this.f18261w == 3 ? this.f18263y - 4.0f : this.f18263y);
            PointF pointF2 = this.f18252o;
            canvas.drawPoint(pointF2.x, pointF2.y, this.f18243j0);
        }
        if (this.f18250n != null) {
            this.f18243j0.setStrokeWidth(this.f18261w == 3 ? this.f18263y : this.f18263y + this.f18246l);
            this.f18243j0.setColor(-1);
            PointF pointF3 = this.f18250n;
            canvas.drawPoint(pointF3.x, pointF3.y, this.f18243j0);
            this.f18243j0.setColor(b.c(getContext(), o.f26466k));
            this.f18243j0.setStrokeWidth(this.f18261w == 3 ? this.f18263y - 4.0f : this.f18263y);
            PointF pointF4 = this.f18250n;
            canvas.drawPoint(pointF4.x, pointF4.y, this.f18243j0);
        }
        if (this.f18261w == 2) {
            Path path = this.f18255q;
            if (path != null) {
                canvas.drawPath(path, this.f18245k0);
            }
            List<PointF> list6 = this.f18254p;
            if (list6 != null && list6.size() > 1) {
                for (PointF pointF5 : this.f18254p) {
                    this.f18243j0.setStrokeWidth(getResources().getDimensionPixelSize(p.f26533t));
                    this.f18243j0.setColor(b.c(getContext(), o.f26476p));
                    canvas.drawPoint(pointF5.x, pointF5.y, this.f18243j0);
                    this.f18243j0.setStrokeWidth(getResources().getDimensionPixelSize(p.f26531s));
                    this.f18243j0.setColor(-1);
                    canvas.drawPoint(pointF5.x, pointF5.y, this.f18243j0);
                }
            }
        }
        Object obj2 = null;
        if (!this.f18253o0 || (list4 = this.C) == null || list4.size() <= 0) {
            z11 = true;
        } else {
            for (Float f12 : this.C) {
                float floatValue = f12.floatValue();
                this.f18256r.reset();
                this.f18256r.moveTo(floatValue, this.f18233a);
                this.f18256r.lineTo(floatValue, this.f18234b);
                canvas.drawPath(this.f18256r, this.f18247l0);
                if (this.G != null) {
                    float width = bitmap5.getWidth() / 2.0f;
                    float height = this.f18234b - this.G.getHeight();
                    float f13 = this.f18244k;
                    this.I.set((int) (floatValue - width), (int) (height - f13), (int) (floatValue + width), (int) (this.f18234b - f13));
                    canvas.drawBitmap(this.G, this.H, this.I, (Paint) null);
                }
            }
            z11 = false;
        }
        if (!this.f18253o0 || (list3 = this.D) == null || list3.size() <= 0) {
            z12 = true;
        } else {
            for (Float f14 : this.D) {
                float floatValue2 = f14.floatValue();
                float width2 = this.J.getWidth() / 2.0f;
                List<Float> list7 = this.C;
                if (list7 == null || !list7.contains(Float.valueOf(floatValue2))) {
                    this.f18257s.reset();
                    this.f18257s.moveTo(floatValue2, this.f18233a);
                    this.f18257s.lineTo(floatValue2, this.f18234b);
                    canvas.drawPath(this.f18257s, this.f18249m0);
                    if (this.J != null) {
                        float height2 = this.f18234b - bitmap3.getHeight();
                        float f15 = this.f18244k;
                        this.L.set((int) (floatValue2 - width2), (int) (height2 - f15), (int) (floatValue2 + width2), (int) (this.f18234b - f15));
                        canvas.drawBitmap(this.J, this.K, this.L, (Paint) null);
                    }
                } else {
                    if (this.J != null) {
                        this.L.set((int) (floatValue2 - width2), (int) ((this.f18234b - this.f18244k) - (bitmap4.getHeight() * 2.25f)), (int) (floatValue2 + width2), (int) ((this.f18234b - this.f18244k) - (this.J.getHeight() * 1.25f)));
                        canvas.drawBitmap(this.J, this.K, this.L, (Paint) null);
                    }
                }
            }
            z12 = false;
        }
        if (!this.f18253o0 || (list2 = this.E) == null || list2.size() <= 0) {
            z13 = true;
        } else {
            for (d dVar : this.E) {
                if (this.M != null) {
                    float f16 = dVar.f31246a;
                    float f17 = dVar.f31247b;
                    float width3 = bitmap2.getWidth() / 2.0f;
                    float f18 = this.f18244k;
                    this.O.set((int) (f16 - width3), (int) ((f17 - this.M.getHeight()) - (f18 / 2.0f)), (int) (width3 + f16), (int) (f17 - (f18 / 2.0f)));
                    canvas.drawBitmap(this.M, this.N, this.O, (Paint) null);
                    this.S.setColor(-1);
                    this.S.setStrokeWidth(this.f18244k);
                    this.S.setStyle(Paint.Style.FILL_AND_STROKE);
                    this.S.setFakeBoldText(true);
                    float height3 = ((f17 - this.M.getHeight()) - (this.f18244k / 2.0f)) - (this.f18248m.height() / 2.0f);
                    canvas.drawText(String.valueOf(dVar.f31248c), f16, height3, this.S);
                    this.S.setColor(b.c(getContext(), o.f26473n0));
                    this.S.setStrokeWidth(0.0f);
                    this.S.setStyle(Paint.Style.FILL_AND_STROKE);
                    this.S.setFakeBoldText(false);
                    canvas.drawText(String.valueOf(dVar.f31248c), f16, height3, this.S);
                }
            }
            z13 = false;
        }
        if (!this.f18253o0 || (list = this.F) == null || list.size() <= 0) {
            z14 = true;
        } else {
            Iterator<d> it2 = this.F.iterator();
            while (it2.hasNext()) {
                d next = it2.next();
                if (this.P != null) {
                    float f19 = next.f31246a;
                    float f20 = next.f31247b;
                    float width4 = bitmap.getWidth() / 2.0f;
                    it = it2;
                    this.R.set((int) (f19 - width4), (int) ((this.f18244k / 2.0f) + f20), (int) (width4 + f19), (int) (this.P.getHeight() + f20 + (this.f18244k / 2.0f)));
                    obj = null;
                    canvas.drawBitmap(this.P, this.Q, this.R, (Paint) null);
                    this.S.setColor(-1);
                    this.S.setStrokeWidth(this.f18244k / 2.0f);
                    this.S.setStyle(Paint.Style.FILL_AND_STROKE);
                    this.S.setFakeBoldText(true);
                    float f21 = this.f18244k;
                    float height4 = f20 + this.P.getHeight() + (f21 / 2.0f) + f21 + this.f18248m.height();
                    canvas.drawText(String.valueOf(next.f31248c), f19, height4, this.S);
                    this.S.setColor(b.c(getContext(), o.f26473n0));
                    this.S.setStrokeWidth(0.0f);
                    this.S.setStyle(Paint.Style.FILL_AND_STROKE);
                    this.S.setFakeBoldText(false);
                    canvas.drawText(String.valueOf(next.f31248c), f19, height4, this.S);
                } else {
                    obj = obj2;
                    it = it2;
                }
                obj2 = obj;
                it2 = it;
            }
            z14 = false;
        }
        if (z10 && z14 && z13 && z11 && z12) {
            this.V.setTextAlign(Paint.Align.CENTER);
            this.V.setColor(b.c(getContext(), o.f26458g));
            canvas.drawText(getResources().getString(u.N2), getWidth() / 2.0f, (this.f18234b - this.f18233a) / 2.0f, this.V);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public HeartRateDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18238f = new int[]{150, 100, 50};
        this.f18239g = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        this.f18248m = new Rect();
        this.f18254p = new ArrayList();
        this.f18255q = new Path();
        this.f18256r = new Path();
        this.f18257s = new Path();
        this.f18258t = -1.0f;
        this.f18259u = -1.0f;
        this.f18260v = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
        this.f18261w = -1;
        this.B = -1L;
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.T = new Paint(1);
        this.U = new Paint(1);
        this.V = new Paint(1);
        this.W = new Paint(1);
        this.f18243j0 = new Paint(1);
        this.f18245k0 = new Paint(1);
        this.f18253o0 = false;
        this.f18251n0 = context;
        this.f18253o0 = h.b().i(this.f18251n0);
        c();
    }
}
