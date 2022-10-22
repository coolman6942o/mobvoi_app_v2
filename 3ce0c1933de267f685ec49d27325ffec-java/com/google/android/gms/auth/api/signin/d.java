package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        ArrayList arrayList = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    arrayList = SafeParcelReader.s(parcel, B, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.n(parcel, B, Account.CREATOR);
                    break;
                case 4:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 5:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 6:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                case 7:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 8:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.s(parcel, B, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new GoogleSignInOptions(i10, arrayList, account, z10, z11, z12, str, str2, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }
}
