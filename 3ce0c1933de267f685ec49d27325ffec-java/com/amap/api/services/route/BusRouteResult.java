package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BusRouteResult extends RouteResult {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private float f7417c;

    /* renamed from: d  reason: collision with root package name */
    private List<BusPath> f7418d;

    /* renamed from: e  reason: collision with root package name */
    private RouteSearch$BusRouteQuery f7419e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<BusRouteResult> {
        a() {
        }

        /* renamed from: a */
        public BusRouteResult createFromParcel(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        /* renamed from: b */
        public BusRouteResult[] newArray(int i10) {
            return new BusRouteResult[i10];
        }
    }

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f7418d = new ArrayList();
        this.f7417c = parcel.readFloat();
        this.f7418d = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f7419e = (RouteSearch$BusRouteQuery) parcel.readParcelable(RouteSearch$BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f7417c);
        parcel.writeTypedList(this.f7418d);
        parcel.writeParcelable(this.f7419e, i10);
    }

    public BusRouteResult() {
        this.f7418d = new ArrayList();
    }
}
