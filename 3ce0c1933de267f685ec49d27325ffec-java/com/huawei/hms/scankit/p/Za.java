package com.huawei.hms.scankit.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.scankit.util.a;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HaLog.java */
/* loaded from: classes2.dex */
public abstract class Za {

    /* renamed from: a  reason: collision with root package name */
    static String f14722a = "FORMAT_UNKNOWN";

    /* renamed from: b  reason: collision with root package name */
    static String f14723b = "OTHER";

    /* renamed from: c  reason: collision with root package name */
    static SparseArray<String> f14724c = new Ma();

    /* renamed from: d  reason: collision with root package name */
    static SparseArray<String> f14725d = new Na();

    /* renamed from: e  reason: collision with root package name */
    Context f14726e;

    /* renamed from: f  reason: collision with root package name */
    LinkedHashMap<String, String> f14727f = new LinkedHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    volatile long f14728g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Za(Bundle bundle, Context context) {
        this.f14726e = context;
        b(bundle);
    }

    private void b(Bundle bundle) {
        try {
            String packageName = this.f14726e.getPackageName();
            this.f14727f.put("package", packageName);
            if (bundle == null || !bundle.containsKey("appid")) {
                this.f14727f.put("appid", packageName);
            } else {
                this.f14727f.put("appid", bundle.getString("appid"));
            }
            PackageManager packageManager = this.f14726e.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            this.f14727f.put("appName", applicationInfo.loadLabel(packageManager).toString());
            this.f14727f.put("version", a(applicationInfo.metaData));
            this.f14727f.put("hmscoreVersion", c());
        } catch (PackageManager.NameNotFoundException unused) {
            a.b("HaLog", "PackageManager.NameNotFoundException");
        } catch (Exception unused2) {
            a.b("HaLog", "initValue Exception");
        }
        try {
            this.f14727f.put("algopt", b());
            if (e()) {
                this.f14727f.put("apkVersion", "unknown");
            } else {
                this.f14727f.put("apkVersion", "1.0");
            }
            this.f14727f.put("service", "com.huawei.hms.scankit");
            this.f14727f.put("operator", C0573cb.b(this.f14726e));
            this.f14727f.put("networkType", C0573cb.a(this.f14726e));
            this.f14727f.put("countryCode", C0573cb.a(this.f14726e, false));
            this.f14727f.put("deviceType", C0573cb.c());
            this.f14727f.put("emuiVersion", C0573cb.d());
            this.f14727f.put("androidVersion", C0573cb.a());
            this.f14727f.put("deviceCategory", C0573cb.b());
        } catch (RuntimeException unused3) {
            a.b("HaLog", "initValue RuntimeException");
        } catch (Exception unused4) {
            a.b("HaLog", "initValue Exception");
        }
    }

    private String c() {
        try {
            return this.f14726e.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return "unknown";
        }
    }

    private boolean d() {
        try {
            String property = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN);
            TelephonyManager telephonyManager = (TelephonyManager) this.f14726e.getApplicationContext().getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (!"CN".equalsIgnoreCase(property) || !"CN".equalsIgnoreCase(networkCountryIso)) {
                return false;
            }
            return "CN".equalsIgnoreCase(simCountryIso);
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    private boolean e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        try {
            if (!e() && !d()) {
                if (Settings.Secure.getInt(this.f14726e.getContentResolver(), "hw_app_analytics_state", 0) != 1) {
                    return false;
                }
            }
            return true;
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i10) {
        return f14724c.get(i10, f14722a);
    }

    private String a(Bundle bundle) {
        String[] strArr = {"huawei_module_scankit_sdk_version", "com.huawei.hms.client.service.name:scan", "com.huawei.hms.client.service.name:scanplus", "com.huawei.hms.client.service.name:scankit"};
        if (bundle == null) {
            return "scankit:1.0.2.300";
        }
        for (int i10 = 0; i10 < 4; i10++) {
            String str = strArr[i10];
            if (bundle.getString(str) != null) {
                return bundle.getString(str);
            }
        }
        return "scankit:1.0.2.300";
    }

    private String b() {
        return Build.VERSION.SDK_INT == 24 ? "lite-noso" : "lite";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(int i10) {
        return f14725d.get(i10, f14723b);
    }
}
