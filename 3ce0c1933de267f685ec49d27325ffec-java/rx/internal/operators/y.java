package rx.internal.operators;

import aq.e;
import rx.c;
import rx.i;
import yp.a;
/* compiled from: OperatorDoOnSubscribe.java */
/* loaded from: classes3.dex */
public class y<T> implements c.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final a f33968a;

    public y(a aVar) {
        this.f33968a = aVar;
    }

    /* renamed from: a */
    public i<? super T> call(i<? super T> iVar) {
        this.f33968a.call();
        return e.c(iVar);
    }
}
