package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7342a;

    /* renamed from: b  reason: collision with root package name */
    private String f7343b;

    /* renamed from: c  reason: collision with root package name */
    private String f7344c;

    /* renamed from: d  reason: collision with root package name */
    private String f7345d;

    /* renamed from: e  reason: collision with root package name */
    private String f7346e;

    /* renamed from: f  reason: collision with root package name */
    private String f7347f;

    /* renamed from: g  reason: collision with root package name */
    private String f7348g;

    /* renamed from: h  reason: collision with root package name */
    private String f7349h;

    /* renamed from: i  reason: collision with root package name */
    private LatLonPoint f7350i;

    /* renamed from: j  reason: collision with root package name */
    private String f7351j;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<GeocodeAddress> {
        a() {
        }

        /* renamed from: a */
        public GeocodeAddress createFromParcel(Parcel parcel) {
            return new GeocodeAddress(parcel, null);
        }

        /* renamed from: b */
        public GeocodeAddress[] newArray(int i10) {
            return null;
        }
    }

    /* synthetic */ GeocodeAddress(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7342a);
        parcel.writeString(this.f7343b);
        parcel.writeString(this.f7344c);
        parcel.writeString(this.f7345d);
        parcel.writeString(this.f7346e);
        parcel.writeString(this.f7347f);
        parcel.writeString(this.f7348g);
        parcel.writeString(this.f7349h);
        parcel.writeValue(this.f7350i);
        parcel.writeString(this.f7351j);
    }

    public GeocodeAddress() {
    }

    private GeocodeAddress(Parcel parcel) {
        this.f7342a = parcel.readString();
        this.f7343b = parcel.readString();
        this.f7344c = parcel.readString();
        this.f7345d = parcel.readString();
        this.f7346e = parcel.readString();
        this.f7347f = parcel.readString();
        this.f7348g = parcel.readString();
        this.f7349h = parcel.readString();
        this.f7350i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7351j = parcel.readString();
    }
}
