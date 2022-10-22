package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        Intent intent = null;
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
                intent = (Intent) SafeParcelReader.n(parcel, B, Intent.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zaa(i10, i11, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa[] newArray(int i10) {
        return new zaa[i10];
    }
}
