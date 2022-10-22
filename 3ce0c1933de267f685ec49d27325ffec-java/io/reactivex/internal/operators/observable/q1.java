package io.reactivex.internal.operators.observable;

import co.e;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.k;
import io.reactivex.r;
/* compiled from: ObservableJust.java */
/* loaded from: classes3.dex */
public final class q1<T> extends k<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f28987a;

    public q1(T t10) {
        this.f28987a = t10;
    }

    @Override // co.e, java.util.concurrent.Callable
    public T call() {
        return this.f28987a;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(rVar, this.f28987a);
        rVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
