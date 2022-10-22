package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_RUN_MULTIPLIER = 13;
    static final int MAX_TABLE_SIZE = 1073741824;
    static final int SPLITERATOR_CHARACTERISTICS = 1297;
    private transient ImmutableList<E> asList;

    /* loaded from: classes.dex */
    public static class a<E> extends ImmutableCollection.a<E> {

        /* renamed from: a  reason: collision with root package name */
        private e<E> f11794a;

        /* renamed from: b  reason: collision with root package name */
        boolean f11795b;

        public a() {
            this(4);
        }

        /* renamed from: e */
        public a<E> a(E e10) {
            p.o(e10);
            j();
            this.f11794a = this.f11794a.a(e10);
            return this;
        }

        public a<E> f(Iterator<? extends E> it) {
            super.c(it);
            return this;
        }

        public ImmutableSet<E> g() {
            this.f11795b = true;
            e<E> g10 = this.f11794a.g();
            this.f11794a = g10;
            return g10.c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a<E> h(a<E> aVar) {
            j();
            this.f11794a = this.f11794a.d(aVar.f11794a);
            return this;
        }

        void i() {
            this.f11794a = this.f11794a.e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void j() {
            if (this.f11795b) {
                i();
                this.f11795b = false;
            }
        }

        a(int i10) {
            this.f11794a = new d(i10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(boolean z10) {
            this.f11794a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b<E> extends ImmutableSet<E> {

        /* loaded from: classes.dex */
        class a extends z3<E> {
            a() {
            }

            @Override // java.util.List
            public E get(int i10) {
                return (E) b.this.get(i10);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: m */
            public b<E> l() {
                return b.this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int a(Object[] objArr, int i10) {
            return asList().a(objArr, i10);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            p.o(consumer);
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                consumer.accept(get(i10));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract E get(int i10);

        @Override // com.google.common.collect.ImmutableSet
        ImmutableList<E> m() {
            return new a();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return s2.c(size(), ImmutableSet.SPLITERATOR_CHARACTERISTICS, new IntFunction() { // from class: com.google.common.collect.t4
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    return ImmutableSet.b.this.get(i10);
                }
            });
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public p8<E> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes.dex */
    private static final class c<E> extends e<E> {

        /* renamed from: c  reason: collision with root package name */
        private final Set<Object> f11796c = l7.d(this.f11802b);

        c(e<E> eVar) {
            super(eVar);
            for (int i10 = 0; i10 < this.f11802b; i10++) {
                this.f11796c.add(this.f11801a[i10]);
            }
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> a(E e10) {
            p.o(e10);
            if (this.f11796c.add(e10)) {
                b(e10);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.e
        ImmutableSet<E> c() {
            int i10 = this.f11802b;
            if (i10 == 0) {
                return ImmutableSet.of();
            }
            if (i10 != 1) {
                return new o5(this.f11796c, ImmutableList.i(this.f11801a, this.f11802b));
            }
            return ImmutableSet.of((Object) this.f11801a[0]);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> e() {
            return new c(this);
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i10) {
        p2.b(i10, "expectedSize");
        return new a<>(i10);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.g()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return l((EnumSet) collection);
        }
        Object[] array = collection.toArray();
        if (collection instanceof Set) {
            return j(array.length, array.length, array);
        }
        return k(array.length, array);
    }

    static int i(int i10) {
        int max = Math.max(i10, 2);
        boolean z10 = true;
        if (max < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= MAX_TABLE_SIZE) {
            z10 = false;
        }
        p.e(z10, "collection too large");
        return MAX_TABLE_SIZE;
    }

    private static <E> ImmutableSet<E> j(int i10, int i11, Object... objArr) {
        if (i10 == 0) {
            return of();
        }
        int i12 = 0;
        if (i10 == 1) {
            return of(objArr[0]);
        }
        d dVar = new d(i11);
        while (i12 < i10) {
            i12++;
            dVar = dVar.a(p.o(objArr[i12]));
        }
        return dVar.g().c();
    }

    private static <E> ImmutableSet<E> k(int i10, Object... objArr) {
        return j(i10, Math.max(4, com.google.common.math.c.e(i10, RoundingMode.CEILING)), objArr);
    }

    private static ImmutableSet l(EnumSet enumSet) {
        return d4.r(EnumSet.copyOf(enumSet));
    }

    static boolean n(Object[] objArr) {
        int p10 = p(objArr.length);
        int i10 = 0;
        while (i10 < objArr.length && objArr[i10] != null) {
            i10++;
            if (i10 > p10) {
                return true;
            }
        }
        int length = objArr.length - 1;
        while (length > i10 && objArr[length] != null) {
            if (((objArr.length - 1) - length) + i10 > p10) {
                return true;
            }
            length--;
        }
        int i11 = p10 / 2;
        int i12 = i10 + 1;
        while (true) {
            int i13 = i12 + i11;
            if (i13 > length) {
                return false;
            }
            for (int i14 = 0; i14 < i11; i14++) {
                if (objArr[i12 + i14] == null) {
                    break;
                }
            }
            return true;
            i12 = i13;
        }
    }

    public static <E> ImmutableSet<E> of() {
        return e7.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(int i10) {
        return com.google.common.math.c.d(i10, RoundingMode.UNNECESSARY) * 13;
    }

    static Object[] q(int i10, Object[] objArr, int i11) {
        int i12;
        Object[] objArr2 = new Object[i10];
        int i13 = i10 - 1;
        for (int i14 = 0; i14 < i11; i14++) {
            Object obj = objArr[i14];
            int c10 = y3.c(obj.hashCode());
            while (true) {
                i12 = c10 & i13;
                if (objArr2[i12] == null) {
                    break;
                }
                c10++;
            }
            objArr2[i12] = obj;
        }
        return objArr2;
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return o2.V();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> m10 = m();
        this.asList = m10;
        return m10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSet) || !o() || !((ImmutableSet) obj).o() || hashCode() == obj.hashCode()) {
            return l7.a(this, obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return l7.b(this);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract p8<E> iterator();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<E> m() {
        return new y6(this, toArray());
    }

    boolean o() {
        return false;
    }

    public static <E> ImmutableSet<E> of(E e10) {
        return new o7(e10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e<E> {

        /* renamed from: a  reason: collision with root package name */
        E[] f11801a;

        /* renamed from: b  reason: collision with root package name */
        int f11802b;

        e(int i10) {
            this.f11801a = (E[]) new Object[i10];
            this.f11802b = 0;
        }

        private void f(int i10) {
            E[] eArr = this.f11801a;
            if (i10 > eArr.length) {
                this.f11801a = (E[]) Arrays.copyOf(this.f11801a, ImmutableCollection.a.d(eArr.length, i10));
            }
        }

        abstract e<E> a(E e10);

        final void b(E e10) {
            f(this.f11802b + 1);
            E[] eArr = this.f11801a;
            int i10 = this.f11802b;
            this.f11802b = i10 + 1;
            eArr[i10] = e10;
        }

        abstract ImmutableSet<E> c();

        final e<E> d(e<E> eVar) {
            e<E> eVar2 = this;
            for (int i10 = 0; i10 < eVar.f11802b; i10++) {
                eVar2 = eVar2.a(eVar.f11801a[i10]);
            }
            return eVar2;
        }

        abstract e<E> e();

        e<E> g() {
            return this;
        }

        e(e<E> eVar) {
            E[] eArr = eVar.f11801a;
            this.f11801a = (E[]) Arrays.copyOf(eArr, eArr.length);
            this.f11802b = eVar.f11802b;
        }
    }

    public static <E> ImmutableSet<E> of(E e10, E e11) {
        return j(2, 2, e10, e11);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12) {
        return j(3, 3, e10, e11, e12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d<E> extends e<E> {

        /* renamed from: c  reason: collision with root package name */
        private Object[] f11797c;

        /* renamed from: d  reason: collision with root package name */
        private int f11798d;

        /* renamed from: e  reason: collision with root package name */
        private int f11799e;

        /* renamed from: f  reason: collision with root package name */
        private int f11800f;

        d(int i10) {
            super(i10);
            int i11 = ImmutableSet.i(i10);
            this.f11797c = new Object[i11];
            this.f11798d = ImmutableSet.p(i11);
            this.f11799e = (int) (i11 * ImmutableSet.DESIRED_LOAD_FACTOR);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> a(E e10) {
            p.o(e10);
            int hashCode = e10.hashCode();
            int c10 = y3.c(hashCode);
            int length = this.f11797c.length - 1;
            for (int i10 = c10; i10 - c10 < this.f11798d; i10++) {
                int i11 = i10 & length;
                Object obj = this.f11797c[i11];
                if (obj == null) {
                    b(e10);
                    this.f11797c[i11] = e10;
                    this.f11800f += hashCode;
                    h(this.f11802b);
                    return this;
                } else if (obj.equals(e10)) {
                    return this;
                }
            }
            return new c(this).a(e10);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        ImmutableSet<E> c() {
            int i10 = this.f11802b;
            if (i10 == 0) {
                return ImmutableSet.of();
            }
            if (i10 == 1) {
                return ImmutableSet.of((Object) this.f11801a[0]);
            }
            Object[] objArr = this.f11801a;
            if (i10 != objArr.length) {
                objArr = Arrays.copyOf(objArr, i10);
            }
            int i11 = this.f11800f;
            Object[] objArr2 = this.f11797c;
            return new e7(objArr, i11, objArr2, objArr2.length - 1);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> e() {
            return new d(this);
        }

        @Override // com.google.common.collect.ImmutableSet.e
        e<E> g() {
            int i10 = ImmutableSet.i(this.f11802b);
            if (i10 * 2 < this.f11797c.length) {
                this.f11797c = ImmutableSet.q(i10, this.f11801a, this.f11802b);
                this.f11798d = ImmutableSet.p(i10);
                this.f11799e = (int) (i10 * ImmutableSet.DESIRED_LOAD_FACTOR);
            }
            return ImmutableSet.n(this.f11797c) ? new c(this) : this;
        }

        void h(int i10) {
            if (i10 > this.f11799e) {
                Object[] objArr = this.f11797c;
                if (objArr.length < ImmutableSet.MAX_TABLE_SIZE) {
                    int length = objArr.length * 2;
                    this.f11797c = ImmutableSet.q(length, this.f11801a, this.f11802b);
                    this.f11798d = ImmutableSet.p(length);
                    this.f11799e = (int) (length * ImmutableSet.DESIRED_LOAD_FACTOR);
                }
            }
        }

        d(d<E> dVar) {
            super(dVar);
            Object[] objArr = dVar.f11797c;
            this.f11797c = Arrays.copyOf(objArr, objArr.length);
            this.f11798d = dVar.f11798d;
            this.f11799e = dVar.f11799e;
            this.f11800f = dVar.f11800f;
        }
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13) {
        return j(4, 4, e10, e11, e12, e13);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13, E e14) {
        return j(5, 5, e10, e11, e12, e13, e14);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        p.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return j(length, length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().a(next).f(it).g();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return k(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
