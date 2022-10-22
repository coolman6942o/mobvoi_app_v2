package com.mobvoi.wear.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CallsRecord implements Serializable, Parcelable {
    public static final Parcelable.Creator<CallsRecord> CREATOR = new Parcelable.Creator<CallsRecord>() { // from class: com.mobvoi.wear.contacts.CallsRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallsRecord[] newArray(int i10) {
            return new CallsRecord[0];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallsRecord createFromParcel(Parcel parcel) {
            return new CallsRecord(parcel);
        }
    };
    public int count;
    public long date;
    public String name;
    public String number;
    public String numberLabel;
    public int type;

    public CallsRecord() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CallsRecord callsRecord = (CallsRecord) obj;
        String str = this.number;
        if (str == null) {
            if (callsRecord.number != null) {
                return false;
            }
        } else if (!str.equals(callsRecord.number)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.number;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "[type:" + this.type + ", number:" + this.number + ", date:" + this.date + ", name:" + this.name + ", count:" + this.count + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.name);
        parcel.writeString(this.number);
        parcel.writeInt(this.type);
        parcel.writeLong(this.date);
    }

    public CallsRecord(Parcel parcel) {
        this.name = parcel.readString();
        this.number = parcel.readString();
        this.type = parcel.readInt();
        this.date = parcel.readLong();
    }

    public CallsRecord(int i10, String str, long j10, String str2, int i11) {
        this.type = i10;
        this.number = str;
        this.date = j10;
        this.name = str2;
        this.count = i11;
    }
}
