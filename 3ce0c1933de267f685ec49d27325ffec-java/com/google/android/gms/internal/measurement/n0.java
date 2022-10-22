package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class n0 implements Parcelable.Creator<zzer> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzer createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                bundle = SafeParcelReader.f(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzer(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzer[] newArray(int i10) {
        return new zzer[i10];
    }
}
