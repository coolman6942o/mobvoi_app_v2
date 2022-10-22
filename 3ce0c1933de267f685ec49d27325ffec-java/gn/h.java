package gn;

import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class h {
    private static long a(String str) {
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(str).getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String b() {
        return new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US).format(new Date());
    }

    public static String c(int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, i10);
        return new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US).format(calendar.getTime());
    }

    public static String d() {
        return new SimpleDateFormat("yyyyMMddHHmm", Locale.US).format(new Date());
    }

    public static String e(String str, int i10) {
        int i11 = i10 / 60;
        int i12 = i10 % 60;
        String valueOf = String.valueOf(i11);
        String valueOf2 = String.valueOf(i12);
        if (i11 < 10) {
            valueOf = "0" + valueOf;
        }
        if (i12 < 10) {
            valueOf2 = "0" + valueOf2;
        }
        return str + valueOf + valueOf2;
    }

    public static int f() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    public static int g(String str, String str2) {
        return (int) ((a(str2) - a(str)) / 1000);
    }

    public static String h(int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, i10);
        return new SimpleDateFormat("yyyyMM", Locale.US).format(calendar.getTime());
    }

    public static String i(int i10) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(i10 * 1000));
    }
}
