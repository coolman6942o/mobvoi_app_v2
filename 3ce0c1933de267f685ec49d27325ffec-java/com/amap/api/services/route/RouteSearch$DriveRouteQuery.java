package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
import n4.o;
/* loaded from: classes.dex */
public class RouteSearch$DriveRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RouteSearch$DriveRouteQuery> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private RouteSearch$FromAndTo f7500a;

    /* renamed from: b  reason: collision with root package name */
    private int f7501b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLonPoint> f7502c;

    /* renamed from: d  reason: collision with root package name */
    private List<List<LatLonPoint>> f7503d;

    /* renamed from: e  reason: collision with root package name */
    private String f7504e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteSearch$DriveRouteQuery> {
        a() {
        }

        /* renamed from: a */
        public RouteSearch$DriveRouteQuery createFromParcel(Parcel parcel) {
            return new RouteSearch$DriveRouteQuery(parcel);
        }

        /* renamed from: b */
        public RouteSearch$DriveRouteQuery[] newArray(int i10) {
            return new RouteSearch$DriveRouteQuery[i10];
        }
    }

    public RouteSearch$DriveRouteQuery(RouteSearch$FromAndTo routeSearch$FromAndTo, int i10, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
        this.f7500a = routeSearch$FromAndTo;
        this.f7501b = i10;
        this.f7502c = list;
        this.f7503d = list2;
        this.f7504e = str;
    }

    /* renamed from: a */
    public RouteSearch$DriveRouteQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            o.b(e10, "RouteSearch", "DriveRouteQueryclone");
        }
        return new RouteSearch$DriveRouteQuery(this.f7500a, this.f7501b, this.f7502c, this.f7503d, this.f7504e);
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
        RouteSearch$DriveRouteQuery routeSearch$DriveRouteQuery = (RouteSearch$DriveRouteQuery) obj;
        String str = this.f7504e;
        if (str == null) {
            if (routeSearch$DriveRouteQuery.f7504e != null) {
                return false;
            }
        } else if (!str.equals(routeSearch$DriveRouteQuery.f7504e)) {
            return false;
        }
        List<List<LatLonPoint>> list = this.f7503d;
        if (list == null) {
            if (routeSearch$DriveRouteQuery.f7503d != null) {
                return false;
            }
        } else if (!list.equals(routeSearch$DriveRouteQuery.f7503d)) {
            return false;
        }
        RouteSearch$FromAndTo routeSearch$FromAndTo = this.f7500a;
        if (routeSearch$FromAndTo == null) {
            if (routeSearch$DriveRouteQuery.f7500a != null) {
                return false;
            }
        } else if (!routeSearch$FromAndTo.equals(routeSearch$DriveRouteQuery.f7500a)) {
            return false;
        }
        if (this.f7501b != routeSearch$DriveRouteQuery.f7501b) {
            return false;
        }
        List<LatLonPoint> list2 = this.f7502c;
        if (list2 == null) {
            if (routeSearch$DriveRouteQuery.f7502c != null) {
                return false;
            }
        } else if (!list2.equals(routeSearch$DriveRouteQuery.f7502c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7504e;
        int i10 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        List<List<LatLonPoint>> list = this.f7503d;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        RouteSearch$FromAndTo routeSearch$FromAndTo = this.f7500a;
        int hashCode3 = (((hashCode2 + (routeSearch$FromAndTo == null ? 0 : routeSearch$FromAndTo.hashCode())) * 31) + this.f7501b) * 31;
        List<LatLonPoint> list2 = this.f7502c;
        if (list2 != null) {
            i10 = list2.hashCode();
        }
        return hashCode3 + i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7500a, i10);
        parcel.writeInt(this.f7501b);
        parcel.writeTypedList(this.f7502c);
        List<List<LatLonPoint>> list = this.f7503d;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(list.size());
            for (List<LatLonPoint> list2 : this.f7503d) {
                parcel.writeTypedList(list2);
            }
        }
        parcel.writeString(this.f7504e);
    }

    public RouteSearch$DriveRouteQuery(Parcel parcel) {
        this.f7500a = (RouteSearch$FromAndTo) parcel.readParcelable(RouteSearch$FromAndTo.class.getClassLoader());
        this.f7501b = parcel.readInt();
        this.f7502c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        int readInt = parcel.readInt();
        if (readInt == 0) {
            this.f7503d = null;
        } else {
            this.f7503d = new ArrayList();
        }
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f7503d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
        }
        this.f7504e = parcel.readString();
    }

    public RouteSearch$DriveRouteQuery() {
    }
}
