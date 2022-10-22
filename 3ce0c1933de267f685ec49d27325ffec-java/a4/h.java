package a4;

import com.alipay.sdk.app.c;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import y3.a;
/* loaded from: classes.dex */
public class h {
    public static String a(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("(^|;)" + str2 + "=\\{([^}]*?)\\}").matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (Throwable th2) {
            d.d(th2);
        }
        return "?";
    }

    public static Map<String, String> b() {
        c b10 = c.b(c.CANCELED.b());
        HashMap hashMap = new HashMap();
        hashMap.put("resultStatus", Integer.toString(b10.b()));
        hashMap.put("memo", b10.a());
        hashMap.put("result", "");
        return hashMap;
    }

    public static Map<String, String> c(String str) {
        String[] split = str.split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String substring = str2.substring(0, str2.indexOf("={"));
            hashMap.put(substring, e(str2, substring));
        }
        return hashMap;
    }

    public static Map<String, String> d(a aVar, String str) {
        Map<String, String> b10 = b();
        try {
            return c(str);
        } catch (Throwable th2) {
            p3.a.d(aVar, "biz", "FormatResultEx", th2);
            return b10;
        }
    }

    public static String e(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }
}
