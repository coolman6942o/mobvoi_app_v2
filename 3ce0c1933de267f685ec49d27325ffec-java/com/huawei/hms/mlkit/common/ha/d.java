package com.huawei.hms.mlkit.common.ha;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
/* compiled from: HianalyticsLogUtils.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14069a = "d";

    public static String a(Context context) {
        return context == null ? "" : ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getNetworkOperator();
    }

    public static String b() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException | Exception unused2) {
            return "";
        }
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }

    public static String d() {
        return "";
    }

    public static String e() {
        return "MLKit";
    }

    public static String a() {
        return Build.MODEL;
    }

    public static LinkedHashMap<String, String> a(HianalyticsLog hianalyticsLog) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("package", hianalyticsLog.f14030a);
        linkedHashMap.put("appid", hianalyticsLog.f14031b);
        linkedHashMap.put("version", hianalyticsLog.f14032c);
        linkedHashMap.put("service", hianalyticsLog.f14033d);
        linkedHashMap.put("apiName", hianalyticsLog.f14034e);
        linkedHashMap.put("result", hianalyticsLog.f14035f);
        linkedHashMap.put("costTime", hianalyticsLog.f14036g);
        linkedHashMap.put("callTime", hianalyticsLog.f14037h);
        linkedHashMap.put("transId", hianalyticsLog.f14038i);
        linkedHashMap.put("operator", hianalyticsLog.f14039j);
        linkedHashMap.put("networkType", hianalyticsLog.f14040k);
        linkedHashMap.put("apkVersion", hianalyticsLog.f14042m);
        linkedHashMap.put("appName", hianalyticsLog.f14043n);
        linkedHashMap.put("countryCode", hianalyticsLog.f14044o);
        linkedHashMap.put("deviceType", hianalyticsLog.f14045p);
        linkedHashMap.put("emuiVersion", hianalyticsLog.f14046q);
        linkedHashMap.put("androidVersion", hianalyticsLog.f14047r);
        linkedHashMap.put("moduleName", hianalyticsLog.f14048s);
        linkedHashMap.put("moduleVersion", hianalyticsLog.f14049t);
        linkedHashMap.put("deviceCategory", hianalyticsLog.f14050u);
        return linkedHashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(Context context) {
        if (context == null) {
            return "Unknown";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return "Unknown";
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        switch (((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                break;
            case 13:
                return "4G";
            default:
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return subtypeName;
                }
                break;
        }
        return "3G";
    }

    public static a a(Context context, Bundle bundle) {
        if (bundle == null) {
            return new a();
        }
        String string = bundle.getString("packageName");
        if (string == null || string.equals("")) {
            b.b(f14069a, "packageName from bundle is null.");
            string = context.getPackageName();
        }
        String string2 = bundle.getString("appid");
        String string3 = bundle.getString("com.huawei.hms.client.service.name:ml-computer-vision");
        String string4 = bundle.getString("appName");
        Boolean valueOf = Boolean.valueOf(bundle.getBoolean("openHa"));
        return new a(string, string2, string3, string4, valueOf.booleanValue(), bundle.getString("countryCode"));
    }
}
