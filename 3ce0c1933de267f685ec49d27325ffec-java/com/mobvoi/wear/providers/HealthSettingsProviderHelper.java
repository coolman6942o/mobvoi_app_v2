package com.mobvoi.wear.providers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import com.mobvoi.android.common.provider.a;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.R;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.AccountInfoHelper;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* loaded from: classes2.dex */
public class HealthSettingsProviderHelper {
    public static final String SETTINGS_PROVIDER_ACTION = "com.mobvoi.health.action.SETTINGS_PROVIDER";
    public static final String SETTINGS_PROVIDER_AUTH = "com.mobvoi.health.provider.settings";
    private static final String TAG = "SettingsProviderHelper";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile HealthSettingsProviderHelper sInstance;
    private Context appContext;
    private a infoClient;

    /* loaded from: classes2.dex */
    public interface AppCtrl {
        public static final String AUTO_DETECT_BLOOD_OXYGEN = "auto_detect_blood_oxygen";
        public static final String AUTO_DETECT_BODY_MIND_STATE = "auto_detect_body_mind_state";
        public static final String AUTO_DETECT_FITNESS = "auto_detect_fitness";
        public static final String AUTO_DETECT_HEART_HEALTH = "auto_detect_heart_health";
        public static final String AUTO_DETECT_PRESSURE = "auto_detect_pressure";
        public static final String AUTO_DETECT_SLEEP = "auto_detect_sleep";
        public static final String AUTO_MOTION = "auto_motion";
        public static final String BACKGROUND_HRM = "background_hrm";
        public static final boolean DEFAULT_AUTO_DETECT_BLOOD_OXYGEN = false;
        public static final boolean DEFAULT_AUTO_DETECT_BODY_MIND_STATE = false;
        public static final boolean DEFAULT_AUTO_DETECT_HEART_HEALTH = false;
        public static final boolean DEFAULT_AUTO_DETECT_PRESSURE = false;
        public static final boolean DEFAULT_AUTO_DETECT_SLEEP = true;
        public static final boolean DEFAULT_FEATURE_HEART_HEALTH_SHOULD_SHOW = false;
        public static final boolean DEFAULT_FITNESS_HRM_WARNING = false;
        public static final boolean DEFAULT_REST_HRM_WARNING = false;
        public static final boolean DEFAULT_STEP_PEDOMETER = true;
        public static final String FEATURE_HEART_HEALTH_SHOULD_SHOW = "feature_heart_health_should_show";
        public static final String FITNESS_HRM_WARNING = "fitness_hrm_warning";
        public static final String REST_HRM_WARNING = "rest_hrm_warning";
        public static final String SHOULD_SHOW_DIALOG_IF_24H_BLOOD_OXYGEN_CLOSED = "should_show_dialog_if_24h_blood_oxygen_closed";
        public static final String SHOULD_SHOW_DIALOG_IF_24H_PRESSURE_CLOSED = "should_show_dialog_if_24h_pressure_closed";
        public static final boolean SHOW_DIALOG_BLOOD_OXYGEN_CLOSED = false;
        public static final boolean SHOW_DIALOG_PRESSURE_CLOSED = false;
        public static final String STEP_PEDOMETER = "step_pedometer";
        public static final String TABLE = "app_ctrl";
        public static final String TIC_CYCLE = "tic_cycle";
    }

    private HealthSettingsProviderHelper(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.infoClient = new a(applicationContext, SETTINGS_PROVIDER_AUTH);
    }

    private static boolean defaultEnableTicCycle() {
        String userSex = AccountInfoHelper.getInstance(b.e()).getUserSex();
        if (AccountInfoHelper.AccountInfo.VAL_SEX_MALE.equals(userSex)) {
            return false;
        }
        AccountInfoHelper.AccountInfo.VAL_SEX_FEMALE.equals(userSex);
        return true;
    }

