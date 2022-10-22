package com.mobvoi.wear.util;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u9.b;
/* loaded from: classes2.dex */
public class WatchInfoUtils {
    private static final Locale MM = new Locale("my", "MM");

    private WatchInfoUtils() {
    }

    public static int compareVersionName(String str, String str2) {
        String str3 = "";
        if (str == null) {
            str = str3;
        }
        if (str2 == null) {
            str2 = str3;
        }
        Pattern compile = Pattern.compile("^([Tt]ic_)?(\\d+(\\.\\d+){2,3})(_intl)?(_[ab]\\d+)?$");
        Matcher matcher = compile.matcher(str);
        String group = matcher.find() ? matcher.group(2) : str3;
        Matcher matcher2 = compile.matcher(str2);
        if (matcher2.find()) {
            str3 = matcher2.group(2);
        }
        return versionCompare(group, str3);
    }

    public static String getDefaultDistanceUnit(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return (Locale.US.equals(locale) || MM.equals(locale)) ? "imperial" : "metric";
    }

    public static String getDefaultTempUnit(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return (locale.equals(Locale.US) || "bz".equals(locale.getCountry().toLowerCase())) ? "fahrenheit" : "celsius";
    }

    public static int getDndCallFilter(Context context) {
        if (isDndMode(context)) {
            return getDndScheduleFilter(context);
        }
        return -1;
    }

