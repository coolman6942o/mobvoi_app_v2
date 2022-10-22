package a4;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import y3.a;
/* loaded from: classes.dex */
public class e {
    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(";");
        for (int i10 = 0; i10 < split.length; i10++) {
            if (split[i10].startsWith("result={") && split[i10].endsWith("}")) {
                String[] split2 = split[i10].substring(8, split[i10].length() - 1).split(ContainerUtils.FIELD_DELIMITER);
                int i11 = 0;
                while (true) {
                    if (i11 >= split2.length) {
                        break;
                    } else if (split2[i11].startsWith("trade_token=\"") && split2[i11].endsWith("\"")) {
                        str2 = split2[i11].substring(13, split2[i11].length() - 1);
                        break;
                    } else if (split2[i11].startsWith("trade_token=")) {
                        str2 = split2[i11].substring(12);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        return str2;
    }

    public static String b(a aVar, Context context) {
        String b10 = f.b(aVar, context, "pref_trade_token", "");
        d.f("mspl", "get trade token: " + b10);
        return b10;
    }

    public static void c(a aVar, Context context, String str) {
        try {
            String a10 = a(str);
            d.f("mspl", "trade token: " + a10);
            if (!TextUtils.isEmpty(a10)) {
                f.c(aVar, context, "pref_trade_token", a10);
            }
        } catch (Throwable th2) {
            p3.a.d(aVar, "biz", "SaveTradeTokenError", th2);
            d.d(th2);
        }
    }
}
