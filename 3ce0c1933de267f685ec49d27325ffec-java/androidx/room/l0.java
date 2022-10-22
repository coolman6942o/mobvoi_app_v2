package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* compiled from: TransactionExecutor.java */
/* loaded from: classes.dex */
class l0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f4274a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Runnable> f4275b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f4276c;

    /* compiled from: TransactionExecutor.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f4277a;

        a(Runnable runnable) {
            this.f4277a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4277a.run();
            } finally {
                l0.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(Executor executor) {
        this.f4274a = executor;
    }

    synchronized void a() {
        Runnable poll = this.f4275b.poll();
        this.f4276c = poll;
        if (poll != null) {
            this.f4274a.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f4275b.offer(new a(runnable));
        if (this.f4276c == null) {
            a();
        }
    }
}
