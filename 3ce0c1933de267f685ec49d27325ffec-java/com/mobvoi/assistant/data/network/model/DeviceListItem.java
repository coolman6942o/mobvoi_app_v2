package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.permission.PermissionConstant;
import h8.c;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class DeviceListItem implements JsonBean, Parcelable {
    public static final Parcelable.Creator<DeviceListItem> CREATOR = new a();
    public int delay;
    @c("device_id")
    public int deviceId;
    @c("icon")
    public String icon;
    public int iconResId;
    @c("model")
    public String model;
    @c(ContactConstant.CallsRecordKeys.NAME)
    public String name;
    @c("name_alias")
    public String nameAlias;
    @c("state")
    public DeviceState state;
    @c("tag")
    public String tag;
    @c("traits")
    public String[] traits;
    @c("type")
    public String type;
    @c("type_name")
    public String typeName;
    @c("wwid")
    public String wwid;

    /* loaded from: classes2.dex */
    public static class DeviceState implements Parcelable {
        public static final Parcelable.Creator<DeviceState> CREATOR = new a();
        @c("on_off")

        /* renamed from: a  reason: collision with root package name */
        public int f15741a;
        @c(PermissionConstant.Columns.STATUS)

        /* renamed from: b  reason: collision with root package name */
        public int f15742b;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<DeviceState> {
            a() {
            }

            /* renamed from: a */
            public DeviceState createFromParcel(Parcel parcel) {
                return new DeviceState(parcel);
            }

            /* renamed from: b */
            public DeviceState[] newArray(int i10) {
                return new DeviceState[i10];
            }
        }

        public DeviceState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "DeviceState{onOff=" + this.f15741a + ", status=" + this.f15742b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f15741a);
            parcel.writeInt(this.f15742b);
        }

        protected DeviceState(Parcel parcel) {
            this.f15741a = parcel.readInt();
            this.f15742b = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DeviceListItem> {
        a() {
        }

        /* renamed from: a */
        public DeviceListItem createFromParcel(Parcel parcel) {
            return new DeviceListItem(parcel);
        }

        /* renamed from: b */
        public DeviceListItem[] newArray(int i10) {
            return new DeviceListItem[i10];
        }
    }

    public DeviceListItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DeviceListItem{iconResId=" + this.iconResId + ", delay=" + this.delay + ", icon='" + this.icon + "', deviceId=" + this.deviceId + ", wwid='" + this.wwid + "', name='" + this.name + "', nameAlias='" + this.nameAlias + "', tag='" + this.tag + "', type='" + this.type + "', typeName='" + this.typeName + "', model='" + this.model + "', traits=" + Arrays.toString(this.traits) + ", state=" + this.state + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.iconResId);
        parcel.writeInt(this.delay);
        parcel.writeString(this.icon);
        parcel.writeInt(this.deviceId);
        parcel.writeString(this.wwid);
        parcel.writeString(this.name);
        parcel.writeString(this.nameAlias);
        parcel.writeString(this.tag);
        parcel.writeString(this.type);
        parcel.writeString(this.typeName);
        parcel.writeString(this.model);
        parcel.writeStringArray(this.traits);
        parcel.writeParcelable(this.state, i10);
    }

    protected DeviceListItem(Parcel parcel) {
        this.iconResId = parcel.readInt();
        this.delay = parcel.readInt();
        this.icon = parcel.readString();
        this.deviceId = parcel.readInt();
        this.wwid = parcel.readString();
        this.name = parcel.readString();
        this.nameAlias = parcel.readString();
        this.tag = parcel.readString();
        this.type = parcel.readString();
        this.typeName = parcel.readString();
        this.model = parcel.readString();
        this.traits = parcel.createStringArray();
        this.state = (DeviceState) parcel.readParcelable(DeviceState.class.getClassLoader());
    }
}
