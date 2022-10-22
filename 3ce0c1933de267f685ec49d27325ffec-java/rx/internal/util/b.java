package rx.internal.util;

import rx.i;
import yp.a;
/* compiled from: ActionSubscriber.java */
/* loaded from: classes3.dex */
public final class b<T> extends i<T> {

    /* renamed from: a  reason: collision with root package name */
    final yp.b<? super T> f34119a;

    /* renamed from: b  reason: collision with root package name */
    final yp.b<Throwable> f34120b;

    /* renamed from: c  reason: collision with root package name */
    final a f34121c;

    public b(yp.b<? super T> bVar, yp.b<Throwable> bVar2, a aVar) {
        this.f34119a = bVar;
        this.f34120b = bVar2;
        this.f34121c = aVar;
    }

    @Override // rx.d
    public void onCompleted() {
        this.f34121c.call();
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.f34120b.call(th2);
    }

    @Override // rx.d
    public void onNext(T t10) {
        this.f34119a.call(t10);
    }
}
