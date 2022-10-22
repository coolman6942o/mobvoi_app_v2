package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7579a;

    /* renamed from: b  reason: collision with root package name */
    private String f7580b;

    /* renamed from: c  reason: collision with root package name */
    private String f7581c;

    /* renamed from: d  reason: collision with root package name */
    private String f7582d;

    /* renamed from: e  reason: collision with root package name */
    private String f7583e;

    /* renamed from: f  reason: collision with root package name */
    private String f7584f;

    /* renamed from: g  reason: collision with root package name */
    private String f7585g;

    /* renamed from: h  reason: collision with root package name */
    private String f7586h;

    /* renamed from: i  reason: collision with root package name */
    private String f7587i;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<LocalWeatherLive> {
        a() {
        }

        /* renamed from: a */
        public LocalWeatherLive createFromParcel(Parcel parcel) {
            return new LocalWeatherLive(parcel);
        }

        /* renamed from: b */
        public LocalWeatherLive[] newArray(int i10) {
            return null;
        }
    }

    public LocalWeatherLive() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7579a);
        parcel.writeString(this.f7580b);
        parcel.writeString(this.f7581c);
        parcel.writeString(this.f7582d);
        parcel.writeString(this.f7583e);
        parcel.writeString(this.f7584f);
        parcel.writeString(this.f7585g);
        parcel.writeString(this.f7586h);
        parcel.writeString(this.f7587i);
    }

    public LocalWeatherLive(Parcel parcel) {
        this.f7579a = parcel.readString();
        this.f7580b = parcel.readString();
        this.f7581c = parcel.readString();
        this.f7582d = parcel.readString();
        this.f7583e = parcel.readString();
        this.f7584f = parcel.readString();
        this.f7585g = parcel.readString();
        this.f7586h = parcel.readString();
        this.f7587i = parcel.readString();
    }
}
