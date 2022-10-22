package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
/* loaded from: classes.dex */
public final class l implements Parcelable.Creator<StreetViewPanoramaCamera> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                f10 = SafeParcelReader.z(parcel, B);
            } else if (u10 == 3) {
                f11 = SafeParcelReader.z(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                f12 = SafeParcelReader.z(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new StreetViewPanoramaCamera(f10, f11, f12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaCamera[] newArray(int i10) {
        return new StreetViewPanoramaCamera[i10];
    }
}
