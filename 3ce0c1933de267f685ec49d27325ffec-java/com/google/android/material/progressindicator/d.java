package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircularIndeterminateAnimatorDelegate.java */
/* loaded from: classes.dex */
public final class d extends i<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f11208l = {0, 1350, 2700, 4050};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f11209m = {667, 2017, 3367, 4717};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f11210n = {1000, 2350, 3700, 5050};

    /* renamed from: o  reason: collision with root package name */
    private static final Property<d, Float> f11211o = new c(Float.class, "animationFraction");

    /* renamed from: p  reason: collision with root package name */
    private static final Property<d, Float> f11212p = new C0128d(Float.class, "completeEndFraction");

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f11213d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f11214e;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f11216g;

    /* renamed from: i  reason: collision with root package name */
    private float f11218i;

    /* renamed from: j  reason: collision with root package name */
    private float f11219j;

    /* renamed from: h  reason: collision with root package name */
    private int f11217h = 0;

    /* renamed from: k  reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b f11220k = null;

    /* renamed from: f  reason: collision with root package name */
    private final x0.b f11215f = new x0.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f11217h = (dVar.f11217h + 4) % d.this.f11216g.f11200c.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            androidx.vectordrawable.graphics.drawable.b bVar = dVar.f11220k;
            if (bVar != null) {
                bVar.a(dVar.f11251a);
            }
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes.dex */
    static class c extends Property<d, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        /* renamed from: b */
        public void set(d dVar, Float f10) {
            dVar.t(f10.floatValue());
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* renamed from: com.google.android.material.progressindicator.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0128d extends Property<d, Float> {
        C0128d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        /* renamed from: b */
        public void set(d dVar, Float f10) {
            dVar.u(f10.floatValue());
        }
    }

    public d(e eVar) {
        super(1);
        this.f11216g = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f11218i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f11219j;
    }

    private void q() {
        if (this.f11213d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f11211o, 0.0f, 1.0f);
            this.f11213d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f11213d.setInterpolator(null);
            this.f11213d.setRepeatCount(-1);
            this.f11213d.addListener(new a());
        }
        if (this.f11214e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f11212p, 0.0f, 1.0f);
            this.f11214e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f11214e.setInterpolator(this.f11215f);
            this.f11214e.addListener(new b());
        }
    }

    private void r(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            float b10 = b(i10, f11210n[i11], 333);
            if (b10 >= 0.0f && b10 <= 1.0f) {
                int i12 = i11 + this.f11217h;
                int[] iArr = this.f11216g.f11200c;
                int length = i12 % iArr.length;
                this.f11253c[0] = e7.c.b().evaluate(this.f11215f.getInterpolation(b10), Integer.valueOf(j7.a.a(iArr[length], this.f11251a.getAlpha())), Integer.valueOf(j7.a.a(this.f11216g.f11200c[(length + 1) % iArr.length], this.f11251a.getAlpha()))).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f10) {
        this.f11219j = f10;
    }

    private void v(int i10) {
        float[] fArr = this.f11252b;
        float f10 = this.f11218i;
        fArr[0] = (f10 * 1520.0f) - 20.0f;
        fArr[1] = f10 * 1520.0f;
        for (int i11 = 0; i11 < 4; i11++) {
            float b10 = b(i10, f11208l[i11], 667);
            float[] fArr2 = this.f11252b;
            fArr2[1] = fArr2[1] + (this.f11215f.getInterpolation(b10) * 250.0f);
            float b11 = b(i10, f11209m[i11], 667);
            float[] fArr3 = this.f11252b;
            fArr3[0] = fArr3[0] + (this.f11215f.getInterpolation(b11) * 250.0f);
        }
        float[] fArr4 = this.f11252b;
        fArr4[0] = fArr4[0] + ((fArr4[1] - fArr4[0]) * this.f11219j);
        fArr4[0] = fArr4[0] / 360.0f;
        fArr4[1] = fArr4[1] / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.i
    void a() {
        ObjectAnimator objectAnimator = this.f11213d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(androidx.vectordrawable.graphics.drawable.b bVar) {
        this.f11220k = bVar;
    }

    @Override // com.google.android.material.progressindicator.i
    void f() {
        ObjectAnimator objectAnimator = this.f11214e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f11251a.isVisible()) {
                this.f11214e.start();
            } else {
                a();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.i
    void g() {
        q();
        s();
        this.f11213d.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
        this.f11220k = null;
    }

    void s() {
        this.f11217h = 0;
        this.f11253c[0] = j7.a.a(this.f11216g.f11200c[0], this.f11251a.getAlpha());
        this.f11219j = 0.0f;
    }

    void t(float f10) {
        this.f11218i = f10;
        int i10 = (int) (f10 * 5400.0f);
        v(i10);
        r(i10);
        this.f11251a.invalidateSelf();
    }
}
