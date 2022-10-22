package com.huawei.hms.ml.camera;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Locale;
import java.util.Objects;
/* loaded from: classes2.dex */
public class CountryCodeBean {
    private static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
    private static final int COUNTRYCODE_SIZE = 2;
    private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    private static final String LOCALE_INFO = "LOCALE_INFO";
    private static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
    private static final String SIM_COUNTRY = "SIM_COUNTRY";
    private static final String SPECIAL_COUNTRYCODE_CN = "cn";
    private static final String SPECIAL_COUNTRYCODE_EU = "eu";
    private static final String SPECIAL_COUNTRYCODE_LA = "la";
    private static final String TAG = "CountryCodeBean";
    private static final String UNKNOWN = "UNKNOWN";
    private static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    private static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    private String countryCode;
    private String countrySource = "UNKNOWN";

    public CountryCodeBean(Context context, boolean z10) {
        this.countryCode = "UNKNOWN";
        init(context, z10);
        this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
    }

    private void checkCodeLenth() {
        String str = this.countryCode;
        if (str == null || str.length() != 2) {
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
        }
    }

    private void getLocaleCountryCode() {
        this.countryCode = getProperty("get", LOCALE_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        this.countrySource = "LOCALE_INFO";
        String str = TAG;
        Log.d(str, "getLocaleCountryCode=" + this.countryCode);
        if (!SPECIAL_COUNTRYCODE_CN.equalsIgnoreCase(this.countryCode)) {
            Log.e(str, "getLocaleCountryCode from system language is not reliable.");
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
        }
    }

    private static String getProperty(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            Log.w(TAG, "reflect class for method has exception.");
            return str4;
        }
        try {
            Class<?> cls = Class.forName(str3);
            return (String) cls.getMethod(str, String.class, String.class).invoke(cls, str2, str4);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            Log.e(TAG, "getProperty catch exception: ", e11);
            return str4;
        }
    }

    private void getSimCountryCode(Context context, boolean z10) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        if (telephonyManager != null) {
            if (!z10 || telephonyManager.getPhoneType() == 2) {
                this.countryCode = telephonyManager.getSimCountryIso();
                this.countrySource = "SIM_COUNTRY";
                String str = TAG;
                Log.e(str, "getSimCountryCode by not enableNetwork, countryCode=" + this.countryCode);
            } else {
                this.countryCode = telephonyManager.getNetworkCountryIso();
                this.countrySource = "NETWORK_COUNTRY";
                String str2 = TAG;
                Log.e(str2, "getSimCountryCode by enableNetwork, countryCode=" + this.countryCode);
            }
        }
        checkCodeLenth();
    }

    private void getVendorCountryCode() {
        this.countrySource = "VENDOR_COUNTRY";
        this.countryCode = getProperty("get", VENDORCOUNTRY_SYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        String str = TAG;
        Log.e(str, "getVendorCountry=" + this.countryCode);
        if (SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(this.countryCode) || SPECIAL_COUNTRYCODE_LA.equalsIgnoreCase(this.countryCode)) {
            Log.e(str, "getVendorCountry equals eu or la ,not reliable");
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
            return;
        }
        checkCodeLenth();
    }

    private void init(Context context, boolean z10) {
        Objects.requireNonNull(context, "context must be not null.Please provide app's Context");
        try {
            getVendorCountryCode();
            if (isCodeValidate()) {
                Log.d(TAG, "getCountryCode get country code from {%s}VENDOR_COUNTRY");
                return;
            }
            getSimCountryCode(context, z10);
            if (isCodeValidate()) {
                Log.d(TAG, "getCountryCode get country code from {%s}SIM_COUNTRY");
                return;
            }
            getLocaleCountryCode();
            if (isCodeValidate()) {
                Log.d(TAG, "getCountryCode get country code from {%s}LOCALE_INFO");
            }
        } catch (Exception unused) {
            Log.w(TAG, "get CountryCode error");
        }
    }

    private boolean isCodeValidate() {
        return !"UNKNOWN".equals(this.countryCode);
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountrySource() {
        return this.countrySource;
    }
}
