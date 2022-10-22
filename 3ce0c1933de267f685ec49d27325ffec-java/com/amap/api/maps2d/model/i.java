package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* compiled from: PolygonOptionsCreator.java */
/* loaded from: classes.dex */
class i implements Parcelable.Creator<PolygonOptions> {
    /* renamed from: a */
    public PolygonOptions createFromParcel(Parcel parcel) {
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z10 = parcel.readByte() == 0;
        polygonOptions.a((LatLng[]) arrayList.toArray(new LatLng[arrayList.size()]));
        polygonOptions.d(readFloat);
        polygonOptions.c(readInt);
        polygonOptions.b(readInt2);
        polygonOptions.f(readFloat2);
        polygonOptions.e(z10);
        polygonOptions.f7125g = parcel.readString();
        return polygonOptions;
    }

    /* renamed from: b */
    public PolygonOptions[] newArray(int i10) {
        return new PolygonOptions[i10];
    }
}
