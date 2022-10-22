package io.reactivex.internal.disposables;

import co.b;
import io.reactivex.h;
import io.reactivex.r;
import io.reactivex.u;
/* loaded from: classes.dex */
public enum EmptyDisposable implements b<Object> {
    INSTANCE,
    NEVER;

    public static void complete(r<?> rVar) {
        rVar.onSubscribe(INSTANCE);
        rVar.onComplete();
    }

    public static void error(Throwable th2, r<?> rVar) {
        rVar.onSubscribe(INSTANCE);
        rVar.onError(th2);
    }

    @Override // co.g
    public void clear() {
    }

    @Override // xn.b
    public void dispose() {
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // co.g
    public boolean isEmpty() {
        return true;
    }

    @Override // co.g
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // co.g
    public Object poll() throws Exception {
        return null;
    }

    @Override // co.c
    public int requestFusion(int i10) {
        return i10 & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(h<?> hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onComplete();
    }

    public static void error(Throwable th2, io.reactivex.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th2);
    }

    public static void complete(io.reactivex.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th2, u<?> uVar) {
        uVar.onSubscribe(INSTANCE);
        uVar.onError(th2);
    }

    public static void error(Throwable th2, h<?> hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onError(th2);
    }
}
