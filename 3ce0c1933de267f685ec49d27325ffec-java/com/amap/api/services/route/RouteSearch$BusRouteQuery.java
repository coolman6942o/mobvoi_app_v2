package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import n4.o;
/* loaded from: classes.dex */
public class RouteSearch$BusRouteQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RouteSearch$BusRouteQuery> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private RouteSearch$FromAndTo f7495a;

    /* renamed from: b  reason: collision with root package name */
    private int f7496b;

    /* renamed from: c  reason: collision with root package name */
    private String f7497c;

    /* renamed from: d  reason: collision with root package name */
    private String f7498d;

    /* renamed from: e  reason: collision with root package name */
    private int f7499e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteSearch$BusRouteQuery> {
        a() {
        }

        /* renamed from: a */
        public RouteSearch$BusRouteQuery createFromParcel(Parcel parcel) {
            return new RouteSearch$BusRouteQuery(parcel);
        }

        /* renamed from: b */
        public RouteSearch$BusRouteQuery[] newArray(int i10) {
            return new RouteSearch$BusRouteQuery[i10];
        }
    }

    public RouteSearch$BusRouteQuery(RouteSearch$FromAndTo routeSearch$FromAndTo, int i10, String str, int i11) {
        this.f7495a = routeSearch$FromAndTo;
        this.f7496b = i10;
        this.f7497c = str;
        this.f7499e = i11;
    }

    /* renamed from: a */
    public RouteSearch$BusRouteQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            o.b(e10, "RouteSearch", "BusRouteQueryclone");
        }
        RouteSearch$BusRouteQuery routeSearch$BusRouteQuery = new RouteSearch$BusRouteQuery(this.f7495a, this.f7496b, this.f7497c, this.f7499e);
        routeSearch$BusRouteQuery.b(this.f7498d);
        return routeSearch$BusRouteQuery;
    }

    public void b(String str) {
        this.f7498d = str;
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
        RouteSearch$BusRouteQuery routeSearch$BusRouteQuery = (RouteSearch$BusRouteQuery) obj;
        String str = this.f7497c;
        if (str == null) {
            if (routeSearch$BusRouteQuery.f7497c != null) {
                return false;
            }
        } else if (!str.equals(routeSearch$BusRouteQuery.f7497c)) {
            return false;
        }
        String str2 = this.f7498d;
        if (str2 == null) {
            if (routeSearch$BusRouteQuery.f7498d != null) {
                return false;
            }
        } else if (!str2.equals(routeSearch$BusRouteQuery.f7498d)) {
            return false;
        }
        RouteSearch$FromAndTo routeSearch$FromAndTo = this.f7495a;
        if (routeSearch$FromAndTo == null) {
            if (routeSearch$BusRouteQuery.f7495a != null) {
                return false;
            }
        } else if (!routeSearch$FromAndTo.equals(routeSearch$BusRouteQuery.f7495a)) {
            return false;
        }
        return this.f7496b == routeSearch$BusRouteQuery.f7496b && this.f7499e == routeSearch$BusRouteQuery.f7499e;
    }

    public int hashCode() {
        String str = this.f7497c;
        int i10 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        RouteSearch$FromAndTo routeSearch$FromAndTo = this.f7495a;
        int hashCode2 = (((((hashCode + (routeSearch$FromAndTo == null ? 0 : routeSearch$FromAndTo.hashCode())) * 31) + this.f7496b) * 31) + this.f7499e) * 31;
        String str2 = this.f7498d;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode2 + i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7495a, i10);
        parcel.writeInt(this.f7496b);
        parcel.writeString(this.f7497c);
        parcel.writeInt(this.f7499e);
        parcel.writeString(this.f7498d);
    }

    public RouteSearch$BusRouteQuery(Parcel parcel) {
        this.f7495a = (RouteSearch$FromAndTo) parcel.readParcelable(RouteSearch$FromAndTo.class.getClassLoader());
        this.f7496b = parcel.readInt();
        this.f7497c = parcel.readString();
        this.f7499e = parcel.readInt();
        this.f7498d = parcel.readString();
    }

    public RouteSearch$BusRouteQuery() {
    }
}
