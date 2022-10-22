package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7574a;

    /* renamed from: b  reason: collision with root package name */
    private String f7575b;

    /* renamed from: c  reason: collision with root package name */
    private String f7576c;

    /* renamed from: d  reason: collision with root package name */
    private String f7577d;

    /* renamed from: e  reason: collision with root package name */
    private List<LocalDayWeatherForecast> f7578e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<LocalWeatherForecast> {
        a() {
        }

        /* renamed from: a */
        public LocalWeatherForecast createFromParcel(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        /* renamed from: b */
        public LocalWeatherForecast[] newArray(int i10) {
            return null;
        }
    }

    public LocalWeatherForecast() {
        this.f7578e = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7574a);
        parcel.writeString(this.f7575b);
        parcel.writeString(this.f7576c);
        parcel.writeString(this.f7577d);
        parcel.writeList(this.f7578e);
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.f7578e = new ArrayList();
        this.f7574a = parcel.readString();
        this.f7575b = parcel.readString();
        this.f7576c = parcel.readString();
        this.f7577d = parcel.readString();
        this.f7578e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }
}
