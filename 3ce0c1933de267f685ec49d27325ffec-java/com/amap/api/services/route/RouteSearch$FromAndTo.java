package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import n4.o;
/* loaded from: classes.dex */
public class RouteSearch$FromAndTo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RouteSearch$FromAndTo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f7505a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f7506b;

    /* renamed from: c  reason: collision with root package name */
    private String f7507c;

    /* renamed from: d  reason: collision with root package name */
    private String f7508d;

    /* renamed from: e  reason: collision with root package name */
    private String f7509e;

    /* renamed from: f  reason: collision with root package name */
    private String f7510f;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteSearch$FromAndTo> {
        a() {
        }

        /* renamed from: a */
        public RouteSearch$FromAndTo createFromParcel(Parcel parcel) {
            return new RouteSearch$FromAndTo(parcel);
        }

        /* renamed from: b */
        public RouteSearch$FromAndTo[] newArray(int i10) {
            return new RouteSearch$FromAndTo[i10];
        }
    }

    public RouteSearch$FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        this.f7505a = latLonPoint;
        this.f7506b = latLonPoint2;
    }

    /* renamed from: a */
    public RouteSearch$FromAndTo clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            o.b(e10, "RouteSearch", "FromAndToclone");
        }
        RouteSearch$FromAndTo routeSearch$FromAndTo = new RouteSearch$FromAndTo(this.f7505a, this.f7506b);
        routeSearch$FromAndTo.e(this.f7507c);
        routeSearch$FromAndTo.b(this.f7508d);
        routeSearch$FromAndTo.d(this.f7509e);
        routeSearch$FromAndTo.c(this.f7510f);
        return routeSearch$FromAndTo;
    }

    public void b(String str) {
        this.f7508d = str;
    }

    public void c(String str) {
        this.f7510f = str;
    }

    public void d(String str) {
        this.f7509e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.f7507c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RouteSearch$FromAndTo routeSearch$FromAndTo = (RouteSearch$FromAndTo) obj;
        String str = this.f7508d;
        if (str == null) {
            if (routeSearch$FromAndTo.f7508d != null) {
                return false;
            }
        } else if (!str.equals(routeSearch$FromAndTo.f7508d)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f7505a;
        if (latLonPoint == null) {
            if (routeSearch$FromAndTo.f7505a != null) {
                return false;
            }
        } else if (!latLonPoint.equals(routeSearch$FromAndTo.f7505a)) {
            return false;
        }
        String str2 = this.f7507c;
        if (str2 == null) {
            if (routeSearch$FromAndTo.f7507c != null) {
                return false;
            }
        } else if (!str2.equals(routeSearch$FromAndTo.f7507c)) {
            return false;
        }
        LatLonPoint latLonPoint2 = this.f7506b;
        if (latLonPoint2 == null) {
            if (routeSearch$FromAndTo.f7506b != null) {
                return false;
            }
        } else if (!latLonPoint2.equals(routeSearch$FromAndTo.f7506b)) {
            return false;
        }
        String str3 = this.f7509e;
        if (str3 == null) {
            if (routeSearch$FromAndTo.f7509e != null) {
                return false;
            }
        } else if (!str3.equals(routeSearch$FromAndTo.f7509e)) {
            return false;
        }
        String str4 = this.f7510f;
        if (str4 == null) {
            if (routeSearch$FromAndTo.f7510f != null) {
                return false;
            }
        } else if (!str4.equals(routeSearch$FromAndTo.f7510f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7508d;
        int i10 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f7505a;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f7507c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        LatLonPoint latLonPoint2 = this.f7506b;
        int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
        String str3 = this.f7509e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f7510f;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return hashCode5 + i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7505a, i10);
        parcel.writeParcelable(this.f7506b, i10);
        parcel.writeString(this.f7507c);
        parcel.writeString(this.f7508d);
        parcel.writeString(this.f7509e);
        parcel.writeString(this.f7510f);
    }

    public RouteSearch$FromAndTo(Parcel parcel) {
        this.f7505a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7506b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7507c = parcel.readString();
        this.f7508d = parcel.readString();
        this.f7509e = parcel.readString();
        this.f7510f = parcel.readString();
    }

    public RouteSearch$FromAndTo() {
    }
}
