package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<SignInButtonConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        Scope[] scopeArr = null;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i12 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.r(parcel, B, Scope.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new SignInButtonConfig(i10, i12, i11, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig[] newArray(int i10) {
        return new SignInButtonConfig[i10];
    }
}
