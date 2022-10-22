package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<ProxyResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyResponse createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        PendingIntent pendingIntent = null;
        int i10 = 0;
        Bundle bundle = null;
        byte[] bArr = null;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, B, PendingIntent.CREATOR);
            } else if (u10 == 3) {
                i12 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 4) {
                bundle = SafeParcelReader.f(parcel, B);
            } else if (u10 == 5) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 != 1000) {
                SafeParcelReader.K(parcel, B);
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ProxyResponse(i10, i11, pendingIntent, i12, bundle, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyResponse[] newArray(int i10) {
        return new ProxyResponse[i10];
    }
}
