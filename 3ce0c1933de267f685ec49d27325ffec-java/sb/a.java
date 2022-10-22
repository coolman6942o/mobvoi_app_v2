package sb;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.scankit.C0559e;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.tendcloud.tenddata.TalkingDataGender;
import com.tendcloud.tenddata.TalkingDataProfile;
import com.tendcloud.tenddata.TalkingDataProfileType;
import com.tendcloud.tenddata.TalkingDataSDK;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Analytics.java */
/* loaded from: classes2.dex */
public class a {
    private static String a(String str) {
        return Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0);
    }

    public static void b(Context context, String str, String str2) {
        TalkingDataSDK.init(context, str, str2, "");
    }

    public static void c(String str, String str2, String str3) {
        k.c("Analytics", "logWatchTypeIfNot sid %s, bt %s, model %s", str, str2, str3);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !TextUtils.isEmpty(str3)) {
            Application e10 = b.e();
            SharedPreferences sharedPreferences = e10.getSharedPreferences("analytics_pref", 0);
            if (!TextUtils.isEmpty(str2)) {
                str = str2.replaceAll(":", "");
            }
            if (!sharedPreferences.getBoolean(str, false)) {
                sharedPreferences.edit().putBoolean(str, true).apply();
                String replaceAll = str3.replaceAll("\\s", "_");
                HashMap hashMap = new HashMap();
                hashMap.put("model", replaceAll);
                TalkingDataSDK.onEvent(e10, "deviceType", 0.0d, hashMap);
            }
        }
    }

    public static void d(Context context, String str) {
        TalkingDataSDK.onEvent(context, str, 0.0d, null);
    }

    public static void e(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("label", str2);
        TalkingDataSDK.onEvent(context, str, 0.0d, hashMap);
    }

    public static void f(Context context, String str, String str2, Map<String, Object> map, double d10) {
        map.put("label", str2);
        TalkingDataSDK.onEvent(context, str, d10, map);
    }

    public static void g(String str, String str2, String str3, String str4, String str5, boolean z10) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            HashMap hashMap = new HashMap();
            TalkingDataProfile createProfile = TalkingDataProfile.createProfile();
            createProfile.setType(TalkingDataProfileType.REGISTERED);
            createProfile.setName(str4);
            createProfile.setGender(z10 ? TalkingDataGender.FEMALE : TalkingDataGender.MALE);
            createProfile.setProperty3(str5);
            if (TextUtils.isEmpty(str2)) {
                hashMap.put(C0559e.f14347a, a(str3));
                TalkingDataSDK.onLogin(str, createProfile);
            } else if (TextUtils.isEmpty(str3)) {
                hashMap.put("p", a(str2));
                TalkingDataSDK.onLogin(str, createProfile);
            } else {
                hashMap.put(C0559e.f14347a, a(str3));
                hashMap.put("p", a(str2));
                TalkingDataSDK.onLogin(str, createProfile);
            }
            TalkingDataSDK.onEvent(b.e(), "login", 0.0d, hashMap);
        }
    }

    public static void h(Context context, String str) {
        TalkingDataSDK.onPageEnd(context, str);
    }

    public static void i(Context context, String str) {
        TalkingDataSDK.onPageBegin(context, str);
    }

    public static void j(String str, String str2, String str3, String str4, boolean z10) {
        TalkingDataProfile createProfile = TalkingDataProfile.createProfile();
        createProfile.setName(str4);
        createProfile.setType(TalkingDataProfileType.REGISTERED);
        createProfile.setGender(z10 ? TalkingDataGender.FEMALE : TalkingDataGender.MALE);
        TalkingDataSDK.onRegister(str, createProfile, null);
    }

    public static void k(boolean z10) {
        if (!z10) {
            TalkingDataSDK.setVerboseLogDisable();
        }
    }

    public static void l(boolean z10) {
        TalkingDataSDK.setReportUncaughtExceptions(z10);
    }
}
