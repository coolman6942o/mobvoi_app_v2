package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class x implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        zzm zzmVar = null;
        int i10 = 1;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                zzmVar = (zzm) SafeParcelReader.n(parcel, B, zzm.CREATOR);
            } else if (u10 == 3) {
                iBinder = SafeParcelReader.C(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                iBinder2 = SafeParcelReader.C(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzo(i10, zzmVar, iBinder, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i10) {
        return new zzo[i10];
    }
}
