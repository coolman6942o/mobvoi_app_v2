package com.tendcloud.tenddata;

import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cc extends ch {

    /* renamed from: a  reason: collision with root package name */
    static cc f22792a;

    private cc() {
    }

    public static synchronized cc a() {
        cc ccVar;
        synchronized (cc.class) {
            if (f22792a == null) {
                f22792a = new cc();
            }
            ccVar = f22792a;
        }
        return ccVar;
    }

    @Override // com.tendcloud.tenddata.ch
    public Object b() {
        try {
            if (!f22792a.f22803b.has("account") && h.l() != null) {
                f22792a.a("account", (Object) new JSONObject(h.l()));
            }
        } catch (Throwable unused) {
        }
        return super.b();
    }

    public void setCurrentPageName(String str) {
        a("page", str);
    }

    public void setDeepLink(String str) {
        try {
            a("deeplink", str);
            h.setDeepLink(str);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public void setProfile(JSONObject jSONObject) {
        a("account", (Object) jSONObject);
    }

    public void setSessionId(String str) {
        a("sessionId", str);
    }

    public void setSessionStartTime(long j10) {
        a("sessionStartTime", Long.valueOf(j10));
    }

    public void setSubprofile(JSONObject jSONObject) {
        a("subaccount", (Object) jSONObject);
    }
}
