package com.ta.utdid2.a.a;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Random;
/* loaded from: classes2.dex */
public class e {
    public static String a() {
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] bytes = d.getBytes((int) (System.currentTimeMillis() / 1000));
        byte[] bytes2 = d.getBytes((int) System.nanoTime());
        byte[] bytes3 = d.getBytes(nextInt);
        byte[] bytes4 = d.getBytes(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return b.encodeToString(bArr, 2);
    }

    public static String b(Context context) {
        String str = "";
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            try {
                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("a5f5faddde9e9f02") && !string.equalsIgnoreCase("8e17f7422b35fbea")) {
                    if (!string.equalsIgnoreCase("0000000000000000")) {
                        return string;
                    }
                }
                return str;
            } catch (Throwable unused) {
                str = string;
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    public static String c() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        TelephonyManager telephonyManager;
        String subscriberId;
        if (context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            } catch (Exception unused) {
            }
            if (telephonyManager != null) {
                subscriberId = telephonyManager.getSubscriberId();
                return !g.m22a(subscriberId) ? a() : subscriberId;
            }
        }
        subscriberId = null;
        if (!g.m22a(subscriberId)) {
        }
    }

    public static String b() {
        String str = h.get("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(str)) {
            str = h.get("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(str) ? c() : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        TelephonyManager telephonyManager;
        if (!c.a() && context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            } catch (Exception unused) {
            }
            if (telephonyManager != null) {
                str = telephonyManager.getDeviceId();
                if (g.m22a(str)) {
                    str = b();
                }
                if (g.m22a(str)) {
                    str = b(context);
                }
                return !g.m22a(str) ? a() : str;
            }
        }
        str = null;
        if (g.m22a(str)) {
        }
        if (g.m22a(str)) {
        }
        if (!g.m22a(str)) {
        }
    }
}
