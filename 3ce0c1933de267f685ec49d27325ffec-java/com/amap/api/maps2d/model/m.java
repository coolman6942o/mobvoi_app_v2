package com.amap.api.maps2d.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.a;
/* compiled from: VisibleRegionCreator.java */
/* loaded from: classes.dex */
class m implements Parcelable.Creator<VisibleRegion> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(VisibleRegion visibleRegion, Parcel parcel, int i10) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.f7160b, i10);
        parcel.writeParcelable(visibleRegion.f7161c, i10);
        parcel.writeParcelable(visibleRegion.f7162d, i10);
        parcel.writeParcelable(visibleRegion.f7163e, i10);
        parcel.writeParcelable(visibleRegion.f7164f, i10);
    }

    /* renamed from: a */
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds;
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        BadParcelableException e10;
        int readInt = parcel.readInt();
        try {
            latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        } catch (BadParcelableException e11) {
            e10 = e11;
            latLng4 = null;
            latLng3 = null;
        }
        try {
            latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                } catch (BadParcelableException e12) {
                    e10 = e12;
                    latLng = null;
                }
                try {
                    latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                } catch (BadParcelableException e13) {
                    e10 = e13;
                    a.e(e10, "VisibleRegionCreator", "createFromParcel");
                    latLngBounds = null;
                    return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                }
            } catch (BadParcelableException e14) {
                e10 = e14;
                latLng2 = null;
                latLng = latLng2;
                a.e(e10, "VisibleRegionCreator", "createFromParcel");
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
            }
        } catch (BadParcelableException e15) {
            e10 = e15;
            latLng3 = null;
            latLng2 = latLng3;
            latLng = latLng2;
            a.e(e10, "VisibleRegionCreator", "createFromParcel");
            latLngBounds = null;
            return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        return new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
    }

    /* renamed from: c */
    public VisibleRegion[] newArray(int i10) {
        return new VisibleRegion[i10];
    }
}
