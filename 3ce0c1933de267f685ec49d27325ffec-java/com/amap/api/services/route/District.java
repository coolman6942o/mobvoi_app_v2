package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7426a;

    /* renamed from: b  reason: collision with root package name */
    private String f7427b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<District> {
        a() {
        }

        /* renamed from: a */
        public District createFromParcel(Parcel parcel) {
            return new District(parcel);
        }

        /* renamed from: b */
        public District[] newArray(int i10) {
            return null;
        }
    }

    public District(Parcel parcel) {
        this.f7426a = parcel.readString();
        this.f7427b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7426a);
        parcel.writeString(this.f7427b);
    }

    public District() {
    }
}
