package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<zzfw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfw createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                iBinder = SafeParcelReader.C(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzfw(i10, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfw[] newArray(int i10) {
        return new zzfw[i10];
    }
}
