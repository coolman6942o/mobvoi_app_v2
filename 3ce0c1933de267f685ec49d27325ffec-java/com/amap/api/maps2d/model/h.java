package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: MarkerOptionsCreator.java */
/* loaded from: classes.dex */
class h implements Parcelable.Creator<MarkerOptions> {
    /* renamed from: a */
    public MarkerOptions createFromParcel(Parcel parcel) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.f((LatLng) parcel.readParcelable(LatLng.class.getClassLoader()));
        markerOptions.d((BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
        markerOptions.i(parcel.readString());
        markerOptions.h(parcel.readString());
        markerOptions.b(parcel.readFloat(), parcel.readFloat());
        boolean z10 = false;
        markerOptions.j(parcel.readByte() == 1);
        markerOptions.c(parcel.readByte() == 1);
        if (parcel.readByte() == 1) {
            z10 = true;
        }
        markerOptions.g(z10);
        markerOptions.f7106h = parcel.readString();
        markerOptions.k(parcel.readFloat());
        markerOptions.e(parcel.createTypedArrayList(BitmapDescriptor.f7065d));
        return markerOptions;
    }

    /* renamed from: b */
    public MarkerOptions[] newArray(int i10) {
        return new MarkerOptions[i10];
    }
}
