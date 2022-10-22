package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import java.util.List;
/* loaded from: classes2.dex */
public class SupportDeviceResponse$SupportDevice implements JsonBean, Parcelable {
    public static final Parcelable.Creator<SupportDeviceResponse$SupportDevice> CREATOR = new a();
    public List<SupportDeviceResponse$DescBean> desc;
    public String type;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SupportDeviceResponse$SupportDevice> {
        a() {
        }

        /* renamed from: a */
        public SupportDeviceResponse$SupportDevice createFromParcel(Parcel parcel) {
            return new SupportDeviceResponse$SupportDevice(parcel);
        }

        /* renamed from: b */
        public SupportDeviceResponse$SupportDevice[] newArray(int i10) {
            return new SupportDeviceResponse$SupportDevice[i10];
        }
    }

    public SupportDeviceResponse$SupportDevice() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.type);
        parcel.writeTypedList(this.desc);
    }

    protected SupportDeviceResponse$SupportDevice(Parcel parcel) {
        this.type = parcel.readString();
        this.desc = parcel.createTypedArrayList(SupportDeviceResponse$DescBean.CREATOR);
    }
}
