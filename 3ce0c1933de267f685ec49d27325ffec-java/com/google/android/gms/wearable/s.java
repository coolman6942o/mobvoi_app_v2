package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class s implements Parcelable.Creator<PutDataRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PutDataRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Uri uri = null;
        long j10 = 0;
        Bundle bundle = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                uri = (Uri) SafeParcelReader.n(parcel, B, Uri.CREATOR);
            } else if (u10 == 4) {
                bundle = SafeParcelReader.f(parcel, B);
            } else if (u10 == 5) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 != 6) {
                SafeParcelReader.K(parcel, B);
            } else {
                j10 = SafeParcelReader.G(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new PutDataRequest(uri, bundle, bArr, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PutDataRequest[] newArray(int i10) {
        return new PutDataRequest[i10];
    }
}
