package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: CameraPositionCreator.java */
/* loaded from: classes.dex */
class c implements Parcelable.Creator<CameraPosition> {
    /* renamed from: a */
    public CameraPosition createFromParcel(Parcel parcel) {
        float readFloat = parcel.readFloat();
        float readFloat2 = parcel.readFloat();
        float readFloat3 = parcel.readFloat();
        float readFloat4 = parcel.readFloat();
        return new CameraPosition(new LatLng(readFloat2, readFloat3), parcel.readFloat(), readFloat4, readFloat);
    }

    /* renamed from: b */
    public CameraPosition[] newArray(int i10) {
        return new CameraPosition[i10];
    }
}
