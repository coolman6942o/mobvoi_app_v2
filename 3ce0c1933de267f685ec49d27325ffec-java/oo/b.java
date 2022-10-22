package oo;

import java.io.Closeable;
/* compiled from: Closeable.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final void a(Closeable closeable, Throwable th2) {
        if (closeable != null) {
            if (th2 == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th3) {
                io.b.a(th2, th3);
            }
        }
    }
}
