package com.mobvoi.wear.settings;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.webkit.URLUtil;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.WatchInfoUtils;
import java.io.Serializable;
import u9.b;
/* loaded from: classes2.dex */
public class SettingsHelper implements Serializable {
    private static final String AUTO_POWER_SAVE_LEVEL = "auto_power_save_level";
    private static final String COUNTRY = "country";
    private static final String DATE_FORMAT = "date_format";
    public static final String DEMO_PLAYER_ENABLE_setting = "demo_player_enable_setting";
    private static final String DIGITAL_CROWN = "tic_digital_crown";
    private static final String ENABLE_COMPAT_MODE = "enable_compat_mode";
    private static final String ENABLE_HANDLE_DOWN_TO_SLEEP = "enable_handle_down_to_sleep";
    private static final String ENABLE_HOTWORD = "enable_hotword";
    public static final String ENABLE_PRIVATE_NOTIFICATION = "enable_private_noti";
    private static final String ENABLE_TILT_TO_WAKE = "enable_tilt_to_wake";
    public static final String GLOBAL_VOLICE_TW_KEY = "com.mobvoi.rom.taiwan";
    public static final String HOTWORD_CONTENT = "hotword_content";
    private static final String HOURS_12_FORMAT = "12";
    private static final String HOURS_24_FORMAT = "24";
    private static final String IS_IN_GUIDE = "is_in_guide";
    private static final String IS_RESTORE = "is_restore";
    private static final String KEY_DOUBLE_TAP_WAKE = "double_tap_wake";
    public static final String KNOCK_TWICE_ENABLE = "knock_twice_enable";
    private static final String LANGUAGE = "language";
    public static final String LANGUAGE_CHINESE = "chinese";
    public static final String LANGUAGE_CHINESE_TAIWAN = "chinese.tw";
    public static final String LANGUAGE_ENGLISH = "english";
    private static final String LONG_PRESS_CHANGE_WATCH_FACE = "long_press_change_watch_face";
    public static final int RESTORE_FLAG = 1;
    public static final int SETTING_DISABLE = 0;
    public static final int SETTING_ENABLE = 1;
    public static final int SETTING_LEFT = 1;
    public static final int SETTING_RIGHT = 0;
    private static final String TAG = "SettingsHelper";
    public static final int TAP_DISABLE = 0;
    public static final int TAP_DOUBLE_TOUCH = 1;
    public static final int TAP_SINGLE_TOUCH = 2;
    private static final String TAP_WAKE_TYPE = "tap_wake_type";
    private static final String TEMPERATURE = "temperature";
    private static final String TICKLE_SIDE_TOUCH_ENABLED = "side_touch_enabled";
    private static final String TTS_ENABLE = "tts_enable";
    public static final String UNITS = "units";
    private static final String WEAR_HAND = "tic_wear_hand";
    private static final String WRIST_GESTURE_ENABLE = "wrist_gesture_enable";
    private static final String WRIST_GESTURE_VOICE = "wrist_gesture_voice";

    public static boolean canWakeupByTap(Context context) {
        return context.getPackageManager().hasSystemFeature("ticwear.hardware.tap_to_wakeup");
    }

    private static void ensureDozeEnabled(Context context, boolean z10) {
        try {
            Settings.Secure.putInt(context.getContentResolver(), (String) Settings.Secure.class.getField("DOZE_ENABLED").get(null), z10 ? 1 : 0);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String getAlarmRingtone(Context context) {
        return getRingtoneDataByUri(context, RingtoneManager.getActualDefaultRingtoneUri(context, 4));
    }

    public static int getAlarmVolume(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamVolume(4);
    }

    public static int getAutoPowerSaveLevel(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), AUTO_POWER_SAVE_LEVEL, 10);
    }

