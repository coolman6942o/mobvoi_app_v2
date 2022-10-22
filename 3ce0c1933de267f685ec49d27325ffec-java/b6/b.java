package b6;

import android.os.Looper;
import android.util.Log;
/* loaded from: classes.dex */
public final class b {
    public static void a(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("checkMainThread: current thread ");
            sb2.append(valueOf);
            sb2.append(" IS NOT the main thread ");
            sb2.append(valueOf2);
            sb2.append("!");
            Log.e("Asserts", sb2.toString());
            throw new IllegalStateException(str);
        }
    }

    public static void b(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 56 + valueOf2.length());
            sb2.append("checkNotMainThread: current thread ");
            sb2.append(valueOf);
            sb2.append(" IS the main thread ");
            sb2.append(valueOf2);
            sb2.append("!");
            Log.e("Asserts", sb2.toString());
            throw new IllegalStateException(str);
        }
    }

    public static void c(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void d(Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException(String.valueOf(obj2));
        }
    }
}
