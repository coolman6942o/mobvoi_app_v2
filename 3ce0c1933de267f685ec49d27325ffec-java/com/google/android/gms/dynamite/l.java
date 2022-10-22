package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import k6.b;
import r6.a;
import r6.c;
/* loaded from: classes.dex */
public final class l extends a implements k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.k
    public final b E1(b bVar, String str, int i10, b bVar2) throws RemoteException {
        Parcel m12 = m1();
        c.c(m12, bVar);
        m12.writeString(str);
        m12.writeInt(i10);
        c.c(m12, bVar2);
        Parcel U1 = U1(3, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }

    @Override // com.google.android.gms.dynamite.k
    public final b d1(b bVar, String str, int i10, b bVar2) throws RemoteException {
        Parcel m12 = m1();
        c.c(m12, bVar);
        m12.writeString(str);
        m12.writeInt(i10);
        c.c(m12, bVar2);
        Parcel U1 = U1(2, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }
}
