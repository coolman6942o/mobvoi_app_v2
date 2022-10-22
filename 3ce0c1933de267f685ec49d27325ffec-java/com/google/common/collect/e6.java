package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.p;
import com.google.common.base.v;
import com.google.common.collect.e6;
import com.google.common.collect.j;
import com.google.common.collect.j6;
import com.google.common.collect.m6;
import com.google.common.collect.w5;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
/* compiled from: Multimaps.java */
/* loaded from: classes.dex */
public final class e6 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Multimaps.java */
    /* loaded from: classes.dex */
    public static final class a<K, V> extends w5.n<K, Collection<V>> {

        /* renamed from: d  reason: collision with root package name */
        private final b6<K, V> f11969d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Multimaps.java */
        /* renamed from: com.google.common.collect.e6$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0144a extends w5.h<K, Collection<V>> {

            /* compiled from: Multimaps.java */
            /* renamed from: com.google.common.collect.e6$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0145a implements h<K, Collection<V>> {
                C0145a() {
                }

                /* renamed from: a */
                public Collection<V> apply(K k10) {
                    return a.this.f11969d.get(k10);
                }
            }

            C0144a() {
            }

            @Override // com.google.common.collect.w5.h
            Map<K, Collection<V>> e() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return w5.a(a.this.f11969d.keySet(), new C0145a());
            }

            @Override // com.google.common.collect.w5.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                a.this.h(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(b6<K, V> b6Var) {
            this.f11969d = (b6) p.o(b6Var);
        }

        @Override // com.google.common.collect.w5.n
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new C0144a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f11969d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f11969d.containsKey(obj);
        }

        /* renamed from: f */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.f11969d.get(obj);
            }
            return null;
        }

        /* renamed from: g */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.f11969d.removeAll(obj);
            }
            return null;
        }

        void h(Object obj) {
            this.f11969d.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f11969d.isEmpty();
        }

        @Override // com.google.common.collect.w5.n, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f11969d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f11969d.keySet().size();
        }
    }

    /* compiled from: Multimaps.java */
    /* loaded from: classes.dex */
    private static class b<K, V> extends com.google.common.collect.d<K, V> {
        private static final long serialVersionUID = 0;
        transient v<? extends List<V>> factory;

        b(Map<K, Collection<V>> map, v<? extends List<V>> vVar) {
            super(map);
            this.factory = (v) p.o(vVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d
        /* renamed from: M */
        public List<V> x() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.j, com.google.common.collect.o
        Map<K, Collection<V>> a() {
            return z();
        }

        @Override // com.google.common.collect.j, com.google.common.collect.o
        Set<K> c() {
            return A();
        }
    }

    /* compiled from: Multimaps.java */
    /* loaded from: classes.dex */
    private static class c<K, V> extends t<K, V> {
        private static final long serialVersionUID = 0;
        transient v<? extends Set<V>> factory;

        c(Map<K, Collection<V>> map, v<? extends Set<V>> vVar) {
            super(map);
            this.factory = (v) p.o(vVar);
        }

        @Override // com.google.common.collect.t, com.google.common.collect.j
        <E> Collection<E> J(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return l7.i((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            return Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.t, com.google.common.collect.j
        Collection<V> K(K k10, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new j.m(k10, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new j.o(k10, (SortedSet) collection, null);
            }
            return new j.n(k10, (Set) collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t
        /* renamed from: M */
        public Set<V> x() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.j, com.google.common.collect.o
        Map<K, Collection<V>> a() {
            return z();
        }

        @Override // com.google.common.collect.j, com.google.common.collect.o
        Set<K> c() {
            return A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Multimaps.java */
    /* loaded from: classes.dex */
    public static abstract class d<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        abstract b6<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* compiled from: Multimaps.java */
    /* loaded from: classes.dex */
    static class e<K, V> extends p<K> {

        /* renamed from: a  reason: collision with root package name */
        final b6<K, V> f11972a;

        /* compiled from: Multimaps.java */
        /* loaded from: classes.dex */
        class a extends n8<Map.Entry<K, Collection<V>>, j6.a<K>> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Multimaps.java */
            /* renamed from: com.google.common.collect.e6$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0146a extends m6.b<K> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Map.Entry f11973a;

                C0146a(a aVar, Map.Entry entry) {
                    this.f11973a = entry;
                }

                @Override // com.google.common.collect.j6.a
                public K a() {
                    return (K) this.f11973a.getKey();
                }

                @Override // com.google.common.collect.j6.a
                public int getCount() {
                    return ((Collection) this.f11973a.getValue()).size();
                }
            }

            a(e eVar, Iterator it) {
                super(it);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: b */
            public j6.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0146a(this, entry);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(b6<K, V> b6Var) {
            this.f11972a = b6Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void h(Consumer consumer, Map.Entry entry) {
            consumer.accept(entry.getKey());
        }

        @Override // com.google.common.collect.p
        int b() {
            return this.f11972a.asMap().size();
        }

        @Override // com.google.common.collect.p
        Iterator<K> c() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f11972a.clear();
        }

        @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
        public boolean contains(Object obj) {
            return this.f11972a.containsKey(obj);
        }

        @Override // com.google.common.collect.j6
        public int count(Object obj) {
            Collection collection = (Collection) w5.p(this.f11972a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.p
        public Iterator<j6.a<K>> d() {
            return new a(this, this.f11972a.asMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.p, com.google.common.collect.j6
        public Set<K> elementSet() {
            return this.f11972a.keySet();
        }

        @Override // com.google.common.collect.p, java.lang.Iterable
        public void forEach(final Consumer<? super K> consumer) {
            p.o(consumer);
            this.f11972a.entries().forEach(new Consumer() { // from class: com.google.common.collect.f6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    e6.e.h(consumer, (Map.Entry) obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return w5.h(this.f11972a.entries().iterator());
        }

        @Override // com.google.common.collect.p, com.google.common.collect.j6
        public int remove(Object obj, int i10) {
            p2.b(i10, "occurrences");
            if (i10 == 0) {
                return count(obj);
            }
            Collection collection = (Collection) w5.p(this.f11972a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i10 >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i11 = 0; i11 < i10; i11++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
        public int size() {
            return this.f11972a.size();
        }

        @Override // com.google.common.collect.p, java.util.Collection, java.lang.Iterable
        public Spliterator<K> spliterator() {
            return s2.e(this.f11972a.entries().spliterator(), f4.f11982a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(b6<?, ?> b6Var, Object obj) {
        if (obj == b6Var) {
            return true;
        }
        if (obj instanceof b6) {
            return b6Var.asMap().equals(((b6) obj).asMap());
        }
        return false;
    }

    public static <K, V> q5<K, V> b(Map<K, Collection<V>> map, v<? extends List<V>> vVar) {
        return new b(map, vVar);
    }

    public static <K, V> k7<K, V> c(Map<K, Collection<V>> map, v<? extends Set<V>> vVar) {
        return new c(map, vVar);
    }
}
