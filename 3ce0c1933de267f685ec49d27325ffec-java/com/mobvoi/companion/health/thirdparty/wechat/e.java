package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import java.util.List;
import kotlin.jvm.internal.i;
/* compiled from: BindWechatBean.kt */
/* loaded from: classes2.dex */
public final class e implements JsonBean {
    private List<String> deviceIds;
    private String wwid;

    public e(String wwid, List<String> deviceIds) {
        i.f(wwid, "wwid");
        i.f(deviceIds, "deviceIds");
        this.wwid = wwid;
        this.deviceIds = deviceIds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return i.b(this.wwid, eVar.wwid) && i.b(this.deviceIds, eVar.deviceIds);
    }

    public int hashCode() {
        return (this.wwid.hashCode() * 31) + this.deviceIds.hashCode();
    }

    public String toString() {
        return "BindStatusRequest(wwid=" + this.wwid + ", deviceIds=" + this.deviceIds + ')';
    }
}
