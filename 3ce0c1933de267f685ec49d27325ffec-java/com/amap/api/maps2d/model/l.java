package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import m4.c;
/* compiled from: TileOverlayOptionsCreator.java */
/* loaded from: classes.dex */
class l implements Parcelable.Creator<TileOverlayOptions> {
    /* renamed from: a */
    public TileOverlayOptions createFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        c cVar = (c) parcel.readValue(c.class.getClassLoader());
        boolean z10 = true;
        boolean z11 = parcel.readByte() != 0;
        float readFloat = parcel.readFloat();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        String readString = parcel.readString();
        boolean z12 = parcel.readByte() != 0;
        if (parcel.readByte() == 0) {
            z10 = false;
        }
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions(readInt, null, z11, readFloat);
        if (cVar != null) {
            tileOverlayOptions.f(cVar);
        }
        tileOverlayOptions.d(readInt2);
        tileOverlayOptions.c(readInt3);
        tileOverlayOptions.a(readString);
        tileOverlayOptions.e(z12);
        tileOverlayOptions.b(z10);
        return tileOverlayOptions;
    }

    /* renamed from: b */
    public TileOverlayOptions[] newArray(int i10) {
        return new TileOverlayOptions[i10];
    }
}
