package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class o0 implements Parcelable.Creator<zzeu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeu createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        long j10 = 0;
        zzer zzerVar = null;
        String str2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                zzerVar = (zzer) SafeParcelReader.n(parcel, B, zzer.CREATOR);
            } else if (u10 == 4) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                j10 = SafeParcelReader.G(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzeu(str, zzerVar, str2, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeu[] newArray(int i10) {
        return new zzeu[i10];
    }
}
