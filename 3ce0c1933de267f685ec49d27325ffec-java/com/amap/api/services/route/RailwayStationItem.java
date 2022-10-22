package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7457a;

    /* renamed from: b  reason: collision with root package name */
    private String f7458b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f7459c;

    /* renamed from: d  reason: collision with root package name */
    private String f7460d;

    /* renamed from: e  reason: collision with root package name */
    private String f7461e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7462f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7463g;

    /* renamed from: h  reason: collision with root package name */
    private float f7464h;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RailwayStationItem> {
        a() {
        }

        /* renamed from: a */
        public RailwayStationItem createFromParcel(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        /* renamed from: b */
        public RailwayStationItem[] newArray(int i10) {
            return new RailwayStationItem[i10];
        }
    }

    public RailwayStationItem() {
        this.f7462f = false;
        this.f7463g = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7457a);
        parcel.writeString(this.f7458b);
        parcel.writeParcelable(this.f7459c, i10);
        parcel.writeString(this.f7460d);
        parcel.writeString(this.f7461e);
        parcel.writeBooleanArray(new boolean[]{this.f7462f, this.f7463g});
        parcel.writeFloat(this.f7464h);
    }

    protected RailwayStationItem(Parcel parcel) {
        this.f7462f = false;
        this.f7463g = false;
        this.f7457a = parcel.readString();
        this.f7458b = parcel.readString();
        this.f7459c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7460d = parcel.readString();
        this.f7461e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f7462f = zArr[0];
        this.f7463g = zArr[1];
        this.f7464h = parcel.readFloat();
    }
}
