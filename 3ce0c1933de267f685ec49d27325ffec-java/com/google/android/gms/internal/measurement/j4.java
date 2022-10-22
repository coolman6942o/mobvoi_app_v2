package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f9384a = true;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f9385b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ zzed f9386c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ zzdz f9387d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ zzed f9388e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ a4 f9389f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j4(a4 a4Var, boolean z10, boolean z11, zzed zzedVar, zzdz zzdzVar, zzed zzedVar2) {
        this.f9389f = a4Var;
        this.f9385b = z11;
        this.f9386c = zzedVar;
        this.f9387d = zzdzVar;
        this.f9388e = zzedVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0 r0Var;
        r0Var = this.f9389f.f9160d;
        if (r0Var == null) {
            this.f9389f.c().K().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f9384a) {
            this.f9389f.G(r0Var, this.f9385b ? null : this.f9386c, this.f9387d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f9388e.f9876a)) {
                    r0Var.X0(this.f9386c, this.f9387d);
                } else {
                    r0Var.C1(this.f9386c);
                }
            } catch (RemoteException e10) {
                this.f9389f.c().K().d("Failed to send conditional user property to the service", e10);
            }
        }
        this.f9389f.R();
    }
}
