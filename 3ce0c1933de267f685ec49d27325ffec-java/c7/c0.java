package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzeg;
import com.google.android.gms.wearable.internal.zzfo;
/* loaded from: classes.dex */
public final class c0 implements Parcelable.Creator<zzeg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeg createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        zzfo zzfoVar = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                zzfoVar = (zzfo) SafeParcelReader.n(parcel, B, zzfo.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzeg(i10, zzfoVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeg[] newArray(int i10) {
        return new zzeg[i10];
    }
}
