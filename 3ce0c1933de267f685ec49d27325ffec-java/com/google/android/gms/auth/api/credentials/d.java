package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<CredentialRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        String[] strArr = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 != 1000) {
                switch (u10) {
                    case 1:
                        z10 = SafeParcelReader.v(parcel, B);
                        continue;
                    case 2:
                        strArr = SafeParcelReader.p(parcel, B);
                        continue;
                    case 3:
                        credentialPickerConfig = (CredentialPickerConfig) SafeParcelReader.n(parcel, B, CredentialPickerConfig.CREATOR);
                        continue;
                    case 4:
                        credentialPickerConfig2 = (CredentialPickerConfig) SafeParcelReader.n(parcel, B, CredentialPickerConfig.CREATOR);
                        continue;
                    case 5:
                        z11 = SafeParcelReader.v(parcel, B);
                        continue;
                    case 6:
                        str = SafeParcelReader.o(parcel, B);
                        continue;
                    case 7:
                        str2 = SafeParcelReader.o(parcel, B);
                        continue;
                    case 8:
                        z12 = SafeParcelReader.v(parcel, B);
                        continue;
                    default:
                        SafeParcelReader.K(parcel, B);
                        continue;
                }
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new CredentialRequest(i10, z10, strArr, credentialPickerConfig, credentialPickerConfig2, z11, str, str2, z12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest[] newArray(int i10) {
        return new CredentialRequest[i10];
    }
}
