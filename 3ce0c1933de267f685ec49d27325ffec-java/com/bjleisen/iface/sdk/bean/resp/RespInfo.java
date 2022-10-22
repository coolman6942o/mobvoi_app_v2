package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.resp.BaseBusiRespInfo;
/* loaded from: classes.dex */
public class RespInfo<T extends BaseBusiRespInfo> {
    private T busiRespInfo;
    private String desc;
    private int status = -1;
    private String version;

    public T getBusiRespInfo() {
        return this.busiRespInfo;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getStatus() {
        return this.status;
    }

    public String getVersion() {
        return this.version;
    }

    public void setBusiRespInfo(T t10) {
        this.busiRespInfo = t10;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
