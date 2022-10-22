package h6;

import android.content.Context;
import android.util.Log;
import b6.i;
/* loaded from: classes.dex */
public final class g {
    public static boolean a(Context context, Throwable th2) {
        return b(context, th2, 536870912);
    }

    private static boolean b(Context context, Throwable th2, int i10) {
        try {
            i.k(context);
            i.k(th2);
            return false;
        } catch (Exception e10) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e10);
            return false;
        }
    }
}
