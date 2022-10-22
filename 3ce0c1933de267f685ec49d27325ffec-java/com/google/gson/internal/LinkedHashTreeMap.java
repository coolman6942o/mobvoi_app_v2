package com.google.gson.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.d entrySet;
    final g<K, V> header;
    private LinkedHashTreeMap<K, V>.e keySet;
    int modCount;
    int size;
    g<K, V>[] table;
    int threshold;

    /* loaded from: classes.dex */
    static class a implements Comparator<Comparable> {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private g<K, V> f12581a;

        /* renamed from: b  reason: collision with root package name */
        private int f12582b;

        /* renamed from: c  reason: collision with root package name */
        private int f12583c;

        /* renamed from: d  reason: collision with root package name */
        private int f12584d;

        b() {
        }

        void a(g<K, V> gVar) {
            gVar.f12594c = null;
            gVar.f12592a = null;
            gVar.f12593b = null;
            gVar.f12600i = 1;
            int i10 = this.f12582b;
            if (i10 > 0) {
                int i11 = this.f12584d;
                if ((i11 & 1) == 0) {
                    this.f12584d = i11 + 1;
                    this.f12582b = i10 - 1;
                    this.f12583c++;
                }
            }
            gVar.f12592a = this.f12581a;
            this.f12581a = gVar;
            int i12 = this.f12584d + 1;
            this.f12584d = i12;
            int i13 = this.f12582b;
            if (i13 > 0 && (i12 & 1) == 0) {
                this.f12584d = i12 + 1;
                this.f12582b = i13 - 1;
                this.f12583c++;
            }
            int i14 = 4;
            while (true) {
                int i15 = i14 - 1;
                if ((this.f12584d & i15) == i15) {
                    int i16 = this.f12583c;
                    if (i16 == 0) {
                        g<K, V> gVar2 = this.f12581a;
                        g<K, V> gVar3 = gVar2.f12592a;
                        g<K, V> gVar4 = gVar3.f12592a;
                        gVar3.f12592a = gVar4.f12592a;
                        this.f12581a = gVar3;
                        gVar3.f12593b = gVar4;
                        gVar3.f12594c = gVar2;
                        gVar3.f12600i = gVar2.f12600i + 1;
                        gVar4.f12592a = gVar3;
                        gVar2.f12592a = gVar3;
                    } else if (i16 == 1) {
                        g<K, V> gVar5 = this.f12581a;
                        g<K, V> gVar6 = gVar5.f12592a;
                        this.f12581a = gVar6;
                        gVar6.f12594c = gVar5;
                        gVar6.f12600i = gVar5.f12600i + 1;
                        gVar5.f12592a = gVar6;
                        this.f12583c = 0;
                    } else if (i16 == 2) {
                        this.f12583c = 0;
                    }
                    i14 *= 2;
                } else {
                    return;
                }
            }
        }

        void b(int i10) {
            this.f12582b = ((Integer.highestOneBit(i10) * 2) - 1) - i10;
            this.f12584d = 0;
            this.f12583c = 0;
            this.f12581a = null;
        }

        g<K, V> c() {
            g<K, V> gVar = this.f12581a;
            if (gVar.f12592a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private g<K, V> f12585a;

        c() {
        }

        public g<K, V> a() {
            g<K, V> gVar = this.f12585a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f12592a;
            gVar.f12592a = null;
            g<K, V> gVar3 = gVar.f12594c;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 != null) {
                    gVar2.f12592a = gVar4;
                    gVar3 = gVar2.f12593b;
                } else {
                    this.f12585a = gVar4;
                    return gVar;
                }
            }
        }

        void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.f12592a = gVar2;
                gVar2 = gVar;
                gVar = gVar.f12593b;
            }
            this.f12585a = gVar2;
        }
    }

    /* loaded from: classes.dex */
    final class d extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes.dex */
        class a extends LinkedHashTreeMap<K, V>.f<Map.Entry<K, V>> {
            a(d dVar) {
                super();
            }

            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.h((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> h10;
            if (!(obj instanceof Map.Entry) || (h10 = LinkedHashTreeMap.this.h((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.k(h10, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: classes.dex */
    final class e extends AbstractSet<K> {

        /* loaded from: classes.dex */
        class a extends LinkedHashTreeMap<K, V>.f<K> {
            a(e eVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f12597f;
            }
        }

        e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.l(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class f<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        g<K, V> f12588a;

        /* renamed from: b  reason: collision with root package name */
        g<K, V> f12589b = null;

        /* renamed from: c  reason: collision with root package name */
        int f12590c;

        f() {
            this.f12588a = LinkedHashTreeMap.this.header.f12595d;
            this.f12590c = LinkedHashTreeMap.this.modCount;
        }

        final g<K, V> a() {
            g<K, V> gVar = this.f12588a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (gVar == linkedHashTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.modCount == this.f12590c) {
                this.f12588a = gVar.f12595d;
                this.f12589b = gVar;
                return gVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f12588a != LinkedHashTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f12589b;
            if (gVar != null) {
                LinkedHashTreeMap.this.k(gVar, true);
                this.f12589b = null;
                this.f12590c = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    private void a() {
        g<K, V>[] b10 = b(this.table);
        this.table = b10;
        this.threshold = (b10.length / 2) + (b10.length / 4);
    }

    static <K, V> g<K, V>[] b(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i10 = 0; i10 < length; i10++) {
            g<K, V> gVar = gVarArr[i10];
            if (gVar != null) {
                cVar.b(gVar);
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    g<K, V> a10 = cVar.a();
                    if (a10 == null) {
                        break;
                    } else if ((a10.f12598g & length) == 0) {
                        i11++;
                    } else {
                        i12++;
                    }
                }
                bVar.b(i11);
                bVar2.b(i12);
                cVar.b(gVar);
                while (true) {
                    g<K, V> a11 = cVar.a();
                    if (a11 == null) {
                        break;
                    } else if ((a11.f12598g & length) == 0) {
                        bVar.a(a11);
                    } else {
                        bVar2.a(a11);
                    }
                }
                g<K, V> gVar2 = null;
                gVarArr2[i10] = i11 > 0 ? bVar.c() : null;
                int i13 = i10 + length;
                if (i12 > 0) {
                    gVar2 = bVar2.c();
                }
                gVarArr2[i13] = gVar2;
            }
        }
        return gVarArr2;
    }

    private boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void j(g<K, V> gVar, boolean z10) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f12593b;
            g<K, V> gVar3 = gVar.f12594c;
            int i10 = 0;
            int i11 = gVar2 != null ? gVar2.f12600i : 0;
            int i12 = gVar3 != null ? gVar3.f12600i : 0;
            int i13 = i11 - i12;
            if (i13 == -2) {
                g<K, V> gVar4 = gVar3.f12593b;
                g<K, V> gVar5 = gVar3.f12594c;
                int i14 = gVar5 != null ? gVar5.f12600i : 0;
                if (gVar4 != null) {
                    i10 = gVar4.f12600i;
                }
                int i15 = i10 - i14;
                if (i15 == -1 || (i15 == 0 && !z10)) {
                    n(gVar);
                } else {
                    o(gVar3);
                    n(gVar);
                }
                if (z10) {
                    return;
                }
            } else if (i13 == 2) {
                g<K, V> gVar6 = gVar2.f12593b;
                g<K, V> gVar7 = gVar2.f12594c;
                int i16 = gVar7 != null ? gVar7.f12600i : 0;
                if (gVar6 != null) {
                    i10 = gVar6.f12600i;
                }
                int i17 = i10 - i16;
                if (i17 == 1 || (i17 == 0 && !z10)) {
                    o(gVar);
                } else {
                    n(gVar2);
                    o(gVar);
                }
                if (z10) {
                    return;
                }
            } else if (i13 == 0) {
                gVar.f12600i = i11 + 1;
                if (z10) {
                    return;
                }
            } else {
                gVar.f12600i = Math.max(i11, i12) + 1;
                if (!z10) {
                    return;
                }
            }
            gVar = gVar.f12592a;
        }
    }

    private void m(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f12592a;
        gVar.f12592a = null;
        if (gVar2 != null) {
            gVar2.f12592a = gVar3;
        }
        if (gVar3 == null) {
            int i10 = gVar.f12598g;
            g<K, V>[] gVarArr = this.table;
            gVarArr[i10 & (gVarArr.length - 1)] = gVar2;
        } else if (gVar3.f12593b == gVar) {
            gVar3.f12593b = gVar2;
        } else {
            gVar3.f12594c = gVar2;
        }
    }

    private void n(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f12593b;
        g<K, V> gVar3 = gVar.f12594c;
        g<K, V> gVar4 = gVar3.f12593b;
        g<K, V> gVar5 = gVar3.f12594c;
        gVar.f12594c = gVar4;
        if (gVar4 != null) {
            gVar4.f12592a = gVar;
        }
        m(gVar, gVar3);
        gVar3.f12593b = gVar;
        gVar.f12592a = gVar3;
        int i10 = 0;
        int max = Math.max(gVar2 != null ? gVar2.f12600i : 0, gVar4 != null ? gVar4.f12600i : 0) + 1;
        gVar.f12600i = max;
        if (gVar5 != null) {
            i10 = gVar5.f12600i;
        }
        gVar3.f12600i = Math.max(max, i10) + 1;
    }

    private void o(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f12593b;
        g<K, V> gVar3 = gVar.f12594c;
        g<K, V> gVar4 = gVar2.f12593b;
        g<K, V> gVar5 = gVar2.f12594c;
        gVar.f12593b = gVar5;
        if (gVar5 != null) {
            gVar5.f12592a = gVar;
        }
        m(gVar, gVar2);
        gVar2.f12594c = gVar;
        gVar.f12592a = gVar2;
        int i10 = 0;
        int max = Math.max(gVar3 != null ? gVar3.f12600i : 0, gVar5 != null ? gVar5.f12600i : 0) + 1;
        gVar.f12600i = max;
        if (gVar4 != null) {
            i10 = gVar4.f12600i;
        }
        gVar2.f12600i = Math.max(max, i10) + 1;
    }

    private static int p(int i10) {
        int i11 = i10 ^ ((i10 >>> 20) ^ (i10 >>> 12));
        return (i11 >>> 4) ^ ((i11 >>> 7) ^ i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.f12595d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f12595d;
            gVar2.f12596e = null;
            gVar2.f12595d = null;
            gVar2 = gVar3;
        }
        gVar.f12596e = gVar;
        gVar.f12595d = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return i(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    g<K, V> g(K k10, boolean z10) {
        int i10;
        g<K, V> gVar;
        Comparator<? super K> comparator = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int p10 = p(k10.hashCode());
        int length = (gVarArr.length - 1) & p10;
        g<K, V> gVar2 = gVarArr[length];
        if (gVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k10 : null;
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(gVar2.f12597f);
                } else {
                    i10 = comparator.compare(k10, (K) gVar2.f12597f);
                }
                if (i10 == 0) {
                    return gVar2;
                }
                g<K, V> gVar3 = i10 < 0 ? gVar2.f12593b : gVar2.f12594c;
                if (gVar3 == null) {
                    break;
                }
                gVar2 = gVar3;
            }
        } else {
            i10 = 0;
        }
        g<K, V> gVar4 = gVar2;
        int i11 = i10;
        if (!z10) {
            return null;
        }
        g<K, V> gVar5 = this.header;
        if (gVar4 != null) {
            gVar = new g<>(gVar4, k10, p10, gVar5, gVar5.f12596e);
            if (i11 < 0) {
                gVar4.f12593b = gVar;
            } else {
                gVar4.f12594c = gVar;
            }
            j(gVar4, true);
        } else if (comparator != NATURAL_ORDER || (k10 instanceof Comparable)) {
            gVar = new g<>(gVar4, k10, p10, gVar5, gVar5.f12596e);
            gVarArr[length] = gVar;
        } else {
            throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
        }
        int i12 = this.size;
        this.size = i12 + 1;
        if (i12 > this.threshold) {
            a();
        }
        this.modCount++;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        g<K, V> i10 = i(obj);
        if (i10 != null) {
            return i10.f12599h;
        }
        return null;
    }

    g<K, V> h(Map.Entry<?, ?> entry) {
        g<K, V> i10 = i(entry.getKey());
        if (i10 != null && d(i10.f12599h, entry.getValue())) {
            return i10;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    g<K, V> i(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return g(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    void k(g<K, V> gVar, boolean z10) {
        int i10;
        if (z10) {
            g<K, V> gVar2 = gVar.f12596e;
            gVar2.f12595d = gVar.f12595d;
            gVar.f12595d.f12596e = gVar2;
            gVar.f12596e = null;
            gVar.f12595d = null;
        }
        g<K, V> gVar3 = gVar.f12593b;
        g<K, V> gVar4 = gVar.f12594c;
        g<K, V> gVar5 = gVar.f12592a;
        int i11 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                m(gVar, gVar3);
                gVar.f12593b = null;
            } else if (gVar4 != null) {
                m(gVar, gVar4);
                gVar.f12594c = null;
            } else {
                m(gVar, null);
            }
            j(gVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        g<K, V> b10 = gVar3.f12600i > gVar4.f12600i ? gVar3.b() : gVar4.a();
        k(b10, false);
        g<K, V> gVar6 = gVar.f12593b;
        if (gVar6 != null) {
            i10 = gVar6.f12600i;
            b10.f12593b = gVar6;
            gVar6.f12592a = b10;
            gVar.f12593b = null;
        } else {
            i10 = 0;
        }
        g<K, V> gVar7 = gVar.f12594c;
        if (gVar7 != null) {
            i11 = gVar7.f12600i;
            b10.f12594c = gVar7;
            gVar7.f12592a = b10;
            gVar.f12594c = null;
        }
        b10.f12600i = Math.max(i10, i11) + 1;
        m(gVar, b10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        LinkedHashTreeMap<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    g<K, V> l(Object obj) {
        g<K, V> i10 = i(obj);
        if (i10 != null) {
            k(i10, true);
        }
        return i10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        Objects.requireNonNull(k10, "key == null");
        g<K, V> g10 = g(k10, true);
        V v11 = g10.f12599h;
        g10.f12599h = v10;
        return v11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> l10 = l(obj);
        if (l10 != null) {
            return l10.f12599h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.table = gVarArr;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        g<K, V> f12592a;

        /* renamed from: b  reason: collision with root package name */
        g<K, V> f12593b;

        /* renamed from: c  reason: collision with root package name */
        g<K, V> f12594c;

        /* renamed from: d  reason: collision with root package name */
        g<K, V> f12595d;

        /* renamed from: e  reason: collision with root package name */
        g<K, V> f12596e;

        /* renamed from: f  reason: collision with root package name */
        final K f12597f;

        /* renamed from: g  reason: collision with root package name */
        final int f12598g;

        /* renamed from: h  reason: collision with root package name */
        V f12599h;

        /* renamed from: i  reason: collision with root package name */
        int f12600i;

        g() {
            this.f12597f = null;
            this.f12598g = -1;
            this.f12596e = this;
            this.f12595d = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f12593b; gVar2 != null; gVar2 = gVar2.f12593b) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f12594c; gVar2 != null; gVar2 = gVar2.f12594c) {
                gVar = gVar2;
            }
            return gVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f12597f;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v10 = this.f12599h;
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
            return this.f12597f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f12599h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f12597f;
            int i10 = 0;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f12599h;
            if (v10 != null) {
                i10 = v10.hashCode();
            }
            return hashCode ^ i10;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = this.f12599h;
            this.f12599h = v10;
            return v11;
        }

        public String toString() {
            return this.f12597f + ContainerUtils.KEY_VALUE_DELIMITER + this.f12599h;
        }

        g(g<K, V> gVar, K k10, int i10, g<K, V> gVar2, g<K, V> gVar3) {
            this.f12592a = gVar;
            this.f12597f = k10;
            this.f12598g = i10;
            this.f12600i = 1;
            this.f12595d = gVar2;
            this.f12596e = gVar3;
            gVar3.f12595d = this;
            gVar2.f12596e = this;
        }
    }
}
