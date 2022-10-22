package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: GroundOverlayOptionsCreator.java */
/* loaded from: classes.dex */
class e implements Parcelable.Creator<GroundOverlayOptions> {
    /* renamed from: a */
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions(readInt, null, (LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), parcel.readByte() != 0, parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        groundOverlayOptions.a(bitmapDescriptor);
        return groundOverlayOptions;
    }

    /* renamed from: b */
    public GroundOverlayOptions[] newArray(int i10) {
        return new GroundOverlayOptions[i10];
    }
}
