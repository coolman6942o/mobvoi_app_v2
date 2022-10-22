package com.huawei.hms.scankit.aiscan.common;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public enum BarcodeFormat implements Parcelable {
    AZTEC,
    CODABAR,
    CODE_39,
    CODE_93,
    CODE_128,
    DATA_MATRIX,
    EAN_8,
    EAN_13,
    ITF,
    PDF_417,
    QR_CODE,
    UPC_A,
    UPC_E,
    UPC_EAN_EXTENSION,
    NONE;
    
    public static final Parcelable.Creator<BarcodeFormat> CREATOR = new Parcelable.Creator<BarcodeFormat>() { // from class: com.huawei.hms.scankit.aiscan.common.b
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BarcodeFormat createFromParcel(Parcel parcel) {
            return BarcodeFormat.values()[parcel.readInt()];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BarcodeFormat[] newArray(int i10) {
            return new BarcodeFormat[i10];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(ordinal());
    }
}
