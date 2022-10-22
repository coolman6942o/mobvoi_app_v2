package com.google.android.gms.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.internal.location.p;
import com.google.android.gms.tasks.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends o<p, Location> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.o
    public final /* synthetic */ void a(p pVar, c<Location> cVar) throws RemoteException {
        cVar.c(pVar.r0());
    }
}
