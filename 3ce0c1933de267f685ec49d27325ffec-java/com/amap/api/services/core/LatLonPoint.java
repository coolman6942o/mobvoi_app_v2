package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private double f7290a;

    /* renamed from: b  reason: collision with root package name */
    private double f7291b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<LatLonPoint> {
        a() {
        }

        /* renamed from: a */
        public LatLonPoint createFromParcel(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        /* renamed from: b */
        public LatLonPoint[] newArray(int i10) {
            return new LatLonPoint[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LatLonPoint(Parcel parcel) {
        this.f7290a = parcel.readDouble();
        this.f7291b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.f7290a) == Double.doubleToLongBits(latLonPoint.f7290a) && Double.doubleToLongBits(this.f7291b) == Double.doubleToLongBits(latLonPoint.f7291b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f7290a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f7291b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public String toString() {
        return "" + this.f7290a + "," + this.f7291b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.f7290a);
        parcel.writeDouble(this.f7291b);
    }
}
