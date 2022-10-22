package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.a;
import zn.g;
/* loaded from: classes2.dex */
public final class CallbackCompletableObserver extends AtomicReference<b> implements io.reactivex.b, b, g<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final a onComplete;
    final g<? super Throwable> onError;

    public CallbackCompletableObserver(a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // xn.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.b
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            fo.a.s(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.b
    public void onError(Throwable th2) {
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            fo.a.s(th3);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.b
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void accept(Throwable th2) {
        fo.a.s(new OnErrorNotImplementedException(th2));
    }

    public CallbackCompletableObserver(g<? super Throwable> gVar, a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }
}
