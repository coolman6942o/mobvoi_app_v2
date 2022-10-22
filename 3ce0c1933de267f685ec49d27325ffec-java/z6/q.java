package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.Tile;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<Tile> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        byte[] bArr = null;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                bArr = SafeParcelReader.g(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new Tile(i10, i11, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile[] newArray(int i10) {
        return new Tile[i10];
    }
}
