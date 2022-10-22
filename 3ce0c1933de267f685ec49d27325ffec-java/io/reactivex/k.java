package io.reactivex;

import bo.b;
import com.mobvoi.wear.contacts.ContactConstant;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.observers.d;
import io.reactivex.internal.observers.e;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.a0;
import io.reactivex.internal.operators.observable.a1;
import io.reactivex.internal.operators.observable.a2;
import io.reactivex.internal.operators.observable.a3;
import io.reactivex.internal.operators.observable.a4;
import io.reactivex.internal.operators.observable.b0;
import io.reactivex.internal.operators.observable.b1;
import io.reactivex.internal.operators.observable.b2;
import io.reactivex.internal.operators.observable.b3;
import io.reactivex.internal.operators.observable.b4;
import io.reactivex.internal.operators.observable.c;
import io.reactivex.internal.operators.observable.c0;
import io.reactivex.internal.operators.observable.c1;
import io.reactivex.internal.operators.observable.c2;
import io.reactivex.internal.operators.observable.c3;
import io.reactivex.internal.operators.observable.c4;
import io.reactivex.internal.operators.observable.d0;
import io.reactivex.internal.operators.observable.d1;
import io.reactivex.internal.operators.observable.d2;
import io.reactivex.internal.operators.observable.d3;
import io.reactivex.internal.operators.observable.d4;
import io.reactivex.internal.operators.observable.e0;
import io.reactivex.internal.operators.observable.e1;
import io.reactivex.internal.operators.observable.e2;
import io.reactivex.internal.operators.observable.e3;
import io.reactivex.internal.operators.observable.e4;
import io.reactivex.internal.operators.observable.f0;
import io.reactivex.internal.operators.observable.f1;
import io.reactivex.internal.operators.observable.f2;
import io.reactivex.internal.operators.observable.f3;
import io.reactivex.internal.operators.observable.f4;
import io.reactivex.internal.operators.observable.g0;
import io.reactivex.internal.operators.observable.g1;
import io.reactivex.internal.operators.observable.g2;
import io.reactivex.internal.operators.observable.g3;
import io.reactivex.internal.operators.observable.g4;
import io.reactivex.internal.operators.observable.h;
import io.reactivex.internal.operators.observable.h0;
import io.reactivex.internal.operators.observable.h1;
import io.reactivex.internal.operators.observable.h2;
import io.reactivex.internal.operators.observable.h3;
import io.reactivex.internal.operators.observable.h4;
import io.reactivex.internal.operators.observable.i0;
import io.reactivex.internal.operators.observable.i1;
import io.reactivex.internal.operators.observable.i2;
import io.reactivex.internal.operators.observable.i3;
import io.reactivex.internal.operators.observable.i4;
import io.reactivex.internal.operators.observable.j;
import io.reactivex.internal.operators.observable.j0;
import io.reactivex.internal.operators.observable.j1;
import io.reactivex.internal.operators.observable.j2;
import io.reactivex.internal.operators.observable.j3;
import io.reactivex.internal.operators.observable.j4;
import io.reactivex.internal.operators.observable.k0;
import io.reactivex.internal.operators.observable.k1;
import io.reactivex.internal.operators.observable.k2;
import io.reactivex.internal.operators.observable.k3;
import io.reactivex.internal.operators.observable.l;
import io.reactivex.internal.operators.observable.l0;
import io.reactivex.internal.operators.observable.l1;
import io.reactivex.internal.operators.observable.l3;
import io.reactivex.internal.operators.observable.m;
import io.reactivex.internal.operators.observable.m0;
import io.reactivex.internal.operators.observable.m1;
import io.reactivex.internal.operators.observable.m2;
import io.reactivex.internal.operators.observable.m3;
import io.reactivex.internal.operators.observable.n;
import io.reactivex.internal.operators.observable.n0;
import io.reactivex.internal.operators.observable.n1;
import io.reactivex.internal.operators.observable.n2;
import io.reactivex.internal.operators.observable.n3;
import io.reactivex.internal.operators.observable.o0;
import io.reactivex.internal.operators.observable.o1;
import io.reactivex.internal.operators.observable.o2;
import io.reactivex.internal.operators.observable.o3;
import io.reactivex.internal.operators.observable.p1;
import io.reactivex.internal.operators.observable.p2;
import io.reactivex.internal.operators.observable.p3;
import io.reactivex.internal.operators.observable.q;
import io.reactivex.internal.operators.observable.q0;
import io.reactivex.internal.operators.observable.q1;
import io.reactivex.internal.operators.observable.q2;
import io.reactivex.internal.operators.observable.q3;
import io.reactivex.internal.operators.observable.r0;
import io.reactivex.internal.operators.observable.r1;
import io.reactivex.internal.operators.observable.r2;
import io.reactivex.internal.operators.observable.r3;
import io.reactivex.internal.operators.observable.s;
import io.reactivex.internal.operators.observable.s0;
import io.reactivex.internal.operators.observable.s1;
import io.reactivex.internal.operators.observable.s2;
import io.reactivex.internal.operators.observable.s3;
import io.reactivex.internal.operators.observable.t;
import io.reactivex.internal.operators.observable.t0;
import io.reactivex.internal.operators.observable.t1;
import io.reactivex.internal.operators.observable.t2;
import io.reactivex.internal.operators.observable.t3;
import io.reactivex.internal.operators.observable.u;
import io.reactivex.internal.operators.observable.u0;
import io.reactivex.internal.operators.observable.u1;
import io.reactivex.internal.operators.observable.u2;
import io.reactivex.internal.operators.observable.u3;
import io.reactivex.internal.operators.observable.v;
import io.reactivex.internal.operators.observable.v0;
import io.reactivex.internal.operators.observable.v1;
import io.reactivex.internal.operators.observable.v2;
import io.reactivex.internal.operators.observable.v3;
import io.reactivex.internal.operators.observable.w;
import io.reactivex.internal.operators.observable.w1;
import io.reactivex.internal.operators.observable.w2;
import io.reactivex.internal.operators.observable.w3;
import io.reactivex.internal.operators.observable.x;
import io.reactivex.internal.operators.observable.x0;
import io.reactivex.internal.operators.observable.x1;
import io.reactivex.internal.operators.observable.x3;
import io.reactivex.internal.operators.observable.y;
import io.reactivex.internal.operators.observable.y0;
import io.reactivex.internal.operators.observable.y1;
import io.reactivex.internal.operators.observable.y2;
import io.reactivex.internal.operators.observable.y3;
import io.reactivex.internal.operators.observable.z0;
import io.reactivex.internal.operators.observable.z1;
import io.reactivex.internal.operators.observable.z2;
import io.reactivex.internal.operators.observable.z3;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.internal.util.f;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import zn.g;
import zn.i;
import zn.o;
import zn.p;
/* compiled from: Observable.java */
/* loaded from: classes2.dex */
public abstract class k<T> implements p<T> {

