package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class i implements Parcelable.Creator<zaj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        ConnectionResult connectionResult = null;
        int i10 = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.n(parcel, B, ConnectionResult.CREATOR);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.n(parcel, B, ResolveAccountResponse.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zaj(i10, connectionResult, resolveAccountResponse);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj[] newArray(int i10) {
        return new zaj[i10];
    }
}
