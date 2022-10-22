package com.google.common.collect;

import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.collect.w5;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
/* loaded from: classes.dex */
public final class HashBiMap<K, V> extends w5.i<K, V> implements e0<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 0;
    private transient b<K, V> firstInKeyInsertionOrder;
    private transient b<K, V>[] hashTableKToV;
    private transient b<K, V>[] hashTableVToK;
    private transient e0<V, K> inverse;
    private transient b<K, V> lastInKeyInsertionOrder;
    private transient int mask;
    private transient int modCount;
    private transient int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends HashBiMap<K, V>.d<Map.Entry<K, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.collect.HashBiMap$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0139a extends n<K, V> {

            /* renamed from: a  reason: collision with root package name */
            b<K, V> f11748a;

            C0139a(b<K, V> bVar) {
                this.f11748a = bVar;
            }

            @Override // com.google.common.collect.n, java.util.Map.Entry
            public K getKey() {
                return this.f11748a.key;
            }

            @Override // com.google.common.collect.n, java.util.Map.Entry
            public V getValue() {
                return this.f11748a.value;
            }

            @Override // com.google.common.collect.n, java.util.Map.Entry
            public V setValue(V v10) {
                V v11 = this.f11748a.value;
                int d10 = y3.d(v10);
                if (d10 == this.f11748a.valueHash && m.a(v10, v11)) {
                    return v10;
                }
                p.j(HashBiMap.this.w(v10, d10) == null, "value already present: %s", v10);
                HashBiMap.this.p(this.f11748a);
                b<K, V> bVar = this.f11748a;
                b<K, V> bVar2 = new b<>(bVar.key, bVar.keyHash, v10, d10);
                HashBiMap.this.r(bVar2, this.f11748a);
                b<K, V> bVar3 = this.f11748a;
                bVar3.prevInKeyInsertionOrder = null;
                bVar3.nextInKeyInsertionOrder = null;
                a aVar = a.this;
                aVar.f11756c = HashBiMap.this.modCount;
                a aVar2 = a.this;
                if (aVar2.f11755b == this.f11748a) {
                    aVar2.f11755b = bVar2;
                }
                this.f11748a = bVar2;
                return v11;
            }
        }

        a() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<K, V> a(b<K, V> bVar) {
            return new C0139a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b<K, V> extends b4<K, V> {
        final int keyHash;
        b<K, V> nextInKToVBucket;
        b<K, V> nextInKeyInsertionOrder;
        b<K, V> nextInVToKBucket;
        b<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        b(K k10, int i10, V v10, int i11) {
            super(k10, v10);
            this.keyHash = i10;
            this.valueHash = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c extends w5.i<V, K> implements e0<V, K>, Serializable {

        /* loaded from: classes.dex */
        class a extends HashBiMap<K, V>.d<Map.Entry<V, K>> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.google.common.collect.HashBiMap$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0140a extends n<V, K> {

                /* renamed from: a  reason: collision with root package name */
                b<K, V> f11751a;

                C0140a(b<K, V> bVar) {
                    this.f11751a = bVar;
                }

                @Override // com.google.common.collect.n, java.util.Map.Entry
                public V getKey() {
                    return this.f11751a.value;
                }

                @Override // com.google.common.collect.n, java.util.Map.Entry
                public K getValue() {
                    return this.f11751a.key;
                }

                @Override // com.google.common.collect.n, java.util.Map.Entry
                public K setValue(K k10) {
                    K k11 = this.f11751a.key;
                    int d10 = y3.d(k10);
                    if (d10 == this.f11751a.keyHash && m.a(k10, k11)) {
                        return k10;
                    }
                    p.j(HashBiMap.this.v(k10, d10) == null, "value already present: %s", k10);
                    HashBiMap.this.p(this.f11751a);
                    b<K, V> bVar = this.f11751a;
                    b<K, V> bVar2 = new b<>(k10, d10, bVar.value, bVar.valueHash);
                    this.f11751a = bVar2;
                    HashBiMap.this.r(bVar2, null);
                    a aVar = a.this;
                    aVar.f11756c = HashBiMap.this.modCount;
                    return k11;
                }
            }

            a() {
                super();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: b */
            public Map.Entry<V, K> a(b<K, V> bVar) {
                return new C0140a(bVar);
            }
        }

        /* loaded from: classes.dex */
        private final class b extends w5.j<V, K> {

            /* loaded from: classes.dex */
            class a extends HashBiMap<K, V>.d<V> {
                a(b bVar) {
                    super();
                }

                @Override // com.google.common.collect.HashBiMap.d
                V a(b<K, V> bVar) {
                    return bVar.value;
                }
            }

            b() {
                super(c.this);
            }

            @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new a(this);
            }

            @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                b w10 = HashBiMap.this.w(obj, y3.d(obj));
                if (w10 == null) {
                    return false;
                }
                HashBiMap.this.p(w10);
                return true;
            }
        }

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w5.i
        public Iterator<Map.Entry<V, K>> a() {
            return new a();
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public void clear() {
            h().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return h().containsValue(obj);
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super V, ? super K> biConsumer) {
            p.o(biConsumer);
            HashBiMap.this.forEach(new BiConsumer() { // from class: com.google.common.collect.w3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    biConsumer.accept(obj2, obj);
                }
            });
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return (K) w5.i(HashBiMap.this.w(obj, y3.d(obj)));
        }

        e0<K, V> h() {
            return HashBiMap.this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V v10, K k10) {
            return (K) HashBiMap.this.t(v10, k10, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            b w10 = HashBiMap.this.w(obj, y3.d(obj));
            if (w10 == null) {
                return null;
            }
            HashBiMap.this.p(w10);
            w10.prevInKeyInsertionOrder = null;
            w10.nextInKeyInsertionOrder = null;
            return w10.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void replaceAll(BiFunction<? super V, ? super K, ? extends K> biFunction) {
            p.o(biFunction);
            clear();
            for (b<K, V> bVar = HashBiMap.this.firstInKeyInsertionOrder; bVar != null; bVar = bVar.nextInKeyInsertionOrder) {
                Object obj = (V) bVar.value;
                put(obj, biFunction.apply(obj, (K) bVar.key));
            }
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.this.size;
        }

        /* synthetic */ c(HashBiMap hashBiMap, a aVar) {
            this();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return h().keySet();
        }
    }

    /* loaded from: classes.dex */
    abstract class d<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        b<K, V> f11754a;

        /* renamed from: b  reason: collision with root package name */
        b<K, V> f11755b = null;

        /* renamed from: c  reason: collision with root package name */
        int f11756c;

        /* renamed from: d  reason: collision with root package name */
        int f11757d;

        d() {
            this.f11754a = HashBiMap.this.firstInKeyInsertionOrder;
            this.f11756c = HashBiMap.this.modCount;
            this.f11757d = HashBiMap.this.size();
        }

        abstract T a(b<K, V> bVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (HashBiMap.this.modCount == this.f11756c) {
                return this.f11754a != null && this.f11757d > 0;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                b<K, V> bVar = this.f11754a;
                this.f11754a = bVar.nextInKeyInsertionOrder;
                this.f11755b = bVar;
                this.f11757d--;
                return a(bVar);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (HashBiMap.this.modCount == this.f11756c) {
                p2.e(this.f11755b != null);
                HashBiMap.this.p(this.f11755b);
                this.f11756c = HashBiMap.this.modCount;
                this.f11755b = null;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    /* loaded from: classes.dex */
    private final class e extends w5.j<K, V> {

        /* loaded from: classes.dex */
        class a extends HashBiMap<K, V>.d<K> {
            a(e eVar) {
                super();
            }

            @Override // com.google.common.collect.HashBiMap.d
            K a(b<K, V> bVar) {
                return bVar.key;
            }
        }

        e() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            b v10 = HashBiMap.this.v(obj, y3.d(obj));
            if (v10 == null) {
                return false;
            }
            HashBiMap.this.p(v10);
            v10.prevInKeyInsertionOrder = null;
            v10.nextInKeyInsertionOrder = null;
            return true;
        }
    }

    private HashBiMap(int i10) {
        q(i10);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private b<K, V>[] o(int i10) {
        return new b[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(b<K, V> bVar) {
        b<K, V> bVar2;
        int i10 = bVar.keyHash & this.mask;
        b<K, V> bVar3 = null;
        b<K, V> bVar4 = null;
        for (b<K, V> bVar5 = this.hashTableKToV[i10]; bVar5 != bVar; bVar5 = bVar5.nextInKToVBucket) {
            bVar4 = bVar5;
        }
        if (bVar4 == null) {
            this.hashTableKToV[i10] = bVar.nextInKToVBucket;
        } else {
            bVar4.nextInKToVBucket = bVar.nextInKToVBucket;
        }
        int i11 = bVar.valueHash & this.mask;
        b<K, V> bVar6 = this.hashTableVToK[i11];
        while (true) {
            bVar2 = bVar3;
            bVar3 = bVar6;
            if (bVar3 == bVar) {
                break;
            }
            bVar6 = bVar3.nextInVToKBucket;
        }
        if (bVar2 == null) {
            this.hashTableVToK[i11] = bVar.nextInVToKBucket;
        } else {
            bVar2.nextInVToKBucket = bVar.nextInVToKBucket;
        }
        b<K, V> bVar7 = bVar.prevInKeyInsertionOrder;
        if (bVar7 == null) {
            this.firstInKeyInsertionOrder = bVar.nextInKeyInsertionOrder;
        } else {
            bVar7.nextInKeyInsertionOrder = bVar.nextInKeyInsertionOrder;
        }
        b<K, V> bVar8 = bVar.nextInKeyInsertionOrder;
        if (bVar8 == null) {
            this.lastInKeyInsertionOrder = bVar7;
        } else {
            bVar8.prevInKeyInsertionOrder = bVar7;
        }
        this.size--;
        this.modCount++;
    }

    private void q(int i10) {
        p2.b(i10, "expectedSize");
        int a10 = y3.a(i10, LOAD_FACTOR);
        this.hashTableKToV = o(a10);
        this.hashTableVToK = o(a10);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = a10 - 1;
        this.modCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(b<K, V> bVar, b<K, V> bVar2) {
        int i10 = bVar.keyHash;
        int i11 = this.mask;
        int i12 = i10 & i11;
        b<K, V>[] bVarArr = this.hashTableKToV;
        bVar.nextInKToVBucket = bVarArr[i12];
        bVarArr[i12] = bVar;
        int i13 = bVar.valueHash & i11;
        b<K, V>[] bVarArr2 = this.hashTableVToK;
        bVar.nextInVToKBucket = bVarArr2[i13];
        bVarArr2[i13] = bVar;
        if (bVar2 == null) {
            b<K, V> bVar3 = this.lastInKeyInsertionOrder;
            bVar.prevInKeyInsertionOrder = bVar3;
            bVar.nextInKeyInsertionOrder = null;
            if (bVar3 == null) {
                this.firstInKeyInsertionOrder = bVar;
            } else {
                bVar3.nextInKeyInsertionOrder = bVar;
            }
            this.lastInKeyInsertionOrder = bVar;
        } else {
            b<K, V> bVar4 = bVar2.prevInKeyInsertionOrder;
            bVar.prevInKeyInsertionOrder = bVar4;
            if (bVar4 == null) {
                this.firstInKeyInsertionOrder = bVar;
            } else {
                bVar4.nextInKeyInsertionOrder = bVar;
            }
            b<K, V> bVar5 = bVar2.nextInKeyInsertionOrder;
            bVar.nextInKeyInsertionOrder = bVar5;
            if (bVar5 == null) {
                this.lastInKeyInsertionOrder = bVar;
            } else {
                bVar5.prevInKeyInsertionOrder = bVar;
            }
        }
        this.size++;
        this.modCount++;
    }

    private V s(K k10, V v10, boolean z10) {
        int d10 = y3.d(k10);
        int d11 = y3.d(v10);
        b<K, V> v11 = v(k10, d10);
        if (v11 != null && d11 == v11.valueHash && m.a(v10, v11.value)) {
            return v10;
        }
        b<K, V> w10 = w(v10, d11);
        if (w10 != null) {
            if (z10) {
                p(w10);
            } else {
                String valueOf = String.valueOf(v10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
                sb2.append("value already present: ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        b<K, V> bVar = new b<>(k10, d10, v10, d11);
        if (v11 != null) {
            p(v11);
            r(bVar, v11);
            v11.prevInKeyInsertionOrder = null;
            v11.nextInKeyInsertionOrder = null;
            return v11.value;
        }
        r(bVar, null);
        u();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K t(V v10, K k10, boolean z10) {
        int d10 = y3.d(v10);
        int d11 = y3.d(k10);
        b<K, V> w10 = w(v10, d10);
        b<K, V> v11 = v(k10, d11);
        if (w10 != null && d11 == w10.keyHash && m.a(k10, w10.key)) {
            return k10;
        }
        if (v11 == null || z10) {
            if (w10 != null) {
                p(w10);
            }
            if (v11 != null) {
                p(v11);
            }
            r(new b<>(k10, d11, v10, d10), v11);
            if (v11 != null) {
                v11.prevInKeyInsertionOrder = null;
                v11.nextInKeyInsertionOrder = null;
            }
            if (w10 != null) {
                w10.prevInKeyInsertionOrder = null;
                w10.nextInKeyInsertionOrder = null;
            }
            u();
            return (K) w5.i(w10);
        }
        String valueOf = String.valueOf(k10);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
        sb2.append("key already present: ");
        sb2.append(valueOf);
        throw new IllegalArgumentException(sb2.toString());
    }

    private void u() {
        b<K, V>[] bVarArr = this.hashTableKToV;
        if (y3.b(this.size, bVarArr.length, LOAD_FACTOR)) {
            int length = bVarArr.length * 2;
            this.hashTableKToV = o(length);
            this.hashTableVToK = o(length);
            this.mask = length - 1;
            this.size = 0;
            for (b<K, V> bVar = this.firstInKeyInsertionOrder; bVar != null; bVar = bVar.nextInKeyInsertionOrder) {
                r(bVar, bVar);
            }
            this.modCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b<K, V> v(Object obj, int i10) {
        for (b<K, V> bVar = this.hashTableKToV[this.mask & i10]; bVar != null; bVar = bVar.nextInKToVBucket) {
            if (i10 == bVar.keyHash && m.a(obj, bVar.key)) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b<K, V> w(Object obj, int i10) {
        for (b<K, V> bVar = this.hashTableVToK[this.mask & i10]; bVar != null; bVar = bVar.nextInVToKBucket) {
            if (i10 == bVar.valueHash && m.a(obj, bVar.value)) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w5.i
    public Iterator<Map.Entry<K, V>> a() {
        return new a();
    }

    @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, (Object) null);
        Arrays.fill(this.hashTableVToK, (Object) null);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return v(obj, y3.d(obj)) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return w(obj, y3.d(obj)) != null;
    }

    @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        p.o(biConsumer);
        for (b<K, V> bVar = this.firstInKeyInsertionOrder; bVar != null; bVar = bVar.nextInKeyInsertionOrder) {
            biConsumer.accept((K) bVar.key, (V) bVar.value);
        }
    }

    public V forcePut(K k10, V v10) {
        return s(k10, v10, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        return (V) w5.w(v(obj, y3.d(obj)));
    }

    public e0<V, K> inverse() {
        e0<V, K> e0Var = this.inverse;
        if (e0Var != null) {
            return e0Var;
        }
        c cVar = new c(this, null);
        this.inverse = cVar;
        return cVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new e();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        return s(k10, v10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        b<K, V> v10 = v(obj, y3.d(obj));
        if (v10 == null) {
            return null;
        }
        p(v10);
        v10.prevInKeyInsertionOrder = null;
        v10.nextInKeyInsertionOrder = null;
        return v10.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        p.o(biFunction);
        clear();
        for (b<K, V> bVar = this.firstInKeyInsertionOrder; bVar != null; bVar = bVar.nextInKeyInsertionOrder) {
            K k10 = bVar.key;
            put(k10, biFunction.apply(k10, (V) bVar.value));
        }
    }

    @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i10) {
        return new HashBiMap<>(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        return inverse().keySet();
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
