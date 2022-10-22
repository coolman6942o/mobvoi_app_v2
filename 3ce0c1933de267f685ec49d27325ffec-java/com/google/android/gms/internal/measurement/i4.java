package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f9364a = true;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f9365b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ zzeu f9366c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ zzdz f9367d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f9368e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ a4 f9369f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i4(a4 a4Var, boolean z10, boolean z11, zzeu zzeuVar, zzdz zzdzVar, String str) {
        this.f9369f = a4Var;
        this.f9365b = z11;
        this.f9366c = zzeuVar;
        this.f9367d = zzdzVar;
        this.f9368e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0 r0Var;
        r0Var = this.f9369f.f9160d;
        if (r0Var == null) {
            this.f9369f.c().K().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f9364a) {
            this.f9369f.G(r0Var, this.f9365b ? null : this.f9366c, this.f9367d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f9368e)) {
                    r0Var.l1(this.f9366c, this.f9367d);
                } else {
                    r0Var.w0(this.f9366c, this.f9368e, this.f9369f.c().T());
                }
            } catch (RemoteException e10) {
                this.f9369f.c().K().d("Failed to send event to the service", e10);
            }
        }
        this.f9369f.R();
    }
}
