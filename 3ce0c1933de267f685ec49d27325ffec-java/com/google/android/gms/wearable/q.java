package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<Asset> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Asset createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        byte[] bArr = null;
        String str = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        Uri uri = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 == 3) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.n(parcel, B, ParcelFileDescriptor.CREATOR);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                uri = (Uri) SafeParcelReader.n(parcel, B, Uri.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new Asset(bArr, str, parcelFileDescriptor, uri);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Asset[] newArray(int i10) {
        return new Asset[i10];
    }
}
