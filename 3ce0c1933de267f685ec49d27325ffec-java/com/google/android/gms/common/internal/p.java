package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class p implements Parcelable.Creator<ResolveAccountResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        IBinder iBinder = null;
        int i10 = 0;
        ConnectionResult connectionResult = null;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                iBinder = SafeParcelReader.C(parcel, B);
            } else if (u10 == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.n(parcel, B, ConnectionResult.CREATOR);
            } else if (u10 == 4) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                z11 = SafeParcelReader.v(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ResolveAccountResponse(i10, iBinder, connectionResult, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse[] newArray(int i10) {
        return new ResolveAccountResponse[i10];
    }
}
