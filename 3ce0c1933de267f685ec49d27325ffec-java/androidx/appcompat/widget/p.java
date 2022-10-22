package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.d0;
import androidx.core.widget.f;
import d.j;
import e.a;
/* compiled from: AppCompatImageHelper.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1276a;

    /* renamed from: b  reason: collision with root package name */
    private v0 f1277b;

    /* renamed from: c  reason: collision with root package name */
    private v0 f1278c;

    /* renamed from: d  reason: collision with root package name */
    private v0 f1279d;

    /* renamed from: e  reason: collision with root package name */
    private int f1280e = 0;

    public p(ImageView imageView) {
        this.f1276a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1279d == null) {
            this.f1279d = new v0();
        }
        v0 v0Var = this.f1279d;
        v0Var.a();
        ColorStateList a10 = f.a(this.f1276a);
        if (a10 != null) {
            v0Var.f1358d = true;
            v0Var.f1355a = a10;
        }
        PorterDuff.Mode b10 = f.b(this.f1276a);
        if (b10 != null) {
            v0Var.f1357c = true;
            v0Var.f1356b = b10;
        }
        if (!v0Var.f1358d && !v0Var.f1357c) {
            return false;
        }
        j.i(drawable, v0Var, this.f1276a.getDrawableState());
        return true;
    }

    private boolean l() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f1277b != null : i10 == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1276a.getDrawable() != null) {
            this.f1276a.getDrawable().setLevel(this.f1280e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1276a.getDrawable();
        if (drawable != null) {
            g0.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!l() || !a(drawable)) {
            v0 v0Var = this.f1278c;
            if (v0Var != null) {
                j.i(drawable, v0Var, this.f1276a.getDrawableState());
                return;
            }
            v0 v0Var2 = this.f1277b;
            if (v0Var2 != null) {
                j.i(drawable, v0Var2, this.f1276a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList d() {
        v0 v0Var = this.f1278c;
        if (v0Var != null) {
            return v0Var.f1355a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode e() {
        v0 v0Var = this.f1278c;
        if (v0Var != null) {
            return v0Var.f1356b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1276a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i10) {
        int n10;
        Context context = this.f1276a.getContext();
        int[] iArr = j.M;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f1276a;
        d0.r0(imageView, imageView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            Drawable drawable = this.f1276a.getDrawable();
            if (!(drawable != null || (n10 = v10.n(j.N, -1)) == -1 || (drawable = a.b(this.f1276a.getContext(), n10)) == null)) {
                this.f1276a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                g0.b(drawable);
            }
            int i11 = j.O;
            if (v10.s(i11)) {
                f.c(this.f1276a, v10.c(i11));
            }
            int i12 = j.P;
            if (v10.s(i12)) {
                f.d(this.f1276a, g0.e(v10.k(i12, -1), null));
            }
        } finally {
            v10.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Drawable drawable) {
        this.f1280e = drawable.getLevel();
    }

    public void i(int i10) {
        if (i10 != 0) {
            Drawable b10 = a.b(this.f1276a.getContext(), i10);
            if (b10 != null) {
                g0.b(b10);
            }
            this.f1276a.setImageDrawable(b10);
        } else {
            this.f1276a.setImageDrawable(null);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ColorStateList colorStateList) {
        if (this.f1278c == null) {
            this.f1278c = new v0();
        }
        v0 v0Var = this.f1278c;
        v0Var.f1355a = colorStateList;
        v0Var.f1358d = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(PorterDuff.Mode mode) {
        if (this.f1278c == null) {
            this.f1278c = new v0();
        }
        v0 v0Var = this.f1278c;
        v0Var.f1356b = mode;
        v0Var.f1357c = true;
        c();
    }
}
