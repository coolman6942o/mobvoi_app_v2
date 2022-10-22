package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
/* compiled from: EsimInfo.kt */
/* loaded from: classes2.dex */
public final class EsimInfo implements JsonBean {
    @c("eid")
    private String eid;
    @c("imei")
    private String imei;

    public final String getEid() {
        return this.eid;
    }

    public final String getImei() {
        return this.imei;
    }

    public final void setEid(String str) {
        this.eid = str;
    }

    public final void setImei(String str) {
        this.imei = str;
    }
}
