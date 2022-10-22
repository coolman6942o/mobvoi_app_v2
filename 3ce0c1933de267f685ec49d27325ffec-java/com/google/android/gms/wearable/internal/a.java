package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<DataItemAssetParcelable> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataItemAssetParcelable createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                str2 = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new DataItemAssetParcelable(str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataItemAssetParcelable[] newArray(int i10) {
        return new DataItemAssetParcelable[i10];
    }
}
