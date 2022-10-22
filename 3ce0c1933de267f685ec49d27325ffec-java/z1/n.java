package z1;

import androidx.work.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: WorkTimer.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: f  reason: collision with root package name */
    private static final String f37256f = k.f("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f37257a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f37258b;

    /* renamed from: c  reason: collision with root package name */
    final Map<String, c> f37259c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final Map<String, b> f37260d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    final Object f37261e = new Object();

    /* compiled from: WorkTimer.java */
    /* loaded from: classes.dex */
    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private int f37262a = 0;

        a(n nVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f37262a);
            this.f37262a = this.f37262a + 1;
            return newThread;
        }
    }

    /* compiled from: WorkTimer.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str);
    }

    /* compiled from: WorkTimer.java */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final n f37263a;

        /* renamed from: b  reason: collision with root package name */
        private final String f37264b;

        c(n nVar, String str) {
            this.f37263a = nVar;
            this.f37264b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f37263a.f37261e) {
                if (this.f37263a.f37259c.remove(this.f37264b) != null) {
                    b remove = this.f37263a.f37260d.remove(this.f37264b);
                    if (remove != null) {
                        remove.a(this.f37264b);
                    }
                } else {
                    k.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f37264b), new Throwable[0]);
                }
            }
        }
    }

    public n() {
        a aVar = new a(this);
        this.f37257a = aVar;
        this.f37258b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a() {
        if (!this.f37258b.isShutdown()) {
            this.f37258b.shutdownNow();
        }
    }

    public void b(String str, long j10, b bVar) {
        synchronized (this.f37261e) {
            k.c().a(f37256f, String.format("Starting timer for %s", str), new Throwable[0]);
            c(str);
            c cVar = new c(this, str);
            this.f37259c.put(str, cVar);
            this.f37260d.put(str, bVar);
            this.f37258b.schedule(cVar, j10, TimeUnit.MILLISECONDS);
        }
    }

    public void c(String str) {
        synchronized (this.f37261e) {
            if (this.f37259c.remove(str) != null) {
                k.c().a(f37256f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f37260d.remove(str);
            }
        }
    }
}
