package com.mobvoi.mcuwatch.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
/* loaded from: classes2.dex */
public class AlarmBean implements JsonBean, Parcelable {
    public static final Parcelable.Creator<AlarmBean> CREATOR = new a();
    public long alarmTime;
    public String description;
    public int hour;
    public boolean isOpen;
    public int minute;
    public int shakePeriod;
    public boolean[] weekChecked;
    public int whichClock;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<AlarmBean> {
        a() {
        }

        /* renamed from: a */
        public AlarmBean createFromParcel(Parcel parcel) {
            return new AlarmBean(parcel);
        }

        /* renamed from: b */
        public AlarmBean[] newArray(int i10) {
            return new AlarmBean[i10];
        }
    }

    public AlarmBean() {
        this.whichClock = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.whichClock == ((AlarmBean) obj).whichClock;
    }

    public int hashCode() {
        return this.whichClock;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.whichClock);
        parcel.writeBooleanArray(this.weekChecked);
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeByte(this.isOpen ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.shakePeriod);
        parcel.writeLong(this.alarmTime);
        parcel.writeString(this.description);
    }

    protected AlarmBean(Parcel parcel) {
        this.whichClock = -1;
        this.whichClock = parcel.readInt();
        this.weekChecked = parcel.createBooleanArray();
        this.hour = parcel.readInt();
        this.minute = parcel.readInt();
        this.isOpen = parcel.readByte() != 0;
        this.shakePeriod = parcel.readInt();
        this.alarmTime = parcel.readLong();
        this.description = parcel.readString();
    }
}
