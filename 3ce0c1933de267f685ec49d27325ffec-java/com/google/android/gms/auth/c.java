package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<AccountChangeEventsResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsResponse createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, AccountChangeEvent.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new AccountChangeEventsResponse(i10, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsResponse[] newArray(int i10) {
        return new AccountChangeEventsResponse[i10];
    }
}
