package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: BindWechatBean.kt */
/* loaded from: classes2.dex */
public final class a implements JsonBean {
    private boolean bindStatus;
    private String deviceId;
    private String sdkId;

    public final boolean a() {
        return this.bindStatus;
    }

    public final String b() {
        return this.deviceId;
    }

    public final String c() {
        return this.sdkId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i.b(this.deviceId, aVar.deviceId) && i.b(this.sdkId, aVar.sdkId) && this.bindStatus == aVar.bindStatus;
    }

    public int hashCode() {
        int hashCode = ((this.deviceId.hashCode() * 31) + this.sdkId.hashCode()) * 31;
        boolean z10 = this.bindStatus;
        if (z10) {
            z10 = true;
        }
        int i10 = z10 ? 1 : 0;
        int i11 = z10 ? 1 : 0;
        return hashCode + i10;
    }

    public String toString() {
        return "BindBO(deviceId=" + this.deviceId + ", sdkId=" + this.sdkId + ", bindStatus=" + this.bindStatus + ')';
    }
}
