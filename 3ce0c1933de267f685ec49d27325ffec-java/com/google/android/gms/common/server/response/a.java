package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i10 = 0;
        String str2 = null;
        zaa zaaVar = null;
        int i11 = 0;
        boolean z10 = false;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 3:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 4:
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 5:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 6:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 7:
                    i13 = SafeParcelReader.D(parcel, B);
                    break;
                case 8:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 9:
                    zaaVar = (zaa) SafeParcelReader.n(parcel, B, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new FastJsonResponse.Field(i10, i11, z10, i12, z11, str, i13, str2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i10) {
        return new FastJsonResponse.Field[i10];
    }
}
