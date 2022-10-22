package com.bjleisen.iface.sdk.bean.resp;
/* loaded from: classes.dex */
public class AbnormalOrderDetailBusiRespInfo extends BaseBusiRespInfo {
    private String appletName;
    private String appletVersion;
    private String cardNo;
    private int chargeMoney;
    private String instanceAid;
    private int orderStatus;
    private String orderTime;
    private int orderType;
    private int orgChargeMoney;
    private int payWay;

    public String getAppletName() {
        return this.appletName;
    }

    public String getAppletVersion() {
        return this.appletVersion;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public int getChargeMoney() {
        return this.chargeMoney;
    }

    public String getInstanceAid() {
        return this.instanceAid;
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

    public int getOrgChargeMoney() {
        return this.orgChargeMoney;
    }

    public int getPayWay() {
        return this.payWay;
    }

    public void setAppletName(String str) {
        this.appletName = str;
    }

    public void setAppletVersion(String str) {
        this.appletVersion = str;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setChargeMoney(int i10) {
        this.chargeMoney = i10;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
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

    public void setOrgChargeMoney(int i10) {
        this.orgChargeMoney = i10;
    }

    public void setPayWay(int i10) {
        this.payWay = i10;
    }
}
