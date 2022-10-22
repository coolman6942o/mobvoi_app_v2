package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9265a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f9266b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c3 f9267c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f3(c3 c3Var, AtomicReference atomicReference, boolean z10) {
        this.f9267c = c3Var;
        this.f9265a = atomicReference;
        this.f9266b = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9267c.l().L(this.f9265a, this.f9266b);
    }
}
