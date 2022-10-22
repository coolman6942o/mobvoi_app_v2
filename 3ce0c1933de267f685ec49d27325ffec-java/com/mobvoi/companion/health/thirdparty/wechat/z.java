package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
/* compiled from: WechatTokenResponse.java */
/* loaded from: classes2.dex */
public class z implements JsonBean {
    @c("err_code")
    public int errorCode;
    @c("err_msg")
    public String errorMessage;
    public String status;
    public String token;

    public String toString() {
        return "TokenResponse{errorCode=" + this.errorCode + ", errorMessage='" + this.errorMessage + "', status='" + this.status + "', token='" + this.token + "'}";
    }
}
