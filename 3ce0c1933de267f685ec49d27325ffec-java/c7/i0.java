package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzay;
import com.google.android.gms.wearable.internal.zzfq;
/* loaded from: classes.dex */
public final class i0 implements Parcelable.Creator<zzfq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfq createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        zzay zzayVar = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                zzayVar = (zzay) SafeParcelReader.n(parcel, B, zzay.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzfq(i10, zzayVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfq[] newArray(int i10) {
        return new zzfq[i10];
    }
}
