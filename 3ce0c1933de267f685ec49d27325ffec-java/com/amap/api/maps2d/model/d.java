package com.amap.api.maps2d.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* compiled from: CircleOptionsCreator.java */
/* loaded from: classes.dex */
class d implements Parcelable.Creator<CircleOptions> {
    /* renamed from: a */
    public CircleOptions createFromParcel(Parcel parcel) {
        CircleOptions circleOptions = new CircleOptions();
        Bundle readBundle = parcel.readBundle();
        circleOptions.a(new LatLng(readBundle.getDouble(SharedWearInfoHelper.LocationInfo.KEY_LAT), readBundle.getDouble(SharedWearInfoHelper.LocationInfo.KEY_LNG)));
        circleOptions.c(parcel.readDouble());
        circleOptions.e(parcel.readFloat());
        circleOptions.d(parcel.readInt());
        circleOptions.b(parcel.readInt());
        circleOptions.g(parcel.readInt());
        boolean z10 = true;
        if (parcel.readByte() != 1) {
            z10 = false;
        }
        circleOptions.f(z10);
        circleOptions.f7073a = parcel.readString();
        return circleOptions;
    }

    /* renamed from: b */
    public CircleOptions[] newArray(int i10) {
        return new CircleOptions[i10];
    }
}
