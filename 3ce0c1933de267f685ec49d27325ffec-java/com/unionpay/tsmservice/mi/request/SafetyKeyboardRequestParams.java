package com.unionpay.tsmservice.mi.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class SafetyKeyboardRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.SafetyKeyboardRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final SafetyKeyboardRequestParams createFromParcel(Parcel parcel) {
            return new SafetyKeyboardRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SafetyKeyboardRequestParams[] newArray(int i10) {
            return new SafetyKeyboardRequestParams[i10];
        }
    };
    private Bundle mParams;

    public SafetyKeyboardRequestParams() {
    }

    public SafetyKeyboardRequestParams(Parcel parcel) {
        super(parcel);
        this.mParams = parcel.readBundle();
    }

    public Bundle getParams() {
        return this.mParams;
    }

    public void setParams(Bundle bundle) {
        this.mParams = bundle;
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeBundle(this.mParams);
    }
}
