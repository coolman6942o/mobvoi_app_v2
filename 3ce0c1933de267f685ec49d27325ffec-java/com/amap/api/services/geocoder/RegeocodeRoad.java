package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7368a;

    /* renamed from: b  reason: collision with root package name */
    private String f7369b;

    /* renamed from: c  reason: collision with root package name */
    private float f7370c;

    /* renamed from: d  reason: collision with root package name */
    private String f7371d;

    /* renamed from: e  reason: collision with root package name */
    private LatLonPoint f7372e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RegeocodeRoad> {
        a() {
        }

        /* renamed from: a */
        public RegeocodeRoad createFromParcel(Parcel parcel) {
            return new RegeocodeRoad(parcel, null);
        }

        /* renamed from: b */
        public RegeocodeRoad[] newArray(int i10) {
            return null;
        }
    }

    /* synthetic */ RegeocodeRoad(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7368a);
        parcel.writeString(this.f7369b);
        parcel.writeFloat(this.f7370c);
        parcel.writeString(this.f7371d);
        parcel.writeValue(this.f7372e);
    }

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f7368a = parcel.readString();
        this.f7369b = parcel.readString();
        this.f7370c = parcel.readFloat();
        this.f7371d = parcel.readString();
        this.f7372e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
