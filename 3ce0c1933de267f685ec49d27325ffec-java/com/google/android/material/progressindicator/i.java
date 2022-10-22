package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndeterminateAnimatorDelegate.java */
/* loaded from: classes.dex */
public abstract class i<T extends Animator> {

    /* renamed from: a  reason: collision with root package name */
    protected j f11251a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f11252b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f11253c;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(int i10) {
        this.f11252b = new float[i10 * 2];
        this.f11253c = new int[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public float b(int i10, int i11, int i12) {
        return (i10 - i11) / i12;
    }

    public abstract void c();

    public abstract void d(b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(j jVar) {
        this.f11251a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
