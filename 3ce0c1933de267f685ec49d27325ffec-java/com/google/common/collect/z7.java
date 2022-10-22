package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.base.r;
import com.google.common.base.s;
import com.google.common.base.v;
import com.google.common.collect.c8;
import com.google.common.collect.l7;
import com.google.common.collect.w5;
import com.google.common.collect.z7;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardTable.java */
/* loaded from: classes.dex */
public class z7<R, C, V> extends y<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<R, Map<C, V>> backingMap;
    private transient Set<C> columnKeySet;
    private transient z7<R, C, V>.f columnMap;
    final v<? extends Map<C, V>> factory;
    private transient Map<R, Map<C, V>> rowMap;

    /* compiled from: StandardTable.java */
    /* loaded from: classes.dex */
    private class b implements Iterator<c8.a<R, C, V>> {

        /* renamed from: a  reason: collision with root package name */
        final Iterator<Map.Entry<R, Map<C, V>>> f12276a;

        /* renamed from: b  reason: collision with root package name */
        Map.Entry<R, Map<C, V>> f12277b;

        /* renamed from: c  reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f12278c;

        private b() {
            this.f12276a = z7.this.backingMap.entrySet().iterator();
            this.f12278c = j5.j();
        }

        /* renamed from: a */
        public c8.a<R, C, V> next() {
            if (!this.f12278c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f12276a.next();
                this.f12277b = next;
                this.f12278c = next.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next2 = this.f12278c.next();
            return m8.b(this.f12277b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12276a.hasNext() || this.f12278c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f12278c.remove();
            if (this.f12277b.getValue().isEmpty()) {
                this.f12276a.remove();
                this.f12277b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes.dex */
    public class c extends w5.n<R, V> {

        /* renamed from: d  reason: collision with root package name */
        final C f12280d;

        /* compiled from: StandardTable.java */
        /* loaded from: classes.dex */
        private class a extends l7.a<Map.Entry<R, V>> {
            private a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.e(s.a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return z7.this.n(entry.getKey(), c.this.f12280d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !z7.this.containsColumn(cVar.f12280d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return z7.this.u(entry.getKey(), c.this.f12280d, entry.getValue());
            }

            @Override // com.google.common.collect.l7.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(s.f(s.d(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i10 = 0;
                for (Map<C, V> map : z7.this.backingMap.values()) {
                    if (map.containsKey(c.this.f12280d)) {
                        i10++;
                    }
                }
                return i10;
            }
        }

        /* compiled from: StandardTable.java */
        /* loaded from: classes.dex */
        private class b extends com.google.common.collect.c<Map.Entry<R, V>> {

            /* renamed from: c  reason: collision with root package name */
            final Iterator<Map.Entry<R, Map<C, V>>> f12283c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: StandardTable.java */
            /* loaded from: classes.dex */
            public class a extends n<R, V> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Map.Entry f12285a;

                a(Map.Entry entry) {
                    this.f12285a = entry;
                }

                @Override // com.google.common.collect.n, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f12285a.getKey();
                }

                @Override // com.google.common.collect.n, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f12285a.getValue()).get(c.this.f12280d);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.n, java.util.Map.Entry
                public V setValue(V v10) {
                    return (V) ((Map) this.f12285a.getValue()).put(c.this.f12280d, p.o(v10));
                }
            }

            private b() {
                this.f12283c = z7.this.backingMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                while (this.f12283c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f12283c.next();
                    if (next.getValue().containsKey(c.this.f12280d)) {
                        return new a(next);
                    }
                }
                return b();
            }
        }

        /* compiled from: StandardTable.java */
        /* renamed from: com.google.common.collect.z7$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class C0152c extends w5.j<R, V> {
            C0152c() {
                super(c.this);
            }

            @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return z7.this.contains(obj, cVar.f12280d);
            }

            @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return z7.this.remove(obj, cVar.f12280d) != null;
            }

            @Override // com.google.common.collect.l7.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(w5.j(s.f(s.d(collection))));
            }
        }

        /* compiled from: StandardTable.java */
        /* loaded from: classes.dex */
        private class d extends w5.m<R, V> {
            d() {
                super(c.this);
            }

            @Override // com.google.common.collect.w5.m, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.e(w5.x(s.c(obj)));
            }

            @Override // com.google.common.collect.w5.m, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.e(w5.x(s.d(collection)));
            }

            @Override // com.google.common.collect.w5.m, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(w5.x(s.f(s.d(collection))));
            }
        }

        c(C c10) {
            this.f12280d = (C) p.o(c10);
        }

        @Override // com.google.common.collect.w5.n
        Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.w5.n
        Set<R> b() {
            return new C0152c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return z7.this.contains(obj, this.f12280d);
        }

        @Override // com.google.common.collect.w5.n
        Collection<V> d() {
            return new d();
        }

        boolean e(r<? super Map.Entry<R, V>> rVar) {
            Iterator<Map.Entry<R, Map<C, V>>> it = z7.this.backingMap.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v10 = value.get(this.f12280d);
                if (v10 != null && rVar.apply(w5.e(next.getKey(), v10))) {
                    value.remove(this.f12280d);
                    z10 = true;
                    if (value.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) z7.this.get(obj, this.f12280d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r10, V v10) {
            return (V) z7.this.put(r10, this.f12280d, v10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) z7.this.remove(obj, this.f12280d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes.dex */
    public class d extends com.google.common.collect.c<C> {

        /* renamed from: c  reason: collision with root package name */
        final Map<C, V> f12289c;

        /* renamed from: d  reason: collision with root package name */
        final Iterator<Map<C, V>> f12290d;

        /* renamed from: e  reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f12291e;

        private d() {
            this.f12289c = z7.this.factory.get();
            this.f12290d = z7.this.backingMap.values().iterator();
            this.f12291e = j5.h();
        }

        @Override // com.google.common.collect.c
        protected C a() {
            while (true) {
                if (this.f12291e.hasNext()) {
                    Map.Entry<C, V> next = this.f12291e.next();
                    if (!this.f12289c.containsKey(next.getKey())) {
                        this.f12289c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (!this.f12290d.hasNext()) {
                    return b();
                } else {
                    this.f12291e = this.f12290d.next().entrySet().iterator();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes.dex */
    public class e extends z7<R, C, V>.i<C> {
        private e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return z7.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return z7.this.o();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z10 = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = z7.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    z10 = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z10;
        }

        @Override // com.google.common.collect.l7.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            p.o(collection);
            Iterator<Map<C, V>> it = z7.this.backingMap.values().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (j5.t(next.keySet().iterator(), collection)) {
                    z10 = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z10;
        }

        @Override // com.google.common.collect.l7.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            p.o(collection);
            Iterator<Map<C, V>> it = z7.this.backingMap.values().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    z10 = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return j5.w(iterator());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes.dex */
    public class f extends w5.n<C, Map<R, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StandardTable.java */
        /* loaded from: classes.dex */
        public class a extends z7<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* compiled from: StandardTable.java */
            /* renamed from: com.google.common.collect.z7$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0153a implements com.google.common.base.h<C, Map<R, V>> {
                C0153a() {
                }

                /* renamed from: a */
                public Map<R, V> apply(C c10) {
                    return z7.this.column(c10);
                }
            }

            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!z7.this.containsColumn(entry.getKey())) {
                    return false;
                }
                return f.this.get(entry.getKey()).equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return w5.a(z7.this.columnKeySet(), new C0153a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                z7.this.t(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.l7.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                p.o(collection);
                return l7.h(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.l7.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                p.o(collection);
                Iterator it = s5.i(z7.this.columnKeySet().iterator()).iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(w5.e(next, z7.this.column(next)))) {
                        z7.this.t(next);
                        z10 = true;
                    }
                }
                return z10;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return z7.this.columnKeySet().size();
            }
        }

        /* compiled from: StandardTable.java */
        /* loaded from: classes.dex */
        private class b extends w5.m<C, Map<R, V>> {
            b() {
                super(f.this);
            }

            @Override // com.google.common.collect.w5.m, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        z7.this.t(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.w5.m, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                p.o(collection);
                Iterator it = s5.i(z7.this.columnKeySet().iterator()).iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (collection.contains(z7.this.column(next))) {
                        z7.this.t(next);
                        z10 = true;
                    }
                }
                return z10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.w5.m, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                p.o(collection);
                Iterator it = s5.i(z7.this.columnKeySet().iterator()).iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(z7.this.column(next))) {
                        z7.this.t(next);
                        z10 = true;
                    }
                }
                return z10;
            }
        }

        private f() {
        }

        @Override // com.google.common.collect.w5.n
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return z7.this.containsColumn(obj);
        }

        @Override // com.google.common.collect.w5.n
        Collection<Map<R, V>> d() {
            return new b();
        }

        /* renamed from: e */
        public Map<R, V> get(Object obj) {
            if (z7.this.containsColumn(obj)) {
                return z7.this.column(obj);
            }
            return null;
        }

        /* renamed from: f */
        public Map<R, V> remove(Object obj) {
            if (z7.this.containsColumn(obj)) {
                return z7.this.t(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.w5.n, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return z7.this.columnKeySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes.dex */
    public class g extends w5.i<C, V> {

        /* renamed from: a  reason: collision with root package name */
        final R f12298a;

        /* renamed from: b  reason: collision with root package name */
        Map<C, V> f12299b;

        /* compiled from: StandardTable.java */
        /* loaded from: classes.dex */
        class a implements Iterator<Map.Entry<C, V>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Iterator f12301a;

            a(Iterator it) {
                this.f12301a = it;
            }

            /* renamed from: a */
            public Map.Entry<C, V> next() {
                return g.this.j((Map.Entry) this.f12301a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f12301a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f12301a.remove();
                g.this.i();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StandardTable.java */
        /* loaded from: classes.dex */
        public class b extends p3<C, V> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map.Entry f12303a;

            b(g gVar, Map.Entry entry) {
                this.f12303a = entry;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.p3
            /* renamed from: b */
            public Map.Entry<C, V> a() {
                return this.f12303a;
            }

            @Override // com.google.common.collect.p3, java.util.Map.Entry
            public boolean equals(Object obj) {
                return d(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.p3, java.util.Map.Entry
            public V setValue(V v10) {
                return (V) super.setValue(p.o(v10));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(R r10) {
            this.f12298a = (R) p.o(r10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w5.i
        public Iterator<Map.Entry<C, V>> a() {
            Map<C, V> g10 = g();
            if (g10 == null) {
                return j5.j();
            }
            return new a(g10.entrySet().iterator());
        }

        @Override // com.google.common.collect.w5.i
        Spliterator<Map.Entry<C, V>> b() {
            Map<C, V> g10 = g();
            if (g10 == null) {
                return Spliterators.emptySpliterator();
            }
            return s2.e(g10.entrySet().spliterator(), new Function() { // from class: com.google.common.collect.a8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return z7.g.this.j((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> g10 = g();
            if (g10 != null) {
                g10.clear();
            }
            i();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> g10 = g();
            return (obj == null || g10 == null || !w5.o(g10, obj)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<C, V> g() {
            Map<C, V> map = this.f12299b;
            if (map != null && (!map.isEmpty() || !z7.this.backingMap.containsKey(this.f12298a))) {
                return this.f12299b;
            }
            Map<C, V> h10 = h();
            this.f12299b = h10;
            return h10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> g10 = g();
            if (obj == null || g10 == null) {
                return null;
            }
            return (V) w5.p(g10, obj);
        }

        Map<C, V> h() {
            return z7.this.backingMap.get(this.f12298a);
        }

        void i() {
            if (g() != null && this.f12299b.isEmpty()) {
                z7.this.backingMap.remove(this.f12298a);
                this.f12299b = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map.Entry<C, V> j(Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c10, V v10) {
            p.o(c10);
            p.o(v10);
            Map<C, V> map = this.f12299b;
            if (map == null || map.isEmpty()) {
                return (V) z7.this.put(this.f12298a, c10, v10);
            }
            return this.f12299b.put(c10, v10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> g10 = g();
            if (g10 == null) {
                return null;
            }
            V v10 = (V) w5.q(g10, obj);
            i();
            return v10;
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> g10 = g();
            if (g10 == null) {
                return 0;
            }
            return g10.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StandardTable.java */
    /* loaded from: classes.dex */
    public class h extends w5.n<R, Map<C, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StandardTable.java */
        /* loaded from: classes.dex */
        public class a extends z7<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* compiled from: StandardTable.java */
            /* renamed from: com.google.common.collect.z7$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0154a implements com.google.common.base.h<R, Map<C, V>> {
                C0154a() {
                }

                /* renamed from: a */
                public Map<C, V> apply(R r10) {
                    return z7.this.row(r10);
                }
            }

            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && y2.c(z7.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return w5.a(z7.this.backingMap.keySet(), new C0154a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && z7.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return z7.this.backingMap.size();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public h() {
        }

        @Override // com.google.common.collect.w5.n
        protected Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return z7.this.containsRow(obj);
        }

        /* renamed from: e */
        public Map<C, V> get(Object obj) {
            if (z7.this.containsRow(obj)) {
                return z7.this.row(obj);
            }
            return null;
        }

        /* renamed from: f */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return z7.this.backingMap.remove(obj);
        }
    }

    /* compiled from: StandardTable.java */
    /* loaded from: classes.dex */
    private abstract class i<T> extends l7.a<T> {
        private i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            z7.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return z7.this.backingMap.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z7(Map<R, Map<C, V>> map, v<? extends Map<C, V>> vVar) {
        this.backingMap = map;
        this.factory = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> q(R r10) {
        Map<C, V> map = this.backingMap.get(r10);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.factory.get();
        this.backingMap.put(r10, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c8.a r(Map.Entry entry, Map.Entry entry2) {
        return m8.b(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator s(final Map.Entry entry) {
        return s2.e(((Map) entry.getValue()).entrySet().spliterator(), new Function() { // from class: com.google.common.collect.x7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                c8.a r10;
                r10 = z7.r(entry, (Map.Entry) obj);
                return r10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<R, V> t(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(Object obj, Object obj2, Object obj3) {
        if (!n(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.y
    Iterator<c8.a<R, C, V>> a() {
        return new b();
    }

    @Override // com.google.common.collect.y
    Spliterator<c8.a<R, C, V>> b() {
        return s2.b(this.backingMap.entrySet().spliterator(), y7.f12271a, 65, size());
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public Set<c8.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.y
    public void clear() {
        this.backingMap.clear();
    }

    public Map<R, V> column(C c10) {
        return new c(c10);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.c8
    public Map<C, Map<R, V>> columnMap() {
        z7<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        z7<R, C, V>.f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.y
    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.y
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> map : this.backingMap.values()) {
            if (w5.o(map, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.y
    public boolean containsRow(Object obj) {
        return obj != null && w5.o(this.backingMap, obj);
    }

    @Override // com.google.common.collect.y
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public V get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.y
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    Iterator<C> o() {
        return new d();
    }

    Map<R, Map<C, V>> p() {
        return new h();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public V put(R r10, C c10, V v10) {
        p.o(r10);
        p.o(c10);
        p.o(v10);
        return q(r10).put(c10, v10);
    }

    @Override // com.google.common.collect.y
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) w5.p(this.backingMap, obj)) == null) {
            return null;
        }
        V v10 = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v10;
    }

    @Override // com.google.common.collect.c8
    public Map<C, V> row(R r10) {
        return new g(r10);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.c8
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> p10 = p();
        this.rowMap = p10;
        return p10;
    }

    @Override // com.google.common.collect.c8
    public int size() {
        int i10 = 0;
        for (Map<C, V> map : this.backingMap.values()) {
            i10 += map.size();
        }
        return i10;
    }

    @Override // com.google.common.collect.y
    public Collection<V> values() {
        return super.values();
    }
}
