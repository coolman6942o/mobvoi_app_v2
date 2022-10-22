package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9591a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9592b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p3(c3 c3Var, AtomicReference atomicReference) {
        this.f9592b = c3Var;
        this.f9591a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9591a) {
            AtomicReference atomicReference = this.f9591a;
            a0 s10 = this.f9592b.s();
            atomicReference.set(Integer.valueOf(s10.E(s10.j().A(), p0.M)));
            this.f9591a.notify();
        }
    }
}
