package io.reactivex.internal.operators.observable;

import bo.b;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.j2;
import io.reactivex.p;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.Callable;
import zn.c;
/* compiled from: ObservableReduceWithSingle.java */
/* loaded from: classes3.dex */
public final class k2<T, R> extends t<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28781a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<R> f28782b;

    /* renamed from: c  reason: collision with root package name */
    final c<R, ? super T, R> f28783c;

    public k2(p<T> pVar, Callable<R> callable, c<R, ? super T, R> cVar) {
        this.f28781a = pVar;
        this.f28782b = callable;
        this.f28783c = cVar;
    }

    @Override // io.reactivex.t
    protected void e(u<? super R> uVar) {
        try {
            this.f28781a.subscribe(new j2.a(uVar, this.f28783c, b.e(this.f28782b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th2) {
            a.b(th2);
            EmptyDisposable.error(th2, uVar);
        }
    }
}
