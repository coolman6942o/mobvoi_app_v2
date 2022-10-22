package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7428a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f7429b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Doorway> {
        a() {
        }

        /* renamed from: a */
        public Doorway createFromParcel(Parcel parcel) {
            return new Doorway(parcel);
        }

        /* renamed from: b */
        public Doorway[] newArray(int i10) {
            return null;
        }
    }

    public Doorway(Parcel parcel) {
        this.f7428a = parcel.readString();
        this.f7429b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7428a);
        parcel.writeParcelable(this.f7429b, i10);
    }

    public Doorway() {
    }
}
