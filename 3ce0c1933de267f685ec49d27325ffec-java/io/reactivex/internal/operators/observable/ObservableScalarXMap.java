package io.reactivex.internal.operators.observable;

import co.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import zn.o;
/* loaded from: classes3.dex */
public final class ObservableScalarXMap {

    /* loaded from: classes3.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements b<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final r<? super T> observer;
        final T value;

        public ScalarDisposable(r<? super T> rVar, T t10) {
            this.observer = rVar;
            this.value = t10;
        }

        @Override // co.g
        public void clear() {
            lazySet(3);
        }

        @Override // xn.b
        public void dispose() {
            set(3);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // co.g
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // co.g
        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // co.g
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // co.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext((T) this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        public boolean offer(T t10, T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends k<R> {

        /* renamed from: a  reason: collision with root package name */
        final T f28424a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super T, ? extends p<? extends R>> f28425b;

        a(T t10, o<? super T, ? extends p<? extends R>> oVar) {
            this.f28424a = t10;
            this.f28425b = oVar;
        }

        @Override // io.reactivex.k
        public void subscribeActual(r<? super R> rVar) {
            try {
                p pVar = (p) bo.b.e(this.f28425b.apply((T) this.f28424a), "The mapper returned a null ObservableSource");
                if (pVar instanceof Callable) {
                    try {
                        Object call = ((Callable) pVar).call();
                        if (call == null) {
                            EmptyDisposable.complete(rVar);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(rVar, call);
                        rVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        EmptyDisposable.error(th2, rVar);
                    }
                } else {
                    pVar.subscribe(rVar);
                }
            } catch (Throwable th3) {
                EmptyDisposable.error(th3, rVar);
            }
        }
    }

    public static <T, U> k<U> a(T t10, o<? super T, ? extends p<? extends U>> oVar) {
        return fo.a.o(new a(t10, oVar));
    }

    public static <T, R> boolean b(p<T> pVar, r<? super R> rVar, o<? super T, ? extends p<? extends R>> oVar) {
        if (!(pVar instanceof Callable)) {
            return false;
        }
        try {
            Object obj = (Object) ((Callable) pVar).call();
            if (obj == 0) {
                EmptyDisposable.complete(rVar);
                return true;
            }
            try {
                p pVar2 = (p) bo.b.e(oVar.apply(obj), "The mapper returned a null ObservableSource");
                if (pVar2 instanceof Callable) {
                    try {
                        Object call = ((Callable) pVar2).call();
                        if (call == null) {
                            EmptyDisposable.complete(rVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(rVar, call);
                        rVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        EmptyDisposable.error(th2, rVar);
                        return true;
                    }
                } else {
                    pVar2.subscribe(rVar);
                }
                return true;
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                EmptyDisposable.error(th3, rVar);
                return true;
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            EmptyDisposable.error(th4, rVar);
            return true;
        }
    }
}
