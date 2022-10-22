package com.mobvoi.wear.msgproxy;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class MessageInfo implements Parcelable {
    public static final Parcelable.Creator<MessageInfo> CREATOR = new Parcelable.Creator<MessageInfo>() { // from class: com.mobvoi.wear.msgproxy.MessageInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageInfo createFromParcel(Parcel parcel) {
            return new MessageInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageInfo[] newArray(int i10) {
            return new MessageInfo[i10];
        }
    };
    private String mNodeId;
    private String mPath;
    private byte[] mPayload;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNodeId() {
        return this.mNodeId;
    }

    public String getPath() {
        return this.mPath;
    }

    public byte[] getPayload() {
        return this.mPayload;
    }

    public String toString() {
        return "MessageInfo[nodeId=" + this.mNodeId + ", path=" + this.mPath + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mNodeId);
        parcel.writeString(this.mPath);
        parcel.writeByteArray(this.mPayload);
    }

    public MessageInfo(String str, String str2, byte[] bArr) {
        this.mNodeId = str;
        this.mPath = str2;
        this.mPayload = bArr;
    }

    private MessageInfo(Parcel parcel) {
        this.mNodeId = parcel.readString();
        this.mPath = parcel.readString();
        this.mPayload = parcel.createByteArray();
    }
}
