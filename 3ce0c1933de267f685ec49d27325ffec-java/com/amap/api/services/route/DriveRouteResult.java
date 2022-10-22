package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DriveRouteResult extends RouteResult {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private float f7435c;

    /* renamed from: d  reason: collision with root package name */
    private List<DrivePath> f7436d;

    /* renamed from: e  reason: collision with root package name */
    private RouteSearch$DriveRouteQuery f7437e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DriveRouteResult> {
        a() {
        }

        /* renamed from: a */
        public DriveRouteResult createFromParcel(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        /* renamed from: b */
        public DriveRouteResult[] newArray(int i10) {
            return new DriveRouteResult[i10];
        }
    }

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f7436d = new ArrayList();
        this.f7435c = parcel.readFloat();
        this.f7436d = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f7437e = (RouteSearch$DriveRouteQuery) parcel.readParcelable(RouteSearch$DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f7435c);
        parcel.writeTypedList(this.f7436d);
        parcel.writeParcelable(this.f7437e, i10);
    }

    public DriveRouteResult() {
        this.f7436d = new ArrayList();
    }
}
