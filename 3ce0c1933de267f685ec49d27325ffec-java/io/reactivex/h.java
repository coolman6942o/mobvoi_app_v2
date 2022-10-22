package io.reactivex;

import xn.b;
/* compiled from: MaybeObserver.java */
/* loaded from: classes2.dex */
public interface h<T> {
    void onComplete();

    void onError(Throwable th2);

    void onSubscribe(b bVar);

    void onSuccess(T t10);
}
