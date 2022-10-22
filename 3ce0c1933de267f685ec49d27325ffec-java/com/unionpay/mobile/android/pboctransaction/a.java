package com.unionpay.mobile.android.pboctransaction;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
final class a implements Parcelable.Creator<AppIdentification> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppIdentification createFromParcel(Parcel parcel) {
        AppIdentification appIdentification = new AppIdentification((byte) 0);
        appIdentification.f23749a = parcel.readString();
        appIdentification.f23750b = parcel.readString();
        return appIdentification;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ AppIdentification[] newArray(int i10) {
        return new AppIdentification[i10];
    }
}
