package io.reactivex.internal.operators.observable;

import co.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.r;
/* compiled from: ObservableEmpty.java */
/* loaded from: classes3.dex */
public final class s0 extends k<Object> implements e<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final k<Object> f29027a = new s0();

    private s0() {
    }

    @Override // co.e, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super Object> rVar) {
        EmptyDisposable.complete(rVar);
    }
}
