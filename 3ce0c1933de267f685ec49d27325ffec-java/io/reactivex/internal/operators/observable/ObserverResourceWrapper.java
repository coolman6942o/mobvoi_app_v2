package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* loaded from: classes3.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<b> implements r<T>, b {
    private static final long serialVersionUID = -8612022020200669122L;
    final r<? super T> downstream;
    final AtomicReference<b> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(r<? super T> rVar) {
        this.downstream = rVar;
    }

    @Override // xn.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.r
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        dispose();
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        this.downstream.onNext(t10);
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
