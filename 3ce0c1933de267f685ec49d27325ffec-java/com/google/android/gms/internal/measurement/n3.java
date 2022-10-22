package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9531a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9532b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n3(c3 c3Var, AtomicReference atomicReference) {
        this.f9532b = c3Var;
        this.f9531a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9531a) {
            this.f9531a.set(this.f9532b.s().P());
            this.f9531a.notify();
        }
    }
}
