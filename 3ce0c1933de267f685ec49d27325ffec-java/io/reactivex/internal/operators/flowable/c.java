package io.reactivex.internal.operators.flowable;

import vp.b;
import yn.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowableGroupBy.java */
/* loaded from: classes2.dex */
public final class c<K, T> extends a<K, T> {

    /* renamed from: c  reason: collision with root package name */
    final d<T, K> f28383c;

    protected c(K k10, d<T, K> dVar) {
        super(k10);
        this.f28383c = dVar;
    }

    public static <T, K> c<K, T> i(K k10, int i10, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z10) {
        return new c<>(k10, new d(i10, flowableGroupBy$GroupBySubscriber, k10, z10));
    }

    @Override // io.reactivex.e
    protected void h(b<? super T> bVar) {
        this.f28383c.a(bVar);
    }

    public void j() {
        this.f28383c.onComplete();
    }

    public void k(Throwable th2) {
        this.f28383c.onError(th2);
    }

    public void l(T t10) {
        this.f28383c.onNext(t10);
    }
}
