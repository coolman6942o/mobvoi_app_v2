package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class e implements Parcelable.Creator<DeviceMetaData> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DeviceMetaData createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        long j10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 3) {
                j10 = SafeParcelReader.G(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                z11 = SafeParcelReader.v(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new DeviceMetaData(i10, z10, j10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DeviceMetaData[] newArray(int i10) {
        return new DeviceMetaData[i10];
    }
}
