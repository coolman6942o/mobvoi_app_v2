package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: BindWechatBean.kt */
/* loaded from: classes2.dex */
public final class c implements JsonBean {
    private String deviceId;
    private String deviceModel;
    private String wwid;

    public c(String wwid, String deviceId, String deviceModel) {
        i.f(wwid, "wwid");
        i.f(deviceId, "deviceId");
        i.f(deviceModel, "deviceModel");
        this.wwid = wwid;
        this.deviceId = deviceId;
        this.deviceModel = deviceModel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return i.b(this.wwid, cVar.wwid) && i.b(this.deviceId, cVar.deviceId) && i.b(this.deviceModel, cVar.deviceModel);
    }

    public int hashCode() {
        return (((this.wwid.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.deviceModel.hashCode();
    }

    public String toString() {
        return "BindRequest(wwid=" + this.wwid + ", deviceId=" + this.deviceId + ", deviceModel=" + this.deviceModel + ')';
    }
}
