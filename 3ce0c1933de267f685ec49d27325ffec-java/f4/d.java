package f4;

import android.content.Context;
import c4.a;
import d4.c;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (d.class) {
            if (!a.d(str)) {
                if (!a.d(str2) && context != null) {
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
}
