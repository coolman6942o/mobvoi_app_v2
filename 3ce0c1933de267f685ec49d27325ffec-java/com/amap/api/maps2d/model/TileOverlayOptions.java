package com.amap.api.maps2d.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import m4.c;
/* loaded from: classes.dex */
public final class TileOverlayOptions implements Parcelable {
    public static final l CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private final int f7150a;

    /* renamed from: b  reason: collision with root package name */
    private c f7151b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7152c;

    /* renamed from: d  reason: collision with root package name */
    private float f7153d;

    /* renamed from: e  reason: collision with root package name */
    private int f7154e;

    /* renamed from: f  reason: collision with root package name */
    private int f7155f;

    /* renamed from: g  reason: collision with root package name */
    private String f7156g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7157h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7158i;

    public TileOverlayOptions() {
        this.f7152c = true;
        this.f7154e = 5120;
        this.f7155f = 20480;
        this.f7156g = null;
        this.f7157h = true;
        this.f7158i = true;
        this.f7150a = 1;
    }

    public TileOverlayOptions a(String str) {
        this.f7156g = str;
        return this;
    }

    public TileOverlayOptions b(boolean z10) {
        this.f7158i = z10;
        return this;
    }

    public TileOverlayOptions c(int i10) {
        this.f7155f = i10 * 1024;
        return this;
    }

    public TileOverlayOptions d(int i10) {
        this.f7154e = i10;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions e(boolean z10) {
        this.f7157h = z10;
        return this;
    }

    public TileOverlayOptions f(c cVar) {
        this.f7151b = cVar;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f7150a);
        parcel.writeValue(this.f7151b);
        parcel.writeByte(this.f7152c ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.f7153d);
        parcel.writeInt(this.f7154e);
        parcel.writeInt(this.f7155f);
        parcel.writeString(this.f7156g);
        parcel.writeByte(this.f7157h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7158i ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(int i10, IBinder iBinder, boolean z10, float f10) {
        this.f7152c = true;
        this.f7154e = 5120;
        this.f7155f = 20480;
        this.f7156g = null;
        this.f7157h = true;
        this.f7158i = true;
        this.f7150a = i10;
        this.f7152c = z10;
        this.f7153d = f10;
    }
}
