package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* compiled from: RoundRectDrawable.java */
/* loaded from: classes.dex */
class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f1410a;

    /* renamed from: e  reason: collision with root package name */
    private float f1414e;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f1417h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f1418i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f1419j;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1415f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1416g = true;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f1420k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1411b = new Paint(5);

    /* renamed from: c  reason: collision with root package name */
    private final RectF f1412c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f1413d = new Rect();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ColorStateList colorStateList, float f10) {
        this.f1410a = f10;
        e(colorStateList);
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1417h = colorStateList;
        this.f1411b.setColor(colorStateList.getColorForState(getState(), this.f1417h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1412c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1413d.set(rect);
        if (this.f1415f) {
            float d10 = g.d(this.f1414e, this.f1410a, this.f1416g);
            this.f1413d.inset((int) Math.ceil(g.c(this.f1414e, this.f1410a, this.f1416g)), (int) Math.ceil(d10));
            this.f1412c.set(this.f1413d);
        }
    }

    public ColorStateList b() {
        return this.f1417h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f1414e;
    }

    public float d() {
        return this.f1410a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f1411b;
        if (this.f1418i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f1418i);
            z10 = true;
        }
        RectF rectF = this.f1412c;
        float f10 = this.f1410a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f10, boolean z10, boolean z11) {
        if (f10 != this.f1414e || this.f1415f != z10 || this.f1416g != z11) {
            this.f1414e = f10;
            this.f1415f = z10;
            this.f1416g = z11;
            i(null);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1413d, this.f1410a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f10) {
        if (f10 != this.f1410a) {
            this.f1410a = f10;
            i(null);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1419j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1417h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1417h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f1411b.getColor();
        if (z10) {
            this.f1411b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1419j;
        if (colorStateList2 == null || (mode = this.f1420k) == null) {
            return z10;
        }
        this.f1418i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f1411b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1411b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1419j = colorStateList;
        this.f1418i = a(colorStateList, this.f1420k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1420k = mode;
        this.f1418i = a(this.f1419j, mode);
        invalidateSelf();
    }
}
