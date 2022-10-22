package com.mobvoi.wear.twappstore;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class WearablePackage implements Serializable {
    public int versionCode;
    public String versionName;

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionCode(int i10) {
        this.versionCode = i10;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
