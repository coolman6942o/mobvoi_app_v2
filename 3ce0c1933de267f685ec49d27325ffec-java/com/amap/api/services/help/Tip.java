package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7378a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f7379b;

    /* renamed from: c  reason: collision with root package name */
    private String f7380c;

    /* renamed from: d  reason: collision with root package name */
    private String f7381d;

    /* renamed from: e  reason: collision with root package name */
    private String f7382e;

    /* renamed from: f  reason: collision with root package name */
    private String f7383f;

    /* renamed from: g  reason: collision with root package name */
    private String f7384g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Tip> {
        a() {
        }

        /* renamed from: a */
        public Tip createFromParcel(Parcel parcel) {
            return new Tip(parcel, null);
        }

        /* renamed from: b */
        public Tip[] newArray(int i10) {
            return null;
        }
    }

    /* synthetic */ Tip(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "name:" + this.f7380c + " district:" + this.f7381d + " adcode:" + this.f7382e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7380c);
        parcel.writeString(this.f7382e);
        parcel.writeString(this.f7381d);
        parcel.writeString(this.f7378a);
        parcel.writeValue(this.f7379b);
        parcel.writeString(this.f7383f);
        parcel.writeString(this.f7384g);
    }

    public Tip() {
    }

    private Tip(Parcel parcel) {
        this.f7380c = parcel.readString();
        this.f7382e = parcel.readString();
        this.f7381d = parcel.readString();
        this.f7378a = parcel.readString();
        this.f7379b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7383f = parcel.readString();
        this.f7384g = parcel.readString();
    }
}
