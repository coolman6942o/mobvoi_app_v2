package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<PlaceReport> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceReport createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i10 = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                str3 = SafeParcelReader.o(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                str2 = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new PlaceReport(i10, str, str3, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceReport[] newArray(int i10) {
        return new PlaceReport[i10];
    }
}
