package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<LocationAvailability> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 1000;
        long j10 = 0;
        zzaj[] zzajVarArr = null;
        int i11 = 1;
        int i12 = 1;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i12 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                j10 = SafeParcelReader.G(parcel, B);
            } else if (u10 == 4) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                zzajVarArr = (zzaj[]) SafeParcelReader.r(parcel, B, zzaj.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new LocationAvailability(i10, i11, i12, j10, zzajVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i10) {
        return new LocationAvailability[i10];
    }
}
