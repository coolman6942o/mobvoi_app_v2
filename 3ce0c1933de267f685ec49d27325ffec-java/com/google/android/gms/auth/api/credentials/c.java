package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<CredentialPickerConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 2) {
                z11 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 3) {
                z12 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 4) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 1000) {
                SafeParcelReader.K(parcel, B);
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new CredentialPickerConfig(i10, z10, z11, z12, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig[] newArray(int i10) {
        return new CredentialPickerConfig[i10];
    }
}
