package com.unionpay.tsmservice;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class AppID implements Parcelable {
    public static final Parcelable.Creator<AppID> CREATOR = new Parcelable.Creator<AppID>() { // from class: com.unionpay.tsmservice.AppID.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppID createFromParcel(Parcel parcel) {
            return new AppID(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppID[] newArray(int i10) {
            return new AppID[i10];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    String f24474a;

    /* renamed from: b  reason: collision with root package name */
    String f24475b;

    public AppID(Parcel parcel) {
        this.f24474a = "";
        this.f24475b = "";
        this.f24474a = parcel.readString();
        this.f24475b = parcel.readString();
    }

    public AppID(String str, String str2) {
        this.f24474a = "";
        this.f24475b = "";
        this.f24474a = str;
        this.f24475b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppAid() {
        return this.f24474a;
    }

    public String getAppVersion() {
        return this.f24475b;
    }

    public void setAppAid(String str) {
        this.f24474a = str;
    }

    public void setAppVersion(String str) {
        this.f24475b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f24474a);
        parcel.writeString(this.f24475b);
    }
}
