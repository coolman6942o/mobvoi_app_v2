package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;
/* loaded from: classes.dex */
public final class e implements Parcelable.Creator<StreetViewPanoramaOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        byte b10 = 0;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        byte b11 = 0;
        byte b12 = 0;
        byte b13 = 0;
        byte b14 = 0;
        String str = null;
        LatLng latLng = null;
        Integer num = null;
        StreetViewSource streetViewSource = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) SafeParcelReader.n(parcel, B, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
                    break;
                case 5:
                    num = SafeParcelReader.E(parcel, B);
                    break;
                case 6:
                    b10 = SafeParcelReader.w(parcel, B);
                    break;
                case 7:
                    b11 = SafeParcelReader.w(parcel, B);
                    break;
                case 8:
                    b12 = SafeParcelReader.w(parcel, B);
                    break;
                case 9:
                    b13 = SafeParcelReader.w(parcel, B);
                    break;
                case 10:
                    b14 = SafeParcelReader.w(parcel, B);
                    break;
                case 11:
                    streetViewSource = (StreetViewSource) SafeParcelReader.n(parcel, B, StreetViewSource.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, str, latLng, num, b10, b11, b12, b13, b14, streetViewSource);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions[] newArray(int i10) {
        return new StreetViewPanoramaOptions[i10];
    }
}
