package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
/* loaded from: classes.dex */
public final class g implements Parcelable.Creator<LatLngBounds> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLngBounds createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                latLng = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                latLng2 = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new LatLngBounds(latLng, latLng2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLngBounds[] newArray(int i10) {
        return new LatLngBounds[i10];
    }
}
