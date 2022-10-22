package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SchedulerPoolFactory.java */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f29224a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f29225b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f29226c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f29227d = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    /* loaded from: classes3.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f29228a;

        /* renamed from: b  reason: collision with root package name */
        int f29229b;

        a() {
        }

        void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f29228a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f29228a = true;
            }
            if (!this.f29228a || !properties.containsKey("rx2.purge-period-seconds")) {
                this.f29229b = 1;
                return;
            }
            try {
                this.f29229b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                this.f29229b = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerPoolFactory.java */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(h.f29227d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    h.f29227d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        f29224a = aVar.f29228a;
        f29225b = aVar.f29229b;
        b();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        c(f29224a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    public static void b() {
        d(f29224a);
    }

    static void c(boolean z10, ScheduledExecutorService scheduledExecutorService) {
        if (z10 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f29227d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void d(boolean z10) {
        if (z10) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f29226c;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (atomicReference.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        b bVar = new b();
                        int i10 = f29225b;
                        newScheduledThreadPool.scheduleAtFixedRate(bVar, i10, i10, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }
}
