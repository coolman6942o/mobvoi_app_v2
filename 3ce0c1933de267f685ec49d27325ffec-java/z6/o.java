package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
/* loaded from: classes.dex */
public final class o implements Parcelable.Creator<StreetViewPanoramaOrientation> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        float f10 = 0.0f;
        float f11 = 0.0f;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                f10 = SafeParcelReader.z(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                f11 = SafeParcelReader.z(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new StreetViewPanoramaOrientation(f10, f11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOrientation[] newArray(int i10) {
        return new StreetViewPanoramaOrientation[i10];
    }
}
