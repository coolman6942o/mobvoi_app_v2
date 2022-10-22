package l6;

import com.google.android.gms.flags.b;
import com.google.android.gms.flags.c;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f30425c;

    /* renamed from: a  reason: collision with root package name */
    private final b f30426a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final c f30427b = new c();

    static {
        c(new a());
    }

    private a() {
    }

    public static b a() {
        return d().f30426a;
    }

    public static c b() {
        return d().f30427b;
    }

    protected static void c(a aVar) {
        synchronized (a.class) {
            f30425c = aVar;
        }
    }

    private static a d() {
        a aVar;
        synchronized (a.class) {
            aVar = f30425c;
        }
        return aVar;
    }
}
