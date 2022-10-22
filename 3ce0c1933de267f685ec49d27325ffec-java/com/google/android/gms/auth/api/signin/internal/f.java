package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
final class f extends b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ e f8429a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f8429a = eVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.b, com.google.android.gms.auth.api.signin.internal.l
    public final void u(Status status) throws RemoteException {
        this.f8429a.j(status);
    }
}
