package com.huawei.hianalytics.mn.no.no;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public abstract class mn {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hianalytics.mn.no.no.mn$mn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0175mn extends Exception {
        C0175mn(String str) {
            super(str);
        }
    }

    private static Object mn(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls != null) {
            if (clsArr == null) {
                if (objArr != null) {
                    throw new C0175mn("paramsType is null, but params is not null");
                }
            } else if (objArr == null) {
                throw new C0175mn("paramsType or params should be same");
            } else if (clsArr.length != objArr.length) {
                throw new C0175mn("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
            try {
            } catch (NoSuchMethodException unused) {
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
            }
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused2) {
                str2 = "invokeStaticFun(): method invoke Exception!";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str2);
                return null;
            } catch (IllegalArgumentException unused3) {
                str2 = "invokeStaticFun(): Illegal Argument!";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str2);
                return null;
            } catch (InvocationTargetException unused4) {
                str2 = "invokeStaticFun(): Invocation Target Exception!";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str2);
                return null;
            }
        } else {
            throw new C0175mn("class is null in invokeStaticFun");
        }
    }

    private static Object mn(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return mn(Class.forName(str), str2, clsArr, objArr);
        } catch (C0175mn unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str3);
            return null;
        }
    }

    public static String mn() {
        return mn("ro.build.version.emui", "");
    }

    public static String mn(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static String mn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String mn2 = mn("android.os.SystemProperties", str, str2);
        return TextUtils.isEmpty(mn2) ? mn("com.huawei.android.os.SystemPropertiesEx", str, str2) : mn2;
    }

    private static String mn(String str, String str2, String str3) {
        Object mn2 = mn(str, "get", new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return mn2 != null ? (String) mn2 : str3;
    }

    public static String no() {
        String mn2 = mn("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "SystemPropertiesEx: get rom_ver: ".concat(String.valueOf(mn2)));
        if (!TextUtils.isEmpty(mn2)) {
            return mn2;
        }
        String str = Build.DISPLAY;
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "SystemProperties: get rom_ver: ".concat(String.valueOf(str)));
        return str;
    }

    public static String no(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(mn(context), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String op(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String pq(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String obj2 = obj.toString();
            return obj2.length() > 256 ? "Unknown" : obj2;
        } catch (PackageManager.NameNotFoundException unused) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }
}
