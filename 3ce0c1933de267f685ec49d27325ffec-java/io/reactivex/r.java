package io.reactivex;

import xn.b;
/* compiled from: Observer.java */
/* loaded from: classes2.dex */
public interface r<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t10);

    void onSubscribe(b bVar);
}
