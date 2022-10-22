package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.wearable.b;
import v6.a;
/* loaded from: classes.dex */
public abstract class g extends b implements f {
    public g() {
        super("com.google.android.gms.wearable.internal.IWearableListener");
    }

    @Override // com.google.android.gms.internal.wearable.b
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 1:
                D((DataHolder) a.a(parcel, DataHolder.CREATOR));
                return true;
            case 2:
                C0((zzfe) a.a(parcel, zzfe.CREATOR));
                return true;
            case 3:
                T((zzfo) a.a(parcel, zzfo.CREATOR));
                return true;
            case 4:
                s1((zzfo) a.a(parcel, zzfo.CREATOR));
                return true;
            case 5:
                z2(parcel.createTypedArrayList(zzfo.CREATOR));
                return true;
            case 6:
                M1((zzl) a.a(parcel, zzl.CREATOR));
                return true;
            case 7:
                a((zzaw) a.a(parcel, zzaw.CREATOR));
                return true;
            case 8:
                a0((zzah) a.a(parcel, zzah.CREATOR));
                return true;
            case 9:
                t0((zzi) a.a(parcel, zzi.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
