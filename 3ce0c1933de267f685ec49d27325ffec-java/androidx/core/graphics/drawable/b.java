package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import c0.d;
import c0.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WrappedDrawableApi14.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback, e, d {

    /* renamed from: g  reason: collision with root package name */
    static final PorterDuff.Mode f2466g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    private int f2467a;

    /* renamed from: b  reason: collision with root package name */
    private PorterDuff.Mode f2468b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2469c;

    /* renamed from: d  reason: collision with root package name */
    d f2470d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2471e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f2472f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, Resources resources) {
        this.f2470d = dVar;
        e(resources);
    }

    private d d() {
        return new d(this.f2470d);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        d dVar = this.f2470d;
        if (dVar != null && (constantState = dVar.f2475b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        d dVar = this.f2470d;
        ColorStateList colorStateList = dVar.f2476c;
        PorterDuff.Mode mode = dVar.f2477d;
        if (colorStateList == null || mode == null) {
            this.f2469c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f2469c && colorForState == this.f2467a && mode == this.f2468b)) {
                setColorFilter(colorForState, mode);
                this.f2467a = colorForState;
                this.f2468b = mode;
                this.f2469c = true;
                return true;
            }
        }
        return false;
    }

    @Override // c0.e
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f2472f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2472f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            d dVar = this.f2470d;
            if (dVar != null) {
                dVar.f2475b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // c0.e
    public final Drawable b() {
        return this.f2472f;
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2472f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        d dVar = this.f2470d;
        return changingConfigurations | (dVar != null ? dVar.getChangingConfigurations() : 0) | this.f2472f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        d dVar = this.f2470d;
        if (dVar == null || !dVar.a()) {
            return null;
        }
        this.f2470d.f2474a = getChangingConfigurations();
        return this.f2470d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2472f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2472f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2472f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.f(this.f2472f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f2472f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f2472f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2472f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f2472f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f2472f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f2472f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.h(this.f2472f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        d dVar;
        ColorStateList colorStateList = (!c() || (dVar = this.f2470d) == null) ? null : dVar.f2476c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f2472f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f2472f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2471e && super.mutate() == this) {
            this.f2470d = d();
            Drawable drawable = this.f2472f;
            if (drawable != null) {
                drawable.mutate();
            }
            d dVar = this.f2470d;
            if (dVar != null) {
                Drawable drawable2 = this.f2472f;
                dVar.f2475b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f2471e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2472f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return a.m(this.f2472f, i10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        return this.f2472f.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f2472f.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        a.j(this.f2472f, z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i10) {
        this.f2472f.setChangingConfigurations(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2472f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f2472f.setDither(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f2472f.setFilterBitmap(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f2472f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintList(ColorStateList colorStateList) {
        this.f2470d.f2476c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2470d.f2477d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11) || this.f2472f.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Drawable drawable) {
        this.f2470d = d();
        a(drawable);
    }
}
