package io.reactivex.internal.operators.observable;

import bo.b;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.Callable;
/* compiled from: ObservableDefer.java */
/* loaded from: classes3.dex */
public final class e0<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends p<? extends T>> f28552a;

    public e0(Callable<? extends p<? extends T>> callable) {
        this.f28552a = callable;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        try {
            ((p) b.e(this.f28552a.call(), "null ObservableSource supplied")).subscribe(rVar);
        } catch (Throwable th2) {
            a.b(th2);
            EmptyDisposable.error(th2, rVar);
        }
    }
}
