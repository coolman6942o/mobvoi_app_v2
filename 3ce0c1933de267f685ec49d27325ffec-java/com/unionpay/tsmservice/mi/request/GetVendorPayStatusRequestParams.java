package com.unionpay.tsmservice.mi.request;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class GetVendorPayStatusRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.GetVendorPayStatusRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final GetVendorPayStatusRequestParams createFromParcel(Parcel parcel) {
            return new GetVendorPayStatusRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GetVendorPayStatusRequestParams[] newArray(int i10) {
            return new GetVendorPayStatusRequestParams[i10];
        }
    };

    public GetVendorPayStatusRequestParams() {
    }

    public GetVendorPayStatusRequestParams(Parcel parcel) {
        super(parcel);
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
    }
}
