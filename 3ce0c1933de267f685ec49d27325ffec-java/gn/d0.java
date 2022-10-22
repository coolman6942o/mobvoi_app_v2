package gn;

import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes2.dex */
public class d0 {
    static {
        Locale locale = Locale.US;
        new DecimalFormat("0.00", new DecimalFormatSymbols(locale));
        new SimpleDateFormat("yyyyMMddHHmmss", locale);
        new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, locale);
    }

    public static Integer a(String str) {
        try {
            long longValue = Long.valueOf(str).longValue();
            if (longValue <= 2147483647L && longValue >= -2147483648L) {
                return Integer.valueOf(str);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(float f10) {
        return new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US)).format(f10);
    }

    public static float c(float f10) {
        return f10 / 0.6213712f;
    }
}
