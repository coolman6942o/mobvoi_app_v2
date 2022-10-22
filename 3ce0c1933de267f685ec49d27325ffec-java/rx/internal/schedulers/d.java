package rx.internal.schedulers;

import bq.c;
import dq.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.e;
import rx.internal.util.i;
import rx.j;
/* compiled from: NewThreadWorker.java */
/* loaded from: classes3.dex */
public class d extends f.a {

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f34046c;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Object f34050g;

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f34052a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f34053b;

    /* renamed from: h  reason: collision with root package name */
    private static final Object f34051h = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f34048e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReference<ScheduledExecutorService> f34049f = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public static final int f34047d = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NewThreadWorker.java */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.g();
        }
    }

    static {
        boolean z10 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int a10 = e.a();
        f34046c = !z10 && (a10 == 0 || a10 >= 21);
    }

    public d(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!l(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            h((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f34052a = newScheduledThreadPool;
    }

    public static void e(ScheduledExecutorService scheduledExecutorService) {
        f34048e.remove(scheduledExecutorService);
    }

    static Method f(ScheduledExecutorService scheduledExecutorService) {
        Method[] methods;
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    static void g() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f34048e.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            c.i(th2);
        }
    }

    public static void h(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f34049f;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (atomicReference.compareAndSet(null, newScheduledThreadPool)) {
                a aVar = new a();
                int i10 = f34047d;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i10, i10, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f34048e.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean l(ScheduledExecutorService scheduledExecutorService) {
        Method method;
        if (f34046c) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f34050g;
                Object obj2 = f34051h;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    method = f(scheduledExecutorService);
                    if (method != null) {
                        obj2 = method;
                    }
                    f34050g = obj2;
                } else {
                    method = (Method) obj;
                }
            } else {
                method = f(scheduledExecutorService);
            }
            if (method != null) {
                try {
                    method.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e10) {
                    c.i(e10);
                } catch (IllegalArgumentException e11) {
                    c.i(e11);
                } catch (InvocationTargetException e12) {
                    c.i(e12);
                }
            }
        }
        return false;
    }

    @Override // rx.f.a
    public j b(yp.a aVar) {
        return c(aVar, 0L, null);
    }

    @Override // rx.f.a
    public j c(yp.a aVar, long j10, TimeUnit timeUnit) {
        if (this.f34053b) {
            return dq.e.c();
        }
        return i(aVar, j10, timeUnit);
    }

    public ScheduledAction i(yp.a aVar, long j10, TimeUnit timeUnit) {
        Future<?> future;
        ScheduledAction scheduledAction = new ScheduledAction(c.p(aVar));
        if (j10 <= 0) {
            future = this.f34052a.submit(scheduledAction);
        } else {
            future = this.f34052a.schedule(scheduledAction, j10, timeUnit);
        }
        scheduledAction.add(future);
        return scheduledAction;
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.f34053b;
    }

    public ScheduledAction j(yp.a aVar, long j10, TimeUnit timeUnit, b bVar) {
        Future<?> future;
        ScheduledAction scheduledAction = new ScheduledAction(c.p(aVar), bVar);
        bVar.a(scheduledAction);
        if (j10 <= 0) {
            future = this.f34052a.submit(scheduledAction);
        } else {
            future = this.f34052a.schedule(scheduledAction, j10, timeUnit);
        }
        scheduledAction.add(future);
        return scheduledAction;
    }

    public ScheduledAction k(yp.a aVar, long j10, TimeUnit timeUnit, i iVar) {
        Future<?> future;
        ScheduledAction scheduledAction = new ScheduledAction(c.p(aVar), iVar);
        iVar.a(scheduledAction);
        if (j10 <= 0) {
            future = this.f34052a.submit(scheduledAction);
        } else {
            future = this.f34052a.schedule(scheduledAction, j10, timeUnit);
        }
        scheduledAction.add(future);
        return scheduledAction;
    }

    @Override // rx.j
    public void unsubscribe() {
        this.f34053b = true;
        this.f34052a.shutdownNow();
        e(this.f34052a);
    }
}
