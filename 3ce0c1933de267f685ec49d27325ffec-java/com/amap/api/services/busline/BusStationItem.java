package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7268a;

    /* renamed from: b  reason: collision with root package name */
    private String f7269b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f7270c;

    /* renamed from: d  reason: collision with root package name */
    private String f7271d;

    /* renamed from: e  reason: collision with root package name */
    private String f7272e;

    /* renamed from: f  reason: collision with root package name */
    private List<BusLineItem> f7273f;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<BusStationItem> {
        a() {
        }

        /* renamed from: a */
        public BusStationItem createFromParcel(Parcel parcel) {
            return new BusStationItem(parcel, null);
        }

        /* renamed from: b */
        public BusStationItem[] newArray(int i10) {
            return null;
        }
    }

    /* synthetic */ BusStationItem(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                stringBuffer.append(list.get(i10).a());
                if (i10 < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusStationItem busStationItem = (BusStationItem) obj;
        String str = this.f7268a;
        if (str == null) {
            if (busStationItem.f7268a != null) {
                return false;
            }
        } else if (!str.equals(busStationItem.f7268a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7268a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BusStationName: " + this.f7269b + " LatLonPoint: " + this.f7270c.toString() + " BusLines: " + a(this.f7273f) + " CityCode: " + this.f7271d + " AdCode: " + this.f7272e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7269b);
        parcel.writeString(this.f7268a);
        parcel.writeValue(this.f7270c);
        parcel.writeString(this.f7271d);
        parcel.writeString(this.f7272e);
        parcel.writeList(this.f7273f);
    }

    public BusStationItem() {
        this.f7273f = new ArrayList();
    }

    private BusStationItem(Parcel parcel) {
        this.f7273f = new ArrayList();
        this.f7269b = parcel.readString();
        this.f7268a = parcel.readString();
        this.f7270c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7271d = parcel.readString();
        this.f7272e = parcel.readString();
        this.f7273f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
