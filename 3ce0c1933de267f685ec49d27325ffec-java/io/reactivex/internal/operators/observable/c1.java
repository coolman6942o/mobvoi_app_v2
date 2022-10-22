package io.reactivex.internal.operators.observable;

import bo.b;
import io.reactivex.exceptions.a;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.Callable;
/* compiled from: ObservableFromCallable.java */
/* loaded from: classes3.dex */
public final class c1<T> extends k<T> implements Callable<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f28483a;

    public c1(Callable<? extends T> callable) {
        this.f28483a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) b.e(this.f28483a.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(rVar);
        rVar.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.complete(b.e(this.f28483a.call(), "Callable returned null"));
            } catch (Throwable th2) {
                a.b(th2);
                if (!deferredScalarDisposable.isDisposed()) {
                    rVar.onError(th2);
                } else {
                    fo.a.s(th2);
                }
            }
        }
    }
}
