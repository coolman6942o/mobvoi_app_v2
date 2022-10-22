package com.unionpay.tsmservice.mi.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class SeAppDetail implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.data.SeAppDetail.1
        @Override // android.os.Parcelable.Creator
        public final SeAppDetail createFromParcel(Parcel parcel) {
            return new SeAppDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SeAppDetail[] newArray(int i10) {
            return new SeAppDetail[i10];
        }
    };
    private Bundle mDetail;

    public SeAppDetail() {
    }

    public SeAppDetail(Parcel parcel) {
        this.mDetail = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getDetail() {
        return this.mDetail;
    }

    public void setDetail(Bundle bundle) {
        this.mDetail = bundle;
    }

    public String toString() {
        if (this.mDetail != null) {
            String str = "AppDetail [mDetail=Bundle(";
            for (String str2 : this.mDetail.keySet()) {
                str = str + str2 + ":" + this.mDetail.get(str2) + ";";
            }
            return str + ")]";
        }
        return "AppDetail [mDetail=null]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.mDetail);
    }
}
