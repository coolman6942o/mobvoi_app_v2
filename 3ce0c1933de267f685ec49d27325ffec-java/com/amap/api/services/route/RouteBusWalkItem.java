package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class RouteBusWalkItem extends WalkPath {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    private LatLonPoint f7482d;

    /* renamed from: e  reason: collision with root package name */
    private LatLonPoint f7483e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RouteBusWalkItem> {
        a() {
        }

        /* renamed from: a */
        public RouteBusWalkItem createFromParcel(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }

        /* renamed from: b */
        public RouteBusWalkItem[] newArray(int i10) {
            return null;
        }
    }

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f7482d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7483e = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f7482d, i10);
        parcel.writeParcelable(this.f7483e, i10);
    }

    public RouteBusWalkItem() {
    }
}
