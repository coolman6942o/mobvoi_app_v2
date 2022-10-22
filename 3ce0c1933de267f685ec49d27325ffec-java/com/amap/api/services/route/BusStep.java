package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private RouteBusWalkItem f7420a;

    /* renamed from: b  reason: collision with root package name */
    private List<RouteBusLineItem> f7421b;

    /* renamed from: c  reason: collision with root package name */
    private Doorway f7422c;

    /* renamed from: d  reason: collision with root package name */
    private Doorway f7423d;

    /* renamed from: e  reason: collision with root package name */
    private RouteRailwayItem f7424e;

    /* renamed from: f  reason: collision with root package name */
    private TaxiItem f7425f;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<BusStep> {
        a() {
        }

        /* renamed from: a */
        public BusStep createFromParcel(Parcel parcel) {
            return new BusStep(parcel);
        }

        /* renamed from: b */
        public BusStep[] newArray(int i10) {
            return null;
        }
    }

    public BusStep(Parcel parcel) {
        this.f7421b = new ArrayList();
        this.f7420a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f7421b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f7422c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f7423d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f7424e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f7425f = (TaxiItem) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7420a, i10);
        parcel.writeTypedList(this.f7421b);
        parcel.writeParcelable(this.f7422c, i10);
        parcel.writeParcelable(this.f7423d, i10);
        parcel.writeParcelable(this.f7424e, i10);
        parcel.writeParcelable(this.f7425f, i10);
    }

    public BusStep() {
        this.f7421b = new ArrayList();
    }
}
