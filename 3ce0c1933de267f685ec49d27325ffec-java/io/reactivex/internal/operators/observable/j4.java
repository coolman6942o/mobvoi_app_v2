package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.r;
import java.util.Iterator;
import xn.b;
import zn.c;
/* compiled from: ObservableZipIterable.java */
/* loaded from: classes3.dex */
public final class j4<T, U, V> extends k<V> {

    /* renamed from: a  reason: collision with root package name */
    final k<? extends T> f28765a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<U> f28766b;

    /* renamed from: c  reason: collision with root package name */
    final c<? super T, ? super U, ? extends V> f28767c;

    /* compiled from: ObservableZipIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T, U, V> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super V> f28768a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<U> f28769b;

        /* renamed from: c  reason: collision with root package name */
        final c<? super T, ? super U, ? extends V> f28770c;

        /* renamed from: d  reason: collision with root package name */
        b f28771d;

        /* renamed from: e  reason: collision with root package name */
        boolean f28772e;

        a(r<? super V> rVar, Iterator<U> it, c<? super T, ? super U, ? extends V> cVar) {
            this.f28768a = rVar;
            this.f28769b = it;
            this.f28770c = cVar;
        }

        void a(Throwable th2) {
            this.f28772e = true;
            this.f28771d.dispose();
            this.f28768a.onError(th2);
        }

        @Override // xn.b
        public void dispose() {
            this.f28771d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28771d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28772e) {
                this.f28772e = true;
                this.f28768a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28772e) {
                fo.a.s(th2);
                return;
            }
            this.f28772e = true;
            this.f28768a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28772e) {
                try {
                    try {
                        this.f28768a.onNext(bo.b.e(this.f28770c.apply(t10, bo.b.e(this.f28769b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                        try {
                            if (!this.f28769b.hasNext()) {
                                this.f28772e = true;
                                this.f28771d.dispose();
                                this.f28768a.onComplete();
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            a(th2);
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        a(th3);
                    }
                } catch (Throwable th4) {
                    io.reactivex.exceptions.a.b(th4);
                    a(th4);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28771d, bVar)) {
                this.f28771d = bVar;
                this.f28768a.onSubscribe(this);
            }
        }
    }

    public j4(k<? extends T> kVar, Iterable<U> iterable, c<? super T, ? super U, ? extends V> cVar) {
        this.f28765a = kVar;
        this.f28766b = iterable;
        this.f28767c = cVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super V> rVar) {
        try {
            Iterator it = (Iterator) bo.b.e(this.f28766b.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(rVar);
                } else {
                    this.f28765a.subscribe(new a(rVar, it, this.f28767c));
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, rVar);
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptyDisposable.error(th3, rVar);
        }
    }
}
