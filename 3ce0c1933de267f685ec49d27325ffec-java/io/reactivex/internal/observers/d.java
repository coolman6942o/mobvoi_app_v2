package io.reactivex.internal.observers;
/* compiled from: BlockingFirstObserver.java */
/* loaded from: classes2.dex */
public final class d<T> extends c<T> {
    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        if (this.f28358a == null) {
            this.f28359b = th2;
        }
        countDown();
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (this.f28358a == null) {
            this.f28358a = t10;
            this.f28360c.dispose();
            countDown();
        }
    }
}
