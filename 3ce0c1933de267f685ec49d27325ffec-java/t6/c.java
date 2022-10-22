package t6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzbh;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<zzbh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbh createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        double d10 = 0.0d;
        int i10 = 0;
        String str = null;
        float f10 = 0.0f;
        long j10 = 0;
        int i11 = -1;
        double d11 = 0.0d;
        short s10 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 2:
                    j10 = SafeParcelReader.G(parcel, B);
                    break;
                case 3:
                    s10 = SafeParcelReader.I(parcel, B);
                    break;
                case 4:
                    d10 = SafeParcelReader.x(parcel, B);
                    break;
                case 5:
                    d11 = SafeParcelReader.x(parcel, B);
                    break;
                case 6:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 7:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 8:
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 9:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzbh(str, i10, s10, d10, d11, f10, j10, i12, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbh[] newArray(int i10) {
        return new zzbh[i10];
    }
}
