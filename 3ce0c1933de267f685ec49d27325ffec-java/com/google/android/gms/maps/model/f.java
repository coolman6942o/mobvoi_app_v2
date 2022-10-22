package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class f implements Parcelable.Creator<PolylineOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolylineOptions createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        float f10 = 0.0f;
        ArrayList arrayList = null;
        int i10 = 0;
        float f11 = 0.0f;
        Cap cap = null;
        Cap cap2 = null;
        ArrayList arrayList2 = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    arrayList = SafeParcelReader.s(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 4:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 5:
                    f11 = SafeParcelReader.z(parcel, B);
                    break;
                case 6:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 7:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 8:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                case 9:
                    cap = (Cap) SafeParcelReader.n(parcel, B, Cap.CREATOR);
                    break;
                case 10:
                    cap2 = (Cap) SafeParcelReader.n(parcel, B, Cap.CREATOR);
                    break;
                case 11:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 12:
                    arrayList2 = SafeParcelReader.s(parcel, B, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new PolylineOptions(arrayList, f10, i10, f11, z10, z11, z12, cap, cap2, i11, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolylineOptions[] newArray(int i10) {
        return new PolylineOptions[i10];
    }
}
