package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;
/* loaded from: classes2.dex */
public class GetAccountBalanceRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetAccountBalanceRequestParams> CREATOR = new Parcelable.Creator<GetAccountBalanceRequestParams>() { // from class: com.unionpay.tsmservice.request.GetAccountBalanceRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetAccountBalanceRequestParams createFromParcel(Parcel parcel) {
            return new GetAccountBalanceRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetAccountBalanceRequestParams[] newArray(int i10) {
            return new GetAccountBalanceRequestParams[i10];
        }
    };
    private AppID mAppID;
    private String mEncryptPin;

    public GetAccountBalanceRequestParams() {
    }

    public GetAccountBalanceRequestParams(Parcel parcel) {
        super(parcel);
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mEncryptPin = parcel.readString();
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public String getEncryptPin() {
        return this.mEncryptPin;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public void setEncryptPin(String str) {
        this.mEncryptPin = str;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.mAppID, i10);
        parcel.writeString(this.mEncryptPin);
    }
}
