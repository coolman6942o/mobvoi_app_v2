package com.mobvoi.assistant.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
/* loaded from: classes2.dex */
public class AlarmBean implements JsonBean, Parcelable {
    public static final Parcelable.Creator<AlarmBean> CREATOR = new a();
    public long alarmTime;
    public int hour;

    /* renamed from: id  reason: collision with root package name */
    public int f15720id;
    public int isActive;
    public int minutes;
    public String repeatDays;
    public int syncOpt;
    public String tag;
    public long updatedAt;
    public String uuid;

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

    protected AlarmBean(Parcel parcel) {
        this.f15720id = parcel.readInt();
        this.hour = parcel.readInt();
        this.minutes = parcel.readInt();
        this.uuid = parcel.readString();
        this.tag = parcel.readString();
        this.alarmTime = parcel.readLong();
        this.isActive = parcel.readInt();
        this.repeatDays = parcel.readString();
        this.updatedAt = parcel.readLong();
        this.syncOpt = parcel.readInt();
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
        AlarmBean alarmBean = (AlarmBean) obj;
        String str = this.uuid;
        return str != null && str.equals(alarmBean.uuid);
    }

    public int hashCode() {
        String str = this.uuid;
        return str != null ? str.hashCode() : this.f15720id;
    }

    public String toString() {
        return "Alarm{tag=" + this.tag + ", id=" + this.f15720id + ", uuid=" + this.uuid + ", active=" + this.isActive + ", hour=" + this.hour + ", minute=" + this.minutes + ", repeatDays=" + this.repeatDays + ", alarmTime=" + this.alarmTime + ", updatedAt=" + this.updatedAt + ", syncOpt=" + this.syncOpt + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f15720id);
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minutes);
        parcel.writeString(this.uuid);
        parcel.writeString(this.tag);
        parcel.writeLong(this.alarmTime);
        parcel.writeInt(this.isActive);
        parcel.writeString(this.repeatDays);
        parcel.writeLong(this.updatedAt);
        parcel.writeInt(this.syncOpt);
    }
}
