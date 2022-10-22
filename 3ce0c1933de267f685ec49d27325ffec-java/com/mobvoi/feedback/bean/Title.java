package com.mobvoi.feedback.bean;

import com.mobvoi.android.common.json.JsonBean;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class Title implements JsonBean, Serializable {

    /* renamed from: cn  reason: collision with root package name */
    private String f17898cn;

    /* renamed from: en  reason: collision with root package name */
    private String f17899en;
    private String tw;

    public String getCn() {
        return this.f17898cn;
    }

    public String getEn() {
        return this.f17899en;
    }

    public String getTw() {
        return this.tw;
    }

    public void setCn(String str) {
        this.f17898cn = str;
    }

    public void setEn(String str) {
        this.f17899en = str;
    }

    public void setTw(String str) {
        this.tw = str;
    }
}
