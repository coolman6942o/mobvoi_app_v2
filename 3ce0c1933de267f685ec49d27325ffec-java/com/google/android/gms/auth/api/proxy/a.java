package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<ProxyRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        String str = null;
        long j10 = 0;
        int i11 = 0;
        byte[] bArr = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 2) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                j10 = SafeParcelReader.G(parcel, B);
            } else if (u10 == 4) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 == 5) {
                bundle = SafeParcelReader.f(parcel, B);
            } else if (u10 != 1000) {
                SafeParcelReader.K(parcel, B);
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ProxyRequest(i10, str, i11, j10, bArr, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest[] newArray(int i10) {
        return new ProxyRequest[i10];
    }
}
