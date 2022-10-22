package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<TokenData> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TokenData createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        Long l10 = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
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
                    l10 = SafeParcelReader.H(parcel, B);
                    break;
                case 4:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 5:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 6:
                    arrayList = SafeParcelReader.q(parcel, B);
                    break;
                case 7:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new TokenData(i10, str, l10, z10, z11, arrayList, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TokenData[] newArray(int i10) {
        return new TokenData[i10];
    }
}
