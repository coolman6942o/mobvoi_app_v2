package kotlinx.coroutines;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public final class a2 {

    /* renamed from: a  reason: collision with root package name */
    public static final a2 f30119a = new a2();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<w0> f30120b = new ThreadLocal<>();

    private a2() {
    }

    public final w0 a() {
        return f30120b.get();
    }

    public final w0 b() {
        ThreadLocal<w0> threadLocal = f30120b;
        w0 w0Var = threadLocal.get();
        if (w0Var != null) {
            return w0Var;
        }
        w0 a10 = z0.a();
        threadLocal.set(a10);
        return a10;
    }

    public final void c() {
        f30120b.set(null);
    }

    public final void d(w0 w0Var) {
        f30120b.set(w0Var);
    }
}
