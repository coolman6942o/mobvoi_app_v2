package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.d0;
import d.j;
/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f1136a;

    /* renamed from: d  reason: collision with root package name */
    private v0 f1139d;

    /* renamed from: e  reason: collision with root package name */
    private v0 f1140e;

    /* renamed from: f  reason: collision with root package name */
    private v0 f1141f;

    /* renamed from: c  reason: collision with root package name */
    private int f1138c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final j f1137b = j.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view) {
        this.f1136a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f1141f == null) {
            this.f1141f = new v0();
        }
        v0 v0Var = this.f1141f;
        v0Var.a();
        ColorStateList u10 = d0.u(this.f1136a);
        if (u10 != null) {
            v0Var.f1358d = true;
            v0Var.f1355a = u10;
        }
        PorterDuff.Mode v10 = d0.v(this.f1136a);
        if (v10 != null) {
            v0Var.f1357c = true;
            v0Var.f1356b = v10;
        }
        if (!v0Var.f1358d && !v0Var.f1357c) {
            return false;
        }
        j.i(drawable, v0Var, this.f1136a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f1139d != null : i10 == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f1136a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            v0 v0Var = this.f1140e;
            if (v0Var != null) {
                j.i(background, v0Var, this.f1136a.getDrawableState());
                return;
            }
            v0 v0Var2 = this.f1139d;
            if (v0Var2 != null) {
                j.i(background, v0Var2, this.f1136a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        v0 v0Var = this.f1140e;
        if (v0Var != null) {
            return v0Var.f1355a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        v0 v0Var = this.f1140e;
        if (v0Var != null) {
            return v0Var.f1356b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i10) {
        Context context = this.f1136a.getContext();
        int[] iArr = j.P3;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        View view = this.f1136a;
        d0.r0(view, view.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            int i11 = j.Q3;
            if (v10.s(i11)) {
                this.f1138c = v10.n(i11, -1);
                ColorStateList f10 = this.f1137b.f(this.f1136a.getContext(), this.f1138c);
                if (f10 != null) {
                    h(f10);
                }
            }
            int i12 = j.R3;
            if (v10.s(i12)) {
                d0.y0(this.f1136a, v10.c(i12));
            }
            int i13 = j.S3;
            if (v10.s(i13)) {
                d0.z0(this.f1136a, g0.e(v10.k(i13, -1), null));
            }
        } finally {
            v10.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f1138c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i10) {
        this.f1138c = i10;
        j jVar = this.f1137b;
        h(jVar != null ? jVar.f(this.f1136a.getContext(), i10) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1139d == null) {
                this.f1139d = new v0();
            }
            v0 v0Var = this.f1139d;
            v0Var.f1355a = colorStateList;
            v0Var.f1358d = true;
        } else {
            this.f1139d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f1140e == null) {
            this.f1140e = new v0();
        }
        v0 v0Var = this.f1140e;
        v0Var.f1355a = colorStateList;
        v0Var.f1358d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f1140e == null) {
            this.f1140e = new v0();
        }
        v0 v0Var = this.f1140e;
        v0Var.f1356b = mode;
        v0Var.f1357c = true;
        b();
    }
}
