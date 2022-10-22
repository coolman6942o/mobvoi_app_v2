package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import k6.b;
import r6.a;
/* loaded from: classes.dex */
public final class z extends a implements x {
    /* JADX INFO: Access modifiers changed from: package-private */
    public z(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.x
    public final b Y1() throws RemoteException {
        Parcel U1 = U1(1, m1());
        b m12 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m12;
    }

    @Override // com.google.android.gms.common.internal.x
    public final int t2() throws RemoteException {
        Parcel U1 = U1(2, m1());
        int readInt = U1.readInt();
        U1.recycle();
        return readInt;
    }
}
