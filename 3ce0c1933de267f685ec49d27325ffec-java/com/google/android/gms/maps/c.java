package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<GoogleMapOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleMapOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        CameraPosition cameraPosition = null;
        byte b10 = -1;
        int i10 = 0;
        Float f10 = null;
        Float f11 = null;
        LatLngBounds latLngBounds = null;
        byte b11 = -1;
        byte b12 = -1;
        byte b13 = -1;
        byte b14 = -1;
        byte b15 = -1;
        byte b16 = -1;
        byte b17 = -1;
        byte b18 = -1;
        byte b19 = -1;
        byte b20 = -1;
        byte b21 = -1;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    b10 = SafeParcelReader.w(parcel, B);
                    break;
                case 3:
                    b11 = SafeParcelReader.w(parcel, B);
                    break;
                case 4:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) SafeParcelReader.n(parcel, B, CameraPosition.CREATOR);
                    break;
                case 6:
                    b12 = SafeParcelReader.w(parcel, B);
                    break;
                case 7:
                    b13 = SafeParcelReader.w(parcel, B);
                    break;
                case 8:
                    b14 = SafeParcelReader.w(parcel, B);
                    break;
                case 9:
                    b15 = SafeParcelReader.w(parcel, B);
                    break;
                case 10:
                    b16 = SafeParcelReader.w(parcel, B);
                    break;
                case 11:
                    b17 = SafeParcelReader.w(parcel, B);
                    break;
                case 12:
                    b18 = SafeParcelReader.w(parcel, B);
                    break;
                case 13:
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
                case 14:
                    b19 = SafeParcelReader.w(parcel, B);
                    break;
                case 15:
                    b20 = SafeParcelReader.w(parcel, B);
                    break;
                case 16:
                    f10 = SafeParcelReader.A(parcel, B);
                    break;
                case 17:
                    f11 = SafeParcelReader.A(parcel, B);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) SafeParcelReader.n(parcel, B, LatLngBounds.CREATOR);
                    break;
                case 19:
                    b21 = SafeParcelReader.w(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new GoogleMapOptions(b10, b11, i10, cameraPosition, b12, b13, b14, b15, b16, b17, b18, b19, b20, f10, f11, latLngBounds, b21);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleMapOptions[] newArray(int i10) {
        return new GoogleMapOptions[i10];
    }
}
