package com.amap.api.maps2d.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* loaded from: classes.dex */
public final class CircleOptions implements Parcelable {
    public static final d CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    String f7073a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f7074b = null;

    /* renamed from: c  reason: collision with root package name */
    private double f7075c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    private float f7076d = 10.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f7077e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    private int f7078f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f7079g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7080h = true;

    public CircleOptions a(LatLng latLng) {
        this.f7074b = latLng;
        return this;
    }

    public CircleOptions b(int i10) {
        this.f7078f = i10;
        return this;
    }

    public CircleOptions c(double d10) {
        this.f7075c = d10;
        return this;
    }

    public CircleOptions d(int i10) {
        this.f7077e = i10;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CircleOptions e(float f10) {
        this.f7076d = f10;
        return this;
    }

    public CircleOptions f(boolean z10) {
        this.f7080h = z10;
        return this;
    }

    public CircleOptions g(float f10) {
        this.f7079g = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.f7074b;
        if (latLng != null) {
            bundle.putDouble(SharedWearInfoHelper.LocationInfo.KEY_LAT, latLng.f7094a);
            bundle.putDouble(SharedWearInfoHelper.LocationInfo.KEY_LNG, this.f7074b.f7095b);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.f7075c);
        parcel.writeFloat(this.f7076d);
        parcel.writeInt(this.f7077e);
        parcel.writeInt(this.f7078f);
        parcel.writeFloat(this.f7079g);
        parcel.writeByte(this.f7080h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7073a);
    }
}
