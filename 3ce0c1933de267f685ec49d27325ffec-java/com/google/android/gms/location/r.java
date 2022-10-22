package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.q;
import w6.m;
/* loaded from: classes.dex */
public class r extends q implements m {
    public static m m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return queryLocalInterface instanceof m ? (m) queryLocalInterface : new s(iBinder);
    }

    @Override // com.google.android.gms.internal.location.q
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        throw new NoSuchMethodError();
    }
}
