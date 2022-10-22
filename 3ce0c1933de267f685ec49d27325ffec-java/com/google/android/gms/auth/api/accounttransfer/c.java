package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        HashSet hashSet = new HashSet();
        zzt zztVar = null;
        int i10 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
                hashSet.add(1);
            } else if (u10 == 2) {
                zztVar = (zzt) SafeParcelReader.n(parcel, B, zzt.CREATOR);
                hashSet.add(2);
            } else if (u10 == 3) {
                str = SafeParcelReader.o(parcel, B);
                hashSet.add(3);
            } else if (u10 == 4) {
                str2 = SafeParcelReader.o(parcel, B);
                hashSet.add(4);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                str3 = SafeParcelReader.o(parcel, B);
                hashSet.add(5);
            }
        }
        if (parcel.dataPosition() == L) {
            return new zzr(hashSet, i10, zztVar, str, str2, str3);
        }
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Overread allowed size end=");
        sb2.append(L);
        throw new SafeParcelReader.ParseException(sb2.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i10) {
        return new zzr[i10];
    }
}
