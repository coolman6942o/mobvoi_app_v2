package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
final class h extends b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ g f8430a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f8430a = gVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.b, com.google.android.gms.auth.api.signin.internal.l
    public final void J(Status status) throws RemoteException {
        this.f8430a.j(status);
    }
}
