package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<GroundOverlayOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GroundOverlayOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        boolean z10 = false;
        IBinder iBinder = null;
        float f10 = 0.0f;
        boolean z11 = false;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    iBinder = SafeParcelReader.C(parcel, B);
                    break;
                case 3:
                    latLng = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
                    break;
                case 4:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 5:
                    f11 = SafeParcelReader.z(parcel, B);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) SafeParcelReader.n(parcel, B, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f12 = SafeParcelReader.z(parcel, B);
                    break;
                case 8:
                    f13 = SafeParcelReader.z(parcel, B);
                    break;
                case 9:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 10:
                    f14 = SafeParcelReader.z(parcel, B);
                    break;
                case 11:
                    f15 = SafeParcelReader.z(parcel, B);
                    break;
                case 12:
                    f16 = SafeParcelReader.z(parcel, B);
                    break;
                case 13:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new GroundOverlayOptions(iBinder, latLng, f10, f11, latLngBounds, f12, f13, z10, f14, f15, f16, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GroundOverlayOptions[] newArray(int i10) {
        return new GroundOverlayOptions[i10];
    }
}
