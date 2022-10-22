package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<MarkerOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        boolean z10 = false;
        LatLng latLng = null;
        float f10 = 0.0f;
        float f11 = 0.5f;
        float f12 = 1.0f;
        boolean z11 = false;
        boolean z12 = false;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    iBinder = SafeParcelReader.C(parcel, B);
                    break;
                case 6:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 7:
                    f13 = SafeParcelReader.z(parcel, B);
                    break;
                case 8:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 9:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 10:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                case 11:
                    f14 = SafeParcelReader.z(parcel, B);
                    break;
                case 12:
                    f11 = SafeParcelReader.z(parcel, B);
                    break;
                case 13:
                    f15 = SafeParcelReader.z(parcel, B);
                    break;
                case 14:
                    f12 = SafeParcelReader.z(parcel, B);
                    break;
                case 15:
                    f16 = SafeParcelReader.z(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new MarkerOptions(latLng, str, str2, iBinder, f10, f13, z10, z11, z12, f14, f11, f15, f12, f16);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions[] newArray(int i10) {
        return new MarkerOptions[i10];
    }
}
