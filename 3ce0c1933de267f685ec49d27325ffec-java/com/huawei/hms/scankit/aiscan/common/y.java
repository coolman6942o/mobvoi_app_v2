package com.huawei.hms.scankit.aiscan.common;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ResultPoint.java */
/* loaded from: classes2.dex */
class y implements Parcelable.Creator<z> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public z createFromParcel(Parcel parcel) {
        return new z(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public z[] newArray(int i10) {
        return new z[i10];
    }
}
