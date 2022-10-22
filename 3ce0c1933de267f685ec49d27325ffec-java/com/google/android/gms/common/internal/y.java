package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import r6.b;
import r6.c;
/* loaded from: classes.dex */
public abstract class y extends b implements x {
    public y() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static x m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof x) {
            return (x) queryLocalInterface;
        }
        return new z(iBinder);
    }

    @Override // r6.b
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            k6.b Y1 = Y1();
            parcel2.writeNoException();
            c.c(parcel2, Y1);
        } else if (i10 != 2) {
            return false;
        } else {
            int t22 = t2();
            parcel2.writeNoException();
            parcel2.writeInt(t22);
        }
        return true;
    }
}
