package com.mobvoi.wear.contacts;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.util.ImageUtils;
/* loaded from: classes2.dex */
public class NumberInfo implements Parcelable {
    public static final Parcelable.Creator<NumberInfo> CREATOR = new Parcelable.Creator<NumberInfo>() { // from class: com.mobvoi.wear.contacts.NumberInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NumberInfo createFromParcel(Parcel parcel) {
            NumberInfo numberInfo = new NumberInfo();
            numberInfo.number = parcel.readString();
            numberInfo.content = parcel.readString();
            numberInfo.location = parcel.readString();
            numberInfo.markCount = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                numberInfo.bitmap = ImageUtils.bytes2Bitmap(bArr);
            } else {
                numberInfo.bitmap = null;
            }
            return numberInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NumberInfo[] newArray(int i10) {
            return new NumberInfo[i10];
        }
    };
    public Bitmap bitmap;
    public String content;
    public String location;
    public int markCount;
    public String number;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.number);
        parcel.writeString(this.content);
        parcel.writeString(this.location);
        parcel.writeInt(this.markCount);
        byte[] bitmap2Bytes = ImageUtils.bitmap2Bytes(this.bitmap);
        int length = bitmap2Bytes != null ? bitmap2Bytes.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(bitmap2Bytes);
        }
    }
}
