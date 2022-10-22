package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;
/* loaded from: classes3.dex */
public final class BackpressureDrainManager extends AtomicLong implements e {
    private static final long serialVersionUID = 2826241102729529449L;
    final a actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Throwable th2);

        boolean accept(Object obj);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(a aVar) {
        this.actual = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
        if (r9 == 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
        r1 = r13.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
        if (r5.peek() == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
        if (get() != Long.MAX_VALUE) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
        if (r2 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0052, code lost:
        if (r1 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0054, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0057, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0058, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005c, code lost:
        r9 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0062, code lost:
        if (r9 == 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0064, code lost:
        if (r2 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0066, code lost:
        if (r1 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0068, code lost:
        if (r2 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006b, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006e, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0070, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0071, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0072, code lost:
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0074, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0075, code lost:
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        Throwable th2;
        synchronized (this) {
            if (!this.emitting) {
                boolean z10 = true;
                this.emitting = true;
                boolean z11 = this.terminated;
                long j10 = get();
                try {
                    a aVar = this.actual;
                    while (true) {
                        int i10 = 0;
                        while (true) {
                            int i11 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
                            try {
                                if (i11 > 0 || z11) {
                                    if (z11) {
                                        if (aVar.peek() == null) {
                                            aVar.a(this.exception);
                                            return;
                                        }
                                    }
                                    Object poll = aVar.poll();
                                    if (poll != null) {
                                        if (!aVar.accept(poll)) {
                                            j10--;
                                            i10++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                try {
                                    break;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                if (!z10) {
                                    synchronized (this) {
                                        this.emitting = false;
                                    }
                                }
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    z10 = false;
                }
            }
        }
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    @Override // rx.e
    public void request(long j10) {
        boolean z10;
        if (j10 != 0) {
            while (true) {
                long j11 = get();
                boolean z11 = true;
                z10 = j11 == 0;
                long j12 = Long.MAX_VALUE;
                if (j11 == Long.MAX_VALUE) {
                    break;
                }
                if (j10 == Long.MAX_VALUE) {
                    j12 = j10;
                } else {
                    if (j11 <= Long.MAX_VALUE - j10) {
                        j12 = j11 + j10;
                    }
                    z11 = z10;
                }
                if (compareAndSet(j11, j12)) {
                    z10 = z11;
                    break;
                }
            }
            if (z10) {
                drain();
            }
        }
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminate(Throwable th2) {
        if (!this.terminated) {
            this.exception = th2;
            this.terminated = true;
        }
    }

    public void terminateAndDrain(Throwable th2) {
        if (!this.terminated) {
            this.exception = th2;
            this.terminated = true;
            drain();
        }
    }
}
