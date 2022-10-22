package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p;
import io.reactivex.r;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: ObservableBuffer.java */
/* loaded from: classes3.dex */
public final class l<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final int f28789b;

    /* renamed from: c  reason: collision with root package name */
    final int f28790c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<U> f28791d;

    /* compiled from: ObservableBuffer.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> implements r<T>, xn.b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super U> f28792a;

        /* renamed from: b  reason: collision with root package name */
        final int f28793b;

        /* renamed from: c  reason: collision with root package name */
        final Callable<U> f28794c;

        /* renamed from: d  reason: collision with root package name */
        U f28795d;

        /* renamed from: e  reason: collision with root package name */
        int f28796e;

        /* renamed from: f  reason: collision with root package name */
        xn.b f28797f;

        a(r<? super U> rVar, int i10, Callable<U> callable) {
            this.f28792a = rVar;
            this.f28793b = i10;
            this.f28794c = callable;
        }

        boolean a() {
            try {
                this.f28795d = (U) bo.b.e(this.f28794c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f28795d = null;
                xn.b bVar = this.f28797f;
                if (bVar == null) {
                    EmptyDisposable.error(th2, this.f28792a);
                    return false;
                }
                bVar.dispose();
                this.f28792a.onError(th2);
                return false;
            }
        }

        @Override // xn.b
        public void dispose() {
            this.f28797f.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28797f.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            U u10 = this.f28795d;
            if (u10 != null) {
                this.f28795d = null;
                if (!u10.isEmpty()) {
                    this.f28792a.onNext(u10);
                }
                this.f28792a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28795d = null;
            this.f28792a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            U u10 = this.f28795d;
            if (u10 != null) {
                u10.add(t10);
                int i10 = this.f28796e + 1;
                this.f28796e = i10;
                if (i10 >= this.f28793b) {
                    this.f28792a.onNext(u10);
                    this.f28796e = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28797f, bVar)) {
                this.f28797f = bVar;
                this.f28792a.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableBuffer.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>> extends AtomicBoolean implements r<T>, xn.b {
        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        final r<? super U> downstream;
        long index;
        final int skip;
        xn.b upstream;

        b(r<? super U> rVar, int i10, int i11, Callable<U> callable) {
            this.downstream = rVar;
            this.count = i10;
            this.skip = i11;
            this.bufferSupplier = callable;
        }

        @Override // xn.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.buffers.clear();
            this.downstream.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.r
        public void onNext(T t10) {
            long j10 = this.index;
            this.index = 1 + j10;
            if (j10 % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) bo.b.e(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th2) {
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th2);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t10);
                if (this.count <= next.size()) {
                    it.remove();
                    this.downstream.onNext(next);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public l(p<T> pVar, int i10, int i11, Callable<U> callable) {
        super(pVar);
        this.f28789b = i10;
        this.f28790c = i11;
        this.f28791d = callable;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super U> rVar) {
        int i10 = this.f28790c;
        int i11 = this.f28789b;
        if (i10 == i11) {
            a aVar = new a(rVar, i11, this.f28791d);
            if (aVar.a()) {
                this.f28426a.subscribe(aVar);
                return;
            }
            return;
        }
        this.f28426a.subscribe(new b(rVar, this.f28789b, this.f28790c, this.f28791d));
    }
}
