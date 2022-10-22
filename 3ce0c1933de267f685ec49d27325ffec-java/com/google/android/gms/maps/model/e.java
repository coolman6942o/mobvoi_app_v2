package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class e implements Parcelable.Creator<PolygonOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        ArrayList arrayList = new ArrayList();
        float f10 = 0.0f;
        ArrayList arrayList2 = null;
        int i10 = 0;
        ArrayList arrayList3 = null;
        int i11 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        int i12 = 0;
        float f11 = 0.0f;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    arrayList2 = SafeParcelReader.s(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    SafeParcelReader.F(parcel, B, arrayList, e.class.getClassLoader());
                    break;
                case 4:
                    f11 = SafeParcelReader.z(parcel, B);
                    break;
                case 5:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 6:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 7:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 8:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 9:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 10:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                case 11:
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 12:
                    arrayList3 = SafeParcelReader.s(parcel, B, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new PolygonOptions(arrayList2, arrayList, f11, i10, i11, f10, z10, z11, z12, i12, arrayList3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions[] newArray(int i10) {
        return new PolygonOptions[i10];
    }
}
