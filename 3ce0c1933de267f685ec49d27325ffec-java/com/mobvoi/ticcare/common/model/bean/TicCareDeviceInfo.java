package com.mobvoi.ticcare.common.model.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.ticcare.common.model.bean.a;
import com.mobvoi.ticcare.common.model.bean.b;
/* loaded from: classes2.dex */
public class TicCareDeviceInfo implements JsonBean, Parcelable {
    public static final Parcelable.Creator<TicCareDeviceInfo> CREATOR = new a();
    public String accountId;
    public int createTime;
    public String deviceId;
    public String deviceName;
    public String deviceType;
    public String headImgUrl;
    public boolean isShowHealthData;
    public boolean isShowSportData;
    public String nickName;
    public String remarkName;
    public String wwid;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<TicCareDeviceInfo> {
        a() {
        }

        /* renamed from: a */
        public TicCareDeviceInfo createFromParcel(Parcel parcel) {
            return new TicCareDeviceInfo(parcel);
        }

        /* renamed from: b */
        public TicCareDeviceInfo[] newArray(int i10) {
            return new TicCareDeviceInfo[i10];
        }
    }

    public TicCareDeviceInfo() {
    }

    public static TicCareDeviceInfo a(a.C0241a aVar) {
        TicCareDeviceInfo ticCareDeviceInfo = new TicCareDeviceInfo();
        ticCareDeviceInfo.wwid = aVar.wwid;
        ticCareDeviceInfo.accountId = aVar.accountId;
        ticCareDeviceInfo.headImgUrl = aVar.headImgUrl;
        ticCareDeviceInfo.nickName = aVar.nickName;
        return ticCareDeviceInfo;
    }

    public static TicCareDeviceInfo b(b.a aVar) {
        TicCareDeviceInfo ticCareDeviceInfo = new TicCareDeviceInfo();
        ticCareDeviceInfo.wwid = aVar.wwid;
        ticCareDeviceInfo.accountId = aVar.accountId;
        ticCareDeviceInfo.headImgUrl = aVar.headImgUrl;
        ticCareDeviceInfo.nickName = aVar.nickName;
        ticCareDeviceInfo.deviceId = aVar.deviceId;
        ticCareDeviceInfo.deviceName = aVar.deviceName;
        ticCareDeviceInfo.remarkName = aVar.remarkName;
        for (b.a.C0242a aVar2 : aVar.settings) {
            if (aVar2.shareDataType.equals("SHARE_EXERCISE")) {
                ticCareDeviceInfo.isShowSportData = aVar2.shareDataStatus;
            } else if (aVar2.shareDataType.equals("SHARE_HEALTH")) {
                ticCareDeviceInfo.isShowHealthData = aVar2.shareDataStatus;
            }
        }
        return ticCareDeviceInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "TicCareDeviceInfo{createTime=" + this.createTime + ", deviceId='" + this.deviceId + "', wwid='" + this.wwid + "', deviceName='" + this.deviceName + "', deviceType='" + this.deviceType + "', accountId='" + this.accountId + "', headImgUrl='" + this.headImgUrl + "', nickName='" + this.nickName + "', remarkName='" + this.remarkName + "', isShowHealthData=" + this.isShowHealthData + ", isShowSportData=" + this.isShowSportData + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.createTime);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.wwid);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.deviceType);
        parcel.writeString(this.accountId);
        parcel.writeString(this.headImgUrl);
        parcel.writeString(this.nickName);
        parcel.writeString(this.remarkName);
        parcel.writeByte(this.isShowHealthData ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isShowSportData ? (byte) 1 : (byte) 0);
    }

    protected TicCareDeviceInfo(Parcel parcel) {
        this.createTime = parcel.readInt();
        this.deviceId = parcel.readString();
        this.wwid = parcel.readString();
        this.deviceName = parcel.readString();
        this.deviceType = parcel.readString();
        this.accountId = parcel.readString();
        this.headImgUrl = parcel.readString();
        this.nickName = parcel.readString();
        this.remarkName = parcel.readString();
        boolean z10 = true;
        this.isShowHealthData = parcel.readByte() != 0;
        this.isShowSportData = parcel.readByte() == 0 ? false : z10;
    }
}
