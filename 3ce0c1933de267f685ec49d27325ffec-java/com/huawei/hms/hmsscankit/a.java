package com.huawei.hms.hmsscankit;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: DetailRect.java */
/* loaded from: classes2.dex */
class a implements Parcelable.Creator<DetailRect> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public DetailRect createFromParcel(Parcel parcel) {
        return new DetailRect(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public DetailRect[] newArray(int i10) {
        return new DetailRect[i10];
    }
}
