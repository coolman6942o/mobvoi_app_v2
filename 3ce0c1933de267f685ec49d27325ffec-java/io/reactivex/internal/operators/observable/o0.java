package io.reactivex.internal.operators.observable;

import io.reactivex.k;
import io.reactivex.r;
import xn.b;
import zn.a;
import zn.g;
/* compiled from: ObservableDoOnLifecycle.java */
/* loaded from: classes3.dex */
public final class o0<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    private final g<? super b> f28885b;

    /* renamed from: c  reason: collision with root package name */
    private final a f28886c;

    public o0(k<T> kVar, g<? super b> gVar, a aVar) {
        super(kVar);
        this.f28885b = gVar;
        this.f28886c = aVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new io.reactivex.internal.observers.g(rVar, this.f28885b, this.f28886c));
    }
}
