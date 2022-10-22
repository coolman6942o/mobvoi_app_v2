package io.reactivex.internal.operators.observable;

import io.reactivex.d;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.Callable;
import xn.b;
import zn.c;
import zn.g;
/* compiled from: ObservableGenerate.java */
/* loaded from: classes3.dex */
public final class h1<T, S> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<S> f28692a;

    /* renamed from: b  reason: collision with root package name */
    final c<S, d<T>, S> f28693b;

    /* renamed from: c  reason: collision with root package name */
    final g<? super S> f28694c;

    /* compiled from: ObservableGenerate.java */
    /* loaded from: classes3.dex */
    static final class a<T, S> implements d<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28695a;

        /* renamed from: b  reason: collision with root package name */
        final c<S, ? super d<T>, S> f28696b;

        /* renamed from: c  reason: collision with root package name */
        final g<? super S> f28697c;

        /* renamed from: d  reason: collision with root package name */
        S f28698d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f28699e;

        /* renamed from: f  reason: collision with root package name */
        boolean f28700f;

        a(r<? super T> rVar, c<S, ? super d<T>, S> cVar, g<? super S> gVar, S s10) {
            this.f28695a = rVar;
            this.f28696b = cVar;
            this.f28697c = gVar;
            this.f28698d = s10;
        }

        private void a(S s10) {
            try {
                this.f28697c.accept(s10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                fo.a.s(th2);
            }
        }

        public void b(Throwable th2) {
            if (this.f28700f) {
                fo.a.s(th2);
                return;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f28700f = true;
            this.f28695a.onError(th2);
        }

        public void c() {
            S s10 = this.f28698d;
            if (this.f28699e) {
                this.f28698d = null;
                a(s10);
                return;
            }
            c<S, ? super d<T>, S> cVar = this.f28696b;
            while (!this.f28699e) {
                try {
                    s10 = cVar.apply(s10, this);
                    if (this.f28700f) {
                        this.f28699e = true;
                        this.f28698d = null;
                        a(s10);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28698d = null;
                    this.f28699e = true;
                    b(th2);
                    a(s10);
                    return;
                }
            }
            this.f28698d = null;
            a(s10);
        }

        @Override // xn.b
        public void dispose() {
            this.f28699e = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28699e;
        }
    }

    public h1(Callable<S> callable, c<S, d<T>, S> cVar, g<? super S> gVar) {
        this.f28692a = callable;
        this.f28693b = cVar;
        this.f28694c = gVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        try {
            a aVar = new a(rVar, this.f28693b, this.f28694c, this.f28692a.call());
            rVar.onSubscribe(aVar);
            aVar.c();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, rVar);
        }
    }
}
