package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import p.b;
import p.c;
/* compiled from: RoundRectDrawableWithShadow.java */
/* loaded from: classes.dex */
class g extends Drawable {

    /* renamed from: q  reason: collision with root package name */
    private static final double f1421q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r  reason: collision with root package name */
    static a f1422r;

    /* renamed from: a  reason: collision with root package name */
    private final int f1423a;

    /* renamed from: c  reason: collision with root package name */
    private Paint f1425c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f1426d;

    /* renamed from: f  reason: collision with root package name */
    private float f1428f;

    /* renamed from: g  reason: collision with root package name */
    private Path f1429g;

    /* renamed from: h  reason: collision with root package name */
    private float f1430h;

    /* renamed from: i  reason: collision with root package name */
    private float f1431i;

    /* renamed from: j  reason: collision with root package name */
    private float f1432j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f1433k;

    /* renamed from: m  reason: collision with root package name */
    private final int f1435m;

    /* renamed from: n  reason: collision with root package name */
    private final int f1436n;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1434l = true;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1437o = true;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1438p = false;

    /* renamed from: b  reason: collision with root package name */
    private Paint f1424b = new Paint(5);

    /* renamed from: e  reason: collision with root package name */
    private final RectF f1427e = new RectF();

    /* compiled from: RoundRectDrawableWithShadow.java */
    /* loaded from: classes.dex */
    interface a {
        void a(Canvas canvas, RectF rectF, float f10, Paint paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Resources resources, ColorStateList colorStateList, float f10, float f11, float f12) {
        this.f1435m = resources.getColor(b.f32523d);
        this.f1436n = resources.getColor(b.f32522c);
        this.f1423a = resources.getDimensionPixelSize(c.f32524a);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f1425c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1428f = (int) (f10 + 0.5f);
        Paint paint2 = new Paint(this.f1425c);
        this.f1426d = paint2;
        paint2.setAntiAlias(false);
        s(f11, f12);
    }

    private void a(Rect rect) {
        float f10 = this.f1430h;
        float f11 = 1.5f * f10;
        this.f1427e.set(rect.left + f10, rect.top + f11, rect.right - f10, rect.bottom - f11);
        b();
    }

    private void b() {
        float f10 = this.f1428f;
        RectF rectF = new RectF(-f10, -f10, f10, f10);
        RectF rectF2 = new RectF(rectF);
        float f11 = this.f1431i;
        rectF2.inset(-f11, -f11);
        Path path = this.f1429g;
        if (path == null) {
            this.f1429g = new Path();
        } else {
            path.reset();
        }
        this.f1429g.setFillType(Path.FillType.EVEN_ODD);
        this.f1429g.moveTo(-this.f1428f, 0.0f);
        this.f1429g.rLineTo(-this.f1431i, 0.0f);
        this.f1429g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1429g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1429g.close();
        float f12 = this.f1428f;
        float f13 = f12 / (this.f1431i + f12);
        Paint paint = this.f1425c;
        float f14 = this.f1428f + this.f1431i;
        int i10 = this.f1435m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f14, new int[]{i10, i10, this.f1436n}, new float[]{0.0f, f13, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1426d;
        float f15 = this.f1428f;
        float f16 = this.f1431i;
        int i11 = this.f1435m;
        paint2.setShader(new LinearGradient(0.0f, (-f15) + f16, 0.0f, (-f15) - f16, new int[]{i11, i11, this.f1436n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1426d.setAntiAlias(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(float f10, float f11, boolean z10) {
        return z10 ? (float) (f10 + ((1.0d - f1421q) * f11)) : f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(float f10, float f11, boolean z10) {
        return z10 ? (float) ((f10 * 1.5f) + ((1.0d - f1421q) * f11)) : f10 * 1.5f;
    }

    private void e(Canvas canvas) {
        float f10 = this.f1428f;
        float f11 = (-f10) - this.f1431i;
        float f12 = f10 + this.f1423a + (this.f1432j / 2.0f);
        float f13 = f12 * 2.0f;
        boolean z10 = this.f1427e.width() - f13 > 0.0f;
        boolean z11 = this.f1427e.height() - f13 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1427e;
        canvas.translate(rectF.left + f12, rectF.top + f12);
        canvas.drawPath(this.f1429g, this.f1425c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1427e.width() - f13, -this.f1428f, this.f1426d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1427e;
        canvas.translate(rectF2.right - f12, rectF2.bottom - f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1429g, this.f1425c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1427e.width() - f13, (-this.f1428f) + this.f1431i, this.f1426d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1427e;
        canvas.translate(rectF3.left + f12, rectF3.bottom - f12);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1429g, this.f1425c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1427e.height() - f13, -this.f1428f, this.f1426d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1427e;
        canvas.translate(rectF4.right - f12, rectF4.top + f12);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1429g, this.f1425c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1427e.height() - f13, -this.f1428f, this.f1426d);
        }
        canvas.restoreToCount(save4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1433k = colorStateList;
        this.f1424b.setColor(colorStateList.getColorForState(getState(), this.f1433k.getDefaultColor()));
    }

    private void s(float f10, float f11) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f10 + ". Must be >= 0");
        } else if (f11 >= 0.0f) {
            float t10 = t(f10);
            float t11 = t(f11);
            if (t10 > t11) {
                if (!this.f1438p) {
                    this.f1438p = true;
                }
                t10 = t11;
            }
            if (this.f1432j != t10 || this.f1430h != t11) {
                this.f1432j = t10;
                this.f1430h = t11;
                this.f1431i = (int) ((t10 * 1.5f) + this.f1423a + 0.5f);
                this.f1434l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f11 + ". Must be >= 0");
        }
    }

    private int t(float f10) {
        int i10 = (int) (f10 + 0.5f);
        return i10 % 2 == 1 ? i10 - 1 : i10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1434l) {
            a(getBounds());
            this.f1434l = false;
        }
        canvas.translate(0.0f, this.f1432j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f1432j) / 2.0f);
        f1422r.a(canvas, this.f1427e, this.f1428f, this.f1424b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f1433k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f1428f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(d(this.f1430h, this.f1428f, this.f1437o));
        int ceil2 = (int) Math.ceil(c(this.f1430h, this.f1428f, this.f1437o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Rect rect) {
        getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f1430h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f1433k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        float f10 = this.f1430h;
        return (Math.max(f10, this.f1428f + this.f1423a + ((f10 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1430h * 1.5f) + this.f1423a) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        float f10 = this.f1430h;
        return (Math.max(f10, this.f1428f + this.f1423a + (f10 / 2.0f)) * 2.0f) + ((this.f1430h + this.f1423a) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f1432j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z10) {
        this.f1437o = z10;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1434l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1433k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1424b.getColor() == colorForState) {
            return false;
        }
        this.f1424b.setColor(colorForState);
        this.f1434l = true;
        invalidateSelf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(float f10) {
        if (f10 >= 0.0f) {
            float f11 = (int) (f10 + 0.5f);
            if (this.f1428f != f11) {
                this.f1428f = f11;
                this.f1434l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f10 + ". Must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(float f10) {
        s(this.f1432j, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(float f10) {
        s(f10, this.f1430h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f1424b.setAlpha(i10);
        this.f1425c.setAlpha(i10);
        this.f1426d.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1424b.setColorFilter(colorFilter);
    }
}
