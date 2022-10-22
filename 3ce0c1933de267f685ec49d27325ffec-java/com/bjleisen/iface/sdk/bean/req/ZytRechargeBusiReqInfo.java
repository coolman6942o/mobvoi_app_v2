package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class ZytRechargeBusiReqInfo extends BaseBusiReqInfo {
    private String cardNo;
    private String instanceAid;
    private String orderId;

    public String getCardNo() {
        return this.cardNo;
    }

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}
