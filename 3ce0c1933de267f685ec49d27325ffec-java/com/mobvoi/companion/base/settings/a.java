package com.mobvoi.companion.base.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.util.WatchInfoUtils;
/* compiled from: BaseCompanionSetting.java */
/* loaded from: classes2.dex */
public class a {
    public static final String ADD_BUS_CARD = "add_bus_card";
    public static final String BUS_CARD_AID = "bus_card_aid";
    public static final String DEVELOP_MODE = "develop_mode";
    public static final String SP_NAME = "settings";
    public static final String TEST_MODE = "test.mode";
    public static final String WEAR3_OVERSEA_PKG = "com.mobvoi.companion.at";
    private static int mVersionCode = 0;
    private static String mVersionName = "";
    private static boolean sBuildIsDebug = false;
    private static boolean sIsOversea = false;

    public static String getCountryUnits(Context context) {
        return getPref(context).getString("country_units", "");
    }

    public static String getDateFormat(Context context) {
        return getPref(context).getString("dateformat", SettingConstants.DATE_FORMAT_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static SharedPreferences getPref(Context context) {
        return context.getSharedPreferences("settings", 0);
    }

    public static int getStatusBarHeight(Context context) {
        return getPref(context).getInt("StatusBarHeight", -1);
    }

    public static String getSyncBusCardAid() {
        return getPref(b.e()).getString(BUS_CARD_AID, "");
    }

    public static String getTempUnit(Context context) {
        return getPref(context).getString(SettingConstants.TEMPERATURE, sIsOversea ? "fahrenheit" : "celsius");
    }

    public static String getUnit(Context context) {
        return getPref(context).getString("units", WatchInfoUtils.getDefaultDistanceUnit(context));
    }

    public static int getVersionCode() {
        return mVersionCode;
    }

    public static String getVersionName() {
        return mVersionName;
    }

    public static boolean isDevelopMode(Context context) {
        return getPref(context).getBoolean(DEVELOP_MODE, sBuildIsDebug);
    }

    public static boolean isOversea() {
        return sIsOversea;
    }

    public static boolean isTempCelsius(Context context) {
        return "celsius".equals(getPref(context).getString(SettingConstants.TEMPERATURE, sIsOversea ? "fahrenheit" : "celsius"));
    }

    public static boolean isTestMode(Context context) {
        return getPref(context).getBoolean(TEST_MODE, false);
    }

    public static boolean isUnitMetric(Context context) {
        String unit = getUnit(context);
        return TextUtils.isEmpty(unit) || "metric".equals(unit);
    }

    public static boolean isW3Oversea(Context context) {
        return WEAR3_OVERSEA_PKG.equals(context.getPackageName());
    }

    public static boolean needSyncBusCard() {
        return getPref(b.e()).getBoolean(ADD_BUS_CARD, false);
    }

    public static void registerOnSharedPreferenceChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        getPref(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static void resetBusCardStatus() {
        getPref(b.e()).edit().putBoolean(ADD_BUS_CARD, false).apply();
    }

    public static void saveCountryUnits(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = getPref(context).edit();
            edit.putString("country_units", str);
            edit.apply();
        }
    }

    public static void setAddBusCardStatus(String str) {
        getPref(b.e()).edit().putBoolean(ADD_BUS_CARD, true).putString(BUS_CARD_AID, str).apply();
    }

    public static void setBuildIsDebug(boolean z10) {
        sBuildIsDebug = z10;
    }

    public static void setDateFormat(Context context, String str) {
        SharedPreferences.Editor edit = getPref(context).edit();
        edit.putString("dateformat", str);
        edit.apply();
    }

    public static void setDevelopMode(Context context, boolean z10) {
        SharedPreferences.Editor edit = getPref(context).edit();
        edit.putBoolean(DEVELOP_MODE, z10);
        edit.apply();
    }

    public static void setOversea(boolean z10) {
        sIsOversea = z10;
    }

    public static void setStatusBarHeight(Context context, int i10) {
        getPref(context).edit().putInt("StatusBarHeight", i10).apply();
    }

    public static void setTempUnit(Context context, String str) {
        SharedPreferences.Editor edit = getPref(context).edit();
        edit.putString(SettingConstants.TEMPERATURE, str);
        edit.apply();
    }

    public static void setTestMode(Context context, boolean z10) {
        getPref(context).edit().putBoolean(TEST_MODE, z10).apply();
    }

    public static void setUnit(Context context, String str) {
        SharedPreferences.Editor edit = getPref(context).edit();
        edit.putString("units", str);
        edit.apply();
    }

    public static void setVersionCode(int i10) {
        mVersionCode = i10;
    }

    public static void setVersionName(String str) {
        mVersionName = str;
    }

    public static void unregisterOnSharedPreferenceChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        getPref(context).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
