package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import h8.c;
/* loaded from: classes2.dex */
public class SupportDeviceResponse$DeviceBean implements JsonBean, Parcelable {
    public static final Parcelable.Creator<SupportDeviceResponse$DeviceBean> CREATOR = new a();
    @c("device_name")
    public String deviceName;
    @c("device_url")
    public String deviceUrl;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SupportDeviceResponse$DeviceBean> {
        a() {
        }

        /* renamed from: a */
        public SupportDeviceResponse$DeviceBean createFromParcel(Parcel parcel) {
            return new SupportDeviceResponse$DeviceBean(parcel);
        }

        /* renamed from: b */
        public SupportDeviceResponse$DeviceBean[] newArray(int i10) {
            return new SupportDeviceResponse$DeviceBean[i10];
        }
    }

    public SupportDeviceResponse$DeviceBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.deviceName);
        parcel.writeString(this.deviceUrl);
    }

    protected SupportDeviceResponse$DeviceBean(Parcel parcel) {
        this.deviceName = parcel.readString();
        this.deviceUrl = parcel.readString();
    }
}
