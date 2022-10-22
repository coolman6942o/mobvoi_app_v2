package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.internal.zzdy;
/* loaded from: classes.dex */
public final class y implements Parcelable.Creator<zzdy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdy createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        ConnectionConfiguration[] connectionConfigurationArr = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                connectionConfigurationArr = (ConnectionConfiguration[]) SafeParcelReader.r(parcel, B, ConnectionConfiguration.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdy(i10, connectionConfigurationArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdy[] newArray(int i10) {
        return new zzdy[i10];
    }
}
