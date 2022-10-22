package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<StringToIntConverter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, StringToIntConverter.zaa.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new StringToIntConverter(i10, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter[] newArray(int i10) {
        return new StringToIntConverter[i10];
    }
}
