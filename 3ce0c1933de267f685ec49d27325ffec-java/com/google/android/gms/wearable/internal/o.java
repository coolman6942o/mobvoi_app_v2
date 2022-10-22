package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import c7.g0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.wearable.k;
/* loaded from: classes.dex */
final class o extends y<k.b> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ h g(Status status) {
        return new g0(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void r(x xVar) throws RemoteException {
        ((i) xVar.G()).S(new u(this));
    }
}
