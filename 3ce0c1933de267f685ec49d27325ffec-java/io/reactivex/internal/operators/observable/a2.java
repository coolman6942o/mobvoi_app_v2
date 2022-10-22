package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.r;
/* compiled from: ObservableNever.java */
/* loaded from: classes3.dex */
public final class a2 extends k<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final k<Object> f28435a = new a2();

    private a2() {
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super Object> rVar) {
        rVar.onSubscribe(EmptyDisposable.NEVER);
    }
}
