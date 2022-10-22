package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzay;
/* loaded from: classes.dex */
public final class f implements Parcelable.Creator<zzaw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaw createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        zzay zzayVar = null;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                zzayVar = (zzay) SafeParcelReader.n(parcel, B, zzay.CREATOR);
            } else if (u10 == 3) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 4) {
                i12 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                i11 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzaw(zzayVar, i10, i12, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaw[] newArray(int i10) {
        return new zzaw[i10];
    }
}
