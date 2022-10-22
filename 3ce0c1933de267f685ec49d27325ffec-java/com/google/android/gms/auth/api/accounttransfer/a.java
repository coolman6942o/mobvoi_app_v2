package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = null;
        int i10 = 0;
        zzo zzoVar = null;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
                hashSet.add(1);
            } else if (u10 == 2) {
                arrayList = SafeParcelReader.s(parcel, B, zzr.CREATOR);
                hashSet.add(2);
            } else if (u10 == 3) {
                i11 = SafeParcelReader.D(parcel, B);
                hashSet.add(3);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                zzoVar = (zzo) SafeParcelReader.n(parcel, B, zzo.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == L) {
            return new zzl(hashSet, i10, arrayList, i11, zzoVar);
        }
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Overread allowed size end=");
        sb2.append(L);
        throw new SafeParcelReader.ParseException(sb2.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl[] newArray(int i10) {
        return new zzl[i10];
    }
}
