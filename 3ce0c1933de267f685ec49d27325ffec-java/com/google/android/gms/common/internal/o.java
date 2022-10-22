package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class o implements Parcelable.Creator<ResolveAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Account account = null;
        int i10 = 0;
        int i11 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                account = (Account) SafeParcelReader.n(parcel, B, Account.CREATOR);
            } else if (u10 == 3) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.n(parcel, B, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ResolveAccountRequest(i10, account, i11, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest[] newArray(int i10) {
        return new ResolveAccountRequest[i10];
    }
}
