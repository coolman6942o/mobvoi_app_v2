package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.zzj;
import java.util.List;
/* loaded from: classes.dex */
public final class w implements Parcelable.Creator<zzm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        zzj zzjVar = zzm.f9141e;
        List<ClientIdentity> list = zzm.f9140d;
        String str = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                zzjVar = (zzj) SafeParcelReader.n(parcel, B, zzj.CREATOR);
            } else if (u10 == 2) {
                list = SafeParcelReader.s(parcel, B, ClientIdentity.CREATOR);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                str = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzm(zzjVar, list, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i10) {
        return new zzm[i10];
    }
}
