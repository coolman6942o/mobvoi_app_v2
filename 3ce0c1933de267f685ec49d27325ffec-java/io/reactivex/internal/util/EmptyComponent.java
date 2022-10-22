package io.reactivex.internal.util;

import fo.a;
import io.reactivex.b;
import io.reactivex.f;
import io.reactivex.h;
import io.reactivex.r;
import io.reactivex.u;
import vp.c;
/* loaded from: classes3.dex */
public enum EmptyComponent implements f<Object>, r<Object>, h<Object>, u<Object>, b, c, xn.b {
    INSTANCE;

    public static <T> r<T> asObserver() {
        return INSTANCE;
    }

    public static <T> vp.b<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // vp.c
    public void cancel() {
    }

    @Override // xn.b
    public void dispose() {
    }

    @Override // xn.b
    public boolean isDisposed() {
        return true;
    }

    @Override // vp.b
    public void onComplete() {
    }

    @Override // vp.b
    public void onError(Throwable th2) {
        a.s(th2);
    }

    @Override // vp.b
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.r
    public void onSubscribe(xn.b bVar) {
        bVar.dispose();
    }

    @Override // io.reactivex.h
    public void onSuccess(Object obj) {
    }

    @Override // vp.c
    public void request(long j10) {
    }

    @Override // vp.b
    public void onSubscribe(c cVar) {
        cVar.cancel();
    }
}
