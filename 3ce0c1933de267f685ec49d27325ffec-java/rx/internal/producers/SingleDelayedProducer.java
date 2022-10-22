package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.e;
import rx.exceptions.a;
import rx.i;
/* loaded from: classes3.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements e {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final i<? super T> child;
    T value;

    public SingleDelayedProducer(i<? super T> iVar) {
        this.child = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(i<? super T> iVar, T t10) {
        if (!iVar.isUnsubscribed()) {
            try {
                iVar.onNext(t10);
                if (!iVar.isUnsubscribed()) {
                    iVar.onCompleted();
                }
            } catch (Throwable th2) {
                a.g(th2, iVar, t10);
            }
        }
    }

    @Override // rx.e
    public void request(long j10) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i10 != 0) {
            do {
                int i11 = get();
                if (i11 != 0) {
                    if (i11 == 1 && compareAndSet(1, 3)) {
                        a(this.child, this.value);
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public void setValue(T t10) {
        do {
            int i10 = get();
            if (i10 == 0) {
                this.value = t10;
            } else if (i10 == 2 && compareAndSet(2, 3)) {
                a(this.child, t10);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }
}
