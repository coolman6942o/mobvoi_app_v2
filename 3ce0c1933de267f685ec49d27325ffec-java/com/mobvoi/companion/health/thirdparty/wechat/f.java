package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: BindWechatBean.kt */
/* loaded from: classes2.dex */
public final class f implements JsonBean {
    private int errorCode;
    private String errorMessage;
    private String ticket;

    public final int a() {
        return this.errorCode;
    }

    public final String b() {
        return this.errorMessage;
    }

    public final String c() {
        return this.ticket;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.errorCode == fVar.errorCode && i.b(this.errorMessage, fVar.errorMessage) && i.b(this.ticket, fVar.ticket);
    }

    public int hashCode() {
        return (((this.errorCode * 31) + this.errorMessage.hashCode()) * 31) + this.ticket.hashCode();
    }

    public String toString() {
        return "BindWechatBean(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", ticket=" + this.ticket + ')';
    }
}
