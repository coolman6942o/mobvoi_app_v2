package com.mobvoi.wear.permission;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.mobvoi.wear.util.AppUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class DynamicPermission {
    private static final Set<String> sInterestedPermission;
    private static final Set<String> sWhiteList;

    static {
        HashSet hashSet = new HashSet();
        sWhiteList = hashSet;
        hashSet.add("com.tencent.mm");
        hashSet.add("com.mobvoi.ticwear.neteasemusic");
        HashSet hashSet2 = new HashSet();
        sInterestedPermission = hashSet2;
        hashSet2.add("android.permission.ACCESS_FINE_LOCATION");
        hashSet2.add("android.permission.ACCESS_COARSE_LOCATION");
        hashSet2.add("android.permission.CAMERA");
        hashSet2.add("android.permission.CALL_PHONE");
        hashSet2.add("android.permission.MODIFY_PHONE_STATE");
        hashSet2.add("android.permission.CHANGE_WIFI_STATE");
        hashSet2.add("android.permission.READ_CONTACTS");
        hashSet2.add("android.permission.WRITE_CONTACTS");
        hashSet2.add("android.permission.READ_CALL_LOG");
        hashSet2.add("android.permission.WRITE_CALL_LOG");
        hashSet2.add("android.permission.SEND_SMS");
        hashSet2.add("android.permission.READ_SMS");
        hashSet2.add("android.permission.BLUETOOTH_ADMIN");
        hashSet2.add("android.permission.BODY_SENSORS");
        hashSet2.add("android.permission.INTERNET");
    }

    public static boolean dontShowAlwayAsk(String str) {
        return false;
    }

    public static int getDefaultStatus(Context context, String str, String str2) {
        if (sWhiteList.contains(str)) {
            return 1;
        }
        if (!"android.permission.INTERNET".equals(str2) || (!"com.google.android.gms".equals(str) && !"com.google.android.gsf".equals(str))) {
            return AppUtils.isSystemApp(context, str) ? 1 : 0;
        }
        return -1;
    }

    public static boolean isInterestPermission(String str) {
        return sInterestedPermission.contains(str);
    }

    public static boolean shouldCheckPermission(PackageManager packageManager, String str) {
        try {
            return shouldCheckPermission(packageManager.getApplicationInfo(str, 0));
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean shouldCheckPermission(ApplicationInfo applicationInfo) {
        if (applicationInfo.uid < 10000) {
            return false;
        }
        return !AppUtils.isPrivateApp(applicationInfo);
    }
}
