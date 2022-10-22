package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes.dex */
public final class h implements Parcelable.Creator<LatLng> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLng createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        double d10 = 0.0d;
        double d11 = 0.0d;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                d10 = SafeParcelReader.x(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                d11 = SafeParcelReader.x(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new LatLng(d10, d11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLng[] newArray(int i10) {
        return new LatLng[i10];
    }
}
