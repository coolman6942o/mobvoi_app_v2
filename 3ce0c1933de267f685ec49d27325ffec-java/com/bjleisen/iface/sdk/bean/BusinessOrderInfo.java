package com.bjleisen.iface.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class BusinessOrderInfo implements Parcelable {
    public static final Parcelable.Creator<BusinessOrderInfo> CREATOR = new Parcelable.Creator<BusinessOrderInfo>() { // from class: com.bjleisen.iface.sdk.bean.BusinessOrderInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BusinessOrderInfo createFromParcel(Parcel parcel) {
            return new BusinessOrderInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BusinessOrderInfo[] newArray(int i10) {
            return new BusinessOrderInfo[i10];
        }
    };
    private String orderId;
    private int orderMoney;
    private int orderStatus;
    private String orderTime;
    private int orderType;
    private int payMoney;
    private int payWay;
    private int refundStatus;

    public BusinessOrderInfo(Parcel parcel) {
        readToParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int getOrderMoney() {
        return this.orderMoney;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public int getPayMoney() {
        return this.payMoney;
    }

    public int getPayWay() {
        return this.payWay;
    }

    public int getRefundStatus() {
        return this.refundStatus;
    }

    public void readToParcel(Parcel parcel) {
        this.orderId = parcel.readString();
        this.orderType = parcel.readInt();
        this.orderTime = parcel.readString();
        this.orderMoney = parcel.readInt();
        this.payWay = parcel.readInt();
        this.orderStatus = parcel.readInt();
        this.payMoney = parcel.readInt();
        this.refundStatus = parcel.readInt();
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderMoney(int i10) {
        this.orderMoney = i10;
    }

    public void setOrderStatus(int i10) {
        this.orderStatus = i10;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public void setOrderType(int i10) {
        this.orderType = i10;
    }

    public void setPayMoney(int i10) {
        this.payMoney = i10;
    }

    public void setPayWay(int i10) {
        this.payWay = i10;
    }

    public void setRefundStatus(int i10) {
        this.refundStatus = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.orderId);
        parcel.writeInt(this.orderType);
        parcel.writeString(this.orderTime);
        parcel.writeInt(this.orderMoney);
        parcel.writeInt(this.payWay);
        parcel.writeInt(this.orderStatus);
        parcel.writeInt(this.payMoney);
        parcel.writeInt(this.refundStatus);
    }
}