    public static int getDndScheduleFilter(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Constants.DND.KEY_SCHEDULED_DND_FILTER, 1);
    }

    public static String getRegion() {
        String a10 = b.a(Constants.Setting.TIC_VERSION_REGION, null);
        if (TextUtils.isEmpty(a10)) {
            a10 = b.a(Constants.Setting.TIC_VERSION_REGION_OLD, null);
        }
        return TextUtils.isEmpty(a10) ? "zh-CN".equals(b.a("ro.product.locale", null)) ? Constants.Setting.CHINA_REGION : Constants.Setting.GLOBAL_REGION : a10;
    }

    public static String getSuperPowerSaveModeReason(Context context) {
        return Settings.Global.getString(context.getContentResolver(), Constants.Setting.SUPER_POWER_SAVE_MODE_REASON);
    }

    public static int getVersionType(String str, boolean z10) {
        if (str.equals("Tic_4.0_master")) {
            return 2;
        }
        if (z10) {
            if (Pattern.compile("^Tic_\\d+(\\.\\d+){2,3}_intl_a\\d+$").matcher(str).matches()) {
                return 2;
            }
            return Pattern.compile("^Tic_\\d+(\\.\\d+){2,3}_intl").matcher(str).matches() ? 0 : 3;
        } else if (Pattern.compile("^tic_\\d+(\\.\\d+){2,3}_b\\d+$").matcher(str).matches()) {
            return 1;
        } else {
            if (Pattern.compile("^tic_\\d+(\\.\\d+){2,3}_a\\d+$").matcher(str).matches()) {
                return 2;
            }
            return Pattern.compile("^tic_\\d+(\\.\\d+){2,3}$").matcher(str).matches() ? 0 : 3;
        }
    }

    private static int[] getVersions(String str) {
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i10 = 0; i10 < split.length; i10++) {
            try {
                iArr[i10] = Integer.parseInt(split[i10]);
            } catch (NumberFormatException unused) {
                iArr[i10] = 0;
            }
        }
        return iArr;
    }

    public static String getVoiceServiceKey(Context context) {
        String string = Settings.Global.getString(context.getContentResolver(), "voice_service_key");
        return TextUtils.isEmpty(string) ? isGlobalVersion() ? "com.mobvoi.rom.global" : "com.mobvoi.rom" : string;
    }

    public static String getWatchBrand() {
        return b.a("ro.product.watch_brand", TicwatchModels.TICWATCH1);
    }

    public static boolean hasCreditCardBind(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), Constants.Setting.CREDIT_CARD_ENABLED, 0) == 1;
    }

    public static boolean isBleVoiceSupported(Context context) {
        return isIosPaired(context) && !isMfiSupported(context);
    }

    public static boolean isCTATestVersion() {
        return b.b("ro.config.isctv", false);
    }

    public static boolean isDeviceProvisioned(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) != 0;
    }

    public static boolean isDndMode(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Constants.DND.DND_MODE, 0) != 0;
    }

    public static boolean isGlobalVersion() {
        return isGlobalVersion(getRegion());
    }

    public static boolean isGoldWatch(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Constants.Setting.KEY_IS_GOLD_WATCH, 0) == 1 || Settings.Global.getInt(context.getContentResolver(), Constants.Setting.KEY_SUPPORT_MFI, 0) == 1;
    }

    public static boolean isIosPaired(Context context) {
        return SharedWearInfoHelper.getInstance(context).getPairedPlatform() == 2;
    }

    public static boolean isMfiSupported(Context context) {
        return false;
    }

    public static boolean isPowerSaveMode(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Constants.Setting.SUPER_POWER_SAVE_MODE, 0) != 0;
    }

    public static boolean isSuperPowerSaveMode(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Constants.Setting.SUPER_POWER_SAVE_MODE, 0) == 1;
    }

    public static boolean isSystemLoadingFinished(Context context) {
        try {
            return context.getPackageManager().getComponentEnabledSetting(new ComponentName("com.mobvoi.ticwear.setup", "com.mobvoi.ticwear.setup.MainActivity")) == 2;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isTWVoiceService(Context context) {
        return "com.mobvoi.rom.taiwan".equals(getVoiceServiceKey(context));
    }

    public static boolean isTicwearCompanion(String str) {
        return Pattern.compile("^([Tt]ic_)(\\d+(\\.\\d+){2,3})(_intl)?(_[ab]\\d+)?$").matcher(str).find();
    }

    public static boolean isTicwearSystem() {
        return !b.a(Constants.Setting.TIC_VERSION_NAME, "").isEmpty();
    }

    public static boolean isUpgradeAvailable(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Constants.Setting.UPGRADE_AVAILABLE, 0) == 1;
    }

    public static boolean isWristMode(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Constants.Setting.SUPER_POWER_SAVE_MODE, 0) == 2;
    }

    public static void setDndMode(Context context, boolean z10) {
        if (z10 != isDndMode(context)) {
            Settings.Global.putInt(context.getContentResolver(), Constants.DND.DND_MODE, z10 ? 1 : 0);
        }
    }

    public static void setDndScheduleFilter(Context context, int i10) {
        Settings.Global.putInt(context.getContentResolver(), Constants.DND.KEY_SCHEDULED_DND_FILTER, i10);
    }

    public static void setSuperPowerSaveModeReason(Context context, String str) {
        Settings.Global.putString(context.getContentResolver(), Constants.Setting.SUPER_POWER_SAVE_MODE_REASON, str);
    }

    public static void setVoiceServiceKey(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Settings.Global.putString(context.getContentResolver(), "voice_service_key", str);
            context.getContentResolver().notifyChange(Settings.Global.getUriFor("voice_service_key"), null);
        }
    }

    public static void updateCreditCardStatus(Context context, boolean z10) {
        Settings.Secure.putInt(context.getContentResolver(), Constants.Setting.CREDIT_CARD_ENABLED, z10 ? 1 : 0);
    }

    private static int versionCompare(String str, String str2) {
        int[] versions = getVersions(str);
        int[] versions2 = getVersions(str2);
        int max = Math.max(versions.length, versions2.length);
        int i10 = 0;
        while (i10 < max) {
            int i11 = i10 < versions.length ? versions[i10] : 0;
            int i12 = i10 < versions2.length ? versions2[i10] : 0;
            if (i11 < i12) {
                return -1;
            }
            if (i11 > i12) {
                return 1;
            }
            i10++;
        }
        return 0;
    }

    public static boolean isGlobalVersion(Context context) {
        return isGlobalVersion(getRegion(context));
    }

    public static boolean isGlobalVersion(String str) {
        return Constants.Setting.GLOBAL_REGION.equals(str);
    }

    public static String getRegion(Context context) {
        if (!isTicwearSystem()) {
            return AwUtils.isAwLe(context) ? Constants.Setting.CHINA_REGION : Constants.Setting.GLOBAL_REGION;
        }
        String a10 = b.a(Constants.Setting.TIC_VERSION_REGION, null);
        if (TextUtils.isEmpty(a10)) {
            a10 = b.a(Constants.Setting.TIC_VERSION_REGION_OLD, null);
        }
        return TextUtils.isEmpty(a10) ? Constants.Setting.CHINA_REGION : a10;
    }

    public static int getVersionType(String str) {
        return getVersionType(str, isGlobalVersion());
    }
}
