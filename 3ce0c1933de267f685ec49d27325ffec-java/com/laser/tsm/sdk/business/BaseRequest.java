package com.laser.tsm.sdk.business;

import com.laser.tsm.sdk.business.Business;
/* loaded from: classes2.dex */
public class BaseRequest<T extends Business> {
    private T business;
    private String clientVersion;
    private String cplc;
    private String functionCallId;
    private String imei;
    private String mobileType;
    private String seid;
    private String serviceId;
    private String version;

    public T getBusiness() {
        return this.business;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public String getCplc() {
        return this.cplc;
    }

    public String getFunctionCallId() {
        return this.functionCallId;
    }

    public String getImei() {
        return this.imei;
    }

    public String getMobileType() {
        return this.mobileType;
    }

    public String getSeid() {
        return this.seid;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setBusiness(T t10) {
        this.business = t10;
    }

    public void setClientVersion(String str) {
        this.clientVersion = str;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setFunctionCallId(String str) {
        this.functionCallId = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setMobileType(String str) {
        this.mobileType = str;
    }

    public void setSeid(String str) {
        this.seid = str;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
