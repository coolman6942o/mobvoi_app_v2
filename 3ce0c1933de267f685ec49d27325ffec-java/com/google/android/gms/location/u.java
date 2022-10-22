package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.q;
import t6.f;
/* loaded from: classes.dex */
public abstract class u extends q implements t {
    public u() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static t m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof t ? (t) queryLocalInterface : new v(iBinder);
    }

    @Override // com.google.android.gms.internal.location.q
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            q1((LocationResult) f.a(parcel, LocationResult.CREATOR));
        } else if (i10 != 2) {
            return false;
        } else {
            L0((LocationAvailability) f.a(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
