package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
/* compiled from: WechatAuthResponse.java */
/* loaded from: classes2.dex */
public class u implements JsonBean {
    @c(pi.a.TAB_NAME)
    public a deviceInfo;

    /* compiled from: WechatAuthResponse.java */
    /* loaded from: classes2.dex */
    public static class a implements JsonBean {
        @c("device_id")
        public String deviceId;
        @c("qr_ticket")
        public String ticket;

        public String toString() {
            return "DeviceInfo{deviceId='" + this.deviceId + "', ticket='" + this.ticket + "'}";
        }
    }

    public String toString() {
        return "WechatAuthResponse{deviceInfo=" + this.deviceInfo + '}';
    }
}
