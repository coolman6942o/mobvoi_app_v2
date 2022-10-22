package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7389a;

    /* renamed from: b  reason: collision with root package name */
    private String f7390b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Photo> {
        a() {
        }

        /* renamed from: a */
        public Photo createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }

        /* renamed from: b */
        public Photo[] newArray(int i10) {
            return null;
        }
    }

    public Photo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7389a);
        parcel.writeString(this.f7390b);
    }

    public Photo(Parcel parcel) {
        this.f7389a = parcel.readString();
        this.f7390b = parcel.readString();
    }
}
