package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.a.a.g;
import java.util.zip.Adler32;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f22445a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f22446d = new Object();

    public static long a(a aVar) {
        if (aVar == null) {
            return 0L;
        }
        String format = String.format("%s%s%s%s%s", aVar.f(), aVar.getDeviceId(), Long.valueOf(aVar.a()), aVar.getImsi(), aVar.e());
        if (g.m22a(format)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(format.getBytes());
        return adler32.getValue();
    }

    public static synchronized a b(Context context) {
        synchronized (b.class) {
            a aVar = f22445a;
            if (aVar != null) {
                return aVar;
            }
            if (context == null) {
                return null;
            }
            a a10 = a(context);
            f22445a = a10;
            return a10;
        }
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (f22446d) {
            String value = c.a(context).getValue();
            if (g.m22a(value)) {
                return null;
            }
            if (value.endsWith("\n")) {
                value = value.substring(0, value.length() - 1);
            }
            a aVar = new a();
            long currentTimeMillis = System.currentTimeMillis();
            String a10 = e.a(context);
            String c10 = e.c(context);
            aVar.d(a10);
            aVar.b(a10);
            aVar.b(currentTimeMillis);
            aVar.c(c10);
            aVar.e(value);
            aVar.a(a(aVar));
            return aVar;
        }
    }
}
