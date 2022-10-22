package com.huawei.hianalytics.mn.no.b;

import android.util.Pair;
import com.huawei.hianalytics.mn.no.qr.mn;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class qr {
    public static long mn(String str, long j10) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j10))).getTime();
        } catch (ParseException unused) {
            mn.op("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0L;
        }
    }

    public static Pair<String, String> mn(String str) {
        String str2;
        String str3;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] split = str.split("-");
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new Pair<>(str2, str3);
    }

    public static String mn(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    public static String mn(String str, String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        return str + "-" + str2;
    }

    public static String mn(String str, String str2, String str3) {
        if ("_default_config_tag".equals(str)) {
            return "_default_config_tag#".concat(String.valueOf(str3));
        }
        return str + "-" + str2 + "#" + str3;
    }

    public static Set<String> mn(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (!"_default_config_tag".equals(str)) {
                String str2 = str + "-oper";
                String str3 = str + "-maint";
                hashSet.add(str2);
                hashSet.add(str3);
                hashSet.add(str + "-diffprivacy");
            } else {
                hashSet.add("_default_config_tag");
            }
        }
        return hashSet;
    }

    public static JSONObject mn(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if ("OnPause".equals(str3)) {
                jSONObject.put("_event_duration", str2);
            }
            jSONObject.put("_activity_name", str);
        } catch (JSONException unused) {
            mn.op("hmsSdk/stringUtil", "getEventContent(): JSONException");
        }
        return jSONObject;
    }
}
