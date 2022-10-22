package u7;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import c0.d;
import w7.g;
import w7.k;
import w7.n;
/* compiled from: RippleDrawableCompat.java */
/* loaded from: classes.dex */
public class a extends Drawable implements n, d {

    /* renamed from: a  reason: collision with root package name */
    private b f35335a;

    /* renamed from: a */
    public a mutate() {
        this.f35335a = new b(this.f35335a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f35335a;
        if (bVar.f35337b) {
            bVar.f35336a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f35335a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f35335a.f35336a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f35335a.f35336a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f35335a.f35336a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e10 = u7.b.e(iArr);
        b bVar = this.f35335a;
        if (bVar.f35337b == e10) {
            return onStateChange;
        }
        bVar.f35337b = e10;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f35335a.f35336a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f35335a.f35336a.setColorFilter(colorFilter);
    }

    @Override // w7.n
    public void setShapeAppearanceModel(k kVar) {
        this.f35335a.f35336a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTint(int i10) {
        this.f35335a.f35336a.setTint(i10);
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintList(ColorStateList colorStateList) {
        this.f35335a.f35336a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintMode(PorterDuff.Mode mode) {
        this.f35335a.f35336a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RippleDrawableCompat.java */
    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        g f35336a;

        /* renamed from: b  reason: collision with root package name */
        boolean f35337b;

        public b(g gVar) {
            this.f35336a = gVar;
            this.f35337b = false;
        }

        /* renamed from: a */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f35336a = (g) bVar.f35336a.getConstantState().newDrawable();
            this.f35337b = bVar.f35337b;
        }
    }

    private a(b bVar) {
        this.f35335a = bVar;
    }
}
