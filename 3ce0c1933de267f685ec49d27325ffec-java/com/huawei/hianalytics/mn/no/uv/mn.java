package com.huawei.hianalytics.mn.no.uv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hianalytics.mn.mn.op;
import java.util.Map;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes.dex */
public class mn {
    public static String mn(Context context, String str) {
        String packageName = context.getPackageName();
        String d10 = op.d("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(d10)) {
            return "hms_" + str + "_" + packageName;
        }
        return "hms_" + str + "_" + packageName + "_" + d10;
    }

    public static void mn(Context context, String str, String str2, long j10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("SharedPreUtils", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences pq = pq(context, str);
        if (pq != null) {
            SharedPreferences.Editor edit = pq.edit();
            edit.putLong(str2, j10);
            edit.commit();
        }
    }

    public static void mn(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("SharedPreUtils", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences pq = pq(context, str);
        if (pq != null) {
            SharedPreferences.Editor edit = pq.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static void mn(Context context, String str, String... strArr) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("SharedPreUtils", "clearData(): parameter error.context,spname");
        } else if (strArr == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("SharedPreUtils", "clearData(): No data need to be deleted,keys is null");
        } else {
            SharedPreferences pq = pq(context, str);
            if (pq != null) {
                SharedPreferences.Editor edit = pq.edit();
                if (strArr.length == 0) {
                    edit.clear();
                    edit.commit();
                    return;
                }
                for (String str2 : strArr) {
                    if (pq.contains(str2)) {
                        edit.remove(str2);
                        edit.commit();
                    }
                }
            }
        }
    }

    public static long no(Context context, String str, String str2, long j10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("SharedPreUtils", "context is null or spName empty or spkey is empty");
            return j10;
        }
        SharedPreferences pq = pq(context, str);
        return pq != null ? pq.getLong(str2, j10) : j10;
    }

    public static String no(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("SharedPreUtils", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences pq = pq(context, str);
        return pq != null ? pq.getString(str2, str3) : str3;
    }

    public static Map<String, ?> no(Context context, String str) {
        return pq(context, str).getAll();
    }

    public static void op(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("SharedPreUtils", "clearTypeDataByTag() eventTag is null or empty!");
        } else if ("_default_config_tag".equals(str)) {
            mn(context, "stat_v2_1", str);
            mn(context, "cached_v2_1", str);
        } else {
            String str2 = str + "-oper";
            String str3 = str + "-maint";
            String str4 = str + "-diffprivacy";
            mn(context, "stat_v2_1", str2);
            mn(context, "cached_v2_1", str2);
            mn(context, "stat_v2_1", str3);
            mn(context, "cached_v2_1", str3);
            mn(context, "stat_v2_1", str4);
            mn(context, "cached_v2_1", str4);
        }
    }

    private static SharedPreferences pq(Context context, String str) {
        return context.getSharedPreferences(mn(context, str), 0);
    }
}
