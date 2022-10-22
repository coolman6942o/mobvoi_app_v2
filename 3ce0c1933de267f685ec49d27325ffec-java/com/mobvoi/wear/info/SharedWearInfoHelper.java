package com.mobvoi.wear.info;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.location.Location;
import android.provider.Settings;
import android.text.TextUtils;
import com.mobvoi.android.common.provider.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.n;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.permission.PermissionHelper;
import com.mobvoi.wear.util.AwUtils;
import com.mobvoi.wear.util.WatchInfoUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SharedWearInfoHelper extends b {
    static final String SHARED_INFO_AUTHORITY = "com.mobvoi.wear.provider.info";
    private static final String TAG = "SharedWearInfoHelper";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile SharedWearInfoHelper sInstance;
    private String mWearDeviceId;

    /* loaded from: classes2.dex */
    public interface DevInfo {
        public static final boolean FITNESS_ALL_SPORTS_DEFAULT = false;
        public static final boolean FITNESS_GPS_BATCHING_DEFAULT = true;
        public static final boolean FITNESS_RAW_DATA_DEFAULT = false;
        public static final String KEY_FITNESS_ALL_SPORTS = "fitness_all_sports";
        public static final String KEY_FITNESS_GPS_BATCHING = "fitness_gps_batching";
        public static final String KEY_FITNESS_RAW_DATA = "fitness_raw_data";
        public static final String TABLE = "dev";
    }

    /* loaded from: classes2.dex */
    public interface GdprInfo {
        public static final String KEY_DATA_BLOOD_OXYGEN = "data_blood_oxygen";
        public static final String KEY_DATA_CALENDAR = "data_calendar";
        public static final String KEY_DATA_DOWN_SDCARD = "data_down_sdcard";
        public static final String KEY_DATA_GPS = "data_gps";
        public static final String KEY_DATA_HRM = "data_hrm";
        public static final String KEY_DATA_MICROPHONE = "data_microphone";
        public static final String KEY_DATA_MOTION = "data_motion";
        public static final String KEY_DATA_PRESSURE = "data_pressure";
        public static final String KEY_DATA_STEP = "data_step";
        public static final String KEY_DATA_STEP_SHARING = "data_step_sharing";
        public static final String KEY_DATA_SYNC = "data_sync";
        public static final String TABLE = "gdpr";

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface DataKey {
        }
    }

    /* loaded from: classes2.dex */
    public interface LocationInfo {
        public static final String KEY_ACCURACY = "accuracy";
        public static final String KEY_LAT = "lat";
        public static final String KEY_LNG = "lng";
        public static final String KEY_PROVIDER = "provider";
        public static final String KEY_TIME = "time";
        public static final String TABLE = "location";
    }

    /* loaded from: classes2.dex */
    public interface PermissionInfo {
        public static final String KEY_PERMISSION_HEALTH_SENSOR = "permission_health_sensor";
        public static final String TABLE = "permission";

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface DataKey {
        }
    }

    /* loaded from: classes2.dex */
    public interface PhoneInfo {
        public static final String KEY_COMPANION_CAPABILITIES = "companion_capabilities";
        public static final String KEY_COMPANION_DATEFORMAT = "companion_dateformat";
        public static final String KEY_COMPANION_TEMPRETUARE = "companion_temperature";
        public static final String KEY_COMPANION_UNIT = "companion_unit";
        public static final String KEY_COMPANION_VERSION_CODE = "companion_version_code";
        public static final String KEY_COMPANION_VERSION_NAME = "companion_version_name";
        public static final String KEY_IS_VPA = "is_vpa";
        public static final String KEY_PHONE_DEVICE_ID = "phone_device_id";
        public static final String KEY_PHONE_MODEL = "phone_model";
        public static final String KEY_PHONE_SYS_VERSION = "phone_sys_version";
        public static final String TABLE = "phone";
    }

    /* loaded from: classes2.dex */
    public interface TaskInfo {
        public static final String KEY_ACTIVITIES = "activities";
        public static final String KEY_PROCESSES = "processes";
        public static final String KEY_SERVICES = "services";
        public static final String TABLE = "task";
    }

    /* loaded from: classes2.dex */
    public interface WearInfo {
        public static final String KEY_BT_ADDRESS = "bt_address";
        public static final String KEY_PAIRED_PLATFORM = "paired_platform";
        public static final String KEY_SERIAL = "serial";
        public static final String KEY_TEST_MODE = "test_mode";
        public static final String KEY_TTS_TYPE = "tts_type";
        public static final String KEY_WEAR_CAPABILITIES = "wear_capabilities";
        public static final String KEY_WEAR_DEVICE_ID = "wear_device_id";
        public static final String KEY_WEAR_TYPE = "wear_type";
        public static final String TABLE = "wear";
    }

    private SharedWearInfoHelper(Context context) {
        super(context, SHARED_INFO_AUTHORITY);
    }

    public static SharedWearInfoHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (SharedWearInfoHelper.class) {
                if (sInstance == null) {
                    sInstance = new SharedWearInfoHelper(context);
                }
            }
        }
        return sInstance;
    }

    public static boolean isInfoProviderExist(Context context) {
        return b.isProviderExist(context, SHARED_INFO_AUTHORITY);
    }

    public String getBtAddress() {
        return this.mInfoClient.f("wear", WearInfo.KEY_BT_ADDRESS, "");
    }

    public String getCompanionCapabilities() {
        return this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_CAPABILITIES, "");
    }

    public String getCompanionDateformat() {
        return this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_DATEFORMAT, "");
    }

    public String getCompanionTempUnit() {
        String f10 = this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_TEMPRETUARE, "");
        return TextUtils.isEmpty(f10) ? WatchInfoUtils.getDefaultTempUnit(this.mAppContext) : f10;
    }

    public String getCompanionUnit() {
        String f10 = this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_UNIT, "");
        return TextUtils.isEmpty(f10) ? WatchInfoUtils.getDefaultDistanceUnit(this.mAppContext) : f10;
    }

    public String getCompanionVersionCode() {
        return this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_VERSION_CODE, null);
    }

    public String getCompanionVersionName() {
        return this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_VERSION_NAME, null);
    }

    public boolean getDevFlag(String str, boolean z10) {
        return this.mInfoClient.a(DevInfo.TABLE, str, z10);
    }

    public String getDeviceSerial() {
        return this.mInfoClient.f("wear", WearInfo.KEY_SERIAL, "unknown");
    }

    public Location getLastLocation() {
        if (!isGdprDataEnabled(GdprInfo.KEY_DATA_GPS)) {
            return null;
        }
        String f10 = this.mInfoClient.f(LocationInfo.TABLE, LocationInfo.KEY_PROVIDER, null);
        if (TextUtils.isEmpty(f10)) {
            return null;
        }
        Location location = new Location(f10);
        location.setLatitude(this.mInfoClient.b(LocationInfo.TABLE, LocationInfo.KEY_LAT, 0.0d));
        location.setLongitude(this.mInfoClient.b(LocationInfo.TABLE, LocationInfo.KEY_LNG, 0.0d));
        location.setAccuracy(this.mInfoClient.c(LocationInfo.TABLE, LocationInfo.KEY_ACCURACY, 0.0f));
        location.setTime(this.mInfoClient.e(LocationInfo.TABLE, "time", 0L));
        return location;
    }

    public int getPairedPlatform() {
        int d10 = this.mInfoClient.d("wear", "paired_platform", 0);
        if (d10 == 0 && (d10 = Settings.Global.getInt(this.mAppContext.getContentResolver(), "paired_platform", 0)) != 0) {
            setPairedPlatform(d10);
        }
        return d10;
    }

    public String getPhoneDeviceId() {
        return this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_PHONE_DEVICE_ID, null);
    }

    public String getPhoneModel() {
        return this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_PHONE_MODEL, null);
    }

    public String getPhoneSysVersion() {
        return this.mInfoClient.f(PhoneInfo.TABLE, PhoneInfo.KEY_PHONE_SYS_VERSION, null);
    }

    public List<ComponentName> getTopActivities() {
        ArrayList arrayList = new ArrayList();
        String f10 = this.mInfoClient.f(TaskInfo.TABLE, TaskInfo.KEY_ACTIVITIES, "");
        if (f10 == null) {
            return arrayList;
        }
        for (String str : f10.split(",")) {
            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
            if (unflattenFromString != null) {
                arrayList.add(unflattenFromString);
            }
        }
        return arrayList;
    }

    public String getTtsType() {
        return this.mInfoClient.f("wear", WearInfo.KEY_TTS_TYPE, "");
    }

    public String getWearCapabilities() {
        return this.mInfoClient.f("wear", WearInfo.KEY_WEAR_CAPABILITIES, "");
    }

    public String getWearDeviceId() {
        if (!TextUtils.isEmpty(this.mWearDeviceId)) {
            return this.mWearDeviceId;
        }
        String f10 = this.mInfoClient.f("wear", "wear_device_id", null);
        if ("illegal_device_id".equals(f10)) {
            return f10;
        }
        this.mWearDeviceId = f10;
        return f10;
    }

    public int getWearType() {
        return this.mInfoClient.d("wear", WearInfo.KEY_WEAR_TYPE, 0);
    }

    public boolean isGdprDataEnabled(String str) {
        return !isGdprEnabled() || this.mInfoClient.a(GdprInfo.TABLE, str, false);
    }

    public boolean isGdprEnabled() {
        return !WatchInfoUtils.isTicwearSystem() && !AwUtils.isAwLe(this.mAppContext) && !AwUtils.isTestMode(this.mAppContext) && !AwUtils.isRetailMode(this.mAppContext) && n.b(this.mAppContext, Constants.Privacy.PACKAGE_NAME);
    }

    public boolean isInfoSynced() {
        return !TextUtils.isEmpty(getPhoneDeviceId()) || !TextUtils.isEmpty(getPhoneModel());
    }

    public boolean isPermissionEnabled(String str) {
        return this.mInfoClient.a("permission", str, false);
    }

    public boolean isTestMode() {
        return this.mInfoClient.a("wear", WearInfo.KEY_TEST_MODE, false);
    }

    public boolean isVpa() {
        return this.mInfoClient.a(PhoneInfo.TABLE, PhoneInfo.KEY_IS_VPA, false);
    }

    public void putDeviceSerial(String str) {
        k.c(TAG, "set ser_ial %s", str);
        this.mInfoClient.n("wear", WearInfo.KEY_SERIAL, str);
    }

    public void saveLastLocation(Location location) {
        this.mInfoClient.n(LocationInfo.TABLE, LocationInfo.KEY_PROVIDER, location.getProvider());
        this.mInfoClient.j(LocationInfo.TABLE, LocationInfo.KEY_LAT, location.getLatitude());
        this.mInfoClient.j(LocationInfo.TABLE, LocationInfo.KEY_LNG, location.getLongitude());
        this.mInfoClient.k(LocationInfo.TABLE, LocationInfo.KEY_ACCURACY, location.getAccuracy());
        this.mInfoClient.m(LocationInfo.TABLE, "time", location.getTime());
    }

    public void setCompanionCapabilities(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_CAPABILITIES, str);
    }

    public void setCompanionDateformat(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_DATEFORMAT, str);
    }

    public void setCompanionTempUnit(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_TEMPRETUARE, str);
    }

    public void setCompanionUnit(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_UNIT, str);
        if (1 == getWearType() && PermissionHelper.isGranted(this.mAppContext, "android.permission.WRITE_SETTINGS")) {
            Settings.Global.putString(this.mAppContext.getContentResolver(), "units", str);
        }
    }

    public void setCompanionVersionCode(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_VERSION_CODE, str);
    }

    public void setCompanionVersionName(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_COMPANION_VERSION_NAME, str);
    }

    public void setDevFlag(String str, boolean z10) {
        this.mInfoClient.i(DevInfo.TABLE, str, z10);
    }

    public void setGpdrDataEnabled(String str, boolean z10) {
        if (isGdprEnabled()) {
            this.mInfoClient.i(GdprInfo.TABLE, str, z10);
        } else {
            k.s(TAG, "Bad logic! GDPR %s set: %s", str, Boolean.valueOf(z10));
        }
    }

    public void setIsVpa(boolean z10) {
        this.mInfoClient.i(PhoneInfo.TABLE, PhoneInfo.KEY_IS_VPA, z10);
    }

    public void setPairedPlatform(int i10) {
        this.mInfoClient.l("wear", "paired_platform", i10);
    }

    public void setPermissionEnabled(String str, boolean z10) {
        this.mInfoClient.i("permission", str, z10);
    }

    public void setPhoneDeviceId(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_PHONE_DEVICE_ID, str);
    }

    public void setPhoneModel(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_PHONE_MODEL, str);
    }

    public void setPhoneSysVersion(String str) {
        this.mInfoClient.n(PhoneInfo.TABLE, PhoneInfo.KEY_PHONE_SYS_VERSION, str);
    }

    public void setTestMode(boolean z10) {
        this.mInfoClient.i("wear", WearInfo.KEY_TEST_MODE, z10);
    }

    public void setTtsType(String str) {
        this.mInfoClient.n("wear", WearInfo.KEY_TTS_TYPE, str);
    }

    public void setWearCapabilities(String str) {
        this.mInfoClient.n("wear", WearInfo.KEY_WEAR_CAPABILITIES, str);
    }

    public static String getWearDeviceId(Context context) {
        return getInstance(context).getWearDeviceId();
    }
}
