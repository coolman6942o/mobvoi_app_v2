package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9609a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9610b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q3(c3 c3Var, AtomicReference atomicReference) {
        this.f9610b = c3Var;
        this.f9609a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9609a) {
            AtomicReference atomicReference = this.f9609a;
            a0 s10 = this.f9610b.s();
            atomicReference.set(Double.valueOf(s10.G(s10.j().A(), p0.N)));
            this.f9609a.notify();
        }
    }
}
