package com.mobvoi.wear.info;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.android.common.provider.b;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* loaded from: classes2.dex */
public class AccountInfoHelper extends b {
    private static final String ACCOUNT_INFO_AUTHORITY = "com.mobvoi.wear.provider.accountInfo";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile AccountInfoHelper sInstance;
    private String mTableName;

    /* loaded from: classes2.dex */
    public interface AccountInfo {
        public static final String KEY_ACCOUNT_ID = "account_id";
        public static final String KEY_CAREER = "career";
        public static final String KEY_COMPANY = "company";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_HEAD_URL = "head_url";
        public static final String KEY_HOME = "home";
        public static final String KEY_NICK_NAME = "nick_name";
        public static final String KEY_NOT_REMIND_LOGIN = "not_remind_login";
        public static final String KEY_PHONE_NUMBER = "phone_number";
        public static final String KEY_SESSION_ID = "session_id";
        public static final String KEY_USER_BIRTHDAY = "user_birthday";
        public static final String KEY_USER_HEIGHT = "user_height";
        public static final String KEY_USER_SEX = "user_sex";
        public static final String KEY_USER_WEIGHT = "user_weight";
        public static final String KEY_WWID = "wwid";
        public static final String TABLE = "account";
        public static final String VAL_SEX_FEMALE = "FEMALE";
        public static final String VAL_SEX_MALE = "MALE";
    }

    private AccountInfoHelper(Context context) {
        super(context, selectAuthority(context));
        if (this.mAuthority.equals(ACCOUNT_INFO_AUTHORITY)) {
            this.mTableName = "account";
        } else {
            this.mTableName = SharedWearInfoHelper.PhoneInfo.TABLE;
        }
    }

    public static AccountInfoHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AccountInfoHelper.class) {
                if (sInstance == null) {
                    sInstance = new AccountInfoHelper(context);
                }
            }
        }
        return sInstance;
    }

    public static boolean isAccountInfoProviderExist(Context context) {
        return b.isProviderExist(context, ACCOUNT_INFO_AUTHORITY);
    }

    private static String selectAuthority(Context context) {
        return isAccountInfoProviderExist(context) ? ACCOUNT_INFO_AUTHORITY : "com.mobvoi.wear.provider.info";
    }

    public static boolean supportAccountInfo(Context context) {
        return isAccountInfoProviderExist(context) || SharedWearInfoHelper.isInfoProviderExist(context);
    }

    public void clearAccountInfo() {
        setWwid("");
        setAccountId("");
        setNickName("");
        setHeadUrl("");
        setUserSex("");
        setUserHeight("");
        setUserWeight("");
        setUserBirthday("");
        setPhoneNumber("");
        setSessionId("");
        setEmail("");
        setCareer("");
        setHome("");
        setCompany("");
    }

    public String getAccount() {
        String phoneNumber = getPhoneNumber();
        if (!TextUtils.isEmpty(phoneNumber)) {
            return phoneNumber;
        }
        String email = getEmail();
        return !TextUtils.isEmpty(email) ? email : "";
    }

    public String getAccountId() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_ACCOUNT_ID, null);
    }

    public String getCareer() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_CAREER, null);
    }

    public String getCompany() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_COMPANY, null);
    }

    public String getEmail() {
        return this.mInfoClient.f(getTableName(), "email", null);
    }

    public String getHeadUrl() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_HEAD_URL, null);
    }

    public String getHome() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_HOME, null);
    }

    public String getNickName() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_NICK_NAME, null);
    }

    public boolean getNotRemindLogin() {
        return this.mInfoClient.a(getTableName(), AccountInfo.KEY_NOT_REMIND_LOGIN, false);
    }

    public String getPhoneNumber() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_PHONE_NUMBER, null);
    }

    public String getSessionId() {
        return this.mInfoClient.f(getTableName(), "session_id", null);
    }

    public String getString(String str) {
        return this.mInfoClient.f(getTableName(), str, null);
    }

    public String getTableName() {
        return this.mTableName;
    }

    public String getUserBirthday() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_USER_BIRTHDAY, null);
    }

    public String getUserHeight() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_USER_HEIGHT, null);
    }

    public String getUserSex() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_USER_SEX, null);
    }

    public String getUserWeight() {
        return this.mInfoClient.f(getTableName(), AccountInfo.KEY_USER_WEIGHT, null);
    }

    public String getWwid() {
        return this.mInfoClient.f(getTableName(), "wwid", null);
    }

    public boolean isLoggedIn() {
        return !TextUtils.isEmpty(getWwid()) || !TextUtils.isEmpty(getAccountId());
    }

    public void setAccountId(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_ACCOUNT_ID, str);
    }

    public void setCareer(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_CAREER, str);
    }

    public void setCompany(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_COMPANY, str);
    }

    public void setEmail(String str) {
        this.mInfoClient.n(getTableName(), "email", str);
    }

    public void setHeadUrl(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_HEAD_URL, str);
    }

    public void setHome(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_HOME, str);
    }

    public void setNickName(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_NICK_NAME, str);
    }

    public void setNotRemindLogin(boolean z10) {
        this.mInfoClient.i(getTableName(), AccountInfo.KEY_NOT_REMIND_LOGIN, z10);
    }

    public void setPhoneNumber(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_PHONE_NUMBER, str);
    }

    public void setSessionId(String str) {
        this.mInfoClient.n(getTableName(), "session_id", str);
    }

    public void setUserBirthday(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_USER_BIRTHDAY, str);
    }

    public void setUserHeight(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_USER_HEIGHT, str);
    }

    public void setUserSex(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_USER_SEX, str);
    }

    public void setUserWeight(String str) {
        this.mInfoClient.n(getTableName(), AccountInfo.KEY_USER_WEIGHT, str);
    }

    public void setWwid(String str) {
        this.mInfoClient.n(getTableName(), "wwid", str);
    }

    public void updateAccountInfo(CompanionInfo companionInfo) {
        setWwid(companionInfo.wwid);
        setAccountId(companionInfo.accountId);
        setNickName(companionInfo.nickName);
        setHeadUrl(companionInfo.headUrl);
        setUserSex(companionInfo.sex);
        setUserHeight(companionInfo.height);
        setUserWeight(companionInfo.weight);
        setUserBirthday(companionInfo.birthday);
        setPhoneNumber(companionInfo.phoneNumber);
        setEmail(companionInfo.email);
        setSessionId(companionInfo.sessionId);
        setCareer("");
        setHome("");
        setCompany("");
    }
}
