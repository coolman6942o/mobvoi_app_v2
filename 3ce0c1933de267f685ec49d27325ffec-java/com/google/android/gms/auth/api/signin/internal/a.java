package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptionsExtensionParcelable createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        Bundle bundle = null;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                bundle = SafeParcelReader.f(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new GoogleSignInOptionsExtensionParcelable(i10, i11, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptionsExtensionParcelable[] newArray(int i10) {
        return new GoogleSignInOptionsExtensionParcelable[i10];
    }
}
