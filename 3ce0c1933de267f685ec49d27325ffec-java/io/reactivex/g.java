package io.reactivex;

import bo.b;
import fo.a;
import io.reactivex.internal.observers.f;
/* compiled from: Maybe.java */
/* loaded from: classes2.dex */
public abstract class g<T> implements i<T> {
    @Override // io.reactivex.i
    public final void b(h<? super T> hVar) {
        b.e(hVar, "observer is null");
        h<? super T> w10 = a.w(this, hVar);
        b.e(w10, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            d(w10);
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

    protected abstract void d(h<? super T> hVar);
}
