package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzdz f9323a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a4 f9324b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h4(a4 a4Var, zzdz zzdzVar) {
        this.f9324b = a4Var;
        this.f9323a = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0 r0Var;
        r0Var = this.f9324b.f9160d;
        if (r0Var == null) {
            this.f9324b.c().K().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            r0Var.c0(this.f9323a);
            this.f9324b.R();
        } catch (RemoteException e10) {
            this.f9324b.c().K().d("Failed to send measurementEnabled to the service", e10);
        }
    }
}
