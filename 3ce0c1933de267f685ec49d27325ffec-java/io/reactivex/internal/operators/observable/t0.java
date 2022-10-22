package io.reactivex.internal.operators.observable;

import bo.b;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.Callable;
/* compiled from: ObservableError.java */
/* loaded from: classes3.dex */
public final class t0<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends Throwable> f29044a;

    public t0(Callable<? extends Throwable> callable) {
        this.f29044a = callable;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        Throwable th2;
        try {
            th2 = (Throwable) b.e(this.f29044a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th3) {
            th2 = th3;
            a.b(th2);
        }
        EmptyDisposable.error(th2, rVar);
    }
}
