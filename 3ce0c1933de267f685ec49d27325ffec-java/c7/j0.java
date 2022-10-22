package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzfs;
/* loaded from: classes.dex */
public final class j0 implements Parcelable.Creator<zzfs> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfs createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        long j10 = 0;
        String str2 = null;
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
                j10 = SafeParcelReader.G(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzfs(str, str2, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfs[] newArray(int i10) {
        return new zzfs[i10];
    }
}
