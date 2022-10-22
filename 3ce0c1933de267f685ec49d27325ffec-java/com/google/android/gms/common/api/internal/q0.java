package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
/* loaded from: classes.dex */
final class q0 implements d.c {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ n f8707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(n0 n0Var, n nVar) {
        this.f8707a = nVar;
    }

    @Override // com.google.android.gms.common.api.d.c
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f8707a.j(new Status(8));
    }
}
