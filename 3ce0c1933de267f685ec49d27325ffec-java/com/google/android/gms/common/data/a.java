package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<BitmapTeleporter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapTeleporter createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.n(parcel, B, ParcelFileDescriptor.CREATOR);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                i11 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new BitmapTeleporter(i10, parcelFileDescriptor, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapTeleporter[] newArray(int i10) {
        return new BitmapTeleporter[i10];
    }
}