    public static int getBrightness(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "screen_brightness", 0);
    }

    public static int getClickScreenOnType(Context context) {
        return Settings.System.getInt(context.getContentResolver(), TAP_WAKE_TYPE, 2);
    }

    public static String getCountry(Context context) {
        return Settings.Global.getString(context.getContentResolver(), "country");
    }

    public static String getDateFormat(Context context) {
        return Settings.Global.getString(context.getContentResolver(), "date_format");
    }

    public static int getDefaultCrownDirection(Context context) {
        return context.getPackageManager().hasSystemFeature("ticwear.hardware.crown.left") ? 1 : 0;
    }

    public static int getDesiredScreenRotation(Context context, boolean z10) {
        return getDefaultCrownDirection(context) == 1 ? z10 ? 0 : 2 : z10 ? 2 : 0;
    }

    public static String getDeviceName() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null ? defaultAdapter.getName() : "";
    }

    public static String getHotword(Context context) {
        return Settings.Global.getString(context.getContentResolver(), HOTWORD_CONTENT);
    }

    public static boolean getKnockTwiceState(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), KNOCK_TWICE_ENABLE, 0) == 1;
    }

    public static String getLanguage(Context context) {
        return Settings.Global.getString(context.getContentResolver(), "language");
    }

    public static int getMusicVolume(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
    }

    public static String getRingtone(Context context) {
        return getRingtoneDataByUri(context, RingtoneManager.getActualDefaultRingtoneUri(context, 1));
    }

    private static String getRingtoneDataByUri(Context context, Uri uri) {
        Cursor query;
        int columnIndex;
        String str = "";
        if (!(uri == null || (query = context.getContentResolver().query(uri, null, null, null, null)) == null)) {
            if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) != -1) {
                str = query.getString(columnIndex);
            }
            query.close();
        }
        return str;
    }

    private static Uri getRingtoneUriByBackup(Context context, String str) {
        if (URLUtil.isValidUrl(str)) {
            return Uri.parse(str);
        }
        RingtoneManager ringtoneManager = new RingtoneManager(context);
        ringtoneManager.setType(5);
        Cursor cursor = ringtoneManager.getCursor();
        for (int i10 = 0; i10 < cursor.getCount(); i10++) {
            Uri ringtoneUri = ringtoneManager.getRingtoneUri(i10);
            if (str.equals(getRingtoneDataByUri(context, ringtoneUri))) {
                return ringtoneUri;
            }
        }
        return null;
    }

    public static int getRingtoneVolume(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamVolume(2);
    }

    public static int getScreenTimeout(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "screen_off_timeout", 0);
    }

    public static String getTemperature(Context context) {
        return Settings.Global.getString(context.getContentResolver(), "temperature");
    }

    public static boolean getTiltToWakeSetting(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), ENABLE_TILT_TO_WAKE, 1) == 1;
    }

    public static String getUnits(Context context) {
        return SharedWearInfoHelper.getInstance(context).getCompanionUnit();
    }

    public static String getVoiceServiceKey(Context context) {
        return WatchInfoUtils.getVoiceServiceKey(context);
    }

    public static boolean getWristGestureState(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), WRIST_GESTURE_ENABLE, 0) == 1;
    }

    public static boolean hasSideTouch(Context context) {
        return context.getPackageManager().hasSystemFeature("ticwear.hardware.side_touch");
    }

    public static boolean hasTelephony(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    public static boolean is24HourFormat(Context context) {
        return DateFormat.is24HourFormat(context);
    }

    public static boolean isAmbientModeEnabled(Context context) {
        return !Boolean.valueOf(b.a("persist.sys.disable_ambient", "true")).booleanValue();
    }

    public static boolean isDemoplayerAppEnable(Context context) {
        return Settings.System.getInt(context.getContentResolver(), DEMO_PLAYER_ENABLE_setting, 0) == 1;
    }

    public static boolean isEnableCompatMode(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), ENABLE_COMPAT_MODE, 0) == 1;
    }

    public static boolean isHotwordEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), ENABLE_HOTWORD, !WatchInfoUtils.isGlobalVersion() ? 1 : 0) == 1;
    }

    public static boolean isInGuide(Context context) {
        return Settings.System.getInt(context.getContentResolver(), IS_IN_GUIDE, 0) == 1;
    }

    public static boolean isLeftDigitalCrown(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), DIGITAL_CROWN, -1) == -1) {
            Settings.Global.putInt(context.getContentResolver(), DIGITAL_CROWN, getDefaultCrownDirection(context));
        }
        return Settings.Global.getInt(context.getContentResolver(), DIGITAL_CROWN, 1) == 1;
    }

    public static boolean isLongPressChangeWatchFace(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), LONG_PRESS_CHANGE_WATCH_FACE, 1) == 1;
    }

    public static boolean isPrivatePushEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), ENABLE_PRIVATE_NOTIFICATION, 1) == 1;
    }

    public static boolean isRestore(Context context) {
        return Settings.System.getInt(context.getContentResolver(), IS_RESTORE, -1) == 1;
    }

    public static boolean isStayAwakeWhenCharging(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
    }

    public static boolean isSupportCrownSwitch(Context context) {
        return context.getPackageManager().hasSystemFeature("ticwear.software.crown.switch");
    }

    public static boolean isTTSEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), TTS_ENABLE, 0) == 1;
    }

    public static boolean isTickleSideTouchEnabled(Context context) {
        return Settings.System.getInt(context.getContentResolver(), TICKLE_SIDE_TOUCH_ENABLED, 1) == 1;
    }

    public static boolean isWearLeftHand(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), WEAR_HAND, 1) == 1;
    }

    public static boolean isWristGestureForVoiceSearch(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), WRIST_GESTURE_VOICE, 0) == 1;
    }

    public static void setAlarmRingtone(Context context, String str) {
        setRingtoneUri(context, str, 4);
    }

    public static void setAlarmVolume(Context context, int i10) {
        ((AudioManager) context.getSystemService("audio")).setStreamVolume(4, i10, 1);
    }

    public static void setAmbientEnabled(Context context, boolean z10) {
        b.h("persist.sys.disable_ambient", String.valueOf(!z10));
        SystemPropertiesUtils.pokeSystemProperties(context);
        ensureDozeEnabled(context, z10);
        Intent intent = new Intent("com.mobvoi.ticwear.settings.TOGGLE_AMBIENT");
        intent.putExtra("disabled", !z10);
        context.sendBroadcast(intent);
    }

    public static void setAutoPowerSaveLevel(Context context, int i10) {
        Settings.Global.putInt(context.getContentResolver(), AUTO_POWER_SAVE_LEVEL, i10);
    }

    public static void setBrightness(Context context, int i10) {
        Settings.System.putInt(context.getContentResolver(), "screen_brightness", i10);
    }

    public static void setClickScreenOnType(Context context, int i10) {
        Settings.System.putInt(context.getContentResolver(), TAP_WAKE_TYPE, i10);
    }

    public static boolean setCountry(Context context, String str) {
        return Settings.Global.putString(context.getContentResolver(), "country", str);
    }

    public static boolean setDateFormat(Context context, String str) {
        return Settings.Global.putString(context.getContentResolver(), "date_format", str);
    }

    public static void setDemoplayerAppEnable(Context context, boolean z10) {
        Settings.System.putInt(context.getContentResolver(), DEMO_PLAYER_ENABLE_setting, z10 ? 1 : 0);
    }

    public static void setHotword(Context context, String str) {
        Settings.Global.putString(context.getContentResolver(), HOTWORD_CONTENT, str);
    }

    public static void setHotwordEnabled(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), ENABLE_HOTWORD, z10 ? 1 : 0);
    }

    public static void setHourFormat(Context context, boolean z10) {
        Settings.System.putString(context.getContentResolver(), "time_12_24", z10 ? HOURS_24_FORMAT : HOURS_12_FORMAT);
    }

    public static void setIsInGuide(Context context, boolean z10) {
        Settings.System.putInt(context.getContentResolver(), IS_IN_GUIDE, z10 ? 1 : 0);
    }

    public static void setIsRestore(Context context, int i10) {
        Settings.System.putInt(context.getContentResolver(), IS_RESTORE, i10);
    }

    public static void setKnockTwiceState(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), KNOCK_TWICE_ENABLE, z10 ? 1 : 0);
    }

    public static boolean setLanguage(Context context, String str) {
        return Settings.Global.putString(context.getContentResolver(), "language", str);
    }

    public static void setLeftDigitalCrown(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), DIGITAL_CROWN, z10 ? 1 : 0);
        setScreen(context, z10);
    }

    public static void setLongPressChangeWatchFace(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), LONG_PRESS_CHANGE_WATCH_FACE, z10 ? 1 : 0);
    }

    public static void setMusicVolume(Context context, int i10) {
        ((AudioManager) context.getSystemService("audio")).setStreamVolume(3, i10, 1);
    }

    public static void setPrivatePushEnabled(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), ENABLE_PRIVATE_NOTIFICATION, z10 ? 1 : 0);
    }

    public static void setRingtone(Context context, String str) {
        setRingtoneUri(context, str, 1);
    }

    private static void setRingtoneUri(Context context, String str, int i10) {
        if (!TextUtils.isEmpty(str)) {
            Uri ringtoneUriByBackup = getRingtoneUriByBackup(context, str);
            if (ringtoneUriByBackup == null) {
                k.f(TAG, "the ringtone cannot be found : %s, type : %d", str, Integer.valueOf(i10));
                return;
            }
            RingtoneManager ringtoneManager = new RingtoneManager(context);
            ringtoneManager.setType(5);
            if (ringtoneManager.getRingtonePosition(ringtoneUriByBackup) == -1) {
                k.f(TAG, "the ringtone cannot be found int ringtone and alarm: %s, type : %d", str, Integer.valueOf(i10));
            } else {
                RingtoneManager.setActualDefaultRingtoneUri(context, i10, ringtoneUriByBackup);
            }
        }
    }

    public static void setRingtoneVolume(Context context, int i10) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        audioManager.setStreamVolume(2, i10, 1);
        audioManager.setStreamVolume(5, i10, 1);
    }

    private static void setScreen(Context context, boolean z10) {
        if (Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 0) {
            Settings.System.putInt(context.getContentResolver(), "accelerometer_rotation", 0);
        }
        Settings.System.putInt(context.getContentResolver(), "user_rotation", getDesiredScreenRotation(context, z10));
    }

    public static void setScreenTimeout(Context context, int i10) {
        Settings.System.putInt(context.getContentResolver(), "screen_off_timeout", i10);
    }

    public static void setStayAwakWhenCharging(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), "stay_on_while_plugged_in", z10 ? 7 : 0);
    }

    public static void setTTSEnabled(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), TTS_ENABLE, z10 ? 1 : 0);
    }

    public static boolean setTemperature(Context context, String str) {
        return Settings.Global.putString(context.getContentResolver(), "temperature", str);
    }

    public static void setTickleSideTouch(Context context, boolean z10) {
        Settings.System.putInt(context.getContentResolver(), TICKLE_SIDE_TOUCH_ENABLED, z10 ? 1 : 0);
    }

    public static void setTiltToWakeSetting(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), ENABLE_TILT_TO_WAKE, z10 ? 1 : 0);
    }

    public static void setUnits(Context context, String str) {
        SharedWearInfoHelper.getInstance(context).setCompanionUnit(str);
    }

    public static void setVoiceServiceKey(Context context, String str) {
        WatchInfoUtils.setVoiceServiceKey(context, str);
    }

    public static void setWearLeftHand(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), WEAR_HAND, z10 ? 1 : 0);
    }

    public static void setWristGestureForVoiceSearch(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), WRIST_GESTURE_VOICE, z10 ? 1 : 0);
    }

    public static void setWristGestureState(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), WRIST_GESTURE_ENABLE, z10 ? 1 : 0);
    }
}
