package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.util.List;
/* loaded from: classes2.dex */
public class ThirdPartySceneResponse$DataBean$ScenariosBean implements JsonBean, Parcelable {
    public static final Parcelable.Creator<ThirdPartySceneResponse$DataBean$ScenariosBean> CREATOR = new a();
    public long createdAt;
    public int faqId;

    /* renamed from: id  reason: collision with root package name */
    public int f15816id;
    public String name;
    public String thirdParty;
    @c("tpId")
    public int thirdPartyId;
    public long updatedAt;
    public List<String> voiceCommands;
    public String wwid;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ThirdPartySceneResponse$DataBean$ScenariosBean> {
        a() {
        }

        /* renamed from: a */
        public ThirdPartySceneResponse$DataBean$ScenariosBean createFromParcel(Parcel parcel) {
            return new ThirdPartySceneResponse$DataBean$ScenariosBean(parcel);
        }

        /* renamed from: b */
        public ThirdPartySceneResponse$DataBean$ScenariosBean[] newArray(int i10) {
            return new ThirdPartySceneResponse$DataBean$ScenariosBean[i10];
        }
    }

    public ThirdPartySceneResponse$DataBean$ScenariosBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ScenariosBean{thirdParty='" + this.thirdParty + "', createdAt=" + this.createdAt + ", thirdPartyId=" + this.thirdPartyId + ", voiceCommands=" + this.voiceCommands + ", name='" + this.name + "', faqId=" + this.faqId + ", id=" + this.f15816id + ", wwid='" + this.wwid + "', updatedAt=" + this.updatedAt + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.thirdParty);
        parcel.writeLong(this.createdAt);
        parcel.writeInt(this.thirdPartyId);
        parcel.writeStringList(this.voiceCommands);
        parcel.writeString(this.name);
        parcel.writeInt(this.faqId);
        parcel.writeInt(this.f15816id);
        parcel.writeString(this.wwid);
        parcel.writeLong(this.updatedAt);
    }

    protected ThirdPartySceneResponse$DataBean$ScenariosBean(Parcel parcel) {
        this.thirdParty = parcel.readString();
        this.createdAt = parcel.readLong();
        this.thirdPartyId = parcel.readInt();
        this.voiceCommands = parcel.createStringArrayList();
        this.name = parcel.readString();
        this.faqId = parcel.readInt();
        this.f15816id = parcel.readInt();
        this.wwid = parcel.readString();
        this.updatedAt = parcel.readLong();
    }
}
