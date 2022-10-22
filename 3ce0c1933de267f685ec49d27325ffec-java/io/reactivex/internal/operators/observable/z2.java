package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.k;
import io.reactivex.r;
/* compiled from: ObservableSerialized.java */
/* loaded from: classes3.dex */
public final class z2<T> extends a<T, T> {
    public z2(k<T> kVar) {
        super(kVar);
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new d(rVar));
    }
}
