package io.reactivex.internal.operators.observable;

import bo.b;
import io.reactivex.exceptions.a;
import io.reactivex.o;
import io.reactivex.p;
import io.reactivex.r;
/* compiled from: ObservableLift.java */
/* loaded from: classes3.dex */
public final class t1<R, T> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final o<? extends R, ? super T> f29045b;

    public t1(p<T> pVar, o<? extends R, ? super T> oVar) {
        super(pVar);
        this.f29045b = oVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super R> rVar) {
        try {
            r<? super Object> a10 = this.f29045b.a(rVar);
            this.f28426a.subscribe((r) b.e(a10, "Operator " + this.f29045b + " returned a null Observer"));
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            a.b(th2);
            fo.a.s(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
