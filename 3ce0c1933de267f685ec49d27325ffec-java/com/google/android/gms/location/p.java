package com.google.android.gms.location;

import android.os.RemoteException;
import b6.a;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.location.e;
import com.google.android.gms.internal.location.zzad;
import com.google.android.gms.tasks.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends e {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c f9955a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar, c cVar) {
        this.f9955a = cVar;
    }

    @Override // com.google.android.gms.internal.location.d
    public final void C(zzad zzadVar) throws RemoteException {
        Status status = zzadVar.getStatus();
        if (status == null) {
            this.f9955a.d(new ApiException(new Status(8, "Got null status from location service")));
        } else if (status.H0() == 0) {
            this.f9955a.c(Boolean.TRUE);
        } else {
            this.f9955a.d(a.a(status));
        }
    }
}
