package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import java.util.List;
/* loaded from: classes2.dex */
public class SupportDeviceResponse$DescBean implements JsonBean, Parcelable {
    public static final Parcelable.Creator<SupportDeviceResponse$DescBean> CREATOR = new a();
    public String brand;
    public List<SupportDeviceResponse$DeviceBean> device;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SupportDeviceResponse$DescBean> {
        a() {
        }

        /* renamed from: a */
        public SupportDeviceResponse$DescBean createFromParcel(Parcel parcel) {
            return new SupportDeviceResponse$DescBean(parcel);
        }

        /* renamed from: b */
        public SupportDeviceResponse$DescBean[] newArray(int i10) {
            return new SupportDeviceResponse$DescBean[i10];
        }
    }

    public SupportDeviceResponse$DescBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.brand);
        parcel.writeTypedList(this.device);
    }

    protected SupportDeviceResponse$DescBean(Parcel parcel) {
        this.brand = parcel.readString();
        this.device = parcel.createTypedArrayList(SupportDeviceResponse$DeviceBean.CREATOR);
    }
}
