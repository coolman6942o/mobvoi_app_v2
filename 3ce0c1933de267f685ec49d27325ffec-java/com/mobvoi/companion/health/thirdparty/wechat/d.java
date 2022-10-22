package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import java.util.List;
import kotlin.jvm.internal.i;
/* compiled from: BindWechatBean.kt */
/* loaded from: classes2.dex */
public final class d implements JsonBean {
    private List<a> bindList;
    private int errorCode;
    private String errorMessage;

    public final int a() {
        return this.errorCode;
    }

    public final List<a> b() {
        return this.bindList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.errorCode == dVar.errorCode && i.b(this.errorMessage, dVar.errorMessage) && i.b(this.bindList, dVar.bindList);
    }

    public int hashCode() {
        return (((this.errorCode * 31) + this.errorMessage.hashCode()) * 31) + this.bindList.hashCode();
    }

    public String toString() {
        return "BindStatusBean(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", bindList=" + this.bindList + ')';
    }
}
