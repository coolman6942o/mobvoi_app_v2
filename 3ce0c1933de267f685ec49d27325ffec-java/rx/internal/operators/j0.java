package rx.internal.operators;

import rx.h;
import rx.i;
import rx.internal.producers.SingleProducer;
/* compiled from: SingleLiftObservableOperator.java */
/* loaded from: classes3.dex */
final class j0<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    final i<? super T> f33847b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(i<? super T> iVar) {
        this.f33847b = iVar;
    }

    @Override // rx.h
    public void b(Throwable th2) {
        this.f33847b.onError(th2);
    }

    @Override // rx.h
    public void c(T t10) {
        this.f33847b.setProducer(new SingleProducer(this.f33847b, t10));
    }
}
