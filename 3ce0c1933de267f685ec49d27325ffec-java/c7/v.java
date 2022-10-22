package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzdt;
/* loaded from: classes.dex */
public final class v implements Parcelable.Creator<zzdt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdt createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                z11 = SafeParcelReader.v(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdt(i10, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdt[] newArray(int i10) {
        return new zzdt[i10];
    }
}
