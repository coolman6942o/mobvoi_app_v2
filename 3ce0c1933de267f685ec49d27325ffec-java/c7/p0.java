package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzfs;
import com.google.android.gms.wearable.internal.zzge;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class p0 implements Parcelable.Creator<zzge> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzge createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        long j10 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                j10 = SafeParcelReader.G(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, zzfs.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzge(i10, j10, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzge[] newArray(int i10) {
        return new zzge[i10];
    }
}
