package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class Tile implements Parcelable {
    public static final k CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private final int f7146a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7147b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7148c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f7149d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tile(int i10, int i11, int i12, byte[] bArr) {
        this.f7146a = i10;
        this.f7147b = i11;
        this.f7148c = i12;
        this.f7149d = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f7146a);
        parcel.writeInt(this.f7147b);
        parcel.writeInt(this.f7148c);
        parcel.writeByteArray(this.f7149d);
    }
}
