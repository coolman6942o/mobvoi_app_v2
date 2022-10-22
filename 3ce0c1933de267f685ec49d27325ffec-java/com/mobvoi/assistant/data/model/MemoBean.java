package com.mobvoi.assistant.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
/* loaded from: classes2.dex */
public class MemoBean implements JsonBean, Parcelable, Cloneable {
    public static final Parcelable.Creator<MemoBean> CREATOR = new a();

    /* renamed from: id  reason: collision with root package name */
    public int f15722id;
    public String note;
    public int syncOpt;
    public long updatedAt;
    public String uuid;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<MemoBean> {
        a() {
        }

        /* renamed from: a */
        public MemoBean createFromParcel(Parcel parcel) {
            return new MemoBean(parcel);
        }

        /* renamed from: b */
        public MemoBean[] newArray(int i10) {
            return new MemoBean[i10];
        }
    }

    protected MemoBean(Parcel parcel) {
        this.f15722id = parcel.readInt();
        this.uuid = parcel.readString();
        this.note = parcel.readString();
        this.syncOpt = parcel.readInt();
        this.updatedAt = parcel.readLong();
    }

    /* renamed from: a */
    public MemoBean clone() {
        try {
            return (MemoBean) super.clone();
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
        MemoBean memoBean = (MemoBean) obj;
        String str = this.uuid;
        return str != null && str.equals(memoBean.uuid);
    }

    public int hashCode() {
        String str = this.uuid;
        return str != null ? str.hashCode() : this.f15722id;
    }

    public String toString() {
        return "MemoBean{note=" + this.note + ", id=" + this.f15722id + ", uuid=" + this.uuid + ", updatedAt=" + this.updatedAt + ", syncOpt=" + this.syncOpt + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f15722id);
        parcel.writeString(this.uuid);
        parcel.writeString(this.note);
        parcel.writeInt(this.syncOpt);
        parcel.writeLong(this.updatedAt);
    }
}
