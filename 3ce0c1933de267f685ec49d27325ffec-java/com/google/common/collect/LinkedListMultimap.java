package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.e6;
import com.google.common.collect.l7;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
/* loaded from: classes.dex */
public class LinkedListMultimap<K, V> extends o<K, V> implements q5<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient g<K, V> head;
    private transient Map<K, f<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;
    private transient g<K, V> tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AbstractSequentialList<V> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f11827a;

        a(Object obj) {
            this.f11827a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i10) {
            return new i(this.f11827a, i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f11827a);
            if (fVar == null) {
                return 0;
            }
            return fVar.f11840c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
            p.o(consumer);
            for (g<K, V> gVar = LinkedListMultimap.this.head; gVar != null; gVar = gVar.f11843c) {
                consumer.accept(gVar);
            }
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i10) {
            return new h(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: classes.dex */
    class c extends l7.a<K> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AbstractSequentialList<V> {

        /* loaded from: classes.dex */
        class a extends o8<Map.Entry<K, V>, V> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h f11832b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f11832b = hVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.o8, java.util.ListIterator
            public void set(V v10) {
                this.f11832b.f(v10);
            }
        }

        d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i10) {
            h hVar = new h(i10);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        g<K, V> f11838a;

        /* renamed from: b  reason: collision with root package name */
        g<K, V> f11839b;

        /* renamed from: c  reason: collision with root package name */
        int f11840c = 1;

        f(g<K, V> gVar) {
            this.f11838a = gVar;
            this.f11839b = gVar;
            gVar.f11846f = null;
            gVar.f11845e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g<K, V> extends n<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f11841a;

        /* renamed from: b  reason: collision with root package name */
        V f11842b;

        /* renamed from: c  reason: collision with root package name */
        g<K, V> f11843c;

        /* renamed from: d  reason: collision with root package name */
        g<K, V> f11844d;

        /* renamed from: e  reason: collision with root package name */
        g<K, V> f11845e;

        /* renamed from: f  reason: collision with root package name */
        g<K, V> f11846f;

        g(K k10, V v10) {
            this.f11841a = k10;
            this.f11842b = v10;
        }

        @Override // com.google.common.collect.n, java.util.Map.Entry
        public K getKey() {
            return this.f11841a;
        }

        @Override // com.google.common.collect.n, java.util.Map.Entry
        public V getValue() {
            return this.f11842b;
        }

        @Override // com.google.common.collect.n, java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = this.f11842b;
            this.f11842b = v10;
            return v11;
        }
    }

    /* loaded from: classes.dex */
    private class h implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        int f11847a;

        /* renamed from: b  reason: collision with root package name */
        g<K, V> f11848b;

        /* renamed from: c  reason: collision with root package name */
        g<K, V> f11849c;

        /* renamed from: d  reason: collision with root package name */
        g<K, V> f11850d;

        /* renamed from: e  reason: collision with root package name */
        int f11851e;

        h(int i10) {
            this.f11851e = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            p.r(i10, size);
            if (i10 < size / 2) {
                this.f11848b = LinkedListMultimap.this.head;
                while (true) {
                    i10--;
                    if (i10 <= 0) {
                        break;
                    }
                    next();
                }
            } else {
                this.f11850d = LinkedListMultimap.this.tail;
                this.f11847a = size;
                while (true) {
                    i10++;
                    if (i10 >= size) {
                        break;
                    }
                    previous();
                }
            }
            this.f11849c = null;
        }

        private void b() {
            if (LinkedListMultimap.this.modCount != this.f11851e) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: a */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public g<K, V> next() {
            b();
            LinkedListMultimap.v(this.f11848b);
            g<K, V> gVar = this.f11848b;
            this.f11849c = gVar;
            this.f11850d = gVar;
            this.f11848b = gVar.f11843c;
            this.f11847a++;
            return gVar;
        }

        /* renamed from: d */
        public g<K, V> previous() {
            b();
            LinkedListMultimap.v(this.f11850d);
            g<K, V> gVar = this.f11850d;
            this.f11849c = gVar;
            this.f11848b = gVar;
            this.f11850d = gVar.f11844d;
            this.f11847a--;
            return gVar;
        }

        /* renamed from: e */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        void f(V v10) {
            p.u(this.f11849c != null);
            this.f11849c.f11842b = v10;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f11848b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f11850d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f11847a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f11847a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            p2.e(this.f11849c != null);
            g<K, V> gVar = this.f11849c;
            if (gVar != this.f11848b) {
                this.f11850d = gVar.f11844d;
                this.f11847a--;
            } else {
                this.f11848b = gVar.f11843c;
            }
            LinkedListMultimap.this.A(gVar);
            this.f11849c = null;
            this.f11851e = LinkedListMultimap.this.modCount;
        }
    }

    LinkedListMultimap() {
        this(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f11844d;
        if (gVar2 != null) {
            gVar2.f11843c = gVar.f11843c;
        } else {
            this.head = gVar.f11843c;
        }
        g<K, V> gVar3 = gVar.f11843c;
        if (gVar3 != null) {
            gVar3.f11844d = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.f11846f == null && gVar.f11845e == null) {
            this.keyToKeyList.remove(gVar.f11841a).f11840c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f11841a);
            fVar.f11840c--;
            g<K, V> gVar4 = gVar.f11846f;
            if (gVar4 == null) {
                fVar.f11838a = gVar.f11845e;
            } else {
                gVar4.f11845e = gVar.f11845e;
            }
            g<K, V> gVar5 = gVar.f11845e;
            if (gVar5 == null) {
                fVar.f11839b = gVar4;
            } else {
                gVar5.f11846f = gVar4;
            }
        }
        this.size--;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g<K, V> u(K k10, V v10, g<K, V> gVar) {
        g<K, V> gVar2 = new g<>(k10, v10);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k10, new f<>(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g<K, V> gVar3 = this.tail;
            gVar3.f11843c = gVar2;
            gVar2.f11844d = gVar3;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k10);
            if (fVar == null) {
                this.keyToKeyList.put(k10, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f11840c++;
                g<K, V> gVar4 = fVar.f11839b;
                gVar4.f11845e = gVar2;
                gVar2.f11846f = gVar4;
                fVar.f11839b = gVar2;
            }
        } else {
            this.keyToKeyList.get(k10).f11840c++;
            gVar2.f11844d = gVar.f11844d;
            gVar2.f11846f = gVar.f11846f;
            gVar2.f11843c = gVar;
            gVar2.f11845e = gVar;
            g<K, V> gVar5 = gVar.f11846f;
            if (gVar5 == null) {
                this.keyToKeyList.get(k10).f11838a = gVar2;
            } else {
                gVar5.f11845e = gVar2;
            }
            g<K, V> gVar6 = gVar.f11844d;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f11843c = gVar2;
            }
            gVar.f11844d = gVar2;
            gVar.f11846f = gVar2;
        }
        this.size++;
        return gVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    private List<V> y(Object obj) {
        return Collections.unmodifiableList(s5.i(new i(obj)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Object obj) {
        j5.d(new i(obj));
    }

    @Override // com.google.common.collect.o
    Map<K, Collection<V>> a() {
        return new e6.a(this);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.o
    Set<K> c() {
        return new c();
    }

    @Override // com.google.common.collect.b6
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.b6
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.o
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.o
    j6<K> d() {
        return new e6.e(this);
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        a6.a(this, biConsumer);
    }

    @Override // com.google.common.collect.o
    Iterator<Map.Entry<K, V>> h() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ j6 keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.o
    public boolean put(K k10, V v10) {
        u(k10, v10, null);
        return true;
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean putAll(b6 b6Var) {
        return super.putAll(b6Var);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.b6
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public List<Map.Entry<K, V>> b() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public List<V> g() {
        return new d();
    }

    private LinkedListMultimap(int i10) {
        this.keyToKeyList = s6.c(i10);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i10) {
        return new LinkedListMultimap<>(i10);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.b6
    public List<V> get(K k10) {
        return new a(k10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.b6
    public List<V> removeAll(Object obj) {
        List<V> y10 = y(obj);
        z(obj);
        return y10;
    }

    @Override // com.google.common.collect.o
    public List<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        List<V> y10 = y(k10);
        i iVar = new i(k10);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return y10;
    }

    @Override // com.google.common.collect.o
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(b6<? extends K, ? extends V> b6Var) {
        return new LinkedListMultimap<>(b6Var);
    }

    /* loaded from: classes.dex */
    private class e implements Iterator<K> {

        /* renamed from: a  reason: collision with root package name */
        final Set<K> f11833a;

        /* renamed from: b  reason: collision with root package name */
        g<K, V> f11834b;

        /* renamed from: c  reason: collision with root package name */
        g<K, V> f11835c;

        /* renamed from: d  reason: collision with root package name */
        int f11836d;

        private e() {
            this.f11833a = l7.d(LinkedListMultimap.this.keySet().size());
            this.f11834b = LinkedListMultimap.this.head;
            this.f11836d = LinkedListMultimap.this.modCount;
        }

        private void a() {
            if (LinkedListMultimap.this.modCount != this.f11836d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f11834b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            g<K, V> gVar;
            a();
            LinkedListMultimap.v(this.f11834b);
            g<K, V> gVar2 = this.f11834b;
            this.f11835c = gVar2;
            this.f11833a.add(gVar2.f11841a);
            do {
                gVar = this.f11834b.f11843c;
                this.f11834b = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f11833a.add(gVar.f11841a));
            return this.f11835c.f11841a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            p2.e(this.f11835c != null);
            LinkedListMultimap.this.z(this.f11835c.f11841a);
            this.f11835c = null;
            this.f11836d = LinkedListMultimap.this.modCount;
        }

        /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i implements ListIterator<V> {

        /* renamed from: a  reason: collision with root package name */
        final Object f11853a;

        /* renamed from: b  reason: collision with root package name */
        int f11854b;

        /* renamed from: c  reason: collision with root package name */
        g<K, V> f11855c;

        /* renamed from: d  reason: collision with root package name */
        g<K, V> f11856d;

        /* renamed from: e  reason: collision with root package name */
        g<K, V> f11857e;

        i(Object obj) {
            this.f11853a = obj;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.f11855c = fVar == null ? null : fVar.f11838a;
        }

        @Override // java.util.ListIterator
        public void add(V v10) {
            this.f11857e = LinkedListMultimap.this.u(this.f11853a, v10, this.f11855c);
            this.f11854b++;
            this.f11856d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f11855c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f11857e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            LinkedListMultimap.v(this.f11855c);
            g<K, V> gVar = this.f11855c;
            this.f11856d = gVar;
            this.f11857e = gVar;
            this.f11855c = gVar.f11845e;
            this.f11854b++;
            return gVar.f11842b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f11854b;
        }

        @Override // java.util.ListIterator
        public V previous() {
            LinkedListMultimap.v(this.f11857e);
            g<K, V> gVar = this.f11857e;
            this.f11856d = gVar;
            this.f11855c = gVar;
            this.f11857e = gVar.f11846f;
            this.f11854b--;
            return gVar.f11842b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f11854b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            p2.e(this.f11856d != null);
            g<K, V> gVar = this.f11856d;
            if (gVar != this.f11855c) {
                this.f11857e = gVar.f11846f;
                this.f11854b--;
            } else {
                this.f11855c = gVar.f11845e;
            }
            LinkedListMultimap.this.A(gVar);
            this.f11856d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v10) {
            p.u(this.f11856d != null);
            this.f11856d.f11842b = v10;
        }

        public i(Object obj, int i10) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i11 = fVar == null ? 0 : fVar.f11840c;
            p.r(i10, i11);
            if (i10 < i11 / 2) {
                this.f11855c = fVar == null ? null : fVar.f11838a;
                while (true) {
                    i10--;
                    if (i10 <= 0) {
                        break;
                    }
                    next();
                }
            } else {
                this.f11857e = fVar == null ? null : fVar.f11839b;
                this.f11854b = i11;
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                    previous();
                }
            }
            this.f11853a = obj;
            this.f11856d = null;
        }
    }

    private LinkedListMultimap(b6<? extends K, ? extends V> b6Var) {
        this(b6Var.keySet().size());
        putAll(b6Var);
    }
}
