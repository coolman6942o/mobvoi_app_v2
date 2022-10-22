package rx.internal.operators;

import aq.e;
import java.util.concurrent.atomic.AtomicInteger;
import rx.c;
import rx.i;
import rx.j;
import yp.b;
import zp.a;
/* loaded from: classes3.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements c.a<T> {
    final b<? super j> connection;
    final int numberOfSubscribers;
    final a<? extends T> source;

    public OnSubscribeAutoConnect(a<? extends T> aVar, int i10, b<? super j> bVar) {
        if (i10 > 0) {
            this.source = aVar;
            this.numberOfSubscribers = i10;
            this.connection = bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // yp.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i) ((i) obj));
    }

    public void call(i<? super T> iVar) {
        this.source.j0(e.c(iVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.m0(this.connection);
        }
    }
}
