package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.permission.PermissionConstant;
import com.mobvoi.wear.util.TelephonyUtil;
import h8.c;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class ScenariosItem implements JsonBean, Serializable, Parcelable {
    public static final Parcelable.Creator<ScenariosItem> CREATOR = new a();
    public List<ActionItem> actions;
    @c("action_group_exec_mode")
    public int mode;
    @c("scenario_id")
    public int scenarioId;
    @c("scenario_meta")
    public Meta scenarioMeta;

    /* loaded from: classes2.dex */
    public static class Meta implements JsonBean, Serializable, Parcelable {
        public static final Parcelable.Creator<Meta> CREATOR = new a();
        @c("desc")
        public String desc;
        @c("icon")
        public String icon;
        @c(ContactConstant.CallsRecordKeys.NAME)
        public String name;
        @c("type")
        public String type;
        @c("voice_commands")
        public String[] voiceCommands;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<Meta> {
            a() {
            }

            /* renamed from: a */
            public Meta createFromParcel(Parcel parcel) {
                return new Meta(parcel);
            }

            /* renamed from: b */
            public Meta[] newArray(int i10) {
                return new Meta[i10];
            }
        }

        public Meta() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.desc);
            parcel.writeString(this.name);
            parcel.writeString(this.type);
            parcel.writeString(this.icon);
            parcel.writeStringArray(this.voiceCommands);
        }

        public Meta(String str, String str2, String str3, String str4, String[] strArr) {
            this.desc = str;
            this.name = str2;
            this.type = str3;
            this.icon = str4;
            this.voiceCommands = strArr;
        }

        protected Meta(Parcel parcel) {
            this.desc = parcel.readString();
            this.name = parcel.readString();
            this.type = parcel.readString();
            this.icon = parcel.readString();
            this.voiceCommands = parcel.createStringArray();
        }
    }

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ScenariosItem> {
        a() {
        }

        /* renamed from: a */
        public ScenariosItem createFromParcel(Parcel parcel) {
            return new ScenariosItem(parcel);
        }

        /* renamed from: b */
        public ScenariosItem[] newArray(int i10) {
            return new ScenariosItem[i10];
        }
    }

    public ScenariosItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mode);
        parcel.writeInt(this.scenarioId);
        parcel.writeParcelable(this.scenarioMeta, i10);
        parcel.writeTypedList(this.actions);
    }

    protected ScenariosItem(Parcel parcel) {
        this.mode = parcel.readInt();
        this.scenarioId = parcel.readInt();
        this.scenarioMeta = (Meta) parcel.readParcelable(Meta.class.getClassLoader());
        this.actions = parcel.createTypedArrayList(ActionItem.CREATOR);
    }

    /* loaded from: classes2.dex */
    public static class ActionItem implements JsonBean, Serializable, Parcelable {
        public static final int ACTION_DELAY = 5;
        public static final int ACTION_DEVICE = 4;
        public static final Parcelable.Creator<ActionItem> CREATOR = new a();
        @c("action_id")
        public int actionId;
        @c("cfg")
        public ActionCfg cfg;
        @c("parent_id")
        public String parentId;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<ActionItem> {
            a() {
            }

            /* renamed from: a */
            public ActionItem createFromParcel(Parcel parcel) {
                return new ActionItem(parcel);
            }

            /* renamed from: b */
            public ActionItem[] newArray(int i10) {
                return new ActionItem[i10];
            }
        }

        public ActionItem(ActionCfg actionCfg) {
            this.actionId = 4;
            this.cfg = actionCfg;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.actionId);
            parcel.writeParcelable(this.cfg, i10);
            parcel.writeString(this.parentId);
        }

        protected ActionItem(Parcel parcel) {
            this.actionId = parcel.readInt();
            this.cfg = (ActionCfg) parcel.readParcelable(ActionCfg.class.getClassLoader());
            this.parentId = parcel.readString();
        }
    }

    /* loaded from: classes2.dex */
    public static class ActionCfg implements JsonBean, Serializable, Parcelable {
        public static final Parcelable.Creator<ActionCfg> CREATOR = new a();
        @c(TelephonyUtil.KEY_SIM_ACTION)
        public String action;
        @c("sleep_in_seconds")
        public int delay;
        @c("device_id")
        public int deviceId;
        @c(ContactConstant.CallsRecordKeys.NAME)
        public String name;
        @c(PermissionConstant.Columns.STATUS)
        public int status;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<ActionCfg> {
            a() {
            }

            /* renamed from: a */
            public ActionCfg createFromParcel(Parcel parcel) {
                return new ActionCfg(parcel);
            }

            /* renamed from: b */
            public ActionCfg[] newArray(int i10) {
                return new ActionCfg[i10];
            }
        }

        public ActionCfg(String str, String str2, int i10, int i11) {
            this.name = str;
            this.action = str2;
            this.deviceId = i10;
            this.delay = i11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.name);
            parcel.writeString(this.action);
            parcel.writeInt(this.deviceId);
            parcel.writeInt(this.delay);
            parcel.writeInt(this.status);
        }

        protected ActionCfg(Parcel parcel) {
            this.name = parcel.readString();
            this.action = parcel.readString();
            this.deviceId = parcel.readInt();
            this.delay = parcel.readInt();
            this.status = parcel.readInt();
        }
    }
}
