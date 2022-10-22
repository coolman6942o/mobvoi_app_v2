package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.c;
import rx.exceptions.a;
import rx.i;
import rx.internal.producers.SingleDelayedProducer;
/* compiled from: OnSubscribeFromCallable.java */
/* loaded from: classes3.dex */
public final class m<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Callable<? extends T> f33861a;

    public m(Callable<? extends T> callable) {
        this.f33861a = callable;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(iVar);
        iVar.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.setValue(this.f33861a.call());
        } catch (Throwable th2) {
            a.f(th2, iVar);
        }
    }
}
