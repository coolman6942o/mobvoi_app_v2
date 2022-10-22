package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p000authapi.a;
/* loaded from: classes.dex */
public final class o extends a implements n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.n
    public final void E0(l lVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel m12 = m1();
        p6.a.b(m12, lVar);
        p6.a.c(m12, googleSignInOptions);
        U1(103, m12);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.n
    public final void v0(l lVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel m12 = m1();
        p6.a.b(m12, lVar);
        p6.a.c(m12, googleSignInOptions);
        U1(102, m12);
    }
}
