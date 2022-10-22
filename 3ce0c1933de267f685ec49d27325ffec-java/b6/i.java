package b6;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import h6.r;
import java.util.Objects;
/* loaded from: classes.dex */
public final class i {
    public static void a(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void d(Handler handler) {
        e(handler, "Must be called on the handler thread");
    }

    public static void e(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void f(String str) {
        if (!r.a()) {
            throw new IllegalStateException(str);
        }
    }

    public static String g(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static String h(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void i() {
        j("Must not be called on the main application thread");
    }

    public static void j(String str) {
        if (r.a()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T k(T t10) {
        Objects.requireNonNull(t10, "null reference");
        return t10;
    }

    public static <T> T l(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int m(int i10) {
        if (i10 != 0) {
            return i10;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static void n(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void o(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void p(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
