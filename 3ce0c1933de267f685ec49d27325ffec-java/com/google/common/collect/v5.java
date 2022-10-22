package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.v5.h;
import com.google.common.collect.v5.m;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapMakerInternalMap.java */
/* loaded from: classes.dex */
public class v5<K, V, E extends h<K, V, E>, S extends m<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final z<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient i<K, V, E, S> entryHelper;
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient m<K, V, E, S>[] segments;
    transient Collection<V> values;

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    class a implements z<Object, Object, d> {
        a() {
        }

        /* renamed from: c */
        public z<Object, Object, d> b(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }

        @Override // com.google.common.collect.v5.z
        public void clear() {
        }

        /* renamed from: d */
        public d a() {
            return null;
        }

        @Override // com.google.common.collect.v5.z
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class a0<K, V, E extends h<K, V, E>> extends WeakReference<V> implements z<K, V, E> {

        /* renamed from: a  reason: collision with root package name */
        final E f12205a;

        a0(ReferenceQueue<V> referenceQueue, V v10, E e10) {
            super(v10, referenceQueue);
            this.f12205a = e10;
        }

        @Override // com.google.common.collect.v5.z
        public E a() {
            return this.f12205a;
        }

        @Override // com.google.common.collect.v5.z
        public z<K, V, E> b(ReferenceQueue<V> referenceQueue, E e10) {
            return new a0(referenceQueue, get(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {

        /* renamed from: a  reason: collision with root package name */
        final K f12206a;

        /* renamed from: b  reason: collision with root package name */
        final int f12207b;

        /* renamed from: c  reason: collision with root package name */
        final E f12208c;

        b(K k10, int i10, E e10) {
            this.f12206a = k10;
            this.f12207b = i10;
            this.f12208c = e10;
        }

        @Override // com.google.common.collect.v5.h
        public E a() {
            return this.f12208c;
        }

        @Override // com.google.common.collect.v5.h
        public int c() {
            return this.f12207b;
        }

        @Override // com.google.common.collect.v5.h
        public K getKey() {
            return this.f12206a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public final class b0 extends com.google.common.collect.n<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f12209a;

        /* renamed from: b  reason: collision with root package name */
        V f12210b;

        b0(K k10, V v10) {
            this.f12209a = k10;
            this.f12210b = v10;
        }

        @Override // com.google.common.collect.n, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f12209a.equals(entry.getKey()) && this.f12210b.equals(entry.getValue());
        }

        @Override // com.google.common.collect.n, java.util.Map.Entry
        public K getKey() {
            return this.f12209a;
        }

        @Override // com.google.common.collect.n, java.util.Map.Entry
        public V getValue() {
            return this.f12210b;
        }

        @Override // com.google.common.collect.n, java.util.Map.Entry
        public int hashCode() {
            return this.f12209a.hashCode() ^ this.f12210b.hashCode();
        }

        @Override // com.google.common.collect.n, java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = (V) v5.this.put(this.f12209a, v10);
            this.f12210b = v10;
            return v11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {

        /* renamed from: a  reason: collision with root package name */
        final int f12212a;

        /* renamed from: b  reason: collision with root package name */
        final E f12213b;

        c(ReferenceQueue<K> referenceQueue, K k10, int i10, E e10) {
            super(k10, referenceQueue);
            this.f12212a = i10;
            this.f12213b = e10;
        }

        @Override // com.google.common.collect.v5.h
        public E a() {
            return this.f12213b;
        }

        @Override // com.google.common.collect.v5.h
        public int c() {
            return this.f12212a;
        }

        @Override // com.google.common.collect.v5.h
        public K getKey() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class d implements h<Object, Object, d> {
        private d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.v5.h
        public int c() {
            throw new AssertionError();
        }

        /* renamed from: d */
        public d a() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.v5.h
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.v5.h
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    final class e extends v5<K, V, E, S>.g<Map.Entry<K, V>> {
        e(v5 v5Var) {
            super();
        }

        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    final class f extends l<Map.Entry<K, V>> {
        f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v5.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = v5.this.get(key)) != null && v5.this.p().d(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return v5.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(v5.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && v5.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v5.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public abstract class g<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        int f12215a;

        /* renamed from: b  reason: collision with root package name */
        int f12216b = -1;

        /* renamed from: c  reason: collision with root package name */
        m<K, V, E, S> f12217c;

        /* renamed from: d  reason: collision with root package name */
        AtomicReferenceArray<E> f12218d;

        /* renamed from: e  reason: collision with root package name */
        E f12219e;

        /* renamed from: f  reason: collision with root package name */
        v5<K, V, E, S>.b0 f12220f;

        /* renamed from: g  reason: collision with root package name */
        v5<K, V, E, S>.b0 f12221g;

        g() {
            this.f12215a = v5.this.segments.length - 1;
            a();
        }

        final void a() {
            this.f12220f = null;
            if (!d() && !e()) {
                while (true) {
                    int i10 = this.f12215a;
                    if (i10 >= 0) {
                        m<K, V, E, S>[] mVarArr = v5.this.segments;
                        this.f12215a = i10 - 1;
                        m<K, V, E, S> mVar = mVarArr[i10];
                        this.f12217c = mVar;
                        if (mVar.count != 0) {
                            AtomicReferenceArray<E> atomicReferenceArray = this.f12217c.table;
                            this.f12218d = atomicReferenceArray;
                            this.f12216b = atomicReferenceArray.length() - 1;
                            if (e()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean b(E e10) {
            boolean z10;
            try {
                Object key = e10.getKey();
                Object g10 = v5.this.g(e10);
                if (g10 != null) {
                    this.f12220f = new b0(key, g10);
                    z10 = true;
                } else {
                    z10 = false;
                }
                return z10;
            } finally {
                this.f12217c.t();
            }
        }

        v5<K, V, E, S>.b0 c() {
            v5<K, V, E, S>.b0 b0Var = this.f12220f;
            if (b0Var != null) {
                this.f12221g = b0Var;
                a();
                return this.f12221g;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            E e10 = this.f12219e;
            if (e10 == null) {
                return false;
            }
            while (true) {
                this.f12219e = (E) e10.a();
                E e11 = this.f12219e;
                if (e11 == null) {
                    return false;
                }
                if (b(e11)) {
                    return true;
                }
                e10 = this.f12219e;
            }
        }

        boolean e() {
            while (true) {
                int i10 = this.f12216b;
                if (i10 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f12218d;
                this.f12216b = i10 - 1;
                E e10 = atomicReferenceArray.get(i10);
                this.f12219e = e10;
                if (e10 != null && (b(e10) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12220f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f12221g != null);
            v5.this.remove(this.f12221g.getKey());
            this.f12221g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public interface h<K, V, E extends h<K, V, E>> {
        E a();

        int c();

        K getKey();

        V getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public interface i<K, V, E extends h<K, V, E>, S extends m<K, V, E, S>> {
        E a(S s10, E e10, E e11);

        n b();

        void c(S s10, E e10, V v10);

        S d(v5<K, V, E, S> v5Var, int i10, int i11);

        E e(S s10, K k10, int i10, E e10);
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    final class j extends v5<K, V, E, S>.g<K> {
        j(v5 v5Var) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    final class k extends l<K> {
        k() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v5.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return v5.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return v5.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j(v5.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return v5.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v5.this.size();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    private static abstract class l<E> extends AbstractSet<E> {
        private l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return v5.n(this).toArray();
        }

        /* synthetic */ l(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) v5.n(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static abstract class m<K, V, E extends h<K, V, E>, S extends m<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        final v5<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        volatile AtomicReferenceArray<E> table;
        int threshold;

        m(v5<K, V, E, S> v5Var, int i10, int i11) {
            this.map = v5Var;
            this.maxSegmentSize = i11;
            o(s(i10));
        }

        static <K, V, E extends h<K, V, E>> boolean p(E e10) {
            return e10.getValue() == null;
        }

        E A(E e10, E e11) {
            int i10 = this.count;
            E e12 = (E) e11.a();
            while (e10 != e11) {
                E d10 = d(e10, e12);
                if (d10 != null) {
                    e12 = d10;
                } else {
                    i10--;
                }
                e10 = (E) e10.a();
            }
            this.count = i10;
            return e12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        V B(K k10, int i10, V v10) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (h hVar = e10; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i10 && key != null && this.map.keyEquivalence.d(k10, key)) {
                        V v11 = (V) hVar.getValue();
                        if (v11 == null) {
                            if (p(hVar)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, A(e10, hVar));
                                this.count--;
                            }
                            return null;
                        }
                        this.modCount++;
                        G(hVar, v10);
                        return v11;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean C(K k10, int i10, V v10, V v11) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (h hVar = e10; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i10 && key != null && this.map.keyEquivalence.d(k10, key)) {
                        Object value = hVar.getValue();
                        if (value == null) {
                            if (p(hVar)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, A(e10, hVar));
                                this.count--;
                            }
                            return false;
                        } else if (!this.map.p().d(v10, value)) {
                            return false;
                        } else {
                            this.modCount++;
                            G(hVar, v11);
                            return true;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void D() {
            E();
        }

        void E() {
            if (tryLock()) {
                try {
                    r();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract S F();

        void G(E e10, V v10) {
            this.map.entryHelper.c(F(), e10, v10);
        }

        void H() {
            if (tryLock()) {
                try {
                    r();
                } finally {
                    unlock();
                }
            }
        }

        void a() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i10 = 0; i10 < atomicReferenceArray.length(); i10++) {
                        atomicReferenceArray.set(i10, null);
                    }
                    q();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        <T> void b(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        boolean c(Object obj, int i10) {
            try {
                boolean z10 = false;
                if (this.count == 0) {
                    return false;
                }
                E m10 = m(obj, i10);
                if (m10 != null) {
                    if (m10.getValue() != null) {
                        z10 = true;
                    }
                }
                return z10;
            } finally {
                t();
            }
        }

        E d(E e10, E e11) {
            return this.map.entryHelper.a(F(), e10, e11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g(ReferenceQueue<K> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.j((h) poll);
                    i10++;
                } else {
                    return;
                }
            } while (i10 != 16);
        }

        void h(ReferenceQueue<V> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.k((z) poll);
                    i10++;
                } else {
                    return;
                }
            } while (i10 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void i() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < v5.MAXIMUM_CAPACITY) {
                int i10 = this.count;
                AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) s(length << 1);
                this.threshold = (atomicReferenceArray2.length() * 3) / 4;
                int length2 = atomicReferenceArray2.length() - 1;
                for (int i11 = 0; i11 < length; i11++) {
                    E e10 = atomicReferenceArray.get(i11);
                    if (e10 != null) {
                        h a10 = e10.a();
                        int c10 = e10.c() & length2;
                        if (a10 == null) {
                            atomicReferenceArray2.set(c10, e10);
                        } else {
                            h hVar = e10;
                            while (a10 != null) {
                                int c11 = a10.c() & length2;
                                if (c11 != c10) {
                                    hVar = a10;
                                    c10 = c11;
                                }
                                a10 = a10.a();
                            }
                            atomicReferenceArray2.set(c10, hVar);
                            while (e10 != hVar) {
                                int c12 = e10.c() & length2;
                                h d10 = d(e10, (h) atomicReferenceArray2.get(c12));
                                if (d10 != null) {
                                    atomicReferenceArray2.set(c12, d10);
                                } else {
                                    i10--;
                                }
                                e10 = e10.a();
                            }
                        }
                    }
                }
                this.table = atomicReferenceArray2;
                this.count = i10;
            }
        }

        V j(Object obj, int i10) {
            try {
                E m10 = m(obj, i10);
                if (m10 == null) {
                    return null;
                }
                V v10 = (V) m10.getValue();
                if (v10 == null) {
                    H();
                }
                return v10;
            } finally {
                t();
            }
        }

        E k(Object obj, int i10) {
            if (this.count == 0) {
                return null;
            }
            for (E l10 = l(i10); l10 != null; l10 = (E) l10.a()) {
                if (l10.c() == i10) {
                    Object key = l10.getKey();
                    if (key == null) {
                        H();
                    } else if (this.map.keyEquivalence.d(obj, key)) {
                        return l10;
                    }
                }
            }
            return null;
        }

        E l(int i10) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i10 & (atomicReferenceArray.length() - 1));
        }

        E m(Object obj, int i10) {
            return k(obj, i10);
        }

        V n(E e10) {
            if (e10.getKey() == null) {
                H();
                return null;
            }
            V v10 = (V) e10.getValue();
            if (v10 != null) {
                return v10;
            }
            H();
            return null;
        }

        void o(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        void q() {
        }

        void r() {
        }

        AtomicReferenceArray<E> s(int i10) {
            return new AtomicReferenceArray<>(i10);
        }

        void t() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                D();
            }
        }

        void u() {
            E();
        }

        /* JADX WARN: Multi-variable type inference failed */
        V v(K k10, int i10, V v10, boolean z10) {
            lock();
            try {
                u();
                int i11 = this.count + 1;
                if (i11 > this.threshold) {
                    i();
                    i11 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (h hVar = e10; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i10 && key != null && this.map.keyEquivalence.d(k10, key)) {
                        V v11 = (V) hVar.getValue();
                        if (v11 == null) {
                            this.modCount++;
                            G(hVar, v10);
                            this.count = this.count;
                            return null;
                        } else if (z10) {
                            return v11;
                        } else {
                            this.modCount++;
                            G(hVar, v10);
                            return v11;
                        }
                    }
                }
                this.modCount++;
                E e11 = this.map.entryHelper.e(F(), k10, i10, e10);
                G(e11, v10);
                atomicReferenceArray.set(length, e11);
                this.count = i11;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean w(E e10, int i10) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                E e11 = atomicReferenceArray.get(length);
                for (h hVar = e11; hVar != null; hVar = hVar.a()) {
                    if (hVar == e10) {
                        this.modCount++;
                        atomicReferenceArray.set(length, A(e11, hVar));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean x(K k10, int i10, z<K, V, E> zVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (h hVar = e10; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i10 && key != null && this.map.keyEquivalence.d(k10, key)) {
                        if (((y) hVar).b() != zVar) {
                            return false;
                        } else {
                            this.modCount++;
                            atomicReferenceArray.set(length, A(e10, hVar));
                            this.count--;
                            return true;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        V y(Object obj, int i10) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                for (h hVar = e10; hVar != null; hVar = hVar.a()) {
                    Object key = hVar.getKey();
                    if (hVar.c() == i10 && key != null && this.map.keyEquivalence.d(obj, key)) {
                        V v10 = (V) hVar.getValue();
                        if (v10 == null && !p(hVar)) {
                            return null;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, A(e10, hVar));
                        this.count--;
                        return v10;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
            if (r8.map.p().d(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
            if (p(r4) == false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
            r8.modCount++;
            r0.set(r1, A(r3, r4));
            r8.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean z(Object obj, int i10, Object obj2) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                E e10 = atomicReferenceArray.get(length);
                h hVar = e10;
                while (true) {
                    boolean z10 = false;
                    if (hVar != null) {
                        Object key = hVar.getKey();
                        if (hVar.c() == i10 && key != null && this.map.keyEquivalence.d(obj, key)) {
                            break;
                        }
                        hVar = hVar.a();
                    } else {
                        return false;
                    }
                }
            } finally {
                unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static abstract class n extends Enum<n> {
        public static final n STRONG = new a("STRONG", 0);
        public static final n WEAK = new b("WEAK", 1);
        private static final /* synthetic */ n[] $VALUES = a();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes.dex */
        final class a extends n {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.collect.v5.n
            Equivalence<Object> b() {
                return Equivalence.c();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes.dex */
        final class b extends n {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.collect.v5.n
            Equivalence<Object> b() {
                return Equivalence.h();
            }
        }

        private n(String str, int i10) {
        }

        private static /* synthetic */ n[] a() {
            return new n[]{STRONG, WEAK};
        }

        public static n valueOf(String str) {
            return (n) Enum.valueOf(n.class, str);
        }

        public static n[] values() {
            return (n[]) $VALUES.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> b();

        /* synthetic */ n(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class o<K, V> extends b<K, V, o<K, V>> {

        /* renamed from: d  reason: collision with root package name */
        private volatile V f12224d = null;

        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes.dex */
        static final class a<K, V> implements i<K, V, o<K, V>, p<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final a<?, ?> f12225a = new a<>();

            a() {
            }

            static <K, V> a<K, V> g() {
                return (a<K, V>) f12225a;
            }

            @Override // com.google.common.collect.v5.i
            public n b() {
                return n.STRONG;
            }

            /* renamed from: f */
            public o<K, V> a(p<K, V> pVar, o<K, V> oVar, o<K, V> oVar2) {
                return oVar.d(oVar2);
            }

            /* renamed from: h */
            public o<K, V> e(p<K, V> pVar, K k10, int i10, o<K, V> oVar) {
                return new o<>(k10, i10, oVar);
            }

            /* renamed from: i */
            public p<K, V> d(v5<K, V, o<K, V>, p<K, V>> v5Var, int i10, int i11) {
                return new p<>(v5Var, i10, i11);
            }

            /* renamed from: j */
            public void c(p<K, V> pVar, o<K, V> oVar, V v10) {
                oVar.e(v10);
            }
        }

        o(K k10, int i10, o<K, V> oVar) {
            super(k10, i10, oVar);
        }

        o<K, V> d(o<K, V> oVar) {
            o<K, V> oVar2 = new o<>(this.f12206a, this.f12207b, oVar);
            oVar2.f12224d = this.f12224d;
            return oVar2;
        }

        void e(V v10) {
            this.f12224d = v10;
        }

        @Override // com.google.common.collect.v5.h
        public V getValue() {
            return this.f12224d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class p<K, V> extends m<K, V, o<K, V>, p<K, V>> {
        p(v5<K, V, o<K, V>, p<K, V>> v5Var, int i10, int i11) {
            super(v5Var, i10, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: I */
        public p<K, V> F() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class q<K, V> extends b<K, V, q<K, V>> implements y<K, V, q<K, V>> {

        /* renamed from: d  reason: collision with root package name */
        private volatile z<K, V, q<K, V>> f12226d = v5.o();

        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes.dex */
        static final class a<K, V> implements i<K, V, q<K, V>, r<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final a<?, ?> f12227a = new a<>();

            a() {
            }

            static <K, V> a<K, V> g() {
                return (a<K, V>) f12227a;
            }

            @Override // com.google.common.collect.v5.i
            public n b() {
                return n.WEAK;
            }

            /* renamed from: f */
            public q<K, V> a(r<K, V> rVar, q<K, V> qVar, q<K, V> qVar2) {
                if (m.p(qVar)) {
                    return null;
                }
                return qVar.d(((r) rVar).queueForValues, qVar2);
            }

            /* renamed from: h */
            public q<K, V> e(r<K, V> rVar, K k10, int i10, q<K, V> qVar) {
                return new q<>(k10, i10, qVar);
            }

            /* renamed from: i */
            public r<K, V> d(v5<K, V, q<K, V>, r<K, V>> v5Var, int i10, int i11) {
                return new r<>(v5Var, i10, i11);
            }

            /* renamed from: j */
            public void c(r<K, V> rVar, q<K, V> qVar, V v10) {
                qVar.e(v10, ((r) rVar).queueForValues);
            }
        }

        q(K k10, int i10, q<K, V> qVar) {
            super(k10, i10, qVar);
        }

        @Override // com.google.common.collect.v5.y
        public z<K, V, q<K, V>> b() {
            return this.f12226d;
        }

        q<K, V> d(ReferenceQueue<V> referenceQueue, q<K, V> qVar) {
            q<K, V> qVar2 = new q<>(this.f12206a, this.f12207b, qVar);
            qVar2.f12226d = this.f12226d.b(referenceQueue, qVar2);
            return qVar2;
        }

        void e(V v10, ReferenceQueue<V> referenceQueue) {
            z<K, V, q<K, V>> zVar = this.f12226d;
            this.f12226d = new a0(referenceQueue, v10, this);
            zVar.clear();
        }

        @Override // com.google.common.collect.v5.h
        public V getValue() {
            return this.f12226d.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class r<K, V> extends m<K, V, q<K, V>, r<K, V>> {
        private final ReferenceQueue<V> queueForValues = new ReferenceQueue<>();

        r(v5<K, V, q<K, V>, r<K, V>> v5Var, int i10, int i11) {
            super(v5Var, i10, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: J */
        public r<K, V> F() {
            return this;
        }

        @Override // com.google.common.collect.v5.m
        void q() {
            b((ReferenceQueue<V>) this.queueForValues);
        }

        @Override // com.google.common.collect.v5.m
        void r() {
            h(this.queueForValues);
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    final class s extends v5<K, V, E, S>.g<V> {
        s(v5 v5Var) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    final class t extends AbstractCollection<V> {
        t() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            v5.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return v5.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return v5.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new s(v5.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return v5.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return v5.n(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) v5.n(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class u<K, V> extends c<K, V, u<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        private volatile V f12229c = null;

        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes.dex */
        static final class a<K, V> implements i<K, V, u<K, V>, v<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final a<?, ?> f12230a = new a<>();

            a() {
            }

            static <K, V> a<K, V> g() {
                return (a<K, V>) f12230a;
            }

            @Override // com.google.common.collect.v5.i
            public n b() {
                return n.STRONG;
            }

            /* renamed from: f */
            public u<K, V> a(v<K, V> vVar, u<K, V> uVar, u<K, V> uVar2) {
                if (uVar.getKey() == null) {
                    return null;
                }
                return uVar.d(((v) vVar).queueForKeys, uVar2);
            }

            /* renamed from: h */
            public u<K, V> e(v<K, V> vVar, K k10, int i10, u<K, V> uVar) {
                return new u<>(((v) vVar).queueForKeys, k10, i10, uVar);
            }

            /* renamed from: i */
            public v<K, V> d(v5<K, V, u<K, V>, v<K, V>> v5Var, int i10, int i11) {
                return new v<>(v5Var, i10, i11);
            }

            /* renamed from: j */
            public void c(v<K, V> vVar, u<K, V> uVar, V v10) {
                uVar.e(v10);
            }
        }

        u(ReferenceQueue<K> referenceQueue, K k10, int i10, u<K, V> uVar) {
            super(referenceQueue, k10, i10, uVar);
        }

        u<K, V> d(ReferenceQueue<K> referenceQueue, u<K, V> uVar) {
            u<K, V> uVar2 = new u<>(referenceQueue, getKey(), this.f12212a, uVar);
            uVar2.e(this.f12229c);
            return uVar2;
        }

        void e(V v10) {
            this.f12229c = v10;
        }

        @Override // com.google.common.collect.v5.h
        public V getValue() {
            return this.f12229c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class v<K, V> extends m<K, V, u<K, V>, v<K, V>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue<>();

        v(v5<K, V, u<K, V>, v<K, V>> v5Var, int i10, int i11) {
            super(v5Var, i10, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: J */
        public v<K, V> F() {
            return this;
        }

        @Override // com.google.common.collect.v5.m
        void q() {
            b((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.v5.m
        void r() {
            g(this.queueForKeys);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class w<K, V> extends c<K, V, w<K, V>> implements y<K, V, w<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        private volatile z<K, V, w<K, V>> f12231c = v5.o();

        /* compiled from: MapMakerInternalMap.java */
        /* loaded from: classes.dex */
        static final class a<K, V> implements i<K, V, w<K, V>, x<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final a<?, ?> f12232a = new a<>();

            a() {
            }

            static <K, V> a<K, V> g() {
                return (a<K, V>) f12232a;
            }

            @Override // com.google.common.collect.v5.i
            public n b() {
                return n.WEAK;
            }

            /* renamed from: f */
            public w<K, V> a(x<K, V> xVar, w<K, V> wVar, w<K, V> wVar2) {
                if (wVar.getKey() != null && !m.p(wVar)) {
                    return wVar.d(((x) xVar).queueForKeys, ((x) xVar).queueForValues, wVar2);
                }
                return null;
            }

            /* renamed from: h */
            public w<K, V> e(x<K, V> xVar, K k10, int i10, w<K, V> wVar) {
                return new w<>(((x) xVar).queueForKeys, k10, i10, wVar);
            }

            /* renamed from: i */
            public x<K, V> d(v5<K, V, w<K, V>, x<K, V>> v5Var, int i10, int i11) {
                return new x<>(v5Var, i10, i11);
            }

            /* renamed from: j */
            public void c(x<K, V> xVar, w<K, V> wVar, V v10) {
                wVar.e(v10, ((x) xVar).queueForValues);
            }
        }

        w(ReferenceQueue<K> referenceQueue, K k10, int i10, w<K, V> wVar) {
            super(referenceQueue, k10, i10, wVar);
        }

        @Override // com.google.common.collect.v5.y
        public z<K, V, w<K, V>> b() {
            return this.f12231c;
        }

        w<K, V> d(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, w<K, V> wVar) {
            w<K, V> wVar2 = new w<>(referenceQueue, getKey(), this.f12212a, wVar);
            wVar2.f12231c = this.f12231c.b(referenceQueue2, wVar2);
            return wVar2;
        }

        void e(V v10, ReferenceQueue<V> referenceQueue) {
            z<K, V, w<K, V>> zVar = this.f12231c;
            this.f12231c = new a0(referenceQueue, v10, this);
            zVar.clear();
        }

        @Override // com.google.common.collect.v5.h
        public V getValue() {
            return this.f12231c.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public static final class x<K, V> extends m<K, V, w<K, V>, x<K, V>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue<>();
        private final ReferenceQueue<V> queueForValues = new ReferenceQueue<>();

        x(v5<K, V, w<K, V>, x<K, V>> v5Var, int i10, int i11) {
            super(v5Var, i10, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: K */
        public x<K, V> F() {
            return this;
        }

        @Override // com.google.common.collect.v5.m
        void q() {
            b((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.v5.m
        void r() {
            g(this.queueForKeys);
            h(this.queueForValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public interface y<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        z<K, V, E> b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapMakerInternalMap.java */
    /* loaded from: classes.dex */
    public interface z<K, V, E extends h<K, V, E>> {
        E a();

        z<K, V, E> b(ReferenceQueue<V> referenceQueue, E e10);

        void clear();

        V get();
    }

    private v5(u5 u5Var, i<K, V, E, S> iVar) {
        this.concurrencyLevel = Math.min(u5Var.a(), 65536);
        this.keyEquivalence = u5Var.c();
        this.entryHelper = iVar;
        int min = Math.min(u5Var.b(), (int) MAXIMUM_CAPACITY);
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        int i13 = 1;
        while (i13 < this.concurrencyLevel) {
            i12++;
            i13 <<= 1;
        }
        this.segmentShift = 32 - i12;
        this.segmentMask = i13 - 1;
        this.segments = i(i13);
        int i14 = min / i13;
        while (i11 < (i13 * i14 < min ? i14 + 1 : i14)) {
            i11 <<= 1;
        }
        while (true) {
            m<K, V, E, S>[] mVarArr = this.segments;
            if (i10 < mVarArr.length) {
                mVarArr[i10] = d(i11, -1);
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> v5<K, V, ? extends h<K, V, ?>, ?> b(u5 u5Var) {
        n d10 = u5Var.d();
        n nVar = n.STRONG;
        if (d10 == nVar && u5Var.e() == nVar) {
            return new v5<>(u5Var, o.a.g());
        }
        if (u5Var.d() == nVar && u5Var.e() == n.WEAK) {
            return new v5<>(u5Var, q.a.g());
        }
        n d11 = u5Var.d();
        n nVar2 = n.WEAK;
        if (d11 == nVar2 && u5Var.e() == nVar) {
            return new v5<>(u5Var, u.a.g());
        }
        if (u5Var.d() == nVar2 && u5Var.e() == nVar2) {
            return new v5<>(u5Var, w.a.g());
        }
        throw new AssertionError();
    }

    static int l(int i10) {
        int i11 = i10 + ((i10 << 15) ^ (-12931));
        int i12 = i11 ^ (i11 >>> 10);
        int i13 = i12 + (i12 << 3);
        int i14 = i13 ^ (i13 >>> 6);
        int i15 = i14 + (i14 << 2) + (i14 << 14);
        return i15 ^ (i15 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> n(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        j5.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends h<K, V, E>> z<K, V, E> o() {
        return (z<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (m<K, V, E, S> mVar : this.segments) {
            mVar.a();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int h10 = h(obj);
        return m(h10).c(obj, h10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.common.collect.v5$m] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.collect.v5$m<K, V, E extends com.google.common.collect.v5$h<K, V, E>, S extends com.google.common.collect.v5$m<K, V, E, S>>[]] */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        m<K, V, E, S>[] mVarArr = this.segments;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            long j11 = 0;
            int length = mVarArr.length;
            for (int i11 = z10; i11 < length; i11++) {
                ?? r11 = mVarArr[i11];
                int i12 = r11.count;
                AtomicReferenceArray<E> atomicReferenceArray = r11.table;
                for (int i13 = z10; i13 < atomicReferenceArray.length(); i13++) {
                    for (E e10 = atomicReferenceArray.get(i13); e10 != null; e10 = e10.a()) {
                        Object n10 = r11.n(e10);
                        if (n10 != null && p().d(obj, n10)) {
                            return true;
                        }
                    }
                }
                j11 += r11.modCount;
                z10 = false;
            }
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
            z10 = false;
        }
        return z10;
    }

    m<K, V, E, S> d(int i10, int i11) {
        return (S) this.entryHelper.d(this, i10, i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.entrySet = fVar;
        return fVar;
    }

    V g(E e10) {
        if (e10.getKey() == null) {
            return null;
        }
        return (V) e10.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int h10 = h(obj);
        return m(h10).j(obj, h10);
    }

    int h(Object obj) {
        return l(this.keyEquivalence.g(obj));
    }

    final m<K, V, E, S>[] i(int i10) {
        return new m[i10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        m<K, V, E, S>[] mVarArr = this.segments;
        long j10 = 0;
        for (int i10 = 0; i10 < mVarArr.length; i10++) {
            if (mVarArr[i10].count != 0) {
                return false;
            }
            j10 += mVarArr[i10].modCount;
        }
        if (j10 == 0) {
            return true;
        }
        for (int i11 = 0; i11 < mVarArr.length; i11++) {
            if (mVarArr[i11].count != 0) {
                return false;
            }
            j10 -= mVarArr[i11].modCount;
        }
        return j10 == 0;
    }

    void j(E e10) {
        int c10 = e10.c();
        m(c10).w(e10, c10);
    }

    void k(z<K, V, E> zVar) {
        E a10 = zVar.a();
        int c10 = a10.c();
        m(c10).x((K) a10.getKey(), c10, zVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.keySet = kVar;
        return kVar;
    }

    m<K, V, E, S> m(int i10) {
        return this.segments[(i10 >>> this.segmentShift) & this.segmentMask];
    }

    Equivalence<Object> p() {
        return this.entryHelper.b().b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        com.google.common.base.p.o(k10);
        com.google.common.base.p.o(v10);
        int h10 = h(k10);
        return m(h10).v(k10, h10, v10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k10, V v10) {
        com.google.common.base.p.o(k10);
        com.google.common.base.p.o(v10);
        int h10 = h(k10);
        return m(h10).v(k10, h10, v10, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int h10 = h(obj);
        return m(h10).y(obj, h10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k10, V v10, V v11) {
        com.google.common.base.p.o(k10);
        com.google.common.base.p.o(v11);
        if (v10 == null) {
            return false;
        }
        int h10 = h(k10);
        return m(h10).C(k10, h10, v10, v11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j10 = 0;
        for (m<K, V, E, S> mVar : this.segments) {
            j10 += mVar.count;
        }
        return com.google.common.primitives.d.h(j10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        t tVar = new t();
        this.values = tVar;
        return tVar;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int h10 = h(obj);
        return m(h10).z(obj, h10, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k10, V v10) {
        com.google.common.base.p.o(k10);
        com.google.common.base.p.o(v10);
        int h10 = h(k10);
        return m(h10).B(k10, h10, v10);
    }
}
