package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class w implements Parcelable.Creator<zzdz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdz createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        boolean z10 = false;
        boolean z11 = true;
        long j10 = 0;
        String str = null;
        long j11 = -2147483648L;
        int i10 = 0;
        boolean z12 = false;
        boolean z13 = true;
        boolean z14 = true;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    str4 = SafeParcelReader.o(parcel, B);
                    break;
                case 6:
                    j10 = SafeParcelReader.G(parcel, B);
                    break;
                case 7:
                    j12 = SafeParcelReader.G(parcel, B);
                    break;
                case 8:
                    str5 = SafeParcelReader.o(parcel, B);
                    break;
                case 9:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 10:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 11:
                    j11 = SafeParcelReader.G(parcel, B);
                    break;
                case 12:
                    str6 = SafeParcelReader.o(parcel, B);
                    break;
                case 13:
                    j13 = SafeParcelReader.G(parcel, B);
                    break;
                case 14:
                    j14 = SafeParcelReader.G(parcel, B);
                    break;
                case 15:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 16:
                    z13 = SafeParcelReader.v(parcel, B);
                    break;
                case 17:
                    z14 = SafeParcelReader.v(parcel, B);
                    break;
                case 18:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdz(str, str2, str3, str4, j10, j12, str5, z11, z10, j11, str6, j13, j14, i10, z13, z14, z12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdz[] newArray(int i10) {
        return new zzdz[i10];
    }
}
