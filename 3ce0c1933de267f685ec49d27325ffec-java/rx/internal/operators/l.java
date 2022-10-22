package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.e;
import rx.i;
/* compiled from: OnSubscribeFromArray.java */
/* loaded from: classes3.dex */
public final class l<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final T[] f33859a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFromArray.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicLong implements e {
        private static final long serialVersionUID = 3534218984725836979L;
        final T[] array;
        final i<? super T> child;
        int index;

        public a(i<? super T> iVar, T[] tArr) {
            this.child = iVar;
            this.array = tArr;
        }

        void a() {
            i<? super T> iVar = this.child;
            for (T t10 : this.array) {
                Object obj = (Object) t10;
                if (!iVar.isUnsubscribed()) {
                    iVar.onNext(obj);
                } else {
                    return;
                }
            }
            if (!iVar.isUnsubscribed()) {
                iVar.onCompleted();
            }
        }

        void b(long j10) {
            i<? super T> iVar = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i10 = this.index;
            do {
                long j11 = 0;
                while (true) {
                    if (j10 == 0 || i10 == length) {
                        j10 = get() + j11;
                        if (j10 == 0) {
                            this.index = i10;
                            j10 = addAndGet(j11);
                        }
                    } else if (!iVar.isUnsubscribed()) {
                        iVar.onNext((Object) tArr[i10]);
                        i10++;
                        if (i10 != length) {
                            j10--;
                            j11--;
                        } else if (!iVar.isUnsubscribed()) {
                            iVar.onCompleted();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j10 != 0);
        }

        @Override // rx.e
        public void request(long j10) {
            int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
            if (i10 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j10);
            } else if (j10 == Long.MAX_VALUE) {
                if (rx.internal.operators.a.b(this, j10) == 0) {
                    a();
                }
            } else if (i10 != 0 && rx.internal.operators.a.b(this, j10) == 0) {
                b(j10);
            }
        }
    }

    public l(T[] tArr) {
        this.f33859a = tArr;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        iVar.setProducer(new a(iVar, this.f33859a));
    }
}
