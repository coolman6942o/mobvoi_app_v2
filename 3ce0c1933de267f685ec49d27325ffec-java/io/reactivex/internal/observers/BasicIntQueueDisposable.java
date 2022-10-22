package io.reactivex.internal.observers;

import co.b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements b<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // co.g
    public abstract /* synthetic */ void clear();

    @Override // xn.b
    public abstract /* synthetic */ void dispose();

    @Override // xn.b
    public abstract /* synthetic */ boolean isDisposed();

    @Override // co.g
    public abstract /* synthetic */ boolean isEmpty();

    @Override // co.g
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // co.g
    public abstract /* synthetic */ T poll() throws Exception;

    @Override // co.c
    public abstract /* synthetic */ int requestFusion(int i10);

    public final boolean offer(T t10, T t11) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
