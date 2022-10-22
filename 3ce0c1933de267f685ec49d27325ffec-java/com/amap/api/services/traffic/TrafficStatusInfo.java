package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;
/* loaded from: classes.dex */
public class TrafficStatusInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficStatusInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7553a;

    /* renamed from: b  reason: collision with root package name */
    private String f7554b;

    /* renamed from: c  reason: collision with root package name */
    private String f7555c;

    /* renamed from: d  reason: collision with root package name */
    private int f7556d;

    /* renamed from: e  reason: collision with root package name */
    private float f7557e;

    /* renamed from: f  reason: collision with root package name */
    private String f7558f;

    /* renamed from: g  reason: collision with root package name */
    private List<LatLonPoint> f7559g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<TrafficStatusInfo> {
        a() {
        }

        /* renamed from: a */
        public TrafficStatusInfo createFromParcel(Parcel parcel) {
            return new TrafficStatusInfo(parcel);
        }

        /* renamed from: b */
        public TrafficStatusInfo[] newArray(int i10) {
            return new TrafficStatusInfo[i10];
        }
    }

    public TrafficStatusInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7553a);
        parcel.writeString(this.f7554b);
        parcel.writeString(this.f7555c);
        parcel.writeInt(this.f7556d);
        parcel.writeFloat(this.f7557e);
        parcel.writeString(this.f7558f);
        parcel.writeTypedList(this.f7559g);
    }

    protected TrafficStatusInfo(Parcel parcel) {
        this.f7553a = parcel.readString();
        this.f7554b = parcel.readString();
        this.f7555c = parcel.readString();
        this.f7556d = parcel.readInt();
        this.f7557e = parcel.readFloat();
        this.f7558f = parcel.readString();
        this.f7559g = parcel.readArrayList(TrafficStatusInfo.class.getClassLoader());
    }
}
