package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;
/* loaded from: classes.dex */
public final class r implements Parcelable.Creator<zzbd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        List<ClientIdentity> list = zzbd.f9117h;
        boolean z10 = false;
        LocationRequest locationRequest = null;
        boolean z11 = false;
        boolean z12 = false;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 != 1) {
                switch (u10) {
                    case 5:
                        list = SafeParcelReader.s(parcel, B, ClientIdentity.CREATOR);
                        continue;
                    case 6:
                        str = SafeParcelReader.o(parcel, B);
                        continue;
                    case 7:
                        z10 = SafeParcelReader.v(parcel, B);
                        continue;
                    case 8:
                        z11 = SafeParcelReader.v(parcel, B);
                        continue;
                    case 9:
                        z12 = SafeParcelReader.v(parcel, B);
                        continue;
                    case 10:
                        str2 = SafeParcelReader.o(parcel, B);
                        continue;
                    default:
                        SafeParcelReader.K(parcel, B);
                        continue;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.n(parcel, B, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzbd(locationRequest, list, str, z10, z11, z12, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd[] newArray(int i10) {
        return new zzbd[i10];
    }
}
