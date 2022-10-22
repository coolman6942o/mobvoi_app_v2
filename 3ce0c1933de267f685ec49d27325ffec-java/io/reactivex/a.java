package io.reactivex;

import bo.b;
/* compiled from: Completable.java */
/* loaded from: classes2.dex */
public abstract class a implements c {
    private static NullPointerException d(Throwable th2) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th2);
        return nullPointerException;
    }

    @Override // io.reactivex.c
    public final void b(b bVar) {
        b.e(bVar, "observer is null");
        try {
            b v10 = fo.a.v(this, bVar);
            b.e(v10, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            c(v10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            fo.a.s(th2);
            throw d(th2);
        }
    }

    protected abstract void c(b bVar);
}
