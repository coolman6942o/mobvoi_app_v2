package eg;

import android.util.Log;
import com.mobvoi.android.common.utils.k;
/* compiled from: LogConfig.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f26043a = "health.";

    /* compiled from: LogConfig.java */
    /* loaded from: classes2.dex */
    public static final class a {
        private static boolean a(String str) {
            if (!k.k()) {
                if (!Log.isLoggable("HEALTH_GLOBAL_DEBUG", 2)) {
                    if (Log.isLoggable(f.f26043a + str, 2)) {
                    }
                }
                return true;
            }
            return false;
        }

        public static boolean b() {
            return a("db_update");
        }

        public static boolean c() {
            return a("net_data");
        }

        public static boolean d() {
            return a("ui_map_view");
        }
    }
}
