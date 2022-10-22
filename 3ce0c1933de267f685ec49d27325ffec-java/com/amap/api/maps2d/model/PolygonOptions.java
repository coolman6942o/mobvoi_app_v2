package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class PolygonOptions implements Parcelable {
    public static final i CREATOR = new i();

    /* renamed from: g  reason: collision with root package name */
    String f7125g;

    /* renamed from: b  reason: collision with root package name */
    private float f7120b = 10.0f;

    /* renamed from: c  reason: collision with root package name */
    private int f7121c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    private int f7122d = -16777216;

    /* renamed from: e  reason: collision with root package name */
    private float f7123e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7124f = true;

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f7119a = new ArrayList();

    public PolygonOptions a(LatLng... latLngArr) {
        this.f7119a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions b(int i10) {
        this.f7122d = i10;
        return this;
    }

    public PolygonOptions c(int i10) {
        this.f7121c = i10;
        return this;
    }

    public PolygonOptions d(float f10) {
        this.f7120b = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolygonOptions e(boolean z10) {
        this.f7124f = z10;
        return this;
    }

    public PolygonOptions f(float f10) {
        this.f7123e = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f7119a);
        parcel.writeFloat(this.f7120b);
        parcel.writeInt(this.f7121c);
        parcel.writeInt(this.f7122d);
        parcel.writeFloat(this.f7123e);
        parcel.writeByte((byte) (!this.f7124f ? 1 : 0));
        parcel.writeString(this.f7125g);
    }
}
