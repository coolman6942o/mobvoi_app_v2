package com.unionpay.tsmservice.mi.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class MessageDetail implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.data.MessageDetail.1
        @Override // android.os.Parcelable.Creator
        public final MessageDetail createFromParcel(Parcel parcel) {
            return new MessageDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MessageDetail[] newArray(int i10) {
            return new MessageDetail[i10];
        }
    };
    private Bundle mDetail;

    public MessageDetail() {
    }

    public MessageDetail(Parcel parcel) {
        this.mDetail = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getDetail() {
        return this.mDetail;
    }

    public void setDetail(Bundle bundle) {
        this.mDetail = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.mDetail);
    }
}
