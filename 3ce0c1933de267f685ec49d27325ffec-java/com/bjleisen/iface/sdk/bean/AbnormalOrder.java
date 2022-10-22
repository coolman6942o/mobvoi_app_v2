package com.bjleisen.iface.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class AbnormalOrder implements Parcelable {
    public static final Parcelable.Creator<AbnormalOrder> CREATOR = new Parcelable.Creator<AbnormalOrder>() { // from class: com.bjleisen.iface.sdk.bean.AbnormalOrder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AbnormalOrder createFromParcel(Parcel parcel) {
            return new AbnormalOrder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AbnormalOrder[] newArray(int i10) {
            return new AbnormalOrder[i10];
        }
    };
    private String appletName;
    private String orderId;
    private String orderTime;
    private int orderType;
    private int orgChargeMoney;

    public AbnormalOrder(Parcel parcel) {
        readToParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppletName() {
        return this.appletName;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public int getOrgChargeMoney() {
        return this.orgChargeMoney;
    }

    public void readToParcel(Parcel parcel) {
        this.appletName = parcel.readString();
        this.orderType = parcel.readInt();
        this.orderTime = parcel.readString();
        this.orderId = parcel.readString();
        this.orgChargeMoney = parcel.readInt();
    }

    public void setAppletName(String str) {
        this.appletName = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public void setOrderType(int i10) {
        this.orderType = i10;
    }

    public void setOrgChargeMoney(int i10) {
        this.orgChargeMoney = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.appletName);
        parcel.writeInt(this.orderType);
        parcel.writeString(this.orderTime);
        parcel.writeString(this.orderId);
        parcel.writeInt(this.orgChargeMoney);
    }
}
