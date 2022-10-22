package f4;

import android.content.Context;
import d4.c;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String a10;
        synchronized (a.class) {
            String str3 = null;
            if (context != null) {
                try {
                    if (!c4.a.d(str) && !c4.a.d(str2)) {
                        try {
                            a10 = e.a(context, str, str2, "");
                        } catch (Throwable unused) {
                        }
                        if (c4.a.d(a10)) {
                            return null;
                        }
                        str3 = c.e(c.a(), a10);
                        return str3;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return null;
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            if (!c4.a.d(str) && !c4.a.d(str2) && context != null) {
                try {
                    String b10 = c.b(c.a(), str3);
                    HashMap hashMap = new HashMap();
                    hashMap.put(str2, b10);
                    e.b(context, str, hashMap);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
