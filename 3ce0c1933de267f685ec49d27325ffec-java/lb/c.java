package lb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountHomeActivity;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import pa.i;
import ra.h;
import rx.j;
import ta.a;
/* compiled from: AccountUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static String c(Context context, String str) {
        if (str == null || str.length() < 8 || !o(str)) {
            return context.getResources().getString(i.Y);
        }
        if (str.length() > 16) {
            return context.getResources().getString(i.Z);
        }
        return null;
    }

    public static boolean d() {
        String str;
        if (TextUtils.isEmpty(a.s()) || TextUtils.isEmpty(a.d())) {
            str = Locale.getDefault().getDisplayCountry(Locale.ENGLISH);
        } else {
            str = a.v();
        }
        return TextUtils.equals("Taiwan", str);
    }

    public static void e(Activity activity, int i10) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(intent, i10);
    }

    public static String f(int i10) {
        char c10;
        int i11 = i10 / 60000;
        if (i11 < 0) {
            c10 = '-';
            i11 = -i11;
        } else {
            c10 = '+';
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GMT");
        sb2.append(c10);
        sb2.append(i11 / 60);
        int i12 = i11 % 60;
        if (i12 > 0) {
            sb2.append(':');
            sb2.append(i12);
        }
        return sb2.toString();
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return f.k(str);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static File h(Context context) {
        return new File(context.getExternalCacheDir(), "avatar.jpg");
    }

    public static String i() {
        String p10 = a.p();
        if (!TextUtils.isEmpty(p10)) {
            return p10;
        }
        String i10 = a.i();
        return !TextUtils.isEmpty(i10) ? i10 : "";
    }

    public static String j() {
        Locale c10 = g0.f.d().c(0);
        if (c10 != null) {
            String country = c10.getCountry();
            if (!TextUtils.isEmpty(country)) {
                k.c("AccountUtil", "get country from locale list, country = %s", country);
                return country;
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) b.e().getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                k.c("AccountUtil", "get country from network country iso, country = %s", networkCountryIso);
                return networkCountryIso.toUpperCase();
            }
        }
        String country2 = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(Locale.getDefault().getCountry())) {
            country2 = com.mobvoi.companion.base.settings.a.isOversea() ? "" : "CN";
            k.c("AccountUtil", "get country all is null, country = %s", country2);
        } else {
            k.c("AccountUtil", "get country from locale country, country = %s", country2);
        }
        return country2;
    }

    public static String k() {
        return f(TimeZone.getDefault().getOffset(System.currentTimeMillis()));
    }

    public static String l() {
        String str;
        if (TextUtils.isEmpty(a.s()) || TextUtils.isEmpty(a.d())) {
            str = Locale.getDefault().getDisplayCountry(Locale.ENGLISH);
        } else {
            str = a.v();
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        return !lowerCase.equals(Constants.Setting.TW_REGION) ? !lowerCase.equals(Constants.Setting.CHINA_REGION) ? "english" : "chinese" : "traditional-chinese";
    }

    public static boolean m(String str) {
        return p(str) || n(str);
    }

    public static boolean n(String str) {
        try {
            return Pattern.compile("^\\s*?(.+)@(.+?)\\s*$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean o(String str) {
        return Pattern.compile("^(?=.*\\d)(?=.*[a-zA-Z]).*$").matcher(str).matches();
    }

    public static boolean p(String str) {
        try {
            return Pattern.compile("^1\\d{10}$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(sa.c cVar) {
        if (cVar.b()) {
            k.a("AccountUtil", "updateUserRegion success");
        }
    }

    public static void s(Context context, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("key_type", "key_profile");
        hashMap.put("key_profile_bar_color", Integer.valueOf(i10));
        t(context, hashMap);
    }

    public static void t(Context context, Map<String, Object> map) {
        Intent intent = new Intent(context, AccountHomeActivity.class);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(entry.getKey(), (String) entry.getValue());
            } else if (value instanceof Integer) {
                intent.putExtra(entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
        }
        context.startActivity(intent);
    }

    public static j u() {
        return com.mobvoi.assistant.account.data.a.v().e(a.e()).Z(h.a().b()).H(h.a().a()).Y(a.f30448a, b.f30449a);
    }
}
