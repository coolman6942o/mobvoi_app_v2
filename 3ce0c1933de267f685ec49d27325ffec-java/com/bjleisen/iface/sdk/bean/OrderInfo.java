package com.bjleisen.iface.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class OrderInfo implements Parcelable {
    public static final Parcelable.Creator<OrderInfo> CREATOR = new Parcelable.Creator<OrderInfo>() { // from class: com.bjleisen.iface.sdk.bean.OrderInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OrderInfo createFromParcel(Parcel parcel) {
            return new OrderInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OrderInfo[] newArray(int i10) {
            return new OrderInfo[i10];
        }
    };
    private String orderId;
    private int orderMoney;
    private String orderTime;
    private int orderType;
    private int payMoney;
    private int payWay;
    private String tradeNo;

    public OrderInfo(Parcel parcel) {
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

    public String getTradeNo() {
        return this.tradeNo;
    }

    public void readToParcel(Parcel parcel) {
        this.orderId = parcel.readString();
        this.orderType = parcel.readInt();
        this.orderTime = parcel.readString();
        this.orderMoney = parcel.readInt();
        this.payWay = parcel.readInt();
        this.tradeNo = parcel.readString();
        this.payMoney = parcel.readInt();
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderMoney(int i10) {
        this.orderMoney = i10;
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

    public void setTradeNo(String str) {
        this.tradeNo = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.orderId);
        parcel.writeInt(this.orderType);
        parcel.writeString(this.orderTime);
        parcel.writeInt(this.orderMoney);
        parcel.writeInt(this.payWay);
        parcel.writeString(this.tradeNo);
        parcel.writeInt(this.payMoney);
    }
}
