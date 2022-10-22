package wn;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.s;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import xn.c;
/* compiled from: HandlerScheduler.java */
/* loaded from: classes2.dex */
final class b extends s {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f36335b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f36336c;

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes2.dex */
    private static final class a extends s.c {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f36337a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f36338b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f36339c;

        a(Handler handler, boolean z10) {
            this.f36337a = handler;
            this.f36338b = z10;
        }

        @Override // io.reactivex.s.c
        @SuppressLint({"NewApi"})
        public xn.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f36339c) {
                return c.a();
            }
            RunnableC0527b bVar = new RunnableC0527b(this.f36337a, fo.a.u(runnable));
            Message obtain = Message.obtain(this.f36337a, bVar);
            obtain.obj = this;
            if (this.f36338b) {
                obtain.setAsynchronous(true);
            }
            this.f36337a.sendMessageDelayed(obtain, timeUnit.toMillis(j10));
            if (!this.f36339c) {
                return bVar;
            }
            this.f36337a.removeCallbacks(bVar);
            return c.a();
        }

        @Override // xn.b
        public void dispose() {
            this.f36339c = true;
            this.f36337a.removeCallbacksAndMessages(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f36339c;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: wn.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class RunnableC0527b implements Runnable, xn.b {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f36340a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f36341b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f36342c;

        RunnableC0527b(Handler handler, Runnable runnable) {
            this.f36340a = handler;
            this.f36341b = runnable;
        }

        @Override // xn.b
        public void dispose() {
            this.f36340a.removeCallbacks(this);
            this.f36342c = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f36342c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f36341b.run();
            } catch (Throwable th2) {
                fo.a.s(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler, boolean z10) {
        this.f36335b = handler;
        this.f36336c = z10;
    }

    @Override // io.reactivex.s
    public s.c a() {
        return new a(this.f36335b, this.f36336c);
    }

    @Override // io.reactivex.s
    public xn.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        RunnableC0527b bVar = new RunnableC0527b(this.f36335b, fo.a.u(runnable));
        this.f36335b.postDelayed(bVar, timeUnit.toMillis(j10));
        return bVar;
    }
}
