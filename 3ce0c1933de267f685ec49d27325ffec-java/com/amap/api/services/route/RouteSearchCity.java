package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RouteSearchCity extends SearchCity {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    List<District> f7515d;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteSearchCity> {
        a() {
        }

        /* renamed from: a */
        public RouteSearchCity createFromParcel(Parcel parcel) {
            return new RouteSearchCity(parcel);
        }

        /* renamed from: b */
        public RouteSearchCity[] newArray(int i10) {
            return null;
        }
    }

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.f7515d = new ArrayList();
        this.f7515d = parcel.createTypedArrayList(District.CREATOR);
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f7515d);
    }

    public RouteSearchCity() {
        this.f7515d = new ArrayList();
    }
}
