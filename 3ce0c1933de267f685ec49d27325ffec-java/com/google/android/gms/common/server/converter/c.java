package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<StringToIntConverter.zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter.zaa createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        String str = null;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                i11 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new StringToIntConverter.zaa(i10, str, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter.zaa[] newArray(int i10) {
        return new StringToIntConverter.zaa[i10];
    }
}
