package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<AccountChangeEventsRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i10 = 0;
        int i11 = 0;
        Account account = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                account = (Account) SafeParcelReader.n(parcel, B, Account.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new AccountChangeEventsRequest(i10, i11, str, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsRequest[] newArray(int i10) {
        return new AccountChangeEventsRequest[i10];
    }
}
