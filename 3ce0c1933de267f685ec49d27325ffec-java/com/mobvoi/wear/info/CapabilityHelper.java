package com.mobvoi.wear.info;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.R;
import com.mobvoi.wear.common.base.Constants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class CapabilityHelper {
    private static final String CAPABILITY_SEPARATOR = "|";
    public static final String RESOURCE_NAME = "tic_apps_capabilities";
    private static final String TAG = "CapabilityHelper";
    private static final String VALID_NAME = "\\w+";

    public static String getAppCapabilities(Context context) {
        return toString(loadAppStaticCapabilities(context.getPackageName(), context.getResources()));
    }

    private static boolean hasSensor(Context context, int i10, boolean z10) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        return (sensorManager == null || (sensorManager.getDefaultSensor(i10, z10) == null && sensorManager.getDefaultSensor(i10, z10 ^ true) == null)) ? false : true;
    }

    public static boolean isValidName(String str) {
        return !TextUtils.isEmpty(str) && str.matches(VALID_NAME);
    }

    private static Set<String> loadAllAppCapabilities(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        HashSet hashSet = new HashSet();
        for (PackageInfo packageInfo : installedPackages) {
            List<String> loadAppStaticCapabilities = loadAppStaticCapabilities(context, packageInfo.packageName);
            if (loadAppStaticCapabilities != null) {
                if (k.j()) {
                    for (String str : loadAppStaticCapabilities) {
                        if (hashSet.contains(str)) {
                            throw new RuntimeException("Capability conflict found! " + str + " is duplicated");
                        } else if (!isValidName(str)) {
                            throw new RuntimeException("Capability name not valid: " + str);
                        }
                    }
                }
                hashSet.addAll(loadAppStaticCapabilities);
            }
        }
        return hashSet;
    }

    private static List<String> loadAppStaticCapabilities(Context context, String str) {
        try {
            return loadAppStaticCapabilities(str, context.getPackageManager().getResourcesForApplication(str));
        } catch (PackageManager.NameNotFoundException e10) {
            k.r(TAG, "failed to get resources for app=" + str, e10, new Object[0]);
            return null;
        }
    }

    private static Set<String> loadWatchCapabilities(Context context) {
        HashSet hashSet = new HashSet();
        if (hasSensor(context, Constants.Sensor.TIC_MOTION_TYPE_SENSOR_TYPE, true)) {
            hashSet.add(context.getString(R.string.watch_capability_sensor_tic_motion));
        }
        if (hasSensor(context, Constants.Sensor.MOBVOI_ACTIVITY_RECOGNIZE_SENSOR_TYPE, true)) {
            hashSet.add(context.getString(R.string.watch_capability_sensor_act_recognition));
        }
        if (hasSensor(context, 21, false)) {
            hashSet.add(context.getString(R.string.watch_capability_sensor_heart_rate));
        }
        return hashSet;
    }

    public static List<String> parseCapabilities(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        return Arrays.asList(str.split(Pattern.quote(CAPABILITY_SEPARATOR)));
    }

    public static String toString(Collection<String> collection) {
        return collection == null ? "" : TextUtils.join(CAPABILITY_SEPARATOR, collection);
    }

    public static void updateWearCapabilityInfo(Context context) {
        SharedWearInfoHelper sharedWearInfoHelper = SharedWearInfoHelper.getInstance(context);
        HashSet hashSet = new HashSet();
        Set<String> loadAllAppCapabilities = loadAllAppCapabilities(context);
        Set<String> loadWatchCapabilities = loadWatchCapabilities(context);
        k.c(TAG, "Capabilities updated: %s || %s", loadAllAppCapabilities, loadWatchCapabilities);
        hashSet.addAll(loadAllAppCapabilities);
        hashSet.addAll(loadWatchCapabilities);
        sharedWearInfoHelper.setWearCapabilities(toString(hashSet));
    }

    private static List<String> loadAppStaticCapabilities(String str, Resources resources) {
        try {
            int identifier = resources.getIdentifier(RESOURCE_NAME, "array", str);
            if (identifier == 0) {
                return null;
            }
            String[] stringArray = resources.getStringArray(identifier);
            if (stringArray.length > 0) {
                return Arrays.asList(stringArray);
            }
            return null;
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
