package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class l implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j10 = 50;
        float f10 = 0.0f;
        long j11 = Long.MAX_VALUE;
        int i10 = Integer.MAX_VALUE;
        boolean z10 = true;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 2) {
                j10 = SafeParcelReader.G(parcel, B);
            } else if (u10 == 3) {
                f10 = SafeParcelReader.z(parcel, B);
            } else if (u10 == 4) {
                j11 = SafeParcelReader.G(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzj(z10, j10, f10, j11, i10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i10) {
        return new zzj[i10];
    }
}
