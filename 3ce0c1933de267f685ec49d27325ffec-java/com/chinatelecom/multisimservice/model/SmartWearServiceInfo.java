package com.chinatelecom.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class SmartWearServiceInfo implements Parcelable {
    public static final Parcelable.Creator<SmartWearServiceInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f8226a;

    /* renamed from: b  reason: collision with root package name */
    private String f8227b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<SmartWearServiceInfo> {
        a() {
        }

        /* renamed from: a */
        public SmartWearServiceInfo createFromParcel(Parcel parcel) {
            return new SmartWearServiceInfo(parcel);
        }

        /* renamed from: b */
        public SmartWearServiceInfo[] newArray(int i10) {
            return new SmartWearServiceInfo[i10];
        }
    }

    public SmartWearServiceInfo() {
    }

    public void a(String str) {
        this.f8226a = str;
    }

    public void b(String str) {
        this.f8227b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8226a);
        parcel.writeString(this.f8227b);
    }

    protected SmartWearServiceInfo(Parcel parcel) {
        this.f8226a = parcel.readString();
        this.f8227b = parcel.readString();
    }
}
