package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import j0.h;
import java.util.ArrayList;
import v7.b;
import w7.g;
import w7.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImplLollipop.java */
/* loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImplLollipop.java */
    /* loaded from: classes.dex */
    public static class a extends g {
        a(k kVar) {
            super(kVar);
        }

        @Override // w7.g, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    private Animator j0(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f10948w, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f10948w, View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(b.D);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void A() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void C() {
        f0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void E(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.f10948w.isEnabled()) {
            this.f10948w.setElevation(this.f10933h);
            if (this.f10948w.isPressed()) {
                this.f10948w.setTranslationZ(this.f10935j);
            } else if (this.f10948w.isFocused() || this.f10948w.isHovered()) {
                this.f10948w.setTranslationZ(this.f10934i);
            } else {
                this.f10948w.setTranslationZ(0.0f);
            }
        } else {
            this.f10948w.setElevation(0.0f);
            this.f10948w.setTranslationZ(0.0f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void F(float f10, float f11, float f12) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 21) {
            this.f10948w.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(b.E, j0(f10, f12));
            stateListAnimator.addState(b.F, j0(f10, f11));
            stateListAnimator.addState(b.G, j0(f10, f11));
            stateListAnimator.addState(b.H, j0(f10, f11));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f10948w, "elevation", f10).setDuration(0L));
            if (i10 >= 22 && i10 <= 24) {
                FloatingActionButton floatingActionButton = this.f10948w;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f10948w, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(b.D);
            stateListAnimator.addState(b.I, animatorSet);
            stateListAnimator.addState(b.J, j0(0.0f, 0.0f));
            this.f10948w.setStateListAnimator(stateListAnimator);
        }
        if (Z()) {
            f0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    boolean K() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f10928c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(u7.b.d(colorStateList));
        } else {
            super.V(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    boolean Z() {
        return this.f10949x.b() || !b0();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void d0() {
    }

    com.google.android.material.floatingactionbutton.a i0(int i10, ColorStateList colorStateList) {
        Context context = this.f10948w.getContext();
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a((k) h.g(this.f10926a));
        aVar.e(androidx.core.content.b.c(context, d7.c.f25176f), androidx.core.content.b.c(context, d7.c.f25175e), androidx.core.content.b.c(context, d7.c.f25173c), androidx.core.content.b.c(context, d7.c.f25174d));
        aVar.d(i10);
        aVar.c(colorStateList);
        return aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    g l() {
        return new a((k) h.g(this.f10926a));
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public float n() {
        return this.f10948w.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void s(Rect rect) {
        if (this.f10949x.b()) {
            super.s(rect);
        } else if (!b0()) {
            int sizeDimension = (this.f10936k - this.f10948w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.b
    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        Drawable drawable;
        g l10 = l();
        this.f10927b = l10;
        l10.setTintList(colorStateList);
        if (mode != null) {
            this.f10927b.setTintMode(mode);
        }
        this.f10927b.O(this.f10948w.getContext());
        if (i10 > 0) {
            this.f10929d = i0(i10, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) h.g(this.f10929d), (Drawable) h.g(this.f10927b)});
        } else {
            this.f10929d = null;
            drawable = this.f10927b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(u7.b.d(colorStateList2), drawable, null);
        this.f10928c = rippleDrawable;
        this.f10930e = rippleDrawable;
    }
}
