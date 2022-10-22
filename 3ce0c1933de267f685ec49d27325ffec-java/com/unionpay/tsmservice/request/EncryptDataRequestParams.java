package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EncryptDataRequestParams extends RequestParams {
    public static final Parcelable.Creator<EncryptDataRequestParams> CREATOR = new Parcelable.Creator<EncryptDataRequestParams>() { // from class: com.unionpay.tsmservice.request.EncryptDataRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EncryptDataRequestParams createFromParcel(Parcel parcel) {
            return new EncryptDataRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EncryptDataRequestParams[] newArray(int i10) {
            return new EncryptDataRequestParams[i10];
        }
    };
    private List<String> mData;

    public EncryptDataRequestParams() {
    }

    public EncryptDataRequestParams(Parcel parcel) {
        super(parcel);
        ArrayList arrayList = new ArrayList();
        this.mData = arrayList;
        parcel.readList(arrayList, ClassLoader.getSystemClassLoader());
    }

    public List<String> getData() {
        return this.mData;
    }

    public void setData(List<String> list) {
        this.mData = list;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeList(this.mData);
    }
}
