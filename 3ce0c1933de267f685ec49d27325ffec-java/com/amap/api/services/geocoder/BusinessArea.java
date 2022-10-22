package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f7340a;

    /* renamed from: b  reason: collision with root package name */
    private String f7341b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<BusinessArea> {
        a() {
        }

        /* renamed from: a */
        public BusinessArea createFromParcel(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        /* renamed from: b */
        public BusinessArea[] newArray(int i10) {
            return new BusinessArea[i10];
        }
    }

    public BusinessArea() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7340a, i10);
        parcel.writeString(this.f7341b);
    }

    public BusinessArea(Parcel parcel) {
        this.f7340a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7341b = parcel.readString();
    }
}
