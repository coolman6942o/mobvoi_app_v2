package g9;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import f9.a;
import h9.b;
/* compiled from: PhoneUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static String a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
            b.d("basePhoneVersion: " + invoke.toString());
            return invoke.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() {
        try {
            String str = (String) Build.class.getField("SERIAL").get(null);
            return TextUtils.isEmpty(str) ? Settings.Secure.getString(a.a().getContentResolver(), "android_id") : str;
        } catch (Exception unused) {
            return Settings.Secure.getString(a.a().getContentResolver(), "android_id");
        }
    }
}
