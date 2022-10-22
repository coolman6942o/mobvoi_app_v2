package c0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* compiled from: RoundedBitmapDrawable.java */
/* loaded from: classes.dex */
public abstract class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Bitmap f5540a;

    /* renamed from: b  reason: collision with root package name */
    private int f5541b;

    /* renamed from: e  reason: collision with root package name */
    private final BitmapShader f5544e;

    /* renamed from: g  reason: collision with root package name */
    private float f5546g;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5550k;

    /* renamed from: l  reason: collision with root package name */
    private int f5551l;

    /* renamed from: m  reason: collision with root package name */
    private int f5552m;

    /* renamed from: c  reason: collision with root package name */
    private int f5542c = 119;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f5543d = new Paint(3);

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f5545f = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    final Rect f5547h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private final RectF f5548i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private boolean f5549j = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Resources resources, Bitmap bitmap) {
        this.f5541b = 160;
        if (resources != null) {
            this.f5541b = resources.getDisplayMetrics().densityDpi;
        }
        this.f5540a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f5544e = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.f5552m = -1;
        this.f5551l = -1;
        this.f5544e = null;
    }

    private void a() {
        this.f5551l = this.f5540a.getScaledWidth(this.f5541b);
        this.f5552m = this.f5540a.getScaledHeight(this.f5541b);
    }

    private static boolean d(float f10) {
        return f10 > 0.05f;
    }

    private void g() {
        this.f5546g = Math.min(this.f5552m, this.f5551l) / 2;
    }

    public float b() {
        return this.f5546g;
    }

    abstract void c(int i10, int i11, int i12, Rect rect, Rect rect2);

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f5540a;
        if (bitmap != null) {
            h();
            if (this.f5543d.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f5547h, this.f5543d);
                return;
            }
            RectF rectF = this.f5548i;
            float f10 = this.f5546g;
            canvas.drawRoundRect(rectF, f10, f10, this.f5543d);
        }
    }

    public void e(boolean z10) {
        this.f5543d.setAntiAlias(z10);
        invalidateSelf();
    }

    public void f(float f10) {
        if (this.f5546g != f10) {
            this.f5550k = false;
            if (d(f10)) {
                this.f5543d.setShader(this.f5544e);
            } else {
                this.f5543d.setShader(null);
            }
            this.f5546g = f10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5543d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f5543d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5552m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5551l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f5542c != 119 || this.f5550k || (bitmap = this.f5540a) == null || bitmap.hasAlpha() || this.f5543d.getAlpha() < 255 || d(this.f5546g)) ? -3 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.f5549j) {
            if (this.f5550k) {
                int min = Math.min(this.f5551l, this.f5552m);
                c(this.f5542c, min, min, getBounds(), this.f5547h);
                int min2 = Math.min(this.f5547h.width(), this.f5547h.height());
                this.f5547h.inset(Math.max(0, (this.f5547h.width() - min2) / 2), Math.max(0, (this.f5547h.height() - min2) / 2));
                this.f5546g = min2 * 0.5f;
            } else {
                c(this.f5542c, this.f5551l, this.f5552m, getBounds(), this.f5547h);
            }
            this.f5548i.set(this.f5547h);
            if (this.f5544e != null) {
                Matrix matrix = this.f5545f;
                RectF rectF = this.f5548i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f5545f.preScale(this.f5548i.width() / this.f5540a.getWidth(), this.f5548i.height() / this.f5540a.getHeight());
                this.f5544e.setLocalMatrix(this.f5545f);
                this.f5543d.setShader(this.f5544e);
            }
            this.f5549j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f5550k) {
            g();
        }
        this.f5549j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f5543d.getAlpha()) {
            this.f5543d.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5543d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f5543d.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f5543d.setFilterBitmap(z10);
        invalidateSelf();
    }
}
