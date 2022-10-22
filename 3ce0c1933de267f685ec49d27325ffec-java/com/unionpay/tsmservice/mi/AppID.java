package com.unionpay.tsmservice.mi;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class AppID implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.AppID.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppID(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
            return new AppID[i10];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    String f24526a;

    /* renamed from: b  reason: collision with root package name */
    String f24527b;

    public AppID(Parcel parcel) {
        this.f24526a = "";
        this.f24527b = "";
        this.f24526a = parcel.readString();
        this.f24527b = parcel.readString();
    }

    public AppID(String str, String str2) {
        this.f24526a = "";
        this.f24527b = "";
        this.f24526a = str;
        this.f24527b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppAid() {
        return this.f24526a;
    }

    public String getAppVersion() {
        return this.f24527b;
    }

    public void setAppAid(String str) {
        this.f24526a = str;
    }

    public void setAppVersion(String str) {
        this.f24527b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f24526a);
        parcel.writeString(this.f24527b);
    }
}
