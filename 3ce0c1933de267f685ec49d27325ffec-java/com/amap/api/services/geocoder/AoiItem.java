package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7335a;

    /* renamed from: b  reason: collision with root package name */
    private String f7336b;

    /* renamed from: c  reason: collision with root package name */
    private String f7337c;

    /* renamed from: d  reason: collision with root package name */
    private LatLonPoint f7338d;

    /* renamed from: e  reason: collision with root package name */
    private Float f7339e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<AoiItem> {
        a() {
        }

        /* renamed from: a */
        public AoiItem createFromParcel(Parcel parcel) {
            return new AoiItem(parcel);
        }

        /* renamed from: b */
        public AoiItem[] newArray(int i10) {
            return new AoiItem[i10];
        }
    }

    public AoiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7335a);
        parcel.writeString(this.f7336b);
        parcel.writeString(this.f7337c);
        parcel.writeParcelable(this.f7338d, i10);
        parcel.writeFloat(this.f7339e.floatValue());
    }

    public AoiItem(Parcel parcel) {
        this.f7335a = parcel.readString();
        this.f7336b = parcel.readString();
        this.f7337c = parcel.readString();
        this.f7338d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7339e = Float.valueOf(parcel.readFloat());
    }
}
