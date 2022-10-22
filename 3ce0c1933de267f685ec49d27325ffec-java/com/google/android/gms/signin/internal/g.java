package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.f;
import q6.a;
import q6.c;
/* loaded from: classes.dex */
public final class g extends a implements f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.f
    public final void B(int i10) throws RemoteException {
        Parcel m12 = m1();
        m12.writeInt(i10);
        U1(7, m12);
    }

    @Override // com.google.android.gms.signin.internal.f
    public final void n0(f fVar, int i10, boolean z10) throws RemoteException {
        Parcel m12 = m1();
        c.c(m12, fVar);
        m12.writeInt(i10);
        c.a(m12, z10);
        U1(9, m12);
    }

    @Override // com.google.android.gms.signin.internal.f
    public final void y0(zah zahVar, d dVar) throws RemoteException {
        Parcel m12 = m1();
        c.d(m12, zahVar);
        c.c(m12, dVar);
        U1(12, m12);
    }
}
