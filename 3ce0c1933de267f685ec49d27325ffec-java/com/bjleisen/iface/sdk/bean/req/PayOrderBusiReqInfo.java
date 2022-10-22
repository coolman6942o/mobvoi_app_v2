package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class PayOrderBusiReqInfo extends BaseBusiReqInfo {
    private String cardNo;
    private String favouableId;
    private String instanceAid;
    private int moneyType;
    private String otherOrderInfo;
    private int payMoney;
    private int payWay;
    private String productId;
    private int tranStatus;

    public String getCardNo() {
        return this.cardNo;
    }

    public String getFavouableId() {
        return this.favouableId;
    }

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getMoneyType() {
        return this.moneyType;
    }

    public String getOtherOrderInfo() {
        return this.otherOrderInfo;
    }

    public int getPayMoney() {
        return this.payMoney;
    }

    public int getPayWay() {
        return this.payWay;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getTranStatus() {
        return this.tranStatus;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setFavouableId(String str) {
        this.favouableId = str;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setMoneyType(int i10) {
        this.moneyType = i10;
    }

    public void setOtherOrderInfo(String str) {
        this.otherOrderInfo = str;
    }

    public void setPayMoney(int i10) {
        this.payMoney = i10;
    }

    public void setPayWay(int i10) {
        this.payWay = i10;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setTranStatus(int i10) {
        this.tranStatus = i10;
    }
}
