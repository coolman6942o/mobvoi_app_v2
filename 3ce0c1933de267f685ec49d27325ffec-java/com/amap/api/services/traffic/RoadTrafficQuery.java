package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import n4.o;
/* loaded from: classes.dex */
public class RoadTrafficQuery extends com.amap.api.services.traffic.a implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RoadTrafficQuery> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private String f7545b;

    /* renamed from: c  reason: collision with root package name */
    private String f7546c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RoadTrafficQuery> {
        a() {
        }

        /* renamed from: a */
        public RoadTrafficQuery createFromParcel(Parcel parcel) {
            return new RoadTrafficQuery(parcel);
        }

        /* renamed from: b */
        public RoadTrafficQuery[] newArray(int i10) {
            return new RoadTrafficQuery[i10];
        }
    }

    public RoadTrafficQuery(String str, String str2, int i10) {
        this.f7545b = str;
        this.f7546c = str2;
        this.f7563a = i10;
    }

    /* renamed from: a */
    public RoadTrafficQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            o.b(e10, "RoadTrafficQuery", "RoadTrafficQueryClone");
        }
        return new RoadTrafficQuery(this.f7545b, this.f7546c, this.f7563a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7545b);
        parcel.writeString(this.f7546c);
        parcel.writeInt(this.f7563a);
    }

    protected RoadTrafficQuery(Parcel parcel) {
        this.f7545b = parcel.readString();
        this.f7546c = parcel.readString();
        this.f7563a = parcel.readInt();
    }
}
