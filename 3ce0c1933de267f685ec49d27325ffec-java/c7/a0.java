package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzdd;
import com.google.android.gms.wearable.internal.zzec;
/* loaded from: classes.dex */
public final class a0 implements Parcelable.Creator<zzec> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzec createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        zzdd zzddVar = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                zzddVar = (zzdd) SafeParcelReader.n(parcel, B, zzdd.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzec(i10, zzddVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzec[] newArray(int i10) {
        return new zzec[i10];
    }
}
