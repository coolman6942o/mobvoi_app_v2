package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class RegUserInfoReqInfo extends BaseBusiReqInfo {
    private String instanceAid;
    private int issueType;
    private String phoneNumber;
    private String userId;
    private int userIdType;
    private String userName;

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getIssueType() {
        return this.issueType;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getUserIdType() {
        return this.userIdType;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setIssueType(int i10) {
        this.issueType = i10;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserIdType(int i10) {
        this.userIdType = i10;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
