package io.reactivex.observers;

import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: TestObserver.java */
/* loaded from: classes3.dex */
public class a<T> extends BaseTestConsumer<T, a<T>> implements r<T>, b, h<T>, u<T> {

    /* renamed from: h  reason: collision with root package name */
    private final r<? super T> f29272h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicReference<b> f29273i;

    /* renamed from: j  reason: collision with root package name */
    private co.b<T> f29274j;

    /* compiled from: TestObserver.java */
    /* renamed from: io.reactivex.observers.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    enum EnumC0349a implements r<Object> {
        INSTANCE;

        @Override // io.reactivex.r
        public void onComplete() {
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
        }
    }

    public a() {
        this(EnumC0349a.INSTANCE);
    }

    @Override // xn.b
    public final void dispose() {
        DisposableHelper.dispose(this.f29273i);
    }

    @Override // xn.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f29273i.get());
    }

    @Override // io.reactivex.r
    public void onComplete() {
        if (!this.f29269e) {
            this.f29269e = true;
            if (this.f29273i.get() == null) {
                this.f29267c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.f29268d++;
            this.f29272h.onComplete();
        } finally {
            this.f29265a.countDown();
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        if (!this.f29269e) {
            this.f29269e = true;
            if (this.f29273i.get() == null) {
                this.f29267c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th2 == null) {
                this.f29267c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f29267c.add(th2);
            }
            this.f29272h.onError(th2);
        } finally {
            this.f29265a.countDown();
        }
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (!this.f29269e) {
            this.f29269e = true;
            if (this.f29273i.get() == null) {
                this.f29267c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        if (this.f29271g == 2) {
            while (true) {
                try {
                    T poll = this.f29274j.poll();
                    if (poll != null) {
                        this.f29266b.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    this.f29267c.add(th2);
                    this.f29274j.dispose();
                    return;
                }
            }
        } else {
            this.f29266b.add(t10);
            if (t10 == null) {
                this.f29267c.add(new NullPointerException("onNext received a null value"));
            }
            this.f29272h.onNext(t10);
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        Thread.currentThread();
        if (bVar == null) {
            this.f29267c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f29273i.compareAndSet(null, bVar)) {
            bVar.dispose();
            if (this.f29273i.get() != DisposableHelper.DISPOSED) {
                this.f29267c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
            }
        } else {
            int i10 = this.f29270f;
            if (i10 != 0 && (bVar instanceof co.b)) {
                co.b<T> bVar2 = (co.b) bVar;
                this.f29274j = bVar2;
                int requestFusion = bVar2.requestFusion(i10);
                this.f29271g = requestFusion;
                if (requestFusion == 1) {
                    this.f29269e = true;
                    Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f29274j.poll();
                            if (poll != null) {
                                this.f29266b.add(poll);
                            } else {
                                this.f29268d++;
                                this.f29273i.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th2) {
                            this.f29267c.add(th2);
                            return;
                        }
                    }
                }
            }
            this.f29272h.onSubscribe(bVar);
        }
    }

    @Override // io.reactivex.h
    public void onSuccess(T t10) {
        onNext(t10);
        onComplete();
    }

    public a(r<? super T> rVar) {
        this.f29273i = new AtomicReference<>();
        this.f29272h = rVar;
    }
}
