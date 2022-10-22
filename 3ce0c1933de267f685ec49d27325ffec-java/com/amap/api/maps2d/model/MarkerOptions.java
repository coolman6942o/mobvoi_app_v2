package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class MarkerOptions implements Parcelable {
    public static final h CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f7099a;

    /* renamed from: b  reason: collision with root package name */
    private String f7100b;

    /* renamed from: c  reason: collision with root package name */
    private String f7101c;

    /* renamed from: h  reason: collision with root package name */
    String f7106h;

    /* renamed from: j  reason: collision with root package name */
    private float f7108j;

    /* renamed from: d  reason: collision with root package name */
    private float f7102d = 0.5f;

    /* renamed from: e  reason: collision with root package name */
    private float f7103e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7104f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7105g = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7107i = false;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<BitmapDescriptor> f7109k = new ArrayList<>();

    private void a() {
        if (this.f7109k == null) {
            this.f7109k = new ArrayList<>();
        }
    }

    public MarkerOptions b(float f10, float f11) {
        this.f7102d = f10;
        this.f7103e = f11;
        return this;
    }

    public MarkerOptions c(boolean z10) {
        this.f7104f = z10;
        return this;
    }

    public MarkerOptions d(BitmapDescriptor bitmapDescriptor) {
        try {
            a();
            this.f7109k.clear();
            this.f7109k.add(bitmapDescriptor);
        } catch (Throwable unused) {
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MarkerOptions e(ArrayList<BitmapDescriptor> arrayList) {
        this.f7109k = arrayList;
        return this;
    }

    public MarkerOptions f(LatLng latLng) {
        this.f7099a = latLng;
        return this;
    }

    public MarkerOptions g(boolean z10) {
        this.f7107i = z10;
        return this;
    }

    public MarkerOptions h(String str) {
        this.f7101c = str;
        return this;
    }

    public MarkerOptions i(String str) {
        this.f7100b = str;
        return this;
    }

    public MarkerOptions j(boolean z10) {
        this.f7105g = z10;
        return this;
    }

    public MarkerOptions k(float f10) {
        this.f7108j = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7099a, i10);
        ArrayList<BitmapDescriptor> arrayList = this.f7109k;
        if (!(arrayList == null || arrayList.size() == 0)) {
            parcel.writeParcelable(this.f7109k.get(0), i10);
        }
        parcel.writeString(this.f7100b);
        parcel.writeString(this.f7101c);
        parcel.writeFloat(this.f7102d);
        parcel.writeFloat(this.f7103e);
        parcel.writeByte(this.f7105g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7104f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7107i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7106h);
        parcel.writeFloat(this.f7108j);
        parcel.writeList(this.f7109k);
    }
}
