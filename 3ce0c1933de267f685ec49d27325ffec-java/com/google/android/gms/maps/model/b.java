package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<CircleOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        float f10 = 0.0f;
        LatLng latLng = null;
        int i10 = 0;
        double d10 = 0.0d;
        float f11 = 0.0f;
        ArrayList arrayList = null;
        int i11 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    d10 = SafeParcelReader.x(parcel, B);
                    break;
                case 4:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 5:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 6:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 7:
                    f11 = SafeParcelReader.z(parcel, B);
                    break;
                case 8:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 9:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 10:
                    arrayList = SafeParcelReader.s(parcel, B, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new CircleOptions(latLng, d10, f10, i10, i11, f11, z10, z11, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions[] newArray(int i10) {
        return new CircleOptions[i10];
    }
}
