package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class ZytBindingCardBusiReqInfo extends BaseBusiReqInfo {
    private String instanceAid;
    private String pin;

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public String getPin() {
        return this.pin;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setPin(String str) {
        this.pin = str;
    }
}
