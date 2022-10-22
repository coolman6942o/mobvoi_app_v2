package w6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
/* loaded from: classes.dex */
public final class f implements Parcelable.Creator<LocationSettingsResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsResult createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                status = (Status) SafeParcelReader.n(parcel, B, Status.CREATOR);
            } else if (u10 != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                locationSettingsStates = (LocationSettingsStates) SafeParcelReader.n(parcel, B, LocationSettingsStates.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsResult[] newArray(int i10) {
        return new LocationSettingsResult[i10];
    }
}
