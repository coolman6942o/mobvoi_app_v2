package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import n4.o;
/* loaded from: classes.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private float f7252a;

    /* renamed from: b  reason: collision with root package name */
    private String f7253b;

    /* renamed from: c  reason: collision with root package name */
    private String f7254c;

    /* renamed from: d  reason: collision with root package name */
    private String f7255d;

    /* renamed from: e  reason: collision with root package name */
    private List<LatLonPoint> f7256e;

    /* renamed from: f  reason: collision with root package name */
    private List<LatLonPoint> f7257f;

    /* renamed from: g  reason: collision with root package name */
    private String f7258g;

    /* renamed from: h  reason: collision with root package name */
    private String f7259h;

    /* renamed from: i  reason: collision with root package name */
    private String f7260i;

    /* renamed from: j  reason: collision with root package name */
    private Date f7261j;

    /* renamed from: k  reason: collision with root package name */
    private Date f7262k;

    /* renamed from: l  reason: collision with root package name */
    private String f7263l;

    /* renamed from: m  reason: collision with root package name */
    private float f7264m;

    /* renamed from: n  reason: collision with root package name */
    private float f7265n;

    /* renamed from: o  reason: collision with root package name */
    private List<BusStationItem> f7266o;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<BusLineItem> {
        a() {
        }

        /* renamed from: a */
        public BusLineItem createFromParcel(Parcel parcel) {
            return new BusLineItem(parcel);
        }

        /* renamed from: b */
        public BusLineItem[] newArray(int i10) {
            return null;
        }
    }

    public BusLineItem() {
        this.f7256e = new ArrayList();
        this.f7257f = new ArrayList();
        this.f7266o = new ArrayList();
    }

    public String a() {
        return this.f7253b;
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
        BusLineItem busLineItem = (BusLineItem) obj;
        String str = this.f7258g;
        if (str == null) {
            if (busLineItem.f7258g != null) {
                return false;
            }
        } else if (!str.equals(busLineItem.f7258g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7258g;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return this.f7253b + " " + o.a(this.f7261j) + "-" + o.a(this.f7262k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f7252a);
        parcel.writeString(this.f7253b);
        parcel.writeString(this.f7254c);
        parcel.writeString(this.f7255d);
        parcel.writeList(this.f7256e);
        parcel.writeList(this.f7257f);
        parcel.writeString(this.f7258g);
        parcel.writeString(this.f7259h);
        parcel.writeString(this.f7260i);
        parcel.writeString(o.a(this.f7261j));
        parcel.writeString(o.a(this.f7262k));
        parcel.writeString(this.f7263l);
        parcel.writeFloat(this.f7264m);
        parcel.writeFloat(this.f7265n);
        parcel.writeList(this.f7266o);
    }

    public BusLineItem(Parcel parcel) {
        this.f7256e = new ArrayList();
        this.f7257f = new ArrayList();
        this.f7266o = new ArrayList();
        this.f7252a = parcel.readFloat();
        this.f7253b = parcel.readString();
        this.f7254c = parcel.readString();
        this.f7255d = parcel.readString();
        this.f7256e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f7257f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f7258g = parcel.readString();
        this.f7259h = parcel.readString();
        this.f7260i = parcel.readString();
        this.f7261j = o.c(parcel.readString());
        this.f7262k = o.c(parcel.readString());
        this.f7263l = parcel.readString();
        this.f7264m = parcel.readFloat();
        this.f7265n = parcel.readFloat();
        this.f7266o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
