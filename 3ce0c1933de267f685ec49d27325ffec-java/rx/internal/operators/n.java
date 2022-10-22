package rx.internal.operators;

import rx.c;
import rx.exceptions.a;
import rx.i;
/* compiled from: OnSubscribeLift.java */
/* loaded from: classes3.dex */
public final class n<T, R> implements c.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final c.a<T> f33862a;

    /* renamed from: b  reason: collision with root package name */
    final c.b<? extends R, ? super T> f33863b;

    public n(c.a<T> aVar, c.b<? extends R, ? super T> bVar) {
        this.f33862a = aVar;
        this.f33863b = bVar;
    }

    /* renamed from: a */
    public void call(i<? super R> iVar) {
        try {
            i<? super T> call = bq.c.m(this.f33863b).call(iVar);
            call.onStart();
            this.f33862a.call(call);
        } catch (Throwable th2) {
            a.e(th2);
            iVar.onError(th2);
        }
    }
}
