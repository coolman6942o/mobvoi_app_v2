package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.b;
import io.reactivex.k;
import io.reactivex.r;
import java.util.Iterator;
/* compiled from: ObservableFromIterable.java */
/* loaded from: classes3.dex */
public final class e1<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends T> f28553a;

    /* compiled from: ObservableFromIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28554a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<? extends T> f28555b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f28556c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28557d;

        /* renamed from: e  reason: collision with root package name */
        boolean f28558e;

        /* renamed from: f  reason: collision with root package name */
        boolean f28559f;

        a(r<? super T> rVar, Iterator<? extends T> it) {
            this.f28554a = rVar;
            this.f28555b = it;
        }

        void a() {
            while (!isDisposed()) {
                try {
                    this.f28554a.onNext(bo.b.e(this.f28555b.next(), "The iterator returned a null value"));
                    if (!isDisposed()) {
                        try {
                            if (!this.f28555b.hasNext()) {
                                if (!isDisposed()) {
                                    this.f28554a.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.f28554a.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    this.f28554a.onError(th3);
                    return;
                }
            }
        }

        @Override // co.g
        public void clear() {
            this.f28558e = true;
        }

        @Override // xn.b
        public void dispose() {
            this.f28556c = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28556c;
        }

        @Override // co.g
        public boolean isEmpty() {
            return this.f28558e;
        }

        @Override // co.g
        public T poll() {
            if (this.f28558e) {
                return null;
            }
            if (!this.f28559f) {
                this.f28559f = true;
            } else if (!this.f28555b.hasNext()) {
                this.f28558e = true;
                return null;
            }
            return (T) bo.b.e(this.f28555b.next(), "The iterator returned a null value");
        }

        @Override // co.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f28557d = true;
            return 1;
        }
    }

    public e1(Iterable<? extends T> iterable) {
        this.f28553a = iterable;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        try {
            Iterator<? extends T> it = this.f28553a.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(rVar);
                    return;
                }
                a aVar = new a(rVar, it);
                rVar.onSubscribe(aVar);
                if (!aVar.f28557d) {
                    aVar.a();
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
