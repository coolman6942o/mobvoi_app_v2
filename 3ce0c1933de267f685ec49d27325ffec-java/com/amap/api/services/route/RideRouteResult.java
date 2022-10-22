package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RideRouteResult extends RouteResult {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private List<RidePath> f7466c;

    /* renamed from: d  reason: collision with root package name */
    private RouteSearch$RideRouteQuery f7467d;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RideRouteResult> {
        a() {
        }

        /* renamed from: a */
        public RideRouteResult createFromParcel(Parcel parcel) {
            return new RideRouteResult(parcel);
        }

        /* renamed from: b */
        public RideRouteResult[] newArray(int i10) {
            return new RideRouteResult[i10];
        }
    }

    public RideRouteResult(Parcel parcel) {
        super(parcel);
        this.f7466c = new ArrayList();
        this.f7466c = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f7467d = (RouteSearch$RideRouteQuery) parcel.readParcelable(RouteSearch$RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f7466c);
        parcel.writeParcelable(this.f7467d, i10);
    }

    public RideRouteResult() {
        this.f7466c = new ArrayList();
    }
}
