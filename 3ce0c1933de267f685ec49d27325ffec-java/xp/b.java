package xp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dq.e;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
import rx.f;
import rx.j;
/* compiled from: LooperScheduler.java */
/* loaded from: classes3.dex */
class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f36645a;

    /* compiled from: LooperScheduler.java */
    /* loaded from: classes3.dex */
    static class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f36646a;

        /* renamed from: b  reason: collision with root package name */
        private final wp.b f36647b = wp.a.a().b();

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f36648c;

        a(Handler handler) {
            this.f36646a = handler;
        }

        @Override // rx.f.a
        public j b(yp.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.f.a
        public j c(yp.a aVar, long j10, TimeUnit timeUnit) {
            if (this.f36648c) {
                return e.c();
            }
            RunnableC0535b bVar = new RunnableC0535b(this.f36647b.c(aVar), this.f36646a);
            Message obtain = Message.obtain(this.f36646a, bVar);
            obtain.obj = this;
            this.f36646a.sendMessageDelayed(obtain, timeUnit.toMillis(j10));
            if (!this.f36648c) {
                return bVar;
            }
            this.f36646a.removeCallbacks(bVar);
            return e.c();
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.f36648c;
        }

        @Override // rx.j
        public void unsubscribe() {
            this.f36648c = true;
            this.f36646a.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LooperScheduler.java */
    /* renamed from: xp.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class RunnableC0535b implements Runnable, j {

        /* renamed from: a  reason: collision with root package name */
        private final yp.a f36649a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f36650b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f36651c;

        RunnableC0535b(yp.a aVar, Handler handler) {
            this.f36649a = aVar;
            this.f36650b = handler;
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.f36651c;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f36649a.call();
            } catch (Throwable th2) {
                if (th2 instanceof OnErrorNotImplementedException) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th2);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th2);
                }
                bq.f.c().b().a(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // rx.j
        public void unsubscribe() {
            this.f36651c = true;
            this.f36650b.removeCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Looper looper) {
        this.f36645a = new Handler(looper);
    }

    @Override // rx.f
    public f.a a() {
        return new a(this.f36645a);
    }
}
