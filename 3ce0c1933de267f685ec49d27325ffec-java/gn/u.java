package gn;

import android.util.Log;
import com.mobvoi.wear.lpa.LpaConstants;
/* loaded from: classes2.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27599a = true;

    public static void a(String str, Object obj) {
        if (f27599a) {
            Log.d(str, obj == null ? LpaConstants.VALUE_NULL : obj.toString());
        }
    }

    public static void b(String str, Object obj) {
        if (f27599a) {
            Log.e(str, obj == null ? LpaConstants.VALUE_NULL : obj.toString());
        }
    }

    public static void c(Object obj) {
        if (f27599a) {
            Log.i("LogUtils", obj == null ? LpaConstants.VALUE_NULL : obj.toString());
        }
    }

    public static void d(String str, Object obj) {
        if (f27599a) {
            Log.i(str, obj == null ? LpaConstants.VALUE_NULL : obj.toString());
        }
    }

    public static void e(boolean z10) {
        f27599a = z10;
    }

    public static void f(String str, Object obj) {
        if (f27599a) {
            Log.w(str, obj == null ? LpaConstants.VALUE_NULL : obj.toString());
        }
    }
}
