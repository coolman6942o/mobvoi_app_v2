package rx.internal.operators;

import rx.c;
import rx.g;
import rx.i;
/* compiled from: SingleToObservable.java */
/* loaded from: classes3.dex */
public final class l0<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final g.c<T> f33860a;

    public l0(g.c<T> cVar) {
        this.f33860a = cVar;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        j0 j0Var = new j0(iVar);
        iVar.add(j0Var);
        this.f33860a.call(j0Var);
    }
}
