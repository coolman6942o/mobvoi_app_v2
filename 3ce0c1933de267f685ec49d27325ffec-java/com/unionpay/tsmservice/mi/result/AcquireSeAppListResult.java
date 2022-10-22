package com.unionpay.tsmservice.mi.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.mi.data.SeAppDetail;
/* loaded from: classes2.dex */
public class AcquireSeAppListResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.AcquireSeAppListResult.1
        @Override // android.os.Parcelable.Creator
        public final AcquireSeAppListResult createFromParcel(Parcel parcel) {
            return new AcquireSeAppListResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final AcquireSeAppListResult[] newArray(int i10) {
            return new AcquireSeAppListResult[i10];
        }
    };
    private String mSeAliasType;
    private SeAppDetail[] mSeAppDetails;

    public AcquireSeAppListResult() {
        this.mSeAliasType = "";
    }

    public AcquireSeAppListResult(Parcel parcel) {
        this.mSeAliasType = "";
        this.mSeAppDetails = (SeAppDetail[]) parcel.createTypedArray(SeAppDetail.CREATOR);
        this.mSeAliasType = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSeAliasType() {
        return this.mSeAliasType;
    }

    public SeAppDetail[] getSeAppDetails() {
        return this.mSeAppDetails;
    }

    public void setSeAliasType(String str) {
        this.mSeAliasType = str;
    }

    public void setSeAppDetails(SeAppDetail[] seAppDetailArr) {
        this.mSeAppDetails = seAppDetailArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedArray(this.mSeAppDetails, i10);
        parcel.writeString(this.mSeAliasType);
    }
}
