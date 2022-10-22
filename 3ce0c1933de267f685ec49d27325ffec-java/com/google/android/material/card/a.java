package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.d0;
import d7.f;
import d7.l;
import t7.c;
import u7.b;
import w7.d;
import w7.e;
import w7.g;
import w7.j;
import w7.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialCardViewHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: t  reason: collision with root package name */
    private static final double f10639t = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f10640a;

    /* renamed from: c  reason: collision with root package name */
    private final g f10642c;

    /* renamed from: d  reason: collision with root package name */
    private final g f10643d;

    /* renamed from: e  reason: collision with root package name */
    private int f10644e;

    /* renamed from: f  reason: collision with root package name */
    private int f10645f;

    /* renamed from: g  reason: collision with root package name */
    private int f10646g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f10647h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f10648i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f10649j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f10650k;

    /* renamed from: l  reason: collision with root package name */
    private k f10651l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f10652m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f10653n;

    /* renamed from: o  reason: collision with root package name */
    private LayerDrawable f10654o;

    /* renamed from: p  reason: collision with root package name */
    private g f10655p;

    /* renamed from: q  reason: collision with root package name */
    private g f10656q;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10658s;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f10641b = new Rect();

    /* renamed from: r  reason: collision with root package name */
    private boolean f10657r = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCardViewHelper.java */
    /* renamed from: com.google.android.material.card.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0120a extends InsetDrawable {
        C0120a(a aVar, Drawable drawable, int i10, int i11, int i12, int i13) {
            super(drawable, i10, i11, i12, i13);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(MaterialCardView materialCardView, AttributeSet attributeSet, int i10, int i11) {
        this.f10640a = materialCardView;
        g gVar = new g(materialCardView.getContext(), attributeSet, i10, i11);
        this.f10642c = gVar;
        gVar.O(materialCardView.getContext());
        gVar.e0(-12303292);
        k.b v10 = gVar.E().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, l.f25403f0, i10, d7.k.f25336a);
        int i12 = l.f25411g0;
        if (obtainStyledAttributes.hasValue(i12)) {
            v10.o(obtainStyledAttributes.getDimension(i12, 0.0f));
        }
        this.f10643d = new g();
        R(v10.m());
        obtainStyledAttributes.recycle();
    }

    private Drawable A(Drawable drawable) {
        int i10;
        int i11;
        if ((Build.VERSION.SDK_INT < 21) || this.f10640a.getUseCompatPadding()) {
            i10 = (int) Math.ceil(d());
            i11 = (int) Math.ceil(c());
        } else {
            i11 = 0;
            i10 = 0;
        }
        return new C0120a(this, drawable, i11, i10, i11, i10);
    }

    private boolean V() {
        return this.f10640a.getPreventCornerOverlap() && !e();
    }

    private boolean W() {
        return this.f10640a.getPreventCornerOverlap() && e() && this.f10640a.getUseCompatPadding();
    }

    private float a() {
        return Math.max(Math.max(b(this.f10651l.q(), this.f10642c.H()), b(this.f10651l.s(), this.f10642c.I())), Math.max(b(this.f10651l.k(), this.f10642c.t()), b(this.f10651l.i(), this.f10642c.s())));
    }

    private void a0(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.f10640a.getForeground() instanceof InsetDrawable)) {
            this.f10640a.setForeground(A(drawable));
        } else {
            ((InsetDrawable) this.f10640a.getForeground()).setDrawable(drawable);
        }
    }

    private float b(d dVar, float f10) {
        if (dVar instanceof j) {
            return (float) ((1.0d - f10639t) * f10);
        }
        if (dVar instanceof e) {
            return f10 / 2.0f;
        }
        return 0.0f;
    }

    private float c() {
        return this.f10640a.getMaxCardElevation() + (W() ? a() : 0.0f);
    }

    private void c0() {
        Drawable drawable;
        if (!b.f35338a || (drawable = this.f10653n) == null) {
            g gVar = this.f10655p;
            if (gVar != null) {
                gVar.Z(this.f10649j);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.f10649j);
    }

    private float d() {
        return (this.f10640a.getMaxCardElevation() * 1.5f) + (W() ? a() : 0.0f);
    }

    private boolean e() {
        return Build.VERSION.SDK_INT >= 21 && this.f10642c.R();
    }

    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        g h10 = h();
        this.f10655p = h10;
        h10.Z(this.f10649j);
        stateListDrawable.addState(new int[]{16842919}, this.f10655p);
        return stateListDrawable;
    }

    private Drawable g() {
        if (!b.f35338a) {
            return f();
        }
        this.f10656q = h();
        return new RippleDrawable(this.f10649j, null, this.f10656q);
    }

    private g h() {
        return new g(this.f10651l);
    }

    private Drawable q() {
        if (this.f10653n == null) {
            this.f10653n = g();
        }
        if (this.f10654o == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f10653n, this.f10643d, this.f10648i});
            this.f10654o = layerDrawable;
            layerDrawable.setId(2, f.L);
        }
        return this.f10654o;
    }

    private float s() {
        if (!this.f10640a.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (Build.VERSION.SDK_INT < 21 || this.f10640a.getUseCompatPadding()) {
            return (float) ((1.0d - f10639t) * this.f10640a.getCardViewRadius());
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        return this.f10657r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.f10658s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(TypedArray typedArray) {
        ColorStateList a10 = c.a(this.f10640a.getContext(), typedArray, l.Z2);
        this.f10652m = a10;
        if (a10 == null) {
            this.f10652m = ColorStateList.valueOf(-1);
        }
        this.f10646g = typedArray.getDimensionPixelSize(l.f25366a3, 0);
        boolean z10 = typedArray.getBoolean(l.S2, false);
        this.f10658s = z10;
        this.f10640a.setLongClickable(z10);
        this.f10650k = c.a(this.f10640a.getContext(), typedArray, l.X2);
        K(c.d(this.f10640a.getContext(), typedArray, l.U2));
        M(typedArray.getDimensionPixelSize(l.W2, 0));
        L(typedArray.getDimensionPixelSize(l.V2, 0));
        ColorStateList a11 = c.a(this.f10640a.getContext(), typedArray, l.Y2);
        this.f10649j = a11;
        if (a11 == null) {
            this.f10649j = ColorStateList.valueOf(j7.a.d(this.f10640a, d7.b.f25157m));
        }
        H(c.a(this.f10640a.getContext(), typedArray, l.T2));
        c0();
        Z();
        d0();
        this.f10640a.setBackgroundInternal(A(this.f10642c));
        Drawable q5 = this.f10640a.isClickable() ? q() : this.f10643d;
        this.f10647h = q5;
        this.f10640a.setForeground(A(q5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i10, int i11) {
        int i12;
        int i13;
        if (this.f10654o != null) {
            int i14 = this.f10644e;
            int i15 = this.f10645f;
            int i16 = (i10 - i14) - i15;
            int i17 = (i11 - i14) - i15;
            if ((Build.VERSION.SDK_INT < 21) || this.f10640a.getUseCompatPadding()) {
                i17 -= (int) Math.ceil(d() * 2.0f);
                i16 -= (int) Math.ceil(c() * 2.0f);
            }
            int i18 = i17;
            int i19 = this.f10644e;
            if (d0.E(this.f10640a) == 1) {
                i12 = i16;
                i13 = i19;
            } else {
                i13 = i16;
                i12 = i19;
            }
            this.f10654o.setLayerInset(2, i13, this.f10644e, i12, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(boolean z10) {
        this.f10657r = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(ColorStateList colorStateList) {
        this.f10642c.Z(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(ColorStateList colorStateList) {
        g gVar = this.f10643d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.Z(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(boolean z10) {
        this.f10658s = z10;
    }

    public void J(boolean z10) {
        Drawable drawable = this.f10648i;
        if (drawable != null) {
            drawable.setAlpha(z10 ? 255 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(Drawable drawable) {
        this.f10648i = drawable;
        if (drawable != null) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f10648i = mutate;
            androidx.core.graphics.drawable.a.o(mutate, this.f10650k);
            J(this.f10640a.isChecked());
        }
        LayerDrawable layerDrawable = this.f10654o;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(f.L, this.f10648i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(int i10) {
        this.f10644e = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(int i10) {
        this.f10645f = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(ColorStateList colorStateList) {
        this.f10650k = colorStateList;
        Drawable drawable = this.f10648i;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(float f10) {
        R(this.f10651l.w(f10));
        this.f10647h.invalidateSelf();
        if (W() || V()) {
            Y();
        }
        if (W()) {
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(float f10) {
        this.f10642c.a0(f10);
        g gVar = this.f10643d;
        if (gVar != null) {
            gVar.a0(f10);
        }
        g gVar2 = this.f10656q;
        if (gVar2 != null) {
            gVar2.a0(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ColorStateList colorStateList) {
        this.f10649j = colorStateList;
        c0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(k kVar) {
        this.f10651l = kVar;
        this.f10642c.setShapeAppearanceModel(kVar);
        g gVar = this.f10642c;
        gVar.d0(!gVar.R());
        g gVar2 = this.f10643d;
        if (gVar2 != null) {
            gVar2.setShapeAppearanceModel(kVar);
        }
        g gVar3 = this.f10656q;
        if (gVar3 != null) {
            gVar3.setShapeAppearanceModel(kVar);
        }
        g gVar4 = this.f10655p;
        if (gVar4 != null) {
            gVar4.setShapeAppearanceModel(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ColorStateList colorStateList) {
        if (this.f10652m != colorStateList) {
            this.f10652m = colorStateList;
            d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i10) {
        if (i10 != this.f10646g) {
            this.f10646g = i10;
            d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i10, int i11, int i12, int i13) {
        this.f10641b.set(i10, i11, i12, i13);
        Y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        Drawable drawable = this.f10647h;
        Drawable q5 = this.f10640a.isClickable() ? q() : this.f10643d;
        this.f10647h = q5;
        if (drawable != q5) {
            a0(q5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        int a10 = (int) ((V() || W() ? a() : 0.0f) - s());
        MaterialCardView materialCardView = this.f10640a;
        Rect rect = this.f10641b;
        materialCardView.k(rect.left + a10, rect.top + a10, rect.right + a10, rect.bottom + a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        this.f10642c.Y(this.f10640a.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0() {
        if (!B()) {
            this.f10640a.setBackgroundInternal(A(this.f10642c));
        }
        this.f10640a.setForeground(A(this.f10647h));
    }

    void d0() {
        this.f10643d.h0(this.f10646g, this.f10652m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f10653n;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i10 = bounds.bottom;
            this.f10653n.setBounds(bounds.left, bounds.top, bounds.right, i10 - 1);
            this.f10653n.setBounds(bounds.left, bounds.top, bounds.right, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g j() {
        return this.f10642c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList k() {
        return this.f10642c.x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f10643d.x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable m() {
        return this.f10648i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f10644e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f10645f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList p() {
        return this.f10650k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float r() {
        return this.f10642c.H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.f10642c.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList u() {
        return this.f10649j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k v() {
        return this.f10651l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w() {
        ColorStateList colorStateList = this.f10652m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList x() {
        return this.f10652m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y() {
        return this.f10646g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rect z() {
        return this.f10641b;
    }
}
