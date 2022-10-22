package rx.internal.operators;

import rx.i;
/* compiled from: DeferredScalarSubscriberSafe.java */
/* loaded from: classes3.dex */
public abstract class c<T, R> extends b<T, R> {

    /* renamed from: e  reason: collision with root package name */
    protected boolean f33737e;

    public c(i<? super R> iVar) {
        super(iVar);
    }

    @Override // rx.internal.operators.b, rx.d
    public void onCompleted() {
        if (!this.f33737e) {
            this.f33737e = true;
            super.onCompleted();
        }
    }

    @Override // rx.internal.operators.b, rx.d
    public void onError(Throwable th2) {
        if (!this.f33737e) {
            this.f33737e = true;
            super.onError(th2);
            return;
        }
        bq.c.i(th2);
    }
}
