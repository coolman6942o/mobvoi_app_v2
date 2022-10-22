package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class z implements Parcelable.Creator<zzed> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzed createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j10 = 0;
        String str = null;
        boolean z10 = false;
        long j11 = 0;
        long j12 = 0;
        String str2 = null;
        zzjx zzjxVar = null;
        String str3 = null;
        zzeu zzeuVar = null;
        zzeu zzeuVar2 = null;
        zzeu zzeuVar3 = null;
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
                    zzjxVar = (zzjx) SafeParcelReader.n(parcel, B, zzjx.CREATOR);
                    break;
                case 5:
                    j10 = SafeParcelReader.G(parcel, B);
                    break;
                case 6:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 7:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 8:
                    zzeuVar = (zzeu) SafeParcelReader.n(parcel, B, zzeu.CREATOR);
                    break;
                case 9:
                    j11 = SafeParcelReader.G(parcel, B);
                    break;
                case 10:
                    zzeuVar2 = (zzeu) SafeParcelReader.n(parcel, B, zzeu.CREATOR);
                    break;
                case 11:
                    j12 = SafeParcelReader.G(parcel, B);
                    break;
                case 12:
                    zzeuVar3 = (zzeu) SafeParcelReader.n(parcel, B, zzeu.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzed(str, str2, zzjxVar, j10, z10, str3, zzeuVar, j11, zzeuVar2, j12, zzeuVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzed[] newArray(int i10) {
        return new zzed[i10];
    }
}
