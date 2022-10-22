package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9321a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9322b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3(c3 c3Var, AtomicReference atomicReference) {
        this.f9322b = c3Var;
        this.f9321a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9322b.l().I(this.f9321a);
    }
}
