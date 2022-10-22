package com.bjleisen.iface.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class TradeInfo implements Parcelable {
    public static final Parcelable.Creator<TradeInfo> CREATOR = new Parcelable.Creator<TradeInfo>() { // from class: com.bjleisen.iface.sdk.bean.TradeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TradeInfo createFromParcel(Parcel parcel) {
            return new TradeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TradeInfo[] newArray(int i10) {
            return new TradeInfo[i10];
        }
    };
    private String posId;
    private String tradeDate;
    private int tradeMoney;
    private String tradeNo;
    private String tradeRecord;
    private String tradeTime;
    private int tradeType;

    public TradeInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPosId() {
        return this.posId;
    }

    public String getTradeDate() {
        return this.tradeDate;
    }

    public int getTradeMoney() {
        return this.tradeMoney;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }

    public String getTradeRecord() {
        return this.tradeRecord;
    }

    public String getTradeTime() {
        return this.tradeTime;
    }

    public int getTradeType() {
        return this.tradeType;
    }

    public void readToParcel(Parcel parcel) {
        this.tradeNo = parcel.readString();
        this.tradeMoney = parcel.readInt();
        this.tradeDate = parcel.readString();
        this.tradeTime = parcel.readString();
        this.tradeType = parcel.readInt();
        this.tradeRecord = parcel.readString();
    }

    public void setPosId(String str) {
        this.posId = str;
    }

    public void setTradeDate(String str) {
        this.tradeDate = str;
    }

    public void setTradeMoney(int i10) {
        this.tradeMoney = i10;
    }

    public void setTradeNo(String str) {
        this.tradeNo = str;
    }

    public void setTradeRecord(String str) {
        this.tradeRecord = str;
    }

    public void setTradeTime(String str) {
        this.tradeTime = str;
    }

    public void setTradeType(int i10) {
        this.tradeType = i10;
    }

    public String toString() {
        return "TradeTemplateInfo [tradeNo=" + this.tradeNo + ", tradeMoney=" + this.tradeMoney + ", tradeDate=" + this.tradeDate + ", tradeTime=" + this.tradeTime + ", tradeType=" + this.tradeType + ", tradeRecord=" + this.tradeRecord + ", posId=" + this.posId + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.tradeNo);
        parcel.writeInt(this.tradeMoney);
        parcel.writeString(this.tradeDate);
        parcel.writeString(this.tradeTime);
        parcel.writeInt(this.tradeType);
        parcel.writeString(this.tradeRecord);
    }

    public TradeInfo(Parcel parcel) {
        readToParcel(parcel);
    }
}
