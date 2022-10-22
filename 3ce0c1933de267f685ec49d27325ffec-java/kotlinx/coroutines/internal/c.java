package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.n0;
/* compiled from: Atomic.kt */
/* loaded from: classes3.dex */
public abstract class c<T> extends s {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30204a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = b.f30202a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.s
    public c<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.s
    public final Object c(Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == b.f30202a) {
            obj2 = e(g(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(T t10, Object obj);

    public final Object e(Object obj) {
        if (n0.a()) {
            if (!(obj != b.f30202a)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        Object obj3 = b.f30202a;
        return obj2 != obj3 ? obj2 : f30204a.compareAndSet(this, obj3, obj) ? obj : this._consensus;
    }

    public long f() {
        return 0L;
    }

    public abstract Object g(T t10);
}
