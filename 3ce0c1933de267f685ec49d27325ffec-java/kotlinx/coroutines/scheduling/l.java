package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.n0;
/* compiled from: WorkQueue.kt */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30330b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask");

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30331c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex");

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30332d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex");

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30333e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer");

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<h> f30334a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ h b(l lVar, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return lVar.a(hVar, z10);
    }

    private final h c(h hVar) {
        boolean z10 = true;
        if (hVar.f30323b.u() != 1) {
            z10 = false;
        }
        if (z10) {
            f30333e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i10 = this.producerIndex & 127;
        while (this.f30334a.get(i10) != null) {
            Thread.yield();
        }
        this.f30334a.lazySet(i10, hVar);
        f30331c.incrementAndGet(this);
        return null;
    }

    private final void d(h hVar) {
        if (hVar != null) {
            boolean z10 = false;
            if (hVar.f30323b.u() == 1) {
                int decrementAndGet = f30333e.decrementAndGet(this);
                if (n0.a()) {
                    if (decrementAndGet >= 0) {
                        z10 = true;
                    }
                    if (!z10) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final h i() {
        h andSet;
        while (true) {
            int i10 = this.consumerIndex;
            if (i10 - this.producerIndex == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (f30332d.compareAndSet(this, i10, i10 + 1) && (andSet = this.f30334a.getAndSet(i11, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(c cVar) {
        h i10 = i();
        if (i10 == null) {
            return false;
        }
        cVar.a(i10);
        return true;
    }

    private final long m(l lVar, boolean z10) {
        h hVar;
        do {
            hVar = (h) lVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z10) {
                boolean z11 = true;
                if (hVar.f30323b.u() != 1) {
                    z11 = false;
                }
                if (!z11) {
                    return -2L;
                }
            }
            long a10 = k.f30329e.a() - hVar.f30322a;
            long j10 = k.f30325a;
            if (a10 < j10) {
                return j10 - a10;
            }
        } while (!f30330b.compareAndSet(lVar, hVar, null));
        b(this, hVar, false, 2, null);
        return -1L;
    }

    public final h a(h hVar, boolean z10) {
        if (z10) {
            return c(hVar);
        }
        h hVar2 = (h) f30330b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(c cVar) {
        h hVar = (h) f30330b.getAndSet(this, null);
        if (hVar != null) {
            cVar.a(hVar);
        }
        do {
        } while (j(cVar));
    }

    public final h h() {
        h hVar = (h) f30330b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final long k(l lVar) {
        if (n0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i10 = lVar.producerIndex;
        AtomicReferenceArray<h> atomicReferenceArray = lVar.f30334a;
        for (int i11 = lVar.consumerIndex; i11 != i10; i11++) {
            int i12 = i11 & 127;
            if (lVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = atomicReferenceArray.get(i12);
            if (hVar != null) {
                if ((hVar.f30323b.u() == 1) && atomicReferenceArray.compareAndSet(i12, hVar, null)) {
                    f30333e.decrementAndGet(lVar);
                    b(this, hVar, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(lVar, true);
    }

    public final long l(l lVar) {
        boolean z10 = true;
        if (n0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        h i10 = lVar.i();
        if (i10 == null) {
            return m(lVar, false);
        }
        h b10 = b(this, i10, false, 2, null);
        if (!n0.a()) {
            return -1L;
        }
        if (b10 != null) {
            z10 = false;
        }
        if (z10) {
            return -1L;
        }
        throw new AssertionError();
    }
}
