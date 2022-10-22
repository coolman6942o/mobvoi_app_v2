package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class e implements Parcelable.Creator<HintRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HintRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        int i10 = 0;
        String[] strArr = null;
        String str = null;
        String str2 = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 != 1000) {
                switch (u10) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) SafeParcelReader.n(parcel, B, CredentialPickerConfig.CREATOR);
                        continue;
                    case 2:
                        z10 = SafeParcelReader.v(parcel, B);
                        continue;
                    case 3:
                        z11 = SafeParcelReader.v(parcel, B);
                        continue;
                    case 4:
                        strArr = SafeParcelReader.p(parcel, B);
                        continue;
                    case 5:
                        z12 = SafeParcelReader.v(parcel, B);
                        continue;
                    case 6:
                        str = SafeParcelReader.o(parcel, B);
                        continue;
                    case 7:
                        str2 = SafeParcelReader.o(parcel, B);
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
        return new HintRequest(i10, credentialPickerConfig, z10, z11, strArr, z12, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HintRequest[] newArray(int i10) {
        return new HintRequest[i10];
    }
}
