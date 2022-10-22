package com.amap.api.maps2d.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.ml.camera.CameraConfig;
import m4.a;
/* loaded from: classes.dex */
public class MyLocationStyle implements Parcelable {
    public static final a CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private BitmapDescriptor f7110a;

    /* renamed from: b  reason: collision with root package name */
    private float f7111b = 0.5f;

    /* renamed from: c  reason: collision with root package name */
    private float f7112c = 0.5f;

    /* renamed from: d  reason: collision with root package name */
    private int f7113d = Color.argb(100, 0, 0, (int) CameraConfig.CAMERA_THIRD_DEGREE);

    /* renamed from: e  reason: collision with root package name */
    private int f7114e = Color.argb(255, 0, 0, 220);

    /* renamed from: f  reason: collision with root package name */
    private float f7115f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f7116g = 1;

    /* renamed from: h  reason: collision with root package name */
    private long f7117h = 2000;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7118i = true;

    public MyLocationStyle a(float f10, float f11) {
        this.f7111b = f10;
        this.f7112c = f11;
        return this;
    }

    public MyLocationStyle b(BitmapDescriptor bitmapDescriptor) {
        this.f7110a = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle c(int i10) {
        this.f7113d = i10;
        return this;
    }

    public MyLocationStyle d(int i10) {
        this.f7114e = i10;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MyLocationStyle e(float f10) {
        this.f7115f = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7110a, i10);
        parcel.writeFloat(this.f7111b);
        parcel.writeFloat(this.f7112c);
        parcel.writeInt(this.f7113d);
        parcel.writeInt(this.f7114e);
        parcel.writeFloat(this.f7115f);
        parcel.writeInt(this.f7116g);
        parcel.writeLong(this.f7117h);
        parcel.writeBooleanArray(new boolean[]{this.f7118i});
    }
}
