package com.mobvoi.wear.info;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CompanionInfoUtil implements Serializable {
    private AccountInfoHelper mAccountHelper;
    private SharedWearInfoHelper mHelper;

    public CompanionInfoUtil(Context context) {
        this.mHelper = SharedWearInfoHelper.getInstance(context);
        this.mAccountHelper = AccountInfoHelper.getInstance(context);
    }

    public String getAccountId() {
        return this.mAccountHelper.getAccountId();
    }

    public String getBirthday() {
        return this.mAccountHelper.getUserBirthday();
    }

    public String getCapabilities() {
        return this.mHelper.getCompanionCapabilities();
    }

    public CompanionInfo getCompanionInfo() {
        CompanionInfo companionInfo = new CompanionInfo();
        companionInfo.accountId = getAccountId();
        companionInfo.sex = getSex();
        companionInfo.phoneNumber = getPhoneNumber();
        companionInfo.nickName = getNickName();
        companionInfo.deviceId = getDeviceId();
        companionInfo.model = getModel();
        companionInfo.versionCode = getVersionCode();
        companionInfo.versionName = getVersionName();
        companionInfo.sessionId = getSessionId();
        companionInfo.wwid = getWwid();
        companionInfo.height = getHeight();
        companionInfo.weight = getWeight();
        companionInfo.birthday = getBirthday();
        companionInfo.headUrl = getHeadUrl();
        companionInfo.capabilities = getCapabilities();
        companionInfo.isVpa = this.mHelper.isVpa();
        return companionInfo;
    }

    public String getDeviceId() {
        return this.mHelper.getPhoneDeviceId();
    }

    public String getHeadUrl() {
        return this.mAccountHelper.getHeadUrl();
    }

    public String getHeight() {
        return this.mAccountHelper.getUserHeight();
    }

    public String getModel() {
        return this.mHelper.getPhoneModel();
    }

    public String getNickName() {
        return this.mAccountHelper.getNickName();
    }

    public String getPhoneNumber() {
        return this.mAccountHelper.getPhoneNumber();
    }

    public String getSessionId() {
        return this.mAccountHelper.getSessionId();
    }

    public String getSex() {
        return this.mAccountHelper.getUserSex();
    }

    public String getVersionCode() {
        return this.mHelper.getCompanionVersionCode();
    }

    public String getVersionName() {
        return this.mHelper.getCompanionVersionName();
    }

    public String getWeight() {
        return this.mAccountHelper.getUserWeight();
    }

    public String getWwid() {
        return this.mAccountHelper.getWwid();
    }

    public void setAccountId(String str) {
        this.mAccountHelper.setAccountId(str);
    }

    public void setBirthday(String str) {
        this.mAccountHelper.setUserBirthday(str);
    }

    public void setCapabilities(String str) {
        this.mHelper.setCompanionCapabilities(str);
    }

    public void setCompanionInfo(CompanionInfo companionInfo) {
        this.mAccountHelper.updateAccountInfo(companionInfo);
        setDeviceId(companionInfo.deviceId);
        setModel(companionInfo.model);
        setVersionCode(companionInfo.versionCode);
        setVersionName(companionInfo.versionName);
        setCapabilities(companionInfo.capabilities);
        this.mHelper.setIsVpa(companionInfo.isVpa);
    }

    public void setDeviceId(String str) {
        this.mHelper.setPhoneDeviceId(str);
    }

    public void setHeadUrl(String str) {
        this.mAccountHelper.setHeadUrl(str);
    }

    public void setHeight(String str) {
        AccountInfoHelper accountInfoHelper = this.mAccountHelper;
        if (str == null) {
            str = "";
        }
        accountInfoHelper.setUserHeight(str);
    }

    public void setModel(String str) {
        this.mHelper.setPhoneModel(str);
    }

    public void setNickName(String str) {
        this.mAccountHelper.setNickName(str);
    }

    public void setPhoneNumber(String str) {
        this.mAccountHelper.setPhoneNumber(str);
    }

    public void setSessionId(String str) {
        AccountInfoHelper accountInfoHelper = this.mAccountHelper;
        if (str == null) {
            str = "";
        }
        accountInfoHelper.setSessionId(str);
    }

    public void setSex(String str) {
        this.mAccountHelper.setUserSex(str);
    }

    public void setVersionCode(String str) {
        this.mHelper.setCompanionVersionCode(str);
    }

    public void setVersionName(String str) {
        this.mHelper.setCompanionVersionName(str);
    }

    public void setWeight(String str) {
        AccountInfoHelper accountInfoHelper = this.mAccountHelper;
        if (str == null) {
            str = "";
        }
        accountInfoHelper.setUserWeight(str);
    }

    public void setWwid(String str) {
        AccountInfoHelper accountInfoHelper = this.mAccountHelper;
        if (str == null) {
            str = "";
        }
        accountInfoHelper.setWwid(str);
    }
}
