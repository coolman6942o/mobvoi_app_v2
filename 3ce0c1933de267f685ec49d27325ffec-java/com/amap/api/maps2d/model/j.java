package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* compiled from: PolylineOptionsCreator.java */
/* loaded from: classes.dex */
class j implements Parcelable.Creator<PolylineOptions> {
    /* renamed from: a */
    public PolylineOptions createFromParcel(Parcel parcel) {
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z10 = false;
        boolean z11 = parcel.readByte() == 1;
        polylineOptions.a(arrayList);
        polylineOptions.m(readFloat);
        polylineOptions.b(readInt);
        polylineOptions.o(readFloat2);
        polylineOptions.l(z11);
        polylineOptions.f7132g = parcel.readString();
        boolean z12 = parcel.readByte() == 1;
        if (parcel.readByte() == 1) {
            z10 = true;
        }
        polylineOptions.c(z12);
        polylineOptions.k(z10);
        return polylineOptions;
    }

    /* renamed from: b */
    public PolylineOptions[] newArray(int i10) {
        return new PolylineOptions[i10];
    }
}
