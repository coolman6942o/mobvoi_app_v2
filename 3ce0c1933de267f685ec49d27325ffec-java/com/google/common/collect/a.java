package com.google.common.collect;

import com.google.common.base.m;
import com.google.common.base.p;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractBiMap.java */
/* loaded from: classes.dex */
public abstract class a<K, V> extends o3<K, V> implements e0<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    transient a<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractBiMap.java */
    /* renamed from: com.google.common.collect.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0143a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        Map.Entry<K, V> f11917a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterator f11918b;

        C0143a(Iterator it) {
            this.f11918b = it;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f11918b.next();
            this.f11917a = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11918b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f11917a != null);
            V value = this.f11917a.getValue();
            this.f11918b.remove();
            a.this.q(value);
            this.f11917a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes.dex */
    public class b extends p3<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final Map.Entry<K, V> f11920a;

        b(Map.Entry<K, V> entry) {
            this.f11920a = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.p3
        /* renamed from: b */
        public Map.Entry<K, V> a() {
            return this.f11920a;
        }

        @Override // com.google.common.collect.p3, java.util.Map.Entry
        public V setValue(V v10) {
            a.this.l(v10);
            p.v(a.this.entrySet().contains(this), "entry no longer in map");
            if (m.a(v10, getValue())) {
                return v10;
            }
            p.j(!a.this.containsValue(v10), "value already present: %s", v10);
            V value = this.f11920a.setValue(v10);
            p.v(m.a(v10, a.this.get(getKey())), "entry no longer in map");
            a.this.s(getKey(), true, value, v10);
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes.dex */
    public class c extends t3<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        final Set<Map.Entry<K, V>> f11922a;

        private c() {
            this.f11922a = a.this.delegate.entrySet();
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public void clear() {
            a.this.clear();
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return w5.c(b(), obj);
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return g(collection);
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return a.this.m();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t3
        /* renamed from: l */
        public Set<Map.Entry<K, V>> b() {
            return this.f11922a;
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f11922a.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((a) a.this.inverse).delegate.remove(entry.getValue());
            this.f11922a.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return m(collection);
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return h(collection);
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return i();
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j(tArr);
        }

        /* synthetic */ c(a aVar, C0143a aVar2) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes.dex */
    public static class d<K, V> extends a<K, V> {
        private static final long serialVersionUID = 0;

        d(Map<K, V> map, a<V, K> aVar) {
            super(map, aVar, null);
        }

        @Override // com.google.common.collect.a, com.google.common.collect.o3, com.google.common.collect.r3
        protected /* bridge */ /* synthetic */ Object a() {
            return a.super.a();
        }

        @Override // com.google.common.collect.a
        K k(K k10) {
            return this.inverse.l(k10);
        }

        @Override // com.google.common.collect.a
        V l(V v10) {
            return this.inverse.k(v10);
        }

        @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return a.super.values();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes.dex */
    public class e extends t3<K> {
        private e() {
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public void clear() {
            a.this.clear();
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return w5.h(a.this.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t3
        /* renamed from: l */
        public Set<K> b() {
            return a.this.delegate.keySet();
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            a.this.p(obj);
            return true;
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return m(collection);
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return h(collection);
        }

        /* synthetic */ e(a aVar, C0143a aVar2) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBiMap.java */
    /* loaded from: classes.dex */
    public class f extends t3<V> {

        /* renamed from: a  reason: collision with root package name */
        final Set<V> f11925a;

        private f() {
            this.f11925a = a.this.inverse.keySet();
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return w5.v(a.this.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t3
        /* renamed from: l */
        public Set<V> b() {
            return this.f11925a;
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return i();
        }

        @Override // com.google.common.collect.r3
        public String toString() {
            return k();
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j(tArr);
        }

        /* synthetic */ f(a aVar, C0143a aVar2) {
            this();
        }
    }

    /* synthetic */ a(Map map, a aVar, C0143a aVar2) {
        this(map, aVar);
    }

    private V o(K k10, V v10, boolean z10) {
        k(k10);
        l(v10);
        boolean containsKey = containsKey(k10);
        if (containsKey && m.a(v10, get(k10))) {
            return v10;
        }
        if (z10) {
            inverse().remove(v10);
        } else {
            p.j(!containsValue(v10), "value already present: %s", v10);
        }
        V put = this.delegate.put(k10, v10);
        s(k10, containsKey, put, v10);
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V p(Object obj) {
        V remove = this.delegate.remove(obj);
        q(remove);
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(V v10) {
        this.inverse.delegate.remove(v10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(K k10, boolean z10, V v10, V v11) {
        if (z10) {
            q(v10);
        }
        this.inverse.delegate.put(v11, k10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.o3
    /* renamed from: b */
    public Map<K, V> a() {
        return this.delegate;
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    public V forcePut(K k10, V v10) {
        return o(k10, v10, true);
    }

    public e0<V, K> inverse() {
        return this.inverse;
    }

    K k(K k10) {
        return k10;
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.keySet = eVar;
        return eVar;
    }

    V l(V v10) {
        return v10;
    }

    Iterator<Map.Entry<K, V>> m() {
        return new C0143a(this.delegate.entrySet().iterator());
    }

    a<V, K> n(Map<V, K> map) {
        return new d(map, this);
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public V put(K k10, V v10) {
        return o(k10, v10, false);
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    void r(Map<K, V> map, Map<V, K> map2) {
        boolean z10 = true;
        p.u(this.delegate == null);
        p.u(this.inverse == null);
        p.d(map.isEmpty());
        p.d(map2.isEmpty());
        if (map == map2) {
            z10 = false;
        }
        p.d(z10);
        this.delegate = map;
        this.inverse = n(map2);
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return p(obj);
        }
        return null;
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        this.delegate.replaceAll(biFunction);
        this.inverse.delegate.clear();
        Iterator<Map.Entry<K, V>> it = this.delegate.entrySet().iterator();
        Map.Entry<K, V> entry = null;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            K key = next.getKey();
            if (this.inverse.delegate.putIfAbsent(next.getValue(), key) != null) {
                it.remove();
                entry = next;
            }
        }
        if (entry != null) {
            String valueOf = String.valueOf(entry.getValue());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
            sb2.append("value already present: ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Map<K, V> map, Map<V, K> map2) {
        r(map, map2);
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        f fVar = new f(this, null);
        this.valueSet = fVar;
        return fVar;
    }

    private a(Map<K, V> map, a<V, K> aVar) {
        this.delegate = map;
        this.inverse = aVar;
    }
}
