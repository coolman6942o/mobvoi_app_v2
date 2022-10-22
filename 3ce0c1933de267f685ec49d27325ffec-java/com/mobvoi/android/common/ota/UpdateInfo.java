package com.mobvoi.android.common.ota;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.mobvoi.wear.providers.OtaColumn;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UpdateInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<UpdateInfo> CREATOR = new a();
    private static final long serialVersionUID = 1;
    public String app;
    public String changelog;
    public String channel;
    public String compatibility;
    public int counter;
    public String created_at;
    public String description;
    public String diff_from;
    public boolean enabled;
    public boolean force_update;
    public String md5;
    public int number;
    public int size;
    public String upload_status;
    public String url;
    public boolean valid;
    public String version;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<UpdateInfo> {
        a() {
        }

        /* renamed from: a */
        public UpdateInfo createFromParcel(Parcel parcel) {
            return new UpdateInfo(parcel, null);
        }

        /* renamed from: b */
        public UpdateInfo[] newArray(int i10) {
            return new UpdateInfo[i10];
        }
    }

    /* synthetic */ UpdateInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void a(Parcel parcel) {
        this.app = parcel.readString();
        this.changelog = parcel.readString();
        this.channel = parcel.readString();
        this.compatibility = parcel.readString();
        this.counter = parcel.readInt();
        this.created_at = parcel.readString();
        this.description = parcel.readString();
        this.diff_from = parcel.readString();
        boolean z10 = false;
        this.enabled = parcel.readInt() == 1;
        this.force_update = parcel.readInt() == 1;
        this.md5 = parcel.readString();
        this.number = parcel.readInt();
        this.size = parcel.readInt();
        this.upload_status = parcel.readString();
        this.url = parcel.readString();
        if (parcel.readInt() == 1) {
            z10 = true;
        }
        this.valid = z10;
        this.version = parcel.readString();
    }

    public static UpdateInfo parseFromJSONObject(JSONObject jSONObject) {
        UpdateInfo updateInfo = new UpdateInfo();
        try {
            updateInfo.app = jSONObject.getString(OtaColumn.COLUMN_APP);
            updateInfo.changelog = jSONObject.getString("changelog");
            updateInfo.channel = jSONObject.getString("channel");
            updateInfo.compatibility = jSONObject.getString(OtaColumn.COLUMN_COMPATIBILITY);
            updateInfo.counter = jSONObject.getInt(OtaColumn.COLUMN_COUNTER);
            updateInfo.created_at = jSONObject.getString(OtaColumn.COLUMN_CREATED_AT);
            updateInfo.description = jSONObject.getString(OtaColumn.COLUMN_DESCRIPTION);
            updateInfo.diff_from = jSONObject.getString(OtaColumn.COLUMN_DIFF_FROM);
            updateInfo.enabled = jSONObject.getBoolean(OtaColumn.COLUMN_ENABLED);
            updateInfo.force_update = jSONObject.getBoolean(OtaColumn.COLUMN_FORCE_UPDATE);
            updateInfo.md5 = jSONObject.getString(OtaColumn.COLUMN_MD5);
            updateInfo.number = jSONObject.getInt("number");
            updateInfo.size = jSONObject.getInt(OtaColumn.COLUMN_SIZE);
            updateInfo.upload_status = jSONObject.getString(OtaColumn.COLUMN_UPLOAD_STATUS);
            updateInfo.url = jSONObject.getString("url");
            updateInfo.valid = jSONObject.getBoolean(OtaColumn.COLUMN_VALID);
            updateInfo.version = jSONObject.getString("version");
            return updateInfo;
        } catch (Exception e10) {
            Log.e("UpdateInfo", e10.getMessage(), e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject serializeToJsonObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(OtaColumn.COLUMN_APP, this.app);
            jSONObject.put("changelog", this.changelog);
            jSONObject.put("channel", this.channel);
            jSONObject.put(OtaColumn.COLUMN_COMPATIBILITY, this.compatibility);
            jSONObject.put(OtaColumn.COLUMN_COUNTER, this.counter);
            jSONObject.put(OtaColumn.COLUMN_CREATED_AT, this.created_at);
            jSONObject.put(OtaColumn.COLUMN_DESCRIPTION, this.description);
            jSONObject.put(OtaColumn.COLUMN_DIFF_FROM, this.diff_from);
            jSONObject.put(OtaColumn.COLUMN_ENABLED, this.enabled);
            jSONObject.put(OtaColumn.COLUMN_FORCE_UPDATE, this.force_update);
            jSONObject.put(OtaColumn.COLUMN_MD5, this.md5);
            jSONObject.put("number", this.number);
            jSONObject.put(OtaColumn.COLUMN_SIZE, this.size);
            jSONObject.put(OtaColumn.COLUMN_UPLOAD_STATUS, this.upload_status);
            jSONObject.put("url", this.url);
            jSONObject.put(OtaColumn.COLUMN_VALID, this.valid);
            jSONObject.put("version", this.version);
            return jSONObject;
        } catch (Exception e10) {
            Log.e("UpdateInfo", e10.getMessage(), e10);
            return null;
        }
    }

    public String toString() {
        return "UpdateInfo{app='" + this.app + "', changelog='" + this.changelog + "', channel='" + this.channel + "', compatibility='" + this.compatibility + "', counter=" + this.counter + ", created_at='" + this.created_at + "', description='" + this.description + "', diff_from='" + this.diff_from + "', enabled=" + this.enabled + ", force_update=" + this.force_update + ", md5='" + this.md5 + "', number=" + this.number + ", size=" + this.size + ", upload_status='" + this.upload_status + "', url='" + this.url + "', valid=" + this.valid + ", version='" + this.version + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.app);
        parcel.writeString(this.changelog);
        parcel.writeString(this.channel);
        parcel.writeString(this.compatibility);
        parcel.writeInt(this.counter);
        parcel.writeString(this.created_at);
        parcel.writeString(this.description);
        parcel.writeString(this.diff_from);
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeInt(this.force_update ? 1 : 0);
        parcel.writeString(this.md5);
        parcel.writeInt(this.number);
        parcel.writeInt(this.size);
        parcel.writeString(this.upload_status);
        parcel.writeString(this.url);
        parcel.writeInt(this.valid ? 1 : 0);
        parcel.writeString(this.version);
    }

    public UpdateInfo() {
    }

    private UpdateInfo(Parcel parcel) {
        a(parcel);
    }
}
