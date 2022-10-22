package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WalkRouteResult extends RouteResult {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private List<WalkPath> f7529c;

    /* renamed from: d  reason: collision with root package name */
    private RouteSearch$WalkRouteQuery f7530d;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<WalkRouteResult> {
        a() {
        }

        /* renamed from: a */
        public WalkRouteResult createFromParcel(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        /* renamed from: b */
        public WalkRouteResult[] newArray(int i10) {
            return new WalkRouteResult[i10];
        }
    }

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f7529c = new ArrayList();
        this.f7529c = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f7530d = (RouteSearch$WalkRouteQuery) parcel.readParcelable(RouteSearch$WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f7529c);
        parcel.writeParcelable(this.f7530d, i10);
    }

    public WalkRouteResult() {
        this.f7529c = new ArrayList();
    }
}
