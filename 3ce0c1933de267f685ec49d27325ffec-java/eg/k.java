package eg;

import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeFormatUtils.java */
/* loaded from: classes2.dex */
public class k {
    public static long a(String str) {
        try {
            return new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT).parse(str).getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static long b(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
            com.mobvoi.android.common.utils.k.a("TimeFormatUtils", "格式化出来一个时间是：" + parse.toString() + "    " + parse.getTime());
            return parse.getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static long c(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyyMMddHHmm").parse(str);
            com.mobvoi.android.common.utils.k.a("TimeFormatUtils", "格式化出来一个时间是：" + parse.toString() + "    " + parse.getTime());
            return parse.getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String d(long j10, String str) {
        if (str == null || str.isEmpty()) {
            str = LeisenIfaceConfig.CARD_DATE_FORMAT;
        }
        return new SimpleDateFormat(str).format(new Date(Long.valueOf(j10).longValue()));
    }
}
