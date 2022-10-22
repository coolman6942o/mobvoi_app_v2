package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzbn;
/* loaded from: classes.dex */
public final class h implements Parcelable.Creator<zzbn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbn createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzbn(i10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbn[] newArray(int i10) {
        return new zzbn[i10];
    }
}
