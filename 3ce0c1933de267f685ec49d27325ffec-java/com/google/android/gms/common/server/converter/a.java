package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                stringToIntConverter = (StringToIntConverter) SafeParcelReader.n(parcel, B, StringToIntConverter.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zaa(i10, stringToIntConverter);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa[] newArray(int i10) {
        return new zaa[i10];
    }
}
