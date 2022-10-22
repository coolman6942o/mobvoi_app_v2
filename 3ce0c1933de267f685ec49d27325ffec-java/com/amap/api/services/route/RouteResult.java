package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f7493a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f7494b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteResult> {
        a() {
        }

        /* renamed from: a */
        public RouteResult createFromParcel(Parcel parcel) {
            return new RouteResult(parcel);
        }

        /* renamed from: b */
        public RouteResult[] newArray(int i10) {
            return new RouteResult[i10];
        }
    }

    public RouteResult(Parcel parcel) {
        this.f7493a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7494b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7493a, i10);
        parcel.writeParcelable(this.f7494b, i10);
    }

    public RouteResult() {
    }
}
