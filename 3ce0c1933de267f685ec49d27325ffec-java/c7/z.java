package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzea;
import com.google.android.gms.wearable.internal.zzfo;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class z implements Parcelable.Creator<zzea> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzea createFromParcel(Parcel parcel) {
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
                arrayList = SafeParcelReader.s(parcel, B, zzfo.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzea(i10, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzea[] newArray(int i10) {
        return new zzea[i10];
    }
}
