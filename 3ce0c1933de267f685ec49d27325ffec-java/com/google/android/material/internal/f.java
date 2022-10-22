package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;
/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<b> f11063a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private b f11064b = null;

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f11065c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f11066d = new a();

    /* compiled from: StateListAnimator.java */
    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            if (fVar.f11065c == animator) {
                fVar.f11065c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateListAnimator.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int[] f11068a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f11069b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f11068a = iArr;
            this.f11069b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f11065c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f11065c = null;
        }
    }

    private void e(b bVar) {
        ValueAnimator valueAnimator = bVar.f11069b;
        this.f11065c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f11066d);
        this.f11063a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f11065c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f11065c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.f11063a.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f11063a.get(i10);
            if (StateSet.stateSetMatches(bVar.f11068a, iArr)) {
                break;
            }
            i10++;
        }
        b bVar2 = this.f11064b;
        if (bVar != bVar2) {
            if (bVar2 != null) {
                b();
            }
            this.f11064b = bVar;
            if (bVar != null) {
                e(bVar);
            }
        }
    }
}
