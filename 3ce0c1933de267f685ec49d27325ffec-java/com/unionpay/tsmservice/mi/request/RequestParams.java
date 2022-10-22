package com.unionpay.tsmservice.mi.request;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class RequestParams implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.RequestParams.1
        @Override // android.os.Parcelable.Creator
        public final RequestParams createFromParcel(Parcel parcel) {
            return new RequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final RequestParams[] newArray(int i10) {
            return new RequestParams[i10];
        }
    };
    private String mReserve;

    public RequestParams() {
        this.mReserve = "";
    }

    public RequestParams(Parcel parcel) {
        this.mReserve = "";
        this.mReserve = parcel.readString();
    }

    public RequestParams(String str) {
        this.mReserve = "";
        this.mReserve = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReserve() {
        return this.mReserve;
    }

    public void setReserve(String str) {
        this.mReserve = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mReserve);
    }
}
