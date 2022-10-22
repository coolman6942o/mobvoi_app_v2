package io.reactivex.internal.operators.observable;

import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
/* compiled from: ObservableFromUnsafeSource.java */
/* loaded from: classes3.dex */
public final class g1<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28671a;

    public g1(p<T> pVar) {
        this.f28671a = pVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28671a.subscribe(rVar);
    }
}
