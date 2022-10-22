package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.internal.u;
/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
public final class q0<T> extends u<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30275d = AtomicIntegerFieldUpdater.newUpdater(q0.class, "_decision");
    private volatile /* synthetic */ int _decision = 0;

    public q0(f fVar, c<? super T> cVar) {
        super(fVar, cVar);
    }

    private final boolean y0() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f30275d.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean z0() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f30275d.compareAndSet(this, 0, 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.u, kotlinx.coroutines.p1
    public void n(Object obj) {
        s0(obj);
    }

    @Override // kotlinx.coroutines.internal.u, kotlinx.coroutines.a
    protected void s0(Object obj) {
        c c10;
        if (!y0()) {
            c10 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f30242c);
            kotlinx.coroutines.internal.f.c(c10, d0.a(obj, this.f30242c), null, 2, null);
        }
    }

    public final Object x0() {
        Object d10;
        if (z0()) {
            d10 = b.d();
            return d10;
        }
        Object h10 = q1.h(N());
        if (!(h10 instanceof a0)) {
            return h10;
        }
        throw ((a0) h10).f30116a;
    }
}
