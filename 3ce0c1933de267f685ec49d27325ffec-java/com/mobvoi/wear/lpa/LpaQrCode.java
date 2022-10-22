package com.mobvoi.wear.lpa;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class LpaQrCode implements Parcelable {
    public static final Parcelable.Creator<LpaQrCode> CREATOR = new Parcelable.Creator<LpaQrCode>() { // from class: com.mobvoi.wear.lpa.LpaQrCode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LpaQrCode createFromParcel(Parcel parcel) {
            return new LpaQrCode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LpaQrCode[] newArray(int i10) {
            return new LpaQrCode[i10];
        }
    };
    public String address;
    public String confirm;

    public LpaQrCode() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.address);
        parcel.writeString(this.confirm);
    }

    public LpaQrCode(String str, String str2) {
        this.address = str;
        this.confirm = str2;
    }

    protected LpaQrCode(Parcel parcel) {
        this.address = parcel.readString();
        this.confirm = parcel.readString();
    }
}
