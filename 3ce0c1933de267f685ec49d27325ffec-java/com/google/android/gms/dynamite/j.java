package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import k6.b;
import r6.a;
import r6.c;
/* loaded from: classes.dex */
public final class j extends a implements i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.i
    public final b K1(b bVar, String str, int i10) throws RemoteException {
        Parcel m12 = m1();
        c.c(m12, bVar);
        m12.writeString(str);
        m12.writeInt(i10);
        Parcel U1 = U1(4, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }

    @Override // com.google.android.gms.dynamite.i
    public final int V1(b bVar, String str, boolean z10) throws RemoteException {
        Parcel m12 = m1();
        c.c(m12, bVar);
        m12.writeString(str);
        c.a(m12, z10);
        Parcel U1 = U1(5, m12);
        int readInt = U1.readInt();
        U1.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.i
    public final int d2() throws RemoteException {
        Parcel U1 = U1(6, m1());
        int readInt = U1.readInt();
        U1.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.i
    public final b i2(b bVar, String str, int i10) throws RemoteException {
        Parcel m12 = m1();
        c.c(m12, bVar);
        m12.writeString(str);
        m12.writeInt(i10);
        Parcel U1 = U1(2, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }

    @Override // com.google.android.gms.dynamite.i
    public final int w2(b bVar, String str, boolean z10) throws RemoteException {
        Parcel m12 = m1();
        c.c(m12, bVar);
        m12.writeString(str);
        c.a(m12, z10);
        Parcel U1 = U1(3, m12);
        int readInt = U1.readInt();
        U1.recycle();
        return readInt;
    }
}
