package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.s2;
import com.realsil.sdk.dfu.DfuException;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectSpliterators.java */
/* loaded from: classes.dex */
public final class s2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectSpliterators.java */
    /* loaded from: classes.dex */
    public class a implements Spliterator<OutElementT> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Spliterator f12165a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function f12166b;

        a(Spliterator spliterator, Function function) {
            this.f12165a = spliterator;
            this.f12166b = function;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Consumer consumer, Function function, Object obj) {
            consumer.accept(function.apply(obj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(Consumer consumer, Function function, Object obj) {
            consumer.accept(function.apply(obj));
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f12165a.characteristics() & (-262);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f12165a.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super OutElementT> consumer) {
            Spliterator spliterator = this.f12165a;
            final Function function = this.f12166b;
            spliterator.forEachRemaining(new Consumer() { // from class: com.google.common.collect.q2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    s2.a.c(consumer, function, obj);
                }
            });
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super OutElementT> consumer) {
            Spliterator spliterator = this.f12165a;
            final Function function = this.f12166b;
            return spliterator.tryAdvance(new Consumer() { // from class: com.google.common.collect.r2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    s2.a.d(consumer, function, obj);
                }
            });
        }

        @Override // java.util.Spliterator
        public Spliterator<OutElementT> trySplit() {
            Spliterator trySplit = this.f12165a.trySplit();
            if (trySplit != null) {
                return s2.e(trySplit, this.f12166b);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectSpliterators.java */
    /* loaded from: classes.dex */
    public class b implements Spliterator<T>, Consumer<T> {

        /* renamed from: a  reason: collision with root package name */
        T f12167a = null;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Spliterator f12168b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Predicate f12169c;

        b(Spliterator spliterator, Predicate predicate) {
            this.f12168b = spliterator;
            this.f12169c = predicate;
        }

        @Override // java.util.function.Consumer
        public void accept(T t10) {
            this.f12167a = t10;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f12168b.characteristics() & DfuException.ERROR_READ_REMOTE_MAC_ADDR;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f12168b.estimateSize() / 2;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            return this.f12168b.getComparator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            while (this.f12168b.tryAdvance(this)) {
                try {
                    if (this.f12169c.test(this.f12167a)) {
                        consumer.accept(this.f12167a);
                        return true;
                    }
                } finally {
                    this.f12167a = null;
                }
            }
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator trySplit = this.f12168b.trySplit();
            if (trySplit == null) {
                return null;
            }
            return s2.a(trySplit, this.f12169c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectSpliterators.java */
    /* loaded from: classes.dex */
    public class c implements Spliterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Spliterator.OfInt f12170a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IntFunction f12171b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f12172c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Comparator f12173d;

        c(Spliterator.OfInt ofInt, IntFunction intFunction, int i10, Comparator comparator) {
            this.f12171b = intFunction;
            this.f12172c = i10;
            this.f12173d = comparator;
            this.f12170a = ofInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Consumer consumer, IntFunction intFunction, int i10) {
            consumer.accept(intFunction.apply(i10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(Consumer consumer, IntFunction intFunction, int i10) {
            consumer.accept(intFunction.apply(i10));
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f12172c | 16464;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f12170a.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.f12170a;
            final IntFunction intFunction = this.f12171b;
            ofInt.forEachRemaining(new IntConsumer() { // from class: com.google.common.collect.u2
                @Override // java.util.function.IntConsumer
                public final void accept(int i10) {
                    s2.c.c(consumer, intFunction, i10);
                }
            });
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return this.f12173d;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.f12170a;
            final IntFunction intFunction = this.f12171b;
            return ofInt.tryAdvance(new IntConsumer() { // from class: com.google.common.collect.t2
                @Override // java.util.function.IntConsumer
                public final void accept(int i10) {
                    s2.c.d(consumer, intFunction, i10);
                }
            });
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator.OfInt trySplit = this.f12170a.trySplit();
            if (trySplit == null) {
                return null;
            }
            return new c(trySplit, this.f12171b, this.f12172c, this.f12173d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectSpliterators.java */
    /* loaded from: classes.dex */
    public static abstract class d<InElementT, OutElementT, OutSpliteratorT extends Spliterator<OutElementT>> implements Spliterator<OutElementT> {

        /* renamed from: a  reason: collision with root package name */
        OutSpliteratorT f12174a;

        /* renamed from: b  reason: collision with root package name */
        final Spliterator<InElementT> f12175b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super InElementT, OutSpliteratorT> f12176c;

        /* renamed from: d  reason: collision with root package name */
        final a<InElementT, OutSpliteratorT> f12177d;

        /* renamed from: e  reason: collision with root package name */
        int f12178e;

        /* renamed from: f  reason: collision with root package name */
        long f12179f;

        /* compiled from: CollectSpliterators.java */
        @FunctionalInterface
        /* loaded from: classes.dex */
        interface a<InElementT, OutSpliteratorT extends Spliterator<?>> {
            OutSpliteratorT a(OutSpliteratorT outspliteratort, Spliterator<InElementT> spliterator, Function<? super InElementT, OutSpliteratorT> function, int i10, long j10);
        }

        d(OutSpliteratorT outspliteratort, Spliterator<InElementT> spliterator, Function<? super InElementT, OutSpliteratorT> function, a<InElementT, OutSpliteratorT> aVar, int i10, long j10) {
            this.f12174a = outspliteratort;
            this.f12175b = spliterator;
            this.f12176c = function;
            this.f12177d = aVar;
            this.f12178e = i10;
            this.f12179f = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Consumer consumer, Object obj) {
            OutSpliteratorT apply = this.f12176c.apply(obj);
            if (apply != null) {
                apply.forEachRemaining(consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Object obj) {
            this.f12174a = this.f12176c.apply(obj);
        }

        @Override // java.util.Spliterator
        public final int characteristics() {
            return this.f12178e;
        }

        @Override // java.util.Spliterator
        public final long estimateSize() {
            OutSpliteratorT outspliteratort = this.f12174a;
            if (outspliteratort != null) {
                this.f12179f = Math.max(this.f12179f, outspliteratort.estimateSize());
            }
            return Math.max(this.f12179f, 0L);
        }

        @Override // java.util.Spliterator
        public final void forEachRemaining(final Consumer<? super OutElementT> consumer) {
            OutSpliteratorT outspliteratort = this.f12174a;
            if (outspliteratort != null) {
                outspliteratort.forEachRemaining(consumer);
                this.f12174a = null;
            }
            this.f12175b.forEachRemaining(new Consumer() { // from class: com.google.common.collect.w2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    s2.d.this.c(consumer, obj);
                }
            });
            this.f12179f = 0L;
        }

        @Override // java.util.Spliterator
        public final boolean tryAdvance(Consumer<? super OutElementT> consumer) {
            do {
                OutSpliteratorT outspliteratort = this.f12174a;
                if (outspliteratort == null || !outspliteratort.tryAdvance(consumer)) {
                    this.f12174a = null;
                } else {
                    long j10 = this.f12179f;
                    if (j10 == Long.MAX_VALUE) {
                        return true;
                    }
                    this.f12179f = j10 - 1;
                    return true;
                }
            } while (this.f12175b.tryAdvance(new Consumer() { // from class: com.google.common.collect.v2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    s2.d.this.d(obj);
                }
            }));
            return false;
        }

        @Override // java.util.Spliterator
        public final OutSpliteratorT trySplit() {
            Spliterator<InElementT> trySplit = this.f12175b.trySplit();
            if (trySplit != null) {
                int i10 = this.f12178e & (-65);
                long estimateSize = estimateSize();
                if (estimateSize < Long.MAX_VALUE) {
                    estimateSize /= 2;
                    this.f12179f -= estimateSize;
                    this.f12178e = i10;
                }
                OutSpliteratorT a10 = this.f12177d.a(this.f12174a, trySplit, this.f12176c, i10, estimateSize);
                this.f12174a = null;
                return a10;
            }
            OutSpliteratorT outspliteratort = this.f12174a;
            if (outspliteratort == null) {
                return null;
            }
            this.f12174a = null;
            return outspliteratort;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectSpliterators.java */
    /* loaded from: classes.dex */
    public static final class e<InElementT, OutElementT> extends d<InElementT, OutElementT, Spliterator<OutElementT>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Spliterator<OutElementT> spliterator, Spliterator<InElementT> spliterator2, Function<? super InElementT, Spliterator<OutElementT>> function, int i10, long j10) {
            super(spliterator, spliterator2, function, x2.f12255a, i10, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Spliterator<T> a(Spliterator<T> spliterator, Predicate<? super T> predicate) {
        p.o(spliterator);
        p.o(predicate);
        return new b(spliterator, predicate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <InElementT, OutElementT> Spliterator<OutElementT> b(Spliterator<InElementT> spliterator, Function<? super InElementT, Spliterator<OutElementT>> function, int i10, long j10) {
        boolean z10 = true;
        p.e((i10 & 16384) == 0, "flatMap does not support SUBSIZED characteristic");
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        p.e(z10, "flatMap does not support SORTED characteristic");
        p.o(spliterator);
        p.o(function);
        return new e(null, spliterator, function, i10, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Spliterator<T> c(int i10, int i11, IntFunction<T> intFunction) {
        return d(i10, i11, intFunction, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Spliterator<T> d(int i10, int i11, IntFunction<T> intFunction, Comparator<? super T> comparator) {
        if (comparator != null) {
            p.d((i11 & 4) != 0);
        }
        return new c(IntStream.range(0, i10).spliterator(), intFunction, i11, comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <InElementT, OutElementT> Spliterator<OutElementT> e(Spliterator<InElementT> spliterator, Function<? super InElementT, ? extends OutElementT> function) {
        p.o(spliterator);
        p.o(function);
        return new a(spliterator, function);
    }
}
