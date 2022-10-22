package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzdz f9252a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a4 f9253b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e4(a4 a4Var, zzdz zzdzVar) {
        this.f9253b = a4Var;
        this.f9252a = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0 r0Var;
        r0Var = this.f9253b.f9160d;
        if (r0Var == null) {
            this.f9253b.c().K().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            r0Var.r0(this.f9252a);
            this.f9253b.G(r0Var, null, this.f9252a);
            this.f9253b.R();
        } catch (RemoteException e10) {
            this.f9253b.c().K().d("Failed to send app launch to the service", e10);
        }
    }
}
