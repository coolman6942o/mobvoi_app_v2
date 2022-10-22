package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class f implements Parcelable.Creator<LocationSettingsRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        boolean z10 = false;
        ArrayList arrayList = null;
        zzae zzaeVar = null;
        boolean z11 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                arrayList = SafeParcelReader.s(parcel, B, LocationRequest.CREATOR);
            } else if (u10 == 2) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 3) {
                z11 = SafeParcelReader.v(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                zzaeVar = (zzae) SafeParcelReader.n(parcel, B, zzae.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new LocationSettingsRequest(arrayList, z10, z11, zzaeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest[] newArray(int i10) {
        return new LocationSettingsRequest[i10];
    }
}
