package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import xn.b;
import zn.g;
import zn.o;
/* compiled from: ObservableUsing.java */
/* loaded from: classes3.dex */
public final class a4<T, D> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends D> f28441a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super D, ? extends p<? extends T>> f28442b;

    /* renamed from: c  reason: collision with root package name */
    final g<? super D> f28443c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f28444d;

    /* compiled from: ObservableUsing.java */
    /* loaded from: classes3.dex */
    static final class a<T, D> extends AtomicBoolean implements r<T>, b {
        private static final long serialVersionUID = 5904473792286235046L;
        final g<? super D> disposer;
        final r<? super T> downstream;
        final boolean eager;
        final D resource;
        b upstream;

        a(r<? super T> rVar, D d10, g<? super D> gVar, boolean z10) {
            this.downstream = rVar;
            this.resource = d10;
            this.disposer = gVar;
            this.eager = z10;
        }

        void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    fo.a.s(th2);
                }
            }
        }

        @Override // xn.b
        public void dispose() {
            a();
            this.upstream.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.downstream.onError(th2);
                        return;
                    }
                }
                this.upstream.dispose();
                this.downstream.onComplete();
                return;
            }
            this.downstream.onComplete();
            this.upstream.dispose();
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                }
                this.upstream.dispose();
                this.downstream.onError(th2);
                return;
            }
            this.downstream.onError(th2);
            this.upstream.dispose();
            a();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public a4(Callable<? extends D> callable, o<? super D, ? extends p<? extends T>> oVar, g<? super D> gVar, boolean z10) {
        this.f28441a = callable;
        this.f28442b = oVar;
        this.f28443c = gVar;
        this.f28444d = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        try {
            D call = this.f28441a.call();
            try {
                ((p) bo.b.e(this.f28442b.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new a(rVar, call, this.f28443c, this.f28444d));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                try {
                    this.f28443c.accept(call);
                    EmptyDisposable.error(th2, rVar);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    EmptyDisposable.error(new CompositeException(th2, th3), rVar);
                }
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            EmptyDisposable.error(th4, rVar);
        }
    }
}
