package n4;

import com.amap.api.services.a.h;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: CoreUtil.java */
/* loaded from: classes.dex */
public class o {
    public static String a(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static void b(Throwable th2, String str, String str2) {
        try {
            h c10 = h.c();
            if (c10 != null) {
                c10.e(th2, str, str2);
            }
            th2.printStackTrace();
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static Date c(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HH:mm").parse(str);
        } catch (ParseException e10) {
            b(e10, "CoreUtil", "parseTime");
            return null;
        }
    }
}
