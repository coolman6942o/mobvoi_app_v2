package f2;

import g2.b;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static /* synthetic */ b f26338a;

    private static synchronized /* bridge */ /* synthetic */ void a() {
        synchronized (d.class) {
            if (f26338a == null) {
                f26338a = new b();
            }
        }
    }

    public static b b() {
        if (f26338a == null) {
            a();
        }
        return f26338a;
    }
}
