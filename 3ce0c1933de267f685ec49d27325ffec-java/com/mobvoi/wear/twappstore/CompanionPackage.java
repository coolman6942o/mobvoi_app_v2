package com.mobvoi.wear.twappstore;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CompanionPackage implements Serializable {
    public String packageName;
    public WearablePackage wearablePackage;

    public String getPackageName() {
        return this.packageName;
    }

    public WearablePackage getWearablePackage() {
        return this.wearablePackage;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setWearablePackage(WearablePackage wearablePackage) {
        this.wearablePackage = wearablePackage;
    }
}
