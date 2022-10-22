package com.mobvoi.assistant.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
/* loaded from: classes2.dex */
public class AgendaBean implements JsonBean, Parcelable, Cloneable {
    public static final Parcelable.Creator<AgendaBean> CREATOR = new a();
    public int checked;
    public String derivedUuid;
    public int hour;

    /* renamed from: id  reason: collision with root package name */
    public int f15719id;
    public int minutes;
    public String note;
    public long reminderTime;
    public String repeatUnit;
    public int repeatVal;
    public int syncOpt;
    public long updatedAt;
    public String uuid;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<AgendaBean> {
        a() {
        }

        /* renamed from: a */
        public AgendaBean createFromParcel(Parcel parcel) {
            return new AgendaBean(parcel);
        }

        /* renamed from: b */
        public AgendaBean[] newArray(int i10) {
            return new AgendaBean[i10];
        }
    }

    protected AgendaBean(Parcel parcel) {
        this.f15719id = parcel.readInt();
        this.hour = parcel.readInt();
        this.minutes = parcel.readInt();
        this.uuid = parcel.readString();
        this.note = parcel.readString();
        this.reminderTime = parcel.readLong();
        this.checked = parcel.readInt();
        this.repeatUnit = parcel.readString();
        this.updatedAt = parcel.readLong();
        this.syncOpt = parcel.readInt();
        this.repeatVal = parcel.readInt();
        this.derivedUuid = parcel.readString();
    }

    /* renamed from: a */
    public AgendaBean clone() {
        try {
            return (AgendaBean) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
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
        AgendaBean agendaBean = (AgendaBean) obj;
        String str = this.uuid;
        return str != null && str.equals(agendaBean.uuid);
    }

    public int hashCode() {
        String str = this.uuid;
        return str != null ? str.hashCode() : this.f15719id;
    }

    public String toString() {
        return "Agenda{note=" + this.note + ", id=" + this.f15719id + ", uuid=" + this.uuid + ", checked=" + this.checked + ", hour=" + this.hour + ", minute=" + this.minutes + ", repeatUnit=" + this.repeatUnit + ", repeatVal=" + this.repeatVal + ", reminderTime=" + this.reminderTime + ", updatedAt=" + this.updatedAt + ", syncOpt=" + this.syncOpt + ", derivedUuid=" + this.derivedUuid + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f15719id);
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minutes);
        parcel.writeString(this.uuid);
        parcel.writeString(this.note);
        parcel.writeLong(this.reminderTime);
        parcel.writeInt(this.checked);
        parcel.writeString(this.repeatUnit);
        parcel.writeLong(this.updatedAt);
        parcel.writeInt(this.syncOpt);
        parcel.writeInt(this.repeatVal);
        parcel.writeString(this.derivedUuid);
    }
}
