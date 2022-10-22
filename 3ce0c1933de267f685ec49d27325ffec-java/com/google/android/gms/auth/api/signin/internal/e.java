package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends i<Status> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ h g(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void r(c cVar) throws RemoteException {
        c cVar2 = cVar;
        ((n) cVar2.G()).v0(new f(this), cVar2.q0());
    }
}
