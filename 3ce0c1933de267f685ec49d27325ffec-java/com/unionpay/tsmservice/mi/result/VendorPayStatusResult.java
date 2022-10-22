package com.unionpay.tsmservice.mi.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VendorPayStatusResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.VendorPayStatusResult.1
        @Override // android.os.Parcelable.Creator
        public final VendorPayStatusResult createFromParcel(Parcel parcel) {
            return new VendorPayStatusResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final VendorPayStatusResult[] newArray(int i10) {
            return new VendorPayStatusResult[i10];
        }
    };
    private Bundle mStatus;

    public VendorPayStatusResult() {
    }

    public VendorPayStatusResult(Parcel parcel) {
        this.mStatus = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getVendorPayStatusResult() {
        return this.mStatus;
    }

    public void setVendorPayStatusResult(Bundle bundle) {
        this.mStatus = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.mStatus);
    }
}
