package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class p5 implements Parcelable.Creator<zzjx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjx createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i10 = 0;
        long j10 = 0;
        Long l10 = null;
        Float f10 = null;
        String str2 = null;
        String str3 = null;
        Double d10 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 3:
                    j10 = SafeParcelReader.G(parcel, B);
                    break;
                case 4:
                    l10 = SafeParcelReader.H(parcel, B);
                    break;
                case 5:
                    f10 = SafeParcelReader.A(parcel, B);
                    break;
                case 6:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 7:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 8:
                    d10 = SafeParcelReader.y(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzjx(i10, str, j10, l10, f10, str2, str3, d10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjx[] newArray(int i10) {
        return new zzjx[i10];
    }
}
