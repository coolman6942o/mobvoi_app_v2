package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class VertifyMessageBusiReqInfo extends BaseBusiReqInfo {
    private String instanceAid;
    private int issueType;
    private String verificationCode;

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getIssueType() {
        return this.issueType;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setIssueType(int i10) {
        this.issueType = i10;
    }

    public void setVerificationCode(String str) {
        this.verificationCode = str;
    }
}
