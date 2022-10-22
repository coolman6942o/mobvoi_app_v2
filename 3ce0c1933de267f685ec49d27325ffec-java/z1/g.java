package z1;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* compiled from: SerialExecutor.java */
/* loaded from: classes.dex */
public class g implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private final Executor f37223b;

    /* renamed from: d  reason: collision with root package name */
    private volatile Runnable f37225d;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<a> f37222a = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final Object f37224c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SerialExecutor.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final g f37226a;

        /* renamed from: b  reason: collision with root package name */
        final Runnable f37227b;

        a(g gVar, Runnable runnable) {
            this.f37226a = gVar;
            this.f37227b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f37227b.run();
            } finally {
                this.f37226a.b();
            }
        }
    }

    public g(Executor executor) {
        this.f37223b = executor;
    }

    public boolean a() {
        boolean z10;
        synchronized (this.f37224c) {
            z10 = !this.f37222a.isEmpty();
        }
        return z10;
    }

    void b() {
        synchronized (this.f37224c) {
            a poll = this.f37222a.poll();
            this.f37225d = poll;
            if (poll != null) {
                this.f37223b.execute(this.f37225d);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f37224c) {
            this.f37222a.add(new a(this, runnable));
            if (this.f37225d == null) {
                b();
            }
        }
    }
}
