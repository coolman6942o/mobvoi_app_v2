package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private float f7451a;

    /* renamed from: b  reason: collision with root package name */
    private long f7452b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Path> {
        a() {
        }

        /* renamed from: a */
        public Path createFromParcel(Parcel parcel) {
            return new Path(parcel);
        }

        /* renamed from: b */
        public Path[] newArray(int i10) {
            return null;
        }
    }

    public Path(Parcel parcel) {
        this.f7451a = parcel.readFloat();
        this.f7452b = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f7451a);
        parcel.writeLong(this.f7452b);
    }

    public Path() {
    }
}
