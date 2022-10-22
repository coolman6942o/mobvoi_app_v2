package k5;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import l5.b;
/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class f<Z> extends j<ImageView, Z> implements b.a {

    /* renamed from: g  reason: collision with root package name */
    private Animatable f29770g;

    public f(ImageView imageView) {
        super(imageView);
    }

    private void m(Z z10) {
        if (z10 instanceof Animatable) {
            Animatable animatable = (Animatable) z10;
            this.f29770g = animatable;
            animatable.start();
            return;
        }
        this.f29770g = null;
    }

    private void p(Z z10) {
        o(z10);
        m(z10);
    }

    @Override // k5.i
    public void a(Z z10, b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z10, this)) {
            p(z10);
        } else {
            m(z10);
        }
    }

    @Override // k5.a, k5.i
    public void c(Drawable drawable) {
        super.c(drawable);
        p(null);
        n(drawable);
    }

    @Override // k5.j, k5.a, k5.i
    public void e(Drawable drawable) {
        super.e(drawable);
        p(null);
        n(drawable);
    }

    @Override // k5.j, k5.a, k5.i
    public void g(Drawable drawable) {
        super.g(drawable);
        Animatable animatable = this.f29770g;
        if (animatable != null) {
            animatable.stop();
        }
        p(null);
        n(drawable);
    }

    public void n(Drawable drawable) {
        ((ImageView) this.f29772a).setImageDrawable(drawable);
    }

    protected abstract void o(Z z10);

    @Override // k5.a, g5.i
    public void onStart() {
        Animatable animatable = this.f29770g;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // k5.a, g5.i
    public void onStop() {
        Animatable animatable = this.f29770g;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
