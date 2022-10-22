package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore2d.a;
/* loaded from: classes.dex */
public final class CameraPosition implements Parcelable {
    public static final c CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f7069a;

    /* renamed from: b  reason: collision with root package name */
    public final float f7070b;

    /* renamed from: c  reason: collision with root package name */
    public final float f7071c;

    /* renamed from: d  reason: collision with root package name */
    public final float f7072d;

    public CameraPosition(LatLng latLng, float f10, float f11, float f12) {
        if (latLng == null) {
            Log.w("CameraPosition", "构建CameraPosition时,位置(target)不能为null");
        }
        this.f7069a = latLng;
        this.f7070b = a.f(f10);
        this.f7071c = a.a(f11);
        this.f7072d = (((double) f12) <= 0.0d ? (f12 % 360.0f) + 360.0f : f12) % 360.0f;
        if (latLng != null) {
            k4.a.a(latLng.f7094a, latLng.f7095b);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f7069a.equals(cameraPosition.f7069a) && Float.floatToIntBits(this.f7070b) == Float.floatToIntBits(cameraPosition.f7070b) && Float.floatToIntBits(this.f7071c) == Float.floatToIntBits(cameraPosition.f7071c) && Float.floatToIntBits(this.f7072d) == Float.floatToIntBits(cameraPosition.f7072d);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return a.d(a.c("target", this.f7069a), a.c("zoom", Float.valueOf(this.f7070b)), a.c("tilt", Float.valueOf(this.f7071c)), a.c("bearing", Float.valueOf(this.f7072d)));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f7072d);
        LatLng latLng = this.f7069a;
        if (latLng != null) {
            parcel.writeFloat((float) latLng.f7094a);
            parcel.writeFloat((float) this.f7069a.f7095b);
        }
        parcel.writeFloat(this.f7071c);
        parcel.writeFloat(this.f7070b);
    }
}
