package aq;

import rx.i;
/* compiled from: SerializedSubscriber.java */
/* loaded from: classes3.dex */
public class d<T> extends i<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.d<T> f4916a;

    public d(i<? super T> iVar) {
        this(iVar, true);
    }

    @Override // rx.d
    public void onCompleted() {
        this.f4916a.onCompleted();
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.f4916a.onError(th2);
    }

    @Override // rx.d
    public void onNext(T t10) {
        this.f4916a.onNext(t10);
    }

    public d(i<? super T> iVar, boolean z10) {
        super(iVar, z10);
        this.f4916a = new c(iVar);
    }
}
