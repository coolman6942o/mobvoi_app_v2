package com.unionpay.tsmservice.mi.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.mi.data.TransactionDetail;
/* loaded from: classes2.dex */
public class TransactionDetailsResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.TransactionDetailsResult.1
        @Override // android.os.Parcelable.Creator
        public final TransactionDetailsResult createFromParcel(Parcel parcel) {
            return new TransactionDetailsResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final TransactionDetailsResult[] newArray(int i10) {
            return new TransactionDetailsResult[i10];
        }
    };
    private String mLastUpdatedTag;
    private TransactionDetail[] mTransactionDetails;

    public TransactionDetailsResult() {
        this.mLastUpdatedTag = "";
    }

    public TransactionDetailsResult(Parcel parcel) {
        this.mLastUpdatedTag = "";
        this.mTransactionDetails = (TransactionDetail[]) parcel.createTypedArray(TransactionDetail.CREATOR);
        this.mLastUpdatedTag = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLastUpdatedTag() {
        return this.mLastUpdatedTag;
    }

    public TransactionDetail[] getTransactionDetails() {
        return this.mTransactionDetails;
    }

    public void setLastUpdatedTag(String str) {
        this.mLastUpdatedTag = str;
    }

    public void setTransactionDetails(TransactionDetail[] transactionDetailArr) {
        this.mTransactionDetails = transactionDetailArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedArray(this.mTransactionDetails, i10);
        parcel.writeString(this.mLastUpdatedTag);
    }
}
