package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class p implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        boolean z10 = false;
        String str = null;
        IBinder iBinder = null;
        boolean z11 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 2) {
                iBinder = SafeParcelReader.C(parcel, B);
            } else if (u10 == 3) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                z11 = SafeParcelReader.v(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzk(str, iBinder, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i10) {
        return new zzk[i10];
    }
}
