package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.j6;
import com.mobvoi.wear.contacts.ContactConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
/* loaded from: classes.dex */
public final class ConcurrentHashMultiset<E> extends p<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* loaded from: classes.dex */
    class a extends t3<E> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set f11733a;

        a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.f11733a = set;
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj != null && y2.c(this.f11733a, obj);
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return g(collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t3
        /* renamed from: l */
        public Set<E> b() {
            return this.f11733a;
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return obj != null && y2.d(this.f11733a, obj);
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return m(collection);
        }
    }

    /* loaded from: classes.dex */
    class b extends com.google.common.collect.c<j6.a<E>> {

        /* renamed from: c  reason: collision with root package name */
        private final Iterator<Map.Entry<E, AtomicInteger>> f11734c;

        b() {
            this.f11734c = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public j6.a<E> a() {
            while (this.f11734c.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.f11734c.next();
                int i10 = next.getValue().get();
                if (i10 != 0) {
                    return m6.g(next.getKey(), i10);
                }
            }
            return b();
        }
    }

    /* loaded from: classes.dex */
    class c extends n3<j6.a<E>> {

        /* renamed from: a  reason: collision with root package name */
        private j6.a<E> f11736a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterator f11737b;

        c(Iterator it) {
            this.f11737b = it;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.n3
        /* renamed from: b */
        public Iterator<j6.a<E>> a() {
            return this.f11737b;
        }

        /* renamed from: d */
        public j6.a<E> next() {
            j6.a<E> aVar = (j6.a) super.next();
            this.f11736a = aVar;
            return aVar;
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f11736a != null);
            ConcurrentHashMultiset.this.setCount(this.f11736a.a(), 0);
            this.f11736a = null;
        }
    }

    /* loaded from: classes.dex */
    private class d extends p<E>.b {
        private d() {
            super();
        }

        private List<j6.a<E>> g() {
            ArrayList k10 = s5.k(size());
            j5.a(k10, iterator());
            return k10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public ConcurrentHashMultiset<E> e() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return g().toArray();
        }

        /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) g().toArray(tArr);
        }
    }

    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        p.j(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> h() {
        ArrayList k10 = s5.k(size());
        for (j6.a aVar : entrySet()) {
            Object a10 = aVar.a();
            for (int count = aVar.getCount(); count > 0; count--) {
                k10.add(a10);
            }
        }
        return k10;
    }

    @Override // com.google.common.collect.p
    Set<E> a() {
        return new a(this, this.countMap.keySet());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L26;
     */
    @Override // com.google.common.collect.p, com.google.common.collect.j6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int add(E e10, int i10) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        p.o(e10);
        if (i10 == 0) {
            return count(e10);
        }
        p2.d(i10, "occurences");
        do {
            atomicInteger = (AtomicInteger) w5.p(this.countMap, e10);
            if (atomicInteger != null || (atomicInteger = this.countMap.putIfAbsent(e10, new AtomicInteger(i10))) != null) {
                while (true) {
                    int i11 = atomicInteger.get();
                    if (i11 == 0) {
                        break;
                    }
                    try {
                        if (atomicInteger.compareAndSet(i11, com.google.common.math.c.a(i11, i10))) {
                            return i11;
                        }
                    } catch (ArithmeticException unused) {
                        StringBuilder sb2 = new StringBuilder(65);
                        sb2.append("Overflow adding ");
                        sb2.append(i10);
                        sb2.append(" occurrences to a count of ");
                        sb2.append(i11);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
            } else {
                return 0;
            }
        } while (!this.countMap.replace(e10, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.p
    int b() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.p
    Iterator<E> c() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.j6
    public int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) w5.p(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.p
    @Deprecated
    public Set<j6.a<E>> createEntrySet() {
        return new d(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.p
    public Iterator<j6.a<E>> d() {
        return new c(new b());
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.p, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer<? super E> consumer) {
        i6.a(this, consumer);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        i6.b(this, objIntConsumer);
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return m6.i(this);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public int remove(Object obj, int i10) {
        int i11;
        int max;
        if (i10 == 0) {
            return count(obj);
        }
        p2.d(i10, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) w5.p(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i11 = atomicInteger.get();
            if (i11 == 0) {
                return 0;
            }
            max = Math.max(0, i11 - i10);
        } while (!atomicInteger.compareAndSet(i11, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i11;
    }

    public boolean removeExactly(Object obj, int i10) {
        int i11;
        int i12;
        if (i10 == 0) {
            return true;
        }
        p2.d(i10, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) w5.p(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i11 = atomicInteger.get();
            if (i11 < i10) {
                return false;
            }
            i12 = i11 - i10;
        } while (!atomicInteger.compareAndSet(i11, i12));
        if (i12 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r6 != 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L29;
     */
    @Override // com.google.common.collect.p, com.google.common.collect.j6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int setCount(E e10, int i10) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        p.o(e10);
        p2.b(i10, ContactConstant.CallsRecordKeys.COUNT);
        do {
            atomicInteger = (AtomicInteger) w5.p(this.countMap, e10);
            if (atomicInteger == null && (i10 == 0 || (atomicInteger = this.countMap.putIfAbsent(e10, new AtomicInteger(i10))) == null)) {
                return 0;
            }
            while (true) {
                int i11 = atomicInteger.get();
                if (i11 == 0) {
                    break;
                } else if (atomicInteger.compareAndSet(i11, i10)) {
                    if (i10 == 0) {
                        this.countMap.remove(e10, atomicInteger);
                    }
                    return i11;
                }
            }
        } while (!this.countMap.replace(e10, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public int size() {
        long j10 = 0;
        for (AtomicInteger atomicInteger : this.countMap.values()) {
            j10 += atomicInteger.get();
        }
        return com.google.common.primitives.d.h(j10);
    }

    @Override // com.google.common.collect.p, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator<E> spliterator() {
        return i6.c(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return h().toArray();
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        h5.a(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) h().toArray(tArr);
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public boolean setCount(E e10, int i10, int i11) {
        p.o(e10);
        p2.b(i10, "oldCount");
        p2.b(i11, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) w5.p(this.countMap, e10);
        if (atomicInteger != null) {
            int i12 = atomicInteger.get();
            if (i12 == i10) {
                if (i12 == 0) {
                    if (i11 == 0) {
                        this.countMap.remove(e10, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i11);
                    return this.countMap.putIfAbsent(e10, atomicInteger2) == null || this.countMap.replace(e10, atomicInteger, atomicInteger2);
                } else if (atomicInteger.compareAndSet(i12, i11)) {
                    if (i11 == 0) {
                        this.countMap.remove(e10, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        } else if (i10 != 0) {
            return false;
        } else {
            return i11 == 0 || this.countMap.putIfAbsent(e10, new AtomicInteger(i11)) == null;
        }
    }
}
