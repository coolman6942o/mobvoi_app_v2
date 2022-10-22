package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzfe;
/* loaded from: classes.dex */
public final class e0 implements Parcelable.Creator<zzfe> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfe createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i10 = 0;
        String str2 = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 4) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                str2 = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzfe(i10, str, bArr, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfe[] newArray(int i10) {
        return new zzfe[i10];
    }
}
