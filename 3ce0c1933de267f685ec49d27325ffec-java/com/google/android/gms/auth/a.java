package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<AccountChangeEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEvent createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i10 = 0;
        long j10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    j10 = SafeParcelReader.G(parcel, B);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 5:
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 6:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new AccountChangeEvent(i10, j10, str, i11, i12, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEvent[] newArray(int i10) {
        return new AccountChangeEvent[i10];
    }
}
