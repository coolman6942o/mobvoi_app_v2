package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class RegisterBusiReqInfo extends BaseBusiReqInfo {
    private String cplc;
    private String userInfoId;

    public String getCplc() {
        return this.cplc;
    }

    public String getUserInfoId() {
        return this.userInfoId;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setUserInfoId(String str) {
        this.userInfoId = str;
    }
}
