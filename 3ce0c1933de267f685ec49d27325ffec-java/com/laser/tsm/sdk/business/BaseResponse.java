package com.laser.tsm.sdk.business;

import com.laser.tsm.sdk.business.Business;
/* loaded from: classes2.dex */
public class BaseResponse<T extends Business> {
    private T business;
    private String version;

    public T getBusiness() {
        return this.business;
    }

    public String getVersion() {
        return this.version;
    }

    public void setBusiness(T t10) {
        this.business = t10;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
