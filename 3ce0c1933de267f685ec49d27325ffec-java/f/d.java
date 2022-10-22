package f;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import d.a;
import d.i;
import d.j;
/* compiled from: DrawerArrowDrawable.java */
/* loaded from: classes.dex */
public class d extends Drawable {

    /* renamed from: m  reason: collision with root package name */
    private static final float f26304m = (float) Math.toRadians(45.0d);

    /* renamed from: a  reason: collision with root package name */
    private final Paint f26305a;

    /* renamed from: b  reason: collision with root package name */
    private float f26306b;

    /* renamed from: c  reason: collision with root package name */
    private float f26307c;

    /* renamed from: d  reason: collision with root package name */
    private float f26308d;

    /* renamed from: e  reason: collision with root package name */
    private float f26309e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26310f;

    /* renamed from: h  reason: collision with root package name */
    private final int f26312h;

    /* renamed from: j  reason: collision with root package name */
    private float f26314j;

    /* renamed from: k  reason: collision with root package name */
    private float f26315k;

    /* renamed from: g  reason: collision with root package name */
    private final Path f26311g = new Path();

    /* renamed from: i  reason: collision with root package name */
    private boolean f26313i = false;

    /* renamed from: l  reason: collision with root package name */
    private int f26316l = 2;

    public d(Context context) {
        Paint paint = new Paint();
        this.f26305a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, j.W0, a.B, i.f24850b);
        d(obtainStyledAttributes.getColor(j.f24856a1, 0));
        c(obtainStyledAttributes.getDimension(j.f24876e1, 0.0f));
        f(obtainStyledAttributes.getBoolean(j.f24871d1, true));
        e(Math.round(obtainStyledAttributes.getDimension(j.f24866c1, 0.0f)));
        this.f26312h = obtainStyledAttributes.getDimensionPixelSize(j.f24861b1, 0);
        this.f26307c = Math.round(obtainStyledAttributes.getDimension(j.Z0, 0.0f));
        this.f26306b = Math.round(obtainStyledAttributes.getDimension(j.X0, 0.0f));
        this.f26308d = obtainStyledAttributes.getDimension(j.Y0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float b(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public float a() {
        return this.f26314j;
    }

    public void c(float f10) {
        if (this.f26305a.getStrokeWidth() != f10) {
            this.f26305a.setStrokeWidth(f10);
            this.f26315k = (float) ((f10 / 2.0f) * Math.cos(f26304m));
            invalidateSelf();
        }
    }

    public void d(int i10) {
        if (i10 != this.f26305a.getColor()) {
            this.f26305a.setColor(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f10;
        Rect bounds = getBounds();
        int i10 = this.f26316l;
        boolean z10 = false;
        if (i10 != 0 && (i10 == 1 || (i10 == 3 ? androidx.core.graphics.drawable.a.f(this) == 0 : androidx.core.graphics.drawable.a.f(this) == 1))) {
            z10 = true;
        }
        float f11 = this.f26306b;
        float b10 = b(this.f26307c, (float) Math.sqrt(f11 * f11 * 2.0f), this.f26314j);
        float b11 = b(this.f26307c, this.f26308d, this.f26314j);
        float round = Math.round(b(0.0f, this.f26315k, this.f26314j));
        float b12 = b(0.0f, f26304m, this.f26314j);
        float b13 = b(z10 ? 0.0f : -180.0f, z10 ? 180.0f : 0.0f, this.f26314j);
        double d10 = b10;
        double d11 = b12;
        boolean z11 = z10;
        float round2 = (float) Math.round(Math.cos(d11) * d10);
        float round3 = (float) Math.round(d10 * Math.sin(d11));
        this.f26311g.rewind();
        float b14 = b(this.f26309e + this.f26305a.getStrokeWidth(), -this.f26315k, this.f26314j);
        float f12 = (-b11) / 2.0f;
        this.f26311g.moveTo(f12 + round, 0.0f);
        this.f26311g.rLineTo(b11 - (round * 2.0f), 0.0f);
        this.f26311g.moveTo(f12, b14);
        this.f26311g.rLineTo(round2, round3);
        this.f26311g.moveTo(f12, -b14);
        this.f26311g.rLineTo(round2, -round3);
        this.f26311g.close();
        canvas.save();
        float strokeWidth = this.f26305a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * f10))) / 4) * 2) + (strokeWidth * 1.5f) + this.f26309e);
        if (this.f26310f) {
            canvas.rotate(b13 * (this.f26313i ^ z11 ? -1 : 1));
        } else if (z11) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f26311g, this.f26305a);
        canvas.restore();
    }

    public void e(float f10) {
        if (f10 != this.f26309e) {
            this.f26309e = f10;
            invalidateSelf();
        }
    }

    public void f(boolean z10) {
        if (this.f26310f != z10) {
            this.f26310f = z10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f26312h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f26312h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f26305a.getAlpha()) {
            this.f26305a.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f26305a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f10) {
        if (this.f26314j != f10) {
            this.f26314j = f10;
            invalidateSelf();
        }
    }
}
