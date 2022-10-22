package com.amap.api.maps2d.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class GroundOverlayOptions implements Parcelable {
    public static final e CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f7081a;

    /* renamed from: b  reason: collision with root package name */
    private BitmapDescriptor f7082b;

    /* renamed from: c  reason: collision with root package name */
    private LatLng f7083c;

    /* renamed from: d  reason: collision with root package name */
    private float f7084d;

    /* renamed from: e  reason: collision with root package name */
    private float f7085e;

    /* renamed from: f  reason: collision with root package name */
    private LatLngBounds f7086f;

    /* renamed from: g  reason: collision with root package name */
    private float f7087g;

    /* renamed from: h  reason: collision with root package name */
    private float f7088h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7089i;

    /* renamed from: j  reason: collision with root package name */
    private float f7090j;

    /* renamed from: k  reason: collision with root package name */
    private float f7091k;

    /* renamed from: l  reason: collision with root package name */
    private float f7092l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroundOverlayOptions(int i10, IBinder iBinder, LatLng latLng, float f10, float f11, LatLngBounds latLngBounds, float f12, float f13, boolean z10, float f14, float f15, float f16) {
        this.f7089i = true;
        this.f7090j = 0.0f;
        this.f7091k = 0.5f;
        this.f7092l = 0.5f;
        this.f7081a = i10;
        this.f7082b = a.a(null);
        this.f7083c = latLng;
        this.f7084d = f10;
        this.f7085e = f11;
        this.f7086f = latLngBounds;
        this.f7087g = f12;
        this.f7088h = f13;
        this.f7089i = z10;
        this.f7090j = f14;
        this.f7091k = f15;
        this.f7092l = f16;
    }

    public GroundOverlayOptions a(BitmapDescriptor bitmapDescriptor) {
        this.f7082b = bitmapDescriptor;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f7081a);
        parcel.writeParcelable(this.f7082b, i10);
        parcel.writeParcelable(this.f7083c, i10);
        parcel.writeFloat(this.f7084d);
        parcel.writeFloat(this.f7085e);
        parcel.writeParcelable(this.f7086f, i10);
        parcel.writeFloat(this.f7087g);
        parcel.writeFloat(this.f7088h);
        parcel.writeByte(this.f7089i ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.f7090j);
        parcel.writeFloat(this.f7091k);
        parcel.writeFloat(this.f7092l);
    }

    public GroundOverlayOptions() {
        this.f7089i = true;
        this.f7090j = 0.0f;
        this.f7091k = 0.5f;
        this.f7092l = 0.5f;
        this.f7081a = 1;
    }
}
