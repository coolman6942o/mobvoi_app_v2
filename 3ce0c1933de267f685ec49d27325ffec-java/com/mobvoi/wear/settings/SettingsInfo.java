package com.mobvoi.wear.settings;

import android.content.Context;
import android.os.Build;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.util.HapticsUtil;
import com.mobvoi.wear.util.LockPatternHelper;
import com.mobvoi.wear.util.TelephonyUtil;
import java.util.Locale;
/* loaded from: classes2.dex */
public class SettingsInfo implements JsonBean {
    public String alarmRingtone;
    public int brightness;
    public String buildModel;
    public String buildType;
    public String country;
    public String dateFormat;
    public String deviceName;
    public boolean isAmbient;
    public boolean isEnableCompatMode;
    public boolean isHotwordEnabled;
    public boolean isLockEnabled;
    public boolean isLongPressChangeWatchFace;
    public boolean isPrivatePushDisabled;
    public boolean isRadioOn;
    public boolean isScreenOnWhenCharge;
    public boolean isSimActivated;
    public boolean isTTSEnabled;
    public boolean isTiltScreenOn;
    public boolean isWearLeftCrown;
    public boolean isWearLeftHand;
    public boolean isWirstControl;
    public boolean isWirstControlVoiceSearch;
    public String language;
    public Locale locale;
    public String ringtone;
    public int screenTimeout;
    public int smartPowerSaveLevel;
    public String temperature;
    public long time;
    public int touchScreenOnType;
    public String units;
    public int vibration;
    public String voiceServiceKey;
    public int alarmVolume = 14;
    public int musicVolume = 14;
    public int ringtoneVolume = 14;

    public static SettingsInfo export(Context context) {
        SettingsInfo settingsInfo = new SettingsInfo();
        settingsInfo.time = System.currentTimeMillis();
        settingsInfo.brightness = SettingsHelper.getBrightness(context);
        if (context.getPackageManager().hasSystemFeature("android.hardware.audio.output")) {
            settingsInfo.musicVolume = SettingsHelper.getMusicVolume(context);
            settingsInfo.ringtoneVolume = SettingsHelper.getRingtoneVolume(context);
            settingsInfo.alarmVolume = SettingsHelper.getAlarmVolume(context);
            settingsInfo.ringtone = SettingsHelper.getRingtone(context);
            settingsInfo.alarmRingtone = SettingsHelper.getAlarmRingtone(context);
        }
        if (HapticsUtil.isSupportHaptics(context)) {
            try {
                settingsInfo.vibration = HapticsUtil.userPreferenceGet(context);
            } catch (Exception unused) {
            }
        }
        settingsInfo.screenTimeout = SettingsHelper.getScreenTimeout(context);
        settingsInfo.isLockEnabled = LockPatternHelper.hasKeyguard(context);
        settingsInfo.isLongPressChangeWatchFace = SettingsHelper.isLongPressChangeWatchFace(context);
        settingsInfo.isAmbient = SettingsHelper.isAmbientModeEnabled(context);
        settingsInfo.isScreenOnWhenCharge = SettingsHelper.isStayAwakeWhenCharging(context);
        settingsInfo.isHotwordEnabled = SettingsHelper.isHotwordEnabled(context);
        settingsInfo.isTTSEnabled = SettingsHelper.isTTSEnabled(context);
        settingsInfo.smartPowerSaveLevel = SettingsHelper.getAutoPowerSaveLevel(context);
        settingsInfo.isWearLeftCrown = SettingsHelper.isLeftDigitalCrown(context);
        settingsInfo.isWearLeftHand = SettingsHelper.isWearLeftHand(context);
        settingsInfo.isTiltScreenOn = SettingsHelper.getTiltToWakeSetting(context);
        settingsInfo.isWirstControl = SettingsHelper.getWristGestureState(context);
        settingsInfo.isWirstControlVoiceSearch = SettingsHelper.isWristGestureForVoiceSearch(context);
        settingsInfo.touchScreenOnType = SettingsHelper.getClickScreenOnType(context);
        settingsInfo.buildType = Build.TYPE;
        settingsInfo.buildModel = Build.MODEL;
        settingsInfo.deviceName = SettingsHelper.getDeviceName();
        settingsInfo.voiceServiceKey = SettingsHelper.getVoiceServiceKey(context);
        settingsInfo.isPrivatePushDisabled = !SettingsHelper.isPrivatePushEnabled(context);
        if (SettingsHelper.hasTelephony(context)) {
            settingsInfo.isRadioOn = TelephonyUtil.isRadioOn(context);
            settingsInfo.isSimActivated = TelephonyUtil.isSimActivitied(context);
        }
        settingsInfo.temperature = SettingsHelper.getTemperature(context);
        settingsInfo.units = SettingsHelper.getUnits(context);
        settingsInfo.country = SettingsHelper.getCountry(context);
        settingsInfo.language = SettingsHelper.getLanguage(context);
        settingsInfo.dateFormat = SettingsHelper.getDateFormat(context);
        settingsInfo.isEnableCompatMode = SettingsHelper.isEnableCompatMode(context);
        return settingsInfo;
    }

