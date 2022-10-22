package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class CardTemplateReqInfo extends BaseBusiReqInfo {
    private String instanceAid;
    private int type;

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getType() {
        return this.type;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
