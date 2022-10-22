package com.bjleisen.iface.sdk.bean.req;

import com.bjleisen.iface.sdk.bean.req.BaseBusiReqInfo;
/* loaded from: classes.dex */
public class ReqInfo<T extends BaseBusiReqInfo> {
    private String appVersion;
    private String basePhoneVersion;
    private T busiReqInfo;
    private int businessType;
    private String callAppHash;
    private String callAppPackageName;
    private String deviceModel;
    private String imei;
    private String msisdn;
    private String phoneModel;
    private int phoneOsType;
    private String phoneOsVersion;
    private String seTsmId;
    private String seid;
    private String userAccountId;
    private String version;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getBasePhoneVersion() {
        return this.basePhoneVersion;
    }

    public T getBusiReqInfo() {
        return this.busiReqInfo;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public String getCallAppHash() {
        return this.callAppHash;
    }

    public String getCallAppPackageName() {
        return this.callAppPackageName;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getImei() {
        return this.imei;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    public String getPhoneModel() {
        return this.phoneModel;
    }

    public int getPhoneOsType() {
        return this.phoneOsType;
    }

    public String getPhoneOsVersion() {
        return this.phoneOsVersion;
    }

    public String getSeTsmId() {
        return this.seTsmId;
    }

    public String getSeid() {
        return this.seid;
    }

    public String getUserAccountId() {
        return this.userAccountId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setBasePhoneVersion(String str) {
        this.basePhoneVersion = str;
    }

    public void setBusiReqInfo(T t10) {
        this.busiReqInfo = t10;
    }

    public void setBusinessType(int i10) {
        this.businessType = i10;
    }

    public void setCallAppHash(String str) {
        this.callAppHash = str;
    }

    public void setCallAppPackageName(String str) {
        this.callAppPackageName = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setMsisdn(String str) {
        this.msisdn = str;
    }

    public void setPhoneModel(String str) {
        this.phoneModel = str;
    }

    public void setPhoneOsType(int i10) {
        this.phoneOsType = i10;
    }

    public void setPhoneOsVersion(String str) {
        this.phoneOsVersion = str;
    }

    public void setSeTsmId(String str) {
        this.seTsmId = str;
    }

    public void setSeid(String str) {
        this.seid = str;
    }

    public void setUserAccountId(String str) {
        this.userAccountId = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
