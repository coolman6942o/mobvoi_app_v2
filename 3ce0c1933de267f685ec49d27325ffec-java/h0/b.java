package h0;

import android.os.Handler;
import android.os.Looper;
/* compiled from: CalleeHandler.java */
/* loaded from: classes.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler a() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }
}
