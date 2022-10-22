package com.google.common.collect;

import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.c8;
import com.google.common.collect.m8;
import com.google.common.collect.w5;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.IntFunction;
/* loaded from: classes.dex */
public final class ArrayTable<R, C, V> extends y<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ArrayTable<R, C, V>.f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient ArrayTable<R, C, V>.h rowMap;

    /* loaded from: classes.dex */
    class a extends com.google.common.collect.b<c8.a<R, C, V>> {
        a(int i10) {
            super(i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public c8.a<R, C, V> a(int i10) {
            return ArrayTable.this.q(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends m8.b<R, C, V> {

        /* renamed from: a  reason: collision with root package name */
        final int f11718a;

        /* renamed from: b  reason: collision with root package name */
        final int f11719b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f11720c;

        b(int i10) {
            this.f11720c = i10;
            this.f11718a = i10 / ArrayTable.this.columnList.size();
            this.f11719b = i10 % ArrayTable.this.columnList.size();
        }

        @Override // com.google.common.collect.c8.a
        public C a() {
            return (C) ArrayTable.this.columnList.get(this.f11719b);
        }

        @Override // com.google.common.collect.c8.a
        public R b() {
            return (R) ArrayTable.this.rowList.get(this.f11718a);
        }

        @Override // com.google.common.collect.c8.a
        public V getValue() {
            return (V) ArrayTable.this.at(this.f11718a, this.f11719b);
        }
    }

    /* loaded from: classes.dex */
    class c extends com.google.common.collect.b<V> {
        c(int i10) {
            super(i10);
        }

        @Override // com.google.common.collect.b
        protected V a(int i10) {
            return (V) ArrayTable.this.r(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class d<K, V> extends w5.i<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableMap<K, Integer> f11723a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends n<K, V> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f11724a;

            a(int i10) {
                this.f11724a = i10;
            }

            @Override // com.google.common.collect.n, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.h(this.f11724a);
            }

            @Override // com.google.common.collect.n, java.util.Map.Entry
            public V getValue() {
                return (V) d.this.j(this.f11724a);
            }

            @Override // com.google.common.collect.n, java.util.Map.Entry
            public V setValue(V v10) {
                return (V) d.this.k(this.f11724a, v10);
            }
        }

        /* loaded from: classes.dex */
        class b extends com.google.common.collect.b<Map.Entry<K, V>> {
            b(int i10) {
                super(i10);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: b */
            public Map.Entry<K, V> a(int i10) {
                return d.this.g(i10);
            }
        }

        /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w5.i
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        @Override // com.google.common.collect.w5.i
        Spliterator<Map.Entry<K, V>> b() {
            return s2.c(size(), 16, new IntFunction() { // from class: com.google.common.collect.c0
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    return ArrayTable.d.this.g(i10);
                }
            });
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f11723a.containsKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map.Entry<K, V> g(int i10) {
            p.m(i10, size());
            return new a(i10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer num = this.f11723a.get(obj);
            if (num == null) {
                return null;
            }
            return j(num.intValue());
        }

        K h(int i10) {
            return this.f11723a.keySet().asList().get(i10);
        }

        abstract String i();

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f11723a.isEmpty();
        }

        abstract V j(int i10);

        abstract V k(int i10, V v10);

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f11723a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k10, V v10) {
            Integer num = this.f11723a.get(k10);
            if (num != null) {
                return k(num.intValue(), v10);
            }
            String i10 = i();
            String valueOf = String.valueOf(k10);
            String valueOf2 = String.valueOf(this.f11723a.keySet());
            StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 9 + valueOf.length() + valueOf2.length());
            sb2.append(i10);
            sb2.append(" ");
            sb2.append(valueOf);
            sb2.append(" not in ");
            sb2.append(valueOf2);
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f11723a.size();
        }

        private d(ImmutableMap<K, Integer> immutableMap) {
            this.f11723a = immutableMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends d<R, V> {

        /* renamed from: b  reason: collision with root package name */
        final int f11727b;

        e(int i10) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f11727b = i10;
        }

        @Override // com.google.common.collect.ArrayTable.d
        String i() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        V j(int i10) {
            return (V) ArrayTable.this.at(i10, this.f11727b);
        }

        @Override // com.google.common.collect.ArrayTable.d
        V k(int i10, V v10) {
            return (V) ArrayTable.this.set(i10, this.f11727b, v10);
        }
    }

    /* loaded from: classes.dex */
    private class f extends d<C, Map<R, V>> {
        /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        String i() {
            return "Column";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: l */
        public Map<R, V> j(int i10) {
            return new e(i10);
        }

        /* renamed from: m */
        public Map<R, V> put(C c10, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: n */
        public Map<R, V> k(int i10, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        private f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends d<C, V> {

        /* renamed from: b  reason: collision with root package name */
        final int f11730b;

        g(int i10) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f11730b = i10;
        }

        @Override // com.google.common.collect.ArrayTable.d
        String i() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        V j(int i10) {
            return (V) ArrayTable.this.at(this.f11730b, i10);
        }

        @Override // com.google.common.collect.ArrayTable.d
        V k(int i10, V v10) {
            return (V) ArrayTable.this.set(this.f11730b, i10, v10);
        }
    }

    /* loaded from: classes.dex */
    private class h extends d<R, Map<C, V>> {
        /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        String i() {
            return "Row";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: l */
        public Map<C, V> j(int i10) {
            return new g(i10);
        }

        /* renamed from: m */
        public Map<C, V> put(R r10, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: n */
        public Map<C, V> k(int i10, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        private h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        p.d(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = w5.f(copyOf);
        this.columnKeyToIndex = w5.f(copyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, copyOf.size(), copyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c8.a<R, C, V> q(int i10) {
        return new b(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V r(int i10) {
        return at(i10 / this.columnList.size(), i10 % this.columnList.size());
    }

    @Override // com.google.common.collect.y
    Iterator<c8.a<R, C, V>> a() {
        return new a(size());
    }

    public V at(int i10, int i11) {
        p.m(i10, this.rowList.size());
        p.m(i11, this.columnList.size());
        return this.array[i10][i11];
    }

    @Override // com.google.common.collect.y
    Spliterator<c8.a<R, C, V>> b() {
        return s2.c(size(), 273, new IntFunction() { // from class: com.google.common.collect.b0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                c8.a q5;
                q5 = ArrayTable.this.q(i10);
                return q5;
            }
        });
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public Set<c8.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.y
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Map<R, V> column(C c10) {
        p.o(c10);
        Integer num = this.columnKeyToIndex.get(c10);
        return num == null ? ImmutableMap.of() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.c8
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f(this, null);
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.y
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.y
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.y
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.y
    public boolean containsValue(Object obj) {
        V[][] vArr;
        for (V[] vArr2 : this.array) {
            for (V v10 : vArr2) {
                if (m.a(obj, v10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public V erase(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.y
    Iterator<V> g() {
        return new c(size());
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.y
    Spliterator<V> h() {
        return s2.c(size(), 16, new IntFunction() { // from class: com.google.common.collect.a0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Object r10;
                r10 = ArrayTable.this.r(i10);
                return r10;
            }
        });
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.y
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public V put(R r10, C c10, V v10) {
        p.o(r10);
        p.o(c10);
        Integer num = this.rowKeyToIndex.get(r10);
        boolean z10 = true;
        p.k(num != null, "Row %s not in %s", r10, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c10);
        if (num2 == null) {
            z10 = false;
        }
        p.k(z10, "Column %s not in %s", c10, this.columnList);
        return set(num.intValue(), num2.intValue(), v10);
    }

    @Override // com.google.common.collect.y
    public void putAll(c8<? extends R, ? extends C, ? extends V> c8Var) {
        super.putAll(c8Var);
    }

    @Override // com.google.common.collect.y
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c8
    public Map<C, V> row(R r10) {
        p.o(r10);
        Integer num = this.rowKeyToIndex.get(r10);
        return num == null ? ImmutableMap.of() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.c8
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar != null) {
            return hVar;
        }
        ArrayTable<R, C, V>.h hVar2 = new h(this, null);
        this.rowMap = hVar2;
        return hVar2;
    }

    public V set(int i10, int i11, V v10) {
        p.m(i10, this.rowList.size());
        p.m(i11, this.columnList.size());
        V[][] vArr = this.array;
        V v11 = vArr[i10][i11];
        vArr[i10][i11] = v10;
        return v11;
    }

    @Override // com.google.common.collect.c8
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i10], 0, vArr[i10], 0, vArr2[i10].length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.y
    public Collection<V> values() {
        return super.values();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(c8<R, C, V> c8Var) {
        if (c8Var instanceof ArrayTable) {
            return new ArrayTable<>((ArrayTable) c8Var);
        }
        return new ArrayTable<>(c8Var);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(c8<R, C, V> c8Var) {
        this(c8Var.rowKeySet(), c8Var.columnKeySet());
        putAll(c8Var);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i10], 0, vArr[i10], 0, vArr2[i10].length);
        }
    }
}
