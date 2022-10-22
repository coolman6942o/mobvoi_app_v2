package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7274a;

    /* renamed from: b  reason: collision with root package name */
    private String f7275b;

    /* renamed from: c  reason: collision with root package name */
    private String f7276c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<CloudImage> {
        a() {
        }

        /* renamed from: a */
        public CloudImage createFromParcel(Parcel parcel) {
            return new CloudImage(parcel);
        }

        /* renamed from: b */
        public CloudImage[] newArray(int i10) {
            return new CloudImage[i10];
        }
    }

    public CloudImage(Parcel parcel) {
        this.f7274a = parcel.readString();
        this.f7275b = parcel.readString();
        this.f7276c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7274a);
        parcel.writeString(this.f7275b);
        parcel.writeString(this.f7276c);
    }
}
