package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RouteRailwayItem extends Railway {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private String f7484c;

    /* renamed from: d  reason: collision with root package name */
    private String f7485d;

    /* renamed from: e  reason: collision with root package name */
    private float f7486e;

    /* renamed from: f  reason: collision with root package name */
    private String f7487f;

    /* renamed from: g  reason: collision with root package name */
    private RailwayStationItem f7488g;

    /* renamed from: h  reason: collision with root package name */
    private RailwayStationItem f7489h;

    /* renamed from: i  reason: collision with root package name */
    private List<RailwayStationItem> f7490i;

    /* renamed from: j  reason: collision with root package name */
    private List<Railway> f7491j;

    /* renamed from: k  reason: collision with root package name */
    private List<RailwaySpace> f7492k;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteRailwayItem> {
        a() {
        }

        /* renamed from: a */
        public RouteRailwayItem createFromParcel(Parcel parcel) {
            return new RouteRailwayItem(parcel);
        }

        /* renamed from: b */
        public RouteRailwayItem[] newArray(int i10) {
            return new RouteRailwayItem[i10];
        }
    }

    public RouteRailwayItem() {
        this.f7490i = new ArrayList();
        this.f7491j = new ArrayList();
        this.f7492k = new ArrayList();
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f7484c);
        parcel.writeString(this.f7485d);
        parcel.writeFloat(this.f7486e);
        parcel.writeString(this.f7487f);
        parcel.writeParcelable(this.f7488g, i10);
        parcel.writeParcelable(this.f7489h, i10);
        parcel.writeTypedList(this.f7490i);
        parcel.writeTypedList(this.f7491j);
        parcel.writeTypedList(this.f7492k);
    }

    protected RouteRailwayItem(Parcel parcel) {
        super(parcel);
        this.f7490i = new ArrayList();
        this.f7491j = new ArrayList();
        this.f7492k = new ArrayList();
        this.f7484c = parcel.readString();
        this.f7485d = parcel.readString();
        this.f7486e = parcel.readFloat();
        this.f7487f = parcel.readString();
        this.f7488g = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f7489h = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f7490i = parcel.createTypedArrayList(RailwayStationItem.CREATOR);
        this.f7491j = parcel.createTypedArrayList(Railway.CREATOR);
        this.f7492k = parcel.createTypedArrayList(RailwaySpace.CREATOR);
    }
}
