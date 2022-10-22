package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzdk;
/* loaded from: classes.dex */
public final class r implements Parcelable.Creator<zzdk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdk createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        zzah zzahVar = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                zzahVar = (zzah) SafeParcelReader.n(parcel, B, zzah.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdk(i10, zzahVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdk[] newArray(int i10) {
        return new zzdk[i10];
    }
}
