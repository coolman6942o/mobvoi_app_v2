package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7539a;

    /* renamed from: b  reason: collision with root package name */
    private String f7540b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f7541c;

    /* renamed from: d  reason: collision with root package name */
    private float f7542d;

    /* renamed from: e  reason: collision with root package name */
    private float f7543e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RoutePOIItem> {
        a() {
        }

        /* renamed from: a */
        public RoutePOIItem createFromParcel(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        /* renamed from: b */
        public RoutePOIItem[] newArray(int i10) {
            return new RoutePOIItem[i10];
        }
    }

    public RoutePOIItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7539a);
        parcel.writeString(this.f7540b);
        parcel.writeParcelable(this.f7541c, i10);
        parcel.writeFloat(this.f7542d);
        parcel.writeFloat(this.f7543e);
    }

    protected RoutePOIItem(Parcel parcel) {
        this.f7539a = parcel.readString();
        this.f7540b = parcel.readString();
        this.f7541c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7542d = parcel.readFloat();
        this.f7543e = parcel.readFloat();
    }
}
