package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RouteBusLineItem extends BusLineItem {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new a();

    /* renamed from: p  reason: collision with root package name */
    private BusStationItem f7476p;

    /* renamed from: q  reason: collision with root package name */
    private BusStationItem f7477q;

    /* renamed from: r  reason: collision with root package name */
    private List<LatLonPoint> f7478r;

    /* renamed from: s  reason: collision with root package name */
    private int f7479s;

    /* renamed from: t  reason: collision with root package name */
    private List<BusStationItem> f7480t;

    /* renamed from: u  reason: collision with root package name */
    private float f7481u;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteBusLineItem> {
        a() {
        }

        /* renamed from: a */
        public RouteBusLineItem createFromParcel(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        /* renamed from: b */
        public RouteBusLineItem[] newArray(int i10) {
            return null;
        }
    }

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f7478r = new ArrayList();
        this.f7480t = new ArrayList();
        this.f7476p = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f7477q = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f7478r = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7479s = parcel.readInt();
        this.f7480t = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f7481u = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        BusStationItem busStationItem = this.f7477q;
        if (busStationItem == null) {
            if (routeBusLineItem.f7477q != null) {
                return false;
            }
        } else if (!busStationItem.equals(routeBusLineItem.f7477q)) {
            return false;
        }
        BusStationItem busStationItem2 = this.f7476p;
        if (busStationItem2 == null) {
            if (routeBusLineItem.f7476p != null) {
                return false;
            }
        } else if (!busStationItem2.equals(routeBusLineItem.f7476p)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        BusStationItem busStationItem = this.f7477q;
        int i10 = 0;
        int hashCode2 = (hashCode + (busStationItem == null ? 0 : busStationItem.hashCode())) * 31;
        BusStationItem busStationItem2 = this.f7476p;
        if (busStationItem2 != null) {
            i10 = busStationItem2.hashCode();
        }
        return hashCode2 + i10;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f7476p, i10);
        parcel.writeParcelable(this.f7477q, i10);
        parcel.writeTypedList(this.f7478r);
        parcel.writeInt(this.f7479s);
        parcel.writeTypedList(this.f7480t);
        parcel.writeFloat(this.f7481u);
    }

    public RouteBusLineItem() {
        this.f7478r = new ArrayList();
        this.f7480t = new ArrayList();
    }
}
