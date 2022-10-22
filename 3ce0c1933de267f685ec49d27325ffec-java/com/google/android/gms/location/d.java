package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<LocationResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        List<Location> list = LocationResult.f9937b;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.K(parcel, B);
            } else {
                list = SafeParcelReader.s(parcel, B, Location.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new LocationResult(list);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult[] newArray(int i10) {
        return new LocationResult[i10];
    }
}
