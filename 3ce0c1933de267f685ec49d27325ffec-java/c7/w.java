package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzdv;
/* loaded from: classes.dex */
public final class w implements Parcelable.Creator<zzdv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdv createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                z10 = SafeParcelReader.v(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdv(i10, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdv[] newArray(int i10) {
        return new zzdv[i10];
    }
}
