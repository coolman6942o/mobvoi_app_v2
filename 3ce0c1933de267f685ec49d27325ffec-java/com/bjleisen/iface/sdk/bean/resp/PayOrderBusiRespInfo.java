package com.bjleisen.iface.sdk.bean.resp;
/* loaded from: classes.dex */
public class PayOrderBusiRespInfo extends BaseBusiRespInfo {
    private String payReqInfo;
    private String tranOrderId;

    public String getPayReqInfo() {
        return this.payReqInfo;
    }

    public String getTranOrderId() {
        return this.tranOrderId;
    }

    public void setPayReqInfo(String str) {
        this.payReqInfo = str;
    }

    public void setTranOrderId(String str) {
        this.tranOrderId = str;
    }
}
