package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzfo;
/* loaded from: classes.dex */
public final class h0 implements Parcelable.Creator<zzfo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfo createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        String str = null;
        String str2 = null;
        boolean z10 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 == 4) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                z10 = SafeParcelReader.v(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzfo(str, str2, i10, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfo[] newArray(int i10) {
        return new zzfo[i10];
    }
}
