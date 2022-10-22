package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LatLonSharePoint extends LatLonPoint {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private String f7292c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<LatLonSharePoint> {
        a() {
        }

        /* renamed from: a */
        public LatLonSharePoint createFromParcel(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        /* renamed from: b */
        public LatLonSharePoint[] newArray(int i10) {
            return new LatLonSharePoint[i10];
        }
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f7292c = parcel.readString();
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.f7292c;
        if (str == null) {
            if (latLonSharePoint.f7292c != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.f7292c)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f7292c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.f7292c;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f7292c);
    }
}