    public static HealthSettingsProviderHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (HealthSettingsProviderHelper.class) {
                if (sInstance == null) {
                    sInstance = new HealthSettingsProviderHelper(context);
                }
            }
        }
        return sInstance;
    }

    private void refreshAutoMotionSwitch() {
        boolean isAutoMotionEnabled = isAutoMotionEnabled();
        boolean isAutoDetectFitnessEnabled = isAutoDetectFitnessEnabled();
        boolean isAutoDetectSleepEnabled = isAutoDetectSleepEnabled();
        boolean isRestHrmEnabled = isRestHrmEnabled();
        boolean z10 = isAutoDetectFitnessEnabled || isAutoDetectSleepEnabled || isRestHrmEnabled;
        k.c(TAG, "refreshAutoMotionSwitch, oldState: %s, fit: %s, sleep: %s, restHrm: %s, newState: %s", Boolean.valueOf(isAutoMotionEnabled), Boolean.valueOf(isAutoDetectFitnessEnabled), Boolean.valueOf(isAutoDetectSleepEnabled), Boolean.valueOf(isRestHrmEnabled), Boolean.valueOf(z10));
        if (z10 != isAutoMotionEnabled) {
            setSettingsEnabled("auto_motion", z10);
        }
    }

    public boolean getHeartHealthEnable() {
        return isSettingsEnabled(AppCtrl.FEATURE_HEART_HEALTH_SHOULD_SHOW, false);
    }

    public int getSettingsIntValue(String str, int i10) {
        return this.infoClient.d(AppCtrl.TABLE, str, i10);
    }

    public int getTimeInterval(String str) {
        return this.infoClient.d(AppCtrl.TABLE, str, 30000);
    }

    public Uri getUriFor(String str, String str2) {
        return this.infoClient.g(str, str2);
    }

    public boolean isAutoDetectBloodOxygenEnabled() {
        return isSettingsEnabled(AppCtrl.AUTO_DETECT_BLOOD_OXYGEN, false);
    }

    public boolean isAutoDetectBodyMindStateEnabled() {
        return isSettingsEnabled(AppCtrl.AUTO_DETECT_BODY_MIND_STATE, false);
    }

    public boolean isAutoDetectFitnessEnabled() {
        return HealthFlagsHelper.isFeatureEnabled("auto_motion") && isSettingsEnabled(AppCtrl.AUTO_DETECT_FITNESS, uk.b.a(this.appContext));
    }

    public boolean isAutoDetectHeartHealthEnabled() {
        return isSettingsEnabled(AppCtrl.AUTO_DETECT_HEART_HEALTH, false);
    }

    public boolean isAutoDetectPressureEnabled() {
        return isSettingsEnabled(AppCtrl.AUTO_DETECT_PRESSURE, false);
    }

    public boolean isAutoDetectSleepEnabled() {
        return HealthFlagsHelper.isFeatureEnabled("auto_motion") && isSettingsEnabled(AppCtrl.AUTO_DETECT_SLEEP, true) && SharedWearInfoHelper.getInstance(this.appContext).getWearCapabilities().contains(this.appContext.getString(R.string.capability_sleep_application));
    }

    public boolean isAutoMotionEnabled() {
        return HealthFlagsHelper.isFeatureEnabled("auto_motion") && isSettingsEnabled("auto_motion", uk.b.b(this.appContext));
    }

    public boolean isBackgroundHRMEnabled() {
        return isSettingsEnabled(AppCtrl.BACKGROUND_HRM, uk.b.c(this.appContext));
    }

    public boolean isFitnessHrmEnabled() {
        return isSettingsEnabled(AppCtrl.FITNESS_HRM_WARNING, false);
    }

    public boolean isHeartHealthShouldShow() {
        return TicwatchModels.isChinaRoverU() || (TicwatchModels.isOverseaRoverU() && isSettingsEnabled(AppCtrl.FEATURE_HEART_HEALTH_SHOULD_SHOW, false));
    }

    public boolean isRestHrmEnabled() {
        return isSettingsEnabled(AppCtrl.REST_HRM_WARNING, false);
    }

    public boolean isSettingsEnabled(String str, boolean z10) {
        return this.infoClient.a(AppCtrl.TABLE, str, z10);
    }

    public boolean isStepPedometerEnabled() {
        return isSettingsEnabled(AppCtrl.STEP_PEDOMETER, true);
    }

    public boolean isTicCycleEnabled() {
        return HealthFlagsHelper.isFeatureEnabled("tic_cycle") && isSettingsEnabled("tic_cycle", defaultEnableTicCycle());
    }

    public void registerObserver(String str, String str2, ContentObserver contentObserver) {
        this.infoClient.p(str, str2, contentObserver);
    }

    public void setAutoDetectBloodOxygenEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.AUTO_DETECT_BLOOD_OXYGEN, z10);
    }

    public void setAutoDetectBodyMindStateEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.AUTO_DETECT_BODY_MIND_STATE, z10);
    }

    public void setAutoDetectFitnessEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.AUTO_DETECT_FITNESS, z10);
        refreshAutoMotionSwitch();
    }

    public void setAutoDetectHeartHealthEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.AUTO_DETECT_HEART_HEALTH, z10);
    }

    public void setAutoDetectPressureEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.AUTO_DETECT_PRESSURE, z10);
    }

    public void setAutoDetectSleepEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.AUTO_DETECT_SLEEP, z10);
        refreshAutoMotionSwitch();
    }

    public void setBackgroundHRMEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.BACKGROUND_HRM, z10);
    }

    public void setFitnessHrmEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.FITNESS_HRM_WARNING, z10);
    }

    public void setHeartHealthShouldShow(boolean z10) {
        setSettingsEnabled(AppCtrl.FEATURE_HEART_HEALTH_SHOULD_SHOW, z10);
    }

    public void setRestHrmEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.REST_HRM_WARNING, z10);
        refreshAutoMotionSwitch();
    }

    public void setSettingsEnabled(String str, boolean z10) {
        this.infoClient.i(AppCtrl.TABLE, str, z10);
    }

    public void setSettingsIntValue(String str, int i10) {
        this.infoClient.l(AppCtrl.TABLE, str, i10);
    }

    public void setStepPedometerEnabled(boolean z10) {
        setSettingsEnabled(AppCtrl.STEP_PEDOMETER, z10);
    }

    public void setTicCycleEnabled(boolean z10) {
        setSettingsEnabled("tic_cycle", z10);
    }

    public void setTimeInterval(String str, int i10) {
        this.infoClient.l(AppCtrl.TABLE, str, i10);
    }

    public void unregisterObserver(ContentObserver contentObserver) {
        this.infoClient.r(contentObserver);
    }

    public void registerObserver(Uri uri, ContentObserver contentObserver) {
        this.infoClient.o(uri, contentObserver);
    }
}
