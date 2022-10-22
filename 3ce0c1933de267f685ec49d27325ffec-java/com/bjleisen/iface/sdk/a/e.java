package com.bjleisen.iface.sdk.a;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
/* compiled from: AsyncHttpUtil.java */
/* loaded from: classes.dex */
public final class e {
    private static String a() {
        String str = null;
        if (TextUtils.isEmpty(null)) {
            str = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1";
        }
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = Build.VERSION.RELEASE;
        if (str2.length() > 0) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str3 = Build.MODEL;
            if (str3.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str3);
            }
        }
        String str4 = Build.ID;
        if (str4.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str4);
        }
        return String.format(str, stringBuffer, "Mobile ");
    }
}
