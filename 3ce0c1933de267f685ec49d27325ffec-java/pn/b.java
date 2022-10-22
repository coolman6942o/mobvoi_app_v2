package pn;

import android.os.Looper;
/* compiled from: ThreadUtil.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Thread f32893a;

    public static void a() {
        if (!b()) {
            throw new IllegalStateException("Must be called on the Main thread.");
        }
    }

    public static boolean b() {
        if (f32893a == null) {
            f32893a = Looper.getMainLooper().getThread();
        }
        return Thread.currentThread() == f32893a;
    }
}
