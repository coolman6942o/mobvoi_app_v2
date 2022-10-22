package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ w3 f9268a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a4 f9269b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f4(a4 a4Var, w3 w3Var) {
        this.f9269b = a4Var;
        this.f9268a = w3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0 r0Var;
        long j10;
        String str;
        String str2;
        String packageName;
        r0Var = this.f9269b.f9160d;
        if (r0Var == null) {
            this.f9269b.c().K().a("Failed to send current screen to service");
            return;
        }
        try {
            w3 w3Var = this.f9268a;
            if (w3Var == null) {
                j10 = 0;
                str = null;
                str2 = null;
                packageName = this.f9269b.getContext().getPackageName();
            } else {
                j10 = w3Var.f9774c;
                str = w3Var.f9772a;
                str2 = w3Var.f9773b;
                packageName = this.f9269b.getContext().getPackageName();
            }
            r0Var.x0(j10, str, str2, packageName);
            this.f9269b.R();
        } catch (RemoteException e10) {
            this.f9269b.c().K().d("Failed to send current screen to the service", e10);
        }
    }
}
