package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7455a;

    /* renamed from: b  reason: collision with root package name */
    private float f7456b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RailwaySpace> {
        a() {
        }

        /* renamed from: a */
        public RailwaySpace createFromParcel(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        /* renamed from: b */
        public RailwaySpace[] newArray(int i10) {
            return new RailwaySpace[i10];
        }
    }

    protected RailwaySpace(Parcel parcel) {
        this.f7455a = parcel.readString();
        this.f7456b = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7455a);
        parcel.writeFloat(this.f7456b);
    }
}
