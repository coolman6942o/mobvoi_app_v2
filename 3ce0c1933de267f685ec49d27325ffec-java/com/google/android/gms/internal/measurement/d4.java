package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9228a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzdz f9229b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ a4 f9230c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d4(a4 a4Var, AtomicReference atomicReference, zzdz zzdzVar) {
        this.f9230c = a4Var;
        this.f9228a = atomicReference;
        this.f9229b = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        r0 r0Var;
        synchronized (this.f9228a) {
            try {
                r0Var = this.f9230c.f9160d;
            } catch (RemoteException e10) {
                this.f9230c.c().K().d("Failed to get app instance id", e10);
                atomicReference = this.f9228a;
            }
            if (r0Var == null) {
                this.f9230c.c().K().a("Failed to get app instance id");
                this.f9228a.notify();
                return;
            }
            this.f9228a.set(r0Var.r1(this.f9229b));
            String str = (String) this.f9228a.get();
            if (str != null) {
                this.f9230c.i().j0(str);
                this.f9230c.r().f9439l.a(str);
            }
            this.f9230c.R();
            atomicReference = this.f9228a;
            atomicReference.notify();
        }
    }
}
