package com.mobvoi.wear.contacts;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.util.ImageUtils;
/* loaded from: classes2.dex */
public class ContactInfo implements Parcelable {
    public static final Parcelable.Creator<ContactInfo> CREATOR = new Parcelable.Creator<ContactInfo>() { // from class: com.mobvoi.wear.contacts.ContactInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactInfo createFromParcel(Parcel parcel) {
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.command = parcel.readString();
            contactInfo.number = parcel.readString();
            contactInfo.name = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt != 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                contactInfo.bitmap = ImageUtils.bytes2Bitmap(bArr);
            } else {
                contactInfo.bitmap = null;
            }
            contactInfo.timestamp = parcel.readLong();
            return contactInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactInfo[] newArray(int i10) {
            return new ContactInfo[i10];
        }
    };
    private Bitmap bitmap;
    private String command;
    private String name;
    private String number;
    private long timestamp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getCommand() {
        return this.command;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.command);
        parcel.writeString(this.number);
        parcel.writeString(this.name);
        byte[] bitmap2Bytes = ImageUtils.bitmap2Bytes(this.bitmap);
        int length = bitmap2Bytes != null ? bitmap2Bytes.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(bitmap2Bytes);
        }
        parcel.writeLong(this.timestamp);
    }
}
