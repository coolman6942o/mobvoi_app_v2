package com.unionpay.tsmservice.mi.request;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class GetEncryptDataRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.GetEncryptDataRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final GetEncryptDataRequestParams createFromParcel(Parcel parcel) {
            return new GetEncryptDataRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GetEncryptDataRequestParams[] newArray(int i10) {
            return new GetEncryptDataRequestParams[i10];
        }
    };
    private String mPan;
    private int mType;

    public GetEncryptDataRequestParams() {
    }

    public GetEncryptDataRequestParams(Parcel parcel) {
        super(parcel);
        this.mType = parcel.readInt();
        this.mPan = parcel.readString();
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPan() {
        return this.mPan;
    }

    public int getType() {
        return this.mType;
    }

    public void setPan(String str) {
        this.mPan = str;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mPan);
    }
}
