package com.bjleisen.iface.sdk.bean;

import com.bjleisen.iface.sdk.bean.req.ReservedField;
/* loaded from: classes.dex */
public class AppletFlag extends ReservedField {
    private String appletFlag;

    public AppletFlag(String str) {
        this.appletFlag = str;
    }

    public String getAppletFlag() {
        return this.appletFlag;
    }

    public void setAppletFlag(String str) {
        this.appletFlag = str;
    }
}