    public static void restore(Context context, SettingsInfo settingsInfo) {
        SettingsHelper.setIsRestore(context, 1);
        SettingsHelper.setBrightness(context, settingsInfo.brightness);
        if (context.getPackageManager().hasSystemFeature("android.hardware.audio.output")) {
            int i10 = settingsInfo.musicVolume;
            if (i10 > 0) {
                SettingsHelper.setMusicVolume(context, i10);
            }
            SettingsHelper.setRingtoneVolume(context, settingsInfo.ringtoneVolume);
            int i11 = settingsInfo.alarmVolume;
            if (i11 > 0) {
                SettingsHelper.setAlarmVolume(context, i11);
            }
            SettingsHelper.setRingtone(context, settingsInfo.ringtone);
            SettingsHelper.setAlarmRingtone(context, settingsInfo.alarmRingtone);
        }
        if (HapticsUtil.isSupportHaptics(context)) {
            try {
                HapticsUtil.userPreference(context, settingsInfo.vibration);
            } catch (Exception unused) {
            }
        }
        int i12 = settingsInfo.screenTimeout;
        if (i12 > 0) {
            SettingsHelper.setScreenTimeout(context, i12);
        }
        SettingsHelper.setLongPressChangeWatchFace(context, settingsInfo.isLongPressChangeWatchFace);
        SettingsHelper.setAmbientEnabled(context, settingsInfo.isAmbient);
        SettingsHelper.setHotwordEnabled(context, settingsInfo.isHotwordEnabled);
        SettingsHelper.setTTSEnabled(context, settingsInfo.isTTSEnabled);
        SettingsHelper.setAutoPowerSaveLevel(context, settingsInfo.smartPowerSaveLevel);
        SettingsHelper.setLeftDigitalCrown(context, settingsInfo.isWearLeftCrown);
        SettingsHelper.setWearLeftHand(context, settingsInfo.isWearLeftHand);
        SettingsHelper.setTiltToWakeSetting(context, settingsInfo.isTiltScreenOn);
        SettingsHelper.setWristGestureState(context, settingsInfo.isWirstControl);
        SettingsHelper.setWristGestureForVoiceSearch(context, settingsInfo.isWirstControlVoiceSearch);
        SettingsHelper.setPrivatePushEnabled(context, true ^ settingsInfo.isPrivatePushDisabled);
        SettingsHelper.setTemperature(context, settingsInfo.temperature);
        SettingsHelper.setUnits(context, settingsInfo.units);
        SettingsHelper.setCountry(context, settingsInfo.country);
        SettingsHelper.setLanguage(context, settingsInfo.language);
        SettingsHelper.setDateFormat(context, settingsInfo.dateFormat);
        SettingsHelper.setVoiceServiceKey(context, settingsInfo.voiceServiceKey);
    }
}
