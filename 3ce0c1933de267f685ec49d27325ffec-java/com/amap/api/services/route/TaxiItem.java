package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f7522a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f7523b;

    /* renamed from: c  reason: collision with root package name */
    private float f7524c;

    /* renamed from: d  reason: collision with root package name */
    private float f7525d;

    /* renamed from: e  reason: collision with root package name */
    private String f7526e;

    /* renamed from: f  reason: collision with root package name */
    private String f7527f;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<TaxiItem> {
        a() {
        }

        /* renamed from: a */
        public TaxiItem createFromParcel(Parcel parcel) {
            return new TaxiItem(parcel);
        }

        /* renamed from: b */
        public TaxiItem[] newArray(int i10) {
            return new TaxiItem[i10];
        }
    }

    public TaxiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7522a, i10);
        parcel.writeParcelable(this.f7523b, i10);
        parcel.writeFloat(this.f7524c);
        parcel.writeFloat(this.f7525d);
        parcel.writeString(this.f7526e);
        parcel.writeString(this.f7527f);
    }

    protected TaxiItem(Parcel parcel) {
        this.f7522a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7523b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7524c = parcel.readFloat();
        this.f7525d = parcel.readFloat();
        this.f7526e = parcel.readString();
        this.f7527f = parcel.readString();
    }
}
