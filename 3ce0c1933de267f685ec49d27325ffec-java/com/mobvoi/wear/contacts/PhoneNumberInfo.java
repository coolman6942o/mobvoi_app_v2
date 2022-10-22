package com.mobvoi.wear.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class PhoneNumberInfo implements Parcelable {
    public static final Parcelable.Creator<PhoneNumberInfo> CREATOR = new Parcelable.Creator<PhoneNumberInfo>() { // from class: com.mobvoi.wear.contacts.PhoneNumberInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneNumberInfo createFromParcel(Parcel parcel) {
            return new PhoneNumberInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneNumberInfo[] newArray(int i10) {
            return new PhoneNumberInfo[i10];
        }
    };
    public String formattedNumber;
    public String number;
    public int type;

    public PhoneNumberInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneNumberInfo)) {
            return false;
        }
        PhoneNumberInfo phoneNumberInfo = (PhoneNumberInfo) obj;
        return TextUtils.equals(this.number, phoneNumberInfo.number) && this.type == phoneNumberInfo.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.number);
        parcel.writeString(this.formattedNumber);
        parcel.writeInt(this.type);
    }

    protected PhoneNumberInfo(Parcel parcel) {
        this.number = parcel.readString();
        this.formattedNumber = parcel.readString();
        this.type = parcel.readInt();
    }
}
