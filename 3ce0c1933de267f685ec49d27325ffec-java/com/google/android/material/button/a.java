package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.view.d0;
import com.google.android.material.internal.m;
import d7.b;
import d7.l;
import t7.c;
import w7.g;
import w7.k;
import w7.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialButtonHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: t  reason: collision with root package name */
    private static final boolean f10609t;

    /* renamed from: u  reason: collision with root package name */
    private static final boolean f10610u;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f10611a;

    /* renamed from: b  reason: collision with root package name */
    private k f10612b;

    /* renamed from: c  reason: collision with root package name */
    private int f10613c;

    /* renamed from: d  reason: collision with root package name */
    private int f10614d;

    /* renamed from: e  reason: collision with root package name */
    private int f10615e;

    /* renamed from: f  reason: collision with root package name */
    private int f10616f;

    /* renamed from: g  reason: collision with root package name */
    private int f10617g;

    /* renamed from: h  reason: collision with root package name */
    private int f10618h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f10619i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f10620j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f10621k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f10622l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f10623m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10624n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10625o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f10626p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10627q;

    /* renamed from: r  reason: collision with root package name */
    private LayerDrawable f10628r;

    /* renamed from: s  reason: collision with root package name */
    private int f10629s;

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        f10609t = i10 >= 21;
        if (i10 < 21 || i10 > 22) {
            z10 = false;
        }
        f10610u = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialButton materialButton, k kVar) {
        this.f10611a = materialButton;
        this.f10612b = kVar;
    }

    private void E(int i10, int i11) {
        int J = d0.J(this.f10611a);
        int paddingTop = this.f10611a.getPaddingTop();
        int I = d0.I(this.f10611a);
        int paddingBottom = this.f10611a.getPaddingBottom();
        int i12 = this.f10615e;
        int i13 = this.f10616f;
        this.f10616f = i11;
        this.f10615e = i10;
        if (!this.f10625o) {
            F();
        }
        d0.H0(this.f10611a, J, (paddingTop + i10) - i12, I, (paddingBottom + i11) - i13);
    }

    private void F() {
        this.f10611a.setInternalBackground(a());
        g f10 = f();
        if (f10 != null) {
            f10.Y(this.f10629s);
        }
    }

    private void G(k kVar) {
        if (!f10610u || this.f10625o) {
            if (f() != null) {
                f().setShapeAppearanceModel(kVar);
            }
            if (n() != null) {
                n().setShapeAppearanceModel(kVar);
            }
            if (e() != null) {
                e().setShapeAppearanceModel(kVar);
                return;
            }
            return;
        }
        int J = d0.J(this.f10611a);
        int paddingTop = this.f10611a.getPaddingTop();
        int I = d0.I(this.f10611a);
        int paddingBottom = this.f10611a.getPaddingBottom();
        F();
        d0.H0(this.f10611a, J, paddingTop, I, paddingBottom);
    }

    private void I() {
        g f10 = f();
        g n10 = n();
        if (f10 != null) {
            f10.h0(this.f10618h, this.f10621k);
            if (n10 != null) {
                n10.g0(this.f10618h, this.f10624n ? j7.a.d(this.f10611a, b.f25161q) : 0);
            }
        }
    }

    private InsetDrawable J(Drawable drawable) {
        return new InsetDrawable(drawable, this.f10613c, this.f10615e, this.f10614d, this.f10616f);
    }

    private Drawable a() {
        g gVar = new g(this.f10612b);
        gVar.O(this.f10611a.getContext());
        androidx.core.graphics.drawable.a.o(gVar, this.f10620j);
        PorterDuff.Mode mode = this.f10619i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(gVar, mode);
        }
        gVar.h0(this.f10618h, this.f10621k);
        g gVar2 = new g(this.f10612b);
        gVar2.setTint(0);
        gVar2.g0(this.f10618h, this.f10624n ? j7.a.d(this.f10611a, b.f25161q) : 0);
        if (f10609t) {
            g gVar3 = new g(this.f10612b);
            this.f10623m = gVar3;
            androidx.core.graphics.drawable.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(u7.b.d(this.f10622l), J(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f10623m);
            this.f10628r = rippleDrawable;
            return rippleDrawable;
        }
        u7.a aVar = new u7.a(this.f10612b);
        this.f10623m = aVar;
        androidx.core.graphics.drawable.a.o(aVar, u7.b.d(this.f10622l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f10623m});
        this.f10628r = layerDrawable;
        return J(layerDrawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private g g(boolean z10) {
        LayerDrawable layerDrawable = this.f10628r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (f10609t) {
            return (g) ((LayerDrawable) ((InsetDrawable) this.f10628r.getDrawable(0)).getDrawable()).getDrawable(!z10);
        }
        return (g) this.f10628r.getDrawable(!z10 ? 1 : 0);
    }

    private g n() {
        return g(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(ColorStateList colorStateList) {
        if (this.f10621k != colorStateList) {
            this.f10621k = colorStateList;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i10) {
        if (this.f10618h != i10) {
            this.f10618h = i10;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(ColorStateList colorStateList) {
        if (this.f10620j != colorStateList) {
            this.f10620j = colorStateList;
            if (f() != null) {
                androidx.core.graphics.drawable.a.o(f(), this.f10620j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(PorterDuff.Mode mode) {
        if (this.f10619i != mode) {
            this.f10619i = mode;
            if (f() != null && this.f10619i != null) {
                androidx.core.graphics.drawable.a.p(f(), this.f10619i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i10, int i11) {
        Drawable drawable = this.f10623m;
        if (drawable != null) {
            drawable.setBounds(this.f10613c, this.f10615e, i11 - this.f10614d, i10 - this.f10616f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f10617g;
    }

    public int c() {
        return this.f10616f;
    }

    public int d() {
        return this.f10615e;
    }

    public n e() {
        LayerDrawable layerDrawable = this.f10628r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.f10628r.getNumberOfLayers() > 2) {
            return (n) this.f10628r.getDrawable(2);
        }
        return (n) this.f10628r.getDrawable(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g f() {
        return g(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f10622l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k i() {
        return this.f10612b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f10621k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f10618h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f10620j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f10619i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f10625o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f10627q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(TypedArray typedArray) {
        this.f10613c = typedArray.getDimensionPixelOffset(l.f25373b2, 0);
        this.f10614d = typedArray.getDimensionPixelOffset(l.f25381c2, 0);
        this.f10615e = typedArray.getDimensionPixelOffset(l.f25389d2, 0);
        this.f10616f = typedArray.getDimensionPixelOffset(l.f25397e2, 0);
        int i10 = l.f25429i2;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f10617g = dimensionPixelSize;
            y(this.f10612b.w(dimensionPixelSize));
            this.f10626p = true;
        }
        this.f10618h = typedArray.getDimensionPixelSize(l.f25508s2, 0);
        this.f10619i = m.e(typedArray.getInt(l.f25421h2, -1), PorterDuff.Mode.SRC_IN);
        this.f10620j = c.a(this.f10611a.getContext(), typedArray, l.f25413g2);
        this.f10621k = c.a(this.f10611a.getContext(), typedArray, l.f25500r2);
        this.f10622l = c.a(this.f10611a.getContext(), typedArray, l.f25493q2);
        this.f10627q = typedArray.getBoolean(l.f25405f2, false);
        this.f10629s = typedArray.getDimensionPixelSize(l.f25437j2, 0);
        int J = d0.J(this.f10611a);
        int paddingTop = this.f10611a.getPaddingTop();
        int I = d0.I(this.f10611a);
        int paddingBottom = this.f10611a.getPaddingBottom();
        if (typedArray.hasValue(l.f25365a2)) {
            s();
        } else {
            F();
        }
        d0.H0(this.f10611a, J + this.f10613c, paddingTop + this.f10615e, I + this.f10614d, paddingBottom + this.f10616f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i10) {
        if (f() != null) {
            f().setTint(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f10625o = true;
        this.f10611a.setSupportBackgroundTintList(this.f10620j);
        this.f10611a.setSupportBackgroundTintMode(this.f10619i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(boolean z10) {
        this.f10627q = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i10) {
        if (!this.f10626p || this.f10617g != i10) {
            this.f10617g = i10;
            this.f10626p = true;
            y(this.f10612b.w(i10));
        }
    }

    public void v(int i10) {
        E(this.f10615e, i10);
    }

    public void w(int i10) {
        E(i10, this.f10616f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ColorStateList colorStateList) {
        if (this.f10622l != colorStateList) {
            this.f10622l = colorStateList;
            boolean z10 = f10609t;
            if (z10 && (this.f10611a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f10611a.getBackground()).setColor(u7.b.d(colorStateList));
            } else if (!z10 && (this.f10611a.getBackground() instanceof u7.a)) {
                ((u7.a) this.f10611a.getBackground()).setTintList(u7.b.d(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(k kVar) {
        this.f10612b = kVar;
        G(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z10) {
        this.f10624n = z10;
        I();
    }
}
