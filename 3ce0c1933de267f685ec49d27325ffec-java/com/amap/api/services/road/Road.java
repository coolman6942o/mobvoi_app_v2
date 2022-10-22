package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7406a;

    /* renamed from: b  reason: collision with root package name */
    private String f7407b;

    /* renamed from: c  reason: collision with root package name */
    private String f7408c;

    /* renamed from: d  reason: collision with root package name */
    private float f7409d;

    /* renamed from: e  reason: collision with root package name */
    private String f7410e;

    /* renamed from: f  reason: collision with root package name */
    private LatLonPoint f7411f;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Road> {
        a() {
        }

        /* renamed from: a */
        public Road createFromParcel(Parcel parcel) {
            return new Road(parcel);
        }

        /* renamed from: b */
        public Road[] newArray(int i10) {
            return null;
        }
    }

    public Road() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7406a);
        parcel.writeString(this.f7407b);
        parcel.writeString(this.f7408c);
        parcel.writeFloat(this.f7409d);
        parcel.writeString(this.f7410e);
        parcel.writeValue(this.f7411f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Road(Parcel parcel) {
        this.f7406a = parcel.readString();
        this.f7407b = parcel.readString();
        this.f7408c = parcel.readString();
        this.f7409d = parcel.readFloat();
        this.f7410e = parcel.readString();
        this.f7411f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
