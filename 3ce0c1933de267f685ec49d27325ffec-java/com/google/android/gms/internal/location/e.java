package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import t6.f;
/* loaded from: classes.dex */
public abstract class e extends q implements d {
    public e() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.q
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        C((zzad) f.a(parcel, zzad.CREATOR));
        return true;
    }
}
