package io.reactivex.internal.operators.observable;

import bo.b;
import io.reactivex.exceptions.a;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* compiled from: ObservableFromFuture.java */
/* loaded from: classes3.dex */
public final class d1<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final Future<? extends T> f28516a;

    /* renamed from: b  reason: collision with root package name */
    final long f28517b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f28518c;

    public d1(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        this.f28516a = future;
        this.f28517b = j10;
        this.f28518c = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(rVar);
        rVar.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                TimeUnit timeUnit = this.f28518c;
                deferredScalarDisposable.complete(b.e(timeUnit != null ? this.f28516a.get(this.f28517b, timeUnit) : this.f28516a.get(), "Future returned null"));
            } catch (Throwable th2) {
                a.b(th2);
                if (!deferredScalarDisposable.isDisposed()) {
                    rVar.onError(th2);
                }
            }
        }
    }
}
