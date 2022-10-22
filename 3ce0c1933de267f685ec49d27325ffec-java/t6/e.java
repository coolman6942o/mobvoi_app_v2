package t6;

import android.os.Looper;
import b6.i;
/* loaded from: classes.dex */
public final class e {
    public static Looper a(Looper looper) {
        return looper != null ? looper : b();
    }

    public static Looper b() {
        i.o(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
