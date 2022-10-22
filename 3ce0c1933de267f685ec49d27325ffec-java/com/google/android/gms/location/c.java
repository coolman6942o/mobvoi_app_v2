package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.mobvoi.wear.util.LogCleaner;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 102;
        long j10 = LogCleaner.ONE_HOUR;
        long j11 = 600000;
        boolean z10 = false;
        long j12 = Long.MAX_VALUE;
        int i11 = Integer.MAX_VALUE;
        float f10 = 0.0f;
        long j13 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    j10 = SafeParcelReader.G(parcel, B);
                    break;
                case 3:
                    j11 = SafeParcelReader.G(parcel, B);
                    break;
                case 4:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 5:
                    j12 = SafeParcelReader.G(parcel, B);
                    break;
                case 6:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 7:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 8:
                    j13 = SafeParcelReader.G(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new LocationRequest(i10, j10, j11, z10, j12, i11, f10, j13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest[] newArray(int i10) {
        return new LocationRequest[i10];
    }
}
