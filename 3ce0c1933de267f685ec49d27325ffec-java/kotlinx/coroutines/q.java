package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.c;
/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public final class q extends a0 {

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30274c = AtomicIntegerFieldUpdater.newUpdater(q.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public q(c<?> cVar, Throwable th2, boolean z10) {
        super(th2, z10);
        if (th2 == null) {
            th2 = new CancellationException("Continuation " + cVar + " was cancelled normally");
        }
        this._resumed = 0;
    }

    public final boolean c() {
        return f30274c.compareAndSet(this, 0, 1);
    }
}
