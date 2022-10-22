package io.reactivex.internal.observers;
/* compiled from: BlockingLastObserver.java */
/* loaded from: classes2.dex */
public final class e<T> extends c<T> {
    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        this.f28358a = null;
        this.f28359b = th2;
        countDown();
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        this.f28358a = t10;
    }
}
