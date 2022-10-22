package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.c8;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableTable.java */
/* loaded from: classes.dex */
public abstract class h7<R, C, V> extends ImmutableTable<R, C, V> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegularImmutableTable.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<c8.a<R, C, V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator f12011a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Comparator f12012b;

        a(Comparator comparator, Comparator comparator2) {
            this.f12011a = comparator;
            this.f12012b = comparator2;
        }

        /* renamed from: a */
        public int compare(c8.a<R, C, V> aVar, c8.a<R, C, V> aVar2) {
            Comparator comparator = this.f12011a;
            int compare = comparator == null ? 0 : comparator.compare(aVar.b(), aVar2.b());
            if (compare != 0) {
                return compare;
            }
            Comparator comparator2 = this.f12012b;
            if (comparator2 == null) {
                return 0;
            }
            return comparator2.compare(aVar.a(), aVar2.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RegularImmutableTable.java */
    /* loaded from: classes.dex */
    public final class b extends f5<c8.a<R, C, V>> {
        private b() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof c8.a)) {
                return false;
            }
            c8.a aVar = (c8.a) obj;
            Object obj2 = h7.this.get(aVar.b(), aVar.a());
            return obj2 != null && obj2.equals(aVar.getValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: r */
        public c8.a<R, C, V> get(int i10) {
            return h7.this.r(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h7.this.size();
        }

        /* synthetic */ b(h7 h7Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RegularImmutableTable.java */
    /* loaded from: classes.dex */
    public final class c extends ImmutableList<V> {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        @Override // java.util.List
        public V get(int i10) {
            return (V) h7.this.s(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return h7.this.size();
        }

        /* synthetic */ c(h7 h7Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R, C, V> h7<R, C, V> o(List<c8.a<R, C, V>> list, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        p.o(list);
        if (!(comparator == null && comparator2 == null)) {
            Collections.sort(list, new a(comparator, comparator2));
        }
        return p(list, comparator, comparator2);
    }

    private static <R, C, V> h7<R, C, V> p(Iterable<c8.a<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        ImmutableSet immutableSet;
        ImmutableSet immutableSet2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList copyOf = ImmutableList.copyOf(iterable);
        for (c8.a<R, C, V> aVar : iterable) {
            linkedHashSet.add(aVar.b());
            linkedHashSet2.add(aVar.a());
        }
        if (comparator == null) {
            immutableSet = ImmutableSet.copyOf((Collection) linkedHashSet);
        } else {
            immutableSet = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet));
        }
        if (comparator2 == null) {
            immutableSet2 = ImmutableSet.copyOf((Collection) linkedHashSet2);
        } else {
            immutableSet2 = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
        }
        return q(copyOf, immutableSet, immutableSet2);
    }

    static <R, C, V> h7<R, C, V> q(ImmutableList<c8.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        if (immutableList.size() > (immutableSet.size() * immutableSet2.size()) / 2) {
            return new d3(immutableList, immutableSet, immutableSet2);
        }
        return new v7(immutableList, immutableSet, immutableSet2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: l */
    public final ImmutableSet<c8.a<R, C, V>> c() {
        return isEmpty() ? ImmutableSet.of() : new b(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: m */
    public final ImmutableCollection<V> d() {
        return isEmpty() ? ImmutableList.of() : new c(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(R r10, C c10, V v10, V v11) {
        p.l(v10 == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r10, c10, v11, v10);
    }

    abstract c8.a<R, C, V> r(int i10);

    abstract V s(int i10);
}
