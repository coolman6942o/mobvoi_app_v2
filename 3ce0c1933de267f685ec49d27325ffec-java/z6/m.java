package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
/* loaded from: classes.dex */
public final class m implements Parcelable.Creator<StreetViewPanoramaLink> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        float f10 = 0.0f;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                f10 = SafeParcelReader.z(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new StreetViewPanoramaLink(str, f10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaLink[] newArray(int i10) {
        return new StreetViewPanoramaLink[i10];
    }
}
