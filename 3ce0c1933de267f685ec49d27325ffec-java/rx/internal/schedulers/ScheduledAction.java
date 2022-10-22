package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.util.i;
import rx.j;
/* loaded from: classes3.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, j {
    private static final long serialVersionUID = -3962399486978279857L;
    final yp.a action;
    final i cancel;

    /* loaded from: classes3.dex */
    final class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private final Future<?> f34004a;

        a(Future<?> future) {
            this.f34004a = future;
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.f34004a.isCancelled();
        }

        @Override // rx.j
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f34004a.cancel(true);
            } else {
                this.f34004a.cancel(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class b extends AtomicBoolean implements j {
        private static final long serialVersionUID = 247232374289553518L;
        final i parent;

        /* renamed from: s  reason: collision with root package name */
        final ScheduledAction f34006s;

        public b(ScheduledAction scheduledAction, i iVar) {
            this.f34006s = scheduledAction;
            this.parent = iVar;
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.f34006s.isUnsubscribed();
        }

        @Override // rx.j
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.f34006s);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class c extends AtomicBoolean implements j {
        private static final long serialVersionUID = 247232374289553518L;
        final dq.b parent;

        /* renamed from: s  reason: collision with root package name */
        final ScheduledAction f34007s;

        public c(ScheduledAction scheduledAction, dq.b bVar) {
            this.f34007s = scheduledAction;
            this.parent = bVar;
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.f34007s.isUnsubscribed();
        }

        @Override // rx.j
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.c(this.f34007s);
            }
        }
    }

    public ScheduledAction(yp.a aVar) {
        this.action = aVar;
        this.cancel = new i();
    }

    void a(Throwable th2) {
        bq.c.i(th2);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    public void add(j jVar) {
        this.cancel.a(jVar);
    }

    public void addParent(dq.b bVar) {
        this.cancel.a(new c(this, bVar));
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } finally {
                unsubscribe();
            }
        } catch (OnErrorNotImplementedException e10) {
            a(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e10));
        } catch (Throwable th2) {
            a(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th2));
        }
    }

    @Override // rx.j
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(i iVar) {
        this.cancel.a(new b(this, iVar));
    }

    public ScheduledAction(yp.a aVar, dq.b bVar) {
        this.action = aVar;
        this.cancel = new i(new c(this, bVar));
    }

    public ScheduledAction(yp.a aVar, i iVar) {
        this.action = aVar;
        this.cancel = new i(new b(this, iVar));
    }
}
