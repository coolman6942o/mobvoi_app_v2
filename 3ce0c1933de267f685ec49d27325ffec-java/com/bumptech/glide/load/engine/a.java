package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.engine.o;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import n5.j;
/* compiled from: ActiveResources.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f7865a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f7866b;

    /* renamed from: c  reason: collision with root package name */
    final Map<q4.b, d> f7867c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<o<?>> f7868d;

    /* renamed from: e  reason: collision with root package name */
    private o.a f7869e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f7870f;

    /* renamed from: g  reason: collision with root package name */
    private volatile c f7871g;

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ThreadFactoryC0093a implements ThreadFactory {

        /* compiled from: ActiveResources.java */
        /* renamed from: com.bumptech.glide.load.engine.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0094a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f7872a;

            RunnableC0094a(ThreadFactoryC0093a aVar, Runnable runnable) {
                this.f7872a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f7872a.run();
            }
        }

        ThreadFactoryC0093a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0094a(this, runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    /* loaded from: classes.dex */
    public static final class d extends WeakReference<o<?>> {

        /* renamed from: a  reason: collision with root package name */
        final q4.b f7874a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f7875b;

        /* renamed from: c  reason: collision with root package name */
        t4.c<?> f7876c;

        d(q4.b bVar, o<?> oVar, ReferenceQueue<? super o<?>> referenceQueue, boolean z10) {
            super(oVar, referenceQueue);
            this.f7874a = (q4.b) j.d(bVar);
            this.f7876c = (!oVar.f() || !z10) ? null : (t4.c) j.d(oVar.e());
            this.f7875b = oVar.f();
        }

        void a() {
            this.f7876c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new ThreadFactoryC0093a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(q4.b bVar, o<?> oVar) {
        d put = this.f7867c.put(bVar, new d(bVar, oVar, this.f7868d, this.f7865a));
        if (put != null) {
            put.a();
        }
    }

    void b() {
        while (!this.f7870f) {
            try {
                c((d) this.f7868d.remove());
                c cVar = this.f7871g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(d dVar) {
        t4.c<?> cVar;
        synchronized (this) {
            this.f7867c.remove(dVar.f7874a);
            if (dVar.f7875b && (cVar = dVar.f7876c) != null) {
                this.f7869e.d(dVar.f7874a, new o<>(cVar, true, false, dVar.f7874a, this.f7869e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(q4.b bVar) {
        d remove = this.f7867c.remove(bVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized o<?> e(q4.b bVar) {
        d dVar = this.f7867c.get(bVar);
        if (dVar == null) {
            return null;
        }
        o<?> oVar = dVar.get();
        if (oVar == null) {
            c(dVar);
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(o.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f7869e = aVar;
            }
        }
    }

    a(boolean z10, Executor executor) {
        this.f7867c = new HashMap();
        this.f7868d = new ReferenceQueue<>();
        this.f7865a = z10;
        this.f7866b = executor;
        executor.execute(new b());
    }
}
