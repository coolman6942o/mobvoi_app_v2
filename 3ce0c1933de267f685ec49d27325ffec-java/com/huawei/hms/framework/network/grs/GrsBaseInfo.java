package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class GrsBaseInfo implements Cloneable {
    private static final String TAG = "GrsBaseInfo";
    private String androidVersion;
    private String appName;
    private String countrySource;
    private String deviceModel;
    private String issueCountry;
    private String regCountry;
    private String romVersion;
    private String serCountry;
    private String uid;
    private String versionName;

    /* loaded from: classes.dex */
    public @interface CountryCodeSource {
        public static final String APP = "APP";
        public static final String LOCALE_INFO = "LOCALE_INFO";
        public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
        public static final String SIM_COUNTRY = "SIM_COUNTRY";
        public static final String UNKNOWN = "UNKNOWN";
        public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    }

    public GrsBaseInfo() {
    }

    public GrsBaseInfo(Context context) {
        this.issueCountry = GrsApp.getInstance().getIssueCountryCode(context);
    }

    private StringBuffer getStringBuffer(StringBuffer stringBuffer, boolean z10, Context context) {
        String androidVersion = getAndroidVersion();
        if (!TextUtils.isEmpty(androidVersion)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("android_version");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(androidVersion);
        }
        String romVersion = getRomVersion();
        if (!TextUtils.isEmpty(romVersion)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("rom_version");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(romVersion);
        }
        String deviceModel = getDeviceModel();
        if (!TextUtils.isEmpty(deviceModel)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("device_model");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(deviceModel);
        }
        String b10 = new c(context).b();
        if (!TextUtils.isEmpty(b10) && !z10) {
            try {
                String encode = URLEncoder.encode(b10, "UTF-8");
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                }
                stringBuffer.append("cp");
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(encode);
            } catch (UnsupportedEncodingException e10) {
                Logger.e(TAG, "cp UnsupportedEncodingException.", e10);
            }
        }
        String countrySource = getCountrySource();
        if (!TextUtils.isEmpty(countrySource)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("country_source");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(countrySource);
        }
        return stringBuffer;
    }

    private boolean isEqual(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return (str == null || str2 == null || !str.equals(str2)) ? false : true;
    }

    public GrsBaseInfo clone() {
        return (GrsBaseInfo) super.clone();
    }

    public boolean compare(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof GrsBaseInfo)) {
            return false;
        }
        GrsBaseInfo grsBaseInfo = (GrsBaseInfo) obj;
        return isEqual(this.serCountry, grsBaseInfo.serCountry) && isEqual(this.versionName, grsBaseInfo.versionName) && isEqual(this.appName, grsBaseInfo.appName) && isEqual(this.uid, grsBaseInfo.uid) && isEqual(this.regCountry, grsBaseInfo.regCountry) && isEqual(this.issueCountry, grsBaseInfo.issueCountry) && isEqual(this.androidVersion, grsBaseInfo.androidVersion) && isEqual(this.romVersion, grsBaseInfo.romVersion) && isEqual(this.deviceModel, grsBaseInfo.deviceModel) && isEqual(this.countrySource, grsBaseInfo.countrySource);
    }

    public GrsBaseInfo copy() {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setAppName(this.appName);
        grsBaseInfo.setSerCountry(this.serCountry);
        grsBaseInfo.setRegCountry(this.regCountry);
        grsBaseInfo.setIssueCountry(this.issueCountry);
        grsBaseInfo.setCountrySource(this.countrySource);
        grsBaseInfo.setAndroidVersion(this.androidVersion);
        grsBaseInfo.setDeviceModel(this.deviceModel);
        grsBaseInfo.setRomVersion(this.romVersion);
        grsBaseInfo.setUid(this.uid);
        grsBaseInfo.setVersionName(this.versionName);
        return grsBaseInfo;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getGrsParasKey(boolean z10, boolean z11, Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        b a10 = b.a(context.getPackageName(), this);
        a a11 = a10 != null ? a10.a() : null;
        String a12 = a11 != null ? a11.a() : "";
        String appName = getAppName();
        if (!TextUtils.isEmpty(appName) && TextUtils.isEmpty(a12)) {
            stringBuffer.append("app_name");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(appName);
        }
        String grsReqParamJoint = getGrsReqParamJoint(z10, z11, a12, context);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append(grsReqParamJoint);
        }
        return stringBuffer.toString();
    }

    public String getGrsParasTag(boolean z10, boolean z11, Context context) {
        return getGrsParasKey(z10, z11, context);
    }

    public String getGrsReqParamJoint(boolean z10, boolean z11, String str, Context context) {
        String a10;
        StringBuffer stringBuffer = new StringBuffer();
        if ("1.0".equals(str)) {
            Logger.v(TAG, "1.0 interface has no query param appname");
        } else {
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("app_name");
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            } else if (!TextUtils.isEmpty(getAppName())) {
                stringBuffer.append("app_name");
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                str = getAppName();
            }
            stringBuffer.append(str);
        }
        String versionName = getVersionName();
        if (!TextUtils.isEmpty(versionName)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("app_version");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(versionName);
        }
        String uid = getUid();
        if (!TextUtils.isEmpty(uid)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("uid");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            if (z10) {
                a10 = com.huawei.hms.framework.network.grs.d.b.b(uid);
            } else if (z11) {
                a10 = com.huawei.hms.framework.network.grs.d.b.a(uid);
            } else {
                stringBuffer.append(uid);
            }
            stringBuffer.append(a10);
        }
        String regCountry = getRegCountry();
        if (!TextUtils.isEmpty(regCountry) && !CountryCodeSource.UNKNOWN.equals(regCountry)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("reg_country");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(regCountry);
        }
        String serCountry = getSerCountry();
        if (!TextUtils.isEmpty(serCountry) && !CountryCodeSource.UNKNOWN.equals(serCountry)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("ser_country");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(serCountry);
        }
        String issueCountry = getIssueCountry();
        if (!TextUtils.isEmpty(issueCountry) && !CountryCodeSource.UNKNOWN.equals(issueCountry)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("issue_country");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(issueCountry);
        }
        return getStringBuffer(stringBuffer, z11, context).toString();
    }

    public String getIssueCountry() {
        return this.issueCountry;
    }

    public String getRegCountry() {
        return this.regCountry;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public String getSerCountry() {
        return this.serCountry;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAndroidVersion(String str) {
        this.androidVersion = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCountrySource(String str) {
        this.countrySource = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    @Deprecated
    public void setIssueCountry(String str) {
        this.issueCountry = str;
    }

    public void setRegCountry(String str) {
        this.regCountry = str;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public void setSerCountry(String str) {
        this.serCountry = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public int uniqueCode() {
        return (this.appName + "#" + this.serCountry + "#" + this.regCountry + "#" + this.issueCountry).hashCode();
    }
}
