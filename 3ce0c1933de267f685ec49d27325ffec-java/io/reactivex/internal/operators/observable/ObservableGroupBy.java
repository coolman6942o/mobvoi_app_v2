package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p;
import io.reactivex.r;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* loaded from: classes3.dex */
public final class ObservableGroupBy<T, K, V> extends io.reactivex.internal.operators.observable.a<T, p001do.b<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends K> f28419b;

    /* renamed from: c  reason: collision with root package name */
    final o<? super T, ? extends V> f28420c;

    /* renamed from: d  reason: collision with root package name */
    final int f28421d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f28422e;

    /* loaded from: classes3.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements r<T>, xn.b {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final boolean delayError;
        final r<? super p001do.b<K, V>> downstream;
        final o<? super T, ? extends K> keySelector;
        xn.b upstream;
        final o<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final Map<Object, a<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(r<? super p001do.b<K, V>> rVar, o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2, int i10, boolean z10) {
            this.downstream = rVar;
            this.keySelector = oVar;
            this.valueSelector = oVar2;
            this.bufferSize = i10;
            this.delayError = z10;
            lazySet(1);
        }

        public void cancel(K k10) {
            if (k10 == null) {
                k10 = (K) NULL_KEY;
            }
            this.groups.remove(k10);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // xn.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            ArrayList<a> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (a aVar : arrayList) {
                aVar.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            ArrayList<a> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (a aVar : arrayList) {
                aVar.onError(th2);
            }
            this.downstream.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.r
        public void onNext(T t10) {
            try {
                K apply = this.keySelector.apply(t10);
                Object obj = apply != null ? apply : NULL_KEY;
                a<K, V> aVar = this.groups.get(obj);
                if (aVar == null) {
                    if (!this.cancelled.get()) {
                        aVar = a.b(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, aVar);
                        getAndIncrement();
                        this.downstream.onNext(aVar);
                    } else {
                        return;
                    }
                }
                try {
                    aVar.onNext(bo.b.e(this.valueSelector.apply(t10), "The value supplied is null"));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.upstream.dispose();
                    onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.upstream.dispose();
                onError(th3);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a<K, T> extends p001do.b<K, T> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, K> f28423b;

        protected a(K k10, b<T, K> bVar) {
            super(k10);
            this.f28423b = bVar;
        }

        public static <T, K> a<K, T> b(K k10, int i10, GroupByObserver<?, K, T> groupByObserver, boolean z10) {
            return new a<>(k10, new b(i10, groupByObserver, k10, z10));
        }

        public void onComplete() {
            this.f28423b.c();
        }

        public void onError(Throwable th2) {
            this.f28423b.d(th2);
        }

        public void onNext(T t10) {
            this.f28423b.g(t10);
        }

        @Override // io.reactivex.k
        protected void subscribeActual(r<? super T> rVar) {
            this.f28423b.subscribe(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b<T, K> extends AtomicInteger implements xn.b, p<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final GroupByObserver<?, K, T> parent;
        final io.reactivex.internal.queue.b<T> queue;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicReference<r<? super T>> actual = new AtomicReference<>();

        b(int i10, GroupByObserver<?, K, T> groupByObserver, K k10, boolean z10) {
            this.queue = new io.reactivex.internal.queue.b<>(i10);
            this.parent = groupByObserver;
            this.key = k10;
            this.delayError = z10;
        }

        boolean a(boolean z10, boolean z11, r<? super T> rVar, boolean z12) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!z12) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        this.actual.lazySet(null);
                        rVar.onError(th2);
                        return true;
                    } else if (!z11) {
                        return false;
                    } else {
                        this.actual.lazySet(null);
                        rVar.onComplete();
                        return true;
                    }
                } else if (!z11) {
                    return false;
                } else {
                    Throwable th3 = this.error;
                    this.actual.lazySet(null);
                    if (th3 != null) {
                        rVar.onError(th3);
                    } else {
                        rVar.onComplete();
                    }
                    return true;
                }
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.queue.b<T> bVar = this.queue;
                boolean z10 = this.delayError;
                r<? super T> rVar = this.actual.get();
                int i10 = 1;
                while (true) {
                    if (rVar != null) {
                        while (true) {
                            boolean z11 = this.done;
                            Object obj = (T) bVar.poll();
                            boolean z12 = obj == null;
                            if (!a(z11, z12, rVar, z10)) {
                                if (z12) {
                                    break;
                                }
                                rVar.onNext(obj);
                            } else {
                                return;
                            }
                        }
                    }
                    i10 = addAndGet(-i10);
                    if (i10 != 0) {
                        if (rVar == null) {
                            rVar = this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void c() {
            this.done = true;
            b();
        }

        public void d(Throwable th2) {
            this.error = th2;
            this.done = true;
            b();
        }

        @Override // xn.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        public void g(T t10) {
            this.queue.offer(t10);
            b();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.p
        public void subscribe(r<? super T> rVar) {
            if (this.once.compareAndSet(false, true)) {
                rVar.onSubscribe(this);
                this.actual.lazySet(rVar);
                if (this.cancelled.get()) {
                    this.actual.lazySet(null);
                } else {
                    b();
                }
            } else {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), rVar);
            }
        }
    }

    public ObservableGroupBy(p<T> pVar, o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2, int i10, boolean z10) {
        super(pVar);
        this.f28419b = oVar;
        this.f28420c = oVar2;
        this.f28421d = i10;
        this.f28422e = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super p001do.b<K, V>> rVar) {
        this.f28426a.subscribe(new GroupByObserver(rVar, this.f28419b, this.f28420c, this.f28421d, this.f28422e));
    }
}
