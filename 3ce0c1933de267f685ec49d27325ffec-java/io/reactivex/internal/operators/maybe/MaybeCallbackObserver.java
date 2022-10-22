package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.a;
import zn.g;
/* loaded from: classes2.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<b> implements h<T>, b {
    private static final long serialVersionUID = -6076952298809384986L;
    final a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public MaybeCallbackObserver(g<? super T> gVar, g<? super Throwable> gVar2, a aVar) {
        this.onSuccess = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
    }

    @Override // xn.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != bo.a.f5361e;
    }

    @Override // xn.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.h
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            fo.a.s(th2);
        }
    }

    @Override // io.reactivex.h
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            fo.a.s(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.h
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.h
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
