package g9;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import h9.b;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
/* compiled from: AppUtil.java */
/* loaded from: classes2.dex */
public final class a {
    public static String a(String str) {
        try {
            PackageInfo packageInfo = f9.a.a().getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                b.f("get callAppHash failure");
                return "";
            }
            Signature signature = packageInfo.signatures[0];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(signature.toByteArray());
            return h9.a.a(messageDigest.digest()).replace(":", "").toUpperCase();
        } catch (Exception e10) {
            b.f("get callAppHash failure:" + e10.getMessage());
            return "";
        }
    }

    public static String b() {
        try {
            return f9.a.a().getPackageManager().getPackageInfo(f9.a.a().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            b.f("get ClientVersionName failure:" + e10.getMessage());
            return null;
        }
    }

    public static String c() {
        try {
            return f9.a.a().getPackageName();
        } catch (Exception e10) {
            b.f("get PackageName failure:" + e10.getMessage());
            return "";
        }
    }

    public static boolean d(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        simpleDateFormat.setLenient(false);
        ParsePosition parsePosition = new ParsePosition(0);
        simpleDateFormat.parse(str, parsePosition);
        return parsePosition.getIndex() == str2.length();
    }

    public static boolean e(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3);
        try {
            return simpleDateFormat.parse(str).getTime() <= simpleDateFormat.parse(str2).getTime();
        } catch (ParseException e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
