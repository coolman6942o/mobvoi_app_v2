package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import n4.o;
/* loaded from: classes.dex */
public class RouteSearch$WalkRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RouteSearch$WalkRouteQuery> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private RouteSearch$FromAndTo f7513a;

    /* renamed from: b  reason: collision with root package name */
    private int f7514b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteSearch$WalkRouteQuery> {
        a() {
        }

        /* renamed from: a */
        public RouteSearch$WalkRouteQuery createFromParcel(Parcel parcel) {
            return new RouteSearch$WalkRouteQuery(parcel);
        }

        /* renamed from: b */
        public RouteSearch$WalkRouteQuery[] newArray(int i10) {
            return new RouteSearch$WalkRouteQuery[i10];
        }
    }

    public RouteSearch$WalkRouteQuery(RouteSearch$FromAndTo routeSearch$FromAndTo) {
        this.f7513a = routeSearch$FromAndTo;
    }

    /* renamed from: c */
    public RouteSearch$WalkRouteQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            o.b(e10, "RouteSearch", "WalkRouteQueryclone");
        }
        return new RouteSearch$WalkRouteQuery(this.f7513a);
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
        RouteSearch$WalkRouteQuery routeSearch$WalkRouteQuery = (RouteSearch$WalkRouteQuery) obj;
        RouteSearch$FromAndTo routeSearch$FromAndTo = this.f7513a;
        if (routeSearch$FromAndTo == null) {
            if (routeSearch$WalkRouteQuery.f7513a != null) {
                return false;
            }
        } else if (!routeSearch$FromAndTo.equals(routeSearch$WalkRouteQuery.f7513a)) {
            return false;
        }
        return this.f7514b == routeSearch$WalkRouteQuery.f7514b;
    }

    public int hashCode() {
        RouteSearch$FromAndTo routeSearch$FromAndTo = this.f7513a;
        return (((routeSearch$FromAndTo == null ? 0 : routeSearch$FromAndTo.hashCode()) + 31) * 31) + this.f7514b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7513a, i10);
        parcel.writeInt(this.f7514b);
    }

    public RouteSearch$WalkRouteQuery(Parcel parcel) {
        this.f7513a = (RouteSearch$FromAndTo) parcel.readParcelable(RouteSearch$FromAndTo.class.getClassLoader());
        this.f7514b = parcel.readInt();
    }

    public RouteSearch$WalkRouteQuery() {
    }
}
