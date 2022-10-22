package com.huawei.hianalytics.mn.no.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.uv.mn;
import java.io.File;
/* loaded from: classes.dex */
public class no {
    public static boolean mn(Context context) {
        return System.currentTimeMillis() - mn.no(context, "Privacy_MY", "flashKeyTime", -1L) > 43200000;
    }

    public static boolean mn(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return false;
            }
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "not have read phone permission!");
            return true;
        } else if (context.checkSelfPermission(str) == 0) {
            return false;
        } else {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "not have read phone permission!");
            return true;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean mn(Context context, String str, int i10) {
        long length = new File(context.getFilesDir(), "../shared_prefs/".concat(String.valueOf(mn.mn(context, str) + ".xml"))).length();
        if (length <= i10) {
            return false;
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i10)));
        return true;
    }

    public static boolean mn(String str, long j10, long j11) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j10 - Long.parseLong(str) > j11;
        } catch (NumberFormatException unused) {
            com.huawei.hianalytics.mn.no.qr.mn.op("TaskAssistant", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
