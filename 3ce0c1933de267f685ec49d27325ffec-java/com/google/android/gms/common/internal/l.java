package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class l implements Parcelable.Creator<AuthAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        IBinder iBinder = null;
        int i10 = 0;
        Scope[] scopeArr = null;
        Integer num = null;
        Integer num2 = null;
        Account account = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    iBinder = SafeParcelReader.C(parcel, B);
                    break;
                case 3:
                    scopeArr = (Scope[]) SafeParcelReader.r(parcel, B, Scope.CREATOR);
                    break;
                case 4:
                    num = SafeParcelReader.E(parcel, B);
                    break;
                case 5:
                    num2 = SafeParcelReader.E(parcel, B);
                    break;
                case 6:
                    account = (Account) SafeParcelReader.n(parcel, B, Account.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new AuthAccountRequest(i10, iBinder, scopeArr, num, num2, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest[] newArray(int i10) {
        return new AuthAccountRequest[i10];
    }
}
