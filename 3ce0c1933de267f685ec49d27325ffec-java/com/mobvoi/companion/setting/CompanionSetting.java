package com.mobvoi.companion.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.info.WearInfo;
/* loaded from: classes2.dex */
public class CompanionSetting extends a {
    public static final String APPKEY = "com.mobvoi.rom";
    private static final String ARTY_AUTHORIZE_STATUS = "arty_authorize_status";
    public static final String ARTY_GUIDE_PAGE_SHOW_FINISH = "arty_guide_page_show_finish";
    private static final String ARTY_JWT = "arty_jwt";
    private static final String BIND_WECHAT_CONFIG = "bind_wechat_config";
    private static final String BLUETOOTH_DEVICE_ADDRESS = "bluetooth_device_address";
    public static final String BLUETOOTH_DEVICE_NAME = "bluetooth_device_name";
    public static final String CROWN_TYPE = "crown_type";
    public static final String FIRST_NAME = "fist";
    public static final String GLOBAL_APPKEY = "com.mobvoi.rom.global";
    public static final String GLOBAL_TW_APPKEY = "com.mobvoi.rom.taiwan";
    public static final String HAND_TYPE = "hand_type";
    public static final String HAS_SEND_HAND_TYPE = "has_send_hand_type";
    private static final String HAS_SHOWN_MIUI_WARNING = "has_shown_miui_warning";
    private static final String HEALTH_CHECK_KEY = "health_check_key";
    public static final String HOTWORD_TYPE = "hotword_type";
    public static final String IS_DUAL_CARD = "isDualCard";
    public static final String IS_MFI_SUPPORT = "is_mfi_support";
    public static final String KEY_ESIM_CARD_TIP = "esim_card_tip";
    private static final String KEY_HAS_SET_RESTORE_BACKUP = "has_set_restore_backup";
    public static final String KEY_HAVE_4G = "have_4g";
    private static final String KEY_IS_RESTORE_BACKUP = "is_restore_backup";
    private static final String KEY_LAST_LOCATION_TIME = "last_location_time";
    private static final String KEY_MAGIC_CITY_LIST = "magic_city_list";
    private static final String KEY_MAGIC_DIDI_PHONE = "magic_didi_phone";
    private static final String KEY_MAGIC_UBER_BIND = "magic_uber_bind";
    private static final String KEY_OPERATION_BANNER_LAST_TIME = "opreation_banner_last_time";
    private static final String KEY_OPERATION_BANNER_LIST = "opreation_banner_list";
    private static final String KEY_OPERATION_FIRST_OPEN = "opreation_first_open";
    private static final String KEY_OPERATION_POP_LIST = "opreation_pop_list";
    public static final String KEY_POPUP_LIST = "popup_list";
    private static final String KEY_SHOWNED_AD_LIST = "showned_ad_list";
    public static final String KEY_TICPAY_PLATFORM = "ticpay_platform";
    private static final String KEY_TICWARCH_CHANNEL = "ticwatch_channel";
    private static final String KEY_WEAR_CAPABILITIES = "wear_capabilities";
    private static final String KEY_WEAR_CHANNEL = "wear_channel";
    private static final String KEY_WEAR_DEVICE_TYPE = "wear_device_type";
    public static final String KEY_WEAR_HAS_NFC_FEATURE = "wear_has_nfc_feature";
    private static final String KEY_WEAR_VERSION = "wear_version";
    public static final String KEY_WEAR_VERSION_NUMBER = "wear_version_number";
    public static final String KEY_WEAR_VERSION_REGION = "wear_version_region";
    private static final String LAST_LOCATION = "last_location";
    public static final String NOT_REMIND = "notRemind";
    private static final String ONEBOX_SHOW_COUNT = "onebox_show_count";
    public static final String PAYMENT_METHOD_ALIPAY_NO_PWD = "payment_method_alipay_no_pwd";
    private static final String PUSH_MESSAGE = "push_message";
    public static final String RECORD_NEW_FEARTURE = "record_new_fearture";
    public static final String RED_POINT_STATUS = "red_point_status";
    public static final String SCREENSHORT_NEW_FEARTURE = "screenshot_new_feature";
    private static final String SHOWN_GUIDE_VIDEO = "shown_guide_video";
    public static final String SHOW_ARTY_CARD = "show_arty_card";
    private static final String SHOW_REQUEST_BG_LOC_DIALOG = "show_request_bg_loc_dialog";
    public static final String TICPAY_PLATFORM_APOLLO = "apollo";
    public static final String TICPAY_PLATFORM_WEAROS = "wearos";
    public static final String UNICOM_PROFILE_ENABLE_STATUS = "unicom_profile_enable_status";
    public static final String VOICE_SERVICE_KEY = "voice_service_key";
    public static final String WATCHFACE_NEW_FEARTURE = "watchface_new_fearture";
    public static final String WEAR_DEVICE_ID = "wear_device_id";

