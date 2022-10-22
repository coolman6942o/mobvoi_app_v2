package com.mobvoi.wear.info;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new Parcelable.Creator<AppInfo>() { // from class: com.mobvoi.wear.info.AppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfo[] newArray(int i10) {
            return new AppInfo[i10];
        }
    };
    public String changeLog;
    public String iconUrl;
    public String packageName;
    public int remindEnable;
    public int versionCode;
    public String versionName;

    public AppInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppInfo[pkgName=" + this.packageName + ", verName=" + this.versionName + ", verCode=" + this.versionCode + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.packageName);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.changeLog);
        parcel.writeInt(this.remindEnable);
    }

    protected AppInfo(Parcel parcel) {
        this.packageName = parcel.readString();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.changeLog = parcel.readString();
        this.remindEnable = parcel.readInt();
    }
}
