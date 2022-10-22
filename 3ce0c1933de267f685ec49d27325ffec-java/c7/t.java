package c7;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzdo;
/* loaded from: classes.dex */
public final class t implements Parcelable.Creator<zzdo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdo createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.n(parcel, B, ParcelFileDescriptor.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdo(i10, parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdo[] newArray(int i10) {
        return new zzdo[i10];
    }
}
