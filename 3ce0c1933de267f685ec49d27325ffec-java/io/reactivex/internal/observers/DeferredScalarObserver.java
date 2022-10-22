package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import xn.b;
/* loaded from: classes2.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements r<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected b upstream;

    public DeferredScalarObserver(r<? super R> rVar) {
        super(rVar);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // io.reactivex.r
    public void onComplete() {
        T t10 = this.value;
        if (t10 != null) {
            this.value = null;
            complete(t10);
            return;
        }
        complete();
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        this.value = null;
        error(th2);
    }

    @Override // io.reactivex.r
    public abstract /* synthetic */ void onNext(T t10);

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
