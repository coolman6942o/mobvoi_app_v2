package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class s implements Parcelable.Creator<zzb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                bundle = SafeParcelReader.f(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                featureArr = (Feature[]) SafeParcelReader.r(parcel, B, Feature.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzb(bundle, featureArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb[] newArray(int i10) {
        return new zzb[i10];
    }
}
