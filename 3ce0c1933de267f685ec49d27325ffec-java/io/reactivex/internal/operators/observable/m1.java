package io.reactivex.internal.operators.observable;

import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* compiled from: ObservableInternalHelper.java */
/* loaded from: classes3.dex */
public final class m1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Callable<p001do.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.k<T> f28815a;

        /* renamed from: b  reason: collision with root package name */
        private final int f28816b;

        a(io.reactivex.k<T> kVar, int i10) {
            this.f28815a = kVar;
            this.f28816b = i10;
        }

        /* renamed from: a */
        public p001do.a<T> call() {
            return this.f28815a.replay(this.f28816b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements Callable<p001do.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.k<T> f28817a;

        /* renamed from: b  reason: collision with root package name */
        private final int f28818b;

        /* renamed from: c  reason: collision with root package name */
        private final long f28819c;

        /* renamed from: d  reason: collision with root package name */
        private final TimeUnit f28820d;

        /* renamed from: e  reason: collision with root package name */
        private final s f28821e;

        b(io.reactivex.k<T> kVar, int i10, long j10, TimeUnit timeUnit, s sVar) {
            this.f28817a = kVar;
            this.f28818b = i10;
            this.f28819c = j10;
            this.f28820d = timeUnit;
            this.f28821e = sVar;
        }

        /* renamed from: a */
        public p001do.a<T> call() {
            return this.f28817a.replay(this.f28818b, this.f28819c, this.f28820d, this.f28821e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class c<T, U> implements zn.o<T, p<U>> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.o<? super T, ? extends Iterable<? extends U>> f28822a;

        c(zn.o<? super T, ? extends Iterable<? extends U>> oVar) {
            this.f28822a = oVar;
        }

        /* renamed from: a */
        public p<U> apply(T t10) throws Exception {
            return new e1((Iterable) bo.b.e(this.f28822a.apply(t10), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class d<U, R, T> implements zn.o<U, R> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.c<? super T, ? super U, ? extends R> f28823a;

        /* renamed from: b  reason: collision with root package name */
        private final T f28824b;

        d(zn.c<? super T, ? super U, ? extends R> cVar, T t10) {
            this.f28823a = cVar;
            this.f28824b = t10;
        }

        @Override // zn.o
        public R apply(U u10) throws Exception {
            return this.f28823a.apply((T) this.f28824b, u10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class e<T, R, U> implements zn.o<T, p<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.c<? super T, ? super U, ? extends R> f28825a;

        /* renamed from: b  reason: collision with root package name */
        private final zn.o<? super T, ? extends p<? extends U>> f28826b;

        e(zn.c<? super T, ? super U, ? extends R> cVar, zn.o<? super T, ? extends p<? extends U>> oVar) {
            this.f28825a = cVar;
            this.f28826b = oVar;
        }

        /* renamed from: a */
        public p<R> apply(T t10) throws Exception {
            return new u1((p) bo.b.e(this.f28826b.apply(t10), "The mapper returned a null ObservableSource"), new d(this.f28825a, t10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class f<T, U> implements zn.o<T, p<T>> {

        /* renamed from: a  reason: collision with root package name */
        final zn.o<? super T, ? extends p<U>> f28827a;

        f(zn.o<? super T, ? extends p<U>> oVar) {
            this.f28827a = oVar;
        }

        /* renamed from: a */
        public p<T> apply(T t10) throws Exception {
            return new k3((p) bo.b.e(this.f28827a.apply(t10), "The itemDelay returned a null ObservableSource"), 1L).map(bo.a.l(t10)).defaultIfEmpty(t10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class g<T> implements zn.a {

        /* renamed from: a  reason: collision with root package name */
        final r<T> f28828a;

        g(r<T> rVar) {
            this.f28828a = rVar;
        }

        @Override // zn.a
        public void run() throws Exception {
            this.f28828a.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class h<T> implements zn.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final r<T> f28829a;

        h(r<T> rVar) {
            this.f28829a = rVar;
        }

        /* renamed from: a */
        public void accept(Throwable th2) throws Exception {
            this.f28829a.onError(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class i<T> implements zn.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final r<T> f28830a;

        i(r<T> rVar) {
            this.f28830a = rVar;
        }

        @Override // zn.g
        public void accept(T t10) throws Exception {
            this.f28830a.onNext(t10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class j<T> implements Callable<p001do.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.k<T> f28831a;

        j(io.reactivex.k<T> kVar) {
            this.f28831a = kVar;
        }

        /* renamed from: a */
        public p001do.a<T> call() {
            return this.f28831a.replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class k<T, R> implements zn.o<io.reactivex.k<T>, p<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.o<? super io.reactivex.k<T>, ? extends p<R>> f28832a;

        /* renamed from: b  reason: collision with root package name */
        private final s f28833b;

        k(zn.o<? super io.reactivex.k<T>, ? extends p<R>> oVar, s sVar) {
            this.f28832a = oVar;
            this.f28833b = sVar;
        }

        /* renamed from: a */
        public p<R> apply(io.reactivex.k<T> kVar) throws Exception {
            return io.reactivex.k.wrap((p) bo.b.e(this.f28832a.apply(kVar), "The selector returned a null ObservableSource")).observeOn(this.f28833b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class l<T, S> implements zn.c<S, io.reactivex.d<T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final zn.b<S, io.reactivex.d<T>> f28834a;

        l(zn.b<S, io.reactivex.d<T>> bVar) {
            this.f28834a = bVar;
        }

        /* renamed from: a */
        public S apply(S s10, io.reactivex.d<T> dVar) throws Exception {
            this.f28834a.accept(s10, dVar);
            return s10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class m<T, S> implements zn.c<S, io.reactivex.d<T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final zn.g<io.reactivex.d<T>> f28835a;

        m(zn.g<io.reactivex.d<T>> gVar) {
            this.f28835a = gVar;
        }

        /* renamed from: a */
        public S apply(S s10, io.reactivex.d<T> dVar) throws Exception {
            this.f28835a.accept(dVar);
            return s10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class n<T> implements Callable<p001do.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.k<T> f28836a;

        /* renamed from: b  reason: collision with root package name */
        private final long f28837b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f28838c;

        /* renamed from: d  reason: collision with root package name */
        private final s f28839d;

        n(io.reactivex.k<T> kVar, long j10, TimeUnit timeUnit, s sVar) {
            this.f28836a = kVar;
            this.f28837b = j10;
            this.f28838c = timeUnit;
            this.f28839d = sVar;
        }

        /* renamed from: a */
        public p001do.a<T> call() {
            return this.f28836a.replay(this.f28837b, this.f28838c, this.f28839d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableInternalHelper.java */
    /* loaded from: classes3.dex */
    public static final class o<T, R> implements zn.o<List<p<? extends T>>, p<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.o<? super Object[], ? extends R> f28840a;

        o(zn.o<? super Object[], ? extends R> oVar) {
            this.f28840a = oVar;
        }

        /* renamed from: a */
        public p<? extends R> apply(List<p<? extends T>> list) {
            return io.reactivex.k.zipIterable(list, this.f28840a, false, io.reactivex.k.bufferSize());
        }
    }

    public static <T, U> zn.o<T, p<U>> a(zn.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new c(oVar);
    }

    public static <T, U, R> zn.o<T, p<R>> b(zn.o<? super T, ? extends p<? extends U>> oVar, zn.c<? super T, ? super U, ? extends R> cVar) {
        return new e(cVar, oVar);
    }

    public static <T, U> zn.o<T, p<T>> c(zn.o<? super T, ? extends p<U>> oVar) {
        return new f(oVar);
    }

    public static <T> zn.a d(r<T> rVar) {
        return new g(rVar);
    }

    public static <T> zn.g<Throwable> e(r<T> rVar) {
        return new h(rVar);
    }

    public static <T> zn.g<T> f(r<T> rVar) {
        return new i(rVar);
    }

    public static <T> Callable<p001do.a<T>> g(io.reactivex.k<T> kVar) {
        return new j(kVar);
    }

    public static <T> Callable<p001do.a<T>> h(io.reactivex.k<T> kVar, int i10) {
        return new a(kVar, i10);
    }

    public static <T> Callable<p001do.a<T>> i(io.reactivex.k<T> kVar, int i10, long j10, TimeUnit timeUnit, s sVar) {
        return new b(kVar, i10, j10, timeUnit, sVar);
    }

    public static <T> Callable<p001do.a<T>> j(io.reactivex.k<T> kVar, long j10, TimeUnit timeUnit, s sVar) {
        return new n(kVar, j10, timeUnit, sVar);
    }

    public static <T, R> zn.o<io.reactivex.k<T>, p<R>> k(zn.o<? super io.reactivex.k<T>, ? extends p<R>> oVar, s sVar) {
        return new k(oVar, sVar);
    }

    public static <T, S> zn.c<S, io.reactivex.d<T>, S> l(zn.b<S, io.reactivex.d<T>> bVar) {
        return new l(bVar);
    }

    public static <T, S> zn.c<S, io.reactivex.d<T>, S> m(zn.g<io.reactivex.d<T>> gVar) {
        return new m(gVar);
    }

    public static <T, R> zn.o<List<p<? extends T>>, p<? extends R>> n(zn.o<? super Object[], ? extends R> oVar) {
        return new o(oVar);
    }
}
