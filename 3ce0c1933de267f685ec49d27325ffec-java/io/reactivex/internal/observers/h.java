package io.reactivex.internal.observers;

import fo.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.c;
import io.reactivex.internal.util.f;
import io.reactivex.r;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: FutureObserver.java */
/* loaded from: classes2.dex */
public final class h<T> extends CountDownLatch implements r<T>, Future<T>, b {

    /* renamed from: a  reason: collision with root package name */
    T f28370a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f28371b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<b> f28372c = new AtomicReference<>();

    public h() {
        super(1);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        b bVar;
        DisposableHelper disposableHelper;
        do {
            bVar = this.f28372c.get();
            if (bVar == this || bVar == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.f28372c.compareAndSet(bVar, disposableHelper));
        if (bVar != null) {
            bVar.dispose();
        }
        countDown();
        return true;
    }

    @Override // xn.b
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            c.b();
            await();
        }
        if (!isCancelled()) {
            Throwable th2 = this.f28371b;
            if (th2 == null) {
                return this.f28370a;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f28372c.get());
    }

    @Override // xn.b
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // io.reactivex.r
    public void onComplete() {
        b bVar;
        if (this.f28370a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            bVar = this.f28372c.get();
            if (bVar == this || bVar == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!this.f28372c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        b bVar;
        if (this.f28371b == null) {
            this.f28371b = th2;
            do {
                bVar = this.f28372c.get();
                if (bVar == this || bVar == DisposableHelper.DISPOSED) {
                    a.s(th2);
                    return;
                }
            } while (!this.f28372c.compareAndSet(bVar, this));
            countDown();
            return;
        }
        a.s(th2);
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (this.f28370a != null) {
            this.f28372c.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f28370a = t10;
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.f28372c, bVar);
    }

    @Override // java.util.concurrent.Future
    public T get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            c.b();
            if (!await(j10, timeUnit)) {
                throw new TimeoutException(f.c(j10, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f28371b;
            if (th2 == null) {
                return this.f28370a;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
