package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzay;
/* loaded from: classes.dex */
public final class g implements Parcelable.Creator<zzay> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzay createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                str3 = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzay(str, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzay[] newArray(int i10) {
        return new zzay[i10];
    }
}
