package com.mobvoi.wear.common.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class Constants {

    /* loaded from: classes2.dex */
    public static class CloudSync {
        public static final int CLOUDSYNC_CLOSED = 0;
        public static final int CLOUDSYNC_OPEND = 1;
        public static final String CLOUDSYNC_SWITCH = "cloudsync_opend";
    }

    /* loaded from: classes2.dex */
    public static class Companion {
        public static final String CANCEL_TEXT = "cancel_text";
        public static final String CAN_SKIP = "can_skip";
        public static final String CAN_STANDALONE = "can_standalone";
        public static final String CHECK_ACTION = "com.mobvoi.wear.action.COMPANION_CHECK_ACTION";
        public static final String INSTALL_EXPLAIN_ANDROID = "install_explain_android";
        public static final String INSTALL_EXPLAIN_IOS = "install_explain_ios";
        public static final String LOGIN_EXPLAIN_ANDROID = "login_explain_android";
        public static final String LOGIN_EXPLAIN_IOS = "login_explain_ios";
        public static final String PACKAGE = "package_name";
    }

    /* loaded from: classes2.dex */
    public static class ConnectType {
        public static final String PAIRED_PLATFORM = "paired_platform";
        public static final int PLATFORM_ANDROID = 1;
        public static final int PLATFORM_IOS = 2;
        public static final int PLATFORM_UNKNOWN = 0;
    }

    /* loaded from: classes2.dex */
    public static class DND {
        public static final String DND_MODE = "dnd_mode";
        public static final String KEY_SCHEDULED_DND_FILTER = "scheduled_dnd_filter";
        public static final int KEY_SCHEDULED_DND_FILTER_EVERYONE = 0;
        public static final int KEY_SCHEDULED_DND_FILTER_FAVERIATE = 2;
        public static final int KEY_SCHEDULED_DND_FILTER_NOONE = 1;
        public static final String KEY_SCHEDULED_DND_SAVE_ENABLED = "scheduled_dnd_save.enabled";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DistanceUnit {
        public static final String IMPERIAL = "imperial";
        public static final String METRIC = "metric";
    }

    /* loaded from: classes2.dex */
    public interface Feature {
        public static final String HARDWARE_GPS_BATCHING = "com.mobvoi.hardware.gps.batching";
        public static final String HARDWARE_MOTION_BIKING = "com.mobvoi.hardware.motion.biking";
        public static final String HARDWARE_MOTION_FAST_WALK_V2 = "com.mobvoi.hardware.motion.fast_walk_v2";
        public static final String HARDWARE_MOTION_SWIMMING = "com.mobvoi.hardware.motion.swimming";
        public static final String HARDWARE_SWIMMING_QUALIFIED = "com.mobvoi.hardware.swimming_qualified";
        public static final String HARDWARE_TICWATCH = "oem.tw.hardware.ticwatch";
    }

    /* loaded from: classes2.dex */
    public static class Fitness {
        public static final String ACTION = "com.mobvoi.ticwear.action.FITNESS";
        public static final String ACTION_SESSION_STATUS = "com.mobvoi.ticwear.action.FITNESS_STATUS";
        public static final String DATA_CALORIE = "calorie";
        public static final String DATA_DISTANCE = "distance";
        public static final String DATA_DURATION = "duration";
        public static final String DATA_GROUP_COUNT = "group_count";
        public static final String DATA_HEART_RATE = "heart_rate";
        public static final String DATA_STEPS = "steps";
        public static final String DATA_TIME_FROM = "time_from";
        public static final String DATA_TIME_TO = "time_to";
        public static final String DATA_TRIPS = "swim_trips";
        public static final String KEY_SESSION_ID = "session_id";
        public static final String KEY_STATUS = "session_status";
        public static final String STATUS_PAUSING = "pausing";
        public static final String STATUS_RUNNING = "running";
        public static final String STATUS_STOPPED = "stopped";
        public static final String TYPE = "fitness_type";
        public static final String TYPE_FREE_TRAIN = "free_train";
        public static final String TYPE_INDOOR_RUN = "indoor_run";
        public static final String TYPE_OUTDOOR_RIDE = "outdoor_ride";
        public static final String TYPE_OUTDOOR_RUN = "outdoor_run";
        public static final String TYPE_OUTDOOR_WALK = "outdoor_walk";
        public static final String TYPE_SWIMMING = "swimming";
    }

    /* loaded from: classes2.dex */
    public static class Intent {
        public static final String ACTION_CHANGE_POWER_SAVE = "com.mobvoi.ticwear.settings.action.CHANGE_POWER_SAVE";
        public static final String ACTION_LOW_WATCH_VERSION = "com.mobvoi.ticwear.action.LOW_WATCH_VERSION";
        public static final String ACTION_MCU_SERVICE_BIND = "com.mobvoi.wear.action.BIND_MCU";
        public static final String ACTION_OPEN_WATCHFACE_MARKET = "com.mobvoi.ticwear.watchface.market.action.OPEN_WATCHFACE_MARKET";
        public static final String ACTION_POWER_SAVE_CHANGED = "com.mobvoi.ticwear.action.POWER_SAVE_MODE_CHANGED";
        public static final String KEY_ENABLE = "enable";
        public static final String KEY_FROM_ONEBOX = "from_onebox";
    }

    /* loaded from: classes2.dex */
    public static class Notification {
        public static final String EXTRA_BACKGROUND_COLOR = "background_color";
        public static final String EXTRA_HIDE_NOTIFICATION = "hide_notification";
        public static final String EXTRA_KEY_HIDE_DELETE = "mobvoi_hide_del";
        public static final String EXTRA_KEY_LAUNCH_INTENT = "launch_intent";
        public static final String EXTRA_SHOW_ON_SCREEN = "show_on_screen";
    }

    /* loaded from: classes2.dex */
    public static class Payment {
        public static final String EXTRA_PAGE_TYPE = "extra_page_type";
        public static final String PAYMENT_ACTION = "com.mobvoi.wear.action.PAY";
        public static final int PAY_BUS = 0;
        public static final int PAY_DOOR = 1;
    }

    /* loaded from: classes2.dex */
    public static class Permission {
        public static final String APP_BADGE = "com.mobvoi.ticwear.permission.APP_BADGE";
        public static final String APP_UPDATE = "com.mobvoi.ticwear.permission.APP_UPDATE";
    }

    /* loaded from: classes2.dex */
    public static class PowerMode {
        public static final int AMBIENT_MODE = 3;
        public static final String EXTRA_MODE_ENABLE = "enable";
        public static final String EXTRA_MODE_TYPE = "power_mode_type";
        public static final int NONE_POWER_MODE = 0;
        public static final int SUPER_POWER_MODE = 1;
        public static final int WRIST_POWER_MODE = 2;
    }

    /* loaded from: classes2.dex */
    public interface Privacy {
        public static final String ACTION_AFFILIATE = "com.mobvoi.wear.action.PRIVACY_AFFILIATE";
        public static final String ACTION_CHECK = "com.mobvoi.wear.action.PRIVACY_CHECK";
        public static final String ACTION_COOKIES = "com.mobvoi.wear.action.PRIVACY_COOKIES";
        public static final String ACTION_POLICY = "com.mobvoi.wear.action.PRIVACY_POLICY";
        public static final String ACTION_SETTINGS = "com.mobvoi.wear.action.PRIVACY_SETTINGS";
        public static final String ACTION_SWITCH = "com.mobvoi.wear.action.PRIVACY_SWITCH";
        public static final String ACTION_TERMS = "com.mobvoi.wear.action.PRIVACY_TERMS";
        public static final String KEY_CHECK_IMPACT_LIST = "impact_list";
        public static final String KEY_CHECK_PRIVACY_LIST = "privacy_list";
        public static final String KEY_SWITCH_DESCRIPTION = "switch_description";
        public static final String PACKAGE_NAME = "com.mobvoi.wear.privacy.aw";
    }

    /* loaded from: classes2.dex */
    public static class Sensor {
        public static final int COARSE_MOTION_TYPE_BIKE = 8;
        public static final int COARSE_MOTION_TYPE_FIDDLE = 3;
        public static final int COARSE_MOTION_TYPE_HIKE = 9;
        public static final int COARSE_MOTION_TYPE_INACTIVE = 10;
        public static final int COARSE_MOTION_TYPE_JOG_STEP_RATE = 12;
        public static final int COARSE_MOTION_TYPE_MOVE = 2;
        public static final int COARSE_MOTION_TYPE_PEDESTRIAN = 4;
        public static final int COARSE_MOTION_TYPE_RUN = 7;
        public static final int COARSE_MOTION_TYPE_RUN_STEP_RATE = 13;
        public static final int COARSE_MOTION_TYPE_STATIONARY = 1;
        public static final int COARSE_MOTION_TYPE_UNKNOWN = 0;
        public static final int COARSE_MOTION_TYPE_VEHICLE = 5;
        public static final int COARSE_MOTION_TYPE_WALK = 6;
        public static final int COARSE_MOTION_TYPE_WALK_STEP_RATE = 11;
        public static final int CYWEE_TAP_SENSOR = 33170991;
        public static final int IN_STATIC = 1;
        public static final int MOBVOI_ACTIVITY_RECOGNIZE_SENSOR_TYPE = 69632;
        public static final int MOBVOI_BG_BLOOD_OXYGEN_SENSOR_TYPE = 69645;
        public static final int MOBVOI_BG_HEART_RATE_SENSOR_TYPE = 69644;
        public static final int MOBVOI_BG_PRESSURE_SENSOR_TYPE = 69646;
        public static final int MOBVOI_BG_RRI_SENSOR_TYPE = 69648;
        public static final int MOBVOI_BLOOD_OXYGEN_SENSOR_TYPE = 69640;
        public static final int MOBVOI_HRM_NON_WAKEUP_SENSOR_TYPE = 69635;
        public static final int MOBVOI_HRM_WAKEUP_SENSOR_TYPE = 69636;
        public static final int MOBVOI_PRESSURE_SENSOR_TYPE = 69641;
        public static final int MOBVOI_RRI_SENSOR_TYPE = 69647;
        public static final int MOBVOI_SLEEP_HR_SENSOR_TYPE = 69643;
        public static final int MOTION_TYPE_SENSOR_TYPE = 33171002;
        public static final int NOT_STATIC = 0;
        public static final int OFF_WRIST = 2;
        public static final int OFF_WRIST_TYPE_SENSOR_TYPE = 33171030;
        public static final int ON_WRIST = 1;
        public static final int QUALCOMM_COARSE_MOTION_SENSOR = 33171012;
        public static final int TIC_MOTION_TYPE_AWAKE = 7;
        public static final int TIC_MOTION_TYPE_BIKING = 5;
        public static final int TIC_MOTION_TYPE_DEEP_SLEEP = 10;
        public static final int TIC_MOTION_TYPE_FAST_WALK = 2;
        public static final int TIC_MOTION_TYPE_INSANE = 4;
        public static final int TIC_MOTION_TYPE_LIGHT_SLEEP = 9;
        public static final int TIC_MOTION_TYPE_OFF_WRIST = 6;
        public static final int TIC_MOTION_TYPE_REM = 8;
        public static final int TIC_MOTION_TYPE_RUN = 3;
        public static final int TIC_MOTION_TYPE_SENSOR_TYPE = 33171020;
        public static final int TIC_MOTION_TYPE_STATIC = 0;
        public static final int TIC_MOTION_TYPE_SWIMMING = 11;
        public static final int TIC_MOTION_TYPE_UNDEFINED = 99;
        public static final int TIC_MOTION_TYPE_WALK = 1;
        public static final int TYPE_STATIC_DETECTOR = 33171003;
    }

    /* loaded from: classes2.dex */
    public static class Setting {
        public static final String ACTION_CHANGE_NFC_PROPERTY = "com.mobvoi.ticwear.action.CHANGE_NFC_PROPERTY";
        public static final String CHINA_REGION = "china";
        public static final String CREDIT_CARD_ENABLED = "credit_card_enabled";
        public static final String CROWN_TYPE_LEFT = "CROWN_LEFT";
        public static final String CROWN_TYPE_RIGHT = "CROWN_RIGHT";
        public static final String GLOBAL_REGION = "global";
        public static final String HAND_TYPE_LEFT = "HAND_LEFT";
        public static final String HAND_TYPE_RIGHT = "HAND_RIGHT";
        public static final String HOTWORD_TYPE = "HOTWORD_DEVICE_TYPE";
        public static final String HOTWORD_TYPE_CHINESE = "HOTWORD_AP";
        public static final String HOTWORD_TYPE_ENGLISH = "HOTWORD_DSP";
        public static final String KEY_IS_GOLD_WATCH = "tw.is_gold_watch";
        public static final String KEY_SUPPORT_MFI = "iap";
        public static final String PAIRED_DEVICE_BT_ADDRESS = "paired_device_bt_addr";
        public static final String PAIRED_DEVICE_NAME = "paired_device_name";
        public static final String PROPERTY_KEY = "extra.key";
        public static final String PROPERTY_VALUE = "extra.value";
        public static final String REBOOT_NFC = "extra.reboot_nfc";
        public static final String SIM_ACTIVITIED = "tw.sim_activitied";
        public static final String SUPER_POWER_SAVE_MODE = "super_power_save_mode";
        public static final String SUPER_POWER_SAVE_MODE_REASON = "super_power_save_mode_reason";
        public static final String SUPER_POWER_SAVE_MODE_REASON_LOW_BATTERY = "low_battery";
        public static final String SUPER_POWER_SAVE_MODE_REASON_NONE = "none";
        public static final String SUPER_POWER_SAVE_MODE_REASON_SCHEDULED = "scheduled";
        public static final String SUPER_POWER_SAVE_MODE_REASON_USER = "user";
        public static final String TIC_VERSION_CHANNEL = "ticwear.version.channel";
        public static final String TIC_VERSION_NAME = "ticwear.version.name";
        public static final String TIC_VERSION_NUMBER = "ticwear.version.number";
        public static final String TIC_VERSION_REGION = "ro.oem.tw.region";
        public static final String TIC_VERSION_REGION_OLD = "ticwear.version.region";
        public static final String TW_REGION = "taiwan";
        public static final String UNIT_IMPERIAL = "imperial";
        public static final String UPGRADE_AVAILABLE = "upgrade_available";
        public static final int VALUE_FALSE = 0;
        public static final int VALUE_TRUE = 1;
        public static final String WIFI_AUTO_ENABLED = "tw.wifi_auto";
        public static final String WIFI_CONFIGURED = "tw.wifi_configured";
    }

    /* loaded from: classes2.dex */
    public static class Sos {
        public static final String ACTION_FALL_DOWN_SOS = "com.mobvoi.wear.action.FALL_DOWN_SOS";
        public static final String ACTION_USER_SOS = "com.mobvoi.wear.action.USER_SOS";
    }

    /* loaded from: classes2.dex */
    public static class SystemTimeUpdate {
        public static final String SYSTEM_TIME_UPDATE = "system_time_update";
        public static final int SYSTEM_TIME_UPDATE_DONE = 1;
        public static final int SYSTEM_TIME_UPDATE_NOT = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface TempUnit {
        public static final String CELSIUS = "celsius";
        public static final String FAHRENHEIT = "fahrenheit";
    }

    /* loaded from: classes2.dex */
    public static class Version {
        public static final int TYPE_ALPHA = 2;
        public static final int TYPE_BETA = 1;
        public static final int TYPE_STABLE = 0;
        public static final int TYPE_UNKNOWN = 3;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface VersionType {
        }
    }

    /* loaded from: classes2.dex */
    public static class VoiceService {
        public static final String ACTION_START = "com.mobvoi.ticwear.voice.START";
        public static final String VOICE_SERVICE_DEFAULT_KEY = "com.mobvoi.rom";
        public static final String VOICE_SERVICE_GLOBAL_KEY = "com.mobvoi.rom.global";
        public static final String VOICE_SERVICE_KEY = "voice_service_key";
        public static final String VOICE_SERVICE_TW_KEY = "com.mobvoi.rom.taiwan";
    }

    /* loaded from: classes2.dex */
    public static class WatchfaceMarket {
        public static final String MARKET_ENTER_FROM = "from";
        public static final String REFER_APPLIST = "applist";
        public static final String REFER_FACE_CHANGE = "face_change";
        public static final String REFER_NOTIFICATION = "notification";
        public static final String REFER_UNKNOWN = "unknown";
    }

    /* loaded from: classes2.dex */
    public interface WearType {
        public static final int ANDROID_WEAR = 2;
        public static final int TICWEAR = 1;
        public static final int UNKNOWN = 0;
    }
}
