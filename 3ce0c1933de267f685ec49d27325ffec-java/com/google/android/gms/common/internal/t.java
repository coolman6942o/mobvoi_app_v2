package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class t implements Parcelable.Creator<GetServiceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        String str = null;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 3:
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    iBinder = SafeParcelReader.C(parcel, B);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.r(parcel, B, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, B);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.n(parcel, B, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.r(parcel, B, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.r(parcel, B, Feature.CREATOR);
                    break;
                case 12:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new GetServiceRequest(i10, i11, i12, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i10) {
        return new GetServiceRequest[i10];
    }
}
