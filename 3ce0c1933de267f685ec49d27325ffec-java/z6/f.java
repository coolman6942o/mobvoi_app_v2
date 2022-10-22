package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes.dex */
public final class f implements Parcelable.Creator<CameraPosition> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        float f10 = 0.0f;
        LatLng latLng = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                latLng = (LatLng) SafeParcelReader.n(parcel, B, LatLng.CREATOR);
            } else if (u10 == 3) {
                f10 = SafeParcelReader.z(parcel, B);
            } else if (u10 == 4) {
                f12 = SafeParcelReader.z(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                f11 = SafeParcelReader.z(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new CameraPosition(latLng, f10, f12, f11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition[] newArray(int i10) {
        return new CameraPosition[i10];
    }
}
