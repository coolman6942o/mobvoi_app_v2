package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawableWithAnimatedVisibilityChange.java */
/* loaded from: classes.dex */
public abstract class g extends Drawable implements Animatable {

    /* renamed from: o  reason: collision with root package name */
    private static final Property<g, Float> f11232o = new c(Float.class, "growFraction");

    /* renamed from: a  reason: collision with root package name */
    final Context f11233a;

    /* renamed from: b  reason: collision with root package name */
    final com.google.android.material.progressindicator.b f11234b;

    /* renamed from: d  reason: collision with root package name */
    private ValueAnimator f11236d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f11237e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11238f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11239g;

    /* renamed from: h  reason: collision with root package name */
    private float f11240h;

    /* renamed from: i  reason: collision with root package name */
    private List<androidx.vectordrawable.graphics.drawable.b> f11241i;

    /* renamed from: j  reason: collision with root package name */
    private androidx.vectordrawable.graphics.drawable.b f11242j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11243k;

    /* renamed from: l  reason: collision with root package name */
    private float f11244l;

    /* renamed from: n  reason: collision with root package name */
    private int f11246n;

    /* renamed from: m  reason: collision with root package name */
    final Paint f11245m = new Paint();

    /* renamed from: c  reason: collision with root package name */
    r7.a f11235c = new r7.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            g.super.setVisible(false, false);
            g.this.d();
        }
    }

    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes.dex */
    static class c extends Property<g, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(g gVar) {
            return Float.valueOf(gVar.g());
        }

        /* renamed from: b */
        public void set(g gVar, Float f10) {
            gVar.m(f10.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context, com.google.android.material.progressindicator.b bVar) {
        this.f11233a = context;
        this.f11234b = bVar;
        setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        androidx.vectordrawable.graphics.drawable.b bVar = this.f11242j;
        if (bVar != null) {
            bVar.a(this);
        }
        List<androidx.vectordrawable.graphics.drawable.b> list = this.f11241i;
        if (!(list == null || this.f11243k)) {
            for (androidx.vectordrawable.graphics.drawable.b bVar2 : list) {
                bVar2.a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        androidx.vectordrawable.graphics.drawable.b bVar = this.f11242j;
        if (bVar != null) {
            bVar.b(this);
        }
        List<androidx.vectordrawable.graphics.drawable.b> list = this.f11241i;
        if (!(list == null || this.f11243k)) {
            for (androidx.vectordrawable.graphics.drawable.b bVar2 : list) {
                bVar2.b(this);
            }
        }
    }

    private void f(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f11243k;
        this.f11243k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f11243k = z10;
    }

    private void k() {
        if (this.f11236d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f11232o, 0.0f, 1.0f);
            this.f11236d = ofFloat;
            ofFloat.setDuration(500L);
            this.f11236d.setInterpolator(e7.a.f25834b);
            o(this.f11236d);
        }
        if (this.f11237e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f11232o, 1.0f, 0.0f);
            this.f11237e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f11237e.setInterpolator(e7.a.f25834b);
            n(this.f11237e);
        }
    }

    private void n(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f11237e;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.f11237e = valueAnimator;
            valueAnimator.addListener(new b());
            return;
        }
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    private void o(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f11236d;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.f11236d = valueAnimator;
            valueAnimator.addListener(new a());
            return;
        }
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        if (!this.f11234b.b() && !this.f11234b.a()) {
            return 1.0f;
        }
        if (this.f11239g || this.f11238f) {
            return this.f11240h;
        }
        return this.f11244l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f11246n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h() {
        return p(false, false, false);
    }

    public boolean i() {
        ValueAnimator valueAnimator = this.f11237e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f11239g;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return j() || i();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f11236d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f11238f;
    }

    public void l(androidx.vectordrawable.graphics.drawable.b bVar) {
        if (this.f11241i == null) {
            this.f11241i = new ArrayList();
        }
        if (!this.f11241i.contains(bVar)) {
            this.f11241i.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f10) {
        if (this.f11244l != f10) {
            this.f11244l = f10;
            invalidateSelf();
        }
    }

    public boolean p(boolean z10, boolean z11, boolean z12) {
        return q(z10, z11, z12 && this.f11235c.a(this.f11233a.getContentResolver()) > 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q(boolean z10, boolean z11, boolean z12) {
        k();
        if (!isVisible() && !z10) {
            return false;
        }
        ValueAnimator valueAnimator = z10 ? this.f11236d : this.f11237e;
        if (!z12) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                f(valueAnimator);
            }
            return super.setVisible(z10, false);
        } else if (z12 && valueAnimator.isRunning()) {
            return false;
        } else {
            boolean z13 = !z10 || super.setVisible(z10, false);
            if (!(z10 ? this.f11234b.b() : this.f11234b.a())) {
                f(valueAnimator);
                return z13;
            }
            if (z11 || Build.VERSION.SDK_INT < 19 || !valueAnimator.isPaused()) {
                valueAnimator.start();
            } else {
                valueAnimator.resume();
            }
            return z13;
        }
    }

    public boolean r(androidx.vectordrawable.graphics.drawable.b bVar) {
        List<androidx.vectordrawable.graphics.drawable.b> list = this.f11241i;
        if (list == null || !list.contains(bVar)) {
            return false;
        }
        this.f11241i.remove(bVar);
        if (!this.f11241i.isEmpty()) {
            return true;
        }
        this.f11241i = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f11246n = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f11245m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return p(z10, z11, true);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        q(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        q(false, true, false);
    }
}
