package com.unionpay.tsmservice.mi.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class AcquireSEAppListRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.AcquireSEAppListRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final AcquireSEAppListRequestParams createFromParcel(Parcel parcel) {
            return new AcquireSEAppListRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final AcquireSEAppListRequestParams[] newArray(int i10) {
            return new AcquireSEAppListRequestParams[i10];
        }
    };
    private Bundle mParams;

    public AcquireSEAppListRequestParams() {
    }

    public AcquireSEAppListRequestParams(Parcel parcel) {
        super(parcel);
        this.mParams = parcel.readBundle();
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
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
