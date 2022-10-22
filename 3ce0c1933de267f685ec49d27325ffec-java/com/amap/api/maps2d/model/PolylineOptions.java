package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class PolylineOptions implements Parcelable {
    public static final j CREATOR = new j();

    /* renamed from: g  reason: collision with root package name */
    String f7132g;

    /* renamed from: b  reason: collision with root package name */
    private float f7127b = 10.0f;

    /* renamed from: c  reason: collision with root package name */
    private int f7128c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    private float f7129d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7130e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7131f = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7133h = false;

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f7126a = new ArrayList();

    public PolylineOptions a(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<LatLng> it = iterable.iterator();
                while (it != null && it.hasNext()) {
                    arrayList.add(it.next());
                }
                this.f7126a.addAll(arrayList);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }

    public PolylineOptions b(int i10) {
        this.f7128c = i10;
        return this;
    }

    public PolylineOptions c(boolean z10) {
        this.f7131f = z10;
        return this;
    }

    public int d() {
        return this.f7128c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<LatLng> e() {
        return this.f7126a;
    }

    public float f() {
        return this.f7127b;
    }

    public float g() {
        return this.f7129d;
    }

    public boolean h() {
        return this.f7133h;
    }

    public boolean i() {
        return this.f7131f;
    }

    public boolean j() {
        return this.f7130e;
    }

    public PolylineOptions k(boolean z10) {
        this.f7133h = z10;
        return this;
    }

    public PolylineOptions l(boolean z10) {
        this.f7130e = z10;
        return this;
    }

    public PolylineOptions m(float f10) {
        this.f7127b = f10;
        return this;
    }

    public PolylineOptions o(float f10) {
        this.f7129d = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(e());
        parcel.writeFloat(f());
        parcel.writeInt(d());
        parcel.writeFloat(g());
        parcel.writeByte(j() ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7132g);
        parcel.writeByte(i() ? (byte) 1 : (byte) 0);
        parcel.writeByte(h() ? (byte) 1 : (byte) 0);
    }
}
