package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7564a;

    /* renamed from: b  reason: collision with root package name */
    private String f7565b;

    /* renamed from: c  reason: collision with root package name */
    private String f7566c;

    /* renamed from: d  reason: collision with root package name */
    private String f7567d;

    /* renamed from: e  reason: collision with root package name */
    private String f7568e;

    /* renamed from: f  reason: collision with root package name */
    private String f7569f;

    /* renamed from: g  reason: collision with root package name */
    private String f7570g;

    /* renamed from: h  reason: collision with root package name */
    private String f7571h;

    /* renamed from: i  reason: collision with root package name */
    private String f7572i;

    /* renamed from: j  reason: collision with root package name */
    private String f7573j;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<LocalDayWeatherForecast> {
        a() {
        }

        /* renamed from: a */
        public LocalDayWeatherForecast createFromParcel(Parcel parcel) {
            return new LocalDayWeatherForecast(parcel);
        }

        /* renamed from: b */
        public LocalDayWeatherForecast[] newArray(int i10) {
            return null;
        }
    }

    public LocalDayWeatherForecast() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7564a);
        parcel.writeString(this.f7565b);
        parcel.writeString(this.f7566c);
        parcel.writeString(this.f7567d);
        parcel.writeString(this.f7568e);
        parcel.writeString(this.f7569f);
        parcel.writeString(this.f7570g);
        parcel.writeString(this.f7571h);
        parcel.writeString(this.f7572i);
        parcel.writeString(this.f7573j);
    }

    public LocalDayWeatherForecast(Parcel parcel) {
        this.f7564a = parcel.readString();
        this.f7565b = parcel.readString();
        this.f7566c = parcel.readString();
        this.f7567d = parcel.readString();
        this.f7568e = parcel.readString();
        this.f7569f = parcel.readString();
        this.f7570g = parcel.readString();
        this.f7571h = parcel.readString();
        this.f7572i = parcel.readString();
        this.f7573j = parcel.readString();
    }
}
