package com.amap.api.maps2d.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.a;
import com.amap.api.maps2d.AMapException;
/* compiled from: LatLngBoundsCreator.java */
/* loaded from: classes.dex */
class f implements Parcelable.Creator<LatLngBounds> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(LatLngBounds latLngBounds, Parcel parcel, int i10) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.f7097b, i10);
        parcel.writeParcelable(latLngBounds.f7098c, i10);
    }

    /* renamed from: a */
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        BadParcelableException e10;
        int readInt = parcel.readInt();
        try {
            latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        } catch (BadParcelableException e11) {
            e10 = e11;
            latLng2 = null;
        }
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        } catch (BadParcelableException e12) {
            e10 = e12;
            a.e(e10, "LatLngBoundsCreator", "createFromParcel");
            latLng = null;
            return new LatLngBounds(readInt, latLng2, latLng);
        }
        try {
            return new LatLngBounds(readInt, latLng2, latLng);
        } catch (AMapException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public LatLngBounds[] newArray(int i10) {
        return new LatLngBounds[i10];
    }
}
