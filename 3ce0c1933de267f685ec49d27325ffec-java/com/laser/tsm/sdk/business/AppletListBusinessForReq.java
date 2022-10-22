package com.laser.tsm.sdk.business;
/* loaded from: classes2.dex */
public class AppletListBusinessForReq extends Business {
    private int appType;
    private String appVersion;
    private String keyword;
    private int listOrder;
    private int osType;
    private int pageNumber;
    private int pageSize;

    public int getAppType() {
        return this.appType;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public int getOsType() {
        return this.osType;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setAppType(int i10) {
        this.appType = i10;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setListOrder(int i10) {
        this.listOrder = i10;
    }

    public void setOsType(int i10) {
        this.osType = i10;
    }

    public void setPageNumber(int i10) {
        this.pageNumber = i10;
    }

    public void setPageSize(int i10) {
        this.pageSize = i10;
    }
}
