package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.Map;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13841a = "c";

    /* renamed from: b  reason: collision with root package name */
    private PLSharedPreferences f13842b;

    public c(Context context) {
        this.f13842b = null;
        String packageName = context.getPackageName();
        Logger.d(f13841a, "get pkgname from context is{%s}", packageName);
        this.f13842b = new PLSharedPreferences(context, "share_pre_grs_conf_" + packageName);
        a(context);
    }

    private void a(Context context) {
        try {
            String l10 = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String a10 = a("version", "");
            if (!l10.equals(a10)) {
                Logger.i(f13841a, "app version changed! old version{%s} and new version{%s}", a10, l10);
                c();
                b("version", l10);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.w(f13841a, "get app version failed and catch NameNotFoundException");
        }
    }

    public String a(String str, String str2) {
        return this.f13842b.getString(str, str2);
    }

    public Map<String, ?> a() {
        return this.f13842b.getAll();
    }

    public void a(String str) {
        this.f13842b.remove(str);
    }

    public String b() {
        return a("cp", "");
    }

    public void b(String str, String str2) {
        this.f13842b.putString(str, str2);
    }

    public void c() {
        this.f13842b.clear();
    }
}
