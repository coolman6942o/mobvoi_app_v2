package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class CloudItemDetail extends CloudItem {
    public static final Parcelable.Creator<CloudItemDetail> CREATOR = new a();

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<CloudItemDetail> {
        a() {
        }

        /* renamed from: a */
        public CloudItemDetail createFromParcel(Parcel parcel) {
            return new CloudItemDetail(parcel);
        }

        /* renamed from: b */
        public CloudItemDetail[] newArray(int i10) {
            return new CloudItemDetail[i10];
        }
    }

    protected CloudItemDetail(Parcel parcel) {
        super(parcel);
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
    }
}
