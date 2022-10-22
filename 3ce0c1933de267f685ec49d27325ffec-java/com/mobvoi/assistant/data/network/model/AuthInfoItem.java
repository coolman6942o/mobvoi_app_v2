package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.contacts.ContactConstant;
import h8.c;
/* loaded from: classes2.dex */
public class AuthInfoItem implements JsonBean, Parcelable {
    public static final Parcelable.Creator<AuthInfoItem> CREATOR = new a();
    @c("bind_device_size")
    public String desc;
    @c("firm")
    public String firm;
    @c("icon")
    public String icon;
    @c("is_bind")
    public boolean isBind;
    @c(ContactConstant.CallsRecordKeys.NAME)
    public String name;
    @c("type")
    public String type;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<AuthInfoItem> {
        a() {
        }

        /* renamed from: a */
        public AuthInfoItem createFromParcel(Parcel parcel) {
            return new AuthInfoItem(parcel);
        }

        /* renamed from: b */
        public AuthInfoItem[] newArray(int i10) {
            return new AuthInfoItem[i10];
        }
    }

    public AuthInfoItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.name);
        parcel.writeString(this.firm);
        parcel.writeByte(this.isBind ? (byte) 1 : (byte) 0);
        parcel.writeString(this.type);
        parcel.writeString(this.icon);
        parcel.writeString(this.desc);
    }

    protected AuthInfoItem(Parcel parcel) {
        this.name = parcel.readString();
        this.firm = parcel.readString();
        this.isBind = parcel.readByte() != 0;
        this.type = parcel.readString();
        this.icon = parcel.readString();
        this.desc = parcel.readString();
    }
}
