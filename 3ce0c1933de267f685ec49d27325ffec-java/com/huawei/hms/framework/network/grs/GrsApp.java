package com.huawei.hms.framework.network.grs;

import android.content.Context;
/* loaded from: classes.dex */
public class GrsApp {
    private static GrsApp instance = new GrsApp();
    private String appConfigName;

    private GrsApp() {
    }

    public static GrsApp getInstance() {
        return instance;
    }

    public String getAppConfigName() {
        return this.appConfigName;
    }

    public String getIssueCountryCode(Context context) {
        return a.a(context, false).getCountryCode();
    }

    public void setAppConfigName(String str) {
        this.appConfigName = str;
    }
}
