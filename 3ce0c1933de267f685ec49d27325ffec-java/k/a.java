package k;

import java.util.concurrent.Executor;
/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f29680c;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f29681d = new b();

    /* renamed from: a  reason: collision with root package name */
    private c f29682a;

    /* renamed from: b  reason: collision with root package name */
    private c f29683b;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0358a implements Executor {
        ExecutorC0358a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.f().d(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.f().a(runnable);
        }
    }

    static {
        new ExecutorC0358a();
    }

    private a() {
        k.b bVar = new k.b();
        this.f29683b = bVar;
        this.f29682a = bVar;
    }

    public static Executor e() {
        return f29681d;
    }

    public static a f() {
        if (f29680c != null) {
            return f29680c;
        }
        synchronized (a.class) {
            if (f29680c == null) {
                f29680c = new a();
            }
        }
        return f29680c;
    }

    @Override // k.c
    public void a(Runnable runnable) {
        this.f29682a.a(runnable);
    }

    @Override // k.c
    public boolean c() {
        return this.f29682a.c();
    }

    @Override // k.c
    public void d(Runnable runnable) {
        this.f29682a.d(runnable);
    }
}
