package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<zzdd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdd createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Uri uri = null;
        Bundle bundle = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                uri = (Uri) SafeParcelReader.n(parcel, B, Uri.CREATOR);
            } else if (u10 == 4) {
                bundle = SafeParcelReader.f(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                bArr = SafeParcelReader.g(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzdd(uri, bundle, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdd[] newArray(int i10) {
        return new zzdd[i10];
    }
}
