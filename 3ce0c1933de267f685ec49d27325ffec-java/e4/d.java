package e4;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import c4.a;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.io.File;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f25776a = new d();

    public static d a() {
        return f25776a;
    }

    public static String b(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean c(Context context) {
        boolean z10;
        int length;
        try {
            if (!Build.HARDWARE.contains("goldfish") && !Build.PRODUCT.contains("sdk") && !Build.FINGERPRINT.contains("generic")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (!(deviceId == null || (length = deviceId.length()) == 0)) {
                        for (int i10 = 0; i10 < length; i10++) {
                            if (!(Character.isWhitespace(deviceId.charAt(i10)) || deviceId.charAt(i10) == '0')) {
                                z10 = false;
                                break;
                            }
                        }
                    }
                    z10 = true;
                    if (z10) {
                        return true;
                    }
                }
                return a.d(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String d() {
        return "android";
    }

    public static boolean e() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i10 = 0; i10 < 5; i10++) {
            try {
                if (new File(strArr[i10] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String f() {
        return Build.BOARD;
    }

    public static String g() {
        return Build.BRAND;
    }

    public static String h() {
        return Build.DEVICE;
    }

    public static String i() {
        return Build.DISPLAY;
    }

    public static String j() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String k() {
        return Build.MANUFACTURER;
    }

    public static String l() {
        return Build.MODEL;
    }

    public static String m() {
        return Build.PRODUCT;
    }

    public static String n() {
        return Build.VERSION.RELEASE;
    }

    public static String o() {
        return Build.VERSION.SDK;
    }

    public static String p() {
        return Build.TAGS;
    }

    public static String q() {
        return b("ro.kernel.qemu", "0");
    }
}
