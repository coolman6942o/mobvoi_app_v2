package fg;

import android.content.Context;
import com.mobvoi.android.common.utils.q;
/* compiled from: HealthPrefsUtils.java */
/* loaded from: classes2.dex */
public class i {
    public static long a(Context context, String str) {
        return q.c(context, "health_sp", str, -1L);
    }

    public static void b(Context context, String str, long j10) {
        q.g(context, "health_sp", str, j10);
    }
}
