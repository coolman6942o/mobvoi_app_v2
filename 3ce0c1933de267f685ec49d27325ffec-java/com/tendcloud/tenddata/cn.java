package com.tendcloud.tenddata;

import android.os.Build;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cn extends ch {
    public cn() {
        a("os", "android");
        a("osVersionName", j.a());
        a("isHarmony", Boolean.valueOf(j.b()));
        a("osVersionCode", String.valueOf(j.j()));
        a("timezone", TimeZone.getDefault().getID());
        a("locale", e());
        a("timezoneV", g());
        a(SettingConstants.LANGUAGE, j.l());
        a("romVersion", Build.FINGERPRINT);
        a("basebandVersion", d());
        a("osBuild", j.c());
        a("isAdbEnabled", Boolean.valueOf(j.a(ab.f22568h)));
    }

    public static String d() {
        try {
            if (u.a(14)) {
                return Build.getRadioVersion();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String e() {
        try {
            return Locale.getDefault().toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static float f() {
        try {
            return TimeZone.getDefault().getRawOffset() / 3600000.0f;
        } catch (Throwable unused) {
            return -1.0f;
        }
    }

    private static String g() {
        try {
            return String.valueOf(f());
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return ((JSONObject) b()).optString("timezoneV");
    }

    public String c() {
        return ((JSONObject) b()).optString("locale");
    }
}
