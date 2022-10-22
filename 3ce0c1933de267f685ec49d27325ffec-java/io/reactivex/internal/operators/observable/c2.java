package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
import zn.o;
/* compiled from: ObservableOnErrorNext.java */
/* loaded from: classes3.dex */
public final class c2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super Throwable, ? extends p<? extends T>> f28484b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f28485c;

    /* compiled from: ObservableOnErrorNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T> {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28486a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super Throwable, ? extends p<? extends T>> f28487b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f28488c;

        /* renamed from: d  reason: collision with root package name */
        final SequentialDisposable f28489d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        boolean f28490e;

        /* renamed from: f  reason: collision with root package name */
        boolean f28491f;

        a(r<? super T> rVar, o<? super Throwable, ? extends p<? extends T>> oVar, boolean z10) {
            this.f28486a = rVar;
            this.f28487b = oVar;
            this.f28488c = z10;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28491f) {
                this.f28491f = true;
                this.f28490e = true;
                this.f28486a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (!this.f28490e) {
                this.f28490e = true;
                if (!this.f28488c || (th2 instanceof Exception)) {
                    try {
                        p<? extends T> apply = this.f28487b.apply(th2);
                        if (apply == null) {
                            NullPointerException nullPointerException = new NullPointerException("Observable is null");
                            nullPointerException.initCause(th2);
                            this.f28486a.onError(nullPointerException);
                            return;
                        }
                        apply.subscribe(this);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        this.f28486a.onError(new CompositeException(th2, th3));
                    }
                } else {
                    this.f28486a.onError(th2);
                }
            } else if (this.f28491f) {
                fo.a.s(th2);
            } else {
                this.f28486a.onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28491f) {
                this.f28486a.onNext(t10);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            this.f28489d.replace(bVar);
        }
    }

    public c2(p<T> pVar, o<? super Throwable, ? extends p<? extends T>> oVar, boolean z10) {
        super(pVar);
        this.f28484b = oVar;
        this.f28485c = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        a aVar = new a(rVar, this.f28484b, this.f28485c);
        rVar.onSubscribe(aVar.f28489d);
        this.f28426a.subscribe(aVar);
    }
}
