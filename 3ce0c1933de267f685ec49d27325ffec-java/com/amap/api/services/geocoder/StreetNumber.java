package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7373a;

    /* renamed from: b  reason: collision with root package name */
    private String f7374b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f7375c;

    /* renamed from: d  reason: collision with root package name */
    private String f7376d;

    /* renamed from: e  reason: collision with root package name */
    private float f7377e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<StreetNumber> {
        a() {
        }

        /* renamed from: a */
        public StreetNumber createFromParcel(Parcel parcel) {
            return new StreetNumber(parcel, null);
        }

        /* renamed from: b */
        public StreetNumber[] newArray(int i10) {
            return null;
        }
    }

    /* synthetic */ StreetNumber(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7373a);
        parcel.writeString(this.f7374b);
        parcel.writeValue(this.f7375c);
        parcel.writeString(this.f7376d);
        parcel.writeFloat(this.f7377e);
    }

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.f7373a = parcel.readString();
        this.f7374b = parcel.readString();
        this.f7375c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7376d = parcel.readString();
        this.f7377e = parcel.readFloat();
    }
}
