package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class e implements Parcelable.Creator<SafeParcelResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeParcelResponse createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Parcel parcel2 = null;
        int i10 = 0;
        zak zakVar = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                parcel2 = SafeParcelReader.l(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                zakVar = (zak) SafeParcelReader.n(parcel, B, zak.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new SafeParcelResponse(i10, parcel2, zakVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeParcelResponse[] newArray(int i10) {
        return new SafeParcelResponse[i10];
    }
}
