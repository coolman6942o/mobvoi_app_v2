package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.internal.zzdw;
/* loaded from: classes.dex */
public final class x implements Parcelable.Creator<zzdw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdw createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        ConnectionConfiguration connectionConfiguration = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                connectionConfiguration = (ConnectionConfiguration) SafeParcelReader.n(parcel, B, ConnectionConfiguration.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdw(i10, connectionConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdw[] newArray(int i10) {
        return new zzdw[i10];
    }
}
