package com.unionpay.tsmservice.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class UniteRequestParams extends RequestParams {
    public static final Parcelable.Creator<UniteRequestParams> CREATOR = new Parcelable.Creator<UniteRequestParams>() { // from class: com.unionpay.tsmservice.request.UniteRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UniteRequestParams createFromParcel(Parcel parcel) {
            return new UniteRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UniteRequestParams[] newArray(int i10) {
            return new UniteRequestParams[i10];
        }
    };
    private Bundle mParams;

    public UniteRequestParams() {
    }

    public UniteRequestParams(Parcel parcel) {
        super(parcel);
        this.mParams = parcel.readBundle();
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getParams() {
        return this.mParams;
    }

    public void setParams(Bundle bundle) {
        this.mParams = bundle;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeBundle(this.mParams);
    }
}
