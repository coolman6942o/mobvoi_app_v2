package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzdg;
/* loaded from: classes.dex */
public final class p implements Parcelable.Creator<zzdg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdg createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                i11 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdg(i10, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdg[] newArray(int i10) {
        return new zzdg[i10];
    }
}
