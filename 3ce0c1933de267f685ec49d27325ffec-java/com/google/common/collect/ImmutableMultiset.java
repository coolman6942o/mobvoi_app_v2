package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.j6;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public abstract class ImmutableMultiset<E> extends s4<E> implements j6<E> {
    private transient ImmutableList<E> asList;
    private transient ImmutableSet<j6.a<E>> entrySet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends p8<E> {

        /* renamed from: a  reason: collision with root package name */
        int f11782a;

        /* renamed from: b  reason: collision with root package name */
        E f11783b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Iterator f11784c;

        a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.f11784c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11782a > 0 || this.f11784c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f11782a <= 0) {
                j6.a aVar = (j6.a) this.f11784c.next();
                this.f11783b = (E) aVar.a();
                this.f11782a = aVar.getCount();
            }
            this.f11782a--;
            return this.f11783b;
        }
    }

    /* loaded from: classes.dex */
    public static class b<E> extends ImmutableCollection.a<E> {

        /* renamed from: a  reason: collision with root package name */
        final j6<E> f11785a;

        public b() {
            this(LinkedHashMultiset.create());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: e */
        public b<E> a(E e10) {
            this.f11785a.add(p.o(e10));
            return this;
        }

        public b<E> f(E... eArr) {
            super.b(eArr);
            return this;
        }

        public b<E> g(Iterator<? extends E> it) {
            super.c(it);
            return this;
        }

        public ImmutableMultiset<E> h() {
            return ImmutableMultiset.copyOf(this.f11785a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(j6<E> j6Var) {
            this.f11785a = j6Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c<E> extends ImmutableSet.b<E> {
        private final j6<E> delegate;
        private final List<j6.a<E>> entries;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(List<j6.a<E>> list, j6<E> j6Var) {
            this.entries = list;
            this.delegate = j6Var;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.delegate.contains(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet.b
        public E get(int i10) {
            return this.entries.get(i10).a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.entries.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class d extends f5<j6.a<E>> {
        private static final long serialVersionUID = 0;

        private d() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof j6.a)) {
                return false;
            }
            j6.a aVar = (j6.a) obj;
            return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.a()) == aVar.getCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return ImmutableMultiset.this.g();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: r */
        public j6.a<E> get(int i10) {
            return ImmutableMultiset.this.l(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        /* synthetic */ d(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return i(eArr);
    }

    private static <E> ImmutableMultiset<E> i(E... eArr) {
        LinkedHashMultiset create = LinkedHashMultiset.create();
        Collections.addAll(create, eArr);
        return j(create.entrySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMultiset<E> j(Collection<? extends j6.a<? extends E>> collection) {
        if (collection.isEmpty()) {
            return of();
        }
        return d7.n(collection);
    }

    private ImmutableSet<j6.a<E>> k() {
        return isEmpty() ? ImmutableSet.of() : new d(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int m(Object obj) {
        return 1;
    }

    public static <E> ImmutableMultiset<E> of() {
        return (ImmutableMultiset<E>) d7.EMPTY;
    }

    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        return o2.S(Function.identity(), r4.f12159a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i10) {
        p8<j6.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            j6.a<E> next = it.next();
            Arrays.fill(objArr, i10, next.getCount() + i10, next.a());
            i10 += next.getCount();
        }
        return i10;
    }

    @Override // com.google.common.collect.j6
    @Deprecated
    public final int add(E e10, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList = super.asList();
        this.asList = asList;
        return asList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public abstract /* synthetic */ int count(Object obj);

    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, com.google.common.collect.j6
    public boolean equals(Object obj) {
        return m6.f(this, obj);
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer<? super E> consumer) {
        i6.a(this, consumer);
    }

    @Override // com.google.common.collect.j6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        i6.b(this, objIntConsumer);
    }

    @Override // java.util.Collection, com.google.common.collect.j6
    public int hashCode() {
        return l7.b(entrySet());
    }

    abstract j6.a<E> l(int i10);

    @Override // com.google.common.collect.j6
    @Deprecated
    public final int remove(Object obj, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.j6
    @Deprecated
    public final int setCount(E e10, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        j6 j6Var;
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.g()) {
                return immutableMultiset;
            }
        }
        if (iterable instanceof j6) {
            j6Var = m6.d(iterable);
        } else {
            j6Var = LinkedHashMultiset.create(iterable);
        }
        return j(j6Var.entrySet());
    }

    public static <E> ImmutableMultiset<E> of(E e10) {
        return i(e10);
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> function, ToIntFunction<? super T> toIntFunction) {
        return o2.S(function, toIntFunction);
    }

    @Override // com.google.common.collect.j6
    public ImmutableSet<j6.a<E>> entrySet() {
        ImmutableSet<j6.a<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<j6.a<E>> k10 = k();
        this.entrySet = k10;
        return k10;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.j6
    @Deprecated
    public final boolean setCount(E e10, int i10, int i11) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11) {
        return i(e10, e11);
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11, E e12) {
        return i(e10, e11, e12);
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11, E e12, E e13) {
        return i(e10, e11, e12, e13);
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11, E e12, E e13, E e14) {
        return i(e10, e11, e12, e13, e14);
    }

    public static <E> ImmutableMultiset<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        return new b().a(e10).a(e11).a(e12).a(e13).a(e14).a(e15).f(eArr).h();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        LinkedHashMultiset create = LinkedHashMultiset.create();
        j5.a(create, it);
        return j(create.entrySet());
    }
}
