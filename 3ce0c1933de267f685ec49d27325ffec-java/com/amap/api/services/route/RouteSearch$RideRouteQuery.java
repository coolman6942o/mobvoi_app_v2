package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import n4.o;
/* loaded from: classes.dex */
public class RouteSearch$RideRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RouteSearch$RideRouteQuery> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private RouteSearch$FromAndTo f7511a;

    /* renamed from: b  reason: collision with root package name */
    private int f7512b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteSearch$RideRouteQuery> {
        a() {
        }

        /* renamed from: a */
        public RouteSearch$RideRouteQuery createFromParcel(Parcel parcel) {
            return new RouteSearch$RideRouteQuery(parcel);
        }

        /* renamed from: b */
        public RouteSearch$RideRouteQuery[] newArray(int i10) {
            return new RouteSearch$RideRouteQuery[i10];
        }
    }

    public RouteSearch$RideRouteQuery(RouteSearch$FromAndTo routeSearch$FromAndTo) {
        this.f7511a = routeSearch$FromAndTo;
    }

    /* renamed from: a */
    public RouteSearch$RideRouteQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            o.b(e10, "RouteSearch", "RideRouteQueryclone");
        }
        return new RouteSearch$RideRouteQuery(this.f7511a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        int i10;
        RouteSearch$FromAndTo routeSearch$FromAndTo;
        RouteSearch$FromAndTo routeSearch$FromAndTo2;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RouteSearch$WalkRouteQuery routeSearch$WalkRouteQuery = (RouteSearch$WalkRouteQuery) obj;
        RouteSearch$FromAndTo routeSearch$FromAndTo3 = this.f7511a;
        if (routeSearch$FromAndTo3 == null) {
            routeSearch$FromAndTo2 = routeSearch$WalkRouteQuery.f7513a;
            if (routeSearch$FromAndTo2 != null) {
                return false;
            }
        } else {
            routeSearch$FromAndTo = routeSearch$WalkRouteQuery.f7513a;
            if (!routeSearch$FromAndTo3.equals(routeSearch$FromAndTo)) {
                return false;
            }
        }
        int i11 = this.f7512b;
        i10 = routeSearch$WalkRouteQuery.f7514b;
        return i11 == i10;
    }

    public int hashCode() {
        RouteSearch$FromAndTo routeSearch$FromAndTo = this.f7511a;
        return (((routeSearch$FromAndTo == null ? 0 : routeSearch$FromAndTo.hashCode()) + 31) * 31) + this.f7512b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7511a, i10);
        parcel.writeInt(this.f7512b);
    }

    public RouteSearch$RideRouteQuery(Parcel parcel) {
        this.f7511a = (RouteSearch$FromAndTo) parcel.readParcelable(RouteSearch$FromAndTo.class.getClassLoader());
        this.f7512b = parcel.readInt();
    }

    public RouteSearch$RideRouteQuery() {
    }
}
