package rx.internal.operators;

import aq.e;
import rx.c;
import rx.exceptions.a;
import rx.i;
import yp.f;
/* compiled from: OnSubscribeDefer.java */
/* loaded from: classes3.dex */
public final class h<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final f<? extends c<? extends T>> f33824a;

    public h(f<? extends c<? extends T>> fVar) {
        this.f33824a = fVar;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        try {
            this.f33824a.call().j0(e.c(iVar));
        } catch (Throwable th2) {
            a.f(th2, iVar);
        }
    }
}
