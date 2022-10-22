package r2;

import w2.c;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static /* synthetic */ a f33364a;

    private static synchronized /* bridge */ /* synthetic */ void a() {
        synchronized (b.class) {
            if (f33364a == null) {
                f33364a = new c();
            }
        }
    }

    public static a b() {
        if (f33364a == null) {
            a();
        }
        return f33364a;
    }
}
