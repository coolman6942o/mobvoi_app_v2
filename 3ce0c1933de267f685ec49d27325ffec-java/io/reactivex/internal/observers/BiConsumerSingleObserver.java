package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* loaded from: classes2.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<b> implements u<T>, b {
    private static final long serialVersionUID = 4943102778943297569L;
    final zn.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(zn.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    @Override // xn.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.u
    public void onError(Throwable th2) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(null, th2);
        } catch (Throwable th3) {
            a.b(th3);
            fo.a.s(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.u
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.u
    public void onSuccess(T t10) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(t10, null);
        } catch (Throwable th2) {
            a.b(th2);
            fo.a.s(th2);
        }
    }
}
