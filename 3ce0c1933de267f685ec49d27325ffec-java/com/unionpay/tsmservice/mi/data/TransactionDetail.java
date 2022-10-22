package com.unionpay.tsmservice.mi.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TransactionDetail implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.data.TransactionDetail.1
        @Override // android.os.Parcelable.Creator
        public final TransactionDetail createFromParcel(Parcel parcel) {
            return new TransactionDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final TransactionDetail[] newArray(int i10) {
            return new TransactionDetail[i10];
        }
    };
    private Bundle mDetail;
    private MessageDetail[] mMessageDetails;

    public TransactionDetail() {
    }

    public TransactionDetail(Parcel parcel) {
        this.mDetail = parcel.readBundle();
        this.mMessageDetails = (MessageDetail[]) parcel.createTypedArray(MessageDetail.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getDetail() {
        return this.mDetail;
    }

    public MessageDetail[] getMessageDetails() {
        return this.mMessageDetails;
    }

    public void setDetail(Bundle bundle) {
        this.mDetail = bundle;
    }

    public void setMessageDetails(MessageDetail[] messageDetailArr) {
        this.mMessageDetails = messageDetailArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.mDetail);
        parcel.writeTypedArray(this.mMessageDetails, i10);
    }
}