    /* compiled from: Observable.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f29264a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f29264a = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29264a[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29264a[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29264a[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static <T> k<T> amb(Iterable<? extends p<? extends T>> iterable) {
        b.e(iterable, "sources is null");
        return fo.a.o(new h(null, iterable));
    }

    public static <T> k<T> ambArray(p<? extends T>... pVarArr) {
        b.e(pVarArr, "sources is null");
        int length = pVarArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(pVarArr[0]);
        }
        return fo.a.o(new h(pVarArr, null));
    }

    public static int bufferSize() {
        return e.b();
    }

    public static <T, R> k<R> combineLatest(o<? super Object[], ? extends R> oVar, int i10, p<? extends T>... pVarArr) {
        return combineLatest(pVarArr, oVar, i10);
    }

    public static <T, R> k<R> combineLatestDelayError(p<? extends T>[] pVarArr, o<? super Object[], ? extends R> oVar) {
        return combineLatestDelayError(pVarArr, oVar, bufferSize());
    }

    public static <T> k<T> concat(Iterable<? extends p<? extends T>> iterable) {
        b.e(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(bo.a.i(), bufferSize(), false);
    }

    public static <T> k<T> concatArray(p<? extends T>... pVarArr) {
        if (pVarArr.length == 0) {
            return empty();
        }
        if (pVarArr.length == 1) {
            return wrap(pVarArr[0]);
        }
        return fo.a.o(new u(fromArray(pVarArr), bo.a.i(), bufferSize(), ErrorMode.BOUNDARY));
    }

    public static <T> k<T> concatArrayDelayError(p<? extends T>... pVarArr) {
        if (pVarArr.length == 0) {
            return empty();
        }
        if (pVarArr.length == 1) {
            return wrap(pVarArr[0]);
        }
        return concatDelayError(fromArray(pVarArr));
    }

    public static <T> k<T> concatArrayEager(p<? extends T>... pVarArr) {
        return concatArrayEager(bufferSize(), bufferSize(), pVarArr);
    }

    public static <T> k<T> concatArrayEagerDelayError(p<? extends T>... pVarArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), pVarArr);
    }

    public static <T> k<T> concatDelayError(Iterable<? extends p<? extends T>> iterable) {
        b.e(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> k<T> concatEager(p<? extends p<? extends T>> pVar) {
        return concatEager(pVar, bufferSize(), bufferSize());
    }

    public static <T> k<T> create(n<T> nVar) {
        b.e(nVar, "source is null");
        return fo.a.o(new b0(nVar));
    }

    public static <T> k<T> defer(Callable<? extends p<? extends T>> callable) {
        b.e(callable, "supplier is null");
        return fo.a.o(new e0(callable));
    }

    private k<T> doOnEach(g<? super T> gVar, g<? super Throwable> gVar2, zn.a aVar, zn.a aVar2) {
        b.e(gVar, "onNext is null");
        b.e(gVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(aVar2, "onAfterTerminate is null");
        return fo.a.o(new n0(this, gVar, gVar2, aVar, aVar2));
    }

    public static <T> k<T> empty() {
        return fo.a.o(s0.f29027a);
    }

    public static <T> k<T> error(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        return fo.a.o(new t0(callable));
    }

    public static <T> k<T> fromArray(T... tArr) {
        b.e(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return fo.a.o(new b1(tArr));
    }

    public static <T> k<T> fromCallable(Callable<? extends T> callable) {
        b.e(callable, "supplier is null");
        return fo.a.o(new c1(callable));
    }

    public static <T> k<T> fromFuture(Future<? extends T> future) {
        b.e(future, "future is null");
        return fo.a.o(new d1(future, 0L, null));
    }

    public static <T> k<T> fromIterable(Iterable<? extends T> iterable) {
        b.e(iterable, "source is null");
        return fo.a.o(new e1(iterable));
    }

    public static <T> k<T> fromPublisher(vp.a<? extends T> aVar) {
        b.e(aVar, "publisher is null");
        return fo.a.o(new f1(aVar));
    }

    public static <T> k<T> generate(g<d<T>> gVar) {
        b.e(gVar, "generator is null");
        return generate(bo.a.s(), m1.m(gVar), bo.a.g());
    }

    public static k<Long> interval(long j10, long j11, TimeUnit timeUnit) {
        return interval(j10, j11, timeUnit, go.a.a());
    }

    public static k<Long> intervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit) {
        return intervalRange(j10, j11, j12, j13, timeUnit, go.a.a());
    }

    public static <T> k<T> just(T t10) {
        b.e(t10, "item is null");
        return fo.a.o(new q1(t10));
    }

    public static <T> k<T> merge(Iterable<? extends p<? extends T>> iterable, int i10, int i11) {
        return fromIterable(iterable).flatMap(bo.a.i(), false, i10, i11);
    }

    public static <T> k<T> mergeArray(int i10, int i11, p<? extends T>... pVarArr) {
        return fromArray(pVarArr).flatMap(bo.a.i(), false, i10, i11);
    }

    public static <T> k<T> mergeArrayDelayError(int i10, int i11, p<? extends T>... pVarArr) {
        return fromArray(pVarArr).flatMap(bo.a.i(), true, i10, i11);
    }

    public static <T> k<T> mergeDelayError(Iterable<? extends p<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(bo.a.i(), true);
    }

    public static <T> k<T> never() {
        return fo.a.o(a2.f28435a);
    }

    public static k<Integer> range(int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i11);
        } else if (i11 == 0) {
            return empty();
        } else {
            if (i11 == 1) {
                return just(Integer.valueOf(i10));
            }
            if (i10 + (i11 - 1) <= 2147483647L) {
                return fo.a.o(new g2(i10, i11));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    public static k<Long> rangeLong(long j10, long j11) {
        int i10 = (j11 > 0L ? 1 : (j11 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j11);
        } else if (i10 == 0) {
            return empty();
        } else {
            if (j11 == 1) {
                return just(Long.valueOf(j10));
            }
            long j12 = (j11 - 1) + j10;
            if (j10 <= 0 || j12 >= 0) {
                return fo.a.o(new h2(j10, j11));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> t<Boolean> sequenceEqual(p<? extends T> pVar, p<? extends T> pVar2) {
        return sequenceEqual(pVar, pVar2, b.d(), bufferSize());
    }

    public static <T> k<T> switchOnNext(p<? extends p<? extends T>> pVar, int i10) {
        b.e(pVar, "sources is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new j3(pVar, bo.a.i(), i10, false));
    }

    public static <T> k<T> switchOnNextDelayError(p<? extends p<? extends T>> pVar) {
        return switchOnNextDelayError(pVar, bufferSize());
    }

    private k<T> timeout0(long j10, TimeUnit timeUnit, p<? extends T> pVar, s sVar) {
        b.e(timeUnit, "timeUnit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new v3(this, j10, timeUnit, sVar, pVar));
    }

    public static k<Long> timer(long j10, TimeUnit timeUnit) {
        return timer(j10, timeUnit, go.a.a());
    }

    public static <T> k<T> unsafeCreate(p<T> pVar) {
        b.e(pVar, "onSubscribe is null");
        if (!(pVar instanceof k)) {
            return fo.a.o(new g1(pVar));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> k<T> using(Callable<? extends D> callable, o<? super D, ? extends p<? extends T>> oVar, g<? super D> gVar) {
        return using(callable, oVar, gVar, true);
    }

    public static <T> k<T> wrap(p<T> pVar) {
        b.e(pVar, "source is null");
        if (pVar instanceof k) {
            return fo.a.o((k) pVar);
        }
        return fo.a.o(new g1(pVar));
    }

    public static <T, R> k<R> zip(Iterable<? extends p<? extends T>> iterable, o<? super Object[], ? extends R> oVar) {
        b.e(oVar, "zipper is null");
        b.e(iterable, "sources is null");
        return fo.a.o(new i4(null, iterable, oVar, bufferSize(), false));
    }

    public static <T, R> k<R> zipArray(o<? super Object[], ? extends R> oVar, boolean z10, int i10, p<? extends T>... pVarArr) {
        if (pVarArr.length == 0) {
            return empty();
        }
        b.e(oVar, "zipper is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new i4(pVarArr, null, oVar, i10, z10));
    }

    public static <T, R> k<R> zipIterable(Iterable<? extends p<? extends T>> iterable, o<? super Object[], ? extends R> oVar, boolean z10, int i10) {
        b.e(oVar, "zipper is null");
        b.e(iterable, "sources is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new i4(null, iterable, oVar, i10, z10));
    }

    public final t<Boolean> all(p<? super T> pVar) {
        b.e(pVar, "predicate is null");
        return fo.a.p(new io.reactivex.internal.operators.observable.g(this, pVar));
    }

    public final k<T> ambWith(p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return ambArray(this, pVar);
    }

    public final t<Boolean> any(p<? super T> pVar) {
        b.e(pVar, "predicate is null");
        return fo.a.p(new j(this, pVar));
    }

    public final <R> R as(l<T, ? extends R> lVar) {
        return (R) ((l) b.e(lVar, "converter is null")).a(this);
    }

    public final T blockingFirst() {
        d dVar = new d();
        subscribe(dVar);
        T a10 = dVar.a();
        if (a10 != null) {
            return a10;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(g<? super T> gVar) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                gVar.accept(it.next());
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                ((xn.b) it).dispose();
                throw f.d(th2);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() {
        e eVar = new e();
        subscribe(eVar);
        T a10 = eVar.a();
        if (a10 != null) {
            return a10;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new c(this);
    }

    public final Iterable<T> blockingMostRecent(T t10) {
        return new io.reactivex.internal.operators.observable.d(this, t10);
    }

    public final Iterable<T> blockingNext() {
        return new io.reactivex.internal.operators.observable.e(this);
    }

    public final T blockingSingle() {
        T c10 = singleElement().c();
        if (c10 != null) {
            return c10;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        io.reactivex.internal.operators.observable.k.a(this);
    }

    public final k<List<T>> buffer(int i10) {
        return buffer(i10, i10);
    }

    public final k<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final k<T> cacheWithInitialCapacity(int i10) {
        b.f(i10, "initialCapacity");
        return fo.a.o(new q(this, i10));
    }

    public final <U> k<U> cast(Class<U> cls) {
        b.e(cls, "clazz is null");
        return (k<U>) map(bo.a.d(cls));
    }

    public final <U> t<U> collect(Callable<? extends U> callable, zn.b<? super U, ? super T> bVar) {
        b.e(callable, "initialValueSupplier is null");
        b.e(bVar, "collector is null");
        return fo.a.p(new s(this, callable, bVar));
    }

    public final <U> t<U> collectInto(U u10, zn.b<? super U, ? super T> bVar) {
        b.e(u10, "initialValue is null");
        return collect(bo.a.k(u10), bVar);
    }

    public final <R> k<R> compose(q<? super T, ? extends R> qVar) {
        return wrap(((q) b.e(qVar, "composer is null")).a(this));
    }

    public final <R> k<R> concatMap(o<? super T, ? extends p<? extends R>> oVar) {
        return concatMap(oVar, 2);
    }

    public final io.reactivex.a concatMapCompletable(o<? super T, ? extends c> oVar) {
        return concatMapCompletable(oVar, 2);
    }

    public final io.reactivex.a concatMapCompletableDelayError(o<? super T, ? extends c> oVar) {
        return concatMapCompletableDelayError(oVar, true, 2);
    }

    public final <R> k<R> concatMapDelayError(o<? super T, ? extends p<? extends R>> oVar) {
        return concatMapDelayError(oVar, bufferSize(), true);
    }

    public final <R> k<R> concatMapEager(o<? super T, ? extends p<? extends R>> oVar) {
        return concatMapEager(oVar, Integer.MAX_VALUE, bufferSize());
    }

    public final <R> k<R> concatMapEagerDelayError(o<? super T, ? extends p<? extends R>> oVar, boolean z10) {
        return concatMapEagerDelayError(oVar, Integer.MAX_VALUE, bufferSize(), z10);
    }

    public final <U> k<U> concatMapIterable(o<? super T, ? extends Iterable<? extends U>> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new a1(this, oVar));
    }

    public final <R> k<R> concatMapMaybe(o<? super T, ? extends i<? extends R>> oVar) {
        return concatMapMaybe(oVar, 2);
    }

    public final <R> k<R> concatMapMaybeDelayError(o<? super T, ? extends i<? extends R>> oVar) {
        return concatMapMaybeDelayError(oVar, true, 2);
    }

    public final <R> k<R> concatMapSingle(o<? super T, ? extends v<? extends R>> oVar) {
        return concatMapSingle(oVar, 2);
    }

    public final <R> k<R> concatMapSingleDelayError(o<? super T, ? extends v<? extends R>> oVar) {
        return concatMapSingleDelayError(oVar, true, 2);
    }

    public final k<T> concatWith(p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return concat(this, pVar);
    }

    public final t<Boolean> contains(Object obj) {
        b.e(obj, "element is null");
        return any(bo.a.h(obj));
    }

    public final t<Long> count() {
        return fo.a.p(new a0(this));
    }

    public final <U> k<T> debounce(o<? super T, ? extends p<U>> oVar) {
        b.e(oVar, "debounceSelector is null");
        return fo.a.o(new c0(this, oVar));
    }

    public final k<T> defaultIfEmpty(T t10) {
        b.e(t10, "defaultItem is null");
        return switchIfEmpty(just(t10));
    }

    public final <U> k<T> delay(o<? super T, ? extends p<U>> oVar) {
        b.e(oVar, "itemDelay is null");
        return (k<T>) flatMap(m1.c(oVar));
    }

    public final <U> k<T> delaySubscription(p<U> pVar) {
        b.e(pVar, "other is null");
        return fo.a.o(new g0(this, pVar));
    }

    @Deprecated
    public final <T2> k<T2> dematerialize() {
        return fo.a.o(new h0(this, bo.a.i()));
    }

    public final k<T> distinct() {
        return distinct(bo.a.i(), bo.a.f());
    }

    public final k<T> distinctUntilChanged() {
        return distinctUntilChanged(bo.a.i());
    }

    public final k<T> doAfterNext(g<? super T> gVar) {
        b.e(gVar, "onAfterNext is null");
        return fo.a.o(new l0(this, gVar));
    }

    public final k<T> doAfterTerminate(zn.a aVar) {
        b.e(aVar, "onFinally is null");
        return doOnEach(bo.a.g(), bo.a.g(), bo.a.f5359c, aVar);
    }

    public final k<T> doFinally(zn.a aVar) {
        b.e(aVar, "onFinally is null");
        return fo.a.o(new m0(this, aVar));
    }

    public final k<T> doOnComplete(zn.a aVar) {
        return doOnEach(bo.a.g(), bo.a.g(), aVar, bo.a.f5359c);
    }

    public final k<T> doOnDispose(zn.a aVar) {
        return doOnLifecycle(bo.a.g(), aVar);
    }

    public final k<T> doOnError(g<? super Throwable> gVar) {
        g<? super T> g10 = bo.a.g();
        zn.a aVar = bo.a.f5359c;
        return doOnEach(g10, gVar, aVar, aVar);
    }

    public final k<T> doOnLifecycle(g<? super xn.b> gVar, zn.a aVar) {
        b.e(gVar, "onSubscribe is null");
        b.e(aVar, "onDispose is null");
        return fo.a.o(new o0(this, gVar, aVar));
    }

    public final k<T> doOnNext(g<? super T> gVar) {
        g<? super Throwable> g10 = bo.a.g();
        zn.a aVar = bo.a.f5359c;
        return doOnEach(gVar, g10, aVar, aVar);
    }

    public final k<T> doOnSubscribe(g<? super xn.b> gVar) {
        return doOnLifecycle(gVar, bo.a.f5359c);
    }

    public final k<T> doOnTerminate(zn.a aVar) {
        b.e(aVar, "onTerminate is null");
        return doOnEach(bo.a.g(), bo.a.a(aVar), aVar, bo.a.f5359c);
    }

    public final g<T> elementAt(long j10) {
        if (j10 >= 0) {
            return fo.a.n(new q0(this, j10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final t<T> elementAtOrError(long j10) {
        if (j10 >= 0) {
            return fo.a.p(new r0(this, j10, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final k<T> filter(p<? super T> pVar) {
        b.e(pVar, "predicate is null");
        return fo.a.o(new u0(this, pVar));
    }

    public final t<T> first(T t10) {
        return elementAt(0L, t10);
    }

    public final g<T> firstElement() {
        return elementAt(0L);
    }

    public final t<T> firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> k<R> flatMap(o<? super T, ? extends p<? extends R>> oVar) {
        return flatMap((o) oVar, false);
    }

    public final io.reactivex.a flatMapCompletable(o<? super T, ? extends c> oVar) {
        return flatMapCompletable(oVar, false);
    }

    public final <U> k<U> flatMapIterable(o<? super T, ? extends Iterable<? extends U>> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new a1(this, oVar));
    }

    public final <R> k<R> flatMapMaybe(o<? super T, ? extends i<? extends R>> oVar) {
        return flatMapMaybe(oVar, false);
    }

    public final <R> k<R> flatMapSingle(o<? super T, ? extends v<? extends R>> oVar) {
        return flatMapSingle(oVar, false);
    }

    public final xn.b forEach(g<? super T> gVar) {
        return subscribe(gVar);
    }

    public final xn.b forEachWhile(p<? super T> pVar) {
        return forEachWhile(pVar, bo.a.f5361e, bo.a.f5359c);
    }

    public final <K> k<p001do.b<K, T>> groupBy(o<? super T, ? extends K> oVar) {
        return (k<p001do.b<K, T>>) groupBy(oVar, bo.a.i(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> k<R> groupJoin(p<? extends TRight> pVar, o<? super T, ? extends p<TLeftEnd>> oVar, o<? super TRight, ? extends p<TRightEnd>> oVar2, zn.c<? super T, ? super k<TRight>, ? extends R> cVar) {
        b.e(pVar, "other is null");
        b.e(oVar, "leftEnd is null");
        b.e(oVar2, "rightEnd is null");
        b.e(cVar, "resultSelector is null");
        return fo.a.o(new i1(this, pVar, oVar, oVar2, cVar));
    }

    public final k<T> hide() {
        return fo.a.o(new j1(this));
    }

    public final io.reactivex.a ignoreElements() {
        return fo.a.l(new l1(this));
    }

    public final t<Boolean> isEmpty() {
        return all(bo.a.b());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> k<R> join(p<? extends TRight> pVar, o<? super T, ? extends p<TLeftEnd>> oVar, o<? super TRight, ? extends p<TRightEnd>> oVar2, zn.c<? super T, ? super TRight, ? extends R> cVar) {
        b.e(pVar, "other is null");
        b.e(oVar, "leftEnd is null");
        b.e(oVar2, "rightEnd is null");
        b.e(cVar, "resultSelector is null");
        return fo.a.o(new p1(this, pVar, oVar, oVar2, cVar));
    }

    public final t<T> last(T t10) {
        b.e(t10, "defaultItem is null");
        return fo.a.p(new s1(this, t10));
    }

    public final g<T> lastElement() {
        return fo.a.n(new r1(this));
    }

    public final t<T> lastOrError() {
        return fo.a.p(new s1(this, null));
    }

    public final <R> k<R> lift(o<? extends R, ? super T> oVar) {
        b.e(oVar, "lifter is null");
        return fo.a.o(new t1(this, oVar));
    }

    public final <R> k<R> map(o<? super T, ? extends R> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new u1(this, oVar));
    }

    public final k<j<T>> materialize() {
        return fo.a.o(new w1(this));
    }

    public final k<T> mergeWith(p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return merge(this, pVar);
    }

    public final k<T> observeOn(s sVar) {
        return observeOn(sVar, false, bufferSize());
    }

    public final <U> k<U> ofType(Class<U> cls) {
        b.e(cls, "clazz is null");
        return filter(bo.a.j(cls)).cast(cls);
    }

    public final k<T> onErrorResumeNext(o<? super Throwable, ? extends p<? extends T>> oVar) {
        b.e(oVar, "resumeFunction is null");
        return fo.a.o(new c2(this, oVar, false));
    }

    public final k<T> onErrorReturn(o<? super Throwable, ? extends T> oVar) {
        b.e(oVar, "valueSupplier is null");
        return fo.a.o(new d2(this, oVar));
    }

    public final k<T> onErrorReturnItem(T t10) {
        b.e(t10, "item is null");
        return onErrorReturn(bo.a.l(t10));
    }

    public final k<T> onExceptionResumeNext(p<? extends T> pVar) {
        b.e(pVar, "next is null");
        return fo.a.o(new c2(this, bo.a.l(pVar), true));
    }

    public final k<T> onTerminateDetach() {
        return fo.a.o(new i0(this));
    }

    public final p001do.a<T> publish() {
        return e2.d(this);
    }

    public final g<T> reduce(zn.c<T, T, T> cVar) {
        b.e(cVar, "reducer is null");
        return fo.a.n(new i2(this, cVar));
    }

    public final <R> t<R> reduceWith(Callable<R> callable, zn.c<R, ? super T, R> cVar) {
        b.e(callable, "seedSupplier is null");
        b.e(cVar, "reducer is null");
        return fo.a.p(new k2(this, callable, cVar));
    }

    public final k<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final k<T> repeatUntil(zn.e eVar) {
        b.e(eVar, "stop is null");
        return fo.a.o(new n2(this, eVar));
    }

    public final k<T> repeatWhen(o<? super k<Object>, ? extends p<?>> oVar) {
        b.e(oVar, "handler is null");
        return fo.a.o(new o2(this, oVar));
    }

    public final p001do.a<T> replay() {
        return p2.h(this);
    }

    public final k<T> retry() {
        return retry(Long.MAX_VALUE, bo.a.c());
    }

    public final k<T> retryUntil(zn.e eVar) {
        b.e(eVar, "stop is null");
        return retry(Long.MAX_VALUE, bo.a.t(eVar));
    }

    public final k<T> retryWhen(o<? super k<Throwable>, ? extends p<?>> oVar) {
        b.e(oVar, "handler is null");
        return fo.a.o(new s2(this, oVar));
    }

    public final void safeSubscribe(r<? super T> rVar) {
        b.e(rVar, "observer is null");
        if (rVar instanceof eo.c) {
            subscribe(rVar);
        } else {
            subscribe(new eo.c(rVar));
        }
    }

    public final k<T> sample(long j10, TimeUnit timeUnit) {
        return sample(j10, timeUnit, go.a.a());
    }

    public final k<T> scan(zn.c<T, T, T> cVar) {
        b.e(cVar, "accumulator is null");
        return fo.a.o(new v2(this, cVar));
    }

    public final <R> k<R> scanWith(Callable<R> callable, zn.c<R, ? super T, R> cVar) {
        b.e(callable, "seedSupplier is null");
        b.e(cVar, "accumulator is null");
        return fo.a.o(new w2(this, callable, cVar));
    }

    public final k<T> serialize() {
        return fo.a.o(new z2(this));
    }

    public final k<T> share() {
        return publish().c();
    }

    public final t<T> single(T t10) {
        b.e(t10, "defaultItem is null");
        return fo.a.p(new b3(this, t10));
    }

    public final g<T> singleElement() {
        return fo.a.n(new a3(this));
    }

    public final t<T> singleOrError() {
        return fo.a.p(new b3(this, null));
    }

    public final k<T> skip(long j10) {
        if (j10 <= 0) {
            return fo.a.o(this);
        }
        return fo.a.o(new c3(this, j10));
    }

    public final k<T> skipLast(int i10) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i10);
        } else if (i10 == 0) {
            return fo.a.o(this);
        } else {
            return fo.a.o(new d3(this, i10));
        }
    }

    public final <U> k<T> skipUntil(p<U> pVar) {
        b.e(pVar, "other is null");
        return fo.a.o(new f3(this, pVar));
    }

    public final k<T> skipWhile(p<? super T> pVar) {
        b.e(pVar, "predicate is null");
        return fo.a.o(new g3(this, pVar));
    }

    public final k<T> sorted() {
        return toList().f().map(bo.a.m(bo.a.n())).flatMapIterable(bo.a.i());
    }

    public final k<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final k<T> startWithArray(T... tArr) {
        k fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return fo.a.o(this);
        }
        return concatArray(fromArray, this);
    }

    public final xn.b subscribe() {
        return subscribe(bo.a.g(), bo.a.f5361e, bo.a.f5359c, bo.a.g());
    }

    protected abstract void subscribeActual(r<? super T> rVar);

    public final k<T> subscribeOn(s sVar) {
        b.e(sVar, "scheduler is null");
        return fo.a.o(new h3(this, sVar));
    }

    public final <E extends r<? super T>> E subscribeWith(E e10) {
        subscribe(e10);
        return e10;
    }

    public final k<T> switchIfEmpty(p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return fo.a.o(new i3(this, pVar));
    }

    public final <R> k<R> switchMap(o<? super T, ? extends p<? extends R>> oVar) {
        return switchMap(oVar, bufferSize());
    }

    public final io.reactivex.a switchMapCompletable(o<? super T, ? extends c> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.l(new io.reactivex.internal.operators.mixed.d(this, oVar, false));
    }

    public final io.reactivex.a switchMapCompletableDelayError(o<? super T, ? extends c> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.l(new io.reactivex.internal.operators.mixed.d(this, oVar, true));
    }

    public final <R> k<R> switchMapDelayError(o<? super T, ? extends p<? extends R>> oVar) {
        return switchMapDelayError(oVar, bufferSize());
    }

    public final <R> k<R> switchMapMaybe(o<? super T, ? extends i<? extends R>> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new io.reactivex.internal.operators.mixed.e(this, oVar, false));
    }

    public final <R> k<R> switchMapMaybeDelayError(o<? super T, ? extends i<? extends R>> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new io.reactivex.internal.operators.mixed.e(this, oVar, true));
    }

    public final <R> k<R> switchMapSingle(o<? super T, ? extends v<? extends R>> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new io.reactivex.internal.operators.mixed.f(this, oVar, false));
    }

    public final <R> k<R> switchMapSingleDelayError(o<? super T, ? extends v<? extends R>> oVar) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new io.reactivex.internal.operators.mixed.f(this, oVar, true));
    }

    public final k<T> take(long j10) {
        if (j10 >= 0) {
            return fo.a.o(new k3(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j10);
    }

    public final k<T> takeLast(int i10) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i10);
        } else if (i10 == 0) {
            return fo.a.o(new k1(this));
        } else {
            if (i10 == 1) {
                return fo.a.o(new m3(this));
            }
            return fo.a.o(new l3(this, i10));
        }
    }

    public final <U> k<T> takeUntil(p<U> pVar) {
        b.e(pVar, "other is null");
        return fo.a.o(new o3(this, pVar));
    }

    public final k<T> takeWhile(p<? super T> pVar) {
        b.e(pVar, "predicate is null");
        return fo.a.o(new q3(this, pVar));
    }

    public final io.reactivex.observers.a<T> test() {
        io.reactivex.observers.a<T> aVar = new io.reactivex.observers.a<>();
        subscribe(aVar);
        return aVar;
    }

    public final k<T> throttleFirst(long j10, TimeUnit timeUnit) {
        return throttleFirst(j10, timeUnit, go.a.a());
    }

    public final k<T> throttleLast(long j10, TimeUnit timeUnit) {
        return sample(j10, timeUnit);
    }

    public final k<T> throttleLatest(long j10, TimeUnit timeUnit) {
        return throttleLatest(j10, timeUnit, go.a.a(), false);
    }

    public final k<T> throttleWithTimeout(long j10, TimeUnit timeUnit) {
        return debounce(j10, timeUnit);
    }

    public final k<go.b<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, go.a.a());
    }

    public final <V> k<T> timeout(o<? super T, ? extends p<V>> oVar) {
        return timeout0(null, oVar, null);
    }

    public final k<go.b<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, go.a.a());
    }

    public final <R> R to(o<? super k<T>, R> oVar) {
        try {
            return (R) ((o) b.e(oVar, "converter is null")).apply(this);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw f.d(th2);
        }
    }

    public final e<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.operators.flowable.b bVar = new io.reactivex.internal.operators.flowable.b(this);
        int i10 = a.f29264a[backpressureStrategy.ordinal()];
        if (i10 == 1) {
            return bVar.e();
        }
        if (i10 == 2) {
            return bVar.f();
        }
        if (i10 == 3) {
            return bVar;
        }
        if (i10 != 4) {
            return bVar.c();
        }
        return fo.a.m(new io.reactivex.internal.operators.flowable.g(bVar));
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new io.reactivex.internal.observers.h());
    }

    public final t<List<T>> toList() {
        return toList(16);
    }

    public final <K> t<Map<K, T>> toMap(o<? super T, ? extends K> oVar) {
        b.e(oVar, "keySelector is null");
        return (t<Map<K, T>>) collect(HashMapSupplier.asCallable(), bo.a.D(oVar));
    }

    public final <K> t<Map<K, Collection<T>>> toMultimap(o<? super T, ? extends K> oVar) {
        return (t<Map<K, Collection<T>>>) toMultimap(oVar, bo.a.i(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final t<List<T>> toSortedList() {
        return toSortedList(bo.a.o());
    }

    public final k<T> unsubscribeOn(s sVar) {
        b.e(sVar, "scheduler is null");
        return fo.a.o(new z3(this, sVar));
    }

    public final k<k<T>> window(long j10) {
        return window(j10, j10, bufferSize());
    }

    public final <U, R> k<R> withLatestFrom(p<? extends U> pVar, zn.c<? super T, ? super U, ? extends R> cVar) {
        b.e(pVar, "other is null");
        b.e(cVar, "combiner is null");
        return fo.a.o(new g4(this, cVar, pVar));
    }

    public final <U, R> k<R> zipWith(Iterable<U> iterable, zn.c<? super T, ? super U, ? extends R> cVar) {
        b.e(iterable, "other is null");
        b.e(cVar, "zipper is null");
        return fo.a.o(new j4(this, iterable, cVar));
    }

    public static <T, R> k<R> combineLatest(Iterable<? extends p<? extends T>> iterable, o<? super Object[], ? extends R> oVar) {
        return combineLatest(iterable, oVar, bufferSize());
    }

    public static <T, R> k<R> combineLatestDelayError(o<? super Object[], ? extends R> oVar, int i10, p<? extends T>... pVarArr) {
        return combineLatestDelayError(pVarArr, oVar, i10);
    }

    public static <T> k<T> concatArrayEager(int i10, int i11, p<? extends T>... pVarArr) {
        return fromArray(pVarArr).concatMapEagerDelayError(bo.a.i(), i10, i11, false);
    }

    public static <T> k<T> concatArrayEagerDelayError(int i10, int i11, p<? extends T>... pVarArr) {
        return fromArray(pVarArr).concatMapEagerDelayError(bo.a.i(), i10, i11, true);
    }

    public static <T> k<T> concatEager(p<? extends p<? extends T>> pVar, int i10, int i11) {
        return wrap(pVar).concatMapEager(bo.a.i(), i10, i11);
    }

    public static k<Long> interval(long j10, long j11, TimeUnit timeUnit, s sVar) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new n1(Math.max(0L, j10), Math.max(0L, j11), timeUnit, sVar));
    }

    public static k<Long> intervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit, s sVar) {
        int i10 = (j11 > 0L ? 1 : (j11 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j11);
        } else if (i10 == 0) {
            return empty().delay(j12, timeUnit, sVar);
        } else {
            long j14 = j10 + (j11 - 1);
            if (j10 <= 0 || j14 >= 0) {
                b.e(timeUnit, "unit is null");
                b.e(sVar, "scheduler is null");
                return fo.a.o(new o1(j10, j14, Math.max(0L, j12), Math.max(0L, j13), timeUnit, sVar));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> k<T> merge(Iterable<? extends p<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(bo.a.i());
    }

    public static <T> k<T> mergeArray(p<? extends T>... pVarArr) {
        return fromArray(pVarArr).flatMap(bo.a.i(), pVarArr.length);
    }

    public static <T> k<T> mergeArrayDelayError(p<? extends T>... pVarArr) {
        return fromArray(pVarArr).flatMap(bo.a.i(), true, pVarArr.length);
    }

    public static <T> k<T> mergeDelayError(Iterable<? extends p<? extends T>> iterable, int i10, int i11) {
        return fromIterable(iterable).flatMap(bo.a.i(), true, i10, i11);
    }

    public static <T> t<Boolean> sequenceEqual(p<? extends T> pVar, p<? extends T> pVar2, zn.d<? super T, ? super T> dVar) {
        return sequenceEqual(pVar, pVar2, dVar, bufferSize());
    }

    public static <T> k<T> switchOnNextDelayError(p<? extends p<? extends T>> pVar, int i10) {
        b.e(pVar, "sources is null");
        b.f(i10, "prefetch");
        return fo.a.o(new j3(pVar, bo.a.i(), i10, true));
    }

    public static k<Long> timer(long j10, TimeUnit timeUnit, s sVar) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new w3(Math.max(j10, 0L), timeUnit, sVar));
    }

    public static <T, D> k<T> using(Callable<? extends D> callable, o<? super D, ? extends p<? extends T>> oVar, g<? super D> gVar, boolean z10) {
        b.e(callable, "resourceSupplier is null");
        b.e(oVar, "sourceSupplier is null");
        b.e(gVar, "disposer is null");
        return fo.a.o(new a4(callable, oVar, gVar, z10));
    }

    public final Iterable<T> blockingIterable(int i10) {
        b.f(i10, "bufferSize");
        return new io.reactivex.internal.operators.observable.b(this, i10);
    }

    public final void blockingSubscribe(g<? super T> gVar) {
        io.reactivex.internal.operators.observable.k.c(this, gVar, bo.a.f5361e, bo.a.f5359c);
    }

    public final k<List<T>> buffer(int i10, int i11) {
        return (k<List<T>>) buffer(i10, i11, ArrayListSupplier.asCallable());
    }

    public final <R> k<R> concatMap(o<? super T, ? extends p<? extends R>> oVar, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "prefetch");
        if (!(this instanceof co.e)) {
            return fo.a.o(new u(this, oVar, i10, ErrorMode.IMMEDIATE));
        }
        Object call = ((co.e) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.a(call, oVar);
    }

    public final io.reactivex.a concatMapCompletable(o<? super T, ? extends c> oVar, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "capacityHint");
        return fo.a.l(new io.reactivex.internal.operators.mixed.a(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    public final io.reactivex.a concatMapCompletableDelayError(o<? super T, ? extends c> oVar, boolean z10) {
        return concatMapCompletableDelayError(oVar, z10, 2);
    }

    public final <R> k<R> concatMapDelayError(o<? super T, ? extends p<? extends R>> oVar, int i10, boolean z10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "prefetch");
        if (this instanceof co.e) {
            Object call = ((co.e) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.a(call, oVar);
        }
        return fo.a.o(new u(this, oVar, i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final <R> k<R> concatMapEager(o<? super T, ? extends p<? extends R>> oVar, int i10, int i11) {
        b.e(oVar, "mapper is null");
        b.f(i10, "maxConcurrency");
        b.f(i11, "prefetch");
        return fo.a.o(new v(this, oVar, ErrorMode.IMMEDIATE, i10, i11));
    }

    public final <R> k<R> concatMapEagerDelayError(o<? super T, ? extends p<? extends R>> oVar, int i10, int i11, boolean z10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "maxConcurrency");
        b.f(i11, "prefetch");
        return fo.a.o(new v(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10, i11));
    }

    public final <R> k<R> concatMapMaybe(o<? super T, ? extends i<? extends R>> oVar, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "prefetch");
        return fo.a.o(new io.reactivex.internal.operators.mixed.b(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    public final <R> k<R> concatMapMaybeDelayError(o<? super T, ? extends i<? extends R>> oVar, boolean z10) {
        return concatMapMaybeDelayError(oVar, z10, 2);
    }

    public final <R> k<R> concatMapSingle(o<? super T, ? extends v<? extends R>> oVar, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "prefetch");
        return fo.a.o(new io.reactivex.internal.operators.mixed.c(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    public final <R> k<R> concatMapSingleDelayError(o<? super T, ? extends v<? extends R>> oVar, boolean z10) {
        return concatMapSingleDelayError(oVar, z10, 2);
    }

    public final <R> k<R> dematerialize(o<? super T, j<R>> oVar) {
        b.e(oVar, "selector is null");
        return fo.a.o(new h0(this, oVar));
    }

    public final <K> k<T> distinct(o<? super T, K> oVar) {
        return distinct(oVar, bo.a.f());
    }

    public final <K> k<T> distinctUntilChanged(o<? super T, K> oVar) {
        b.e(oVar, "keySelector is null");
        return fo.a.o(new k0(this, oVar, b.d()));
    }

    public final <R> k<R> flatMap(o<? super T, ? extends p<? extends R>> oVar, boolean z10) {
        return flatMap(oVar, z10, Integer.MAX_VALUE);
    }

    public final io.reactivex.a flatMapCompletable(o<? super T, ? extends c> oVar, boolean z10) {
        b.e(oVar, "mapper is null");
        return fo.a.l(new x0(this, oVar, z10));
    }

    public final <R> k<R> flatMapMaybe(o<? super T, ? extends i<? extends R>> oVar, boolean z10) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new y0(this, oVar, z10));
    }

    public final <R> k<R> flatMapSingle(o<? super T, ? extends v<? extends R>> oVar, boolean z10) {
        b.e(oVar, "mapper is null");
        return fo.a.o(new z0(this, oVar, z10));
    }

    public final xn.b forEachWhile(p<? super T> pVar, g<? super Throwable> gVar) {
        return forEachWhile(pVar, gVar, bo.a.f5359c);
    }

    public final <K> k<p001do.b<K, T>> groupBy(o<? super T, ? extends K> oVar, boolean z10) {
        return (k<p001do.b<K, T>>) groupBy(oVar, bo.a.i(), z10, bufferSize());
    }

    public final k<T> observeOn(s sVar, boolean z10) {
        return observeOn(sVar, z10, bufferSize());
    }

    public final <R> k<R> publish(o<? super k<T>, ? extends p<R>> oVar) {
        b.e(oVar, "selector is null");
        return fo.a.o(new f2(this, oVar));
    }

    public final k<T> repeat(long j10) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + j10);
        } else if (i10 == 0) {
            return empty();
        } else {
            return fo.a.o(new m2(this, j10));
        }
    }

    public final <R> k<R> replay(o<? super k<T>, ? extends p<R>> oVar) {
        b.e(oVar, "selector is null");
        return p2.i(m1.g(this), oVar);
    }

    public final k<T> retry(zn.d<? super Integer, ? super Throwable> dVar) {
        b.e(dVar, "predicate is null");
        return fo.a.o(new q2(this, dVar));
    }

    public final k<T> sample(long j10, TimeUnit timeUnit, boolean z10) {
        return sample(j10, timeUnit, go.a.a(), z10);
    }

    public final k<T> sorted(Comparator<? super T> comparator) {
        b.e(comparator, "sortFunction is null");
        return toList().f().map(bo.a.m(comparator)).flatMapIterable(bo.a.i());
    }

    public final k<T> startWith(p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return concatArray(pVar, this);
    }

    public final xn.b subscribe(g<? super T> gVar) {
        return subscribe(gVar, bo.a.f5361e, bo.a.f5359c, bo.a.g());
    }

    public final <R> k<R> switchMap(o<? super T, ? extends p<? extends R>> oVar, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "bufferSize");
        if (!(this instanceof co.e)) {
            return fo.a.o(new j3(this, oVar, i10, false));
        }
        Object call = ((co.e) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.a(call, oVar);
    }

    public final <R> k<R> switchMapDelayError(o<? super T, ? extends p<? extends R>> oVar, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "bufferSize");
        if (!(this instanceof co.e)) {
            return fo.a.o(new j3(this, oVar, i10, true));
        }
        Object call = ((co.e) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.a(call, oVar);
    }

    public final k<T> throttleFirst(long j10, TimeUnit timeUnit, s sVar) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new r3(this, j10, timeUnit, sVar));
    }

    public final k<T> throttleLast(long j10, TimeUnit timeUnit, s sVar) {
        return sample(j10, timeUnit, sVar);
    }

    public final k<T> throttleLatest(long j10, TimeUnit timeUnit, boolean z10) {
        return throttleLatest(j10, timeUnit, go.a.a(), z10);
    }

    public final k<T> throttleWithTimeout(long j10, TimeUnit timeUnit, s sVar) {
        return debounce(j10, timeUnit, sVar);
    }

    public final k<go.b<T>> timeInterval(s sVar) {
        return timeInterval(TimeUnit.MILLISECONDS, sVar);
    }

    public final <V> k<T> timeout(o<? super T, ? extends p<V>> oVar, p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return timeout0(null, oVar, pVar);
    }

    public final k<go.b<T>> timestamp(s sVar) {
        return timestamp(TimeUnit.MILLISECONDS, sVar);
    }

    public final t<List<T>> toList(int i10) {
        b.f(i10, "capacityHint");
        return fo.a.p(new y3(this, i10));
    }

    public final t<List<T>> toSortedList(Comparator<? super T> comparator) {
        b.e(comparator, "comparator is null");
        return (t<List<T>>) toList().d(bo.a.m(comparator));
    }

    public final k<k<T>> window(long j10, long j11) {
        return window(j10, j11, bufferSize());
    }

    public static <T, R> k<R> combineLatest(Iterable<? extends p<? extends T>> iterable, o<? super Object[], ? extends R> oVar, int i10) {
        b.e(iterable, "sources is null");
        b.e(oVar, "combiner is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new t(null, iterable, oVar, i10 << 1, false));
    }

    public static <T, R> k<R> combineLatestDelayError(p<? extends T>[] pVarArr, o<? super Object[], ? extends R> oVar, int i10) {
        b.f(i10, "bufferSize");
        b.e(oVar, "combiner is null");
        if (pVarArr.length == 0) {
            return empty();
        }
        return fo.a.o(new t(pVarArr, null, oVar, i10 << 1, true));
    }

    public static <T> k<T> concat(p<? extends p<? extends T>> pVar) {
        return concat(pVar, bufferSize());
    }

    public static <T> k<T> concatDelayError(p<? extends p<? extends T>> pVar) {
        return concatDelayError(pVar, bufferSize(), true);
    }

    public static <T> k<T> concatEager(Iterable<? extends p<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> k<T> error(Throwable th2) {
        b.e(th2, "exception is null");
        return error(bo.a.k(th2));
    }

    public static <T> k<T> fromFuture(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        b.e(future, "future is null");
        b.e(timeUnit, "unit is null");
        return fo.a.o(new d1(future, j10, timeUnit));
    }

    public static <T> k<T> just(T t10, T t11) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        return fromArray(t10, t11);
    }

    public static <T> k<T> merge(Iterable<? extends p<? extends T>> iterable, int i10) {
        return fromIterable(iterable).flatMap(bo.a.i(), i10);
    }

    public static <T> k<T> mergeDelayError(Iterable<? extends p<? extends T>> iterable, int i10) {
        return fromIterable(iterable).flatMap(bo.a.i(), true, i10);
    }

    public static <T> t<Boolean> sequenceEqual(p<? extends T> pVar, p<? extends T> pVar2, zn.d<? super T, ? super T> dVar, int i10) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(dVar, "isEqual is null");
        b.f(i10, "bufferSize");
        return fo.a.p(new y2(pVar, pVar2, dVar, i10));
    }

    public final T blockingSingle(T t10) {
        return single(t10).c();
    }

    public final void blockingSubscribe(g<? super T> gVar, g<? super Throwable> gVar2) {
        io.reactivex.internal.operators.observable.k.c(this, gVar, gVar2, bo.a.f5359c);
    }

    public final <U extends Collection<? super T>> k<U> buffer(int i10, int i11, Callable<U> callable) {
        b.f(i10, ContactConstant.CallsRecordKeys.COUNT);
        b.f(i11, "skip");
        b.e(callable, "bufferSupplier is null");
        return fo.a.o(new l(this, i10, i11, callable));
    }

    public final io.reactivex.a concatMapCompletableDelayError(o<? super T, ? extends c> oVar, boolean z10, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "prefetch");
        return fo.a.l(new io.reactivex.internal.operators.mixed.a(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    public final <U> k<U> concatMapIterable(o<? super T, ? extends Iterable<? extends U>> oVar, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "prefetch");
        return (k<U>) concatMap(m1.a(oVar), i10);
    }

    public final <R> k<R> concatMapMaybeDelayError(o<? super T, ? extends i<? extends R>> oVar, boolean z10, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "prefetch");
        return fo.a.o(new io.reactivex.internal.operators.mixed.b(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    public final <R> k<R> concatMapSingleDelayError(o<? super T, ? extends v<? extends R>> oVar, boolean z10, int i10) {
        b.e(oVar, "mapper is null");
        b.f(i10, "prefetch");
        return fo.a.o(new io.reactivex.internal.operators.mixed.c(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    public final k<T> concatWith(v<? extends T> vVar) {
        b.e(vVar, "other is null");
        return fo.a.o(new y(this, vVar));
    }

    public final k<T> debounce(long j10, TimeUnit timeUnit) {
        return debounce(j10, timeUnit, go.a.a());
    }

    public final k<T> delay(long j10, TimeUnit timeUnit) {
        return delay(j10, timeUnit, go.a.a(), false);
    }

    public final k<T> delaySubscription(long j10, TimeUnit timeUnit) {
        return delaySubscription(j10, timeUnit, go.a.a());
    }

    public final <K> k<T> distinct(o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        b.e(oVar, "keySelector is null");
        b.e(callable, "collectionSupplier is null");
        return fo.a.o(new j0(this, oVar, callable));
    }

    public final t<T> elementAt(long j10, T t10) {
        if (j10 >= 0) {
            b.e(t10, "defaultItem is null");
            return fo.a.p(new r0(this, j10, t10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final <R> k<R> flatMap(o<? super T, ? extends p<? extends R>> oVar, boolean z10, int i10) {
        return flatMap(oVar, z10, i10, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> k<V> flatMapIterable(o<? super T, ? extends Iterable<? extends U>> oVar, zn.c<? super T, ? super U, ? extends V> cVar) {
        b.e(oVar, "mapper is null");
        b.e(cVar, "resultSelector is null");
        return (k<V>) flatMap(m1.a(oVar), cVar, false, bufferSize(), bufferSize());
    }

    public final xn.b forEachWhile(p<? super T> pVar, g<? super Throwable> gVar, zn.a aVar) {
        b.e(pVar, "onNext is null");
        b.e(gVar, "onError is null");
        b.e(aVar, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(pVar, gVar, aVar);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K, V> k<p001do.b<K, V>> groupBy(o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2) {
        return groupBy(oVar, oVar2, false, bufferSize());
    }

    public final k<T> mergeWith(v<? extends T> vVar) {
        b.e(vVar, "other is null");
        return fo.a.o(new z1(this, vVar));
    }

    public final k<T> observeOn(s sVar, boolean z10, int i10) {
        b.e(sVar, "scheduler is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new b2(this, sVar, z10, i10));
    }

    public final k<T> onErrorResumeNext(p<? extends T> pVar) {
        b.e(pVar, "next is null");
        return onErrorResumeNext(bo.a.l(pVar));
    }

    public final <R> t<R> reduce(R r10, zn.c<R, ? super T, R> cVar) {
        b.e(r10, "seed is null");
        b.e(cVar, "reducer is null");
        return fo.a.p(new j2(this, r10, cVar));
    }

    public final k<T> sample(long j10, TimeUnit timeUnit, s sVar) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new t2(this, j10, timeUnit, sVar, false));
    }

    public final <R> k<R> scan(R r10, zn.c<R, ? super T, R> cVar) {
        b.e(r10, "initialValue is null");
        return scanWith(bo.a.k(r10), cVar);
    }

    public final k<T> skip(long j10, TimeUnit timeUnit) {
        return skipUntil(timer(j10, timeUnit));
    }

    public final xn.b subscribe(g<? super T> gVar, g<? super Throwable> gVar2) {
        return subscribe(gVar, gVar2, bo.a.f5359c, bo.a.g());
    }

    public final k<T> take(long j10, TimeUnit timeUnit) {
        return takeUntil(timer(j10, timeUnit));
    }

    public final k<T> takeUntil(p<? super T> pVar) {
        b.e(pVar, "stopPredicate is null");
        return fo.a.o(new p3(this, pVar));
    }

    public final io.reactivex.observers.a<T> test(boolean z10) {
        io.reactivex.observers.a<T> aVar = new io.reactivex.observers.a<>();
        if (z10) {
            aVar.dispose();
        }
        subscribe(aVar);
        return aVar;
    }

    public final k<T> throttleLatest(long j10, TimeUnit timeUnit, s sVar) {
        return throttleLatest(j10, timeUnit, sVar, false);
    }

    public final k<go.b<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, go.a.a());
    }

    public final k<go.b<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, go.a.a());
    }

    public final <K, V> t<Map<K, V>> toMap(o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2) {
        b.e(oVar, "keySelector is null");
        b.e(oVar2, "valueSelector is null");
        return (t<Map<K, V>>) collect(HashMapSupplier.asCallable(), bo.a.E(oVar, oVar2));
    }

    public final k<k<T>> window(long j10, long j11, int i10) {
        b.g(j10, ContactConstant.CallsRecordKeys.COUNT);
        b.g(j11, "skip");
        b.f(i10, "bufferSize");
        return fo.a.o(new b4(this, j10, j11, i10));
    }

    public static <T> k<T> concat(p<? extends p<? extends T>> pVar, int i10) {
        b.e(pVar, "sources is null");
        b.f(i10, "prefetch");
        return fo.a.o(new u(pVar, bo.a.i(), i10, ErrorMode.IMMEDIATE));
    }

    public static <T> k<T> concatDelayError(p<? extends p<? extends T>> pVar, int i10, boolean z10) {
        b.e(pVar, "sources is null");
        b.f(i10, "prefetch is null");
        return fo.a.o(new u(pVar, bo.a.i(), i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public static <T> k<T> concatEager(Iterable<? extends p<? extends T>> iterable, int i10, int i11) {
        return fromIterable(iterable).concatMapEagerDelayError(bo.a.i(), i10, i11, false);
    }

    public static <T> k<T> merge(p<? extends p<? extends T>> pVar) {
        b.e(pVar, "sources is null");
        return fo.a.o(new v0(pVar, bo.a.i(), false, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> k<T> mergeDelayError(p<? extends p<? extends T>> pVar) {
        b.e(pVar, "sources is null");
        return fo.a.o(new v0(pVar, bo.a.i(), true, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> k<T> switchOnNext(p<? extends p<? extends T>> pVar) {
        return switchOnNext(pVar, bufferSize());
    }

    private <U, V> k<T> timeout0(p<U> pVar, o<? super T, ? extends p<V>> oVar, p<? extends T> pVar2) {
        b.e(oVar, "itemTimeoutIndicator is null");
        return fo.a.o(new u3(this, pVar, oVar, pVar2));
    }

    public static <T, R> k<R> zip(p<? extends p<? extends T>> pVar, o<? super Object[], ? extends R> oVar) {
        b.e(oVar, "zipper is null");
        b.e(pVar, "sources is null");
        return fo.a.o(new x3(pVar, 16).flatMap(m1.n(oVar)));
    }

    public final void blockingSubscribe(g<? super T> gVar, g<? super Throwable> gVar2, zn.a aVar) {
        io.reactivex.internal.operators.observable.k.c(this, gVar, gVar2, aVar);
    }

    public final k<T> debounce(long j10, TimeUnit timeUnit, s sVar) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new d0(this, j10, timeUnit, sVar));
    }

    public final k<T> delay(long j10, TimeUnit timeUnit, boolean z10) {
        return delay(j10, timeUnit, go.a.a(), z10);
    }

    public final k<T> delaySubscription(long j10, TimeUnit timeUnit, s sVar) {
        return delaySubscription(timer(j10, timeUnit, sVar));
    }

    public final k<T> distinctUntilChanged(zn.d<? super T, ? super T> dVar) {
        b.e(dVar, "comparer is null");
        return fo.a.o(new k0(this, bo.a.i(), dVar));
    }

    public final <R> k<R> flatMap(o<? super T, ? extends p<? extends R>> oVar, boolean z10, int i10, int i11) {
        b.e(oVar, "mapper is null");
        b.f(i10, "maxConcurrency");
        b.f(i11, "bufferSize");
        if (!(this instanceof co.e)) {
            return fo.a.o(new v0(this, oVar, z10, i10, i11));
        }
        Object call = ((co.e) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.a(call, oVar);
    }

    public final <K, V> k<p001do.b<K, V>> groupBy(o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2, boolean z10) {
        return groupBy(oVar, oVar2, z10, bufferSize());
    }

    public final <R> k<R> replay(o<? super k<T>, ? extends p<R>> oVar, int i10) {
        b.e(oVar, "selector is null");
        b.f(i10, "bufferSize");
        return p2.i(m1.h(this, i10), oVar);
    }

    public final k<T> retry(long j10) {
        return retry(j10, bo.a.c());
    }

    public final k<T> skip(long j10, TimeUnit timeUnit, s sVar) {
        return skipUntil(timer(j10, timeUnit, sVar));
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit) {
        return skipLast(j10, timeUnit, go.a.c(), false, bufferSize());
    }

    public final k<T> startWith(T t10) {
        b.e(t10, "item is null");
        return concatArray(just(t10), this);
    }

    public final xn.b subscribe(g<? super T> gVar, g<? super Throwable> gVar2, zn.a aVar) {
        return subscribe(gVar, gVar2, aVar, bo.a.g());
    }

    public final k<T> take(long j10, TimeUnit timeUnit, s sVar) {
        return takeUntil(timer(j10, timeUnit, sVar));
    }

    public final k<T> throttleLatest(long j10, TimeUnit timeUnit, s sVar, boolean z10) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new s3(this, j10, timeUnit, sVar, z10));
    }

    public final k<go.b<T>> timeInterval(TimeUnit timeUnit, s sVar) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new t3(this, timeUnit, sVar));
    }

    public final k<T> timeout(long j10, TimeUnit timeUnit) {
        return timeout0(j10, timeUnit, null, go.a.a());
    }

    public final k<go.b<T>> timestamp(TimeUnit timeUnit, s sVar) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return (k<go.b<T>>) map(bo.a.u(timeUnit, sVar));
    }

    public final <U extends Collection<? super T>> t<U> toList(Callable<U> callable) {
        b.e(callable, "collectionSupplier is null");
        return fo.a.p(new y3(this, callable));
    }

    public final t<List<T>> toSortedList(Comparator<? super T> comparator, int i10) {
        b.e(comparator, "comparator is null");
        return (t<List<T>>) toList(i10).d(bo.a.m(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> k<R> withLatestFrom(p<T1> pVar, p<T2> pVar2, zn.h<? super T, ? super T1, ? super T2, R> hVar) {
        b.e(pVar, "o1 is null");
        b.e(pVar2, "o2 is null");
        b.e(hVar, "combiner is null");
        return withLatestFrom(new p[]{pVar, pVar2}, bo.a.w(hVar));
    }

    public final <U, R> k<R> zipWith(p<? extends U> pVar, zn.c<? super T, ? super U, ? extends R> cVar) {
        b.e(pVar, "other is null");
        return zip(this, pVar, cVar);
    }

    public static <T, S> k<T> generate(Callable<S> callable, zn.b<S, d<T>> bVar) {
        b.e(bVar, "generator is null");
        return generate(callable, m1.l(bVar), bo.a.g());
    }

    public static k<Long> interval(long j10, TimeUnit timeUnit) {
        return interval(j10, j10, timeUnit, go.a.a());
    }

    public final T blockingFirst(T t10) {
        d dVar = new d();
        subscribe(dVar);
        T a10 = dVar.a();
        return a10 != null ? a10 : t10;
    }

    public final T blockingLast(T t10) {
        e eVar = new e();
        subscribe(eVar);
        T a10 = eVar.a();
        return a10 != null ? a10 : t10;
    }

    public final void blockingSubscribe(r<? super T> rVar) {
        io.reactivex.internal.operators.observable.k.b(this, rVar);
    }

    public final k<T> concatWith(i<? extends T> iVar) {
        b.e(iVar, "other is null");
        return fo.a.o(new x(this, iVar));
    }

    public final k<T> delay(long j10, TimeUnit timeUnit, s sVar) {
        return delay(j10, timeUnit, sVar, false);
    }

    public final <K, V> k<p001do.b<K, V>> groupBy(o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2, boolean z10, int i10) {
        b.e(oVar, "keySelector is null");
        b.e(oVar2, "valueSelector is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new ObservableGroupBy(this, oVar, oVar2, i10, z10));
    }

    public final k<T> mergeWith(i<? extends T> iVar) {
        b.e(iVar, "other is null");
        return fo.a.o(new y1(this, iVar));
    }

    public final k<T> retry(long j10, p<? super Throwable> pVar) {
        if (j10 >= 0) {
            b.e(pVar, "predicate is null");
            return fo.a.o(new r2(this, j10, pVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j10);
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit, boolean z10) {
        return skipLast(j10, timeUnit, go.a.c(), z10, bufferSize());
    }

    public final xn.b subscribe(g<? super T> gVar, g<? super Throwable> gVar2, zn.a aVar, g<? super xn.b> gVar3) {
        b.e(gVar, "onNext is null");
        b.e(gVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(gVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(gVar, gVar2, aVar, gVar3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final k<T> takeLast(long j10, long j11, TimeUnit timeUnit) {
        return takeLast(j10, j11, timeUnit, go.a.c(), false, bufferSize());
    }

    public final k<T> timeout(long j10, TimeUnit timeUnit, p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return timeout0(j10, timeUnit, pVar, go.a.a());
    }

    public final <K, V> t<Map<K, Collection<V>>> toMultimap(o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2) {
        return toMultimap(oVar, oVar2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public static <T> k<T> fromFuture(Future<? extends T> future, long j10, TimeUnit timeUnit, s sVar) {
        b.e(sVar, "scheduler is null");
        return fromFuture(future, j10, timeUnit).subscribeOn(sVar);
    }

    public static k<Long> interval(long j10, TimeUnit timeUnit, s sVar) {
        return interval(j10, j10, timeUnit, sVar);
    }

    public static <T> k<T> just(T t10, T t11, T t12) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        b.e(t12, "item3 is null");
        return fromArray(t10, t11, t12);
    }

    public static <T> k<T> merge(p<? extends p<? extends T>> pVar, int i10) {
        b.e(pVar, "sources is null");
        b.f(i10, "maxConcurrency");
        return fo.a.o(new v0(pVar, bo.a.i(), false, i10, bufferSize()));
    }

    public static <T> k<T> mergeDelayError(p<? extends p<? extends T>> pVar, int i10) {
        b.e(pVar, "sources is null");
        b.f(i10, "maxConcurrency");
        return fo.a.o(new v0(pVar, bo.a.i(), true, i10, bufferSize()));
    }

    public final k<T> delay(long j10, TimeUnit timeUnit, s sVar, boolean z10) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new f0(this, j10, timeUnit, sVar, z10));
    }

    public final k<T> doOnEach(g<? super j<T>> gVar) {
        b.e(gVar, "onNotification is null");
        return doOnEach(bo.a.r(gVar), bo.a.q(gVar), bo.a.p(gVar), bo.a.f5359c);
    }

    public final k<T> sample(long j10, TimeUnit timeUnit, s sVar, boolean z10) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return fo.a.o(new t2(this, j10, timeUnit, sVar, z10));
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit, s sVar) {
        return skipLast(j10, timeUnit, sVar, false, bufferSize());
    }

    public final k<T> takeLast(long j10, long j11, TimeUnit timeUnit, s sVar) {
        return takeLast(j10, j11, timeUnit, sVar, false, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> t<Map<K, V>> toMap(o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2, Callable<? extends Map<K, V>> callable) {
        b.e(oVar, "keySelector is null");
        b.e(oVar2, "valueSelector is null");
        b.e(callable, "mapSupplier is null");
        return (t<Map<K, V>>) collect(callable, bo.a.E(oVar, oVar2));
    }

    public final t<List<T>> toSortedList(int i10) {
        return toSortedList(bo.a.o(), i10);
    }

    public final <U, R> k<R> zipWith(p<? extends U> pVar, zn.c<? super T, ? super U, ? extends R> cVar, boolean z10) {
        return zip(this, pVar, cVar, z10);
    }

    public static <T, R> k<R> combineLatest(p<? extends T>[] pVarArr, o<? super Object[], ? extends R> oVar) {
        return combineLatest(pVarArr, oVar, bufferSize());
    }

    public static <T> k<T> concat(p<? extends T> pVar, p<? extends T> pVar2) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        return concatArray(pVar, pVar2);
    }

    public static <T, S> k<T> generate(Callable<S> callable, zn.b<S, d<T>> bVar, g<? super S> gVar) {
        b.e(bVar, "generator is null");
        return generate(callable, m1.l(bVar), gVar);
    }

    public final <U extends Collection<? super T>> k<U> buffer(int i10, Callable<U> callable) {
        return buffer(i10, i10, callable);
    }

    public final k<T> concatWith(c cVar) {
        b.e(cVar, "other is null");
        return fo.a.o(new w(this, cVar));
    }

    public final k<T> mergeWith(c cVar) {
        b.e(cVar, "other is null");
        return fo.a.o(new x1(this, cVar));
    }

    public final <R> k<R> replay(o<? super k<T>, ? extends p<R>> oVar, int i10, long j10, TimeUnit timeUnit) {
        return replay(oVar, i10, j10, timeUnit, go.a.a());
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit, s sVar, boolean z10) {
        return skipLast(j10, timeUnit, sVar, z10, bufferSize());
    }

    public final k<T> takeLast(long j10, long j11, TimeUnit timeUnit, s sVar, boolean z10, int i10) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        b.f(i10, "bufferSize");
        if (j10 >= 0) {
            return fo.a.o(new n3(this, j10, j11, timeUnit, sVar, i10, z10));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j10);
    }

    public final k<T> timeout(long j10, TimeUnit timeUnit, s sVar, p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return timeout0(j10, timeUnit, pVar, sVar);
    }

    public final k<k<T>> window(long j10, long j11, TimeUnit timeUnit) {
        return window(j10, j11, timeUnit, go.a.a(), bufferSize());
    }

    public final <U, R> k<R> zipWith(p<? extends U> pVar, zn.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10) {
        return zip(this, pVar, cVar, z10, i10);
    }

    public static <T, R> k<R> combineLatest(p<? extends T>[] pVarArr, o<? super Object[], ? extends R> oVar, int i10) {
        b.e(pVarArr, "sources is null");
        if (pVarArr.length == 0) {
            return empty();
        }
        b.e(oVar, "combiner is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new t(pVarArr, null, oVar, i10 << 1, false));
    }

    public static <T, R> k<R> combineLatestDelayError(Iterable<? extends p<? extends T>> iterable, o<? super Object[], ? extends R> oVar) {
        return combineLatestDelayError(iterable, oVar, bufferSize());
    }

    public static <T> t<Boolean> sequenceEqual(p<? extends T> pVar, p<? extends T> pVar2, int i10) {
        return sequenceEqual(pVar, pVar2, b.d(), i10);
    }

    public final k<List<T>> buffer(long j10, long j11, TimeUnit timeUnit) {
        return (k<List<T>>) buffer(j10, j11, timeUnit, go.a.a(), ArrayListSupplier.asCallable());
    }

    public final <R> k<R> replay(o<? super k<T>, ? extends p<R>> oVar, int i10, long j10, TimeUnit timeUnit, s sVar) {
        b.e(oVar, "selector is null");
        b.f(i10, "bufferSize");
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return p2.i(m1.i(this, i10, j10, timeUnit, sVar), oVar);
    }

    public final k<T> retry(p<? super Throwable> pVar) {
        return retry(Long.MAX_VALUE, pVar);
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit, s sVar, boolean z10, int i10) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new e3(this, j10, timeUnit, sVar, i10 << 1, z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> t<Map<K, Collection<V>>> toMultimap(o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2, Callable<? extends Map<K, Collection<V>>> callable, o<? super K, ? extends Collection<? super V>> oVar3) {
        b.e(oVar, "keySelector is null");
        b.e(oVar2, "valueSelector is null");
        b.e(callable, "mapSupplier is null");
        b.e(oVar3, "collectionFactory is null");
        return (t<Map<K, Collection<V>>>) collect(callable, bo.a.F(oVar, oVar2, oVar3));
    }

    public final k<k<T>> window(long j10, long j11, TimeUnit timeUnit, s sVar) {
        return window(j10, j11, timeUnit, sVar, bufferSize());
    }

    public static <T, R> k<R> combineLatestDelayError(Iterable<? extends p<? extends T>> iterable, o<? super Object[], ? extends R> oVar, int i10) {
        b.e(iterable, "sources is null");
        b.e(oVar, "combiner is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new t(null, iterable, oVar, i10 << 1, true));
    }

    public static <T> k<T> fromFuture(Future<? extends T> future, s sVar) {
        b.e(sVar, "scheduler is null");
        return fromFuture(future).subscribeOn(sVar);
    }

    public static <T, S> k<T> generate(Callable<S> callable, zn.c<S, d<T>, S> cVar) {
        return generate(callable, cVar, bo.a.g());
    }

    public static <T> k<T> merge(p<? extends T> pVar, p<? extends T> pVar2) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        return fromArray(pVar, pVar2).flatMap(bo.a.i(), false, 2);
    }

    public static <T> k<T> mergeDelayError(p<? extends T> pVar, p<? extends T> pVar2) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        return fromArray(pVar, pVar2).flatMap(bo.a.i(), true, 2);
    }

    public static <T1, T2, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, zn.c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        return zipArray(bo.a.v(cVar), false, bufferSize(), pVar, pVar2);
    }

    public final k<List<T>> buffer(long j10, long j11, TimeUnit timeUnit, s sVar) {
        return (k<List<T>>) buffer(j10, j11, timeUnit, sVar, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> k<T> delay(p<U> pVar, o<? super T, ? extends p<V>> oVar) {
        return delaySubscription(pVar).delay(oVar);
    }

    public final <U> k<T> sample(p<U> pVar) {
        b.e(pVar, "sampler is null");
        return fo.a.o(new u2(this, pVar, false));
    }

    public final k<T> timeout(long j10, TimeUnit timeUnit, s sVar) {
        return timeout0(j10, timeUnit, null, sVar);
    }

    public final k<k<T>> window(long j10, long j11, TimeUnit timeUnit, s sVar, int i10) {
        b.g(j10, "timespan");
        b.g(j11, "timeskip");
        b.f(i10, "bufferSize");
        b.e(sVar, "scheduler is null");
        b.e(timeUnit, "unit is null");
        return fo.a.o(new f4(this, j10, j11, timeUnit, sVar, Long.MAX_VALUE, i10, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> k<R> withLatestFrom(p<T1> pVar, p<T2> pVar2, p<T3> pVar3, i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        b.e(pVar, "o1 is null");
        b.e(pVar2, "o2 is null");
        b.e(pVar3, "o3 is null");
        b.e(iVar, "combiner is null");
        return withLatestFrom(new p[]{pVar, pVar2, pVar3}, bo.a.x(iVar));
    }

    public static <T> k<T> concat(p<? extends T> pVar, p<? extends T> pVar2, p<? extends T> pVar3) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        return concatArray(pVar, pVar2, pVar3);
    }

    public static <T, S> k<T> generate(Callable<S> callable, zn.c<S, d<T>, S> cVar, g<? super S> gVar) {
        b.e(callable, "initialState is null");
        b.e(cVar, "generator is null");
        b.e(gVar, "disposeState is null");
        return fo.a.o(new h1(callable, cVar, gVar));
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        b.e(t12, "item3 is null");
        b.e(t13, "item4 is null");
        return fromArray(t10, t11, t12, t13);
    }

    public final <U extends Collection<? super T>> k<U> buffer(long j10, long j11, TimeUnit timeUnit, s sVar, Callable<U> callable) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        b.e(callable, "bufferSupplier is null");
        return fo.a.o(new io.reactivex.internal.operators.observable.p(this, j10, j11, timeUnit, sVar, callable, Integer.MAX_VALUE, false));
    }

    public final <U, V> k<T> timeout(p<U> pVar, o<? super T, ? extends p<V>> oVar) {
        b.e(pVar, "firstTimeoutIndicator is null");
        return timeout0(pVar, oVar, null);
    }

    public final k<T> doOnEach(r<? super T> rVar) {
        b.e(rVar, "observer is null");
        return doOnEach(m1.f(rVar), m1.e(rVar), m1.d(rVar), bo.a.f5359c);
    }

    public final <U> k<T> sample(p<U> pVar, boolean z10) {
        b.e(pVar, "sampler is null");
        return fo.a.o(new u2(this, pVar, z10));
    }

    @Override // io.reactivex.p
    public final void subscribe(r<? super T> rVar) {
        b.e(rVar, "observer is null");
        try {
            r<? super T> x10 = fo.a.x(this, rVar);
            b.e(x10, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(x10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            fo.a.s(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public static <T> k<T> merge(p<? extends T> pVar, p<? extends T> pVar2, p<? extends T> pVar3) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        return fromArray(pVar, pVar2, pVar3).flatMap(bo.a.i(), false, 3);
    }

    public static <T> k<T> mergeDelayError(p<? extends T> pVar, p<? extends T> pVar2, p<? extends T> pVar3) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        return fromArray(pVar, pVar2, pVar3).flatMap(bo.a.i(), true, 3);
    }

    public static <T1, T2, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, zn.c<? super T1, ? super T2, ? extends R> cVar, boolean z10) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        return zipArray(bo.a.v(cVar), z10, bufferSize(), pVar, pVar2);
    }

    public final <R> k<R> flatMap(o<? super T, ? extends p<? extends R>> oVar, o<? super Throwable, ? extends p<? extends R>> oVar2, Callable<? extends p<? extends R>> callable) {
        b.e(oVar, "onNextMapper is null");
        b.e(oVar2, "onErrorMapper is null");
        b.e(callable, "onCompleteSupplier is null");
        return merge(new v1(this, oVar, oVar2, callable));
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit) {
        return takeLast(j10, timeUnit, go.a.c(), false, bufferSize());
    }

    public final <U, V> k<T> timeout(p<U> pVar, o<? super T, ? extends p<V>> oVar, p<? extends T> pVar2) {
        b.e(pVar, "firstTimeoutIndicator is null");
        b.e(pVar2, "other is null");
        return timeout0(pVar, oVar, pVar2);
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit, boolean z10) {
        return takeLast(j10, timeUnit, go.a.c(), z10, bufferSize());
    }

    public final <K, V> t<Map<K, Collection<V>>> toMultimap(o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(oVar, oVar2, callable, ArrayListSupplier.asFunction());
    }

    public static <T1, T2, R> k<R> combineLatest(p<? extends T1> pVar, p<? extends T2> pVar2, zn.c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        return combineLatest(bo.a.v(cVar), bufferSize(), pVar, pVar2);
    }

    public static <T> k<T> concat(p<? extends T> pVar, p<? extends T> pVar2, p<? extends T> pVar3, p<? extends T> pVar4) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        return concatArray(pVar, pVar2, pVar3, pVar4);
    }

    public final k<List<T>> buffer(long j10, TimeUnit timeUnit) {
        return buffer(j10, timeUnit, go.a.a(), Integer.MAX_VALUE);
    }

    public final <R> k<R> replay(o<? super k<T>, ? extends p<R>> oVar, int i10, s sVar) {
        b.e(oVar, "selector is null");
        b.e(sVar, "scheduler is null");
        b.f(i10, "bufferSize");
        return p2.i(m1.h(this, i10), m1.k(oVar, sVar));
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit, s sVar) {
        return takeLast(j10, timeUnit, sVar, false, bufferSize());
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        b.e(t12, "item3 is null");
        b.e(t13, "item4 is null");
        b.e(t14, "item5 is null");
        return fromArray(t10, t11, t12, t13, t14);
    }

    public static <T1, T2, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, zn.c<? super T1, ? super T2, ? extends R> cVar, boolean z10, int i10) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        return zipArray(bo.a.v(cVar), z10, i10, pVar, pVar2);
    }

    public final k<List<T>> buffer(long j10, TimeUnit timeUnit, int i10) {
        return buffer(j10, timeUnit, go.a.a(), i10);
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit, s sVar, boolean z10) {
        return takeLast(j10, timeUnit, sVar, z10, bufferSize());
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit) {
        return window(j10, timeUnit, go.a.a(), Long.MAX_VALUE, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> k<R> withLatestFrom(p<T1> pVar, p<T2> pVar2, p<T3> pVar3, p<T4> pVar4, zn.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        b.e(pVar, "o1 is null");
        b.e(pVar2, "o2 is null");
        b.e(pVar3, "o3 is null");
        b.e(pVar4, "o4 is null");
        b.e(jVar, "combiner is null");
        return withLatestFrom(new p[]{pVar, pVar2, pVar3, pVar4}, bo.a.y(jVar));
    }

    public static <T> k<T> merge(p<? extends T> pVar, p<? extends T> pVar2, p<? extends T> pVar3, p<? extends T> pVar4) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        return fromArray(pVar, pVar2, pVar3, pVar4).flatMap(bo.a.i(), false, 4);
    }

    public static <T> k<T> mergeDelayError(p<? extends T> pVar, p<? extends T> pVar2, p<? extends T> pVar3, p<? extends T> pVar4) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        return fromArray(pVar, pVar2, pVar3, pVar4).flatMap(bo.a.i(), true, 4);
    }

    public final k<List<T>> buffer(long j10, TimeUnit timeUnit, s sVar, int i10) {
        return (k<List<T>>) buffer(j10, timeUnit, sVar, i10, ArrayListSupplier.asCallable(), false);
    }

    public final <R> k<R> flatMap(o<? super T, ? extends p<? extends R>> oVar, o<Throwable, ? extends p<? extends R>> oVar2, Callable<? extends p<? extends R>> callable, int i10) {
        b.e(oVar, "onNextMapper is null");
        b.e(oVar2, "onErrorMapper is null");
        b.e(callable, "onCompleteSupplier is null");
        return merge(new v1(this, oVar, oVar2, callable), i10);
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit, s sVar, boolean z10, int i10) {
        return takeLast(Long.MAX_VALUE, j10, timeUnit, sVar, z10, i10);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, long j11) {
        return window(j10, timeUnit, go.a.a(), j11, false);
    }

    public static <T1, T2, T3, R> k<R> combineLatest(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, zn.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        return combineLatest(bo.a.w(hVar), bufferSize(), pVar, pVar2, pVar3);
    }

    public final <U extends Collection<? super T>> k<U> buffer(long j10, TimeUnit timeUnit, s sVar, int i10, Callable<U> callable, boolean z10) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        b.e(callable, "bufferSupplier is null");
        b.f(i10, ContactConstant.CallsRecordKeys.COUNT);
        return fo.a.o(new io.reactivex.internal.operators.observable.p(this, j10, j10, timeUnit, sVar, callable, i10, z10));
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, long j11, boolean z10) {
        return window(j10, timeUnit, go.a.a(), j11, z10);
    }

    public static <T1, T2, T3, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, zn.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        return zipArray(bo.a.w(hVar), false, bufferSize(), pVar, pVar2, pVar3);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, s sVar) {
        return window(j10, timeUnit, sVar, Long.MAX_VALUE, false);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, s sVar, long j11) {
        return window(j10, timeUnit, sVar, j11, false);
    }

    public final <R> k<R> flatMap(o<? super T, ? extends p<? extends R>> oVar, int i10) {
        return flatMap((o) oVar, false, i10, bufferSize());
    }

    public final <R> k<R> replay(o<? super k<T>, ? extends p<R>> oVar, long j10, TimeUnit timeUnit) {
        return replay(oVar, j10, timeUnit, go.a.a());
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, s sVar, long j11, boolean z10) {
        return window(j10, timeUnit, sVar, j11, z10, bufferSize());
    }

    public static <T1, T2, T3, T4, R> k<R> combineLatest(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        return combineLatest(bo.a.x(iVar), bufferSize(), pVar, pVar2, pVar3, pVar4);
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        b.e(t12, "item3 is null");
        b.e(t13, "item4 is null");
        b.e(t14, "item5 is null");
        b.e(t15, "item6 is null");
        return fromArray(t10, t11, t12, t13, t14, t15);
    }

    public final <U, R> k<R> flatMap(o<? super T, ? extends p<? extends U>> oVar, zn.c<? super T, ? super U, ? extends R> cVar) {
        return flatMap(oVar, cVar, false, bufferSize(), bufferSize());
    }

    public final <R> k<R> replay(o<? super k<T>, ? extends p<R>> oVar, long j10, TimeUnit timeUnit, s sVar) {
        b.e(oVar, "selector is null");
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return p2.i(m1.j(this, j10, timeUnit, sVar), oVar);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, s sVar, long j11, boolean z10, int i10) {
        b.f(i10, "bufferSize");
        b.e(sVar, "scheduler is null");
        b.e(timeUnit, "unit is null");
        b.g(j11, ContactConstant.CallsRecordKeys.COUNT);
        return fo.a.o(new f4(this, j10, j10, timeUnit, sVar, j11, i10, z10));
    }

    public static <T1, T2, T3, T4, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        return zipArray(bo.a.x(iVar), false, bufferSize(), pVar, pVar2, pVar3, pVar4);
    }

    public final k<List<T>> buffer(long j10, TimeUnit timeUnit, s sVar) {
        return (k<List<T>>) buffer(j10, timeUnit, sVar, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    public final <U, R> k<R> flatMap(o<? super T, ? extends p<? extends U>> oVar, zn.c<? super T, ? super U, ? extends R> cVar, boolean z10) {
        return flatMap(oVar, cVar, z10, bufferSize(), bufferSize());
    }

    public final <R> k<R> withLatestFrom(p<?>[] pVarArr, o<? super Object[], R> oVar) {
        b.e(pVarArr, "others is null");
        b.e(oVar, "combiner is null");
        return fo.a.o(new h4(this, pVarArr, oVar));
    }

    public final <TOpening, TClosing> k<List<T>> buffer(p<? extends TOpening> pVar, o<? super TOpening, ? extends p<? extends TClosing>> oVar) {
        return (k<List<T>>) buffer(pVar, oVar, ArrayListSupplier.asCallable());
    }

    public final <U, R> k<R> flatMap(o<? super T, ? extends p<? extends U>> oVar, zn.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10) {
        return flatMap(oVar, cVar, z10, i10, bufferSize());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> k<U> buffer(p<? extends TOpening> pVar, o<? super TOpening, ? extends p<? extends TClosing>> oVar, Callable<U> callable) {
        b.e(pVar, "openingIndicator is null");
        b.e(oVar, "closingIndicator is null");
        b.e(callable, "bufferSupplier is null");
        return fo.a.o(new m(this, pVar, oVar, callable));
    }

    public final <U, R> k<R> flatMap(o<? super T, ? extends p<? extends U>> oVar, zn.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10, int i11) {
        b.e(oVar, "mapper is null");
        b.e(cVar, "combiner is null");
        return flatMap(m1.b(oVar, cVar), z10, i10, i11);
    }

    public final <R> k<R> replay(o<? super k<T>, ? extends p<R>> oVar, s sVar) {
        b.e(oVar, "selector is null");
        b.e(sVar, "scheduler is null");
        return p2.i(m1.g(this), m1.k(oVar, sVar));
    }

    public final <R> k<R> withLatestFrom(Iterable<? extends p<?>> iterable, o<? super Object[], R> oVar) {
        b.e(iterable, "others is null");
        b.e(oVar, "combiner is null");
        return fo.a.o(new h4(this, iterable, oVar));
    }

    public static <T1, T2, T3, T4, T5, R> k<R> combineLatest(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, zn.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        return combineLatest(bo.a.y(jVar), bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5);
    }

    public final <B> k<k<T>> window(p<B> pVar) {
        return window(pVar, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, zn.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        return zipArray(bo.a.y(jVar), false, bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5);
    }

    public final <U, R> k<R> flatMap(o<? super T, ? extends p<? extends U>> oVar, zn.c<? super T, ? super U, ? extends R> cVar, int i10) {
        return flatMap(oVar, cVar, false, i10, bufferSize());
    }

    public final <B> k<k<T>> window(p<B> pVar, int i10) {
        b.e(pVar, "boundary is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new c4(this, pVar, i10));
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        b.e(t12, "item3 is null");
        b.e(t13, "item4 is null");
        b.e(t14, "item5 is null");
        b.e(t15, "item6 is null");
        b.e(t16, "item7 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16);
    }

    public final <B> k<List<T>> buffer(p<B> pVar) {
        return (k<List<T>>) buffer(pVar, ArrayListSupplier.asCallable());
    }

    public final <B> k<List<T>> buffer(p<B> pVar, int i10) {
        b.f(i10, "initialCapacity");
        return (k<List<T>>) buffer(pVar, bo.a.e(i10));
    }

    public final p001do.a<T> replay(int i10) {
        b.f(i10, "bufferSize");
        return p2.d(this, i10);
    }

    public final <U, V> k<k<T>> window(p<U> pVar, o<? super U, ? extends p<V>> oVar) {
        return window(pVar, oVar, bufferSize());
    }

    public final <B, U extends Collection<? super T>> k<U> buffer(p<B> pVar, Callable<U> callable) {
        b.e(pVar, "boundary is null");
        b.e(callable, "bufferSupplier is null");
        return fo.a.o(new io.reactivex.internal.operators.observable.o(this, pVar, callable));
    }

    public final <U, V> k<k<T>> window(p<U> pVar, o<? super U, ? extends p<V>> oVar, int i10) {
        b.e(pVar, "openingIndicator is null");
        b.e(oVar, "closingIndicator is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new d4(this, pVar, oVar, i10));
    }

    public static <T1, T2, T3, T4, T5, T6, R> k<R> combineLatest(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, p<? extends T6> pVar6, zn.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        b.e(pVar6, "source6 is null");
        return combineLatest(bo.a.z(kVar), bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5, pVar6);
    }

    public final p001do.a<T> replay(int i10, long j10, TimeUnit timeUnit) {
        return replay(i10, j10, timeUnit, go.a.a());
    }

    public static <T1, T2, T3, T4, T5, T6, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, p<? extends T6> pVar6, zn.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        b.e(pVar6, "source6 is null");
        return zipArray(bo.a.z(kVar), false, bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5, pVar6);
    }

    public final p001do.a<T> replay(int i10, long j10, TimeUnit timeUnit, s sVar) {
        b.f(i10, "bufferSize");
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return p2.f(this, j10, timeUnit, sVar, i10);
    }

    public final <B> k<List<T>> buffer(Callable<? extends p<B>> callable) {
        return (k<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    public final <B, U extends Collection<? super T>> k<U> buffer(Callable<? extends p<B>> callable, Callable<U> callable2) {
        b.e(callable, "boundarySupplier is null");
        b.e(callable2, "bufferSupplier is null");
        return fo.a.o(new n(this, callable, callable2));
    }

    public final <B> k<k<T>> window(Callable<? extends p<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        b.e(t12, "item3 is null");
        b.e(t13, "item4 is null");
        b.e(t14, "item5 is null");
        b.e(t15, "item6 is null");
        b.e(t16, "item7 is null");
        b.e(t17, "item8 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17);
    }

    public final <B> k<k<T>> window(Callable<? extends p<B>> callable, int i10) {
        b.e(callable, "boundary is null");
        b.f(i10, "bufferSize");
        return fo.a.o(new e4(this, callable, i10));
    }

    public final p001do.a<T> replay(int i10, s sVar) {
        b.f(i10, "bufferSize");
        return p2.j(replay(i10), sVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> k<R> combineLatest(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, p<? extends T6> pVar6, p<? extends T7> pVar7, zn.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        b.e(pVar6, "source6 is null");
        b.e(pVar7, "source7 is null");
        return combineLatest(bo.a.A(lVar), bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7);
    }

    public final p001do.a<T> replay(long j10, TimeUnit timeUnit) {
        return replay(j10, timeUnit, go.a.a());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, p<? extends T6> pVar6, p<? extends T7> pVar7, zn.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        b.e(pVar6, "source6 is null");
        b.e(pVar7, "source7 is null");
        return zipArray(bo.a.A(lVar), false, bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7);
    }

    public final p001do.a<T> replay(long j10, TimeUnit timeUnit, s sVar) {
        b.e(timeUnit, "unit is null");
        b.e(sVar, "scheduler is null");
        return p2.e(this, j10, timeUnit, sVar);
    }

    public final p001do.a<T> replay(s sVar) {
        b.e(sVar, "scheduler is null");
        return p2.j(replay(), sVar);
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        b.e(t12, "item3 is null");
        b.e(t13, "item4 is null");
        b.e(t14, "item5 is null");
        b.e(t15, "item6 is null");
        b.e(t16, "item7 is null");
        b.e(t17, "item8 is null");
        b.e(t18, "item9 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17, t18);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> k<R> combineLatest(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, p<? extends T6> pVar6, p<? extends T7> pVar7, p<? extends T8> pVar8, zn.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        b.e(pVar6, "source6 is null");
        b.e(pVar7, "source7 is null");
        b.e(pVar8, "source8 is null");
        return combineLatest(bo.a.B(mVar), bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, p<? extends T6> pVar6, p<? extends T7> pVar7, p<? extends T8> pVar8, zn.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        b.e(pVar6, "source6 is null");
        b.e(pVar7, "source7 is null");
        b.e(pVar8, "source8 is null");
        return zipArray(bo.a.B(mVar), false, bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8);
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
        b.e(t10, "item1 is null");
        b.e(t11, "item2 is null");
        b.e(t12, "item3 is null");
        b.e(t13, "item4 is null");
        b.e(t14, "item5 is null");
        b.e(t15, "item6 is null");
        b.e(t16, "item7 is null");
        b.e(t17, "item8 is null");
        b.e(t18, "item9 is null");
        b.e(t19, "item10 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> k<R> combineLatest(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, p<? extends T6> pVar6, p<? extends T7> pVar7, p<? extends T8> pVar8, p<? extends T9> pVar9, zn.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        b.e(pVar6, "source6 is null");
        b.e(pVar7, "source7 is null");
        b.e(pVar8, "source8 is null");
        b.e(pVar9, "source9 is null");
        return combineLatest(bo.a.C(nVar), bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8, pVar9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> k<R> zip(p<? extends T1> pVar, p<? extends T2> pVar2, p<? extends T3> pVar3, p<? extends T4> pVar4, p<? extends T5> pVar5, p<? extends T6> pVar6, p<? extends T7> pVar7, p<? extends T8> pVar8, p<? extends T9> pVar9, zn.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        b.e(pVar3, "source3 is null");
        b.e(pVar4, "source4 is null");
        b.e(pVar5, "source5 is null");
        b.e(pVar6, "source6 is null");
        b.e(pVar7, "source7 is null");
        b.e(pVar8, "source8 is null");
        b.e(pVar9, "source9 is null");
        return zipArray(bo.a.C(nVar), false, bufferSize(), pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8, pVar9);
    }
}
