package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.f;
import kotlinx.coroutines.b1;
/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
final class d extends b1 implements i, Executor {

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30313g = AtomicIntegerFieldUpdater.newUpdater(d.class, "inFlightTasks");

    /* renamed from: b  reason: collision with root package name */
    private final b f30314b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30315c;

    /* renamed from: d  reason: collision with root package name */
    private final String f30316d;

    /* renamed from: e  reason: collision with root package name */
    private final int f30317e;

    /* renamed from: f  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Runnable> f30318f = new ConcurrentLinkedQueue<>();
    private volatile /* synthetic */ int inFlightTasks = 0;

    public d(b bVar, int i10, String str, int i11) {
        this.f30314b = bVar;
        this.f30315c = i10;
        this.f30316d = str;
        this.f30317e = i11;
    }

    private final void W(Runnable runnable, boolean z10) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30313g;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f30315c) {
                this.f30314b.g0(runnable, this, z10);
                return;
            }
            this.f30318f.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) < this.f30315c) {
                runnable = this.f30318f.poll();
            } else {
                return;
            }
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.g0
    public void Q(f fVar, Runnable runnable) {
        W(runnable, false);
    }

    @Override // kotlinx.coroutines.g0
    public void T(f fVar, Runnable runnable) {
        W(runnable, true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        W(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.i
    public void n() {
        Runnable poll = this.f30318f.poll();
        if (poll != null) {
            this.f30314b.g0(poll, this, true);
            return;
        }
        f30313g.decrementAndGet(this);
        Runnable poll2 = this.f30318f.poll();
        if (poll2 != null) {
            W(poll2, true);
        }
    }

    @Override // kotlinx.coroutines.g0
    public String toString() {
        String str = this.f30316d;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f30314b + ']';
    }

    @Override // kotlinx.coroutines.scheduling.i
    public int u() {
        return this.f30317e;
    }
}
