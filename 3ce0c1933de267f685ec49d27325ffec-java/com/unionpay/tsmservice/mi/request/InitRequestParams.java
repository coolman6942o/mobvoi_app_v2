package com.unionpay.tsmservice.mi.request;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class InitRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.InitRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final InitRequestParams createFromParcel(Parcel parcel) {
            return new InitRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final InitRequestParams[] newArray(int i10) {
            return new InitRequestParams[i10];
        }
    };
    private String mSignature;

    public InitRequestParams() {
        this.mSignature = "";
    }

    public InitRequestParams(Parcel parcel) {
        super(parcel);
        this.mSignature = "";
        this.mSignature = parcel.readString();
    }

    public String getSignature() {
        return this.mSignature;
    }

    public void setSignature(String str) {
        this.mSignature = str;
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.mSignature);
    }
}