    public static void clearPhone(Context context) {
        context.getSharedPreferences("phoneList", 0).edit().clear().apply();
    }

    public static boolean getAliPayNoPwd() {
        return getPref().getBoolean(PAYMENT_METHOD_ALIPAY_NO_PWD, false);
    }

    public static String getAppVoiceKey(Context context, boolean z10) {
        return q.d(context, "settings", "voice_service_key", z10 ? "com.mobvoi.rom.global" : "com.mobvoi.rom");
    }

    public static boolean getArtyGuidePageShowFinished() {
        return getPref().getBoolean(ARTY_GUIDE_PAGE_SHOW_FINISH, false);
    }

    public static String getArtyJsonWebToken() {
        return getPref().getString(ARTY_JWT, "");
    }

    public static long getBannerLastModifyTime() {
        return getPref().getLong(KEY_OPERATION_BANNER_LAST_TIME, 0L);
    }

    public static String getBannerList() {
        return getPref().getString(KEY_OPERATION_BANNER_LIST, "");
    }

    public static String getBindWechatConfig() {
        return getPref().getString(BIND_WECHAT_CONFIG, "");
    }

    public static String getCityList() {
        return getPref().getString(KEY_MAGIC_CITY_LIST, "");
    }

    public static String getCrownType(Context context) {
        return a.getPref(context).getString(CROWN_TYPE, "");
    }

