package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9226a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9227b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d3(c3 c3Var, AtomicReference atomicReference) {
        this.f9227b = c3Var;
        this.f9226a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9226a) {
            this.f9226a.set(Boolean.valueOf(this.f9227b.s().O()));
            this.f9226a.notify();
        }
    }
}
