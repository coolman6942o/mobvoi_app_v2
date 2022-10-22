package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
/* loaded from: classes.dex */
public final class LatLng implements Parcelable, Cloneable {
    public static final g CREATOR = new g();

    /* renamed from: c  reason: collision with root package name */
    private static DecimalFormat f7093c = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));

    /* renamed from: a  reason: collision with root package name */
    public final double f7094a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7095b;

    public LatLng(double d10, double d11) {
        if (-180.0d > d11 || d11 >= 180.0d) {
            this.f7095b = a(((((d11 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        } else {
            this.f7095b = a(d11);
        }
        this.f7094a = a(Math.max(-90.0d, Math.min(90.0d, d10)));
    }

    private static double a(double d10) {
        try {
            return Double.parseDouble(f7093c.format(d10));
        } catch (Throwable unused) {
            return d10;
        }
    }

    /* renamed from: b */
    public LatLng clone() {
        return new LatLng(this.f7094a, this.f7095b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f7094a) == Double.doubleToLongBits(latLng.f7094a) && Double.doubleToLongBits(this.f7095b) == Double.doubleToLongBits(latLng.f7095b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f7094a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f7095b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public String toString() {
        return "lat/lng: (" + this.f7094a + "," + this.f7095b + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.f7095b);
        parcel.writeDouble(this.f7094a);
    }
}
