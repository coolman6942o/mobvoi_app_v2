package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class h implements Parcelable.Creator<TileOverlayOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        float f10 = 0.0f;
        IBinder iBinder = null;
        boolean z10 = false;
        boolean z11 = true;
        float f11 = 0.0f;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                iBinder = SafeParcelReader.C(parcel, B);
            } else if (u10 == 3) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 4) {
                f10 = SafeParcelReader.z(parcel, B);
            } else if (u10 == 5) {
                z11 = SafeParcelReader.v(parcel, B);
            } else if (u10 != 6) {
                SafeParcelReader.K(parcel, B);
            } else {
                f11 = SafeParcelReader.z(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new TileOverlayOptions(iBinder, z10, f10, z11, f11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions[] newArray(int i10) {
        return new TileOverlayOptions[i10];
    }
}
