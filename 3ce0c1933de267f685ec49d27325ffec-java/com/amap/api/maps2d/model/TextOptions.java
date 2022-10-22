package com.amap.api.maps2d.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import m4.b;
/* loaded from: classes.dex */
public class TextOptions implements Parcelable {
    public static final b CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private String f7134a;

    /* renamed from: d  reason: collision with root package name */
    private float f7137d;

    /* renamed from: e  reason: collision with root package name */
    private LatLng f7138e;

    /* renamed from: h  reason: collision with root package name */
    private Object f7141h;

    /* renamed from: b  reason: collision with root package name */
    private Typeface f7135b = Typeface.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7136c = true;

    /* renamed from: f  reason: collision with root package name */
    private float f7139f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f7140g = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f7142i = -16777216;

    /* renamed from: j  reason: collision with root package name */
    private int f7143j = 20;

    /* renamed from: k  reason: collision with root package name */
    private int f7144k = 3;

    /* renamed from: l  reason: collision with root package name */
    private int f7145l = 6;

    public TextOptions a(int i10, int i11) {
        this.f7144k = i10;
        this.f7145l = i11;
        return this;
    }

    public TextOptions b(int i10) {
        this.f7140g = i10;
        return this;
    }

    public TextOptions c(int i10) {
        this.f7142i = i10;
        return this;
    }

    public TextOptions d(int i10) {
        this.f7143j = i10;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TextOptions e(LatLng latLng) {
        this.f7138e = latLng;
        return this;
    }

    public TextOptions f(float f10) {
        this.f7139f = f10;
        return this;
    }

    public TextOptions g(Object obj) {
        this.f7141h = obj;
        return this;
    }

    public TextOptions h(String str) {
        this.f7134a = str;
        return this;
    }

    public TextOptions i(Typeface typeface) {
        this.f7135b = typeface;
        return this;
    }

    public TextOptions j(boolean z10) {
        this.f7136c = z10;
        return this;
    }

    public TextOptions k(float f10) {
        this.f7137d = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.f7138e;
        if (latLng != null) {
            bundle.putDouble(SharedWearInfoHelper.LocationInfo.KEY_LAT, latLng.f7094a);
            bundle.putDouble(SharedWearInfoHelper.LocationInfo.KEY_LNG, this.f7138e.f7095b);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.f7134a);
        parcel.writeInt(this.f7135b.getStyle());
        parcel.writeFloat(this.f7139f);
        parcel.writeInt(this.f7144k);
        parcel.writeInt(this.f7145l);
        parcel.writeInt(this.f7140g);
        parcel.writeInt(this.f7142i);
        parcel.writeInt(this.f7143j);
        parcel.writeFloat(this.f7137d);
        parcel.writeByte(this.f7136c ? (byte) 1 : (byte) 0);
        if (this.f7141h instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.f7141h);
            parcel.writeBundle(bundle2);
        }
    }
}
