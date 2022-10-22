package io.reactivex.internal.observers;

import fo.a;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* loaded from: classes2.dex */
public final class EmptyCompletableObserver extends AtomicReference<b> implements io.reactivex.b, b {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // xn.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.b
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.b
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        a.s(new OnErrorNotImplementedException(th2));
    }

    @Override // io.reactivex.b
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
