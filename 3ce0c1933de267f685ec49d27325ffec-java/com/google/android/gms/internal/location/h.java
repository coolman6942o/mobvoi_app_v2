package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import t6.f;
/* loaded from: classes.dex */
public final class h extends a implements g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.g
    public final void D0(zzo zzoVar) throws RemoteException {
        Parcel m12 = m1();
        f.b(m12, zzoVar);
        A2(75, m12);
    }

    @Override // com.google.android.gms.internal.location.g
    public final void G1(zzbf zzbfVar) throws RemoteException {
        Parcel m12 = m1();
        f.b(m12, zzbfVar);
        A2(59, m12);
    }

    @Override // com.google.android.gms.internal.location.g
    public final Location H1(String str) throws RemoteException {
        Parcel m12 = m1();
        m12.writeString(str);
        Parcel U1 = U1(21, m12);
        Location location = (Location) f.a(U1, Location.CREATOR);
        U1.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.location.g
    public final void w1(boolean z10) throws RemoteException {
        Parcel m12 = m1();
        f.c(m12, z10);
        A2(12, m12);
    }
}
