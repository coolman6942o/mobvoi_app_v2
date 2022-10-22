package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableDebounceTimed.java */
/* loaded from: classes3.dex */
public final class d0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f28505b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f28506c;

    /* renamed from: d  reason: collision with root package name */
    final s f28507d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableDebounceTimed.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicReference<xn.b> implements Runnable, xn.b {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        a(T t10, long j10, b<T> bVar) {
            this.value = t10;
            this.idx = j10;
            this.parent = bVar;
        }

        public void a(xn.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableDebounceTimed.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements r<T>, xn.b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28508a;

        /* renamed from: b  reason: collision with root package name */
        final long f28509b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f28510c;

        /* renamed from: d  reason: collision with root package name */
        final s.c f28511d;

        /* renamed from: e  reason: collision with root package name */
        xn.b f28512e;

        /* renamed from: f  reason: collision with root package name */
        xn.b f28513f;

        /* renamed from: g  reason: collision with root package name */
        volatile long f28514g;

        /* renamed from: h  reason: collision with root package name */
        boolean f28515h;

        b(r<? super T> rVar, long j10, TimeUnit timeUnit, s.c cVar) {
            this.f28508a = rVar;
            this.f28509b = j10;
            this.f28510c = timeUnit;
            this.f28511d = cVar;
        }

        void a(long j10, T t10, a<T> aVar) {
            if (j10 == this.f28514g) {
                this.f28508a.onNext(t10);
                aVar.dispose();
            }
        }

        @Override // xn.b
        public void dispose() {
            this.f28512e.dispose();
            this.f28511d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28511d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28515h) {
                this.f28515h = true;
                xn.b bVar = this.f28513f;
                if (bVar != null) {
                    bVar.dispose();
                }
                a aVar = (a) bVar;
                if (aVar != null) {
                    aVar.run();
                }
                this.f28508a.onComplete();
                this.f28511d.dispose();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28515h) {
                fo.a.s(th2);
                return;
            }
            xn.b bVar = this.f28513f;
            if (bVar != null) {
                bVar.dispose();
            }
            this.f28515h = true;
            this.f28508a.onError(th2);
            this.f28511d.dispose();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28515h) {
                long j10 = this.f28514g + 1;
                this.f28514g = j10;
                xn.b bVar = this.f28513f;
                if (bVar != null) {
                    bVar.dispose();
                }
                a aVar = new a(t10, j10, this);
                this.f28513f = aVar;
                aVar.a(this.f28511d.c(aVar, this.f28509b, this.f28510c));
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28512e, bVar)) {
                this.f28512e = bVar;
                this.f28508a.onSubscribe(this);
            }
        }
    }

    public d0(p<T> pVar, long j10, TimeUnit timeUnit, s sVar) {
        super(pVar);
        this.f28505b = j10;
        this.f28506c = timeUnit;
        this.f28507d = sVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new b(new d(rVar), this.f28505b, this.f28506c, this.f28507d.a()));
    }
}
