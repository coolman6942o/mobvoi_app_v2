package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;
import rx.exceptions.a;
import rx.i;
/* loaded from: classes3.dex */
public final class SingleProducer<T> extends AtomicBoolean implements e {
    private static final long serialVersionUID = -3353584923995471404L;
    final i<? super T> child;
    final T value;

    public SingleProducer(i<? super T> iVar, T t10) {
        this.child = iVar;
        this.value = t10;
    }

    @Override // rx.e
    public void request(long j10) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i10 != 0 && compareAndSet(false, true)) {
            i<? super T> iVar = this.child;
            if (!iVar.isUnsubscribed()) {
                Object obj = (T) this.value;
                try {
                    iVar.onNext(obj);
                    if (!iVar.isUnsubscribed()) {
                        iVar.onCompleted();
                    }
                } catch (Throwable th2) {
                    a.g(th2, iVar, obj);
                }
            }
        }
    }
}
