package com.google.protobuf;

import com.google.protobuf.t;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmallSortedMap.java */
/* loaded from: classes.dex */
public class r0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f13340a;

    /* renamed from: b  reason: collision with root package name */
    private List<r0<K, V>.c> f13341b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f13342c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13343d;

    /* renamed from: e  reason: collision with root package name */
    private volatile r0<K, V>.e f13344e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes.dex */
    public static class a extends r0<FieldDescriptorType, Object> {
        a(int i10) {
            super(i10, null);
        }

        @Override // com.google.protobuf.r0
        public void o() {
            if (!n()) {
                for (int i10 = 0; i10 < j(); i10++) {
                    Map.Entry<FieldDescriptorType, Object> i11 = i(i10);
                    if (((t.b) i11.getKey()).o()) {
                        i11.setValue(Collections.unmodifiableList((List) i11.getValue()));
                    }
                }
                Iterator it = l().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((t.b) entry.getKey()).o()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            r0.super.o();
        }

        @Override // com.google.protobuf.r0, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return r0.super.put((t.b) obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final Iterator<Object> f13345a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f13346b = new C0173b();

        /* compiled from: SmallSortedMap.java */
        /* loaded from: classes.dex */
        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: SmallSortedMap.java */
        /* renamed from: com.google.protobuf.r0$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0173b implements Iterable<Object> {
            C0173b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f13345a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f13346b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes.dex */
    public class c implements Map.Entry<K, V>, Comparable<r0<K, V>.c> {

        /* renamed from: a  reason: collision with root package name */
        private final K f13347a;

        /* renamed from: b  reason: collision with root package name */
        private V f13348b;

        c(r0 r0Var, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        /* renamed from: a */
        public int compareTo(r0<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        /* renamed from: c */
        public K getKey() {
            return this.f13347a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f13347a, entry.getKey()) && b(this.f13348b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f13348b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f13347a;
            int i10 = 0;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f13348b;
            if (v10 != null) {
                i10 = v10.hashCode();
            }
            return hashCode ^ i10;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            r0.this.g();
            V v11 = this.f13348b;
            this.f13348b = v10;
            return v11;
        }

        public String toString() {
            return this.f13347a + ContainerUtils.KEY_VALUE_DELIMITER + this.f13348b;
        }

        c(K k10, V v10) {
            this.f13347a = k10;
            this.f13348b = v10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes.dex */
    public class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            r0.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            r0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = r0.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(r0.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            r0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r0.this.size();
        }

        /* synthetic */ e(r0 r0Var, a aVar) {
            this();
        }
    }

    /* synthetic */ r0(int i10, a aVar) {
        this(i10);
    }

    private int f(K k10) {
        int size = this.f13341b.size() - 1;
        if (size >= 0) {
            int compareTo = k10.compareTo(this.f13341b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int compareTo2 = k10.compareTo(this.f13341b.get(i11).getKey());
            if (compareTo2 < 0) {
                size = i11 - 1;
            } else if (compareTo2 <= 0) {
                return i11;
            } else {
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f13343d) {
            throw new UnsupportedOperationException();
        }
    }

    private void h() {
        g();
        if (this.f13341b.isEmpty() && !(this.f13341b instanceof ArrayList)) {
            this.f13341b = new ArrayList(this.f13340a);
        }
    }

    private SortedMap<K, V> m() {
        g();
        if (this.f13342c.isEmpty() && !(this.f13342c instanceof TreeMap)) {
            this.f13342c = new TreeMap();
        }
        return (SortedMap) this.f13342c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends t.b<FieldDescriptorType>> r0<FieldDescriptorType, Object> p(int i10) {
        return new a(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V r(int i10) {
        g();
        V value = this.f13341b.remove(i10).getValue();
        if (!this.f13342c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = m().entrySet().iterator();
            this.f13341b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f13341b.isEmpty()) {
            this.f13341b.clear();
        }
        if (!this.f13342c.isEmpty()) {
            this.f13342c.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f13342c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f13344e == null) {
            this.f13344e = new e(this, null);
        }
        return this.f13344e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return super.equals(obj);
        }
        r0 r0Var = (r0) obj;
        int size = size();
        if (size != r0Var.size()) {
            return false;
        }
        int j10 = j();
        if (j10 != r0Var.j()) {
            return entrySet().equals(r0Var.entrySet());
        }
        for (int i10 = 0; i10 < j10; i10++) {
            if (!i(i10).equals(r0Var.i(i10))) {
                return false;
            }
        }
        if (j10 != size) {
            return this.f13342c.equals(r0Var.f13342c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f10 = f(comparable);
        if (f10 >= 0) {
            return this.f13341b.get(f10).getValue();
        }
        return this.f13342c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int j10 = j();
        int i10 = 0;
        for (int i11 = 0; i11 < j10; i11++) {
            i10 += this.f13341b.get(i11).hashCode();
        }
        return k() > 0 ? i10 + this.f13342c.hashCode() : i10;
    }

    public Map.Entry<K, V> i(int i10) {
        return this.f13341b.get(i10);
    }

    public int j() {
        return this.f13341b.size();
    }

    public int k() {
        return this.f13342c.size();
    }

    public Iterable<Map.Entry<K, V>> l() {
        if (this.f13342c.isEmpty()) {
            return b.b();
        }
        return this.f13342c.entrySet();
    }

    public boolean n() {
        return this.f13343d;
    }

    public void o() {
        Map<K, V> map;
        if (!this.f13343d) {
            if (this.f13342c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f13342c);
            }
            this.f13342c = map;
            this.f13343d = true;
        }
    }

    /* renamed from: q */
    public V put(K k10, V v10) {
        g();
        int f10 = f(k10);
        if (f10 >= 0) {
            return this.f13341b.get(f10).setValue(v10);
        }
        h();
        int i10 = -(f10 + 1);
        if (i10 >= this.f13340a) {
            return m().put(k10, v10);
        }
        int size = this.f13341b.size();
        int i11 = this.f13340a;
        if (size == i11) {
            r0<K, V>.c remove = this.f13341b.remove(i11 - 1);
            m().put((K) remove.getKey(), remove.getValue());
        }
        this.f13341b.add(i10, new c(k10, v10));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int f10 = f(comparable);
        if (f10 >= 0) {
            return (V) r(f10);
        }
        if (this.f13342c.isEmpty()) {
            return null;
        }
        return this.f13342c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f13341b.size() + this.f13342c.size();
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes.dex */
    private class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f13350a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13351b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f13352c;

        private d() {
            this.f13350a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f13352c == null) {
                this.f13352c = r0.this.f13342c.entrySet().iterator();
            }
            return this.f13352c;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.f13351b = true;
            int i10 = this.f13350a + 1;
            this.f13350a = i10;
            if (i10 < r0.this.f13341b.size()) {
                return (Map.Entry) r0.this.f13341b.get(this.f13350a);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13350a + 1 < r0.this.f13341b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f13351b) {
                this.f13351b = false;
                r0.this.g();
                if (this.f13350a < r0.this.f13341b.size()) {
                    r0 r0Var = r0.this;
                    int i10 = this.f13350a;
                    this.f13350a = i10 - 1;
                    r0Var.r(i10);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ d(r0 r0Var, a aVar) {
            this();
        }
    }

    private r0(int i10) {
        this.f13340a = i10;
        this.f13341b = Collections.emptyList();
        this.f13342c = Collections.emptyMap();
    }
}
