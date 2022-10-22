package io.reactivex.internal.observers;

import bo.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.g;
/* loaded from: classes2.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<b> implements u<T>, b {
    private static final long serialVersionUID = -7012088219455310787L;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public ConsumerSingleObserver(g<? super T> gVar, g<? super Throwable> gVar2) {
        this.onSuccess = gVar;
        this.onError = gVar2;
    }

    @Override // xn.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != a.f5361e;
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.u
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            fo.a.s(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.u
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.u
    public void onSuccess(T t10) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t10);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            fo.a.s(th2);
        }
    }
}
