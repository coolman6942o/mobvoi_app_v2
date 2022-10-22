package com.mobvoi.wear.contacts;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class MessageInfo implements Parcelable {
    public static final Parcelable.Creator<MessageInfo> CREATOR = new Parcelable.Creator<MessageInfo>() { // from class: com.mobvoi.wear.contacts.MessageInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageInfo createFromParcel(Parcel parcel) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.commond = parcel.readString();
            messageInfo.message = parcel.readString();
            messageInfo.number = parcel.readString();
            return messageInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageInfo[] newArray(int i10) {
            return new MessageInfo[i10];
        }
    };
    private String commond;
    private String message;
    private String number;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCommond() {
        return this.commond;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNumber() {
        return this.number;
    }

    public void setCommond(String str) {
        this.commond = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.commond);
        parcel.writeString(this.message);
        parcel.writeString(this.number);
    }
}
