package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9550a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9551b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o3(c3 c3Var, AtomicReference atomicReference) {
        this.f9551b = c3Var;
        this.f9550a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9550a) {
            AtomicReference atomicReference = this.f9550a;
            a0 s10 = this.f9551b.s();
            atomicReference.set(Long.valueOf(s10.t(s10.j().A(), p0.L)));
            this.f9550a.notify();
        }
    }
}
