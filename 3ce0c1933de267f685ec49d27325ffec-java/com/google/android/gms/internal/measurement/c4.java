package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzdz f9200a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a4 f9201b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c4(a4 a4Var, zzdz zzdzVar) {
        this.f9201b = a4Var;
        this.f9200a = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0 r0Var;
        r0Var = this.f9201b.f9160d;
        if (r0Var == null) {
            this.f9201b.c().K().a("Failed to reset data on the service; null service");
            return;
        }
        try {
            r0Var.Q0(this.f9200a);
        } catch (RemoteException e10) {
            this.f9201b.c().K().d("Failed to reset data on the service", e10);
        }
        this.f9201b.R();
    }
}
