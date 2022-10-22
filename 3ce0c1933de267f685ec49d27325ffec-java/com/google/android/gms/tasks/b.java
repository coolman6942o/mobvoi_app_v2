package com.google.android.gms.tasks;

import b7.a;
import b7.c;
import b7.d;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class b<TResult> {
    public abstract b<TResult> a(Executor executor, a aVar);

    public abstract b<TResult> b(b7.b<TResult> bVar);

    public abstract b<TResult> c(Executor executor, b7.b<TResult> bVar);

    public abstract b<TResult> d(c cVar);

    public abstract b<TResult> e(Executor executor, c cVar);

    public abstract b<TResult> f(d<? super TResult> dVar);

    public abstract b<TResult> g(Executor executor, d<? super TResult> dVar);

    public abstract <TContinuationResult> b<TContinuationResult> h(a<TResult, TContinuationResult> aVar);

    public abstract <TContinuationResult> b<TContinuationResult> i(Executor executor, a<TResult, TContinuationResult> aVar);

    public abstract Exception j();

    public abstract TResult k();

    public abstract <X extends Throwable> TResult l(Class<X> cls) throws Throwable;

    public abstract boolean m();

    public abstract boolean n();

    public abstract boolean o();
}
