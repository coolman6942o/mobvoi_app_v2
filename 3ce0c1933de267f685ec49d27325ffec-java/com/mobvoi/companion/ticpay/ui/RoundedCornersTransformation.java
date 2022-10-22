package com.mobvoi.companion.ticpay.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import java.security.MessageDigest;
import q4.g;
import t4.c;
import u4.e;
/* loaded from: classes2.dex */
public class RoundedCornersTransformation implements g<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private e f17524b;

    /* renamed from: c  reason: collision with root package name */
    private int f17525c;

    /* renamed from: d  reason: collision with root package name */
    private int f17526d;

    /* renamed from: e  reason: collision with root package name */
    private int f17527e;

    /* renamed from: f  reason: collision with root package name */
    private CornerType f17528f;

    /* loaded from: classes2.dex */
    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17529a;

        static {
            int[] iArr = new int[CornerType.values().length];
            f17529a = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17529a[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17529a[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17529a[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17529a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17529a[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17529a[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17529a[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17529a[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17529a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17529a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17529a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17529a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f17529a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17529a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public RoundedCornersTransformation(Context context, int i10, int i11) {
        this(context, i10, i11, CornerType.ALL);
    }

    private void c(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        int i11 = this.f17526d;
        RectF rectF = new RectF(i10, f11 - i11, i10 + i11, f11);
        int i12 = this.f17525c;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f17527e;
        canvas.drawRect(new RectF(i13, i13, i13 + this.f17526d, f11 - this.f17525c), paint);
        int i14 = this.f17527e;
        canvas.drawRect(new RectF(this.f17525c + i14, i14, f10, f11), paint);
    }

    private void d(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17526d;
        RectF rectF = new RectF(f10 - i10, f11 - i10, f10, f11);
        int i11 = this.f17525c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f17527e;
        canvas.drawRect(new RectF(i12, i12, f10 - this.f17525c, f11), paint);
        int i13 = this.f17525c;
        canvas.drawRect(new RectF(f10 - i13, this.f17527e, f10, f11 - i13), paint);
    }

    private void e(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(this.f17527e, f11 - this.f17526d, f10, f11);
        int i10 = this.f17525c;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        int i11 = this.f17527e;
        canvas.drawRect(new RectF(i11, i11, f10, f11 - this.f17525c), paint);
    }

    private void f(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        int i11 = this.f17526d;
        RectF rectF = new RectF(i10, i10, i10 + i11, i10 + i11);
        int i12 = this.f17525c;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f17526d;
        RectF rectF2 = new RectF(f10 - i13, f11 - i13, f10, f11);
        int i14 = this.f17525c;
        canvas.drawRoundRect(rectF2, i14, i14, paint);
        int i15 = this.f17527e;
        canvas.drawRect(new RectF(i15, i15 + this.f17525c, f10 - this.f17526d, f11), paint);
        int i16 = this.f17527e;
        canvas.drawRect(new RectF(this.f17526d + i16, i16, f10, f11 - this.f17525c), paint);
    }

    private void g(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17526d;
        int i11 = this.f17527e;
        RectF rectF = new RectF(f10 - i10, i11, f10, i11 + i10);
        int i12 = this.f17525c;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f17527e;
        int i14 = this.f17526d;
        RectF rectF2 = new RectF(i13, f11 - i14, i13 + i14, f11);
        int i15 = this.f17525c;
        canvas.drawRoundRect(rectF2, i15, i15, paint);
        int i16 = this.f17527e;
        int i17 = this.f17525c;
        canvas.drawRect(new RectF(i16, i16, f10 - i17, f11 - i17), paint);
        int i18 = this.f17527e;
        int i19 = this.f17525c;
        canvas.drawRect(new RectF(i18 + i19, i18 + i19, f10, f11), paint);
    }

    private void h(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        RectF rectF = new RectF(i10, i10, i10 + this.f17526d, f11);
        int i11 = this.f17525c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f17527e;
        canvas.drawRect(new RectF(this.f17525c + i12, i12, f10, f11), paint);
    }

    private void i(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        RectF rectF = new RectF(i10, i10, f10, i10 + this.f17526d);
        int i11 = this.f17525c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        RectF rectF2 = new RectF(f10 - this.f17526d, this.f17527e, f10, f11);
        int i12 = this.f17525c;
        canvas.drawRoundRect(rectF2, i12, i12, paint);
        int i13 = this.f17527e;
        int i14 = this.f17525c;
        canvas.drawRect(new RectF(i13, i13 + i14, f10 - i14, f11), paint);
    }

    private void j(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        RectF rectF = new RectF(i10, i10, f10, i10 + this.f17526d);
        int i11 = this.f17525c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f17527e;
        RectF rectF2 = new RectF(i12, i12, i12 + this.f17526d, f11);
        int i13 = this.f17525c;
        canvas.drawRoundRect(rectF2, i13, i13, paint);
        int i14 = this.f17527e;
        int i15 = this.f17525c;
        canvas.drawRect(new RectF(i14 + i15, i14 + i15, f10, f11), paint);
    }

    private void k(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(this.f17527e, f11 - this.f17526d, f10, f11);
        int i10 = this.f17525c;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        RectF rectF2 = new RectF(f10 - this.f17526d, this.f17527e, f10, f11);
        int i11 = this.f17525c;
        canvas.drawRoundRect(rectF2, i11, i11, paint);
        int i12 = this.f17527e;
        int i13 = this.f17525c;
        canvas.drawRect(new RectF(i12, i12, f10 - i13, f11 - i13), paint);
    }

    private void l(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        RectF rectF = new RectF(i10, i10, i10 + this.f17526d, f11);
        int i11 = this.f17525c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        RectF rectF2 = new RectF(this.f17527e, f11 - this.f17526d, f10, f11);
        int i12 = this.f17525c;
        canvas.drawRoundRect(rectF2, i12, i12, paint);
        int i13 = this.f17527e;
        int i14 = this.f17525c;
        canvas.drawRect(new RectF(i13 + i14, i13, f10, f11 - i14), paint);
    }

    private void m(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(f10 - this.f17526d, this.f17527e, f10, f11);
        int i10 = this.f17525c;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        int i11 = this.f17527e;
        canvas.drawRect(new RectF(i11, i11, f10 - this.f17525c, f11), paint);
    }

    private void n(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        float f12 = f10 - i10;
        float f13 = f11 - i10;
        switch (a.f17529a[this.f17528f.ordinal()]) {
            case 1:
                int i11 = this.f17527e;
                RectF rectF = new RectF(i11, i11, f12, f13);
                int i12 = this.f17525c;
                canvas.drawRoundRect(rectF, i12, i12, paint);
                return;
            case 2:
                o(canvas, paint, f12, f13);
                return;
            case 3:
                p(canvas, paint, f12, f13);
                return;
            case 4:
                c(canvas, paint, f12, f13);
                return;
            case 5:
                d(canvas, paint, f12, f13);
                return;
            case 6:
                q(canvas, paint, f12, f13);
                return;
            case 7:
                e(canvas, paint, f12, f13);
                return;
            case 8:
                h(canvas, paint, f12, f13);
                return;
            case 9:
                m(canvas, paint, f12, f13);
                return;
            case 10:
                k(canvas, paint, f12, f13);
                return;
            case 11:
                l(canvas, paint, f12, f13);
                return;
            case 12:
                i(canvas, paint, f12, f13);
                return;
            case 13:
                j(canvas, paint, f12, f13);
                return;
            case 14:
                f(canvas, paint, f12, f13);
                return;
            case 15:
                g(canvas, paint, f12, f13);
                return;
            default:
                int i13 = this.f17527e;
                RectF rectF2 = new RectF(i13, i13, f12, f13);
                int i14 = this.f17525c;
                canvas.drawRoundRect(rectF2, i14, i14, paint);
                return;
        }
    }

    private void o(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        int i11 = this.f17526d;
        RectF rectF = new RectF(i10, i10, i10 + i11, i10 + i11);
        int i12 = this.f17525c;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f17527e;
        int i14 = this.f17525c;
        canvas.drawRect(new RectF(i13, i13 + i14, i13 + i14, f11), paint);
        int i15 = this.f17527e;
        canvas.drawRect(new RectF(this.f17525c + i15, i15, f10, f11), paint);
    }

    private void p(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17526d;
        int i11 = this.f17527e;
        RectF rectF = new RectF(f10 - i10, i11, f10, i11 + i10);
        int i12 = this.f17525c;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f17527e;
        canvas.drawRect(new RectF(i13, i13, f10 - this.f17525c, f11), paint);
        int i14 = this.f17525c;
        canvas.drawRect(new RectF(f10 - i14, this.f17527e + i14, f10, f11), paint);
    }

    private void q(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f17527e;
        RectF rectF = new RectF(i10, i10, f10, i10 + this.f17526d);
        int i11 = this.f17525c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f17527e;
        canvas.drawRect(new RectF(i12, i12 + this.f17525c, f10, f11), paint);
    }

    private String r() {
        return "RoundedTransformation(radius=" + this.f17525c + ", margin=" + this.f17527e + ", diameter=" + this.f17526d + ", cornerType=" + this.f17528f.name() + ")";
    }

    @Override // q4.g
    public c<Bitmap> a(Context context, c<Bitmap> cVar, int i10, int i11) {
        Bitmap bitmap = cVar.get();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap d10 = this.f17524b.d(width, height, Bitmap.Config.ARGB_8888);
        if (d10 == null) {
            d10 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(d10);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        n(canvas, paint, width, height);
        return a5.c.f(d10, this.f17524b);
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        messageDigest.update(r().getBytes());
    }

    public RoundedCornersTransformation(Context context, int i10, int i11, CornerType cornerType) {
        this(com.bumptech.glide.c.c(context).f(), i10, i11, cornerType);
    }

    public RoundedCornersTransformation(e eVar, int i10, int i11, CornerType cornerType) {
        this.f17524b = eVar;
        this.f17525c = i10;
        this.f17526d = i10 * 2;
        this.f17527e = i11;
        this.f17528f = cornerType;
    }
}
