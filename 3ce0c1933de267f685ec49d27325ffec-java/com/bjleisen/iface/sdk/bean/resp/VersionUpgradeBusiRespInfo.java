package com.bjleisen.iface.sdk.bean.resp;
/* loaded from: classes.dex */
public class VersionUpgradeBusiRespInfo extends BaseBusiRespInfo {
    private String appUrl;
    private String newAppVersion;
    private String upgradeContent;
    private int upgradeFlag;

    public String getAppUrl() {
        return this.appUrl;
    }

    public String getNewAppVersion() {
        return this.newAppVersion;
    }

    public String getUpgradeContent() {
        return this.upgradeContent;
    }

    public int getUpgradeFlag() {
        return this.upgradeFlag;
    }

    public void setAppUrl(String str) {
        this.appUrl = str;
    }

    public void setNewAppVersion(String str) {
        this.newAppVersion = str;
    }

    public void setUpgradeContent(String str) {
        this.upgradeContent = str;
    }

    public void setUpgradeFlag(int i10) {
        this.upgradeFlag = i10;
    }
}
