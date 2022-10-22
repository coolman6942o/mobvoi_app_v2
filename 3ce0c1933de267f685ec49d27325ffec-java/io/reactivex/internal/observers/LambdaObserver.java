package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.a;
import zn.g;
/* loaded from: classes2.dex */
public final class LambdaObserver<T> extends AtomicReference<b> implements r<T>, b {
    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super b> onSubscribe;

    public LambdaObserver(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super b> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
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
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.r
    public void onComplete() {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onComplete.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                fo.a.s(th2);
            }
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onError.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                fo.a.s(new CompositeException(th2, th3));
            }
        } else {
            fo.a.s(th2);
        }
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                get().dispose();
                onError(th2);
            }
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                bVar.dispose();
                onError(th2);
            }
        }
    }
}
