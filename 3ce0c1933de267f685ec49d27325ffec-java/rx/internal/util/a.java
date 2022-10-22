package rx.internal.util;

import rx.d;
import yp.b;
/* compiled from: ActionObserver.java */
/* loaded from: classes3.dex */
public final class a<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    final b<? super T> f34097a;

    /* renamed from: b  reason: collision with root package name */
    final b<? super Throwable> f34098b;

    /* renamed from: c  reason: collision with root package name */
    final yp.a f34099c;

    public a(b<? super T> bVar, b<? super Throwable> bVar2, yp.a aVar) {
        this.f34097a = bVar;
        this.f34098b = bVar2;
        this.f34099c = aVar;
    }

    @Override // rx.d
    public void onCompleted() {
        this.f34099c.call();
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.f34098b.call(th2);
    }

    @Override // rx.d
    public void onNext(T t10) {
        this.f34097a.call(t10);
    }
}
