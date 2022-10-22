package com.laser.tsm.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Parcelable.Creator<DeviceInfo>() { // from class: com.laser.tsm.sdk.bean.DeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int i10) {
            return new DeviceInfo[i10];
        }
    };
    private String deviceId;
    private String deviceMac;
    private String deviceModel;
    private String deviceName;

    public DeviceInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceMac() {
        return this.deviceMac;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    void readFromParcel(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.deviceName = parcel.readString();
        this.deviceMac = parcel.readString();
        this.deviceModel = parcel.readString();
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.deviceId);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.deviceMac);
        parcel.writeString(this.deviceModel);
    }

    public DeviceInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public DeviceInfo(String str, String str2, String str3, String str4) {
        this.deviceId = str;
        this.deviceName = str2;
        this.deviceMac = str3;
        this.deviceModel = str4;
    }
}
