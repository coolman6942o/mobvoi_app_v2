package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: TileCreator.java */
/* loaded from: classes.dex */
class k implements Parcelable.Creator<Tile> {
    /* renamed from: a */
    public Tile createFromParcel(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
    }

    /* renamed from: b */
    public Tile[] newArray(int i10) {
        return new Tile[i10];
    }
}
