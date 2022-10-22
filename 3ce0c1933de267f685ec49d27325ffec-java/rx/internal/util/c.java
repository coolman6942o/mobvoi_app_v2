package rx.internal.util;

import rx.d;
import rx.i;
/* compiled from: ObserverSubscriber.java */
/* loaded from: classes3.dex */
public final class c<T> extends i<T> {

    /* renamed from: a  reason: collision with root package name */
    final d<? super T> f34122a;

    public c(d<? super T> dVar) {
        this.f34122a = dVar;
    }

    @Override // rx.d
    public void onCompleted() {
        this.f34122a.onCompleted();
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.f34122a.onError(th2);
    }

    @Override // rx.d
    public void onNext(T t10) {
        this.f34122a.onNext(t10);
    }
}
