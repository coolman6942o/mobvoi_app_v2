package com.google.common.collect;

import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.collect.l7;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
/* loaded from: classes.dex */
public final class LinkedHashMultimap<K, V> extends p5<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;
    private transient b<K, V> multimapHeaderEntry;
    transient int valueSetCapacity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        b<K, V> f11813a;

        /* renamed from: b  reason: collision with root package name */
        b<K, V> f11814b;

        a() {
            this.f11813a = LinkedHashMultimap.this.multimapHeaderEntry.successorInMultimap;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                b<K, V> bVar = this.f11813a;
                this.f11814b = bVar;
                this.f11813a = bVar.successorInMultimap;
                return bVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11813a != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f11814b != null);
            LinkedHashMultimap.this.remove(this.f11814b.getKey(), this.f11814b.getValue());
            this.f11814b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b<K, V> extends b4<K, V> implements d<K, V> {
        b<K, V> nextInValueBucket;
        b<K, V> predecessorInMultimap;
        d<K, V> predecessorInValueSet;
        final int smearedValueHash;
        b<K, V> successorInMultimap;
        d<K, V> successorInValueSet;

        b(K k10, V v10, int i10, b<K, V> bVar) {
            super(k10, v10);
            this.smearedValueHash = i10;
            this.nextInValueBucket = bVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void a(d<K, V> dVar) {
            this.successorInValueSet = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> b() {
            return this.predecessorInValueSet;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> c() {
            return this.successorInValueSet;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void d(d<K, V> dVar) {
            this.predecessorInValueSet = dVar;
        }

        public b<K, V> g() {
            return this.predecessorInMultimap;
        }

        public b<K, V> h() {
            return this.successorInMultimap;
        }

        boolean i(Object obj, int i10) {
            return this.smearedValueHash == i10 && m.a(getValue(), obj);
        }

        public void j(b<K, V> bVar) {
            this.predecessorInMultimap = bVar;
        }

        public void k(b<K, V> bVar) {
            this.successorInMultimap = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c extends l7.a<V> implements d<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final K f11816a;

        /* renamed from: b  reason: collision with root package name */
        b<K, V>[] f11817b;

        /* renamed from: c  reason: collision with root package name */
        private int f11818c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f11819d = 0;

        /* renamed from: e  reason: collision with root package name */
        private d<K, V> f11820e = this;

        /* renamed from: f  reason: collision with root package name */
        private d<K, V> f11821f = this;

        /* loaded from: classes.dex */
        class a implements Iterator<V> {

            /* renamed from: a  reason: collision with root package name */
            d<K, V> f11823a;

            /* renamed from: b  reason: collision with root package name */
            b<K, V> f11824b;

            /* renamed from: c  reason: collision with root package name */
            int f11825c;

            a() {
                this.f11823a = c.this.f11820e;
                this.f11825c = c.this.f11819d;
            }

            private void a() {
                if (c.this.f11819d != this.f11825c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f11823a != c.this;
            }

            @Override // java.util.Iterator
            public V next() {
                if (hasNext()) {
                    b<K, V> bVar = (b) this.f11823a;
                    V value = bVar.getValue();
                    this.f11824b = bVar;
                    this.f11823a = bVar.c();
                    return value;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                p2.e(this.f11824b != null);
                c.this.remove(this.f11824b.getValue());
                this.f11825c = c.this.f11819d;
                this.f11824b = null;
            }
        }

        c(K k10, int i10) {
            this.f11816a = k10;
            this.f11817b = new b[y3.a(i10, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)];
        }

        private int g() {
            return this.f11817b.length - 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void h() {
            if (y3.b(this.f11818c, this.f11817b.length, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)) {
                int length = this.f11817b.length * 2;
                b<K, V>[] bVarArr = new b[length];
                this.f11817b = bVarArr;
                int i10 = length - 1;
                for (d dVar = (d<K, V>) this.f11820e; dVar != this; dVar = (d<K, V>) dVar.c()) {
                    b<K, V> bVar = (b) dVar;
                    int i11 = bVar.smearedValueHash & i10;
                    bVar.nextInValueBucket = bVarArr[i11];
                    bVarArr[i11] = bVar;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void a(d<K, V> dVar) {
            this.f11820e = dVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v10) {
            int d10 = y3.d(v10);
            int g10 = g() & d10;
            b<K, V> bVar = this.f11817b[g10];
            for (b<K, V> bVar2 = bVar; bVar2 != null; bVar2 = bVar2.nextInValueBucket) {
                if (bVar2.i(v10, d10)) {
                    return false;
                }
            }
            b<K, V> bVar3 = new b<>(this.f11816a, v10, d10, bVar);
            LinkedHashMultimap.W(this.f11821f, bVar3);
            LinkedHashMultimap.W(bVar3, this);
            LinkedHashMultimap.V(LinkedHashMultimap.this.multimapHeaderEntry.g(), bVar3);
            LinkedHashMultimap.V(bVar3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.f11817b[g10] = bVar3;
            this.f11818c++;
            this.f11819d++;
            h();
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> b() {
            return this.f11821f;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> c() {
            return this.f11820e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f11817b, (Object) null);
            this.f11818c = 0;
            for (d<K, V> dVar = this.f11820e; dVar != this; dVar = dVar.c()) {
                LinkedHashMultimap.T((b) dVar);
            }
            LinkedHashMultimap.W(this, this);
            this.f11819d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int d10 = y3.d(obj);
            for (b<K, V> bVar = this.f11817b[g() & d10]; bVar != null; bVar = bVar.nextInValueBucket) {
                if (bVar.i(obj, d10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void d(d<K, V> dVar) {
            this.f11821f = dVar;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> consumer) {
            p.o(consumer);
            for (d<K, V> dVar = this.f11820e; dVar != this; dVar = dVar.c()) {
                consumer.accept((V) ((b) dVar).getValue());
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d10 = y3.d(obj);
            int g10 = g() & d10;
            b<K, V> bVar = null;
            for (b<K, V> bVar2 = this.f11817b[g10]; bVar2 != null; bVar2 = bVar2.nextInValueBucket) {
                if (bVar2.i(obj, d10)) {
                    if (bVar == null) {
                        this.f11817b[g10] = bVar2.nextInValueBucket;
                    } else {
                        bVar.nextInValueBucket = bVar2.nextInValueBucket;
                    }
                    LinkedHashMultimap.U(bVar2);
                    LinkedHashMultimap.T(bVar2);
                    this.f11818c--;
                    this.f11819d++;
                    return true;
                }
                bVar = bVar2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f11818c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d<K, V> {
        void a(d<K, V> dVar);

        d<K, V> b();

        d<K, V> c();

        void d(d<K, V> dVar);
    }

    private LinkedHashMultimap(int i10, int i11) {
        super(s6.e(i10));
        this.valueSetCapacity = 2;
        p2.b(i11, "expectedValuesPerKey");
        this.valueSetCapacity = i11;
        b<K, V> bVar = new b<>(null, null, 0, null);
        this.multimapHeaderEntry = bVar;
        V(bVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void T(b<K, V> bVar) {
        V(bVar.g(), bVar.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void U(d<K, V> dVar) {
        W(dVar.b(), dVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void V(b<K, V> bVar, b<K, V> bVar2) {
        bVar.k(bVar2);
        bVar2.j(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void W(d<K, V> dVar, d<K, V> dVar2) {
        dVar.a(dVar2);
        dVar2.d(dVar);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.t
    /* renamed from: M */
    public Set<V> x() {
        return s6.f(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public void clear() {
        super.clear();
        b<K, V> bVar = this.multimapHeaderEntry;
        V(bVar, bVar);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    Iterator<Map.Entry<K, V>> h() {
        return new a();
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    Spliterator<Map.Entry<K, V>> i() {
        return Spliterators.spliterator(entries(), 17);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    Iterator<V> j() {
        return w5.v(h());
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    Spliterator<V> k() {
        return s2.e(i(), l4.f12095a);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ j6 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean putAll(b6 b6Var) {
        return super.putAll(b6Var);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    public Collection<V> values() {
        return super.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.j
    public Collection<V> y(K k10) {
        return new c(k10, this.valueSetCapacity);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i10, int i11) {
        return new LinkedHashMultimap<>(w5.b(i10), w5.b(i11));
    }

    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.o, com.google.common.collect.b6
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.o
    public Set<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        return super.replaceValues((LinkedHashMultimap<K, V>) k10, (Iterable) iterable);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(b6<? extends K, ? extends V> b6Var) {
        LinkedHashMultimap<K, V> create = create(b6Var.keySet().size(), 2);
        create.putAll(b6Var);
        return create;
    }
}
