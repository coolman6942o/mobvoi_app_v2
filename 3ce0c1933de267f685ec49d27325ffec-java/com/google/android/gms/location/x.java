package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.q;
import t6.f;
/* loaded from: classes.dex */
public abstract class x extends q implements w {
    public x() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static w m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof w ? (w) queryLocalInterface : new y(iBinder);
    }

    @Override // com.google.android.gms.internal.location.q
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        onLocationChanged((Location) f.a(parcel, Location.CREATOR));
        return true;
    }
}
