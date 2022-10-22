package com.unionpay.tsmservice.mi.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PinRequestResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.PinRequestResult.1
        @Override // android.os.Parcelable.Creator
        public final PinRequestResult createFromParcel(Parcel parcel) {
            return new PinRequestResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PinRequestResult[] newArray(int i10) {
            return new PinRequestResult[i10];
        }
    };
    private Bundle mResultData;

    public PinRequestResult() {
    }

    public PinRequestResult(Parcel parcel) {
        this.mResultData = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getResultData() {
        return this.mResultData;
    }

    public void setResultData(Bundle bundle) {
        this.mResultData = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.mResultData);
    }
}
