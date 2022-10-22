package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9533a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzdz f9534b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ boolean f9535c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ a4 f9536d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n4(a4 a4Var, AtomicReference atomicReference, zzdz zzdzVar, boolean z10) {
        this.f9536d = a4Var;
        this.f9533a = atomicReference;
        this.f9534b = zzdzVar;
        this.f9535c = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        r0 r0Var;
        synchronized (this.f9533a) {
            try {
                r0Var = this.f9536d.f9160d;
            } catch (RemoteException e10) {
                this.f9536d.c().K().d("Failed to get user properties", e10);
                atomicReference = this.f9533a;
            }
            if (r0Var == null) {
                this.f9536d.c().K().a("Failed to get user properties");
                this.f9533a.notify();
                return;
            }
            this.f9533a.set(r0Var.i1(this.f9534b, this.f9535c));
            this.f9536d.R();
            atomicReference = this.f9533a;
            atomicReference.notify();
        }
    }
}
