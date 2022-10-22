package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<WebImage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        Uri uri = null;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                uri = (Uri) SafeParcelReader.n(parcel, B, Uri.CREATOR);
            } else if (u10 == 3) {
                i12 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.K(parcel, B);
            } else {
                i11 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new WebImage(i10, uri, i12, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage[] newArray(int i10) {
        return new WebImage[i10];
    }
}
