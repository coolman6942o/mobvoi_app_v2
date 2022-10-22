package rx;
/* compiled from: Observer.java */
/* loaded from: classes3.dex */
public interface d<T> {
    void onCompleted();

    void onError(Throwable th2);

    void onNext(T t10);
}
