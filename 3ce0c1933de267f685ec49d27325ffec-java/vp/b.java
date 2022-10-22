package vp;
/* compiled from: Subscriber.java */
/* loaded from: classes3.dex */
public interface b<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t10);

    void onSubscribe(c cVar);
}
