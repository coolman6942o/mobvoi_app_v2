package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: LatLngCreator.java */
/* loaded from: classes.dex */
class g implements Parcelable.Creator<LatLng> {
    /* renamed from: a */
    public LatLng createFromParcel(Parcel parcel) {
        return new LatLng(parcel.readDouble(), parcel.readDouble());
    }

    /* renamed from: b */
    public LatLng[] newArray(int i10) {
        return new LatLng[i10];
    }
}
