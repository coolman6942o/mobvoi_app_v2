package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<Cap> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Cap createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        IBinder iBinder = null;
        int i10 = 0;
        Float f10 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                iBinder = SafeParcelReader.C(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                f10 = SafeParcelReader.A(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new Cap(i10, iBinder, f10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Cap[] newArray(int i10) {
        return new Cap[i10];
    }
}
