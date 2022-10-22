package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;
/* loaded from: classes.dex */
public final class r implements Parcelable.Creator<VisibleRegion> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                latLng = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
            } else if (u10 == 3) {
                latLng2 = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
            } else if (u10 == 4) {
                latLng3 = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
            } else if (u10 == 5) {
                latLng4 = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
            } else if (u10 != 6) {
                SafeParcelReader.K(parcel, B);
            } else {
                latLngBounds = (LatLngBounds) SafeParcelReader.n(parcel, B, LatLngBounds.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new VisibleRegion(latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion[] newArray(int i10) {
        return new VisibleRegion[i10];
    }
}
