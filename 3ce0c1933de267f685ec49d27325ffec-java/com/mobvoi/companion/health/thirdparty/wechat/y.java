package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
/* compiled from: WechatStepResponse.java */
/* loaded from: classes2.dex */
public class y implements JsonBean {
    @c("err_code")
    public int errorCode;
    @c("err_msg")
    public String errorMsg;
    public String status;

    public String toString() {
        return "WechatStepResponse{status='" + this.status + "', errorMsg='" + this.errorMsg + "', errorCode=" + this.errorCode + '}';
    }
}
