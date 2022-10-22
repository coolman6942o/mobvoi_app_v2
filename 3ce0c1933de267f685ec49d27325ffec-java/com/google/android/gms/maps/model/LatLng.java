package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.h;
/* loaded from: classes.dex */
public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    public final double f10052a;

    /* renamed from: b  reason: collision with root package name */
    public final double f10053b;

    public LatLng(double d10, double d11) {
        if (-180.0d > d11 || d11 >= 180.0d) {
            this.f10053b = ((((d11 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f10053b = d11;
        }
        this.f10052a = Math.max(-90.0d, Math.min(90.0d, d10));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f10052a) == Double.doubleToLongBits(latLng.f10052a) && Double.doubleToLongBits(this.f10053b) == Double.doubleToLongBits(latLng.f10053b);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f10052a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f10053b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public final String toString() {
        double d10 = this.f10052a;
        double d11 = this.f10053b;
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("lat/lng: (");
        sb2.append(d10);
        sb2.append(",");
        sb2.append(d11);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.g(parcel, 2, this.f10052a);
        a.g(parcel, 3, this.f10053b);
        a.b(parcel, a10);
    }
}
