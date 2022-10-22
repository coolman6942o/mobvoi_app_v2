package androidx.collection;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapCollections.java */
/* loaded from: classes.dex */
public abstract class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    e<K, V>.b f1460a;

    /* renamed from: b  reason: collision with root package name */
    e<K, V>.c f1461b;

    /* renamed from: c  reason: collision with root package name */
    e<K, V>.C0010e f1462c;

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f1463a;

        /* renamed from: b  reason: collision with root package name */
        int f1464b;

        /* renamed from: c  reason: collision with root package name */
        int f1465c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1466d = false;

        a(int i10) {
            this.f1463a = i10;
            this.f1464b = e.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1465c < this.f1464b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t10 = (T) e.this.b(this.f1465c, this.f1463a);
                this.f1465c++;
                this.f1466d = true;
                return t10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f1466d) {
                int i10 = this.f1465c - 1;
                this.f1465c = i10;
                this.f1464b--;
                this.f1466d = false;
                e.this.h(i10);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d10 = e.this.d();
            for (Map.Entry<K, V> entry : collection) {
                e.this.g(entry.getKey(), entry.getValue());
            }
            return d10 != e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e10 = e.this.e(entry.getKey());
            if (e10 < 0) {
                return false;
            }
            return androidx.collection.c.c(e.this.b(e10, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i10 = 0;
            for (int d10 = e.this.d() - 1; d10 >= 0; d10--) {
                Object b10 = e.this.b(d10, 0);
                Object b11 = e.this.b(d10, 1);
                i10 += (b10 == null ? 0 : b10.hashCode()) ^ (b11 == null ? 0 : b11.hashCode());
            }
            return i10;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return e.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return e.j(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i10 = 0;
            for (int d10 = e.this.d() - 1; d10 >= 0; d10--) {
                Object b10 = e.this.b(d10, 0);
                i10 += b10 == null ? 0 : b10.hashCode();
            }
            return i10;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e10 = e.this.e(obj);
            if (e10 < 0) {
                return false;
            }
            e.this.h(e10);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return e.o(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return e.p(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return e.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e.this.r(tArr, 0);
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f1470a;

        /* renamed from: c  reason: collision with root package name */
        boolean f1472c = false;

        /* renamed from: b  reason: collision with root package name */
        int f1471b = -1;

        d() {
            this.f1470a = e.this.d() - 1;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f1471b++;
                this.f1472c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f1472c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return androidx.collection.c.c(entry.getKey(), e.this.b(this.f1471b, 0)) && androidx.collection.c.c(entry.getValue(), e.this.b(this.f1471b, 1));
            }
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f1472c) {
                return (K) e.this.b(this.f1471b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f1472c) {
                return (V) e.this.b(this.f1471b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1471b < this.f1470a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.f1472c) {
                int i10 = 0;
                Object b10 = e.this.b(this.f1471b, 0);
                Object b11 = e.this.b(this.f1471b, 1);
                int hashCode = b10 == null ? 0 : b10.hashCode();
                if (b11 != null) {
                    i10 = b11.hashCode();
                }
                return hashCode ^ i10;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f1472c) {
                e.this.h(this.f1471b);
                this.f1471b--;
                this.f1470a--;
                this.f1472c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (this.f1472c) {
                return (V) e.this.i(this.f1471b, v10);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: androidx.collection.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    final class C0010e implements Collection<V> {
        C0010e() {
        }

        @Override // java.util.Collection
        public boolean add(V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return e.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f10 = e.this.f(obj);
            if (f10 < 0) {
                return false;
            }
            e.this.h(f10);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d10 = e.this.d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < d10) {
                if (collection.contains(e.this.b(i10, 1))) {
                    e.this.h(i10);
                    i10--;
                    d10--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d10 = e.this.d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < d10) {
                if (!collection.contains(e.this.b(i10, 1))) {
                    e.this.h(i10);
                    i10--;
                    d10--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return e.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i10, int i11);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k10, V v10);

    protected abstract void h(int i10);

    protected abstract V i(int i10, V v10);

    public Set<Map.Entry<K, V>> l() {
        if (this.f1460a == null) {
            this.f1460a = new b();
        }
        return this.f1460a;
    }

    public Set<K> m() {
        if (this.f1461b == null) {
            this.f1461b = new c();
        }
        return this.f1461b;
    }

    public Collection<V> n() {
        if (this.f1462c == null) {
            this.f1462c = new C0010e();
        }
        return this.f1462c;
    }

    public Object[] q(int i10) {
        int d10 = d();
        Object[] objArr = new Object[d10];
        for (int i11 = 0; i11 < d10; i11++) {
            objArr[i11] = b(i11, i10);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] r(T[] tArr, int i10) {
        int d10 = d();
        if (tArr.length < d10) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d10));
        }
        for (int i11 = 0; i11 < d10; i11++) {
            tArr[i11] = b(i11, i10);
        }
        if (tArr.length > d10) {
            tArr[d10] = null;
        }
        return tArr;
    }
}
