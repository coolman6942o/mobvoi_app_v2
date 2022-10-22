package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7393a;

    /* renamed from: b  reason: collision with root package name */
    private String f7394b;

    /* renamed from: c  reason: collision with root package name */
    private String f7395c;

    /* renamed from: d  reason: collision with root package name */
    private int f7396d;

    /* renamed from: e  reason: collision with root package name */
    private LatLonPoint f7397e;

    /* renamed from: f  reason: collision with root package name */
    private String f7398f;

    /* renamed from: g  reason: collision with root package name */
    private String f7399g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<SubPoiItem> {
        a() {
        }

        /* renamed from: a */
        public SubPoiItem createFromParcel(Parcel parcel) {
            return new SubPoiItem(parcel);
        }

        /* renamed from: b */
        public SubPoiItem[] newArray(int i10) {
            return null;
        }
    }

    public SubPoiItem(Parcel parcel) {
        this.f7393a = parcel.readString();
        this.f7394b = parcel.readString();
        this.f7395c = parcel.readString();
        this.f7396d = parcel.readInt();
        this.f7397e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7398f = parcel.readString();
        this.f7399g = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7393a);
        parcel.writeString(this.f7394b);
        parcel.writeString(this.f7395c);
        parcel.writeInt(this.f7396d);
        parcel.writeValue(this.f7397e);
        parcel.writeString(this.f7398f);
        parcel.writeString(this.f7399g);
    }
}
