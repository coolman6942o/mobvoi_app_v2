package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class AppletOperBusiReqInfo extends BaseBusiReqInfo {
    private String appletVersion;
    private String cin;
    private String iin;
    private String instanceAid;
    private int operType;
    private String orderId;
    private String removalCode;
    private ReservedField reservedField;

    public String getAppletVersion() {
        return this.appletVersion;
    }

    public String getCin() {
        return this.cin;
    }

    public String getIin() {
        return this.iin;
    }

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getOperType() {
        return this.operType;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getRemovalCode() {
        return this.removalCode;
    }

    public ReservedField getReservedField() {
        return this.reservedField;
    }

    public void setAppletVersion(String str) {
        this.appletVersion = str;
    }

    public void setCin(String str) {
        this.cin = str;
    }

    public void setIin(String str) {
        this.iin = str;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setOperType(int i10) {
        this.operType = i10;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setRemovalCode(String str) {
        this.removalCode = str;
    }

    public void setReservedField(ReservedField reservedField) {
        this.reservedField = reservedField;
    }
}