    public static String getDeviceAddress(Context context) {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 == null || TextUtils.isEmpty(e10.btAddress)) {
            return a.getPref(context).getString(BLUETOOTH_DEVICE_ADDRESS, "");
        }
        return e10.btAddress;
    }

    public static String getDeviceName() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.btName;
        }
        return getPref().getString(BLUETOOTH_DEVICE_NAME, "");
    }

    public static String getDidiPhone() {
        return getPref().getString(KEY_MAGIC_DIDI_PHONE, "");
    }

    public static boolean getFirstOpen() {
        return getPref().getBoolean(KEY_OPERATION_FIRST_OPEN, false);
    }

    public static String getHandType(Context context) {
        return a.getPref(context).getString(HAND_TYPE, "");
    }

    public static long getHealthCheckTime() {
        return getPref().getLong(HEALTH_CHECK_KEY, 0L);
    }

    public static String getHotwordType(Context context) {
        return a.getPref(context).getString(HOTWORD_TYPE, "");
    }

    public static int getIsDualCard(Context context) {
        return context.getSharedPreferences("settings", 0).getInt(IS_DUAL_CARD, -1);
    }

    public static String getLastLocation(Context context) {
        return context.getSharedPreferences("settings", 0).getString(LAST_LOCATION, null);
    }

    public static long getLastLocationTime() {
        return getPref().getLong(KEY_LAST_LOCATION_TIME, 0L);
    }

    public static boolean getNewFeartureShowKey(Context context, String str) {
        return q.a(context, "settings", str, true);
    }

    public static boolean getNotRemind(Context context) {
        return context.getSharedPreferences("settings", 0).getBoolean(NOT_REMIND, false);
    }

    public static int getOneboxCount(Context context) {
        return context.getSharedPreferences("settings", 0).getInt(ONEBOX_SHOW_COUNT, 2);
    }

    public static String getOperationPopList() {
        return getPref().getString(KEY_OPERATION_POP_LIST, "");
    }

    public static String getPhone(Context context) {
        return context.getSharedPreferences("phoneList", 0).getString(SharedWearInfoHelper.PhoneInfo.TABLE, "");
    }

    public static String getPopUpList() {
        return getPref().getString(KEY_POPUP_LIST, "");
    }

    private static SharedPreferences getPref() {
        return a.getPref(b.e());
    }

    public static boolean getRedPointStatus() {
        return getPref().getBoolean(RED_POINT_STATUS, true);
    }

    public static String getShownedPopList() {
        return getPref().getString(KEY_SHOWNED_AD_LIST, null);
    }

    public static String getTicpayPlatform() {
        return getPref().getString(KEY_TICPAY_PLATFORM, TICPAY_PLATFORM_WEAROS);
    }

    public static String getTicwatchChannel() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.ticwatchChannel;
        }
        return b.e().getSharedPreferences("settings", 0).getString(KEY_TICWARCH_CHANNEL, "");
    }

    public static boolean getUberBind() {
        return getPref().getBoolean(KEY_MAGIC_UBER_BIND, false);
    }

    public static boolean getUnicomProfileEnableStatus() {
        return getPref().getBoolean(UNICOM_PROFILE_ENABLE_STATUS, false);
    }

    public static String getWearCapabilities() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.wearCapability;
        }
        return getPref().getString("wear_capabilities", "");
    }

    public static String getWearChannel() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.wearChannel;
        }
        return getPref().getString(KEY_WEAR_CHANNEL, "");
    }

    public static String getWearDeviceId(Context context) {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.wearDeviceId;
        }
        return a.getPref(context).getString("wear_device_id", "");
    }

    public static boolean getWearHasNfcFeature() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.hasNfcFeature;
        }
        return getPref().getBoolean(KEY_WEAR_HAS_NFC_FEATURE, false);
    }

    public static String getWearModel() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.wearType;
        }
        return getPref().getString(KEY_WEAR_DEVICE_TYPE, "");
    }

    public static String getWearVersion() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.wearVersion;
        }
        return getPref().getString(KEY_WEAR_VERSION, "");
    }

    public static long getWearVersionNumber() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.wearVersionNumber;
        }
        return getPref().getLong(KEY_WEAR_VERSION_NUMBER, 0L);
    }

    public static String getWearVersionRegion() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return e10.region;
        }
        return getPref().getString(KEY_WEAR_VERSION_REGION, Constants.Setting.CHINA_REGION);
    }

    public static boolean hasSendHandToWear(Context context) {
        return a.getPref(context).getInt(HAS_SEND_HAND_TYPE, 0) == 1;
    }

    public static boolean hasShownGuideVideo(Context context) {
        return a.getPref(context).getInt(SHOWN_GUIDE_VIDEO, 0) == 1;
    }

    public static boolean hasShownMiuiWarning() {
        return getPref().getBoolean(HAS_SHOWN_MIUI_WARNING, false);
    }

    public static boolean isArtyAuthorize() {
        return getPref().getBoolean(ARTY_AUTHORIZE_STATUS, false);
    }

    public static boolean isArtyEnable() {
        return getPref().getBoolean(SHOW_ARTY_CARD, false);
    }

    public static boolean isESIM4g(Context context) {
        return a.getPref(context).getBoolean(KEY_ESIM_CARD_TIP, true);
    }

    public static boolean isFirstSetup(Context context) {
        return a.getPref(context).getInt(FIRST_NAME, 0) != 1;
    }

    public static boolean isHave4g(Context context) {
        return a.getPref(context).getBoolean(KEY_HAVE_4G, false);
    }

    public static boolean needShowRequestBgLocDialog() {
        return getPref().getBoolean(SHOW_REQUEST_BG_LOC_DIALOG, true);
    }

    public static void setAliPayNoPwd(boolean z10) {
        getPref().edit().putBoolean(PAYMENT_METHOD_ALIPAY_NO_PWD, z10).apply();
    }

    public static void setAppVoiceKey(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            q.h(context, "settings", "voice_service_key", str);
        }
    }

    public static void setArtyAuthorizeStatus(boolean z10) {
        getPref().edit().putBoolean(ARTY_AUTHORIZE_STATUS, z10).apply();
    }

    public static void setArtyEnable(boolean z10) {
        getPref().edit().putBoolean(SHOW_ARTY_CARD, z10).apply();
    }

    public static void setArtyGuidePageShowFinish(boolean z10) {
        getPref().edit().putBoolean(ARTY_GUIDE_PAGE_SHOW_FINISH, z10).apply();
    }

    public static void setArtyJsonWebToken(String str) {
        getPref().edit().putString(ARTY_JWT, str).apply();
    }

    public static void setBannerLastModifyTime(long j10) {
        getPref().edit().putLong(KEY_OPERATION_BANNER_LAST_TIME, j10).apply();
    }

    public static void setBannerList(String str) {
        getPref().edit().putString(KEY_OPERATION_BANNER_LIST, str).apply();
    }

    public static void setBindWechatConfig(String str) {
        getPref().edit().putString(BIND_WECHAT_CONFIG, str).apply();
    }

    public static void setCityList(String str) {
        getPref().edit().putString(KEY_MAGIC_CITY_LIST, str).apply();
    }

    public static void setCrownType(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = a.getPref(context).edit();
            edit.putString(CROWN_TYPE, str);
            edit.apply();
        }
    }

    public static void setDeviceAddress(Context context, String str) {
        SharedPreferences.Editor edit = a.getPref(context).edit();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        edit.putString(BLUETOOTH_DEVICE_ADDRESS, str);
        edit.apply();
    }

    public static void setDeviceName(String str) {
        SharedPreferences.Editor edit = getPref().edit();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        edit.putString(BLUETOOTH_DEVICE_NAME, str);
        edit.apply();
    }

    public static void setDidiPhone(String str) {
        getPref().edit().putString(KEY_MAGIC_DIDI_PHONE, str).apply();
    }

    public static void setESIM4g(Context context, boolean z10) {
        SharedPreferences.Editor edit = a.getPref(context).edit();
        edit.putBoolean(KEY_ESIM_CARD_TIP, z10);
        edit.apply();
    }

    public static void setFirstOpen(boolean z10) {
        getPref().edit().putBoolean(KEY_OPERATION_FIRST_OPEN, z10).apply();
    }

    public static void setHandType(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = a.getPref(context).edit();
            edit.putString(HAND_TYPE, str);
            edit.apply();
        }
    }

    public static void setHave4g(Context context, boolean z10) {
        SharedPreferences.Editor edit = a.getPref(context).edit();
        edit.putBoolean(KEY_HAVE_4G, z10);
        edit.apply();
    }

    public static void setHotwordType(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = a.getPref(context).edit();
            edit.putString(HOTWORD_TYPE, str);
            edit.apply();
        }
    }

    public static void setIsDualCard(Context context, int i10) {
        context.getSharedPreferences("settings", 0).edit().putInt(IS_DUAL_CARD, i10).apply();
    }

    public static void setLastLocation(Context context, String str) {
        context.getSharedPreferences("settings", 0).edit().putString(LAST_LOCATION, str).apply();
    }

    public static void setLastLocationTime(long j10) {
        getPref().edit().putLong(KEY_LAST_LOCATION_TIME, j10).apply();
    }

    public static void setNewFeartureShowKey(Context context, String str, boolean z10) {
        if (!TextUtils.isEmpty(str)) {
            q.e(context, "settings", str, z10);
        }
    }

    public static void setNotRemind(Context context, boolean z10) {
        context.getSharedPreferences("settings", 0).edit().putBoolean(NOT_REMIND, z10).apply();
    }

    public static void setNotStarted(Context context) {
        SharedPreferences.Editor edit = a.getPref(context).edit();
        edit.putInt(FIRST_NAME, 0);
        edit.apply();
    }

    public static void setOneboxCount(Context context, int i10) {
        SharedPreferences.Editor edit = context.getSharedPreferences("settings", 0).edit();
        edit.putInt(ONEBOX_SHOW_COUNT, i10);
        edit.apply();
    }

    public static void setOperationPopList(String str) {
        getPref().edit().putString(KEY_OPERATION_POP_LIST, str).apply();
    }

    public static void setPhone(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("phoneList", 0).edit();
        edit.putString(SharedWearInfoHelper.PhoneInfo.TABLE, str);
        edit.apply();
    }

    public static void setPopUplist(String str) {
        getPref().edit().putString(KEY_POPUP_LIST, str).apply();
    }

    public static void setRedPointStatus(boolean z10) {
        getPref().edit().putBoolean(RED_POINT_STATUS, z10).apply();
    }

    public static void setSendHandToWear(Context context) {
        SharedPreferences.Editor edit = a.getPref(context).edit();
        edit.putInt(HAS_SEND_HAND_TYPE, 1);
        edit.apply();
    }

    public static void setShowRequestBgLocDialog(boolean z10) {
        getPref().edit().putBoolean(SHOW_REQUEST_BG_LOC_DIALOG, z10).apply();
    }

    public static void setShownGuideVideo(Context context) {
        SharedPreferences.Editor edit = a.getPref(context).edit();
        edit.putInt(SHOWN_GUIDE_VIDEO, 1);
        edit.apply();
    }

    public static void setShownMiuiWarning(boolean z10) {
        getPref().edit().putBoolean(HAS_SHOWN_MIUI_WARNING, z10).apply();
    }

    public static void setShownedPopList(String str) {
        getPref().edit().putString(KEY_SHOWNED_AD_LIST, str).apply();
    }

    public static void setStartedFlag(Context context) {
        SharedPreferences.Editor edit = a.getPref(context).edit();
        edit.putInt(FIRST_NAME, 1);
        edit.apply();
    }

    public static void setTicpayPlatform(String str) {
        SharedPreferences.Editor edit = getPref().edit();
        if (TextUtils.isEmpty(str)) {
            str = TICPAY_PLATFORM_WEAROS;
        }
        edit.putString(KEY_TICPAY_PLATFORM, str);
        edit.apply();
    }

    public static void setUberBind(boolean z10) {
        getPref().edit().putBoolean(KEY_MAGIC_UBER_BIND, z10).apply();
    }

    public static void setUnicomProfileEnableStatus(boolean z10) {
        getPref().edit().putBoolean(UNICOM_PROFILE_ENABLE_STATUS, z10).apply();
    }

    public static void updateHealthCheckTime(long j10) {
        getPref().edit().putLong(HEALTH_CHECK_KEY, j10);
    }

    public static String getWearModel(WearNode wearNode) {
        WearInfo c10;
        if (wearNode == null || (c10 = com.mobvoi.companion.wear.a.f().c(wearNode.nodeId)) == null) {
            return getPref().getString(KEY_WEAR_DEVICE_TYPE, "");
        }
        return c10.wearType;
    }
}
