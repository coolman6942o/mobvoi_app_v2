package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class r implements Parcelable.Creator<ConnectionConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionConfiguration createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i10 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i11 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 5:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 6:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 7:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 8:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 9:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                case 10:
                    str4 = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ConnectionConfiguration(str, str2, i10, i11, z10, z11, str3, z12, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionConfiguration[] newArray(int i10) {
        return new ConnectionConfiguration[i10];
    }
}
