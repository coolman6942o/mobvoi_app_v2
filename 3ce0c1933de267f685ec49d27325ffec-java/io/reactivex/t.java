package io.reactivex;

import bo.b;
import fo.a;
import io.reactivex.internal.observers.f;
import zn.o;
/* compiled from: Single.java */
/* loaded from: classes2.dex */
public abstract class t<T> implements v<T> {
    @Override // io.reactivex.v
    public final void b(u<? super T> uVar) {
        b.e(uVar, "observer is null");
        u<? super T> y10 = a.y(this, uVar);
        b.e(y10, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            e(y10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public final T c() {
        f fVar = new f();
        b(fVar);
        return (T) fVar.a();
    }

    public final <R> t<R> d(o<? super T, ? extends R> oVar) {
        b.e(oVar, "mapper is null");
        return a.p(new io.reactivex.internal.operators.single.a(this, oVar));
    }

    protected abstract void e(u<? super T> uVar);

    public final k<T> f() {
        if (this instanceof co.a) {
            return ((co.a) this).a();
        }
        return a.o(new io.reactivex.internal.operators.single.b(this));
    }
}
