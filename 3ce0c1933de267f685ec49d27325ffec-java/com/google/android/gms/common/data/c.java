package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        String[] strArr = null;
        int i11 = 0;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                strArr = SafeParcelReader.p(parcel, B);
            } else if (u10 == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.r(parcel, B, CursorWindow.CREATOR);
            } else if (u10 == 3) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 4) {
                bundle = SafeParcelReader.f(parcel, B);
            } else if (u10 != 1000) {
                SafeParcelReader.K(parcel, B);
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        DataHolder dataHolder = new DataHolder(i10, strArr, cursorWindowArr, i11, bundle);
        dataHolder.N0();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i10) {
        return new DataHolder[i10];
    }
}
