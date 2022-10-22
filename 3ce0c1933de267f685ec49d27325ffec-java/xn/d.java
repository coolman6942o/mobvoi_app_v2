package xn;

import bo.b;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ReferenceDisposable.java */
/* loaded from: classes2.dex */
abstract class d<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(T t10) {
        super(b.e(t10, "value is null"));
    }

    protected abstract void a(T t10);

    @Override // xn.b
    public final void dispose() {
        T andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            a(andSet);
        }
    }

    @Override // xn.b
    public final boolean isDisposed() {
        return get() == null;
    }
}
