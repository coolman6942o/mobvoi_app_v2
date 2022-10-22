package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.c;
import io.reactivex.internal.util.f;
import io.reactivex.p;
import io.reactivex.r;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: BlockingObservableIterable.java */
/* loaded from: classes3.dex */
public final class b<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<? extends T> f28445a;

    /* renamed from: b  reason: collision with root package name */
    final int f28446b;

    /* compiled from: BlockingObservableIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<xn.b> implements r<T>, Iterator<T>, xn.b {
        private static final long serialVersionUID = 6695226475494099826L;
        final Condition condition;
        volatile boolean done;
        Throwable error;
        final Lock lock;
        final io.reactivex.internal.queue.b<T> queue;

        a(int i10) {
            this.queue = new io.reactivex.internal.queue.b<>(i10);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        void a() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z10 = this.done;
                boolean isEmpty = this.queue.isEmpty();
                if (z10) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        throw f.d(th2);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                try {
                    c.b();
                    this.lock.lock();
                    while (!this.done && this.queue.isEmpty()) {
                        this.condition.await();
                    }
                    this.lock.unlock();
                } catch (InterruptedException e10) {
                    DisposableHelper.dispose(this);
                    a();
                    throw f.d(e10);
                }
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.queue.offer(t10);
            a();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public b(p<? extends T> pVar, int i10) {
        this.f28445a = pVar;
        this.f28446b = i10;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f28446b);
        this.f28445a.subscribe(aVar);
        return aVar;
    }
}
