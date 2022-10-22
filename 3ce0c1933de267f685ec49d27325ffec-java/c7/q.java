package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzdi;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<zzdi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdi createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, zzah.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdi(i10, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdi[] newArray(int i10) {
        return new zzdi[i10];
    }
}
