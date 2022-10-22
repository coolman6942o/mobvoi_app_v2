package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import c7.f0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.wearable.k;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class p extends y<k.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ h g(Status status) {
        return new f0(status, new ArrayList());
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void r(x xVar) throws RemoteException {
        ((i) xVar.G()).h1(new t(this));
    }
}
