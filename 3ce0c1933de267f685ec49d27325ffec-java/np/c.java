package np;

import android.util.Log;
import com.amap.api.services.core.AMapException;
import ip.e;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.d0;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import kotlin.text.w;
import lp.b;
import okhttp3.y;
/* compiled from: AndroidLog.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, String> f31319b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f31320c = new c();

    /* renamed from: a  reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f31318a = new CopyOnWriteArraySet<>();

    static {
        Map<String, String> n10;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r12 = y.class.getPackage();
        String name = r12 != null ? r12.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = y.class.getName();
        i.e(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = b.class.getName();
        i.e(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = e.class.getName();
        i.e(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        n10 = d0.n(linkedHashMap);
        f31319b = n10;
    }

    private c() {
    }

    private final void c(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (f31318a.add(logger)) {
            i.e(logger, "logger");
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(d.f31321a);
        }
    }

    private final String d(String str) {
        String H0;
        String str2 = f31319b.get(str);
        if (str2 != null) {
            return str2;
        }
        H0 = w.H0(str, 23);
        return H0;
    }

    public final void a(String loggerName, int i10, String message, Throwable th2) {
        int S;
        int min;
        i.f(loggerName, "loggerName");
        i.f(message, "message");
        String d10 = d(loggerName);
        if (Log.isLoggable(d10, i10)) {
            if (th2 != null) {
                message = message + "\n" + Log.getStackTraceString(th2);
            }
            int i11 = 0;
            int length = message.length();
            while (i11 < length) {
                S = u.S(message, '\n', i11, false, 4, null);
                if (S == -1) {
                    S = length;
                }
                while (true) {
                    min = Math.min(S, i11 + AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED);
                    String substring = message.substring(i11, min);
                    i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i10, d10, substring);
                    if (min >= S) {
                        break;
                    }
                    i11 = min;
                }
                i11 = min + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry<String, String> entry : f31319b.entrySet()) {
            c(entry.getKey(), entry.getValue());
        }
    }
}
