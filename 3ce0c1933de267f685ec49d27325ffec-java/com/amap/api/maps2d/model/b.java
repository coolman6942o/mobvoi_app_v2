package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: BitmapDescriptorCreator.java */
/* loaded from: classes.dex */
class b implements Parcelable.Creator<BitmapDescriptor> {
    /* renamed from: a */
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null);
        bitmapDescriptor.f7068c = (Bitmap) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        bitmapDescriptor.f7066a = parcel.readInt();
        bitmapDescriptor.f7067b = parcel.readInt();
        return bitmapDescriptor;
    }

    /* renamed from: b */
    public BitmapDescriptor[] newArray(int i10) {
        return new BitmapDescriptor[i10];
    }
}
