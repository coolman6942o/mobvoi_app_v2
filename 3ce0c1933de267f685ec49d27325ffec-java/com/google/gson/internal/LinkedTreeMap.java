package com.google.gson.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    /* loaded from: classes.dex */
    static class a implements Comparator<Comparable> {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes.dex */
        class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            a(b bVar) {
                super();
            }

            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.d((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> d10;
            if (!(obj instanceof Map.Entry) || (d10 = LinkedTreeMap.this.d((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.i(d10, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes.dex */
    final class c extends AbstractSet<K> {

        /* loaded from: classes.dex */
        class a extends LinkedTreeMap<K, V>.d<K> {
            a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f12612f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.j(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        e<K, V> f12603a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f12604b = null;

        /* renamed from: c  reason: collision with root package name */
        int f12605c;

        d() {
            this.f12603a = LinkedTreeMap.this.header.f12610d;
            this.f12605c = LinkedTreeMap.this.modCount;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f12603a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedTreeMap.modCount == this.f12605c) {
                this.f12603a = eVar.f12610d;
                this.f12604b = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f12603a != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f12604b;
            if (eVar != null) {
                LinkedTreeMap.this.i(eVar, true);
                this.f12604b = null;
                this.f12605c = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void h(e<K, V> eVar, boolean z10) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f12608b;
            e<K, V> eVar3 = eVar.f12609c;
            int i10 = 0;
            int i11 = eVar2 != null ? eVar2.f12614h : 0;
            int i12 = eVar3 != null ? eVar3.f12614h : 0;
            int i13 = i11 - i12;
            if (i13 == -2) {
                e<K, V> eVar4 = eVar3.f12608b;
                e<K, V> eVar5 = eVar3.f12609c;
                int i14 = eVar5 != null ? eVar5.f12614h : 0;
                if (eVar4 != null) {
                    i10 = eVar4.f12614h;
                }
                int i15 = i10 - i14;
                if (i15 == -1 || (i15 == 0 && !z10)) {
                    l(eVar);
                } else {
                    m(eVar3);
                    l(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i13 == 2) {
                e<K, V> eVar6 = eVar2.f12608b;
                e<K, V> eVar7 = eVar2.f12609c;
                int i16 = eVar7 != null ? eVar7.f12614h : 0;
                if (eVar6 != null) {
                    i10 = eVar6.f12614h;
                }
                int i17 = i10 - i16;
                if (i17 == 1 || (i17 == 0 && !z10)) {
                    m(eVar);
                } else {
                    l(eVar2);
                    m(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i13 == 0) {
                eVar.f12614h = i11 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f12614h = Math.max(i11, i12) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f12607a;
        }
    }

    private void k(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f12607a;
        eVar.f12607a = null;
        if (eVar2 != null) {
            eVar2.f12607a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f12608b == eVar) {
            eVar3.f12608b = eVar2;
        } else {
            eVar3.f12609c = eVar2;
        }
    }

    private void l(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f12608b;
        e<K, V> eVar3 = eVar.f12609c;
        e<K, V> eVar4 = eVar3.f12608b;
        e<K, V> eVar5 = eVar3.f12609c;
        eVar.f12609c = eVar4;
        if (eVar4 != null) {
            eVar4.f12607a = eVar;
        }
        k(eVar, eVar3);
        eVar3.f12608b = eVar;
        eVar.f12607a = eVar3;
        int i10 = 0;
        int max = Math.max(eVar2 != null ? eVar2.f12614h : 0, eVar4 != null ? eVar4.f12614h : 0) + 1;
        eVar.f12614h = max;
        if (eVar5 != null) {
            i10 = eVar5.f12614h;
        }
        eVar3.f12614h = Math.max(max, i10) + 1;
    }

    private void m(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f12608b;
        e<K, V> eVar3 = eVar.f12609c;
        e<K, V> eVar4 = eVar2.f12608b;
        e<K, V> eVar5 = eVar2.f12609c;
        eVar.f12608b = eVar5;
        if (eVar5 != null) {
            eVar5.f12607a = eVar;
        }
        k(eVar, eVar2);
        eVar2.f12609c = eVar;
        eVar.f12607a = eVar2;
        int i10 = 0;
        int max = Math.max(eVar3 != null ? eVar3.f12614h : 0, eVar5 != null ? eVar5.f12614h : 0) + 1;
        eVar.f12614h = max;
        if (eVar4 != null) {
            i10 = eVar4.f12614h;
        }
        eVar2.f12614h = Math.max(max, i10) + 1;
    }

    e<K, V> b(K k10, boolean z10) {
        int i10;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k10 : null;
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(eVar2.f12612f);
                } else {
                    i10 = comparator.compare(k10, (K) eVar2.f12612f);
                }
                if (i10 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i10 < 0 ? eVar2.f12608b : eVar2.f12609c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k10, eVar4, eVar4.f12611e);
            if (i10 < 0) {
                eVar2.f12608b = eVar;
            } else {
                eVar2.f12609c = eVar;
            }
            h(eVar2, true);
        } else if (comparator != NATURAL_ORDER || (k10 instanceof Comparable)) {
            eVar = new e<>(eVar2, k10, eVar4, eVar4.f12611e);
            this.root = eVar;
        } else {
            throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f12611e = eVar;
        eVar.f12610d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return g(obj) != null;
    }

    e<K, V> d(Map.Entry<?, ?> entry) {
        e<K, V> g10 = g(entry.getKey());
        if (g10 != null && a(g10.f12613g, entry.getValue())) {
            return g10;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> g(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> g10 = g(obj);
        if (g10 != null) {
            return g10.f12613g;
        }
        return null;
    }

    void i(e<K, V> eVar, boolean z10) {
        int i10;
        if (z10) {
            e<K, V> eVar2 = eVar.f12611e;
            eVar2.f12610d = eVar.f12610d;
            eVar.f12610d.f12611e = eVar2;
        }
        e<K, V> eVar3 = eVar.f12608b;
        e<K, V> eVar4 = eVar.f12609c;
        e<K, V> eVar5 = eVar.f12607a;
        int i11 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                k(eVar, eVar3);
                eVar.f12608b = null;
            } else if (eVar4 != null) {
                k(eVar, eVar4);
                eVar.f12609c = null;
            } else {
                k(eVar, null);
            }
            h(eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e<K, V> b10 = eVar3.f12614h > eVar4.f12614h ? eVar3.b() : eVar4.a();
        i(b10, false);
        e<K, V> eVar6 = eVar.f12608b;
        if (eVar6 != null) {
            i10 = eVar6.f12614h;
            b10.f12608b = eVar6;
            eVar6.f12607a = b10;
            eVar.f12608b = null;
        } else {
            i10 = 0;
        }
        e<K, V> eVar7 = eVar.f12609c;
        if (eVar7 != null) {
            i11 = eVar7.f12614h;
            b10.f12609c = eVar7;
            eVar7.f12607a = b10;
            eVar.f12609c = null;
        }
        b10.f12614h = Math.max(i10, i11) + 1;
        k(eVar, b10);
    }

    e<K, V> j(Object obj) {
        e<K, V> g10 = g(obj);
        if (g10 != null) {
            i(g10, true);
        }
        return g10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        Objects.requireNonNull(k10, "key == null");
        e<K, V> b10 = b(k10, true);
        V v11 = b10.f12613g;
        b10.f12613g = v10;
        return v11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> j10 = j(obj);
        if (j10 != null) {
            return j10.f12613g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new e<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        e<K, V> f12607a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f12608b;

        /* renamed from: c  reason: collision with root package name */
        e<K, V> f12609c;

        /* renamed from: d  reason: collision with root package name */
        e<K, V> f12610d;

        /* renamed from: e  reason: collision with root package name */
        e<K, V> f12611e;

        /* renamed from: f  reason: collision with root package name */
        final K f12612f;

        /* renamed from: g  reason: collision with root package name */
        V f12613g;

        /* renamed from: h  reason: collision with root package name */
        int f12614h;

        e() {
            this.f12612f = null;
            this.f12611e = this;
            this.f12610d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f12608b; eVar2 != null; eVar2 = eVar2.f12608b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f12609c; eVar2 != null; eVar2 = eVar2.f12609c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f12612f;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v10 = this.f12613g;
            if (v10 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v10.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f12612f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f12613g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f12612f;
            int i10 = 0;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f12613g;
            if (v10 != null) {
                i10 = v10.hashCode();
            }
            return hashCode ^ i10;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = this.f12613g;
            this.f12613g = v10;
            return v11;
        }

        public String toString() {
            return this.f12612f + ContainerUtils.KEY_VALUE_DELIMITER + this.f12613g;
        }

        e(e<K, V> eVar, K k10, e<K, V> eVar2, e<K, V> eVar3) {
            this.f12607a = eVar;
            this.f12612f = k10;
            this.f12614h = 1;
            this.f12610d = eVar2;
            this.f12611e = eVar3;
            eVar3.f12610d = this;
            eVar2.f12611e = this;
        }
    }
}
