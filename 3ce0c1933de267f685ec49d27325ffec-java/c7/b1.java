package c7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.internal.zzl;
/* loaded from: classes.dex */
public final class b1 implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        String str = null;
        byte b10 = 0;
        byte b11 = 0;
        byte b12 = 0;
        byte b13 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 6:
                    str4 = SafeParcelReader.o(parcel, B);
                    break;
                case 7:
                    str5 = SafeParcelReader.o(parcel, B);
                    break;
                case 8:
                    str6 = SafeParcelReader.o(parcel, B);
                    break;
                case 9:
                    b10 = SafeParcelReader.w(parcel, B);
                    break;
                case 10:
                    b11 = SafeParcelReader.w(parcel, B);
                    break;
                case 11:
                    b12 = SafeParcelReader.w(parcel, B);
                    break;
                case 12:
                    b13 = SafeParcelReader.w(parcel, B);
                    break;
                case 13:
                    str7 = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzl(i10, str, str2, str3, str4, str5, str6, b10, b11, b12, b13, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl[] newArray(int i10) {
        return new zzl[i10];
    }
}
